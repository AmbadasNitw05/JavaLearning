package com.practice.algorithms.point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestPoint {
	
	private List<Point> points;
	
	public ClosestPoint(List<Point> points) {
		this.points = points;
	}
	
	public double getClosestDistance() {
		List<Point> sortedPointsX = new ArrayList<Point>(); 
		List<Point> sortedPointsY = new ArrayList<Point>();
		
		// RTC - O(N)
		for(Point p: this.points) {
			sortedPointsX.add(p); // SC: O(N)
			sortedPointsY.add(p);
		}
				
		Collections.sort(sortedPointsX, new XSorter()); // RTC: O(NlogN)
		Collections.sort(sortedPointsY, new YSorter()); // RTC: O(NlogN)
		
		return findMinDistance(sortedPointsX, sortedPointsY);
		
		
	}

	private double findMinDistance(List<Point> sortedPointsX, List<Point> sortedPointsY) {
		// Base condition
		int numOfPoints = sortedPointsX.size();
		if(numOfPoints <= 3)
			return findMinDistanceBruteForce(sortedPointsX);
		
		int middleIndex = numOfPoints/2;
		Point middlePoint = sortedPointsX.get(middleIndex);
		
		List<Point> leftSortedPointsX = new ArrayList<Point>();
		List<Point> rightSortedPointsX = new ArrayList<Point>();
		
		for(int i=0; i<numOfPoints; i++) {
			if(i<=middleIndex)
				leftSortedPointsX.add(sortedPointsX.get(i));
			else
				rightSortedPointsX.add(sortedPointsX.get(i));
		}
		
		double deltaLeft = findMinDistance(leftSortedPointsX, sortedPointsY);
		double deltaRight = findMinDistance(rightSortedPointsX, sortedPointsY);
		
		double delta = Math.min(deltaLeft, deltaRight);
		
		List<Point> stripPoints = new ArrayList<Point>();
		
		for(int i=0; i<numOfPoints; i++) {
			if(Math.abs(sortedPointsY.get(i).getX() - middlePoint.getX()) < delta) {
				stripPoints.add(sortedPointsY.get(i));
			}
		}
		
		double deltaStrip = findMinDistanceInStrip(stripPoints, delta);
		
		return Math.min(delta, deltaStrip);
		
	}

	private double findMinDistanceInStrip(List<Point> stripPoints, double delta) {
		double minDistance = delta;
		
		for(int i=0; i<stripPoints.size(); i++) {
			for(int j=1; 
					j<stripPoints.size() 
					&& (stripPoints.get(j).getY() - stripPoints.get(i).getY()) < minDistance; j++) {
				double distance = distance(stripPoints.get(i), stripPoints.get(j));
				minDistance = Math.min(minDistance, distance);
			}
		}
		return minDistance;
	}

	private double findMinDistanceBruteForce(List<Point> sortedPointsX) {
		double minDistance = Double.MAX_VALUE;
		
		for(int i=0; i<sortedPointsX.size(); i++) {
			for(int j=i+1; j<sortedPointsX.size(); j++) {
				double distance = distance(sortedPointsX.get(i), sortedPointsX.get(j));
				minDistance = Math.min(minDistance, distance);
			}
		}
		
		return minDistance;
	}

	private double distance(Point point1, Point point2) {
		double xDistance = point1.getX() - point2.getX();
		double yDistance = point1.getY() - point2.getY();
		return Math.sqrt(xDistance *xDistance + yDistance*yDistance);
	}

	public static void main(String[] args) {
		List<Point> points = Arrays.asList(
				new Point(1.5,1),
				new Point(1,2),
				new Point(2,1),
				new Point(3,1),
				new Point(4,5),
				new Point(5,5)
				);
		
		ClosestPoint cp = new ClosestPoint(points);
		System.out.println(cp.getClosestDistance());

	}

}
