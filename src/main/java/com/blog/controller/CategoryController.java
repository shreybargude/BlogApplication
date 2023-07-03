package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.ApiResponse;
import com.blog.dto.CategoryDto;
import com.blog.service.CategoryService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//POST-create user
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createUserDto = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	//PUT-update category
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable("catId") Integer cId){
		CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, cId);
		return ResponseEntity.ok(updatedCategory);
	}
	
	//DELETE-delete user
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("catId") Integer cId){
		this.categoryService.deleteCategory(cId);
		return new ResponseEntity<>(new ApiResponse("Category Deleted Successfully", true),HttpStatus.OK);
	}
	
	//GET-user get
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	//GET-user get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getSingleUser(@PathVariable("catId") Integer cId){
		return ResponseEntity.ok(this.categoryService.getCategory(cId));
	}
}
