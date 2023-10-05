package marketProject;

public class TestProducerCurve {
	
	public TestProducerCurve() {
		
		ProducerCurve pc = new ProducerCurve();
		System.out.println(pc.toString());
		
		Point op = new Point(5, 5.0); //should be true
		op = new Point(0,0.0); //left of curve (should be false)
		op = new Point(5,6.0); // above curve (should be false)
		op = new Point(-1, -1.0); // left of curve and illegal? point
		op = new Point(5, 4.0); //belove curve (should be false)
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("Is" + op.toString() + "on the curve?" +pc.search(op));
	}
	
	public static void main(String[] args) {
		new TestProducerCurve();
	}
}
