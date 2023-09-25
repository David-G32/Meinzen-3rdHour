package abstractPackage;

import economicsSimulation.Point;

public class ConsumerCurve extends AbstractCurve {

	public ConsumerCurve(Point p1, Point p2, int numPoints) {
		super(p1, p2, numPoints);
	}
	
	public void sort() {
		super.sortHelper();
	}
}