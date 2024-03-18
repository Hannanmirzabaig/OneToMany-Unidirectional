package com.jsp.hibernate_one_to_man_unidirection.service;

import java.util.List;

import com.jsp.hibernate_one_to_man_unidirection.dao.CartProductDao;
import com.jsp.hibernate_one_to_man_unidirection.dto.Cart;
import com.jsp.hibernate_one_to_man_unidirection.dto.Product;

public class CartProductService {
	
	CartProductDao cpo=new CartProductDao();
	
	/**
	 * for case 1
	 * @param c
	 * @param products
	 * @return
	 */
	public Cart saveCartProduuctService(Cart c, List<Product> products) {
		return cpo.saveCartProduuctDao(c, products);
	}
	
	
	/**
	 * for case 2
	 * @param pro
	 * @return
	 */
	public Product saveProductService(Product pro) {
		return cpo.saveProductDao(pro);
	}
//	public void associateCartProductByPKService(int cardId,int productId) {
//		cpo.associateCartProductByPKDao(cardId, productId);
//	}
	
	
	/**
	 * for case 3
	 * @param id
	 * @return
	 */
	public  Cart fetchCartProductDetailsByCardIdService(int id) {
		return cpo.fetchCartProductDetailsByCardIdDao(id);
	}
	
	/**
	 * for case 4
	 */
	public Cart updateCartNameByIdDao(int id,String name) {
		return cpo.updateCartNameByIdDao(id, name);
	}
	
	/**
	 * for case 5
	 */
	public Product updateProductByIdDao(int id,String name ,double price) {
		return cpo.updateProductByIdDao(id, name, price);
	}

}
