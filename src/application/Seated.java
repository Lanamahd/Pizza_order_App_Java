package application;

//import project.PizzaOrder;

//Name: Lana Mahmoud Ali Musaffer
//Id number: 1210455
//Lab section: 11

//SUB CLASS
public class Seated extends PizzaOrder {
	private double serviceCharge;
	private int numberOfPeople;
	
	//DEFAULT CONSTRUCTOR
	public Seated() {
	}
	
	//NON DEFAULT CONSTRUCTOR TO INITIALIZE THE ATTRIBUTES
	public Seated(String customerName, int pizzaSize ,int numberOfToppings, double toppingPrice, double serviceCharge, int numberOfPeople) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
		super.calculateOrderPrice();
		this.serviceCharge = serviceCharge;
		this.numberOfPeople = numberOfPeople;
	}
	
	public double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	@Override //OVERRIDE THE calculateOrderPrice() IN THE SUPER CLASS(PizzaOrder) AND ADDS THE EXTRA PAYMENT FOR THE SERVICE TO THE ORDER PRICE
	public double calculateOrderPrice() {
		return ((super.getToppingPrice()*super.getNumberOfToppings())*super.getPizzaSize() + (getServiceCharge()*getNumberOfPeople()));
	}

	@Override
	public String toString() {
		return super.toString() + //OVERRIDE THE toString METHOD IN THE SUPER CLASS(PizzaOrder)
				"Service Charge= " + getServiceCharge() + 
				"\nNumber Of People= " + getNumberOfPeople();
	}
}