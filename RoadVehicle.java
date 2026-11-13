public abstract class RoadVehicle implements ImportDuty
{
	private int wheels;
	private int passengers;
	private double price;

	public RoadVehicle(int w, int p, double vehiclePrice)
	{
		wheels = w;
		passengers = p;
		price = vehiclePrice;
	}

	public double getPrice()
	{
		return price;
	}

	public abstract double calculateDuty();
}