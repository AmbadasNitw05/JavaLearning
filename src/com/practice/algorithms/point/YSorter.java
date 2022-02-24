package com.practice.algorithms.point;

import java.util.Comparator;

public class YSorter implements Comparator<Point>{

	@Override
	public int compare(Point p1, Point p2) {
		return Double.compare(p1.getY(), p2.getY());
	}
}
