package tests;

public class NextPrimeNumber {
	public static int nextPrime(int number){
		boolean isPrime=false;
		while(!isPrime){
			number+=1;
			int limit=(int)Math.ceil(Math.sqrt(number));
			isPrime=true;
			for(int i=2;i<=limit;i++){
				if(number%i==0){
					isPrime=false;
					break;
				}
			}
		}
		return number;
	}
	public static void main(String[] args) {
		System.out.println(nextPrime(2));
		
	}
}
