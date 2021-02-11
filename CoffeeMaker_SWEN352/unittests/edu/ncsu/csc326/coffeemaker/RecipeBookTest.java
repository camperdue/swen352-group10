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
	
	@Test
	public void testDeleteRecipe1() {
		RecipeBook book = new RecipeBook();
		
		assertNull(book.deleteRecipe(0));
		assertNull(book.deleteRecipe(1));
		assertNull(book.deleteRecipe(5));
	}
	
	@Test
	public void testDeleteRecipe2() {
		RecipeBook book = new RecipeBook();
		Recipe recipeOne = new Recipe();
		
		recipeOne.setName("one");
		
		book.addRecipe(recipeOne);
		assertEquals(book.deleteRecipe(0), "one");
		assertEquals(book.deleteRecipe(0), null);
	}
	
	@Test
	public void testDeleteRecipe3() {
		RecipeBook book = new RecipeBook();
		Recipe recipeOne = new Recipe();
		Recipe recipeTwo = new Recipe();
		
		recipeOne.setName("one");
		recipeTwo.setName("two");
		
		book.addRecipe(recipeOne);
		book.deleteRecipe(0);
		book.addRecipe(recipeTwo);
		assertEquals(book.getRecipes()[0], recipeTwo);
	}
	
	@Test
	public void testEditRecipe1() {
		RecipeBook book = new RecipeBook();
		assertNull(book.editRecipe(0, null));
		assertNull(book.editRecipe(1, null));
	}
	
	@Test
	public void testEditRecipe2() {
		RecipeBook book = new RecipeBook();
		assertNull(book.editRecipe(5, null));
	}
	
	@Test
	public void testEditRecipe3() {
		RecipeBook book = new RecipeBook();
		Recipe recipeOne = new Recipe();
		Recipe recipeTwo = new Recipe();
		
		recipeOne.setName("one");
		
		book.addRecipe(recipeOne);
		assertEquals(book.editRecipe(0, recipeTwo), "one");
	}
	
	@Test
	public void testEditRecipe4() {
		RecipeBook book = new RecipeBook();
		Recipe recipeOne = new Recipe();
		Recipe recipeTwo = new Recipe();
		
		recipeOne.setName("one");
		
		book.addRecipe(recipeOne);
		assertEquals(book.editRecipe(0, recipeTwo), "one");
		assertEquals(book.getRecipes()[0], recipeTwo);
	}
	
	@Test
	public void testEditRecipe5() {
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
		book.addRecipe(recipeOne);
		book.addRecipe(recipeTwo);
		book.addRecipe(recipeThree);
		book.addRecipe(recipeFour);
		
		assertEquals(book.editRecipe(0, recipeFive), "one");
		assertEquals(book.editRecipe(1, recipeOne), "two");
		assertEquals(book.editRecipe(2, recipeTwo), "three");
		assertEquals(book.editRecipe(3, recipeThree), "four");
		
	}
}
