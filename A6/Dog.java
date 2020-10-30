
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
		return "DOG: " + super.toString() + ", Size: " + this.getSize();
	}

	@Override
	public void setBoardStart(int month, int day, int year) {
		if(this.validDate(year, month, day)) {
			this.startDate = this.dateSetter(year, month, day);
		} 
	}

	@Override
	public void setBoardEnd(int month, int day, int year) {
		if(this.validDate(year, month, day)) {
			this.endDate = this.dateSetter(year, month, day);
		}
	}

	@Override
	public boolean boarding(int month, int day, int year) {
		if(this.validDate(year, month, day) && this.startDate != 0 && this.endDate != 0) {
			int today = this.dateSetter(year, month, day);
			return ((today - this.startDate) >= 0 && (this.endDate - today >= 0));
		}
		return false;
	}
	
	private boolean validDate(int year, int month, int day) {
		String y = "" + year;
		if(y.length() != 4) return false;
		if( month < 1 || month > 12) return false;
		if( day < 1 || day > 31) return false;
		return true;
	}
	
	private int dateSetter(int year, int month, int day) {
		String date = "" + year;
		String mon = "" + month;
		String d = "" + day;
		if(mon.length() == 1) {
			date += "0";
		}
		date += month;
		if(d.length() == 1) {
			date += "0";
		}
		date += day;
		return Integer.parseInt(date);
	}
	
	public static void main(String[] args) {
		Dog p = new Dog("zico", "phoebe", "white", "medium");
		p.setSex(1);
		System.out.println(p.toString());
		p.setBoardStart(1, 31, 2017);
		p.setBoardEnd(8, 3, 2020);
		System.out.println(p.boarding(5, 20, 2019));
		System.out.println(p.boarding(5, 20, 2021));
	}

}
