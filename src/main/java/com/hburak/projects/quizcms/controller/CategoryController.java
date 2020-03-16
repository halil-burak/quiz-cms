package com.hburak.projects.quizcms.controller;

import com.hburak.projects.quizcms.domain.dto.category.CategoryCreateDTO;
import com.hburak.projects.quizcms.service.CategoryService;
import com.hburak.projects.quizcms.service.PlatformService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final PlatformService platformService;

    @GetMapping("/listAll")
    public ResponseEntity<?> getCategories() {
        return new ResponseEntity<Object>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/category/{id}}")
    public ResponseEntity<?> getOneCategory(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<Object>(categoryService.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public Long addCategory(@RequestBody CategoryCreateDTO categoryCreateDTO) {
        return categoryService.save(categoryCreateDTO);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable(name = "id") Long id) {
        categoryService.delete(id);
    }

    @PutMapping("/update/{id}")
    public void updateCategory(@PathVariable(name = "id") Long id, @RequestBody CategoryCreateDTO categoryUpdateDTO) {
        categoryService.update(id, categoryUpdateDTO);
    }

    @GetMapping("/category/{id}/platforms")
    public ResponseEntity<?> getPlatformsByCategory(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<Object>(platformService.getPlatformsByCategory(id), HttpStatus.OK);
    }
}
