package marketProject;

import com.sun.javafx.scene.paint.GradientUtils.Point;

public class ProducerCurve {
	
	private Point[] pCurveArray;
	
	public ProducerCurve() {
		pCurveArray = new Point[10];
		
		for(int i=0; i<pCurveArray.length; i++) {
			double p = i+1;
			int q = i+1;
			pCurveArray[i] = new Point(q,p);
		}
	}

	public boolean search(Point op)
	{
		for(Point p : pCurveArray) {
			if(p.equals(op)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * private helper method
	 */
	private int searchForIndex(Point op)
	{
		for(int i=0; i<pCurveArray.length; i++) {
			if(p.equals(op)) {
				return true;
			}
		}
		return -1; //havent found the point so return nonsense index
	}
	
	public void add(Point p) {
		Point [] newArray = new Point[pCurveArray.length+1];
		for (int i =0; i<pCurveArray.length; i++) {
			newArray[i] = pCurveArray[i];
		}
		newArray[newArray.length-1] = p;
		pCurveArray = newArray;
	}
	
	public String toString() {
		String temp = "ProducerCurve: ";
		for(point p : pCurveArray) {
			temp = temp + p.toString() + ", ";
		}
		return temp;
	}
	
	public void delete(Point p) {
		int findIndex = searchForIndex(p);
		
		// if point not found on curve then just skip the rest of method
		if(findIndex == -1) {return;}
		Point tempArray[] = new Point[pCurveArray.length-1];
		
		for(int i=0; i<findIndex; i++) {
			tempArray[i] = pCurveArray[i];
		}
		
		for(int i=findIndex; i<tempArray.length; i++) {
			tempArray[i] = pCurveArray[i+1];
		}
		
		pCurveArray = tempArray;
	}
	
}
