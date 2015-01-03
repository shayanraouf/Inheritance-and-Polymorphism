import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**Description: This Rectangle class inherits from it's parent class Shape
 * which has the basic functionalities for a general shape. However,
 * this Rectangle class is modified specifically to be implemented for 
 * a circle therefore, many of the functions or methods in the parent class
 * are overwritten to complement the Rectangle class. 
 * 
 * The instance variables are height and width and we of course utilize 
 * the x,y from the parent class also the area in this class is specified 
 * for a rectangle such as A = L*W
 * Project: Rectangle.java
 * Author: Shayan Raouf
 * Due Date:11/03/2014
 */
public class Rectangle extends Shape{
	
	//initialization of private fields 
	private double height;
	private double width;
	
	/**This constructor accepts four arguments as as parameter
	 * x, y coordinates and the height & width of the Rectangle
	 * and initializes them for the given value*/
	public Rectangle(int x, int y, double h, double w){
		
		super(x, y); //calls the super class
		//sets the height & width
		setHeight(h); 
		setWidth(w);
	}
	
	/**This method accepts an argument of 
	 * type double and initializes the height
	 * to the given value*/
	public void setHeight(double h){
		this.height = h;	
	}
	
	/**This method accepts an argument of 
	 * type double and initializes the width
	 * to the given value*/
	public void setWidth(double w){
		this.width = w;	
		
	}
	
	/**This method @returns he height of the rectangle*/
	public double getHeight(){
		return this.height;
	}
	
	/**This method @returns he width of the rectangle*/
	public double getWidth(){
		return this.width;
	}
	
	/**This @returns the area, which length * width
	 * and length being represented by height here*/
	public double getArea(){
		return (this.height * this.width);
	}
	
	
	/**This method takes in a Graphics g as an argument and
	 * will draw the shape(Rectangle in this case) onto the Graphics context*/
	public void draw(Graphics g){

		//checks for null and instance of Graphics class
		if(g != null && g instanceof Graphics){
		Graphics2D g2d = (Graphics2D)g; //makes it into a Grapics2d
		
		//super class x & y coordinates 
		int x = getX(); 
		int y = getY();
		
		 
		g2d.setColor( Color.BLUE ); //sets the color to blue
	    g2d.drawRect(x, y, (int)height, (int)width); //draws the rectangle by the x,y and the height and width
		}
		else{
			
			//prints error message if invalid paramater was passed in
			System.err.println("Paramater is either null or not an instance of Graphics class");
		}
	}
	

	
	
	
}
