package marketProject;

public class TestPoint {
	
	private Point p0;
	private Point p1;
	
	public TestPoint() {
		//constructor
		
		testConstructors();
		
		testAccesoryMutators();
		
		testEquals();
	}
	
	public void testContructors() {
		p0 = new Point();
		System.out.println("p0 is "+p0.toString());
		p1 = new Point(1,1.0);
		System.out.println("p1 is "+p1.toString());
	}
	
	public void testAccesorMutators() {
		System.out.println("p0 has a quantity "+p0.getQuantity()+" and price "+p0.getPrice());
		System.out.println("p1 has a quantity "+p1.getQuantity()+" and price "+p1.getPrice());
	}
	
	public void testEquals() {
		p0 = new Point(1,1.0);
		p1 = new Point(2,1.0);
		
		System.out.println("are p0 and p1 equal?" + p1.equals(p0));
	}
	
	public static void main(String arg[]) {
		TestPoint app = new TestPoint();
	}

}
