// Student Name :	Kyle Wilson
// Student Id Number :	C00242634
// Date :		23/10/2026
// Purpose :		Store the street, city or town and county of an employee.

public class Address
{
	private final String street;
	private final String cityTown;
	private final String county;

	public Address(String street, String cityTown, String county)
	{
		this.street = street;
		this.cityTown = cityTown;
		this.county = county;
	}

	public String getStreet()
	{
		return street;
	}

	public String getCityTown()
	{
		return cityTown;
	}

	public String getCounty()
	{
		return county;
	}

	// toString
	@Override
	public String toString()
	{
		return street + ", " + cityTown + ", " + county;
	}
}