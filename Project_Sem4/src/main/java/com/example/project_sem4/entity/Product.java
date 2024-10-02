package com.example.project_sem4.entity;

import com.example.project_sem4.dto.ProductDTO;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 20)
    private String status;

    @Column(length = 20)
    private String duration;

    @Column
    private Double price;

    private Integer quantity;
//
//    @Column(name = "image_file_name")
//    private String imageFileName;


    @ManyToOne
    @JoinColumn(name = "label_id", nullable = true)
    private Label label;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductDetails> productDetails;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Image> images;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Feedback> feedbacks;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RentalDate> rentalDates;

    public Product(Category category, Set<RentalDate> rentalDates, Set<Feedback> feedbacks, Set<ProductDetails> productDetails, Set<Image> images, Label label, Integer quantity, String duration, Double price, String status, String name, Integer productId,String imageFileName) {
        this.category = category;
        this.rentalDates = rentalDates;
        this.feedbacks = feedbacks;
        this.productDetails = productDetails;
        this.images = images;
        this.label = label;
        this.quantity = quantity;
        this.duration = duration;
        this.price = price;
        this.status = status;
        this.name = name;
        this.productId = productId;
//        this.imageFileName = imageFileName;
    }


    public Product() {

    }


    // Getters and setters


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ProductDetails> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(Set<ProductDetails> productDetails) {
        this.productDetails = productDetails;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Set<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Set<RentalDate> getRentalDates() {
        return rentalDates;
    }

    public void setRentalDates(Set<RentalDate> rentalDates) {
        this.rentalDates = rentalDates;
    }

//    public String getImageFileName() {
//        return imageFileName;
//    }
//
//    public void setImageFileName(String imageFileName) {
//        this.imageFileName = imageFileName;
//    }
}
