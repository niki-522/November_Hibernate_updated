package com.jbk.hibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.criterion.Order;

import com.jbk.hibernate.dao.ProductDao;
import com.jbk.hibernate.entity.Product;
import com.jbk.hibernate.service.ProductService;
import com.jbk.hibernate.utility.ProductUtility;

public class ProductController {

	public static void main(String[] args) {
		char ch;
		Scanner scanner = new Scanner(System.in);
		ProductService service = new ProductService();
		do {
			System.out.println("Press 1 for save product");
			System.out.println("Press 2 for get product by id");
			System.out.println("press 3 to delete product by id");
			System.out.println("press 4 to update product by id");
			System.out.println("press 5 to get all products");
			System.out.println("press 6 for ascending order of the product name");
			System.out.println("press 7 for descending order of the product name");
			System.out.println("press 8 to set maximum products");
			System.out.println("press 9 to set the result in query which is starting from records");
			System.out.println("press 10 for pagination");
			System.out.println("press 11 to apply 'greater than' constraint to the named property");
			System.out.println("press 12 to apply 'greater than equal to' constraint to the named property");
			System.out.println("press 13 for between");
			System.out.println("press 14 for like");
			System.out.println("press 15 for sorting in ascending or descending");
			System.out.println("press 16 to find products exists or not");
			System.out.println("press 17 to apply 'less than equal to' constraint to the named property");
			System.out.println("press 18 equal id");
			System.out.println("press 19 to show not null");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				Product product = ProductUtility.prepareProductData(scanner);
				boolean isAdded = service.saveProduct(product);
				if (isAdded) {
					System.out.println("saved!!!");
				} else {
					System.out.println("Product Already exist with Id  =" + product.getProductId());
				}
				break;
			}
			case 2: {
				System.out.println("Enter Product Id");
				long productId = scanner.nextLong();
				Product product = service.getProductById(productId);
				if (product != null) {
					System.out.println(product);
				} else {
					System.out.println("product does not exist !! ID = " + productId);
				}
				break;
			}
			case 3: {
				System.out.println("Enter productId to delete the product");
				long productId = scanner.nextLong();
				boolean isDeleted = service.deleteProductById(productId);
				if (isDeleted) {
					System.out.println("product deleted");
				} else {
					System.out.println("does not exist with id" + productId);
				}
				break;
			}
			case 4: {
				Product product = ProductUtility.prepareProductData(scanner);
				boolean isUpdated = service.updateProduct(product);
				if (isUpdated) {

					System.out.println("updated");
				} else {
					System.out.println("doessnot exist with id=" + product.getProductId());
				}
				break;
			}
			case 5: {
				List<Product> list = service.getAllProducts();
				if (list.isEmpty() || list == null) {
					System.out.println("products does not exist");
				} else {
					for (Product product : list) {
						System.out.println(product);

					}
				}
			}
			case 6: {
				List<Product> list = service.getAllProductsInAscendingOrder();
				if (list.isEmpty() || list == null) {
					System.out.println("products does not exist");
				} else {
					for (Product product : list) {
						System.out.println(product);

					}
				}
				break;

			}
			case 7: {
				List<Product> list = service.getAllProductsInDescendingOrder();
				if (list.isEmpty() || list == null) {
					System.out.println("products does not exist");
				} else {
					for (Product product : list) {
						System.out.println(product);

					}
				}
				break;

			}
			case 8: {
				List<Product> list = service.setMaximumProducts();
				if (list.isEmpty() || list == null) {
					System.out.println("products does not exist");
				} else {
					for (Product product : list) {
						System.out.println(product);

					}
				}
				break;

			}
			case 9: {
				List<Product> list = service.setToStartFromTheRecords();
				if (list.isEmpty() || list == null) {
					System.out.println("products does not exist");
				} else {
					for (Product product : list) {
						System.out.println(product);

					}
				}
				break;

			}
			case 10: {
				List<Product> list = service.forPagination();
				if (list.isEmpty() || list == null) {
					System.out.println("products does not exist");
				} else {
					for (Product product : list) {
						System.out.println(product);

					}
				}
				break;

			}
			case 11: {
				List<Product> list = service.forGreaterThan();
				if (list.isEmpty() || list == null) {
					System.out.println("products does not exist");
				} else {
					for (Product product : list) {
						System.out.println(product);

					}
				}
				break;

			}
			case 12: {
				List<Product> list = service.forGreaterThanEqualTo();
				if (list.isEmpty() || list == null) {
					System.out.println("products does not exist");
				} else {
					for (Product product : list) {
						System.out.println(product);

					}
				}
				break;

			}
			case 13: {
				List<Product> list = service.forBetween();
				if (list.isEmpty() || list == null) {
					System.out.println("products does not exist");
				} else {
					for (Product product : list) {
						System.out.println(product);

					}
				}
				break;

			}
			case 14: {
				System.out.println("type for search");
				String exp = scanner.next();
				List<Product> list = service.forLike(exp);
				if (list.isEmpty() || list == null) {
					System.out.println("products does not exist");
				} else {
					for (Product product : list) {
						System.out.println(product);

					}
				}
				break;
			}
			case 15: {
				System.out.println("Enter 1 for Ascending Order ");
				System.out.println("Enter 2 for Descending Order ");
				int exp = scanner.nextInt();

				List<Product> list = service.forSortingWithAscendingOrDescending(exp);

				if (list.isEmpty() || list == null) {
					System.out.println("products does not exist");
				} else {
					for (Product product : list) {
						System.out.println(product);

					}
				}
				break;

			}
			case 16: {
				System.out.println("enter to find");
				String exp = scanner.next();
				List<Product> list = service.forEqOrIsNull(exp);
				if (list.isEmpty() || list == null) {
					System.out.println("product exists");
				}

			}
			case 17: {
				System.out.println("enter value");
				long exp = scanner.nextInt();
				List<Product> list = service.forLessThan(exp);
				if (list.isEmpty() || list == null) {
					System.out.println("product does not exists");
				} else {
					for (Product product : list) {
						System.out.println(product);
					}
				}

			}
			case 18: {
				System.out.println("enter value");
				long exp = scanner.nextInt();
				List<Product> list = service.forLessThan(exp);
				if (list.isEmpty() || list == null) {
					System.out.println("product does not exists");
				} else {
					for (Product product : list) {
						System.out.println(product);
					}
				}
			}
			case 19: {
				System.out.println("enter value");
				String exp = scanner.next();
				List<Product> list = service.toShowNotNull(exp);
				if (!list.isEmpty() || list != null) {
					System.out.println("product is not null");
				}
			}

			default:
				break;
			}
			System.out.println("Do you want to continue? Y/N");
			ch = scanner.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
		System.out.println("terminated");
	}
}
