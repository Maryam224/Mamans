

/**
 * Temperature Conversion Calculator
 *
 * @author (Maryam)
 * @version (14/11/2020)
 */
import java.util.Scanner;

public class Temperature
{
   public static void main(String[] args) {       
       final double VAL1=273.15;
       final double VAL2=9.0/5;
       final double VAL3=32.0;
       double celsius=0,kelvin=0,fahrenheit=0;
       
       Scanner scan=new Scanner(System.in);
       
       System.out.print ("Please enter temperature scale you want to convert as follows :\n\t"
       +" C for Celsius"+"\n\t K for Kelvin"
       +"\n\t F for Fahrenheit"+"\nthen enter the value");
       
       String word = scan.next();
       char c = word.charAt(0);
       double temp=scan.nextDouble();
       
       
       if(c=='C'){
           celsius=temp;
           kelvin=celsius+VAL1;
           fahrenheit=celsius*VAL2+VAL3;
           
        }
        else if(c=='K'){
            kelvin=temp;
            celsius=kelvin-VAL1;
            fahrenheit=(VAL2*(kelvin-VAL1))+VAL3;     
            
        }
        else if(c=='F'){
            fahrenheit=temp;
            celsius=(1/VAL2)*(fahrenheit-VAL3);
            
            kelvin=((fahrenheit-VAL3)/VAL2)+VAL1;
         
        }
        else{
            System.out.println("Incorrect Values");
        }
        
        System.out.print(celsius +" C\n" + fahrenheit+" F\n" 
        + kelvin+" K");
    }
}
