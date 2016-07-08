package com.endava.training.examples;

class Simple {

	int i;

	public Simple(int i) {
		i = 5;
	}
}

public class ExtendedSimple extends Simple {

	int extI;
	
	public ExtendedSimple() {
		super(10);
		System.out.println("Hello from constructor with no args");
	}

	public ExtendedSimple(int i) {
		super(i);
		System.out.println("Hello from constructor with 1 args");
	}

	public ExtendedSimple(int i, int j) {
		super(i);
		System.out.println("Hello from constructor with 2 args");
	}
}
