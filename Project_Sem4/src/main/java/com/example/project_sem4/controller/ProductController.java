package com.example.project_sem4.controller;

import com.example.project_sem4.dto.ProductDTO;
import com.example.project_sem4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/api/products")
//public class ProductController {
//
//    @Autowired
//    private IProductService productService;
//
//    // Get all products
//    @GetMapping
//    public ResponseEntity<List<ProductDTO>> getAllProducts() {
//        List<ProductDTO> products = productService.getAllProducts();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//
//    // Get product by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id) {
//        ProductDTO productDTO = productService.getProductById(id);
//        if (productDTO != null) {
//            return new ResponseEntity<>(productDTO, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // Create a new product
//    @PostMapping
//    public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO) {
//        productService.saveProduct(productDTO);
//        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
//    }
//
//    // Update a product
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO) {
//        ProductDTO existingProduct = productService.getProductById(id);
//        if (existingProduct != null) {
//            productService.updateProduct(id, productDTO);
//            return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // Delete a product
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
//        ProductDTO existingProduct = productService.getProductById(id);
//        if (existingProduct != null) {
//            productService.deleteProduct(id);
//            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // Sorting products by name
//    @GetMapping("/sorted-by-name")
//    public ResponseEntity<List<ProductDTO>> getProductsSortedByName() {
//        List<ProductDTO> products = productService.getAllProductsSortedByName();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//
//    // Sorting products by price
//    @GetMapping("/sorted-by-price")
//    public ResponseEntity<List<ProductDTO>> getProductsSortedByPrice() {
//        List<ProductDTO> products = productService.getAllProductsSortedByPrice();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//}



import com.example.project_sem4.dto.ProductDTO;
import com.example.project_sem4.service.ICategoryService;
import com.example.project_sem4.service.ILabelService;
import com.example.project_sem4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ILabelService labelService;

    // List all products
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "productList"; // Name of your Thymeleaf template for the product list
    }

    // Show form for creating a new product
    @GetMapping("/new")
    public String showProductForm(Model model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("labels", labelService.getAllLabels());
        return "productForm"; // Name of your Thymeleaf template for product form
    }

    // Save a new product
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") ProductDTO productDTO) {
        productService.saveProduct(productDTO);
        return "redirect:/products"; // Redirect to product list after saving
    }

    // Show form for updating an existing product
    @GetMapping("/edit/{productId}")
    public String showUpdateForm(@PathVariable int productId, Model model) {
        ProductDTO productDTO = productService.getProductById(productId);
        model.addAttribute("product", productDTO);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("labels", labelService.getAllLabels());
        return "productForm"; // Same form for both creation and update
    }

    // Update an existing product
    @PostMapping("/update/{productId}")
    public String updateProduct(@PathVariable int productId, @ModelAttribute("product") ProductDTO productDTO) {
        productService.updateProduct(productId, productDTO);
        return "redirect:/products"; // Redirect to product list after updating
    }

    // Delete a product
    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return "redirect:/products"; // Redirect to product list after deletion
    }
}
