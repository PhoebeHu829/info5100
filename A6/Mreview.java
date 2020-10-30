import java.util.*;

public class Mreview implements Comparable<Mreview>{
	private String title;
	private ArrayList<Integer> ratings;
	
	public Mreview() {
		this.title = "";
		this.ratings = new ArrayList<Integer>();
	}
	
	public Mreview(String title) {
		this();
		this.title = title;
	}
	
	public Mreview(String title, int firstRating) {
		this(title);
		this.ratings.add(firstRating);
	}
	
	public void addrating(int r) {
		this.ratings.add(r);
	}
	
	public double aveRating() {
		if( this.numRatings() == 0) {
			return 0;
		}
		double total = 0.0;
		for(int r : this.ratings) {
			total += r;
		}
		return (double) total / this.ratings.size();
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int numRatings() {
		return this.ratings.size();
	}
	
	@Override
	public int compareTo(Mreview obj) {
		return this.title.compareTo(obj.title);
	}
	
	@Override
	public boolean equals(java.lang.Object obj) {
		return this.title.equals( ((Mreview) obj).getTitle() );
	}

	
	
	

}
