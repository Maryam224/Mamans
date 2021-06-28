package Maman12;

/**
 * Maman 12 - Segment1 represents a line (parallel to the x-axis) using two Points.
 * 
 * @author (Maryam Agbaria)
 * @version (28/11/2020)
 *
 */
public class Segment1 {
	private Point _poLeft;
	private Point _poRight;
	private final double DEF_VAL=0;
	
	/**
	 * Constructs a new segment using 4 specified x y coordinates:
	 * Two coordinates for the left point and two coordinates for the right point. 
	 * If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
	 * @param leftX - X value of left point
	 * @param leftY - Y value of left point
	 * @param rightX - X value of right point
	 * @param rightY - Y value of right point
	 * 
	 */
	public Segment1(double leftX, double leftY, double rightX, double rightY) {
		_poLeft=new Point(leftX,leftY);
		_poRight=new Point(rightX,leftY);
	}

	/**
	 * Constructs a new segment using two Points.
	 * If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
	 * @param left - the left point of the segment
	 * @param right - the right point of the segment
	 */
	public Segment1 (Point left, Point right) {
		_poLeft=new Point(left);
		_poRight=new Point (right);
		if(left.getY()!=right.getY()) 
		{
			_poRight.setY(left.getY());
			
		}
		
	}
	
	/**
	 * Copy Constructor. Construct a segment using a reference segment.
	 * @param other - the reference segment
	 */
	public Segment1 (Segment1 other) {
		this._poLeft=new Point(other.getPoLeft());
		this._poRight=new Point(other.getPoRight());
	}
	
	/**
	 * Returns the left point of the segment.
	 * @return The left point of the segment
	 */
	public Point getPoLeft() {
		return this._poLeft;
	}
	
	/**
	 * Returns the right point of the segment.
	 * @return The right point of the segment
	 */
	public Point getPoRight() {
		return this._poRight;
	}
	
	/**
	 * Returns the segment length.
	 * @return The segment length
	 */
	public double getLength() {
		return _poRight.getX()-_poLeft.getX();
	}
	
	/**
	 * Return a string representation of this segment in the format (3.0,4.0)---(3.0,6.0).
	 * @override toString in class java.lang.Object
	 * @return String representation of this segment
	 */
	public String toString() {
		String s="---";
		return(_poLeft.toString()+s+_poRight.toString());
	}
	
	/**
	 * Check if the reference segment is equal to this segment.
	 * @param other - the reference segment
	 * @return True if the reference segment is equal to this segment
	 */
	 public boolean equals(Segment1 other) {
		 
		 boolean equal_seg=false;
		 if(this._poLeft.equals(other.getPoLeft()) && this._poRight.equals(other.getPoRight()))
		 {
			 equal_seg=true;
		 }
		 return equal_seg;
	 }
	 
	 /**
	  * Check if this segment is above a reference segment.
	  * @param other - the reference segment
	  * @return True if this segment is above the reference segment
	  */
	 public boolean isAbove(Segment1 other) {
		 boolean is_above=false;
		 if(this.getPoLeft().getY() > other.getPoLeft().getY())
		 {
			 is_above=true;
		 }
		 return is_above;
	 }
	 
	 /**
	  * Check if this segment is under a reference segment.
	  * @param other - the reference segment
	  * @return True if this segment is under the reference segment
	  */
	 public boolean isUnder(Segment1 other) 
	 {
		 boolean is_under=false;
		 
		 if(this._poLeft.getY()!=other.getPoLeft().getY()&& this.isAbove(other)==false)
		 {
			 is_under=true;
		 }
		 return is_under;
		 
	 }
	 
	 
	 /**
	  * Check if this segment is left of a received segment.
	  * @param other - the reference segment
	  * @return True if this segment is left to the reference segment
	  */
	 public boolean isLeft(Segment1 other)
	 {
		 boolean is_left=false;
		 if(this._poRight.getX() < other.getPoLeft().getX())
		 {
			 is_left=true;
		 }
		 return is_left;
		 
	 }
	 
	 /**
	  * Check if this segment is right of a received segment.
	  * @param other - the reference segment
	  * @return True if this segment is right to the reference segment
	  */
	 public boolean isRight(Segment1 other)
	 {
		 boolean is_right=false;
		 if(this._poLeft.getX() > other.getPoRight().getX())
		 {
			 is_right=true;
		 }
		 return is_right;
		 
	 }
	 
	 /**
	  * Move the segment horizontally by delta.
	  * @param delta - the displacement size
	  */
	 public void moveHorizontal(double delta) 
	 {
		 this._poLeft.setX(this._poLeft.getX()+delta);
		 this._poRight.setX(this._poRight.getX()+delta);
		 
	 }
	 
	 /**
	  * Move the segment vertically by delta.
	  * @param delta - the displacement size
	  */
	 public void moveVertical(double delta) 
	 {
		 this._poLeft.setY(this._poLeft.getY()+delta);
		 this._poRight.setY(this._poRight.getY()+delta);
		 
	 }
	 
	 /**
	  * Change the segment size by moving the right point by delta. Will be implemented only for a valid delta:
	  * only if the new right point remains the right point.
	  * @param delta
	  */
	 public void changeSize(double delta) {
		 double d=this._poRight.getX()+delta;
		 if(d > this._poLeft.getX()) 
		 {
			 this._poRight.setX(d);
		 }
	 }
	 
	 /**
	  * Check if a point is located on the segment.
	  * @param p - a point to be checked
	  * @return True if p is on this segment
	  */
	 public boolean  pointOnSegment(Point p) 
	 {
		 boolean on_segment=false;
		 if(p.getY()==this._poLeft.getY())
		 {
			 if(p.getX()<=this._poLeft.getX() && p.getX()>=this._poRight.getX())
			 {
				 on_segment=true;
			 }
		 }
		 
		 return on_segment;
	 }
	 
	 /**
	  * Check if this segment is bigger than a reference segment.
	  * @param other - the reference segment
	  * @return True if this segment is bigger than the reference segment
	  */
	 public boolean isBigger(Segment1 other) 
	 {
		 boolean is_bigger=false;
		 
		 if(this.getLength()>other.getLength()) 
		 {
			 is_bigger=true;
		 }
		 
		 return is_bigger;
		 
	 }
	 
	 
	 /**
	  * Returns the overlap size of this segment and a reference segment.
	  * @param other - the reference segment
	  * @return The overlap size
	  */
	 public double overlap(Segment1 other) 
	 {
		 double overlapLength=DEF_VAL;
		 double max,min;
		 if(!this.isRight(other) && !this.isLeft(other))
		 {
			max=Math.max(this._poLeft.getX(),other.getPoLeft().getX());
			min=Math.min(this._poRight.getX(),other.getPoRight().getX());
			overlapLength=min-max;
			 
		 }
		 return overlapLength;
	 }
	 
	 
	 /**
	  * Compute the trapeze perimeter, which is constructed by this segment and a reference segment.
	  * @param other - the reference segment
	  * @return The trapeze perimeter
	  */
	 public double trapezePerimeter(Segment1 other) 
	 {
		 double perimeter;
		 double leftSide=this._poLeft.distance(other.getPoLeft());
		 double rightSide=this._poRight.distance(other.getPoRight());
		 perimeter=this.getLength()+other.getLength()+leftSide+rightSide;
		 return perimeter;
		 
	 }

}
