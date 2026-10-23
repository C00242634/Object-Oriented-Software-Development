// Student Name :	Kyle Wilson
// Student Id Number :	C00242634
// Date :		23/10/2026
// Purpose :		Store an office and the employees assigned to it.

public class Office
{
	private static final int MAX_EMPLOYEES = 2;
	private static int nextRoomNumber = 100;
	private final int roomNumber;
	private final Employee[] employees = new Employee[MAX_EMPLOYEES];
	private int employeeCount = 0;

	public Office()
	{
		roomNumber = nextRoomNumber;
		nextRoomNumber++;
	}

	public int getRoomNumber()
	{
		return roomNumber;
	}

	public int getNumberOfEmployees()
	{
		return employeeCount;
	}

	// Checks if another employee can be assigned.
	public boolean isFull()
	{
		return employeeCount == employees.length;
	}

	public void addEmployee(Employee employee)
	{
		if (employee == null || employee.getOffice() != this)
		{
			throw new IllegalArgumentException("Employee must belong to this office.");
		}
		for (int i = 0; i < employeeCount; i++)
		{
			if (employees[i] == employee)
			{
				throw new IllegalArgumentException("Employee already assigned.");
			}
		}
		if (isFull())
		{
			throw new IllegalStateException("Office is full.");
		}
		employees[employeeCount] = employee;
		employeeCount++;
	}

	// Return the actual records in a separate array.
	public Employee[] getEmployees()
	{
		Employee[] records = new Employee[employeeCount];
		for (int i = 0; i < employeeCount; i++)
		{
			records[i] = employees[i];
		}
		return records;
	}

	// toString
	@Override
	public String toString()
	{
		return "Office " + roomNumber + " - " + employeeCount + "/" + MAX_EMPLOYEES + " employees";
	}
}