import java.util.Arrays;

public class HelloWorld {

	
	public static String Word = "Hello World";
	
	 //int [] Array = new int [10];
		static int [] Array = {5,20,12,3,5,7,12,53,24,10};
		static int [] arrayNew = new int [5];
		
	
	
	public String Input(String Input) {
		return Input + "!";
	}
	
	
	public int Sum (int a, int b) {
		int c = a + b;

		return c;
	}
	
	
	public int sumBoolean (int a, int b, Boolean test) {
		
		if(test) {
			int c = a + b;
			return c;
		}
		else {
			int c = a * b;
			return c;
		}
	}
		
	
public int nonZero (int a, int b) {
		
		if (a == 0) {
			return b;
		}
		else if (b == 0) {
			return a;
			
		}
		else {
			int c = a + b;
			return c;
		}
	}
	



	public static void printArray(int[] Array) {
		for(int i : Array)
		System.out.println(i);
		
}
	
	
	public static void fillArray(int[] array) {
		
			for (int i = 0; i < array.length; i++) {
				array[i] = i;
				System.out.println(array[i]);
			}
			System.out.println();
	}
	
	
	public static void timesTen(int[] array) {
		
		for (int i = 0; i < 5; i++) {
			array[i] = i * 10;
			System.out.println(array[i]);
		}
		System.out.println();
}
	
	
	public static void blackJack (int a, int b) {
		
		if (a > 21 && b > 21) {
			System.out.println("Both Players over 21");
			System.out.println(0);
		}
		else if (a > 21 && b <= 21) {
			System.out.println("Player B is closer Winner!");
			System.out.println(b);
		}
		else if (a <= 21 && b > 21) {
			System.out.println("Player A is closer Winner!");
			System.out.println(a);
		}
		else {
		 int One = 21 - a;
		 int Two = 21 - b; 
		 
		if (One < Two) {
			System.out.println("One Wins");
			System.out.println(a);
		}
		else if (Two < One) {
			System.out.println("Two Wins");
			System.out.println(b);
		} else {
			System.out.println("Draw");
			}			
		}
	}
	
	

//	uniqueSum(1,2,3);
//	uniqueSum(3,3,3);
//	uniqueSum(1,1,2);
	public static void uniqueSum(int a, int b, int c) {
			if (a == b && a == c){
				System.out.println(0);
			}
			 if (a != b && a != c) {
				 System.out.println(a + b + c);
			 }
			 if (a == b && a != c) {
				 System.out.println(c);
			 }
			 if (a != b && a == c) {
				 System.out.println(b);
			 }
	}
	
	
	
	public static boolean Temperature (int a, boolean isSummer) {
		
		if(isSummer) {
			if (a >= 60 && a <= 100) {
				return true;
				}
			else if (a > 100 || a < 60) {
				return false;
			}
		
		else {
			if (a >= 60 && a <=90) {
				return false;
		} else if (a > 90 || a < 60) {
			return false;
				}
			}
		}
		return isSummer;
	}
	
	
	public static void main (String[] args) {
		System.out.println(Word);

		//System.out.println(args[0]);
		
		System.out.println(new HelloWorld().Input(Word));
		
		System.out.println(new HelloWorld().Sum(2, 1));
		
		System.out.println(new HelloWorld().sumBoolean(2, 6, true));
		
		System.out.println(new HelloWorld().sumBoolean(2, 6, false));
		
		System.out.println(new HelloWorld().nonZero(0, 1));
		
		System.out.println(new HelloWorld().nonZero(1, 1));
		
		System.out.println(new HelloWorld().nonZero(2, 0));
		
		System.out.println();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(new HelloWorld().nonZero(i, 5));
		}
		 
		System.out.println();
		
		for (int i = 0; i < 10; i++) {
			int b = Array[i];
			System.out.println(new HelloWorld().nonZero(b, 5));
		}
		
		System.out.println("");
		System.out.println("Print Array");
		System.out.println("");
		printArray(Array);
		System.out.println("");
		fillArray(arrayNew);
		timesTen(arrayNew);
		
		blackJack(18, 21);
		blackJack(20, 18);
		blackJack(22, 22);
		
		System.out.println("");
		
		uniqueSum(1,2,3);
		uniqueSum(3,3,3);
		uniqueSum(1,1,2);
		System.out.println("");
		System.out.println(Temperature(100, true));
		System.out.println(Temperature(110, true));
		System.out.println(Temperature(100, false));
	
		
	}
	

}
