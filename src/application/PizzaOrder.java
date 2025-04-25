package application;

import java.util.Date;

//import project.PizzaOrder;

//THIS IS THE SUPER CLASS WITH COMPARABLE INTERFACE WHICH HAS A ONE METHOD NAMED "compareTo"
public class PizzaOrder implements Comparable<PizzaOrder>{
	private String customerName;
	private Date dateOrdered;
	
	private int pizzaSize;
	final static int SMALL=1;
	final static int MEDIUM=2;
	final static int LARGE=3;

	private int numberOfToppings;
	private double toppingPrice;
	
	//DEFAULT CONSTRUCTOR
	public PizzaOrder() {
		dateOrdered = new Date();
	}
	
	
	//NON DEFAULT CONSTRUCTOR TO INITIALIZE THE ATTRIBUTES
	public PizzaOrder(String customerName, int pizzaSize ,int numberOfToppings, double toppingPrice) {
		this.customerName = customerName;
		this.pizzaSize = pizzaSize;
		this.numberOfToppings = numberOfToppings;
		this.toppingPrice = toppingPrice;
		dateOrdered = new Date();
	}
	
	public int getPizzaSize() {
		return pizzaSize;
	}

	public void setPizzaSize(int pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getNumberOfToppings() {
		return numberOfToppings;
	}

	public void setNumberOfToppings(int numberOfToppings) {
		this.numberOfToppings = numberOfToppings;
	}

	public double getToppingPrice() {
		return toppingPrice;    
	}

	public void setToppingPrice(double toppingPrice) {
		this.toppingPrice = toppingPrice;
	}

	//A METHOD TO CALCULATE THE PRICE OF THE PIZZA ORDER
	public double calculateOrderPrice() {
		return ((getToppingPrice()*getNumberOfToppings())*getPizzaSize());
	}

	@Override //TOSTRING METHOD 
	public String toString() {
		
		/*TO CHECK THE SIZE AND PRINT IT AS A STRING
		 EX.: IF THE SIZE IS SMALL IT PRINTS "small" NOT (1)
		 */
		String stringPizzaSize = "";
		if(getPizzaSize() == PizzaOrder.SMALL)
			stringPizzaSize += "small";
		else if(getPizzaSize() == PizzaOrder.MEDIUM)
			stringPizzaSize += "medium";
		else stringPizzaSize += "large";
		
		return "Customer Name= " + getCustomerName() +
				"\nDate Ordered= " + dateOrdered +
				"\nPizza Size= " + stringPizzaSize + 
				"\nNumber Of Toppings= " + getNumberOfToppings() + 
				"\nTopping Price= " + Math.round(getToppingPrice());  //I USED MATH.round TO RETURN THE ORDER PRICE IN AN INTEGER TYPE EXACTLY AS THE SAMPLE RUN!!!
	}

	//METHOD FOR PRINTING SPECIFIC ATTRIBUTES
	public String OrderInfo() {
		return "Customer Name: "+ getCustomerName() +
				"    Order price: "+ Math.round(calculateOrderPrice()); //I USED MATH.round TO RETURN THE ORDER PRICE IN AN INTEGER TYPE EXACTLY AS THE SAMPLE RUN!!!
	}

	@Override  //IMPLEMINTING compareTo METHOD TO SORTING THE ORDERS DEPENDING ON THEIR ORDER PRICES 
	public int compareTo(PizzaOrder object) {
		if(calculateOrderPrice() > object.calculateOrderPrice())
			return 1;
		else if(calculateOrderPrice() < object.calculateOrderPrice())
			return -1;
		return 0;
	}
}