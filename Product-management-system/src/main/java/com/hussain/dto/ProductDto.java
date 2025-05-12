package com.hussain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ProductDto {
	
	private Integer id;
	
//	@NotBlank
//	private String name;
//	
//	@NotEmpty
//	@Size(min =3, max =10,message = "description min or max size is 3 10")
//	private String description ;
//	
////	@NotEmpty
////	@Pattern(regexp = "^[0-9]*$", message ="invalid price thik se likho")
//	private double price ;
//	
//	private Integer quantity;
	

//    @NotBlank(message = "Name cannot be blank")
//    private String name;
//
//    @NotEmpty(message = "Description cannot be empty")
//    @Size(min = 3, max = 10, message = "Description must be 3-10 characters")
//    private String description;
//
//    @NotNull(message = "Price cannot be null")
//    private Double price; // Use Double instead of double
//
//    private Integer quantity;
	@NotBlank(message = "Name cannot be blank")
    private String name;

 
    
    @NotEmpty(message = "Description cannot be empty")
    @Size(min = 3, max = 10, message = "Description must be 3-10 characters")
    private String description;

    @NotNull(message = "Price cannot be null")
    private Double price; // or Integer price

    private Integer quantity;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public String getPrice() {
//		return price;
//	}
//	public void setPrice(String price) {
//		this.price = price;
//	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}


}
