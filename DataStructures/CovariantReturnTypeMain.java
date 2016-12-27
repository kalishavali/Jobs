package Classes;

public class CovariantReturnTypeMain {
	CovariantReturnTypeMain getVal(){
		return this;
	}
	public static void main(String[] args) {
		
		new B().getVal().message();
	}
}
class B extends CovariantReturnTypeMain{
	B getVal(){
		return this;
	}
	void message(){
		System.out.println("This is Subclass Message");
	}
	
}
