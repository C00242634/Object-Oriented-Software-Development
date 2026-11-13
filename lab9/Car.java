public class Car extends RoadVehicle
{
	private String carType;

	public Car(String c, int w, int p, double vehiclePrice)
	{
		super(w, p, vehiclePrice);
		carType = c;
	}

	public double calculateDuty()
	{
		return getPrice() * CARTAXRATE;
	}
}