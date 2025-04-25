package application;

//Name: Lana Mahmoud Ali Musaffer
//Id number: 1210455
//Lab section: 11
	
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	//METHOD WHICH CALCULATE THE SUM OF ALL ORDER PRICES
	static double calculateTotalOrdersPrice(ArrayList<PizzaOrder>orders) {
		double totalOrdersPrice = 0.0;
		for(PizzaOrder i: orders)
			totalOrdersPrice += i.calculateOrderPrice();
		return totalOrdersPrice;
	}
	
	@Override
	public void start(Stage primaryStage) {
		screen(primaryStage);
	
	}
	
	public void screen(Stage stage) {
		FlowPane pane = new FlowPane();
		pane.setPadding(new Insets(10, 25, 30, 40));  //The constructor Insets creates an Insets with the border sizes for top (10), right (25), bottom (30), and left (40) in pixels
		pane.setHgap(150); 
		pane.setVgap(15);
		
		//ENTER CUSTOMER NAME
		Label labelName = new Label("Customer Name"); 
		TextField tf = new TextField();
		//String customerName = tf.getText();   //GET THE STRING IN TEXTFIELD
		HBox box1 = new HBox(5);
		box1.getChildren().addAll(labelName, tf);
		
		//ENTER ORDER TYPE
		Label labelOrder = new Label("Order Type");
		//MAKE AN ARRAY OF STRINGS AND TURN IT INTO A COMBO BOX
		String [] selectOrderType = {"To Go", "Delivery", "Seated"};
		ObservableList<String> orders = FXCollections.observableArrayList(selectOrderType);
		ComboBox cb = new ComboBox<>(orders);
		cb.setValue("To Go");
		HBox box2 = new HBox(32);
		box2.getChildren().addAll(labelOrder, cb);

		
		//ENTER PIZZA SIZE
		Label labelSize = new Label("Pizze Size");
		RadioButton s = new RadioButton("small");
		s.setSelected(true);   //SMALL IS THE DEFAULT VALUE OF PIZZA SIZE
		RadioButton m = new RadioButton("medium");
		RadioButton l = new RadioButton("large");
		ToggleGroup group = new ToggleGroup();
		VBox box4 = new VBox(2);
		box4.getChildren().addAll(s, m, l);
		s.setToggleGroup(group);
		m.setToggleGroup(group);
		l.setToggleGroup(group);
		VBox box3 = new VBox(5);
		box3.getChildren().addAll(labelSize, box4);
		
		ArrayList<PizzaOrder> orders1 = new ArrayList<>(); 

		//LIST OF TOPPINGS
		Label labelToppings = new Label("List of Toppings");
		CheckBox c1 = new CheckBox("Onions");  
	    CheckBox c2 = new CheckBox("Olives");  
	    CheckBox c3 = new CheckBox("Green peppers");  
	    
	    HBox box5 = new HBox(20);  
	    box5.getChildren().addAll(c1,c2,c3); 
	    VBox box6 = new VBox(5);
	    box6.getChildren().addAll(labelToppings, box5);
	    
		Button enter = new Button("Enter");
		Label wait = new Label("Please hold on we're processing the order :)");
		HBox box = new HBox(10);
		box.getChildren().addAll(enter, wait);
	    

	    Label toppingPrice = new Label("Topping Price");
	    TextField toppingPriceText = new TextField("10");
	    if(Double.parseDouble(toppingPriceText.getText()) != 10) {
	    	toppingPriceText.getText();
	    }
	    else toppingPriceText.setText("10");

	    HBox box7 = new HBox(20);
	    box7.getChildren().addAll(toppingPrice, toppingPriceText);
	    
	    Label orderPrice = new Label("Order Price");
	    Label result = new Label("0.0");
	    HBox boxRes = new HBox(20);
	    boxRes.getChildren().addAll(orderPrice, result);
	    
	    Label tripRate = new Label("Trip Rate");
	    TextField tripRateText = new TextField();
	    HBox box8 = new HBox(20);
	    box8.getChildren().addAll(tripRate, tripRateText);
	    box8.managedProperty().bind(box8.visibleProperty());
	    
	    Label ZONE = new Label("Zone");
	    TextField ZONEText = new TextField();
	    HBox box9 = new HBox(20);
	    box9.getChildren().addAll(ZONE, ZONEText);
	    box9.managedProperty().bind(box9.visibleProperty());

	    
	    Label serviceCharge = new Label("Service Charge");
	    TextField serviceChargeText = new TextField();
	    HBox box10 = new HBox(20);
	    box10.getChildren().addAll(serviceCharge, serviceChargeText);
	    box10.managedProperty().bind(box10.visibleProperty());

	    
	    Label numOfPeople = new Label("Number of People");
	    TextField numOfPeopleText = new TextField();
	    HBox box11 = new HBox(20);
	    box11.getChildren().addAll(numOfPeople, numOfPeopleText);
	    box11.managedProperty().bind(box11.visibleProperty());
	    
	    //TO REMOVE THE UNNECEASARY FIELDS FROM THE SCREEN FOR EACH SELECT
	    enter.setOnAction(e->{
		    
		    if(cb.getValue().equals("To Go")) {
				    box8.setVisible(false);
				    box9.setVisible(false);
				    box10.setVisible(false);
				    box11.setVisible(false);
				}
				
				else if(cb.getValue().equals("Delivery")) {
					box8.setVisible(true);
				    box9.setVisible(true);
				    box10.setVisible(false);
				    box11.setVisible(false);	
				}
				
				else {
					box8.setVisible(false);
					box9.setVisible(false);
				    box10.setVisible(true);
				    box11.setVisible(true);
				}
	    });
	    
		//TO PRINT THE ORDER PRICE AFTER COLLECTING THE ORDER INFORMATIONS FROM THE USRE
		Button processOrder = new Button("Process Order");
		processOrder.setOnAction(e->{
			
			//TO GET THE PIZZA SIZE FROM USER'S SELECTION
			int size = 0;
		    if(s.isSelected())	size = 1;	
		    else if(m.isSelected()) size=2;
		    else size=3;
		    
		    
	       	int numberOfToppingsCB = 0;  	
	    	//TO INCREMENT THE NUMBER OF TOPPINGS WHEN THE USER SELECT ONE
		    if(c1.isSelected()) {
		    	numberOfToppingsCB++;
		    }
		    
		    else if(c2.isSelected()) {
		    	numberOfToppingsCB++;
		    }
		    
		    else numberOfToppingsCB++;
		    
		    
		    //SELECT PIZZA TYPE FROM COMBO BOX
		    if(cb.getValue().equals("To Go")) {
				orders1.add(new ToGo(tf.getText(), size, numberOfToppingsCB, Double.parseDouble(toppingPriceText.getText())));
				}
				
				else if(cb.getValue().equals("Delivery")) {
					orders1.add(new Delivery(tf.getText(), size, numberOfToppingsCB, Double.parseDouble(toppingPriceText.getText()), Double.parseDouble(tripRateText.getText()), Integer.parseInt(ZONEText.getText())));	
				}
				
				else {
					orders1.add(new Seated(String.valueOf(tf.getText()), size, numberOfToppingsCB, Double.parseDouble(toppingPriceText.getText()), Double.parseDouble(serviceChargeText.getText()), Integer.parseInt(numOfPeopleText.getText())));
				}

		    result.setText(String.valueOf(calculateTotalOrdersPrice(orders1)));

		});

		//PRINT ORDER INFORMATIONS
		Button printOrder = new Button("Print Order");
		printOrder.setOnAction(e->{
			Stage newStage = new Stage();
			FlowPane newPane = new FlowPane();
			newPane.setVgap(15);
			
			Collections.sort(orders1);  //SORTING THE ORDERS DEPENDING ON THEIR ORDER PRICES (IN ASCENDING ORDER)
			

			//A LOOP TO PRINT THE NAME OF TH CUSTOMER AND HER/HIS ORDER PRICE
			for(int i=0; i<orders1.size(); i++) {
				Label label1 = new Label(orders1.get(i).OrderInfo());
				newPane.getChildren().add(label1);

			}	
			Scene scene = new Scene(newPane, 300, 400);
			newStage.setScene(scene);
			newStage.show();			
		});

		//CLEAR ALL THE INFORMATIONS
		Button Reset = new Button("Reset");
		Reset.setOnAction(e->{
			toppingPriceText.setText("10");
			tf.clear();            //CLEAR THE TEXT IN THE CUSTOMER NAME TEXTFIELD
			s.setSelected(true);   //DEFAULT VALUE OF THE PIZZA SIZE IS SMALL
			cb.setValue("To Go");  //DEFAULT VALUE OF THE PIZZA TYPE IS TO GO
			//REMOVE THE CHECKS
			c1.setSelected(false);
			c2.setSelected(false);
			c3.setSelected(false);
			orders1.clear();       //CLEAR ALL THE INFORMATIONS
			//REMOVE THE LAST TEXTS FIELDS
		    box8.setVisible(false);
		    box8.setVisible(false);
		    box9.setVisible(false);
		    box10.setVisible(false);
		    box11.setVisible(false);
		});
		
		//CLOSE THE PROGRAM
		Button exit = new Button("Exit");
		exit.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e) {
				stage.close();
			}
		});
		
		HBox buttons = new HBox(30);
		buttons.getChildren().addAll(processOrder, printOrder, Reset, exit);
			
	    
		pane.getChildren().addAll(box1, box2, box3, box6, box, box7, box8, box9, box10, box11, boxRes, buttons);
		Scene scene = new Scene(pane, 400, 600);
		stage.setTitle("Pizza Order");
		stage.setScene(scene);	
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

