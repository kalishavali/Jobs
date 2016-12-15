package stacksQueues;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import linkedLists.ListNode;

public class StringSplitter {
	private Queue<Character> characters;
	private String token;
	public static final String SPECIAL_CHARACTERS="()+-*/^";
	public StringSplitter(String line){
		characters=new LinkedList<Character>();
		for(int i=0;i<line.length();i++){
			characters.add(line.charAt(i));
		}
		findNextToken();
	}
	public boolean hasNext(){
		return token!=null;
	}
	public String next(){
		checkToken();
		String result=token;
		findNextToken();
		return result;
	}
	public String peek(){
		checkToken();
		return token;
	}
	public void checkToken(){
		if(!hasNext())
			throw new NoSuchElementException();
	}
	public void findNextToken(){
		characters=removeWhiteSpace();
		if(characters.isEmpty())
			token=null;
		else{
			token=""+characters.remove();
			if(!SPECIAL_CHARACTERS.contains(token)){
				boolean done=false;
				while(!characters.isEmpty() && !done){
					char ch=characters.peek();
					if(SPECIAL_CHARACTERS.indexOf(ch)>=0){
						done=true;
					}else{
						token=token+characters.remove();
					}
				}
			}
		}
	}
	public Queue<Character> removeWhiteSpace(){
		Queue<Character> temp=new LinkedList<Character>();
		while(!characters.isEmpty()){
			Character ch=characters.remove();
			if(!Character.isWhitespace(ch))
				temp.add(ch);
		}
		return temp;
	}
	public String toString(){
		String result="[";
		while(!characters.isEmpty()){
			result+=","+characters.remove();
		}
		result+="]";
		return result;
	}
	public static void main(String[] args) {
		StringSplitter ss=new StringSplitter("( 2 + 3 )");
		System.out.println(ss);
	}
	
}
