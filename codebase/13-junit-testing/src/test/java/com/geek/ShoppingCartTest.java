package com.geek;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
class ShoppingCartTest {
	public ShoppingCartTest() {
	//System.out.println("constructor ...");
	}
	 ShoppingCart cart=null;
//	@BeforeAll //used for common DB connection
//	public static void init() {
//		//common initialization for all test cases
//		cart=new ShoppingCart();
//		cart.addItem("pen", 10);
//		cart.addItem("notebook", 20);
//	}
	@BeforeEach
	
	public  void init() {
		//common initialization for all test cases
		cart=new ShoppingCart();
		cart.addItem("pen", 10);
		cart.addItem("notebook", 20);
	}
	//Every Test case run on its own instance
	//bcoz one test case result shud not affect other 
	//test case result 
	@Test
	//@CsvFileSource(files = "")
	void testAddItem() {
		//assertEquals(exptected,actual)
		assertEquals(2, cart.itemCount());
		Map<String, Float> items= cart.getCart();
		assertEquals(10, items.get("pen"));
		assertEquals(20, items.get("notebook"));
	}

	@Test
	void testTotalPrice() {
		//fail("Not yet implemented");
		double totalPrice=cart.totalPrice();
		assertEquals(30, totalPrice);
	}
	@Test
	void testItemCount() {
		//fail("Not yet implemented");
		assertEquals(2, cart.itemCount());
	}
	@Test
	void testGetPrice() {
		//fail("Not yet implemented");
		assertEquals(10, cart.getPrice("pen"));
	}
	@Test
	void testClearCart() {
		//fail("Not yet implemented");
		cart.clearCart();
		assertEquals(0, cart.itemCount());
	}
	@Test
   void testAddItemNegativeTest() {
		IllegalArgumentException ex=
	   assertThrows(IllegalArgumentException.class, 
			   ()-> cart.addItem("", 0));
		assertEquals("Price must be greater than zero", ex.getMessage());
   }
	@Test
	void testGetPriceNegative() {
		IllegalArgumentException ex=
		assertThrows(IllegalArgumentException.class, 
				()->cart.getPrice("xyz"));
		assertEquals("item not found", ex.getMessage());
	}

	
}
