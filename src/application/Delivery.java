package application;

//Name: Lana Mahmoud Ali Musaffer
//Id number: 1210455
//Lab section: 11

//import application.PizzaOrder;

//SUB CLASS
public class Delivery extends PizzaOrder{
	private double tripRate;
	private int zone;
	
	//DEFAULT CONSTRUCTOR
	public Delivery() {
	}
	
	//NON DEFAULT CONSTRUCTOR TO INITIALIZE THE ATTRIBUTES
	public Delivery(String customerName, int pizzaSize ,int numberOfToppings, double toppingPrice, double tripRate, int zone) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice); //TO ACCESS THE SUPER CLASS NON DEFAULT CONSTRUCTOR
		this.tripRate = tripRate;
		this.zone = zone;
	}

	public double getTripRate() {
		return tripRate;    
	}

	public void setTripRate(double tripRate) {
		this.tripRate = tripRate;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}

	@Override  //OVERRIDE THE calculateOrderPrice() IN THE SUPER CLASS(PizzaOrder) AND ADDS THE EXTRA PAYMENT FOR DELIVERING TO THE ORDER PRICE 
	public double calculateOrderPrice() {
		return ((super.getToppingPrice()*super.getNumberOfToppings())*super.getPizzaSize() + ((getTripRate()/100)*getZone()*super.calculateOrderPrice()));
	}
	
	@Override
	public String toString() {
		return super.toString() +  //OVERRIDE THE toString METHOD IN THE SUPER CLASS(PizzaOrder)
				"\nTrip Rate= " + Math.round(getTripRate()) + //I USED MATH.round TO RETURN THE ORDER PRICE IN AN INTEGER TYPE EXACTLY AS THE SAMPLE RUN!!!
				"\nZone= " + getZone() + 
				"\nOrder Price= " + Math.round(calculateOrderPrice());  //I USED MATH.round TO RETURN THE ORDER PRICE IN AN INTEGER TYPE EXACTLY AS THE SAMPLE RUN!!!
	}
}