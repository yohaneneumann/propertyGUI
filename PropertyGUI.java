/*Course: Higher Diploma in Computing (Full-time)
Module: Software Development + Testing
Teacher: Clare Doherty
Task: Assignment 1
Author: Yohane Gamiz Ancel Neumann
Student Number:L00157217
This code creates a GUI application to manage properties details*/

import javafx.application.Application;//Necessary to create a GUI application
import javafx.geometry.Pos;//Allows changes in the position of controls
import javafx.scene.Scene;//Manage the following controls
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;//Horizontal layout
import javafx.scene.layout.VBox;//Vertical layout
import javafx.stage.Stage;//Used to create and display a window
import javafx.event.ActionEvent;//Class used to allows a button to be clicked by the user
import java.util.ArrayList;//Used to store objects of the same type
import javafx.scene.control.Alert;//Class used to display an alert message
import javafx.scene.control.Alert.AlertType;//Used to choose the type of alert

public class PropertyGUI extends Application//Used to run the code as an application
{
   //Createa an ArrayList of the Property class
   ArrayList<Property> propList = new ArrayList<>();
      
   //Creates an object of Alert class
   Alert a = new Alert(AlertType.NONE);
   //Creating controls   
   TextField txtStreet;
   TextField txtTown;
   TextField txtCounty;
   TextField txtBeds;
   TextField txtReceptions;
   TextField txtBaths;
   TextField txtType;
   TextField txtPrice;
   TextField txtYears;
   TextField txtSalary;
   TextField txtPropertyNo;
   TextField txtPropertyNo2;
   TextField txtPropertyNo3;
   TextField txtPropertyNo4;
   Button btnAddProperty;
   Button btnDelProperty;
   Button btnDelProperty2;
   Button btnViewProperties;
   Button btnSearchType;
   Button btnSearchBedrooms;
   Button btnSearchPrice;
   Button btnCheckMort;
   Button btnCalc1;
   Button btnCalcRepay;
   Button btnCalc2;
   Button btnCalcTax;
   Button btnCalc3;
   Button btnReturn;
   Button btnReturn1;
   Button btnReturn2;
   Button btnReturn3;
   TextArea txtOutput;
   TextArea txtOutput1;
   TextArea txtOutput2;
   TextArea txtOutput3;
     
   public void start (Stage stage)//Required method that will allow the main container to appear + .show() method
   {
      //Creates Labels
      Label lblEnterDetails = new Label("| ENTER PROPERTY DETAILS |");
      Label lblStreet = new Label("Street:");
      Label lblTown = new Label("Town:");
      Label lblCounty = new Label("County:");
      Label lblBeds = new Label("Bedrooms:");
      Label lblReceptions = new Label("Receptions:");
      Label lblBaths = new Label("Bathrooms:");
      Label lblType = new Label("Type:");
      Label lblPrice = new Label("Price:");
      Label lblSearch = new Label("| SEARCH FOR A PROPERTY |");
      Label lblCalc = new Label("| CALCULATORS |");
      
      //Creates TextFields
      txtStreet = new TextField();
      txtStreet.setMaxWidth(100);
      txtTown = new TextField();
      txtTown.setMaxWidth(100);
      txtCounty = new TextField();
      txtCounty.setMaxWidth(100);
      txtBeds = new TextField();
      txtBeds.setMaxWidth(50);
      txtReceptions = new TextField();
      txtReceptions.setMaxWidth(50);
      txtBaths = new TextField();
      txtBaths.setMaxWidth(50);
      txtType = new TextField();
      txtType.setMaxWidth(100);
      txtPrice = new TextField();
      txtPrice.setMaxWidth(100);
      
      //Creates Buttons
      btnAddProperty = new Button("Add property");
      btnAddProperty.setOnAction(e -> addProperty(e));//Adds events to the buttons using Lambda expressions
      btnDelProperty = new Button("Delete property");
      btnViewProperties = new Button("View all properties");
      btnViewProperties.setOnAction(e -> viewProperties(e));
      btnSearchType = new Button("Search by type");
      btnSearchType.setOnAction(e -> searchType(e));
      btnSearchBedrooms = new Button("Search by number of bedrooms");
      btnSearchBedrooms.setOnAction(e-> searchBedrooms(e));
      btnSearchPrice = new Button("Search by maximum price");
      btnSearchPrice.setOnAction(e -> searchPrice(e));
      btnCheckMort = new Button("Check Mortgage Eligibility");
      btnCalcRepay = new Button("Calculate Monthly Repayments");
      btnCalcTax = new Button("Calculate Property Tax");
            
      //Creates TextArea for output
      txtOutput = new TextArea();
      txtOutput.setMaxSize(1000, 500);//Changes the size of TextArea
      txtOutput.setEditable(false);//Method that makes the text area uneditable
      
      //Creates HBoxes and adds all controls for input to it. It adds labels and TextFields across the screnn   
      HBox input1 = new HBox(10);
      input1.setAlignment(Pos.CENTER);//Method used to change the Alignment of the controls, which in this case is centered
      input1.getChildren().addAll(lblStreet, txtStreet, lblTown, txtTown, lblCounty, txtCounty);
      HBox input2 = new HBox(10);
      input2.setAlignment(Pos.CENTER);
      input2.getChildren().addAll(lblBeds, txtBeds, lblReceptions, txtReceptions, lblBaths, txtBaths, lblType, txtType, lblPrice, txtPrice);
      HBox input3 = new HBox(8);
      input3.setAlignment(Pos.CENTER);
      input3.getChildren().addAll(btnViewProperties, btnSearchBedrooms, btnSearchType, btnSearchPrice);
      HBox input3a = new HBox(8);
      input3a.setAlignment(Pos.CENTER);
      input3a.getChildren().addAll(btnAddProperty, btnDelProperty);
      HBox input4 = new HBox(8);
      input4.setAlignment(Pos.CENTER);
      input4.getChildren().addAll(btnCheckMort, btnCalcRepay, btnCalcTax);
      
      //Creates VBox and adds the HBoxes to it + other Labels + other buttons + TextArea
      VBox root = new VBox(20);
      root.setAlignment(Pos.CENTER);//Place the VBox in the center of the screen
      root.getChildren().addAll(lblEnterDetails, input1, input2, input3a, lblSearch, input3, txtOutput, lblCalc, input4);
      
      //Creates scene for main stage/window and adds VBox to it
      Scene scene = new Scene(root, 1100, 600);
      stage.setScene(scene);//Adds Scene to the Stage
      stage.setTitle("Property System");//Adds Title to the Stage
      stage.show();//Makes the stage and its contents visible 
      
      //Controls for 2nd scene(Check Mortgage Elegibility)
      Label lblPropertyNo = new Label("Property number: ");
      Label lblSalary = new Label("Annual salary €: ");
      txtPropertyNo = new TextField();
      txtPropertyNo.setMaxWidth(100);
      txtSalary = new TextField();
      txtSalary.setMaxWidth(100);
      btnCalc1 = new Button("Check elegibility for a mortage");
      btnReturn = new Button("Return");
      txtOutput1 = new TextArea();
      txtOutput1.setMaxSize(300, 90);
      txtOutput1.setEditable(false);//Method that makes the text area uneditable
      HBox box1 = new HBox(10);
      box1.setAlignment(Pos.CENTER);
      box1.getChildren().addAll(lblPropertyNo, txtPropertyNo, lblSalary, txtSalary);
      VBox root1 = new VBox(30);
      root1.setAlignment(Pos.CENTER);
      root1.getChildren().addAll(box1, btnCalc1, txtOutput1, btnReturn);
      
      //Creates 2nd scene
      Scene scene2 = new Scene(root1, 1100, 600);
      btnCheckMort.setOnAction(e-> stage.setScene(scene2));
      btnCalc1.setOnAction(e -> checkMortgage(e));
      btnReturn.setOnAction(e -> stage.setScene(scene));
      
      //Controls for 3rd scene(Calculate Monthly Repayments)
      Label lblPropertyNo2 = new Label ("Property number: ");
      txtPropertyNo2 = new TextField();
      txtPropertyNo2.setMaxWidth(100);
      Label lblYears = new Label("Number of years: ");
      txtYears = new TextField();
      txtYears.setMaxWidth(50);
      btnCalc2 = new Button("Calculate Monthly Repayments");
      btnReturn1 = new Button("Return");
      txtOutput2 = new TextArea();
      txtOutput2.setMaxSize(400, 100);
      txtOutput2.setEditable(false);//Method that makes the text area uneditable
      HBox box01 = new HBox(10);
      box01.setAlignment(Pos.CENTER);
      box01.getChildren().addAll(lblPropertyNo2, txtPropertyNo2, lblYears, txtYears);
      VBox root2 = new VBox(30);
      root2.setAlignment(Pos.CENTER);
      root2.getChildren().addAll(box01, btnCalc2, txtOutput2, btnReturn1);
      
      //Creates 3rd scene
      Scene scene3 = new Scene(root2, 1100, 600);
      btnCalcRepay.setOnAction(e-> stage.setScene(scene3));
      btnCalc2.setOnAction(e -> calcRepayments(e));
      btnReturn1.setOnAction(e -> stage.setScene(scene));

      //Controls for 4th scene(Calculate Property Tax)
      Label lblPropertyNo3 = new Label ("Property number: ");
      txtPropertyNo3 = new TextField();
      txtPropertyNo3.setMaxWidth(100);
      btnCalc3 = new Button("Calculate Property Tax");
      btnReturn2 = new Button("Return");
      txtOutput3 = new TextArea();
      txtOutput3.setMaxSize(300, 100);
      txtOutput3.setEditable(false);//Method that makes the text area uneditable
      HBox box001 = new HBox(10);
      box001.setAlignment(Pos.CENTER);
      box001.getChildren().addAll(lblPropertyNo3, txtPropertyNo3);
      VBox root3 = new VBox(30);
      root3.setAlignment(Pos.CENTER);
      root3.getChildren().addAll(box001, btnCalc3, txtOutput3, btnReturn2);
      
      //Creates 3rd scene
      Scene scene4 = new Scene(root3, 1100, 600);
      btnCalcTax.setOnAction(e-> stage.setScene(scene4));
      btnCalc3.setOnAction(e -> calcTax(e));
      btnReturn2.setOnAction(e -> stage.setScene(scene));
      
      //Controls for 4th scene
      Label lblPropertyNo4 = new Label ("Property number: ");
      txtPropertyNo4 = new TextField();
      txtPropertyNo4.setMaxWidth(100);
      btnDelProperty2 = new Button("Delete Property");
      btnReturn3 = new Button("Return");
      HBox box0001 = new HBox(10);
      box0001.setAlignment(Pos.CENTER);
      box0001.getChildren().addAll(lblPropertyNo4, txtPropertyNo4);
      VBox root4 = new VBox(30);
      root4.setAlignment(Pos.CENTER);
      root4.getChildren().addAll(box0001, btnDelProperty2, btnReturn3);
      
      //Creates 4th scene
      Scene scene5 = new Scene(root4, 1100, 600);
      btnDelProperty.setOnAction(e-> stage.setScene(scene5));
      btnDelProperty2.setOnAction(e -> deleteProperty(e));
      btnReturn3.setOnAction(e -> stage.setScene(scene));
      
   }//Close start method
   
   //Method to add Properties
   public void addProperty(ActionEvent e)//Parameter to accept the argument and pass it down
   {
      try//Runs code that could cause an exception
      {
         //Check whether the user entered values to all TextFields
         if(txtStreet.getText().isEmpty() || txtTown.getText().isEmpty() || txtCounty.getText().isEmpty() || txtBeds.getText().isEmpty() || txtReceptions.getText().isEmpty() || txtBaths.getText().isEmpty() || txtType.getText().isEmpty() || txtPrice.getText().isEmpty())
         {
            a.setAlertType(AlertType.ERROR);//Sets an error alert
            a.setContentText("YOU MUST ENTER VALUES IN ALL FIELDS");//It displays an error message in case the user does not enter values in all TextFields
            a.show();//Makes the error alert visible 
         }
         else
         {
            String street = txtStreet.getText();//Getting value from TextField. It is a String, so it does not need to parse
            String town = txtTown.getText();
            String county = txtCounty.getText();
            int noBeds = Integer.parseInt(txtBeds.getText());//Parse allows to get different values than String from the TextFields
            int noReceptions = Integer.parseInt(txtReceptions.getText());
            int noBaths = Integer.parseInt(txtBaths.getText());
            String type = txtType.getText();
            double price = Double.parseDouble(txtPrice.getText());
            
            //Creates object and add it to ArrayList propList
            propList.add(new Property(street, town, county, noBeds, noBaths, noReceptions, price, type));//Taking all the values from the text field and adding to arraylist
            a.setAlertType(AlertType.INFORMATION);//Sets an information alert
            a.setContentText("PROPERTY SUCCESSFULLY ADDED");//Displays an information message after the user added a property
            a.show();//Makes the information alert visible
         }//Close else
      }//Close try
      //Action to be taken if the exception occurs in the try block
      catch(NumberFormatException ex)//Type of exception that has occurred and name of the object that is created
      {
         a.setAlertType(AlertType.ERROR);//Sets an error alert
         a.setContentText(" BEDS, BATHS, RECEPTIONS AND PRICE \n  MUST CONTAIN ONLY NUMBERS");//it display an error message in case the user enter an parameter different than expected
         a.show();//Makes the error alert visible
      }
      catch(IllegalArgumentException ex)
      {
         a.setAlertType(AlertType.ERROR);//Sets an error alert
         a.setContentText(" YOU MUST ENTER POSITIVE VALUES IN ALL FIELDS");//It displays an error message in case the user enters 0 or a negative value
         a.show();//Makes the error alert visible
      }//Close catch
   
      //Clears the TextFields
      txtStreet.clear();
      txtTown.clear();
      txtCounty.clear();
      txtBeds.clear();
      txtReceptions.clear();
      txtBaths.clear();
      txtType.clear();
      txtPrice.clear();      
           
   }//Close method addProperties
   
   //Method to delete property from the system
   public void deleteProperty(ActionEvent e)
   {
      try
      {
         if(txtPropertyNo4.getText().isEmpty())//Checks if the TextField is not empty
         {
            a.setAlertType(AlertType.ERROR);//Sets an error alert
            a.setContentText("PLEASE ENTER A PROPERTY NUMBER");//It displays an error message in case the user does not entered any value for type
            a.show();//Makes the error alert visible
         }
         else
         {
            //Get property type from user
            int propertyNo = Integer.parseInt(txtPropertyNo4.getText());
            //Searches entire arraylist
            boolean isFound = false;//boolean flag
            for(int i = 0; i < propList.size(); i++)
            {
               if(Integer.parseInt(txtPropertyNo4.getText()) == propList.get(i).getPropertyNo()) //.equals for string values and IgnoreCase to get lower and capital letters
               {
                  propList.remove(i);
                  a.setAlertType(AlertType.INFORMATION);//Sets an error alert
                  a.setContentText("PROPERTY SUCCESSFULLY DELETED FROM THE SYSTEM");//It displays an error message in case there is no match for user's search
                  a.show();//Makes the error alert visible
                  isFound = true;
               }
            }//Close for
         if(isFound == false)//It must be out of the for loop, otherwise it will create an infinite loop
         {
               a.setAlertType(AlertType.ERROR);//Sets an error alert
               a.setContentText("NO PROPERTY WAS FOUND MATCHING THIS TYPE");//It displays an error message in case there is no match for user's search
               a.show();//Makes the error alert visible
            }//Close if
         }//Close else
      }//Close try
      catch(IllegalArgumentException ex)
      {
         a.setAlertType(AlertType.ERROR);//Sets an error alert
         a.setContentText("YOU MUST ENTER A VALID PROPERTY NUMBER");//It displays an error message in case the user enters 0 or a negative value
         a.show();//Makes the error alert visible
      }//Close catch
      
      //Clears the TextField
      txtPropertyNo4.clear();
      
   }//Close method deleteProperty
   
   
   //Method to view all property details
   public void viewProperties(ActionEvent e)
   {
      //Clears TextArea
      txtOutput.clear();
      for(Property  prop: propList)//For every object in the array list called propList in the Property class
      {
         txtOutput.appendText(prop +"\n" );// \n to put each property on separate line  
      }
   }//Close method viewProperties
   
   //Method to search by type
   public void searchType(ActionEvent e)
   {
      //Clears TextArea
      txtOutput.clear();
      //Check whether the user entered values to all TextFields
      if(txtType.getText().isEmpty())
      {
         a.setAlertType(AlertType.ERROR);//Sets an error alert
         a.setContentText("PLEASE ENTER PROPERTY TYPE");//It displays an error message in case the user does not entered any value for type
         a.show();//Makes the error alert visible
      }
      else
      {
         //Gets property type from user
         String searchType = txtType.getText();
         //Searches entire arraylist
         boolean isFound = false; //boolean flag
         for(int i = 0; i < propList.size(); i++)
         { 
            if(searchType.equalsIgnoreCase(propList.get(i).type())) //.equals for string values and IgnoreCase to get lower and capital letters
            {
               txtOutput.appendText(propList.get(i) + "\n");//Append because it might have same values
               isFound = true;
            }
         }//Close for
         if(isFound == false)//It must be out of the for loop, otherwise it will create an infinite loop
         {
            a.setAlertType(AlertType.ERROR);//Sets an error alert
            a.setContentText("NO PROPERTY WAS FOUND MATCHING THIS TYPE");//It displays an error message in case there is no match for user's search
            a.show();//Makes the error alert visible
         }//Close if
      }//Close else
      
      //Clears the TextField
      txtType.clear();
      
   }//Close method searchType
   
   //Method to search by number of bedrooms
   public void searchBedrooms(ActionEvent e)
   {
      //Clears TextArea
      txtOutput.clear();
      try
      {
         //Checks whether the user entered values to all TextFields
         if(txtBeds.getText().isEmpty())
         {
            a.setAlertType(AlertType.ERROR);//Sets an error alert
            a.setContentText("PLEASE ENTER NUMBER OF BEDROOMS");//It displays an error message in case the user does not entered any value for bedrooms
            a.show();//Makes the error alert visible
         }
         else
         {
            //Gets number of bedrooms from user
            int searchBedrooms = Integer.parseInt(txtBeds.getText());
            //Searchs entire arraylist
            boolean isFound = false; //boolean flag
            for(int i = 0; i < propList.size(); i++)
            { 
               if(searchBedrooms == propList.get(i).beds())
               {
                  txtOutput.appendText(propList.get(i) + "\n");//Append because it might have same values
                  isFound = true;
               }
            }//Close for
            if(isFound == false)//It must be out of the for loop, otherwise it will create an infinite loop
            {
               a.setAlertType(AlertType.ERROR);//Sets an error alert
               a.setContentText("NO PROPERTY WAS FOUND MATCHING THIS CRITERIA");//It displays an error message in case there is no matching values
               a.show();//Makes the error alert visible
            }
         }//Close else
      }//Close try
      catch(IllegalArgumentException ex)
      {
         a.setAlertType(AlertType.ERROR);//Sets an error alert
         a.setContentText("NO PROPERTY WAS FOUND MATCHING THIS CRITERIA");//It displays an error message in case the user enters 0 or a negative value
         a.show();//Makes the error alert visible
      }//Close catch
      //Clears the TextField
      txtBeds.clear();
         
   }//Close method searchBedrooms
   
   //Method to search by price
   public void searchPrice(ActionEvent e)
   {
      //Clears TextArea
      txtOutput.clear();
      try
      {
         //Checks whether the user entered values to all TextFields
         if(txtPrice.getText().isEmpty())
         {
            a.setAlertType(AlertType.ERROR);//Sets an error alert
            a.setContentText("PLEASE ENTER PROPERTY PRICE");//It displays an error message in case the user does not entered any value for price
            a.show();//Makes the error alert visible
         }
         else
         {
            int price = Integer.parseInt(txtPrice.getText());
            boolean isFound = false; //boolean flag
            for(int i = 0; i < propList.size(); i++)
            {
               if(propList.get(i).viewPrice() <= price)
               {
                  txtOutput.appendText(propList.get(i) + "\n");
                  isFound = true;
               }
            }//Close for
            if(isFound == false)//It must be out of the for loop, otherwise it will create an infinite loop
            {
               a.setAlertType(AlertType.ERROR);//Sets an error alert
               a.setContentText("NO PROPERTY WAS FOUND MATCHING THIS PRICE RANGE");//It displays an error message in case there is no match for price range
               a.show();//Makes the error alert visible
            }//Close if
         }//Close else
      }//Close try
      catch(IllegalArgumentException ex)
      {
         a.setAlertType(AlertType.ERROR);//Sets an error alert
         a.setContentText("NO PROPERTY WAS FOUND MATCHING THIS CRITERIA");//It displays an error message in case the user enters 0 or a negative value
         a.show();//Makes the error alert visible
      }//Close catch
      //Clears the TextField
      txtPrice.clear();
      
   }//Close method search Price
   
   //Method to check mortage elegibility
   public void checkMortgage(ActionEvent e)//Parameter to accept the argument and pass it down
   {
      //Clears TextArea
      txtOutput1.clear();
      try
      {
         //Checks whether the user entered values to all TextFields
         if(txtPropertyNo.getText().isEmpty() || txtSalary.getText().isEmpty())
         {
            a.setAlertType(AlertType.ERROR);//Sets an error alert
            a.setContentText("YOU MUST ENTER VALUES IN ALL FIELDS");//It displays an error message in case the user does not enter values in all TextFiels
            a.show();//Makes the error alert visible 
         }
         else
         {
            //User enters propertyNo for the property they wish to check the mortgage availability for
            int propertyNo = Integer.parseInt(txtPropertyNo.getText());
            //Gets the user annual salary
            double salary = Double.parseDouble(txtSalary.getText());
            //Searches Arraylist to check if propertyNo entered above exists in Arraylist
            for(int i= 0; i < propList.size(); i++)
            {
               if(propertyNo == propList.get(i).getPropertyNo())//If match if found
               {
                  //Call on checkMortgage method and pass across value from TextField
                  //This method will also return and display the mortgage elegibility
                  txtOutput1.setText(propList.get(i).checkMortgage(salary));
               }
               else
               {
                  a.setAlertType(AlertType.ERROR);//Sets an error alert
                  a.setContentText("YOU MUST ENTER A VALID PROPERTY NUMBER");//It displays an error message in case the user does not enter values in all TextFiels
                  a.show();//Makes the error alert visible 
               }
            }//Close for
         }//Close else
      }//Close try
      catch(IllegalArgumentException ex)
      {
         a.setAlertType(AlertType.ERROR);//Sets an error alert
         a.setContentText("YOU MUST ENTER ONLY POSITIVE NUMBERS IN BOTH FIELDS");//It displays an error message in case the user enters 0 or a negative value
         a.show();//Makes the error alert visible
      }//Close catch
      
      //Clears the TextFields
      txtPropertyNo.clear();
      txtSalary.clear();
   
   }//Close method checkMortgage
   
   //Method to calculate monthly repayments
   public void calcRepayments(ActionEvent e)//Parameter to accept the argument and pass it down
   {
      //Clears TextArea
      txtOutput2.clear();
      try
      {
         //Check whether the user entered values to all TextFields
         if(txtPropertyNo2.getText().isEmpty() || txtYears.getText().isEmpty())
         {
            a.setAlertType(AlertType.ERROR);//Sets an error alert
            a.setContentText("YOU MUST ENTER VALUES IN ALL FIELDS");//It displays an error message in case the user does not enter values in all TextFiels
            a.show();//Makes the error alert visible 
         }
         else
         {
            //User enters propertyNo for the property they wish to calculate the monthly repayments
            int propertyNo2 = Integer.parseInt(txtPropertyNo2.getText());
            //Gets years from user
            int years = Integer.parseInt(txtYears.getText());
            //Searches Arraylist to check if propertyNo entered above exists in Arraylist
            for(int i= 0; i < propList.size(); i++)
            {
               if(propertyNo2 == propList.get(i).getPropertyNo() && Integer.parseInt(txtYears.getText()) < 25)//if match is found
               {
                  //Call on  method and pass across value from TextField
                  //This method will also return and display the monthly repayments
                  txtOutput2.setText("The value for the monthly repayments is €: " +propList.get(i).monthlyRepay(years));
               }
               else
               {
                  a.setAlertType(AlertType.ERROR);//Sets an error alert
                  a.setContentText("YOU MUST ENTER A VALID PROPERTY NUMBER \n    AND A MAXIMUM OF 25 YEARS");//It displays an error message in case the user does not enter values in all TextFiels
                  a.show();//Makes the error alert visible 
               }
            }//Close for
         }//Close else
      }//Close try
      //Action to be taken if the exception occurs in the try block
      catch(IllegalArgumentException ex)
      {
         a.setAlertType(AlertType.ERROR);//Sets an error alert
         a.setContentText("YOU MUST ENTER ONLY NUMBERS IN BOTH FIELDS");//It displays an error message in case the user enters 0 or a negative value
         a.show();//Makes the error alert visible
      }//Close catch
      
      //Clears the TextFields
      txtPropertyNo2.clear();
      txtYears.clear();
   
   }//Close method calcRepayments
   
   //Method to calculate property tax
   public void calcTax(ActionEvent e)//Parameter to accept the argument and pass it down
   {
      //Clears TextArea
      txtOutput3.clear();
      try//Runs code that could cause an exception
      {
         //Checks whether the user entered values to all TextFields
         if(txtPropertyNo3.getText().isEmpty())
         {
            a.setAlertType(AlertType.ERROR);//Sets an error alert
            a.setContentText("YOU MUST ENTER A VALUE");//It displays an error message in case the user does not enter values in all TextFiels
            a.show();//Makes the error alert visible 
         }
         else
         {
            //User enters propertyNo for the property they wish to calculate property tax
            int propertyNo3 = Integer.parseInt(txtPropertyNo3.getText());
            //Searches Arraylist to check if propertyNo entered above exists in Arraylist
            for(int i= 0; i < propList.size(); i++)
            {
               if(propertyNo3 == propList.get(i).getPropertyNo())//If a match is found, display a message
               {
                  //Call on  method and pass across value from TextField
                  //This method will also return and display the property tax
                  txtOutput3.setText("The value for the property tax is €: " +propList.get(i).propertyTax());
               }//Close if
               else
               {
                  a.setAlertType(AlertType.ERROR);//Sets an error alert
                  a.setContentText("YOU MUST ENTER A VALID PROPERTY NUMBER");//It displays an error message in case the user does not enter values in all TextFiels
                  a.show();//Makes the error alert visible 
               }
            }//Close for
         }//Close else
      }//Close try
      catch(IllegalArgumentException ex)
      {
         a.setAlertType(AlertType.ERROR);//Sets an error alert
         a.setContentText("YOU MUST ENTER ONLY NUMBERS");//It displays an error message in case the user enters 0 or a negative value
         a.show();//Makes the error alert visible
      }//Close catch
      //Clears the TextField
      txtPropertyNo3.clear();
   
   }//Close method calcTax
           
   public static void main(String []args)//The main method allows the program to run
   {
      launch(args);//Calls the Application’s launch method and passes to it any arguments it receives itself 
   }
}//Close application