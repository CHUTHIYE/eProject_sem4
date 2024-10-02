package com.example.project_sem4.service;

import com.example.project_sem4.dto.CategoryDTO;
import com.example.project_sem4.entity.Category;
import com.example.project_sem4.repository.CategoryRepository; // Ensure this repository is created
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private Category convertToEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryName(categoryDTO.getCategoryName());
        return category;
    }

    private CategoryDTO convertToDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setCategoryName(category.getCategoryName());
        return categoryDTO;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(int categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        return category.map(this::convertToDTO).orElse(null);
    }

    @Override
    public void saveCategory(CategoryDTO categoryDTO) {
        Category category = convertToEntity(categoryDTO);
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(int categoryId, CategoryDTO categoryDTO) {
        Optional<Category> existingCategoryOptional = categoryRepository.findById(categoryId);
        if (existingCategoryOptional.isPresent()) {
            Category existingCategory = existingCategoryOptional.get();
            existingCategory.setCategoryName(categoryDTO.getCategoryName());
            categoryRepository.save(existingCategory);
        } else {
            throw new RuntimeException("Category not found with id: " + categoryId);
        }
    }

    @Override
    public void deleteCategory(int categoryId) {
        if (categoryRepository.existsById(categoryId)) {
            categoryRepository.deleteById(categoryId);
        } else {
            throw new RuntimeException("Category not found with id: " + categoryId);
        }
    }
}
