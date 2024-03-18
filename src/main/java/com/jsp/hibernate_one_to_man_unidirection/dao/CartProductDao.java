package com.jsp.hibernate_one_to_man_unidirection.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hibernate_one_to_man_unidirection.dto.Cart;
import com.jsp.hibernate_one_to_man_unidirection.dto.Product;


public class CartProductDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AbdulHannanMirza");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	/**
	 * for case 1
	 * @param c
	 * @param products
	 * @return
	 */
	public Cart saveCartProduuctDao(Cart c, List<Product> products) {
		et.begin();
		em.persist(c);
		/**
		 * we are using for each loop because one cart have multiple product so we used
		 * list and inside the for each loop we will call em.persis(pass reference);
		 */
		for (Product product : products) {
			em.persist(product);
		}
		et.commit();
		return c;
	}
	/**
	 * for case 3
	 * @param pro
	 * @return
	 */
	public Product saveProductDao(Product pro) {
		et.begin();
		em.persist(pro);
		et.commit();
		return pro;
	}
	
	
	/**
	 * 
	 * @param cardId
	 * @param productId
	 * take Query from javax.persistence.      we will not take form com.mysql.cj
	 * setParameter(take Position from table , argument reference)
	 * at here two argument so we will take two set parameter method
	 * after then we have to call execute update method with help of Query reference
	 */
	public void associateCartProductByPKDao(int cardId,int productId) {
		String insertQuery="insert into cart_product(Cart_cart_no,product_product_id) values(?1,?2)";
		
		Query query=em.createNativeQuery(insertQuery);
		query.setParameter(1, cardId);
		query.setParameter(2, productId);
		
		et.begin();
		query.executeUpdate();
		et.commit();
	}
	
	/**
	 * for case 3
	 * @param id
	 * @return
	 */
	public  Cart fetchCartProductDetailsByCardIdDao(int id) {
		return em.find(Cart.class, id);
		
	}
	
	/**
	 * for case 4
	 */
	public Cart updateCartNameByIdDao(int id,String name) {
		Cart c=em.find(Cart.class, id);
		if(c!=null) {
			et.begin();
			c.setCard_name(name);
			em.merge(c);
			et.commit();
			return c;
		}
		return null;    //we can use else block because this true then return c other wise return false
	}
	
	/**
	 * for case 5
	 */
	public Product updateProductByIdDao(int id,String name ,double price) {
		Product p=em.find(Product.class, id);
		
		if(p!=null) {
			et.begin();
			
			p.setProduct_name(name);
			p.setProduct_price(price);
			
			em.merge(p);
			et.commit();
			return p;
			
		}
		return null;
	}
		
}


