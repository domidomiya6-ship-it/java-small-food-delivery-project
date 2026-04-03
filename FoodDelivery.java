import java.util.Scanner;

abstract  class Foodorder
{
   protected String foodname;
   protected double baseprice;
   protected int deliverytime;
   
   Foodorder(String foodname,double baseprice,int deliverytime)
   {
     this.foodname=foodname;
	 this.baseprice=baseprice;
	 this.deliverytime=deliverytime;
	 
   }
   abstract void calculateTotalCost();
   abstract void getOrderDetails();
   
   
   
}

class Pizzaorder extends Foodorder
{
  
  private int extraTopping;

  Pizzaorder(String foodname,double baseprice,int deliverytime,int extraTopping)
  {
    super(foodname,baseprice,deliverytime);
	this.extraTopping=extraTopping;
  }
  
  public void calculateTotalCost()
  {
	  int extrachrage=200;
	  double finalprice=baseprice+(extraTopping*extrachrage);
	  System.out.println("Total cost of your pizzaorder"+finalprice);
  }
  public void getOrderDetails()
  {
	 System.out.println("order name"+foodname);
	 System.out.println("baseprice"+baseprice);
	 System.out.println("order delivery in mintues"+deliverytime);
	 
  }
  
}

class SandwitchOrder extends Foodorder
{
  
  private int extraFilling;
  
  SandwitchOrder(String foodname,double baseprice,int deliverytime,int extraFilling)
  {
	 super(foodname,baseprice,deliverytime);
     this.extraFilling=extraFilling;	 
  }
   public void calculateTotalCost()
  {
	  int extrachrage=150;
	  double finalprice=baseprice+(extraFilling*extrachrage);
	  System.out.println("Total cost of your pizzaorder"+finalprice);
	  
	  
  }
  public void getOrderDetails()
  {
	 System.out.println("order name"+foodname);
	 System.out.println("baseprice"+baseprice);
	 System.out.println("order delivery in mintues"+deliverytime);
  }
}

class SaladOrder extends Foodorder
{

  private String isLarge;

  SaladOrder(String foodname,double baseprice,int deliverytime,String isLarge)
  {
	 super(foodname,baseprice,deliverytime);
     this.isLarge=isLarge;	 
  }  
   public void calculateTotalCost()
  {
	 if(isLarge.equals("large"))
     {
		 double finalprice=baseprice-(baseprice*0.1);
		 System.out.println("Total cost of saldorder"+finalprice);	 
	 }
     else if(isLarge.equals("small"))
     {
		 System.out.println("Total cost of saldorder"+baseprice);
	 }
     else
	 {
		System.out.println("invalid input"); 
	 }		 
  }
  public void getOrderDetails()
  {
	 System.out.println("order name"+foodname);
	 System.out.println("baseprice"+baseprice);
	 System.out.println("order delivery in mintues"+deliverytime); 
  }
}

 class FoodDelivery
{
  public static void main(String args[])
  {
     Scanner scan=new Scanner(System.in);
	 System.out.println("select your food type like: pizza,Sandwitch,Salad");
	 String foodname=scan.nextLine();
	 
	 switch(foodname)
	 {
		case "pizza": 
		   System.out.println("enter the number of extraTopping");
		   int extraTopping=scan.nextInt();
		   
		   Pizzaorder pizza =new Pizzaorder(foodname,1200,12,extraTopping);
		   System.out.println("details of your order");
		   pizza.getOrderDetails();
		   pizza.calculateTotalCost();
		   break;
		   
		case "Sandwitch":
            System.out.println("enter the number of extraFilling");	
            int extraFilling=scan.nextInt();
			
            SandwitchOrder sand=new SandwitchOrder(foodname,600,20,extraFilling);
            System.out.println("details of your order");
		    sand.getOrderDetails();
		    sand.calculateTotalCost();
		    break;
        case "Salad":
            System.out.println(" Is you want your salad portion large or small:");
            String isLarge=scan.nextLine();
			
            SaladOrder salard=new SaladOrder(foodname,500,50,isLarge);
            System.out.println("details of your order");
		    salard.getOrderDetails();
		    salard.calculateTotalCost();
		    break;	
        default:
            System.out.println("Invalid entery");
            break;			
	 }
  }
}