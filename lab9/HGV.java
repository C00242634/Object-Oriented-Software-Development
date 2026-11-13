public class HGV extends RoadVehicle
{
	private int cargo;

	public HGV(int c, int w, int p, double vehiclePrice)
	{
		super(w, p, vehiclePrice);
		cargo = c;
	}

	public double calculateDuty()
	{
		return getPrice() * HGVTAXRATE;
	}
}