import java.awt.Graphics;
import java.awt.Graphics2D;
/**Description: This RiverSix class inherits from it's parent class Shape
 * which has the basic functionalities for a general shape.
 * This RiverSix class is modified specifically to be implemented for 
 * a RiverSix therefore, many of the functions or methods in the parent class
 * are overwritten to complement this RiverSix class. 
 * 
 * This class makes 6 objects of the Equilateral class and stores each one
 * in an array of Shapes. Later draws them making a river-like pattern. 
 * Project: RiverSix.java
 * Author: Shayan Raouf
 * Due Date:11/03/2014
 */
public class RiverSix extends Shape{
	
	//Private instance variable 
	private Shape[] array = new Shape[6];
	private int size;
	
	/**Constructor that accepts three arguments
	 * as a parameter, an x,y coordinate and a size */
	public RiverSix(int x, int y, int size){
		
		super(x,y);//calls super for initialization 
		setSize(size);
		//for loop at add each Equilateral into each element
		for(int i = 0; i < 6; i++){
			array[i] = new Equilateral(x + i * getSize(), y, getSize());
			
		}
	}
	
	/**This initializes the instance variable to the argument passed in*/
	public void setSize(int size){
		this.size = size;
	}
	
	/**@returns the size*/
	public int getSize(){
		return this.size;
	}
	
	
	/**This method takes in a Graphics g as an argument and 
	 * will draw the Equilateral onto the Graphics context*/
	public void draw(Graphics g){

		//Checks for null and instance of the Graphics class 
		if(g != null && g instanceof Graphics){
		Graphics2D g2d = (Graphics2D)g;
		
		
		for(int i = 0; i < 6; i++){
			array[i].draw(g2d);
			
		}
		
		}
		else{
			//Prints error message if passed invalid argument
			System.err.println("Paramater is either null or not an instance of Graphics class");
		}
	}

}
