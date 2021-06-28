
/**
 * This program calculates the areas
 * and the perimeters of the excircle and the incircle
 *of a given rectangle
 *
 * @author (Maryam)
 * @version (14/11/2020)
 */
import java.util.Scanner;
public class Circle
{
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println ("This program calculates the areas " +
        "and the perimeters of the excircle and the incircle " +
        "of a given rectangle ");
        
        System.out.println ("Please enter the two coordinates of the " +
        "left-upper point of the rectangle");
        int leftUpX = scan.nextInt();
        int leftUpY = scan.nextInt();
        
        System.out.print ("Please enter the two coordinates of the " +
        "right-down point of the rectangle");
        int rightdownX = scan.nextInt();
        int rightDownY = scan.nextInt();
        
        int width = Math.abs(rightdownX-leftUpX);
        int height=Math.abs(rightDownY-leftUpY);
        //r is the radius for smaller circle R for the bigger one
        double r = height/2.0;//as we assume height<width
        double R = Math.sqrt((Math.pow(width,2))+(Math.pow(height,2)));
        R=R/2;
        
        double smallArea = Math.pow(r,2) * (Math.PI);
        double bigArea = Math.pow(R,2) * (Math.PI);
        
        double smallPerimeter = 2*r * (Math.PI);
        double bigPerimeter = 2*R * (Math.PI);
        
        System.out.println("Incircle: radius = "+r+" area: "+smallArea+" perimeter = "+smallPerimeter);
        System.out.println("Excircle: radius = "+R+" area: "+bigArea+" perimeter = "+bigPerimeter);
        
        
    }
    


    
    
    
}
