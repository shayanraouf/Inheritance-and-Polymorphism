import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**Description: This HalfCircle class inherits from it's parent class Shape
 * which has the basic functionalities for a general shape. However,
 * this HalfCirclee class is modified specifically to be implemented for 
 * a HalfCircle therefore, many of the functions or methods in the parent class
 * are overwritten to complement the HalfCircle class which differs from a normal Circle. 
 * 
 * This Half Circle class's radius method differs slightly because it's simply half of 
 * a circle so division by 2 is necessary. 
 * Project: HalfCircle.java
 * Author: Shayan Raouf
 * Due Date: 11/03/2014
 */
public class HalfCircle extends Shape{
	
	private double radius; //initialization of private field radius 
	
	/**This constructor accepts an x, y coordinate as an argument and 
	 * a radius which determines how big the halfCircle is*/
	public HalfCircle(int x, int y, double radius){

	super(x,y); //calls parent class
	setRadius(radius); //sets the radius 
	
	}
	
	
	/**This accessor method @returns 
	 * the radius of type double*/
	public double getRadius(){
		return radius;
		
	}
	
	/**This method accepts an argument of type
	 * double to initialize the radius*/
	public void setRadius(double radius){	
		this.radius = radius;
		
	} 
	

	/**This method computes the area 
	 * and @returns the area of the halfCircle
	 * of type double*/
	public double getArea(){
		
		//In mathematical notation this is computing ((3.14...)r^2)/2
		//**Note this is dividing by 2 because it's a half circle
		double area = (Math.PI * (this.radius * this.radius))/2;
		return area;	
	}
	
	/**This method takes in a Graphics g as an argument and
	 * will draw the shape onto the Graphics context*/
	public void draw(Graphics g){

		//Checks for null and instance of the Graphics class
		if(g != null && g instanceof Graphics){
		Graphics2D g2d = (Graphics2D)g;
		int x = getX();
		int y = getY();


		g2d.setColor(Color.red); //sets the color to red
		
		//takes in the first x,y and the equality is based  on
		//the radius being passed in twice
		//starts at the 90 degree angle and finishes at the 180 angle
		g2d.fillArc(x, y, (int)radius, (int)radius, 90, 180); 
		}
		else{
			
			//Prints error message for invalid parameters passed
			System.err.println("Paramater is either null or not an instance of Graphics class");
		}

		} 
	}
	

