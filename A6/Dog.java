
public class Dog extends Pet implements Boardable{
	private String size;
	private int startDate;
	private int endDate;

	Dog(String name, String owner, String color, String size) {
		super(name, owner, color);
		this.size = size;
	}
	
	public String getSize() {
		return this.size;
	}
	
	@Override
	public String toString() {
		return "DOG: " + super.toString() + " Size: " + this.getSize();
	}

	@Override
	public void setBoardStart(int month, int day, int year) {
		String date = "" + year + month + day;
		this.startDate = Integer.parseInt(date);
	}

	@Override
	public void setBoardEnd(int month, int day, int year) {
		String date = "" + year + month + day;
		this.endDate = Integer.parseInt(date);
		
	}

	@Override
	public boolean boarding(int month, int day, int year) {
		String date = "" + year + month + day;
		int today = Integer.parseInt(date);
		
		return (today - this.startDate) >= 0 && (this.endDate - today) >= 0;
	}

}
