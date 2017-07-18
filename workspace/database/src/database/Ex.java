package database;

import java.util.Scanner;

public class Ex {
	public static void main(String[] args ){
		String a,b;
		Scanner s=new Scanner(System.in);
		System.out.println("enter first name");
		a=s.next();
		System.out.println("enter last name");
		b=s.next();
		System.out.println(a+b);
		System.out.println(a.replaceAll("u","a"));
		System.out.println("my name is" +a+b);
	}
}
