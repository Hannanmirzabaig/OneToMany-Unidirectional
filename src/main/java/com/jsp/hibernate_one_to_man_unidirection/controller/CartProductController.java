package com.jsp.hibernate_one_to_man_unidirection.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_one_to_man_unidirection.dao.CartProductDao;
import com.jsp.hibernate_one_to_man_unidirection.dto.Cart;
import com.jsp.hibernate_one_to_man_unidirection.dto.Product;
import com.jsp.hibernate_one_to_man_unidirection.service.CartProductService;

public class CartProductController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		CartProductService cartProductService = new CartProductService();

		while (true) {
			System.out.println("1-INSERT\n2-ADD PRODUCT IN CART \n3-FETCH BY CARD NUMBER\n4-UPDATE CARD NAME BY CARD NUMBER");
			System.out.println("5-UPDATE PRODUCT NAME AND PRICE BY PRODUCT ID");
			int n = sc.nextInt();

			switch (n) {
			case 1: {
				System.out.println("enter the product id");
				int id = sc.nextInt();
				System.out.println("enter the product name");
				String name = sc.next();
				System.out.println("enter the product price");
				double price = sc.nextDouble();

				Product product = new Product(id, name, price);

				List<Product> products = Arrays.asList(product);

				System.out.println("enter the cart number");
				int card_number = sc.nextInt();
				System.out.println("enter the cart name ");
				String card_name = sc.next();

				Cart cart = new Cart(card_number, card_name, products);

				cartProductService.saveCartProduuctService(cart, products);

			}
				break;
			case 2: {
//				Product product=new Product(102, "khajoor", 500);
//				Product p=cartProductService.saveProductService(product);
//				if(p!=null){
//					System.out.println("data insert successfully");
//				}else {
//					System.out.println("data does not insert ");
//				}
				CartProductDao cartProductDao = new CartProductDao();
				cartProductDao.associateCartProductByPKDao(201, 102);

			}
				break;
			case 3: {
				System.out.println("enter the cart number");
				int card_number = sc.nextInt();

				Cart c = cartProductService.fetchCartProductDetailsByCardIdService(card_number);
				if (c != null) {
					System.out.println(c);
					List<Product> p = c.getProduct();
					if (!p.isEmpty()) {
						for (Product product : p) {
							System.out.println();
						}
					} else {
						System.out.println("card have not product");
					}

				} else {
					System.out.println("id does not found");
				}

			}
				break;
			case 4: {

				System.out.println("enter the card number ");
				int card_no = sc.nextInt();
				System.out.println("enter the new card name");
				String name = sc.next();

				Cart c = cartProductService.updateCartNameByIdDao(card_no, name);
				if (c != null) {
					System.out.println("successsfully updated");
				} else {
					System.out.println("id does not found");
				}
			}
			case 5:{
				System.out.println("enter the product id ");
				int card_no = sc.nextInt();
				System.out.println("enter the product new name");
				String name = sc.next();
				System.out.println("enter the product new price");
				double price=sc.nextDouble();
				
				Product p=cartProductService.updateProductByIdDao(card_no, name, price);
				if(p!=null) {
					System.out.println("data succcessfully updated ");
				}else {
					System.out.println("id does not found");
				}
				

				
				
			}break;

			default: {
				System.out.println("plz choose valid option");
			}

			}

		}

	}

}
