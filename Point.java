package Maman12;
/**
 *Maman 12 - this class represents 2 dimensional points.
 *
 * @author (Maryam Agbaria)
 * @version (28/11/2020)
 */
public class Point {
	private double _radius;
	private double _alpha;
	private final double DEF_VAL=0;

    /**
    * creates a new Point object  
    * @param x - The x coordinate
    * @param y - The y coordinate
    */ 
	public Point(double x, double y) {
		if(x <= DEF_VAL)
		{
			x=0.0;
			_alpha=Math.PI/2;
			_radius=y;
			
		}
		if(y<=DEF_VAL)
		{
			y=0.0;
			_alpha=0;
			_radius=x;
		}

		if( x>0 && y>0)
		{
			_alpha=Math.atan(y/x);
			_radius=Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
		}
		
		
	}
	
   /**
   * Constructor for objects of class Point.
   * Copy constructor, construct a point using another point.
   * @param other - The point from which to construct the new object
   */
	public Point(Point other) {
		double x=other.getX();
		double y=other.getY();
				
		if(x==DEF_VAL)
		{

			_alpha=Math.PI/2;
			_radius=y;
			
		}
		if(y==DEF_VAL)
		{
			
			_alpha=0;
			_radius=x;
		}

		if( x>0 && y>0)
		{
			_alpha=Math.atan(y/x);
			_radius=Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
		}
		
	}
	/**
	 * This method returns the x coordinate of the point.
	 * @return The x coordinate of the point
	 */
	public double getX() {
		
		if(_alpha==Math.PI/2) {
			return DEF_VAL;
		}
		
		double x=_radius * Math.cos(_alpha);
		return x;
	}
	
	/**
	 * This method returns the y coordinate of the point.
	 * @return The y coordinate of the point
	 */
	public double getY() {
		if(_alpha==0)
			return DEF_VAL;
		double y=_radius* Math.sin(_alpha);
		return y;
	}
	
	/**
	 * This method sets the x coordinate of the point.
	 * If the new x coordinate is negative the old x coordinate will remain unchanged.
	 * @param num - The new x coordinate
	 */
	public void setX(double num) {
		
		double y=getY();
		
		if(num == 0)
		{
			_alpha=Math.PI/2;
			_radius=y;
		}
		if (num>0) 
		{
			_alpha=Math.atan(y/num);
			_radius=Math.sqrt(Math.pow(num,2)+Math.pow(y,2));
		}
	}
	
	/**
	 * This method sets the y coordinate of the point.
	 * If the new y coordinate is negative the old y coordinate will remain unchanged.
	 * @param num - The new y coordinate
	 */
	public void setY(double num) {

		double x=getX();
		
		if(num == 0)
		{
			_alpha=0.0;
			_radius=x;
		}
		if (num>0) 
		{
			_alpha=Math.atan(num/x);
			_radius=Math.sqrt(Math.pow(x,2)+Math.pow(num,2));
		} 
	}
	
	/**
	 * Check if the given point is equal to this point.
	 * @param other - The point to check equality with
	 * @return True if the given point is equal to this point
	 */
	public boolean equals(Point other) {
		boolean is_equal=false;
		if(this.getX() == other.getX() && this.getY() == other.getY()) {
			is_equal=true;
			
		}
		return is_equal;
	}
	
	/**
	 * Check if this point is above a received point.
	 * @param other - The point to check if this point is above
	 * @return True if this point is above the other point
	 */
	public boolean isAbove(Point other) {
		boolean is_above=false;
		
		if(this.getY() > other.getY()) {
			is_above=true;
		}
		return is_above;
		
	}
	/**
	 * Check if this point is below a received point.
	 * @param other - The point to check if this point is below
	 * @return True if this point is below the other point
	 */
	public boolean isUnder(Point other) {
		boolean is_under=false;
		if(this.getY() != other.getY() && this.isAbove(other)==false)
		{
			is_under=true;
		}
		return is_under;
	}
	
	/**
	 * Check if this point is left of a received point.
	 * @param other - The point to check if this point is left of
	 * @return True if this point is left of the other point
	 */
	public boolean isLeft(Point other) {
		
		boolean is_left=false;
		
		if(this.getX() < other.getX())
		{
			is_left=true;
		}
		return is_left;
	}
	
	/**
	 * Check if this point is right of a received point.
	 * @param other - The point to check if this point is right of
	 * @return True if this point is right of the other point
	 */
	public boolean isRight(Point other) {
		boolean is_right=false;
		if(this.getX() != other.getX() && this.isLeft(other)==false)
		{
			is_right=true;
		}
		return is_right;
	}
	
	/**
	 * Check the distance between this point and a given point.
	 * @param other - The point to check the distance from
	 * @return The distance
	 */
	public double distance(Point p) {
		double d=Math.sqrt(Math.pow(this.getX()-p.getX(),2)+Math.pow(this.getY()-p.getY(),2));
		return d;
	}
	
	/**
	 * Moves a point. If either coordinate becomes negative the point remains unchanged.
	 * @param dx - The difference to add to x
	 * @param dy - The difference to add to y
	 */
	public void move(double dx, double dy) 
	{
		if(this.getX()+dx>=0 && this.getY()+dy>=0)
		{
			this.setX(this.getX()+dx);
			this.setY(this.getY()+dy);
		}
		
	}
	
	
	/**
	 * Returns a string representation of Point in the format (x,y).
	 * @overrides toString in class java.lang.Object
	 * @return A String representation of the Point
	 */
	public String toString() {
		double x=this.getX();
		 x=Math.round(x*10000)/(double)10000;
		 double y=this.getY();
		 y=Math.round(y*10000)/(double)10000;
		return "("+x+","+y+")";
	}
	
	
	

}
