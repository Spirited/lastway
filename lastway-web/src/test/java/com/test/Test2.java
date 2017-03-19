package com.test;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		String welcome = "Введите свое имя: ";
		
		System.out.print(welcome);
		
		String title = "Hello world ";
		
		Scanner in = new Scanner(System.in);
		
		String name = in.nextLine();
		System.out.println(title + name);
	}
}
