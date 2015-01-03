import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**Description: This Equilateral class inherits from it's parent class Shape
 * which has the basic functionalities for a general shape. However,
 * this Equilateral class is modified specifically to be implemented for 
 * a Equilateral therefore, many of the functions or methods in the parent class
 * are overwritten to complement this Equilateral class. 
 * An Equilateral is a specific type of Triangle with an angle of 60 degrees
 * In contrast a regular Triangle may consist of various angles. 
 * Project: Equilateral.java
 * Author: Shayan Raouf
 * Due Date:11/03/2014
 */
public class Equilateral extends Shape{
	
	//private instance variables size
	private int size;
	
	/**This constructor accepts 2 arguments and initializes 
	 *the x & y by calling the super class and accepts a size
	 *which determines the size of the Equilateral*/
	public Equilateral(int x, int y, int size){
		super(x, y); //super class	
		setSize(size); //calls method and sets size
		
	} 
	
	/**accepts a size of type int
	 * and initializes this.size*/
	public void setSize(int size){
		this.size = size;
		
	}
	
	/**@returns the size of type int*/
	public int getSize(){
		return this.size;		
	}
		
	/**This method @returns the length at two given coordinates*/
	public double getLength(double x1, double y1, double x2, double y2){
		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}
	
	/**This method computes and @returns the Area by using 1/4 square root of 3 * a^2
	 * and a is the length in this case this also calls the getLenth()
	 * method which takes 2 coordinates and since this is an Equilateral the length
	 * of lines are equal*/
	public double getArea(){
		double a = getLength(getX(),getY(),getX() - size/2, (int)(getY() + Math.sqrt(3)/2 * size));
		return (Math.sqrt(3)/4) * Math.pow(a, 2);
	}
	/**This method takes in a Graphics g as an argument and 
	 * will draw the Equilateral onto the Graphics context*/
	public void draw(Graphics g){

		//Checks for null and instance of the Graphics class 
		if(g != null && g instanceof Graphics){
		Graphics2D g2d = (Graphics2D)g;
		
		//calling the x and y from out super class
		int x = getX();
		int y = getY();
		
		//This makes it so it dosn't go out of the bounds of pixel screens
		if(x < size/2){
			x = size/2;
			
		}	

	
		g2d.setColor( Color.ORANGE); //sets the color
		
		/*The following 3 methods Connects the first x,y coordinates to second with respect to size
		 *coordinates act differently in Graphics than they do on a regular 
		 *graph with (0,0) starting at the top-left pixel*/

		//x - size/2 is the x we connect to
		//(int)(y + Math.sqrt(3)/2 * size) is the y value and later 
		//parsed into an int because drawLine only accepts type int as an arugment
		
	    g2d.drawLine(x,y,x - size/2, (int)(y + Math.sqrt(3)/2 * size));//Connects side1 to side2
	    g2d.drawLine(x, y, x + size/2, (int)(y + Math.sqrt(3)/2 * size));//Connects side1 to side 3
	    //Connects side2 to side3
	    g2d.drawLine(x - size/2, (int)(y + Math.sqrt(3)/2 * size), x + size/2, (int)(y + Math.sqrt(3)/2 * size));
	    
		}
		else{
			//Prints error message if passed invalid argument
			System.err.println("Paramater is either null or not an instance of Graphics class");
		}
	}
}
