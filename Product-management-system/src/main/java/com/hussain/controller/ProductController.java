package com.hussain.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hussain.dto.ProductDto;
import com.hussain.dto.ProductResponse;
import com.hussain.exception.InvalidRequestException;
import com.hussain.model.Product;
import com.hussain.service.ProductService;

import jakarta.validation.Valid;

@RestController
//@Validated // Add this
public class ProductController {
	

	@Autowired
	private ProductService productService;


	
//	@PostMapping ("/save-product")
//	public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto){
//		 
//		Boolean saveproduct =  productService.saveProduct(productDto);
//		
//		 return new ResponseEntity("save prodcut successfuly",HttpStatus.CREATED);
//
//
//		
//
//	}
//	@PostMapping("/save-product")
//	public ResponseEntity<?> saveProduct(@RequestBody @Valid ProductDto productDto) {
//
//		try {
//			Boolean saveProduct = productService.saveProduct(productDto);
//			if (!saveProduct) {
//				return new ResponseEntity<>("product not saved", HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		} catch (Exception e) {
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return new ResponseEntity<>("saved success", HttpStatus.CREATED);
//	}

//	@PostMapping("/save-product")
//	public ResponseEntity<?> saveProduct(@RequestBody @Valid ProductDto productDto, BindingResult bindingResult) {
//	    if (bindingResult.hasErrors()) {
//	        // Return validation errors
//	        List<String> errors = bindingResult
//	            .getFieldErrors()
//	            .stream()
//	            .map(error -> error.getField() + ": " + error.getDefaultMessage())
//	            .collect(Collectors.toList());
//	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//	    }
//
//	    try {
//	        boolean saveProduct = productService.saveProduct(productDto);
//	        if (!saveProduct) {
//	            return new ResponseEntity<>("Product not saved", HttpStatus.INTERNAL_SERVER_ERROR);
//	        }
//	    } catch (Exception e) {
//	        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	    return new ResponseEntity<>("Saved successfully", HttpStatus.CREATED);
//	}
//	
	//@Valid 
	@PostMapping("/save-product")
	public ResponseEntity<String> saveProduct(@RequestBody ProductDto productDto) {
	    boolean isSaved = productService.saveProduct(productDto);
	    return isSaved 
	        ? ResponseEntity.ok("Saved successfully")
	        : ResponseEntity.internalServerError().body("Failed to save product");
	}
	
	@GetMapping("/products")
	public ResponseEntity<?> getProducts() {
		List<ProductDto> allProducts = null;
		try {
			allProducts = productService.getAllProducts();
			if (allProducts == null || allProducts.isEmpty()) {
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}
	
	
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProducts(@PathVariable(name = "id") Integer id) {
		ProductDto product = null;
		try {
			product = productService.getProductById(id);

			if (ObjectUtils.isEmpty(product)) {
				return new ResponseEntity<>("Product not found with id=" + id, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") Integer id) {
		Boolean deleteProduct = null;
		try {
			deleteProduct = productService.deleteProduct(id);

			if (!deleteProduct) {
				return new ResponseEntity<>("Product not Deleted", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Delete success", HttpStatus.OK);
	}

	@GetMapping("/page-products")
	public ResponseEntity<?> getProductsPaginate(@RequestParam(name = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize", defaultValue = "2") int pageSize,
			@RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
			@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "sortDir", defaultValue = "asc") String sortDir)
	 		{
		ProductResponse productResponse = null;
		
		//String name = null;
		name.toUpperCase();
		
		
		    
		    if (name == null) {
		        throw new InvalidRequestException("ERR_NAME_REQUIRED", "Name parameter is required");
		    }
	
		    
		
		try {

			productResponse = productService.getProductsWithPagination(pageNo, pageSize, sortBy, sortDir);
			if (ObjectUtils.isEmpty(productResponse)) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}

	

}
