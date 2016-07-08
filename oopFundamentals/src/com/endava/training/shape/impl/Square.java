package com.endava.training.shape.impl;

import com.endava.training.shape.Shape2D;

public class Square implements Shape2D {

	double size;
	double x, y;

	public Square(double size) {
		this.size = size;
	}

	public Square() {

	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
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
		return size * size;
	}

	@Override
	public double computePerimeter() {
		return 4 * size;
	}

}
