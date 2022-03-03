public class Pizzaiolo {

    public static void main(String[] args){
        // Makes new pizzas, based on what which pizza customer wants
        MeatLovers lrgPizza = new MeatLovers();
        lrgPizza.makePizza();
        // Just adds a space between each pizza creation
        System.out.println();
        Veggie lrgPizza2 = new Veggie();
        lrgPizza2.makePizza();

    }

}