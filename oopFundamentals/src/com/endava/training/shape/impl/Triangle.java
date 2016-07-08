package com.endava.training.shape.impl;

import com.endava.training.shape.Shape2D;

public class Triangle implements Shape2D {

	double l1, l2, l3;
	double x, y;

	public Triangle(double l1, double l2, double l3) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
	}

	public Triangle() {
	}

	public double getL1() {
		return l1;
	}

	public void setL1(double l1) {
		this.l1 = l1;
	}

	public double getL2() {
		return l2;
	}

	public void setL2(double l2) {
		this.l2 = l2;
	}

	public double getL3() {
		return l3;
	}

	public void setL3(double l3) {
		this.l3 = l3;
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
		double p = (l1 + l2 + l3) / 2;
		return Math.sqrt(p * (p - l1) * (p - l2) * (p - l3));
	}

	@Override
	public double computePerimeter() {
		return l1 + l2 + l3;
	}
}
