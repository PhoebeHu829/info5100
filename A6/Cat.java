
public class Cat extends Pet implements Boardable {
	private String hairLength;
	private int startDate;
	private int endDate;

	Cat(String name, String owner, String color, String hairLength) {
		super(name, owner, color);
		this.hairLength = hairLength;
	}
	
	public String getHairLength() {
		return this.hairLength;
	}
	
	@Override
	public String toString() {
		String ans = super.toString();
		ans += " Hair: " + this.getHairLength();
		return "CAT " + ans;
	}

	@Override
	public void setBoardStart(int month, int day, int year) {
		String date = "" + year + day + month;
		this.startDate = Integer.parseInt(date);
	}

	@Override
	public void setBoardEnd(int month, int day, int year) {
		String date = "" + year + day + month;
		this.endDate = Integer.parseInt(date);
	}
		

	@Override
	public boolean boarding(int month, int day, int year) {
		String date = "" + year + day + month;
		int today = Integer.parseInt(date);
		return ((today - this.startDate) >= 0 && (this.endDate - today >= 0));
	}
	 
}
