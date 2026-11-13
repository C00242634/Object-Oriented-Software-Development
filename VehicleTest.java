public class VehicleTest
{
	public static void main(String args[])
	{
		Car car = new Car("Saloon", 4, 5, 20000.0);
		HGV hgv = new HGV(20000, 6, 2, 50000.0);

		System.out.println("Car duty: " + car.calculateDuty());
		System.out.println("HGV duty: " + hgv.calculateDuty());
	}
}