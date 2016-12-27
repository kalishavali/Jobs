package Classes;

public class LocalClassMain {
	public void getLocalClass(){
		int num=6;
		class LocalInner{
			void eat(){
				System.out.println("Eat Method");
			}
		}
		LocalInner li=new LocalInner();
		li.eat();
	};
	public static void main(String[] args) {
		LocalClassMain lc=new LocalClassMain();
		lc.getLocalClass();
	}
}
