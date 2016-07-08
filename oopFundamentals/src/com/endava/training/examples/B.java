package com.endava.training.examples;

public class B extends A {
	
	public void f() {
		System.out.println("Hello from B");
	}
	
	public void f(int x) {
		System.out.println("Hello from B - 1 arg");
	}
	
	public void f(int x, int y) {
		System.out.println("Hello from B - 2 args");
	}
}
