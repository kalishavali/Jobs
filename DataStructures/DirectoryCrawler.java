package tests;

import java.io.File;

public class DirectoryCrawler {
	public static void displayDirectory(File f,int level){
		for(int i=0;i<level;i++){
			System.out.print("  ");
		}
		System.out.println(f.getName());
		if(f.isDirectory()){
			for(File subF:f.listFiles()){
				displayDirectory(subF,level+1);
			}
		}
	}
	public static void main(String[] args) {
		displayDirectory(new File("C:\\Users\\Kalishavali_PC\\Desktop\\TCS\\PractiseIT"),0);
	}
}
