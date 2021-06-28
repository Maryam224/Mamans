
/**
 * Polygon represents a Polygon by a number  of given Points.
 *
 * @author (Maryam Agbaria)
 * @version (12/12/2020)
 */
public class Polygon
{
    private Point[] _vertices;
    private int _noOfVertices;
    public static final int MAX_VER=10;

    /**
     * Constructor for objects of class Polygon
     * Makes a new Point array with a length of 10.
     */
    public Polygon()
    {
       _vertices=new Point[MAX_VER];
       _noOfVertices=0;
    }
    
    /**
     * This method adds a vertex if there is enogh place
     * and returns true if added, false if not
     * @param x  x coordinate of the new Point
     * @param y  y coordinate of the new Point
     * @return True if the vertex was added
     */
    public boolean addVertex(double x, double y)
    {
        if(_noOfVertices<MAX_VER ){
            _vertices[_noOfVertices]=new Point(x,y);
            _noOfVertices++;
            return true;
        }
        else
        return false;
    }
    /**
     * This method returns the highest Vertex
     * @return the highest vertex in the polygon
     */
    public Point highestVertex()
    {
        if(_vertices==null || _vertices[0]==null || _noOfVertices==0 )
        return null;
        
        Point highestV=new Point(_vertices[0]);
        for(int i=1;i<_noOfVertices;i++){
            if(_vertices[i].isAbove(highestV)){
                highestV=new Point(_vertices[i]);
            }
        }
        return highestV;
    }
    /**
     * Returns a String representation of the Polygon with is points 
     * in Point format (x,y).
     * @override toString in class java.lang.Object
     * @return A String represents the Polygon points
     */
    public String toString(){
        String str="The polygon has 0 vertices.";
        if(_vertices==null|| _vertices[0]==null || _noOfVertices==0)
        {
            return str;
        }
        else{
        str="The polygon has "+_noOfVertices+" vertices:\n(";
        for(int i=0;i<_noOfVertices-1;i++){
            str+=_vertices[i].toString()+",";
        }
        str+=_vertices[_noOfVertices-1]+")";
    }
        return str;
    }
    /**
     * This method returns the perimeter of the Polygon
     * @return the perimeter of the Polygon
     */
    public double calcPerimeter(){
        double perimeter=0;
        if(_vertices==null|| _vertices[0]==null || _noOfVertices<=1){
            return perimeter;
        }
        if(_noOfVertices==2){
            perimeter=_vertices[0].distance(_vertices[1]);
        }
        else{
            for(int i=0;i<_noOfVertices-1;i++){
            perimeter+=_vertices[i].distance(_vertices[i+1]);
        }
        perimeter+=_vertices[0].distance(_vertices[_noOfVertices-1]);
        }
        return perimeter;        
    }
    /**
     * This method calculates the area of a triangle
     * @param a  length  of triangle side
     * @param b  length  of triangle side
     * @param c  length  of triangle side
     * @return The triangle area
     */
    private double heronArea(double a,double b,double c){
        double s=(a+b+c)/2;
        double area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return area;
    }
    
    /**
     * This method returns the erea of the Polygon
     * @return the erea of the Polygon
     */
    public double calcArea(){
        double area=0;
        if(_vertices==null|| _vertices[0]==null || _noOfVertices<3)
        {
            return area;
        }
        else {
            double a,b,c;
            for(int i=0;i<_noOfVertices-2;i++){
                a=_vertices[0].distance(_vertices[i+1]);
                b=_vertices[0].distance(_vertices[i+2]);
                c=_vertices[i+1].distance(_vertices[i+2]);
                area+=heronArea(a,b,c);
            }

            
        }
        return area;
        
    }
    /**
     * This methods checks if this Polygon are is bigger than
     * the received Polygons' area
     * @param other the refrence Polygon
     * @return True if this Polygon area is bigger than the others' area
     */
    public boolean isBigger(Polygon other){
        boolean is_bigger=false;
        if (other!=null)
        {
            if(this.calcArea()>other.calcArea())
            is_bigger=true;
        }
        
        return is_bigger;
    }
    /**
     * This method finds the index of the given point
     * if its found in the Polygon 
     * if not returns -1
     * @param p the refrence Point
     * @return the index of the given Point
     */
    public int findVertex(Point p){
        if(_vertices!=null && _vertices[0]!=null && _noOfVertices!=0)
        {        
            for(int i=0;i<_noOfVertices;i++){
                if(p.equals(_vertices[i]))
                return i;
            }
    }
        return -1;
    }
    /**
     * This method returns the next Point of the current vertex
     * in the polygon
     * if there isn't it returns a null.
     * @param Point the vertex point precedes the given one by the method
     * @return the Point object of the next vertex
     */
    public Point getNextVertex(Point p){
        Point nextP=null;
        int index=this.findVertex(p);
        if(index != -1)
        {
            if (index < _noOfVertices-1)
            {
                nextP=new Point(_vertices[index+1]);
            }
            else{
                nextP=new Point(_vertices[0]);
            }
        }
        return nextP;
    }
    
    /**
     * This method return the bounding rectangle of a polygon 
     * if it has more than 3 vertices
     * @return  a new rectangle as a polygon object
     */
    public Polygon getBoundingBox(){
        double minX,maxX,minY,maxY;
        Polygon rectangle=null;
        if(_noOfVertices >=3 && _vertices!=null &&_vertices[0]!=null)
        {
            minX=_vertices[0].getX();
            maxX=_vertices[0].getX();
            minY=_vertices[0].getY();
            maxY=_vertices[0].getY();
            double otherX,otherY;
            for(int i=1;i<_noOfVertices;i++)
            {
                otherX=_vertices[i].getX();
                otherY=_vertices[i].getY();
                
                if(otherX< minX){
                    minX=otherX;
                }
                if(otherX > maxX){
                    maxX=otherX;
                }
                if(otherY < minY){
                    minY=otherY;
                }
                if(otherY > maxY){
                    maxY=otherY;
                }
            }
            rectangle=new Polygon();
            rectangle.addVertex(minX,minY);
            rectangle.addVertex(maxX,minY);
            rectangle.addVertex(maxX,maxY);
            rectangle.addVertex(minX,maxY);         
        }
        return rectangle;
    }
    
    
    
    
    
}
