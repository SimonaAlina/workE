package com.endava.training;

import com.endava.training.shape.impl.Circle;
import com.endava.training.shape.impl.Square;
import com.endava.training.shape.impl.Triangle;
import com.endava.training.examples.A;
import com.endava.training.examples.B;
import com.endava.training.examples.C;
import com.endava.training.examples.ExtendedSimple;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello OOP");

		Circle c = new Circle(5);
		Triangle tr = new Triangle(4, 5, 6);
		Square sq = new Square(4);

		System.out.println("Circle - area: " + c.computeArea());
		System.out.println("Circle - perimeter: " + c.computePerimeter());

		System.out.println("\nTriangle - area: " + tr.computeArea());
		System.out.println("Triangle - perimeter: " + tr.computePerimeter());

		System.out.println("\nSquare - area: " + sq.computeArea());
		System.out.println("Square - perimeter: " + sq.computePerimeter());

		System.out.println();

		new ExtendedSimple(10, 11);

		System.out.println();

		A ab = new B();
		ab.f(); // Hello from B
		B bc = new C();
		bc.f(); // Hello from C
		A ac = new C();
		ac.f();// Hello from C

	}

}
