package com.blog.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.CommentRepository;
import com.blog.dao.PostRepository;
import com.blog.dto.CommentDto;
import com.blog.entities.Comment;
import com.blog.entities.Post;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post ","Post Id ", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		
		Comment savedComment = this.commentRepository.save(comment);
		
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commnetId) {
		Comment com = this.commentRepository.findById(commnetId).orElseThrow(()->new ResourceNotFoundException("Comment", "Comment Id", commnetId));
		this.commentRepository.delete(com);
	}
	
	
	
}
