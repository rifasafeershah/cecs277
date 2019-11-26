public class CircleAbstractClass extends GeometricShape {
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(this.getRadius(),2);
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point[] getPoints() {
		// TODO Auto-generated method stub
		return this.getPoints();
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder("Circle - Points: ");
		Point [] corners = this.getRadius();
		for (int i = 0; i < corners.length; i++) {
			sb.append(corners[i].toString() + " ");
		}
		sb.append("\nArea: " + this.getArea() + " Perimeter: " + this.getPerimeter());
		return sb.toString();
	} // End of the toString method

}
