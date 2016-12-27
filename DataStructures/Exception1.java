package exceptions;

public class Exception1 {
	public static void main(String[] args) {
		int n=5;
		int a=3;
		switch(n){
		case 1:
			System.out.println("one");
		case 2:
			System.out.println("two");
		case 3:
			System.out.println("three");
			break;
		default:
			System.out.println("default");
			break;
		}
		System.gc();
		System.out.println(a);
	}
}
