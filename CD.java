public class CD extends LibraryItem implements LoanItem
{
	private String band;
	private String title;
	private int numTracks;

	public CD(String itemID, String bandName, String cdTitle, int tracks)
	{
		super("CD", itemID);
		band = bandName;
		title = cdTitle;
		numTracks = tracks;
	}

	public double calculatePrice()
	{
		return numTracks * 0.50;
	}
}