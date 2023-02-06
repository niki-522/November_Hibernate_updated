package com.jbk.hibernate.service;

import java.util.List;

import org.hibernate.criterion.Order;

import com.jbk.hibernate.dao.ProductDao;
import com.jbk.hibernate.entity.Product;

public class ProductService {

	ProductDao dao =new ProductDao();
	public boolean saveProduct(Product product) {
		return dao.saveProduct(product);
	}
	public Product getProductById(long productId) {
		return dao.getProductById(productId);
	}
	public boolean deleteProductById(long productId) {
		boolean isDeleted= dao.deleteProductById(productId);
		return isDeleted;
	}
	public boolean  updateProduct(Product product) {
		boolean isUpdated= dao.updateProduct(product);
		return isUpdated;
	}
	public List<Product> getAllProducts(){
		return dao.getAllProducts();
		
	}
	public List<Product> getAllProductsInAscendingOrder(){
		return dao.getAllProductsInAscendingOrder();
		
	}
	public List<Product> getAllProductsInDescendingOrder() {
		return dao.getAllProductsInDescendingOrder();
	}
	public List<Product> setMaximumProducts() {
		return dao.setMaximumProducts();
	}
	public List<Product> setToStartFromTheRecords() {
		return dao.setToStartFromTheRecords();
	}
	public List<Product> forPagination() {
		return dao.forPagination();
	}
	public List<Product> forGreaterThan() {
		return dao.forGreaterThan();
	}
	public List<Product> forGreaterThanEqualTo() {
		return dao.forGreaterThanEqualTo();
		
	}
	public List<Product> forBetween() {
		return dao.forBetween();
		
	}
	public List<Product> forSorting() {
		return dao.forSorting();
		
	}
	public List<Product> forSortingWithAscendingOrDescending(int exp) {
		return dao.forSortingWithAscendingOrDescending(exp);
		
	}
	public List<Product> forLike(String exp) {
		return dao.forLike(exp);
	}
	public List<Product> forEqOrIsNull(String exp){
		return dao.forEqOrIsNull(exp);
	}
	public List<Product> forLessThan(long exp){
		return dao.forLessThan(exp);
	}
	public List<Product> forEqId(long exp){
		return dao.forEqId(exp);
	}
	public List<Product> toShowNotNull(String exp){
		return dao.toShowNotNull(exp);
	}
}
