package application;

//Name: Lana Mahmoud Ali Musaffer
//Id number: 1210455
//Lab section: 11


//SUB CLASS
public class ToGo extends PizzaOrder {
	
	//DEFAULT CONSTRUCTOR
	public ToGo() {
		
	}

	//NON DEFAULT CONSTRUCTOR 
	public ToGo(String customerName, int pizzaSize ,int numberOfToppings, double toppingPrice) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice); //TO ACCESS THE SUPER CLASS NON DEFAULT CONSTRUCTOR
	}
}
