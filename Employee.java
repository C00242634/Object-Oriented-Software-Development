// Student Name :	Kyle Wilson
// Student Id Number :	C00242634
// Date :		23/10/2026
// Purpose :		Store employee details and their assigned office.

public final class Employee
{
	public static final int MAX_EMPLOYEES = 5;
	private static int nextEmployeeNumber = 1000;
	private static int numberOfEmployees = 0;
	private final int employeeNumber;
	private final String name;
	private final Address address;
	private final String employeeType;
	private final String companyCarDetails;
	private final Office office;

	public Employee(String name, Address address, String employeeType, String companyCarDetails, Office office)
	{
		if (numberOfEmployees >= MAX_EMPLOYEES)
		{
			throw new IllegalStateException("Maximum of " + MAX_EMPLOYEES + " employee records reached.");
		}
		if (name == null || name.trim().isEmpty() || address == null || office == null)
		{
			throw new IllegalArgumentException("Name, address and office are required.");
		}
		if (!"Staff".equals(employeeType) && !"Manager".equals(employeeType))
		{
			throw new IllegalArgumentException("Type must be Staff or Manager.");
		}
		if ("Manager".equals(employeeType) && (companyCarDetails == null || companyCarDetails.trim().isEmpty()))
		{
			throw new IllegalArgumentException("Managers require company car details.");
		}
		if (office.isFull())
		{
			throw new IllegalStateException("Office is full.");
		}
		this.employeeNumber = nextEmployeeNumber;
		this.name = name;
		this.address = address;
		this.employeeType = employeeType;
		if (employeeType.equals("Manager"))
		{
			this.companyCarDetails = companyCarDetails;
		}
		else
		{
			this.companyCarDetails = "";
		}
		this.office = office;
		office.addEmployee(this);
		nextEmployeeNumber++;
		numberOfEmployees++;
	}

	// Getters
	public static int getNumberOfEmployees()
	{
		return numberOfEmployees;
	}

	public int getEmployeeNumber()
	{
		return employeeNumber;
	}

	public Office getOffice()
	{
		return office;
	}

	public String getName()
	{
		return name;
	}

	public Address getAddress()
	{
		return address;
	}

	public String getEmployeeType()
	{
		return employeeType;
	}

	public String getCompanyCarDetails()
	{
		return companyCarDetails;
	}

	// toString
	@Override
	public String toString()
	{
		String result = "Employee " + employeeNumber + " | " + name + " | " + employeeType + " | Address: " + address + " | Office: " + office.getRoomNumber();
		if (employeeType.equals("Manager"))
		{
			result += " | Company car: " + companyCarDetails;
		}
		return result;
	}
}