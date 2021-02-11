package edu.ncsu.csc326.coffeemaker;

import org.junit.Test;
import org.junit.Assert;

import junit.framework.TestCase;

public class RecipeBookTest extends TestCase {
	
	@Test
	public void testCreation1() {
		RecipeBook book = new RecipeBook();
		assertEquals(4, book.getRecipes().length);
	}
	
	@Test
	public void testAddAndGet1() {
		//simple testing of adding recipes and getting them back
		RecipeBook book = new RecipeBook();
		Recipe recipeOne = new Recipe();
		Recipe recipeTwo = new Recipe();
		
		recipeOne.setName("one");
		recipeTwo.setName("two");
		
		assertTrue(book.addRecipe(recipeOne));
		assertTrue(book.addRecipe(recipeTwo));
		
		assertEquals(book.getRecipes()[0], recipeOne);
		assertEquals(book.getRecipes()[1], recipeTwo);
	}
	
	@Test
	public void testAddAndGet2() {
		//kinda sucks, test cases need to change if max recipe size changes but does not seem to be a way around that
		RecipeBook book = new RecipeBook();
		Recipe recipeOne = new Recipe();
		Recipe recipeTwo = new Recipe();
		Recipe recipeThree = new Recipe();
		Recipe recipeFour = new Recipe();
		Recipe recipeFive = new Recipe();
		
		recipeOne.setName("one");
		recipeTwo.setName("two");
		recipeThree.setName("three");
		recipeFour.setName("four");
		recipeFive.setName("five");
		
		book.addRecipe(recipeOne); book.addRecipe(recipeTwo); book.addRecipe(recipeThree); book.addRecipe(recipeFour);
		
		assertFalse(book.addRecipe(recipeFive)); //should be false; larger then size of array
	}
	
	@Test
	public void testAddAndGet3() {
		RecipeBook book = new RecipeBook();
		Recipe recipeOne = new Recipe();
		
		recipeOne.setName("one");
		
		book.addRecipe(recipeOne);
		assertFalse(book.addRecipe(recipeOne));
		assertEquals(book.getRecipes()[0], recipeOne);
		assertNull(book.getRecipes()[1]);
		
	}

}
