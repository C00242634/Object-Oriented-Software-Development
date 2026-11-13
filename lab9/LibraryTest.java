public class LibraryTest
{
	public static void main(String args[])
	{
		LibraryItem[] items = new LibraryItem[2];
		LoanItem loanItem;
		int i;

		items[0] = new Book("B001", "A. Smith", "Learning Java", 300);
		items[1] = new CD("C001", "The Example Band", "First Album", 12);

		for(i = 0; i < items.length; i++)
		{
			loanItem = (LoanItem) items[i];
			System.out.println("Loan price: " + loanItem.calculatePrice());
		}
	}
}