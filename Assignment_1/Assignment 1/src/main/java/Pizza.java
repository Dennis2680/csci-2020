/**
 * This assignment was to implement our desired pattern, me and my group chose
 * template pattern, this assignemnt shows a simple pizza maker, putting a template
 * in the main class, then having each other class, the meatlovers and veggie pizzza class
 * put their own toppings, to show understanding, we just made the main class have a
 * "Skeleton" and let the subclasses override the topping they want to top. This showcases the
 * fucntionality of template, and shows us the usfullness when we have classes with relating patterns.
 * Template pattern has showed me that I can save more time in writing code if i find relating patterns
 * in each class, forming a main class, so that i can keep adding as many subclasses I want, without having to worr
 * about each subclass and mainclas's formatting
 *
 * @author Vishwaajeeth Kamalakkannan , Zhi Quan (Dennis) Peng
 * @version 1.0
 */

public abstract class Pizza {

    boolean toppingBefore = false;
    // This is the Template Method, we should make this final so that the subclasses cannot, change it.
    final void makePizza(){
        formPizza();
        if(wantsCheese()){
            topCheese();
            // Helps with new lines
            toppingBefore = true;
        }

        if(wantsMeat()){
            if(toppingBefore) { System.out.print("\n"); }
            topMeat();
            toppingBefore = true;
        }

        if(wantsVegetables()){
            if(toppingBefore) { System.out.print("\n"); }
            topVegetables();
            toppingBefore = true;
        }
        bakePizza();
        servePizza();
    }

    // These methods should be overridden by the extending subclasses
    abstract void topCheese();
    abstract void topMeat();
    abstract void topVegetables();

    public void formPizza(){
        System.out.println("The Pizzaiolo is Forming The Pizza");
    }

    // The users have an option of overriding these, These are hooks
    // We used abstract above when we wanted to force the user to override
    // In this case it is optional so we used hooks
    boolean wantsCheese() { return true; }
    boolean wantsMeat() { return true; }
    boolean wantsVegetables() { return true; }
    public void bakePizza(){
        System.out.println("\nThe Pizza is Baking");

    }
    public void servePizza(){
        System.out.println("The Pizza is Being Served");
    }

}

