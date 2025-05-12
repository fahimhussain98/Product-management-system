package com.hussain.service;

import java.util.List;

import com.hussain.dto.ProductDto;
import com.hussain.dto.ProductResponse;
import com.hussain.model.Product;

public interface ProductService {
	
//	public Boolean saveProduct(ProductDto productDto);
//	
//	public List<ProductDto> getAllProducts();
//
//	public ProductDto getProductById(Integer id);
//
//	public Boolean deleteProduct(Integer id);
	
	public Boolean saveProduct(ProductDto productDto);

	public List<ProductDto> getAllProducts();

	public ProductDto getProductById(Integer id);

	public Boolean deleteProduct(Integer id);

//	public ProductResponse getProductsWithPagination(int pageNo, int pageSize, String sortBy, String sortDir);
	 ProductResponse getProductsWithPagination(int pageNo, int pageSize, String sortBy, String sortDir);

}
