package com.example.project_sem4.service;

import com.example.project_sem4.dto.ProductDTO;
import com.example.project_sem4.entity.Category;
import com.example.project_sem4.entity.Label;
import com.example.project_sem4.entity.Product;
import com.example.project_sem4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    // Helper method to convert ProductDTO to Product entity
    private Product convertToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setName(productDTO.getName());
        product.setStatus(productDTO.getStatus());
        product.setDuration(productDTO.getDuration());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());


        Label label = new Label();
        label.setLabelId(productDTO.getLabelId());
        product.setLabel(label);

        Category category = new Category();
        category.setCategoryId(productDTO.getCategoryId());
        product.setCategory(category);

        return product;
    }

    // Helper method to convert Product entity to ProductDTO
    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setName(product.getName());
        productDTO.setStatus(product.getStatus());
        productDTO.setDuration(product.getDuration());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setLabelId(product.getLabel().getLabelId());
        productDTO.setCategoryId(product.getCategory().getCategoryId());
        return productDTO;
    }

    // Get all products
    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get product by ID
    @Override
    public ProductDTO getProductById(int productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.map(this::convertToDTO).orElse(null);
    }

    // Save a new product
    @Override
    public void saveProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        productRepository.save(product);
    }

    // Update an existing product
    @Override
    public void updateProduct(int productId, ProductDTO productDTO) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        if (existingProduct.isPresent()) {
            Product product = convertToEntity(productDTO);
            product.setProductId(productId);
            productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with id: " + productId);
        }
    }

    // Delete a product by ID
    @Override
    public void deleteProduct(int productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
        } else {
            throw new RuntimeException("Product not found with id: " + productId);
        }
    }

    // Sorting Methods
    @Override
    public List<ProductDTO> getAllProductsSortedByName() {
        return productRepository.findAll()
                .stream()
                .sorted((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllProductsSortedByPrice() {
        return productRepository.findAll()
                .stream()
                .sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
