package com.jbk.hibernate.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jbk.hibernate.config.HibernateConfig;
import com.jbk.hibernate.entity.Product;

public class ProductDao {

	private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	public boolean deleteProductById(long productId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted = false;
		try {
			Product dbproduct = getProductById(productId);
			if (dbproduct != null) {
				session.delete(dbproduct);
				transaction.commit();
				isDeleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isDeleted;
	}

	public boolean updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated = false;
		try {
			Product dbproduct = getProductById(product.getProductId());

			if (dbproduct != null) {

				session.update(product);
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isUpdated;
	}

	public boolean saveProduct(Product product) {

		Session session = sessionFactory.openSession();
		boolean isAdded = false;
		try {
			Product dbProduct = getProductById(product.getProductId());
			if (dbProduct == null) {
				Transaction transaction = session.beginTransaction();

				session.save(product);
				transaction.commit();
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isAdded;
	}

	public Product getProductById(long productId) {

		Session session = sessionFactory.openSession();
		Product product = null;
		try {
			product = session.get(Product.class, productId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return product;

	}

	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;

	}

	public List<Product> getAllProductsInAscendingOrder() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.asc("productName"));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> getAllProductsInDescendingOrder() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
//			criteria.addOrder(Order.desc("productName"));
//			criteria.add(Restrictions.gt("productPrice", 30.0));
			criteria.add(Restrictions.like("productName", " %wa%"));
//			criteria.setMaxResults(3);
//			criteria.setFirstResult(2);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> setMaximumProducts() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setMaxResults(3);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> setToStartFromTheRecords() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setFirstResult(2);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> forPagination() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setMaxResults(3);
			criteria.setFirstResult(2);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> forGreaterThan() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.gt("productPrice", 30.0));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> forGreaterThanEqualTo() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.ge("productPrice", 30.0));
			criteria.add(Restrictions.between("productPrice", 30, 70));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> forBetween() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.between("productPrice", 30.0, 70.0));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> forSorting() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);

			criteria.addOrder(Order.asc("productName"));

			criteria.addOrder(Order.asc("categoryId"));
			criteria.addOrder(Order.asc("productId"));
			criteria.addOrder(Order.asc("supplierId"));
			criteria.addOrder(Order.asc("productQTY"));
			criteria.addOrder(Order.asc("productPrice"));

			System.out.println("not present");

			criteria.addOrder(Order.desc("productName"));
			criteria.addOrder(Order.desc("categoryId"));
			criteria.addOrder(Order.desc("productId"));
			criteria.addOrder(Order.desc("supplierId"));
			criteria.addOrder(Order.desc("productQTY"));
			criteria.addOrder(Order.desc("productPrice"));

			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> forSortingWithAscendingOrDescending(int exp) {
		Session session = sessionFactory.openSession();
		Scanner scanner = new Scanner(System.in);
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			if (exp == 1) {
				System.out.println("for ascending order");

				System.out.println("press 1 for order by productname");
				System.out.println("press 2 for order by categoryId");
				System.out.println("press 3 for order by productId");
				System.out.println("press 4 for order by supplierId");
				System.out.println("press 5 for order by productQTY");
				System.out.println("press 6 for order by productPrice");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:

					criteria.addOrder(Order.asc("productName"));

					break;
				case 2:
					criteria.addOrder(Order.asc("categoryId"));
					break;
				case 3:
					criteria.addOrder(Order.asc("productId"));
					break;
				case 4:
					criteria.addOrder(Order.asc("supplierId"));
					break;
				case 5:
					criteria.addOrder(Order.asc("productQTY"));
					break;
				case 6:
					criteria.addOrder(Order.asc("productPrice"));
					break;
				default:
					break;
				}
			}

			else if (exp == 2) {
				System.out.println("descending order");
				System.out.println("press 1 for order by productname");
				System.out.println("press 2 for order by categoryId");
				System.out.println("press 3 for order by productId");
				System.out.println("press 4 for order by supplierId");
				System.out.println("press 5 for order by productQTY");
				System.out.println("press 6 for order by productPrice");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:

					criteria.addOrder(Order.desc("productName"));
					break;
				case 2:
					criteria.addOrder(Order.desc("categoryId"));
					break;
				case 3:
					criteria.addOrder(Order.desc("productId"));
					break;
				case 4:
					criteria.addOrder(Order.desc("supplierId"));
					break;
				case 5:
					criteria.addOrder(Order.desc("productQTY"));
					break;
				case 6:
					criteria.addOrder(Order.desc("productPrice"));
					break;
				default:
					break;
				}
			} else {
				System.out.println("not present");
			}
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> forLike(String exp) {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.like("productName", "%" + exp + "%"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> forEqOrIsNull(String exp) {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.isNull("productName"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> forLessThan(long exp) {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.le("productId", exp));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> forEqId(long exp) {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.idEq("productId"));
			criteria.add(Restrictions.isNotNull("productName"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List<Product> toShowNotNull(String exp) {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.isNotNull("productName"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}
