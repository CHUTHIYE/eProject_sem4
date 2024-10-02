package com.example.project_sem4.service;

import com.example.project_sem4.dto.ProductDTO;
import java.util.List;

public interface IProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(int productId);
    void saveProduct(ProductDTO productDTO);
    void updateProduct(int productId, ProductDTO productDTO);
    void deleteProduct(int productId);

    List<ProductDTO> getAllProductsSortedByName();
    List<ProductDTO> getAllProductsSortedByPrice();
}


