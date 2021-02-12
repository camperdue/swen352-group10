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
	
	//Test constructor for correct amount of initial chocolate
	@Test
	public void testCreation1() {
		Inventory inventory = new Inventory();
		assertEquals(15, inventory.getChocolate());
	}
	
	//Test constructor for correct amount of initial coffee
	@Test
	public void testCreation2() {
		Inventory inventory = new Inventory();
		assertEquals(15, inventory.getCoffee());
	}
	
	//Test constructor for correct amount of initial milk
	@Test
	public void testCreation3() {
		Inventory inventory = new Inventory();
		assertEquals(15, inventory.getMilk());
	}
	
	//Test constructor for correct amount of initial sugar
	@Test
	public void testCreation4() {
		Inventory inventory = new Inventory();
		assertEquals(15, inventory.getSugar());
	}
	
	//Test set coffee with input of 0
	@Test
	public void testSetCoffee1() {
		Inventory inventory = new Inventory();
		inventory.setCoffee(0);
		assertEquals(0, inventory.getCoffee());
	}
	
	//Test set coffee with negative integer input
	@Test
	public void testSetCoffee2() {
		Inventory inventory = new Inventory();
		inventory.setCoffee(-1);
		assertEquals(15, inventory.getCoffee());
	}
	
	//Test set coffee with proper integer input
	@Test
	public void testSetCoffee3() {
		Inventory inventory = new Inventory();
		inventory.setCoffee(30);
		assertEquals(30, inventory.getCoffee());
	}
	
	//Test set chocolate with input of 0
	@Test
	public void testSetChocolate1() {
		Inventory inventory = new Inventory();
		inventory.setChocolate(0);
		assertEquals(0, inventory.getChocolate());
	}
	
	//Test set chocolate with negative integer input
	@Test
	public void testSetChocolate2() {
		Inventory inventory = new Inventory();
		inventory.setChocolate(-1);
		assertEquals(15, inventory.getChocolate());
	}
	
	//Test set chocolate with proper integer input
	@Test
	public void testSetChocolate3() {
		Inventory inventory = new Inventory();
		inventory.setChocolate(30);
		assertEquals(30, inventory.getChocolate());
	}
	
	//Test set sugar with input of 0
	@Test
	public void testSetSugar1() {
		Inventory inventory = new Inventory();
		inventory.setSugar(0);
		assertEquals(0, inventory.getSugar());
	}
	
	//Test set sugar with negative integer input
	@Test
	public void testSetSugar2() {
		Inventory inventory = new Inventory();
		inventory.setSugar(-1);
		assertEquals(15, inventory.getSugar());
	}
	
	//Test set sugar proper integer input
	@Test
	public void testSetSugar3() {
		Inventory inventory = new Inventory();
		inventory.setSugar(30);
		assertEquals(30, inventory.getSugar());
	}
	
	//Test set milk with input of 0
	@Test
	public void testSetMilk1() { 
		Inventory inventory = new Inventory();
		inventory.setMilk(0);
		assertEquals(0, inventory.getMilk());
	}
	
	//Test set milk with negative integer input
	@Test
	public void testSetMilk2() {
		Inventory inventory = new Inventory();
		inventory.setMilk(-1);
		assertEquals(15, inventory.getMilk());
	}
	
	//Test set milk proper integer input
	@Test
	public void testSetMilk3() {
		Inventory inventory = new Inventory();
		inventory.setMilk(30);
		assertEquals(30, inventory.getMilk());
	}
	
	//Test enoughIngredients
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
	
	//Test enoughIngredients when not enough coffee
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
	
	//Test enoughIngredients when not enough milk
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
	
	//Test enoughIngredients when not enough sugar
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
	
	//Test enoughIngredients when not enough chocolate
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
	
	//Test useIngredients
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
	
	//Test useIngredients when not enough coffee
	@Test
	public void testUseIngredientsWhenNotEnoughCoffee() throws RecipeException {
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
	
	//Test useIngredients when not enough milk
	@Test
	public void testUseIngredientsWhenNotEnoughMilk() throws RecipeException {
		Inventory inventory = new Inventory();
		Recipe recipe = new Recipe();
		recipe.setName("recipe");
		recipe.setPrice("5");
		recipe.setAmtCoffee("2");
		recipe.setAmtMilk("20");
		recipe.setAmtSugar("1");
		recipe.setAmtChocolate("1");
		assertEquals(false, inventory.useIngredients(recipe));
	}
	
	//Test useIngredients when not enough sugar
	@Test
	public void testUseIngredientsWhenNotEnoughSugar() throws RecipeException {
		Inventory inventory = new Inventory();
		Recipe recipe = new Recipe();
		recipe.setName("recipe");
		recipe.setPrice("5");
		recipe.setAmtCoffee("2");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("20");
		recipe.setAmtChocolate("1");
		assertEquals(false, inventory.useIngredients(recipe));
	}	
	
	//Test useIngredients when not enough chocolate
	@Test
	public void testUseIngredientsWhenNotEnoughChocolate() throws RecipeException {
		Inventory inventory = new Inventory();
		Recipe recipe = new Recipe();
		recipe.setName("recipe");
		recipe.setPrice("5");
		recipe.setAmtCoffee("2");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setAmtChocolate("20");
		assertEquals(false, inventory.useIngredients(recipe));
	}
	
	@Test
	public void testCorrectCoffeeAfterUse() throws RecipeException {
		Inventory inventory = new Inventory();
		Recipe recipe = new Recipe();
		recipe.setName("recipe");
		recipe.setPrice("5");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setAmtChocolate("1");
		inventory.useIngredients(recipe);
		assertEquals(0, inventory.getCoffee());
	}
	
	@Test
	public void testCorrectMilkAfterUse() throws RecipeException {
		Inventory inventory = new Inventory();
		Recipe recipe = new Recipe();
		recipe.setName("recipe");
		recipe.setPrice("5");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setAmtChocolate("1");
		inventory.useIngredients(recipe);
		assertEquals(14, inventory.getMilk());
	}
	
	@Test
	public void testCorrectSugarAfterUse() throws RecipeException {
		Inventory inventory = new Inventory();
		Recipe recipe = new Recipe();
		recipe.setName("recipe");
		recipe.setPrice("5");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setAmtChocolate("1");
		inventory.useIngredients(recipe);
		assertEquals(14, inventory.getSugar());
	}
		
	@Test
	public void testCorrectCholateAfterUse() throws RecipeException {
		Inventory inventory = new Inventory();
		Recipe recipe = new Recipe();
		recipe.setName("recipe");
		recipe.setPrice("5");
		recipe.setAmtCoffee("15");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setAmtChocolate("1");
		inventory.useIngredients(recipe);
		assertEquals(14, inventory.getChocolate());
	}
	@Test
	public void testAddChocolate() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addChocolate("5");
		assertEquals(20, inventory.getChocolate());
	}
	
	@Test
	public void testAddChocolateEmptyString() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addChocolate(""));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}	
	
	@Test
	public void testAddChocolateLetter() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addChocolate("g"));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}
	
	@Test
	public void testAddChocolateSpecialCharacter() throws InventoryException {
		Inventory inventory = new Inventory();			
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addChocolate("~"));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}	
		
	@Test
	public void testAddChocolateNegativeInteger() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addChocolate("-5"));
		assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
	}
	
	@Test
	public void testAddCoffee() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addCoffee("5");
		assertEquals(20, inventory.getCoffee());
	}
		
	@Test
	public void testAddCoffeeEmptyString() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addCoffee(""));
		assertEquals("Units of coffee must be a positive integer", exception.getMessage());
	}	
		
	@Test
	public void testAddCoffeeLetter() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addCoffee("g"));
		assertEquals("Units of coffee must be a positive integer", exception.getMessage());
	}
		
	@Test
	public void testAddCoffeeSpecialCharacter() throws InventoryException {
		Inventory inventory = new Inventory();			
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addCoffee("~"));
		assertEquals("Units of coffee must be a positive integer", exception.getMessage());
	}	
	
	@Test
	public void testAddCoffeeNegativeInteger() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addCoffee("-5"));
		assertEquals("Units of coffee must be a positive integer", exception.getMessage());
	}

	@Test
	public void testAddMilk() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addMilk("5");
		assertEquals(20, inventory.getMilk());
	}
			
	@Test
	public void testAddMilkEmptyString() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addMilk(""));
		assertEquals("Units of milk must be a positive integer", exception.getMessage());
	}	
		
	@Test
	public void testAddMilkLetter() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addMilk("g"));
		assertEquals("Units of milk must be a positive integer", exception.getMessage());
	}
			
	@Test
	public void testAddMilkSpecialCharacter() throws InventoryException {
		Inventory inventory = new Inventory();			
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addMilk("~"));
		assertEquals("Units of milk must be a positive integer", exception.getMessage());
	}	
		
	@Test
	public void testAddMilkNegativeInteger() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addMilk("-5"));
		assertEquals("Units of milk must be a positive integer", exception.getMessage());
	}

	@Test
	public void testAddSugar() throws InventoryException {
		Inventory inventory = new Inventory();
		inventory.addSugar("5");
		assertEquals(20, inventory.getSugar());
	}
				
	@Test
	public void testAddSugarEmptyString() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addSugar(""));
		assertEquals("Units of sugar must be a positive integer", exception.getMessage());
	}	
			
	@Test
	public void testAddSugarLetter() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addSugar("g"));
		assertEquals("Units of sugar must be a positive integer", exception.getMessage());
	}
				
	@Test
	public void testAddSugarSpecialCharacter() throws InventoryException {
		Inventory inventory = new Inventory();			
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addSugar("~"));
		assertEquals("Units of sugar must be a positive integer", exception.getMessage());
	}	
			
	@Test
	public void testAddSugarNegativeInteger() throws InventoryException {
		Inventory inventory = new Inventory();
		Exception exception = assertThrows(InventoryException.class, () -> inventory.addSugar("-5"));
		assertEquals("Units of sugar must be a positive integer", exception.getMessage());
	}
	
	@Test
	public void testToString() {
		Inventory inventory = new Inventory();
		StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(15);
    	buf.append("\n");
    	String testString =  buf.toString();
    	assertEquals(testString, inventory.toString());
	}
	
	
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}