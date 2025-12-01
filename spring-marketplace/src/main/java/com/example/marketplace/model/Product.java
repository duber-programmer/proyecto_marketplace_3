package com.example.marketplace.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Size(max=100)
    private String name;
    @Size(max=500)
    private String description;
    @Min(0)
    private double price;
    public Product() {}
    public Product(String name, String description, double price) { this.name=name; this.description=description; this.price=price;}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getDescription(){return description;} public void setDescription(String description){this.description=description;}
    public double getPrice(){return price;} public void setPrice(double price){this.price=price;}
}
