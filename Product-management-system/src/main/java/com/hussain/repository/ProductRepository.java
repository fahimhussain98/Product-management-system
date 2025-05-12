package com.hussain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hussain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
