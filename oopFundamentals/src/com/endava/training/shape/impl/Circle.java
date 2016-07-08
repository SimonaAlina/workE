package com.endava.training.shape.impl;

import com.endava.training.shape.Shape2D;

public class Circle implements Shape2D {

	double radius;
	double x, y;

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle() {
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public double computeArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double computePerimeter() {
		return 2 * Math.PI * radius;
	}

}
