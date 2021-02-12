package edu.ncsu.csc326.coffeemaker;

import org.junit.Test;

import static org.junit.Assert.*;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

import junit.framework.TestCase;

public class InventoryTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	//Test Inventory constructor (Test #1)
	@Test
	public void testCreation() {
		Inventory inventory = new Inventory();
		assertEquals(15, inventory.getChocolate());
		assertEquals(15, inventory.getCoffee());
		assertEquals(15, inventory.getMilk());
		assertEquals(15,inventory.getSugar());
	}
	
	//Test enoughIncredients (Test #2)
	@Test
	public void testEnoughIngredients() throws RecipeException {
		Inventory inventory = new Inventory();
		Recipe recipe = new Recipe();
		recipe.setName("recipe");
		recipe.setPrice("5");
		recipe.setAmtCoffee("2");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setAmtChocolate("1");
		assertEquals(true, inventory.enoughIngredients(recipe));
		}
	
	//Test enoughIngredients when Inventory does not have enough coffee (Test #3)
	@Test
	public void testEnoughIngredientsNotEnoughCoffee() throws RecipeException {
		Inventory inventory = new Inventory();
		Recipe recipe = new Recipe();
		recipe.setName("recipe");
		recipe.setPrice("5");
		recipe.setAmtCoffee("20");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setAmtChocolate("1");
		assertEquals(false, inventory.enoughIngredients(recipe));
		}
	
	//Test enoughIngredients when Inventory does not have enough milk (Test #4)
	@Test
	public void testEnoughIngredientsNotEnoughMilk() throws RecipeException {
		Inventory inventory = new Inventory();
		Recipe recipe = new Recipe();
		recipe.setName("recipe");
		recipe.setPrice("5");
		recipe.setAmtCoffee("2");
		recipe.setAmtMilk("20");
		recipe.setAmtSugar("1");
		recipe.setAmtChocolate("1");
		assertEquals(false, inventory.enoughIngredients(recipe));
		}
	
	//Test enoughIngredients when Inventory does not have enough sugar (Test #5)
	@Test
	public void testEnoughIngredientsNotEnoughSugar() throws RecipeException {
		Inventory inventory = new Inventory();
		Recipe recipe = new Recipe();
		recipe.setName("recipe");
		recipe.setPrice("5");
		recipe.setAmtCoffee("2");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("20");
		recipe.setAmtChocolate("1");
		assertEquals(false, inventory.enoughIngredients(recipe));
		}

	//Test enoughIngredients when Inventory does not have enough chocolate (Test #6)
	@Test
	public void testEnoughIngredientsNotEnoughChocolate() throws RecipeException {
		Inventory inventory = new Inventory();
		Recipe recipe = new Recipe();
		recipe.setName("recipe");
		recipe.setPrice("5");
		recipe.setAmtCoffee("2");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setAmtChocolate("20");
		assertEquals(false, inventory.enoughIngredients(recipe));
		}
	
	//Test useIngredients (Test #7)
	@Test
	public void testUseIngredients() throws RecipeException {
		Inventory inventory = new Inventory();
		Recipe recipe = new Recipe();
		recipe.setName("recipe");
		recipe.setPrice("5");
		recipe.setAmtCoffee("2");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setAmtChocolate("1");
		assertEquals(true, inventory.useIngredients(recipe));
		}
	
	//Test useIngredients when not enough are available (Test #8)
	@Test
	public void testUseIngredientsWhenNotEnough() throws RecipeException {
		Inventory inventory = new Inventory();
		Recipe recipe = new Recipe();
		recipe.setName("recipe");
		recipe.setPrice("5");
		recipe.setAmtCoffee("20");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setAmtChocolate("1");
		assertEquals(false, inventory.useIngredients(recipe));
		}
	
	//Test addChocolate (Test #9)
	@Test
	public void testAddChocolate() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addChocolate("5");
		assertEquals(20, inventory.getChocolate());
	}
	
	//Test addChocolate with empty string (Test #10)
	@Test
	public void testAddChocolateEmptyString() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addChocolate(""));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}	
	
	//Test addChocolate with letter (Test #11)
	@Test
	public void testAddChocolateLetter() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addChocolate("g"));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}
	
	//Test addChocolate with special character (Test #12)
	@Test
	public void testAddChocolateSpecialCharacter() throws InventoryException {
		Inventory inventory = new Inventory();			
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addChocolate("~"));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}	
		
	//Test addChocolate with negative integer (Test #13)
	@Test
	public void testAddChocolateNegativeInteger() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addChocolate("-5"));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}
	
	//Test addCoffee (Test #14)
	@Test
	public void testAddCoffee() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addCoffee("5");
		assertEquals(20, inventory.getCoffee());
	}
		
	//Test addCoffee with empty string (Test #15)
	@Test
	public void testAddCoffeeEmptyString() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addCoffee(""));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}	
		
	//Test addCoffee with letter (Test #16)
	@Test
	public void testAddCoffeeLetter() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addCoffee("g"));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}
		
	//Test addCoffee with special character (Test #17)
	@Test
	public void testAddCoffeeSpecialCharacter() throws InventoryException {
		Inventory inventory = new Inventory();			
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addCoffee("~"));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}	
	
	//Test addCoffee with negative integer (Test #18)
	@Test
	public void testAddCoffeeNegativeInteger() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addCoffee("-5"));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}

	//Test addMilk (Test #19)
	@Test
	public void testAddMilk() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addMilk("5");
		assertEquals(20, inventory.getMilk());
	}
			
	//Test addMilk with empty string (Test #20)
	@Test
	public void testAddMilkEmptyString() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addMilk(""));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}	
		
	//Test addMilk with letter (Test #21)
	@Test
	public void testAddMilkLetter() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addMilk("g"));
		assertEquals("Units of milk must be a positive integer", exception.getMessage());
	}
			
	//Test addMilk with special character (Test #22)
	@Test
	public void testAddMilkSpecialCharacter() throws InventoryException {
		Inventory inventory = new Inventory();			
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addMilk("~"));
		assertEquals("Units of milk must be a positive integer", exception.getMessage());
	}	
		
	//Test addMilk with negative integer (Test #23)
	@Test
	public void testAddMilkNegativeInteger() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addMilk("-5"));
		assertEquals("Units of milk must be a positive integer", exception.getMessage());
	}

	//Test addSugar (Test #24)
	@Test
	public void testAddSugar() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addSugar("5");
		assertEquals(20, inventory.getSugar());
	}
				
	//Test addSugar with empty string (Test #25)
	@Test
	public void testAddSugarEmptyString() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addSugar(""));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}	
			
	//Test addMilk with letter (Test #26)
	@Test
	public void testAddSugarLetter() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addSugar("g"));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}
				
	//Test addSugar with special character (Test #27)
	@Test
	public void testAddSugarSpecialCharacter() throws InventoryException {
		Inventory inventory = new Inventory();			
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addSugar("~"));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}	
			
	//Test addSugar with negative integer (Test #28)
	@Test
	public void testAddSugarNegativeInteger() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addSugar("-5"));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}	
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
