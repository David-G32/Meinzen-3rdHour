package abstractPackage;

import java.util.ArrayList;

import economicsSimulation.Point;

abstract class AbstractCurve implements CurveInterface
{
	private ArrayList<Point> newCurve;
	
	
	public AbstractCurve(Point p1, Point p2, int numPoints) {
		int maxPoints = 1+Math.abs((p2.getQuantity()-p1.getQuantity()));
		
		// This is a formula that tells if numPoints can fit cleanly between p1 and p2
		if (numPoints > 1 && (maxPoints-numPoints)%(numPoints-1) == 0) {
			newCurve = new ArrayList<Point>(numPoints);
			
			Point leftmostPoint;
			if (p1.getQuantity() < p2.getQuantity()) {
				leftmostPoint = p1;
			} else {
				leftmostPoint = p2;
			}
			
			int    startQuant = leftmostPoint.getQuantity();
			double startPrice = leftmostPoint.getPrice();
			
			int    jumpBy     = (maxPoints-1) / (numPoints-1);
			double priceDelta = 
				(p1.getPrice()-p2.getPrice()) / (p1.getQuantity()-p2.getQuantity());
			
			for (int i=0; i<numPoints; i++) {
				newCurve.add(
					new Point(
						startQuant + i*jumpBy,
						startPrice + i*jumpBy*priceDelta
					)
				);
			}
		} else {
			newCurve = new ArrayList<Point>(0);
		}
	}
	public boolean add(Point aP) {
		// if aP has the same quantity as another point, don't add it
		if (!searchForSameQuantity(aP.getQuantity())) {
			newCurve.add(aP);
			sortByQuantity();
			return true;
		}
		return false;
	}
	private boolean searchForSameQuantity(int quant) {
		for (Point p: newCurve) {
			if (p.getQuantity() == quant) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String temp = "[";
		for (int i=0; i<newCurve.size(); i++) {
			if (i != newCurve.size() - 1) {
				temp += newCurve.get(i).toString() + ", ";
			} else {
				temp += newCurve.get(i).toString();
			}
		}
		temp += "]";
		return temp;
	}
	public boolean delete(Point p) {
		boolean didRemove = newCurve.remove(p);
		
		// Trims the list to the size of the new list
		newCurve.trimToSize();
		return didRemove;
	}
	public boolean search(Point op) {
		return newCurve.contains(op);
	}
	
	abstract void sort();
	
	public void sortHelper() {
		sortByQuantity();
	}
	
	private void sortByQuantity() {
		for (int numChecks=newCurve.size()-1; numChecks>0; numChecks--) {
			for (int i=0; i<numChecks; i++) {
				if (newCurve.get(i).getQuantity() > newCurve.get(i).getQuantity()) {
					Point temp = newCurve.get(i);
					newCurve.set(i, newCurve.get(i+1));
					newCurve.set(i+1, temp);
				}
			}
		}
	}
}