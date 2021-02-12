package edu.ncsu.csc326.coffeemaker;

import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;



import junit.framework.TestCase;

public class RecipeTest extends TestCase {
	@Test
	public void testGetAmtChocolate() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.getAmtChocolate(),0);
	}
	
	@Test
	public void testSetAmtChocolate() {
		Recipe recipe = new Recipe();
		try {
		recipe.setAmtChocolate("1");
		}catch(Exception e) {
		}
		assertEquals(recipe.getAmtChocolate(),1);
	}
	
	@Test
	public void testSetAmtChocolateZero() {
		Recipe recipe = new Recipe();
		try {
			recipe.setAmtChocolate("0");
		} catch(Exception e) { }
		assertEquals(recipe.getAmtChocolate(), 0);
	}
	
	@Test
	public void testSetAmtChocolateNegative() {
		Recipe recipe = new Recipe();
		try {
		recipe.setAmtChocolate("-1");
		}catch(Exception e) {
			assertTrue(e instanceof RecipeException);
			assertEquals(e.getMessage(), "Units of chocolate must be a positive integer");
		}
		assertFalse(recipe.getAmtChocolate()==-1);
	}
	
	@Test
	public void testSetAmtChocolateNotPositiveInteger() {
		Recipe recipe = new Recipe();
		try {
		recipe.setAmtChocolate("foo");
		}catch(Exception e) {
			assertTrue(e instanceof RecipeException);
			assertEquals(e.getMessage(), "Units of chocolate must be a positive integer");
		}
	}
	
	@Test
	public void testGetAmtCoffee() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.getAmtCoffee(),0);
	}
	
	@Test
	public void testSetAmtCoffee() {
		Recipe recipe = new Recipe();
		try {
		recipe.setAmtCoffee("1");
		}catch(Exception e) {
		}
		assertEquals(recipe.getAmtCoffee(),1);
	}
	
	@Test
	public void testSetAmtCoffeeNegative() {
		Recipe recipe = new Recipe();
		try {
		recipe.setAmtCoffee("-1");
		}catch(Exception e) {
			assertTrue(e instanceof RecipeException);
			assertEquals(e.getMessage(), "Units of coffee must be a positive integer");
		}
		assertFalse(recipe.getAmtCoffee()==-1);
	}
	
	@Test
	public void testSetAmtCoffeeNotPositiveInteger() {
		Recipe recipe = new Recipe();
		try {
		recipe.setAmtCoffee("foo");
		}catch(Exception e) {
			assertTrue(e instanceof RecipeException);
			assertEquals(e.getMessage(), "Units of coffee must be a positive integer");
		}
	}
	@Test
	public void testGetAmtMilk() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.getAmtMilk(),0);
	}
	
	@Test
	public void testSetAmtMilk() {
		Recipe recipe = new Recipe();
		try {
		recipe.setAmtMilk("1");
		}catch(Exception e) {
		}
		assertEquals(recipe.getAmtMilk(),1);
	}
	
	@Test
	public void testSetAmtMilkZero() {
		Recipe recipe = new Recipe();
		try {
			recipe.setAmtMilk("0");
		} catch (Exception e) { } 
		assertEquals(recipe.getAmtMilk(), 0);
	}
	
	@Test
	public void testSetAmtMilkNegative() {
		Recipe recipe = new Recipe();
		try {
		recipe.setAmtMilk("-1");
		}catch(Exception e) {
			assertTrue(e instanceof RecipeException);
			assertEquals(e.getMessage(), "Units of milk must be a positive integer");
		}
		assertFalse(recipe.getAmtMilk()==-1);
	}
	
	@Test
	public void testSetAmtMilkNotPositiveInteger() {
		Recipe recipe = new Recipe();
		try {
		recipe.setAmtMilk("foo");
		}catch(Exception e) {
			assertTrue(e instanceof RecipeException);
			assertEquals(e.getMessage(), "Units of milk must be a positive integer");
		}
	}
	
	@Test
	public void testGetAmtSugar() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.getAmtSugar(),0);
	}
	
	@Test
	public void testSetAmtSugar() {
		Recipe recipe = new Recipe();
		try {
		recipe.setAmtSugar("1");
		}catch(Exception e) {
		}
		assertEquals(recipe.getAmtSugar(),1);
	}
	
	@Test
	public void testSetAmtSugarNegative() {
		Recipe recipe = new Recipe();
		try {
		recipe.setAmtSugar("-1");
		}catch(Exception e) {
			assertTrue(e instanceof RecipeException);
			assertEquals(e.getMessage(), "Units of sugar must be a positive integer");
		}
		assertFalse(recipe.getAmtSugar()==-1);
	}
	
	@Test
	public void testSetAmtSugarNotPositiveInteger() {
		Recipe recipe = new Recipe();
		try {
		recipe.setAmtSugar("foo");
		}catch(Exception e) {
			assertTrue(e instanceof RecipeException);
			assertEquals(e.getMessage(), "Units of sugar must be a positive integer");
		}
	}
	
	@Test
	public void testGetName() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.getName(),"");
	}
	
	@Test
	public void testSetName() {
		Recipe recipe = new Recipe();
		recipe.setName("name");
		assertEquals(recipe.getName(),"name");
	}
	
	@Test
	public void testSetNameNull() {
		Recipe recipe = new Recipe();
		recipe.setName(null);
		assertEquals(recipe.getName(),"");
	}
	@Test
	public void testGetPrice() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.getPrice(),0);
	}
	
	@Test
	public void testSetPrice() {
		Recipe recipe = new Recipe();
		try {
		recipe.setPrice("1");
		}catch(Exception e) {
		}
		assertEquals(recipe.getPrice(),1);
	}
	
	@Test
	public void testSetPriceNegative() {
		Recipe recipe = new Recipe();
		try {
		recipe.setPrice("-1");
		}catch(Exception e) {
			assertTrue(e instanceof RecipeException);
			assertEquals(e.getMessage(), "Price must be a positive integer");
		}
		assertFalse(recipe.getPrice()==-1);
	}
	
	@Test
	public void testSetPriceNotPositiveInteger() {
		Recipe recipe = new Recipe();
		try {
		recipe.setPrice("foo");
		}catch(Exception e) {
			assertTrue(e instanceof RecipeException);
			assertEquals(e.getMessage(), "Price must be a positive integer");
		}
	}
	
	@Test
	public void testToString() {
		Recipe recipe = new Recipe();
		assertEquals(recipe.toString(),"");
	}
	
	@Test
	public void testEqualsSame() {
		Recipe recipe = new Recipe();
		assertTrue(recipe.equals(recipe));
	}
	
	@Test
	public void testEqualsNull() {
		Recipe recipe = new Recipe();
		assertFalse(recipe.equals(null));
	}
	
	@Test
	public void testEqualsNonObject() {
		Recipe recipe = new Recipe();
		assertFalse(recipe.equals(5));
	}
	
	@Test
	public void testEqualsNonRecipeObject() {
		Recipe recipe = new Recipe();
		assertFalse(recipe.equals(new String()));
	}
	
	@Test
	public void testEqualsNameFalse() {
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();
		recipe2.setName("foo");
		assertFalse(recipe1.equals(recipe2));
	}
	@Test
	public void testEqualsNameTrue() {
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();
		assertTrue(recipe1.equals(recipe2));
	}
	
	@Test
	public void testHashCodeSame() {
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();
		recipe1.setName("foo");
		recipe2.setName("foo");
		assertTrue(recipe1.hashCode()==recipe2.hashCode());
		assertTrue(recipe1.equals(recipe2) && recipe2.equals(recipe1));
	}
	
	@Test
	public void testHashCodeDifferent() {
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();
		recipe1.setName("foo");
		recipe2.setName("bar");
		assertFalse(recipe1.hashCode()==recipe2.hashCode());
		assertFalse(recipe1.equals(recipe2) && recipe2.equals(recipe1));
	}
	
	@Test
	public void testHashCodeEmpty() {
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();
		assertTrue(recipe1.hashCode()==recipe2.hashCode());
		assertTrue(recipe1.equals(recipe2) && recipe2.equals(recipe1));
	}
}
