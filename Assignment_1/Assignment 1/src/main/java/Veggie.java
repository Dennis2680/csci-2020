public class Veggie extends Pizza{
    // Just the topping and final condiments used on the pizza
    String[] cheeseUsed = { "Mozzarella " };
    String[] veggiesUsed = { "Onion", "Jalapeno", "Tomatoes", "Sweet-Peppers" };

    // We are saying here that the customer does not want meat on their pizza
    boolean wantsMeat() { return false; }

    /*these override the main class, the main classes structure does not
    get messed due to these overrides.*/
    @Override
    public void topCheese(){
        System.out.print("Adding Cheese: ");
        for (String cheese : cheeseUsed){
            System.out.print(cheese + " ");
        }
    }
    // since this is a mandatory override in the main class, we have to include the topMeat section method as blank.
    @Override
    public void topMeat(){

    }

    @Override
    public void topVegetables(){
        System.out.print("Adding Vegetables: ");
        for (String vegetable : veggiesUsed){
            System.out.print(vegetable + " ");
        }
    }



}