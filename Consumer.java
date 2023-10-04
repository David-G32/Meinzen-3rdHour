package abstractPackage;

public class Consumer 
{
	private ConsumerCurve myCCurve = new ConsumerCurve(new Point(1, 10.0), new Point(10, 1.0), 10);
	private double tolerance = 0.01;
	
	public Point respondToBid(Point p)
	{
		System.out.println("Consumer: " + myCCurve.toString());
		
		if (myCCurve.lessThanOrWithinTolerancePrice(p, tolerance))
		{
			System.out.println("consumer matches");
			return p;
		}
		
		return myCCurve.closestLessOrEqualQuant(p);
	}
}
