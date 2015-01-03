import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**Description: This Triangle class inherits from it's parent class Shape
 * which has the basic functionalities for a general shape. However,
 * this Triangle class is modified specifically to be implemented for 
 * a Triangle therefore, many of the functions or methods in the parent class
 * are overwritten to complement this Triangle class. 
 * 
 * The methods I wrote for this Triangle class that are significantly different
 * than other shape classes due to the nature of differences of this class are 
 * as follows: 
 * semiPerimeter(double l1, double l2, double l3) 
 * public double getArea()
 * double getLength
 * 
 * I don't use all methods that I have made to draw my circle however, I included them in 
 * here because they're functioning methods and it was good practice for me to connect
 * some simple mathematics with java code and understanding the connection between them
 * such as using Herons formula and implementing that into java code
 * Project: Triangle.java
 * Author: Shayan Raouf
 * Due Date: 11/03/2014
 */
public class Triangle extends Shape{
	
	//initialization of the three sides of a Triangle 
	//points a,b represent an x,y coordinate as c, d
	private int a;
	private int b;
	private int c;
	private int d;
	
	/**This constructor accepts 6 arguments and initializes 
	 *the x & y by calling the super class and a,b & c by calling
	 *the methods that set the sides of the triangle*/
	public Triangle(int x, int y, int a, int b, int c, int d){
		super(x, y); //super class
		
		
		//I may have to give it a condition 
		//of the the 3 points can't be on the same plane 
		setAandB(a, b);
		setCandD(c, d);
		
		
	} 
	
	
	/**This method accepts two argument of type 
	 * int and initializes the x,y coordinates of one 
	 * point of the Triangle*/
	public void setAandB(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	/**This method accepts two argument of type 
	 * int and initializes the x,y coordinates of one 
	 * point of the Triangle*/
	public void setCandD(int c, int d){
		this.c = c;
		this.d = d;
	}


	
	/**@returns the this.a value of the Triangle*/
	public int getA(){
		return this.a;
	}
	
	/**@returns the this.b value of the Triangle*/
	public int getB(){
		return this.b;
	}
	
	/**@returns the this.c value of the Triangle*/
	public int getC(){
		return this.c;
	}
	
	/**@returns the this.c value of the Triangle*/
	public int getD(){
		return this.d;
	}
	
	/**this calculates and @returns the semiperimeter which is used in the area*/
	private double semiPerimeter(double l1, double l2, double l3){
		return (l1 + l2 + l3)/2;
		
	}
	
	/**This method computes the Area by using Herons formula 
	 * and calling the semiPerimeter() method*/
	public double getArea(){
		double l1 = getLength(getX(),getY(), this.a, this.b);//gets the length of one set of coordinates 
		double l2 = getLength(getX(),getY(), this.c, this.d);
		double l3 = getLength(this.c, this.d, this.a, this.b);
		double s = semiPerimeter(l1, l2, l3);
		return Math.sqrt(s*(s-l1)*(s-l2)*(s-l3));
		
	}
	

	/**This method @returns the length at two given coordinates*/
	public double getLength(double x1, double y1, double x2, double y2){
		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}
	
	/**This method takes in a Graphics g as an argument and
	 * will draw the shape onto the Graphics context g or g2D*/
	public void draw(Graphics g){
		
		//Checks for null and instance of the Graphics class
		if(g != null && g instanceof Graphics){
		Graphics2D g2d = (Graphics2D)g; //Concatenates to Graphics2d
		
		//retrieves the x and y from parent class
		int x = getX();
		int y = getY();
		
		 
		g2d.setColor( Color.PINK );//sets the color to pink
	    g2d.drawLine(x,y,this.a,this.b);//Connects the first point (x,y) --> (a,b)
	    g2d.drawLine(x,y,this.c,this.d);//Connects the second point (x,y) -- > (c,d)
	    g2d.drawLine(this.c,this.d,this.a,this.b);//Connects the third point (c,d) --> (a,b)
	    //now we have all the lines connected to each other
		}
		else{
			
			//Prints error message if invalid parameters were passed
			System.err.println("Paramater is either null or not an instance of Graphics class");
		}
	}


}
