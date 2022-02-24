package com.practice.algorithms.point;

import java.util.Comparator;

public class XSorter implements Comparator<Point>{

	@Override
	public int compare(Point p1, Point p2) {
		return Double.compare(p1.getX(), p2.getX());
	}
}
