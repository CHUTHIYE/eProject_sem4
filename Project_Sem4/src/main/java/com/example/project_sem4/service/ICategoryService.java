package com.example.project_sem4.service;

import com.example.project_sem4.dto.CategoryDTO;
import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(int categoryId);
    void saveCategory(CategoryDTO categoryDTO);
    void updateCategory(int categoryId, CategoryDTO categoryDTO);
    void deleteCategory(int categoryId);
}
