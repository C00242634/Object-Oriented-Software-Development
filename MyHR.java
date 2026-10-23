// Student Name :	Kyle Wilson
// Student Id Number :	C00242634
// Date :		23/10/2026
// Purpose :		Manage employee records and office allocation using a menu.

public class MyHR
{
	private static final int NUMBER_OF_OFFICES = 3;
	private final Office[] offices = new Office[NUMBER_OF_OFFICES];
	private final Employee[] employees = new Employee[Employee.MAX_EMPLOYEES];
	private int employeeCount = 0;

	public MyHR()
	{
		for (int i = 0; i < offices.length; i++)
		{
			offices[i] = new Office();
		}
	}

	public static void main(String[] args)
	{
		MyHR system = new MyHR();
		system.run();
	}

	public void run()
	{
		boolean running = true;
		while (running)
		{
			System.out.println("\nMyHR");
			System.out.println("1. List all offices");
			System.out.println("2. Create a new employee record");
			System.out.println("3. List all employees");
			System.out.println("0. Exit");
			System.out.print("Choose an option: ");
			String choice = EasyIn.getString().trim();
			switch (choice)
			{
				case "1":
					listOffices();
					break;
				case "2":
					createEmployee();
					break;
				case "3":
					listEmployees();
					break;
				case "0":
					running = false;
					break;
				default:
					System.out.println("Please enter 0, 1, 2 or 3.");
			}
		}
		System.out.println("Goodbye.");
	}

	private void listOffices()
	{
		for (Office office : offices)
		{
			System.out.println(office);
			for (Employee employee : office.getEmployees())
			{
				System.out.println("  " + employee);
			}
		}
	}

	private void createEmployee()
	{
		if (employeeCount == Employee.MAX_EMPLOYEES)
		{
			System.out.println("Maximum of " + Employee.MAX_EMPLOYEES + " employee records reached.");
			return;
		}

		String name = readRequired("Employee name: ");
		String street = readRequired("Street: ");
		String city = readRequired("City/town: ");
		String county = readRequired("County: ");

		String type;
		while (true)
		{
			type = readRequired("Employee type (Staff or Manager): ");
			if (type.equalsIgnoreCase("Staff"))
			{
				type = "Staff";
				break;
			}
			if (type.equalsIgnoreCase("Manager"))
			{
				type = "Manager";
				break;
			}
			System.out.println("Please enter Staff or Manager.");
		}

		String carDetails = "";
		if (type.equals("Manager"))
		{
			carDetails = readRequired("Company car (make, model and registration): ");
		}

		listOffices();
		Office selectedOffice = null;
		while (selectedOffice == null)
		{
			String room = readRequired("Office room number: ");
			try
			{
				int roomNumber = Integer.parseInt(room);
				for (Office office : offices)
				{
					if (office.getRoomNumber() == roomNumber)
					{
						if (office.isFull())
						{
							System.out.println("That office is full (maximum 2 people).");
						}
						else
						{
							selectedOffice = office;
						}
						break;
					}
				}
				if (selectedOffice == null)
				{
					System.out.println("Pick an existing office with a free space.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Please enter a room number.");
			}
		}

		Address address = new Address(street, city, county);
		Employee employee = new Employee(name, address, type, carDetails, selectedOffice);
		employees[employeeCount] = employee;
		employeeCount++;
		System.out.println("Created: " + employee);
	}

	private void listEmployees()
	{
		System.out.println("Employee records: " + Employee.getNumberOfEmployees());
		if (employeeCount == 0)
		{
			System.out.println("No employees have been created yet.");
		}
		for (int i = 0; i < employeeCount; i++)
		{
			System.out.println(employees[i]);
		}
	}

	// Keeps asking until a non blank valie is entered.
	private String readRequired(String prompt)
	{
		while (true)
		{
			System.out.print(prompt);
			String value = EasyIn.getString().trim();
			if (!value.isEmpty())
			{
				return value;
			}
			System.out.println("This field can't be blank.");
		}
	}

	// toString
	@Override
	public String toString()
	{
		return "MyHR: " + offices.length + " offices, " + employeeCount + " employees";
	}
}