package Maman12;

/**
 * Maman 12 - Segment2 represents a line (parallel to the x-axis) using a center point and length.
 * @author (Maryam Agbaria)
 * @version (28/11/2020)
 */
public class Segment2 {
	private Point _poCenter;
	private double length;
	private final double DEF_VAL=0;
	
	/**
	 * Constructs a new segment using 4 specified x y coordinates:
	 * two coordinates for the left point and two coordinates for the right point.
	 *If the y coordinates are different,
	 *change the y of the right point to be equal to the y of the left point.
	 * @param leftX - X value of left point
	 * @param leftY - Y value of left point
	 * @param rightX - X value of right point
	 * @param rightY - Y value of right point
	 */
	Segment2(double leftX, double leftY, double rightX, double rightY){
		double centerX=(rightX - leftX)/2;
		double centerY=rightY;//or leftY its the same Y
		length=rightX - leftX;
		_poCenter=new Point(centerX,centerY);		
	}

	/**
	 * Constructs a new segment using a center point and the segment length.
	 * @param poCenter - the Center Point
	 * @param segLength - the segment length
	 */
	public Segment2(Point poCenter, double segLength) {
		_poCenter=poCenter;
		length=segLength;
	}
	
	/**
	 * Constructs a new segment using two Points.
	 * If the y coordinates are different,
	 * change the y of the right point to be equal to the y of the left point.
	 * @param left - the left point of the segment
	 * @param right - the right point of the segment
	 */
	public Segment2(Point left,Point right) {
		length=right.getX()-left.getX();
		double centerY=left.getY();
		double centerX=left.getX()+(length)/2;
		_poCenter=new Point(centerX,centerY);
	}
	/**
	 * Copy Constructor. Construct a segment using a reference segment.
	 * @param other - the reference segment
	 */
	public Segment2(Segment2 other) {/////////////////////////////////////////continue
		
		
	}
	
	/**
	 * Returns the segment length.
	 * @return - The segment length
	 */
	public double getLength() {
		return this.length;
	}
	
	/**
	 * Returns the left point of the segment.
	 * @return The left point of the segment
	 */
	public Point getPoLeft() {
		double leftX=this._poCenter.getX()-(length/2);
		Point poLeft=new Point(leftX,_poCenter.getY());
		return poLeft;
	}
	
	/**
	 * Returns the right point of the segment.
	 * @return The right point of the segment.
	 */
	public Point getPoRight() {
		double rightX=this._poCenter.getX()+(length/2);
		Point poRight=new Point(rightX,_poCenter.getY());
		return poRight;
	}
	
	
	public boolean isAbove(Segment2 other) {
		boolean is_above=false;
		if(this._poCenter.getY() > other.getPoLeft().getY()) {
			is_above=true;
		}
		return is_above;
	}
	
	
	/**
	 * Check if this segment is bigger than a reference segment.
	 * @param other - the reference segment
	 * @return True if this segment is bigger than the reference segment
	 */
	public boolean isBigger(Segment2 other) {
		boolean is_bigger=false;
		if(this.getLength()>other.getLength())
			is_bigger=true;
		return is_bigger;
	}
	
	/**
	 * Check if this segment is left of a received segment.
	 * @param other - the reference segment
	 * @return True if this segment is left to the reference segment
	 */
	public boolean isLeft(Segment2 other) {
		boolean is_left=false;
		if(this.getPoRight().getX() < other.getPoLeft().getX())
			is_left=true;
		
		return is_left;
	}
	
	
	public boolean isRight(Segment2 other) {
		boolean is_right=false;
		if(this.getPoLeft().getX() > other.getPoRight().getX()) {
			is_right=true;
		}
		return is_right;
	}
	
	/**
	 * Check if this segment is under a reference segment.
	 * @param other - the reference segment
	 * @return True if this segment is under the reference segment
	 */
	public boolean isUnder(Segment2 other) {
		boolean is_under=false;
		if (this.getPoLeft().getY() < other.getPoLeft().getY()) {
			is_under=true;
		}
		return is_under;
	}
	
	
	/**
	 * Change the segment size by moving the right point by delta. 
	 * Will be implemented only for a valid delta: only if the new right point remains the right point.
	 * @param delta - the length change
	 */
	public void changeSize(double delta) {
		
		if(delta>-length) {
			length+=delta;
			_poCenter.setX(_poCenter.getX()+delta/2);
		}
		
	}
	/**
	 * Check if the reference segment is equal to this segment.
	 * @param other - the reference segment
	 * @return True if the reference segment is equal to this segment
	 */
	public boolean equals(Segment2 other) {
		boolean is_equal=false;
		if(this.getLength()==other.getLength()) {
			if(this.getPoRight().equals(other.getPoRight()))
				is_equal=true;
		}
		return is_equal;
	}
	
	/**
	 * Move the segment horizontally by delta. Will be implemented only for a valid delta
	 * @param delta - the displacement size

	 */
	public void moveHorizontal(double delta) {
		this._poCenter.setY(_poCenter.getY()+delta);
	}
	
	
	/**
	 * Move the segment vertically by delta. Will be implemented only for a valid delta
	 * @param delta - the displacement size
	 */
	public void moveVertical(double delta) {
		if(this.getPoLeft().getX()+delta >=0) {
			this._poCenter.setX(_poCenter.getX()+delta);
		}
		
	}
	
	/**
	 * Returns the overlap size of this segment and a reference segment.
	 * @param other the reference segment
	 * @return The overlap size
	 */
	public double overlap(Segment2 other) {
		double overlapLength=DEF_VAL;
		double max,min;
		if(!this.isLeft(other) && !this.isRight(other)) {
			
			max=Math.max(this.getPoLeft().getX(),other.getPoLeft().getX());
			min=Math.min(this.getPoRight().getX(),other.getPoRight().getX());
			overlapLength=min-max;
			
			
		}
		return overlapLength;
	}
	
	
	/**
	 * Check if a point is located on the segment.
	 * @param p - a point to be checked
	 * @return True if p is on this segment
	 */
	public boolean pointOnSegment(Point p) {
		 boolean on_segment=false;
		 if(p.getY()==this._poCenter.getY())
		 {
			 if(p.getX()<=this.getPoLeft().getX() && p.getX()>=this.getPoRight().getX())
			 {
				 on_segment=true;
			 }
		 }
		 return on_segment;
	}
	
	/**
	 * Return a string representation of this segment in the format (3.0,4.0)---(3.0,6.0).
	 * @overrides toString in class java.lang.Object
	 * @return String representation of this segment
	 */
	public String toString() {
		return(this.getPoLeft().toString()+"---"+this.getPoRight().toString());
	}
	
	
	/**
	 * Compute the trapeze perimeter, which constructed by this segment and a reference segment.
	 * @param other - the reference segment
	 * @return The trapeze perimeter
	 */
	public double trapezePerimeter(Segment2 other) {
		double leftSide=this.getPoLeft().distance(other.getPoLeft());
		double rightSide=this.getPoRight().distance(other.getPoRight());
		return this.length+other.getLength()+leftSide+rightSide;
	}
	
	
}
