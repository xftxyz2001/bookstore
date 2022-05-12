package com.atguigu.bookstore.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.atguigu.bookstore.domain.ShoppingCart;

public class BookStoreWebUtils {

	/**
	 * 获取购物车对象: 从 session 中获取, 若 session 中没有改对象.
	 * 则创建一个新的购物车对象, 放入到 session 中.
	 * 若有, 则直接返回.
	 * 
	 * @param request
	 * @return
	 */
	public static ShoppingCart getShoppingCart(HttpServletRequest request) {
		HttpSession session = request.getSession();

		ShoppingCart sc = (ShoppingCart) session.getAttribute("ShoppingCart");
		if (sc == null) {
			sc = new ShoppingCart();
			session.setAttribute("ShoppingCart", sc);
		}

		return sc;
	}

}
