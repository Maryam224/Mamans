package Maman15;

public class Maman15Tester {
/**
 * 
 * @param args
 */
	public static void main(String[] args) {
		System.out.println("************************ MMN 15 TEST START **************************");

		System.out.println("***** b1 = new  BigNumber() = ");
		BigNumber b1 = new BigNumber();
		System.out.println(b1);

		System.out.println("\n***** b2 = new BigNumber(1234567895432L) = ");
		BigNumber b2 = new BigNumber(1234567895432L);
		System.out.println(b2);

		System.out.println("\n****** b3 = new BigNumber(b2) = ");
		BigNumber b3 = new BigNumber(b2);
		System.out.println("b3 is: "+b3);

		System.out.println("\n****** b4 = b3.addLong(123456789L) = ");
		BigNumber b4 = b3.addLong(123456789L);
		System.out.println("b4 is: "+b4);
		long a=1234567895432L;
		long b=123456789L;
		long sum=a+b;
		System.out.println("b4 should be :"+ sum);
		

		System.out.println("\n****** b5 = b3.addBigNumber(b4) = ");
		BigNumber b5 = b3.addBigNumber(b4);
		System.out.println("b5 is: "+b5);
		 a = Long.parseLong(b3.toString());
		 b=Long.parseLong(b4.toString());
		 sum=a+b;
		System.out.println("b5 should be :"+ sum);

		System.out.println("\n****** b6 = b4.subtractBigNumber(b2) = ");
		BigNumber b6 = b4.subtractBigNumber(b2);
		System.out.println("b6 is: "+b6);
		a = Long.parseLong(b4.toString());
		 b=Long.parseLong(b2.toString());
		 long sub=a-b;
		System.out.println("b6 should be :"+ sub);
		BigNumber b9 = b2.subtractBigNumber(b4);
		System.out.println("the result of opposite sub must be the same:"+b9);

		System.out.println("\n****** comp = b2.compareTo(b3) = ");
		System.out.println("b2 is: "+b2);
		System.out.println("b3 is: "+b3);
		int comp = b2.compareTo(b3);
		System.out.println(comp);

		System.out.println("\n****** b7 = b2.multBigNumber(b4) = ");
		BigNumber b7 = b2.multBigNumber(b4);
		System.out.println("b2 is: "+b2);
		System.out.println("b4 is: "+b4);
		System.out.println("b7 is: "+b7);
		long f=Long.parseLong(b2.toString());
		long s=Long.parseLong(b4.toString());
		long multp=f*s;
		System.out.println("b2*b4 should be: "+multp);
		System.out.println("M*********************************************************************M");
		BigNumber p1=new BigNumber(437L);
		BigNumber p2=new BigNumber(129L);
		System.out.println(p1+" and multiply to "+p2);
		System.out.println("p2*p1 "+p2.multBigNumber(p1).toString());
		System.out.println("p1*p2 "+p1.multBigNumber(p2).toString());
		System.out.println("should be "+437L*129L);
		

		System.out.println("\n************************ MMN 15 TEST END **************************");
		

	}

}
