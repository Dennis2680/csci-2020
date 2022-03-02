public class MeatLovers extends Pizza{
// Just the topping and final condiments used on the pizza
	String[] meatUsed = { "Pepperoni", "Bacon", "Sausage" };
	String[] cheeseUsed = { "Mozzarella " };
	String[] veggiesUsed = { "Onion", "Jalapeno", "Tomatos", "Sweet-Peppers" };

  
// these override the main class, the main classes structure does not
// get messed with due to these overrides.
    @Override
    public void topCheese(){		
		System.out.print("Adding Cheese: ");		
		for (String cheese : cheeseUsed){			
			System.out.print(cheese + " ");			
		}		
	}

    @Override	
	public void topMeat(){		
		System.out.print("Adding Meat: ");		
		for (String meat : meatUsed){			
			System.out.print(meat + " ");			
		}		
	}	

    @Override
	public void topVegetables(){		
		System.out.print("Adding Vegetables: ");		
		for (String vegetable : veggiesUsed){			
			System.out.print(vegetable + " ");			
		}		
	}
    	
}
	


	