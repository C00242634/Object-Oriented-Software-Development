public class Book extends LibraryItem implements LoanItem
{
	private String author;
	private String title;
	private int numPages;

	public Book(String itemID, String bookAuthor, String bookTitle, int pages)
	{
		super("Book", itemID);
		author = bookAuthor;
		title = bookTitle;
		numPages = pages;
	}

	public double calculatePrice()
	{
		return numPages * 0.01;
	}
}