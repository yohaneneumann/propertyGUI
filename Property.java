/*Course: Higher Diploma in Computing (Full-time)
Module: Software Development + Testing
Teacher: Clare Doherty
Task: Assignment 1
Author: Yohane Gamiz Ancel Neumann
Student Number:L00157217
This code generates a Property class to handle the details for the PropertyGUI*/
public class Property
{
   private int propertyNo;
   private String street;
   private String town;
   private String county;
   private int noBeds;
   private int noBaths;
   private int noReception;
   private double price;
   private String type;
   private static int nextPropertyNo = 100;
   
   //Constructors
   //User default constructor
   public Property()
   {
      propertyNo = nextPropertyNo++;
      street = "";
      town = "";
      county = "";
      noBeds = 0;
      noBaths = 0;;
      noReception = 0;
      price = 0.00;
      type = "";
   }
   //Constructor to set all instance variable values
   public Property(String s, String t, String c, int bed, int bath, int reception, double p, String propType) throws IllegalArgumentException //declaring an exception
   {
      if(bed < 0 || bath < 0 || reception < 0 || p <= 0)//It will ensure the user won't enter negative values in these fields
      {
         throw new IllegalArgumentException();//Throwing the exception
      }
      else
      {        
         propertyNo = nextPropertyNo++;
         street = s;
         town = t;
         county = c;
         noBeds = bed;
         noBaths = bath;
         noReception = reception;
         price = p;
         type = propType;
      }
      
   }
   
   //Methods
   public String toString()
   {
      return "Property No: "+propertyNo+ "\t Street: "+street+ "\t Town: "+town+ "\t County: "+county+
      "\t No Bedrooms: "+noBeds+ "\t No Bathrooms: "+noBaths+ "\t Reception Rooms: "+ noReception+ 
      "\t Price €: "+price+  "\t Type: " +type;//Type was added to it
   }
   public int getPropertyNo()//Added method to get propertyNo (used when calling the methods checkMortgage, calcRepayments and calcTax in PropertyGUI)
   {
      return propertyNo;
   }
   public String street()
   {
      return street;
   }
   public String town()
   {
      return town;
   }
   public String county()
   {
      return county;
   }
   public int beds()
   {
      return noBeds;
   }
   public int baths()
   {  
      return noBaths;
   }
   public int reception()
   {
      return noReception;
   }
   public double viewPrice()
   {
      return price;
   }
   public String type()
   {
      return type;
   }
   public String checkMortgage(double amount) throws IllegalArgumentException //Declaring an exception
   {
      if(amount <= 0)
      {
         throw new IllegalArgumentException(); //Throwing an exception
      }
      else if(price <= amount * 3)
      {
         return "                You qualify for a mortgage!";
      }
      else
      {
         return "    Unfortunately you don't qualify for a mortgage";
      }
         
   }
   public double monthlyRepay(int years) throws IllegalArgumentException //Declaring an exception
   {
      if(years <= 0)
      {
         throw new IllegalArgumentException();//Throwing the exception
      }
      else
      {
         double repayment = 0.00;
         double monthly;
         int months = years * 12;
         monthly = price / months;
         repayment = monthly + monthly * 0.03;
         return repayment;
      }
   }
   public double propertyTax() throws IllegalArgumentException//Declaring exception
   {
      double tax =0.00;
      if(propertyNo <= 0)
      {
         throw new IllegalArgumentException();//Throwing the exception
      }
      else if (price >0.00 && price <=100000.00)
      {
         tax = 90.00;
      }
      else if (price >=100001.00 && price <= 200000.00)
      {
         tax = 225.00;
      }
      else if (price >=200001.00 && price <=500000.00)
      {
         tax = 405.00;
      }
      else if (price >=500001.00 && price <=1000000.00)
      {
         tax = 1500.00;
      }
      else 
      {
         tax = 3000.00;
      }
      return tax;
   }
}//Close class