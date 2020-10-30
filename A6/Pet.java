

public class Pet {
	private String name;
	private String owner;
	private String color;
	private int sex;
	// FEMALE -> 1, MALE -> 2, SYAYED -> 3, NEUTERED -> 4;
	static final String[] POSSIBLE_SEX = new String[]{"Unknown", "FEMALE", "MALE", "SPAYED", "NEUTERED"};
    
	Pet(String name, String owner, String color) {
		this.name = name;
		this.owner = owner;
		this.color = color;
	}
	
	public String getPetName() {
		return this.name;
	}

	public String getOwnerName() {
		return this.owner;
	}

	public String getColor() {
		return this.color;
	}

	public void setSex(int sexid) {
		if(sexid >= 1 && sexid <= 4) {
			this.sex = sexid;
		} else {
			System.out.println("Invalid input. sexid should be an integer in the range of 1 to 4, inclusive.");
		}
	}
	
	// Should return the string equivalent of the gender, e.g the string “MALE” etc.
	public String getSex() {
		return POSSIBLE_SEX[this.sex];
	}
	
	// Should return the name, owner’s name, age, color, and gender (use getSex());
	public String toString() {
		String res = this.name + " owned by " + this.owner + ", Color " + this.color + ", Sex: " + this.getSex();
		return res;
	}
	
	public static void main(String[] args) {
		Pet p = new Pet("zico", "phoebe", "white");
		System.out.println(p.toString());
		p.setSex(8);
		p.setSex(2);
		System.out.println(p.toString());
	}

}
