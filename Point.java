package marketProject;

/**
 * @author Christopher Meyer
 * @class  AP Computer Science A
 * @hour   3rd
 * @date   8/18/2023
 */

public class Point extends Object{

	private double price;
	private int quantity;
	private final double TOLERANCE = 0.01; // each point defaults to a 1 penny tolerance for equality

	public Point(double p, int q) {
		price = p;
		quantity = q;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String toString() {
		return "("+quantity+", "+price+")";
	}
	
	public boolean equals(Object other) {
		return(this == other);
	}
	
	public boolean equals(Point otherPoint) {
		
		if((Math.abs(this.price - otherPoint.price)<= TOLERANCE) &&
				(this.quantity == otherPoint.quantity)) {
			return true;
		}
		return false;
	}
	
	public void setTolerance(double t) {
		tolerance = t;
	}

}
