package coe528.parkinglot;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Interface and display board launched together
// Finish interface today and work on display board tomorrow

/**
 *
 * @author uzair
 */

public class Interface extends Application {
    Stage window;
    Scene scene1, scene2, scene3, customerScene, createTicket, createTicket2, createTicket3, payTicket, payTicket1, payTicket2, thankYou, editUser;

    /**
     *
     */
    public String userType;

    /**
     *
     */
    public int userFloor;

    /**
     *
     */
    public Ticket t;

    /**
     *
     */
    public Text Manager1,

    /**
     *
     */
    yourSpot;
    GridPane create3 = new GridPane();

    /**
     *
     */
    public double cost;

    /**
     *
     */
    public int z = 0,     

    /**
     *
     */
    r;     
    GridPane payEnd = new GridPane();

    /**
     *
     */
    public int n = 2;
    ParkingLot parkinglot;

    /**
     *
     */
    public int floor;

    /**
     *
     */
    public boolean maxed = true;
    
    //Assuming Parking System has 3 floors 
    //Assuming each parking lot has 5 parking spots on every floor.

    /**
     *
     * @param args
     */
    
    public static void main(String[] args) {
        launch(args);
    }
  
    //Use parameter parking Lot instead of Manager

    /**
     *
     * @param parking
     */
    
    public Interface(ParkingLot parking){
        this.parkinglot = parking;
    }
        
    /**
     *
     */
    public Interface(){
        //Creating new parking Lot with required specs
        parkinglot = new ParkingLot();
        
        parkinglot.mainLot.createFloor(1, 1, 1, 1, 1); 
        parkinglot.mainLot.createFloor(1, 1, 1, 1, 1); 
        parkinglot.mainLot.createFloor(1, 1, 1, 1, 1);
     }
    
    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        //Check if parking lot is maxed
        parkinglot.mainLot.floors.forEach(i->{
        i.spaces.forEach(b->{
            if(!b.get(0).isFull()){
                maxed = false;
            }
        });
        });
        
        
        //Display Boards made here
        Stage displayBoard1 = new Stage();
        
        Pane second= new Pane();    
        Scene displayBoard1Scene;
        boolean compact1 = parkinglot.mainLot.floors.get(0).getSpaces("compact").get(0).isFull();
        boolean large1 = parkinglot.mainLot.floors.get(0).getSpaces("large").get(0).isFull();
        boolean handicap1 = parkinglot.mainLot.floors.get(0).getSpaces("handicap").get(0).isFull();
        boolean motorcycle1 = parkinglot.mainLot.floors.get(0).getSpaces("motorcycle").get(0).isFull();
        boolean electric1 = parkinglot.mainLot.floors.get(0).getSpaces("electric").get(0).isFull();
        
        
        
        FileInputStream input = new FileInputStream("src/background1.JPG");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        second.getChildren().addAll(imageView);
        
        if(maxed){
        input = new FileInputStream("src/background1s.JPG");
        image = new Image(input);
        imageView = new ImageView(image);
        second.getChildren().addAll(imageView);
        }
        
        if(compact1){
        FileInputStream input1 = new FileInputStream("src/compact-car.png");
        Image image1 = new Image(input1);
        ImageView imageView1 = new ImageView(image1);
        imageView1.relocate(-20, -60);
        imageView1.scaleXProperty().set(0.5);
        imageView1.scaleYProperty().set(0.5);
        
        second.getChildren().addAll(imageView1);
        }
        if(large1){
        FileInputStream input2 = new FileInputStream("src/SUV-car.png");
        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);
        imageView2.relocate(270, -90);
        imageView2.scaleXProperty().set(0.6);
        imageView2.scaleYProperty().set(0.6);
        second.getChildren().addAll(imageView2);
        }
        if(handicap1){
        FileInputStream input3 = new FileInputStream("src/handicap-Car.png");
        Image image3 = new Image(input3);
        ImageView imageView3 = new ImageView(image3);
        imageView3.relocate(550, -60);
        imageView3.scaleXProperty().set(0.5);
        imageView3.scaleYProperty().set(0.5);
        second.getChildren().addAll(imageView3);
        }
        if(motorcycle1){
        FileInputStream input4 = new FileInputStream("src/motorcycle-.png");
        Image image4 = new Image(input4);
        ImageView imageView4 = new ImageView(image4);
        imageView4.relocate(740, 10);
        imageView4.scaleXProperty().set(0.3);
        imageView4.scaleYProperty().set(0.3);
        second.getChildren().addAll(imageView4);
        }
        if(electric1){
        FileInputStream input5 = new FileInputStream("src/eV-car.png");
        Image image5 = new Image(input5);
        ImageView imageView5 = new ImageView(image5);
        imageView5.relocate(1070, -10);
        imageView5.scaleXProperty().set(0.5);
        imageView5.scaleYProperty().set(0.5);
        second.getChildren().addAll(imageView5);
        }        
        displayBoard1Scene = new Scene(second, 1450, 850);
        displayBoard1.setScene(displayBoard1Scene);
        displayBoard1.show();
        
        Stage displayBoard2 = new Stage();
        
        Pane third = new Pane();   
        
        Scene displayBoard2Scene;
        
        compact1 = parkinglot.mainLot.floors.get(1).getSpaces("compact").get(0).isFull();
        large1 = parkinglot.mainLot.floors.get(1).getSpaces("large").get(0).isFull();
        handicap1 = parkinglot.mainLot.floors.get(1).getSpaces("handicap").get(0).isFull();
        motorcycle1 = parkinglot.mainLot.floors.get(1).getSpaces("motorcycle").get(0).isFull();
        electric1 = parkinglot.mainLot.floors.get(1).getSpaces("electric").get(0).isFull();        
        
        input = new FileInputStream("src/background2.JPG");
        image = new Image(input);
        imageView = new ImageView(image);
        third.getChildren().addAll(imageView);
        if(compact1){
        FileInputStream input1 = new FileInputStream("src/compact-car.png");
        Image image1 = new Image(input1);
        ImageView imageView1 = new ImageView(image1);
        imageView1.relocate(-20, -60);
        imageView1.scaleXProperty().set(0.5);
        imageView1.scaleYProperty().set(0.5);
        
        third.getChildren().addAll(imageView1);
        }
        if(large1){
        FileInputStream input2 = new FileInputStream("src/SUV-car.png");
        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);
        imageView2.relocate(270, -90);
        imageView2.scaleXProperty().set(0.6);
        imageView2.scaleYProperty().set(0.6);
        third.getChildren().addAll(imageView2);
        }
        if(handicap1){
        FileInputStream input3 = new FileInputStream("src/handicap-Car.png");
        Image image3 = new Image(input3);
        ImageView imageView3 = new ImageView(image3);
        imageView3.relocate(550, -60);
        imageView3.scaleXProperty().set(0.5);
        imageView3.scaleYProperty().set(0.5);
        third.getChildren().addAll(imageView3);
        }
        if(motorcycle1){
        FileInputStream input4 = new FileInputStream("src/motorcycle-.png");
        Image image4 = new Image(input4);
        ImageView imageView4 = new ImageView(image4);
        imageView4.relocate(740, 10);
        imageView4.scaleXProperty().set(0.3);
        imageView4.scaleYProperty().set(0.3);
        third.getChildren().addAll(imageView4);
        }
        if(electric1){
        FileInputStream input5 = new FileInputStream("src/eV-car.png");
        Image image5 = new Image(input5);
        ImageView imageView5 = new ImageView(image5);
        imageView5.relocate(1070, -10);
        imageView5.scaleXProperty().set(0.5);
        imageView5.scaleYProperty().set(0.5);
        third.getChildren().addAll(imageView5);
        }        
        
        displayBoard2Scene = new Scene(third, 1450, 850);
        displayBoard2.setScene(displayBoard2Scene);
        displayBoard2.show(); 
    
        Stage displayBoard3 = new Stage();
        Pane fourth = new Pane();    
        Scene displayBoard3Scene;
        
        compact1 = parkinglot.mainLot.floors.get(2).getSpaces("compact").get(0).isFull();
        large1 = parkinglot.mainLot.floors.get(2).getSpaces("large").get(0).isFull();
        handicap1 = parkinglot.mainLot.floors.get(2).getSpaces("handicap").get(0).isFull();
        motorcycle1 = parkinglot.mainLot.floors.get(2).getSpaces("motorcycle").get(0).isFull();
        electric1 = parkinglot.mainLot.floors.get(2).getSpaces("electric").get(0).isFull();        
        
        FileInputStream input2s = new FileInputStream("src/background3.JPG");
        image = new Image(input2s);
        imageView = new ImageView(image);
        fourth.getChildren().addAll(imageView);
        if(compact1){
        FileInputStream input1s = new FileInputStream("src/compact-car.png");
        Image image1 = new Image(input1s);
        ImageView imageView1 = new ImageView(image1);
        imageView1.relocate(-20, -60);
        imageView1.scaleXProperty().set(0.5);
        imageView1.scaleYProperty().set(0.5);
        
        fourth.getChildren().addAll(imageView1);
        }
        if(large1){
        FileInputStream input2 = new FileInputStream("src/SUV-car.png");
        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);
        imageView2.relocate(270, -90);
        imageView2.scaleXProperty().set(0.6);
        imageView2.scaleYProperty().set(0.6);
        fourth.getChildren().addAll(imageView2);
        }
        if(handicap1){
        FileInputStream input3 = new FileInputStream("src/handicap-Car.png");
        Image image3 = new Image(input3);
        ImageView imageView3 = new ImageView(image3);
        imageView3.relocate(550, -60);
        imageView3.scaleXProperty().set(0.5);
        imageView3.scaleYProperty().set(0.5);
        fourth.getChildren().addAll(imageView3);
        }
        if(motorcycle1){
        FileInputStream input4 = new FileInputStream("src/motorcycle-.png");
        Image image4 = new Image(input4);
        ImageView imageView4 = new ImageView(image4);
        imageView4.relocate(740, 10);
        imageView4.scaleXProperty().set(0.3);
        imageView4.scaleYProperty().set(0.3);
        fourth.getChildren().addAll(imageView4);
        }
        if(electric1){
        FileInputStream input5 = new FileInputStream("src/eV-car.png");
        Image image5 = new Image(input5);
        ImageView imageView5 = new ImageView(image5);
        imageView5.relocate(1070, -10);
        imageView5.scaleXProperty().set(0.5);
        imageView5.scaleYProperty().set(0.5);
        fourth.getChildren().addAll(imageView5);
        }        
        
        displayBoard3Scene = new Scene(fourth, 1450, 850);
        displayBoard3.setScene(displayBoard3Scene);
        displayBoard3.show(); 
        
        //Home Screen code 
        GridPane grid2 = new GridPane();
        GridPane s = new GridPane();
        s.setAlignment(Pos.CENTER);
        s.setVgap(10);
        s.setHgap(10);
        s.setPadding(new Insets(10));   
        
        if(maxed){
                 Label pw = new Label("Parking lot is currently at full capacity!");
                 s.add(pw, 0, 6);
        }
        
        Text welcomeTxt = new Text("Welcome.");
        welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        s.add(welcomeTxt, 0, 0);
        
        Label w = new Label("Are you a customer or a manager?");
        s.add(w, 0, 1);
      
        Button Customer = new Button("Customer");
        s.add(Customer, 0, 3);
        Customer.setOnAction(e->{
            window.setScene(customerScene);
        });
        
        Button Manager = new Button("Manager");
        s.add(Manager, 0, 4);
        Customer.setOnAction(e->{
            window.setScene(customerScene);
        });
        
        Manager.setOnAction(e -> window.setScene(scene2));
      
        scene1 = new Scene(s, 600, 600);
        
        //Layout for Manager Button
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
        
        Text welcome = new Text("Log In");
        welcome.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        grid.add(welcome, 0, 0);
        
        Label lblUser = new Label("Username");
        grid.add(lblUser, 0, 1);
        
        TextField txtUser = new TextField();
        txtUser.setPromptText("username");
        grid.add(txtUser, 1, 1);
 
        Label lblPass = new Label("Password");
        grid.add(lblPass, 0, 2);
        
        PasswordField pwBox = new PasswordField();
        pwBox.setPromptText("password");
        grid.add(pwBox, 1, 2);
        
        Label label3 = new Label("Error. Wrong password and/or username");
         
        Button loginBtn = new Button("Login");
        grid.add(loginBtn, 1, 3);
        loginBtn.setOnAction(e->{
            if(authenticate(txtUser, pwBox)){
                

        //They will look at the display and select floor and type from a comboBox whose answers will then be sent to the next scene
        
        parkinglot.mainLot.floors.forEach(i -> {
            if(i.getSpaces("compact").get(0).isFull()){     
                Label compact = new Label("Compact");
                grid2.add(compact, z, n); 
                n++;
            }
            if(i.getSpaces("large").get(0).isFull()){
                Label large = new Label("Large");
                grid2.add(large, z, n);
                n++;
            }            

            if(i.getSpaces("handicap").get(0).isFull()){
                Label handicap = new Label("Handicap");
                grid2.add(handicap, z, n);
                n++;
            }    
                    
            if(i.getSpaces("motorcycle").get(0).isFull()){
                Label motorcycle = new Label("Motorcycle");
                grid2.add(motorcycle, z, n);
                n++;
            }                    
            
            if(i.getSpaces("electric").get(0).isFull()){
                Label electric = new Label("Electric");
                grid2.add(electric, z, n);
            }     
      
                z++;
                n=2;
        });
            
 
            window.setScene(scene3);}
            z=0;
            grid.add(label3, 0, 5);
        });
        
        scene2 = new Scene(grid, 600, 600);
        

        Button cT = new Button("Create Ticket");
        grid2.add(cT, 0, 18);
        cT.setOnAction(e->{
                window.setScene(createTicket2);
        });        
        
        Button logout = new Button("Log Out");
        

        grid2.add( logout, 0, 19);
        logout.setOnAction(e->{
                window.close();
                displayBoard1.close();
                displayBoard2.close();
                displayBoard3.close();
                Platform.runLater(()-> {
                 try {
                 new Interface(parkinglot).start(new Stage());
                 
                 } catch (Exception ex) {
                     Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                 }
                }); 
        });
        
        Text sfloor = new Text("Select Floor: ");
        sfloor.setFont(Font.font("Tahoma", FontWeight.LIGHT, 13));
        grid2.add(sfloor, 0, 12);
        
        ComboBox<Integer> sFloor = new ComboBox<>();
        sFloor.getItems().addAll(
                1,
                2,
                3
        );
        
        grid2.add(sFloor, 1, 12);
        
        Button edit = new Button("Edit Selected Space");
        grid2.add(edit, 2, 12);
        
        edit.setOnAction(e->{
                window.setScene(editUser);
        });
        
        ComboBox<String> Nope = new ComboBox<>();
        Nope.getItems().addAll(
                "compact",
                "large",
                "handicap",
                "motorcycle",
                "electric"
        );
        
        
       
        grid2.add(Nope, 1, 14);  
        
        Text stype = new Text("Select Type: ");
        stype.setFont(Font.font("Tahoma", FontWeight.LIGHT, 13));
        grid2.add(stype, 0, 14);
        
        grid2.setAlignment(Pos.CENTER);
        grid2.setVgap(10);
        grid2.setHgap(10);
        grid2.setPadding(new Insets(10));
        
        Text welcome1 = new Text("Manager");
        welcome1.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        grid2.add(welcome1, 0, 0);
        
        Text floor1 = new Text("1st floor");
        floor1.setFont(Font.font("Tahoma", FontWeight.LIGHT, 18));
        grid2.add(floor1, 0, 1);
       
        Text floor2 = new Text("2nd floor   ");
        floor2.setFont(Font.font("Tahoma", FontWeight.LIGHT, 18));
        grid2.add(floor2, 1, 1);
        
        Text floor3 = new Text("3rd floor");
        floor3.setFont(Font.font("Tahoma", FontWeight.LIGHT, 18));
        grid2.add(floor3, 2, 1);
        

        
       
        scene3 = new Scene(grid2, 600, 600);
        
        GridPane cGrid = new GridPane();
        cGrid.setAlignment(Pos.CENTER);
        cGrid.setVgap(10);
        cGrid.setHgap(10);
        cGrid.setPadding(new Insets(10));    
        
        Manager1 = new Text("Compact vehicle"); 
        Manager1.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        cGrid.add(Manager1, 0, 0);
        
        Text nameChange = new Text("Change Parker Name");
        nameChange.setFont(Font.font("Tahoma", FontWeight.LIGHT, 13));
        cGrid.add(nameChange, 0, 2);
        
        TextField txt3 = new TextField();
        txt3.setPromptText("name");
        cGrid.add(txt3, 1, 2);  
        
        //Assuming if ticket is paid to parking attendent the person has left the lot
        Text Paid = new Text("Ticket Paid to Parking Attendent?");
        Paid.setFont(Font.font("Tahoma", FontWeight.LIGHT, 13));
        cGrid.add(Paid, 0, 3);
        
        ComboBox<String> changeType = new ComboBox<>();
        changeType.getItems().addAll(
                "Yes",
                "No"
        );
        
        cGrid.add(changeType, 1, 3);
        
        Button confirm = new Button("Confirm Changes");
        
        cGrid.add(confirm, 1, 7);
        confirm.setOnAction(e->{
                userType = Nope.getValue();
                userFloor = sFloor.getValue();
                Ticket user = parkinglot.mainLot.floors.get(userFloor-1).getSpaces(userType).get(0).user;
                if(changeType.getValue().equals("Yes")){
                parkinglot.mainLot.exit1.payForTicket(user, "cash"); //Assuming the user paid the attendent in Cash
                }
            
                parkinglot.mainLot.floors.get(userFloor-1).getSpaces(userType).get(0).user.customerName = txt3.getText();            
                
                window.close();
                displayBoard1.close();
                displayBoard2.close();
                displayBoard3.close();
                Platform.runLater(()-> {
                 try {
                 new Interface(parkinglot).start(new Stage());
                 
                 } catch (Exception ex) {
                     Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                 }
                }); 
                
        });
        
        Button delete = new Button("Delete Ticket");
       
        delete.setOnAction(e->{
                userType = Nope.getValue();
                userFloor = sFloor.getValue();
                
                Ticket user = parkinglot.mainLot.floors.get(userFloor-1).getSpaces(userType).get(0).user;

                parkinglot.mainLot.exit1.payForTicket(user, "cash"); //Assuming the user paid the attendent in Cash

               window.close();
               displayBoard1.close();
               displayBoard2.close();
               displayBoard3.close();
               Platform.runLater(()-> {
               try {
               new Interface(parkinglot).start(new Stage());
               }catch (Exception ex) {
                     Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
               }
            }); 
        });
        
        cGrid.add(delete, 0, 7);   
   
        
        editUser = new Scene(cGrid, 600, 600);  
                
      
        GridPane customerLanding = new GridPane();
        
        customerLanding.setAlignment(Pos.CENTER);
        customerLanding.setVgap(10);
        customerLanding.setHgap(10);
        customerLanding.setPadding(new Insets(10));     
        
        Text welcomeT = new Text("Welcome Customer");
        welcomeT.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        customerLanding.add(welcomeT, 0, 0);
  
        Label name = new Label("Please enter your name: ");
        customerLanding.add(name, 0, 1);
           
        TextField txt = new TextField();
        txt.setPromptText("name");
        customerLanding.add(txt, 0, 2);              
        
        
        Button CreateTicket = new Button("Create Ticket");
        customerLanding.add(CreateTicket, 0, 4);
        CreateTicket.setOnAction(e->{
                window.setScene(createTicket2);
        });
        
        Button PayTicket = new Button("Pay Ticket");
        customerLanding.add(PayTicket, 0, 5);
        PayTicket.setOnAction(e->{
                 window.setScene(payTicket);   
        });
        
        customerScene = new Scene(customerLanding, 600, 600);
 
        GridPane pay = new GridPane();
        pay.setAlignment(Pos.CENTER);
        pay.setVgap(10);
        pay.setHgap(10);
        pay.setPadding(new Insets(10));   
        
        Text welcome2= new Text("Welcome Customer");
        welcome2.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        pay.add(welcome2, 0, 0);
 
        Label park = new Label("Please select floor you parked your car on: ");
        pay.add(park, 0, 2);
  
        ComboBox<Integer> parked = new ComboBox<>();
        parked.getItems().addAll(
                1,
                2,
                3
        );
       
        pay.add(parked, 0, 3);
        
        Label type = new Label("Please select your car type: ");
        pay.add(type, 0, 4);
        
        ComboBox<String> None1 = new ComboBox<>();
        None1.getItems().addAll(
                "compact",
                "large",
                "handicap",
                "motorcycle",
                "electric"
        );
        
        pay.add(None1, 0, 5);  
        
        
        Label paym = new Label("Please select your payment method: ");
        pay.add(paym, 0, 6);
        
        ComboBox<String> Paym = new ComboBox<>();
        Paym.getItems().addAll(
                "cash",
                "card"
        );
        
        pay.add(Paym, 0, 7);        
        
        
        Button PayTicket1 = new Button("Pay Ticket");
        pay.add(PayTicket1, 0, 8);
        PayTicket1.setOnAction(e->{
            //Pay ticket here
            //Find ticket
            //Time spent is random for now
            
               Random rand= new Random();
               r = rand.nextInt(11)+1;

               Ticket user = parkinglot.mainLot.floors.get(parked.getValue()-1).getSpaces(None1.getValue()).get(0).user;
               parkinglot.mainLot.exit1.payForTicket(user, Paym.getValue());
               cost = user.calculateCost(r);
               
               Label pa = new Label("You have been charged " + cost + "$ for " + r + " hours.");
               payEnd.add(pa, 0, 2);
            
        
               user.space.setFull(false, user);
               
               window.setScene(payTicket1);         
        });
        
        payTicket = new Scene(pay, 600, 600);
        

        payEnd.setAlignment(Pos.CENTER);
        payEnd.setVgap(10);
        payEnd.setHgap(10);
        payEnd.setPadding(new Insets(10));   

        Text wel = new Text("Ticket Created");
        wel.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        payEnd.add(wel, 0, 0);
  
        
        Button ok1 = new Button("Done!");
        payEnd.add(ok1, 0, 4);
        
        ok1.setOnAction(e->{
                window.close();
                displayBoard1.close();
                displayBoard2.close();
                displayBoard3.close();
                Platform.runLater(()-> {
                 try {
                 new Interface(parkinglot).start(new Stage());
                 
                 } catch (Exception ex) {
                     Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                 }
                });                
        });
 
        
        payTicket1 = new Scene(payEnd, 600, 600);
        
        GridPane create2 = new GridPane();
        
        create2.setAlignment(Pos.CENTER);
        create2.setVgap(10);
        create2.setHgap(10);
        create2.setPadding(new Insets(10));

        ComboBox<String> None = new ComboBox<>();
        None.getItems().addAll(
                "compact",
                "large",
                "handicap",
                "motorcycle",
                "electric"
        );
        
        create2.add(None, 0, 2);  
        
        Text CreateText2 = new Text("Car Type?");
        CreateText2.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        create2.add(CreateText2, 0, 0);
        
        Button Submit2 = new Button("Create Ticket");
        
        create2.add(Submit2, 0, 3);
        Submit2.setOnAction(e->{
        final int index;
        int i;
        for (i = 0; i < 5;i++)
        {
            String p = None.getItems().get(i);
            if(p.equals(None.getValue())){
                break;
            }        
        }
        
        index = i;
        //Put a try catch here to catch any errors resulting from an overused spot or if a person doesn't enter a name
        try{
            t = parkinglot.mainLot.entrance1.createNewTicket(parkinglot.mainLot.entrance1.chooseAnEmptySpace(None.getValue()), txt.getText(), 0);
            floor = t.space.floor.id;
            
            yourSpot = new Text("Your parking spot has been generated on the " + None.getValue() + " spot of the floor " + floor);
                
            yourSpot.setFont(Font.font("Tahoma", FontWeight.LIGHT, 15));
            create3.add(yourSpot, 0, 2);
            window.setScene(createTicket3);
        }
        catch(Exception P){
             System.out.println("Ticket cannot be created due to full capacity!");
                window.close();
                displayBoard1.close();
                displayBoard2.close();
                displayBoard3.close();
                Platform.runLater(()-> {
                 try {
                 new Interface(parkinglot).start(new Stage());
                 
                 } catch (Exception ex) {
                     Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                 }
                });           
        }
        });
   
        
        createTicket2 = new Scene(create2, 600, 600);
        
        create3.setAlignment(Pos.CENTER);
        create3.setVgap(10);
        create3.setHgap(10);
        create3.setPadding(new Insets(10));
        
        Text Ticketcreated = new Text("Ticket created!");
        Ticketcreated.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        create3.add(Ticketcreated, 0, 0);
        
        
            
        Button Submit3 = new Button("Done");
        
        create3.add(Submit3, 0, 4);
        Submit3.setOnAction(e->{   
                window.close();
                displayBoard1.close();
                displayBoard2.close();
                displayBoard3.close();
                Platform.runLater(()-> {
                 try {
                 new Interface(parkinglot).start(new Stage());
                 } catch (Exception ex) {
                     Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                 }
                });             
        });
        
        
        createTicket3 = new Scene(create3, 600, 600);
        
        window.setScene(scene1);
        window.setTitle("ParkEz - Multi-Floor Parking Application");
        window.show();
    }
    
    /**
     *
     * @param user
     * @param pass
     * @return
     */
    public boolean authenticate(TextField user, PasswordField pass){ 
        //if returns true move to next scene
        if("admin".equals(user.getText())){
            if("admin".equals(pass.getText())){
                return true;
            }
        }
        return false;
    }
}

