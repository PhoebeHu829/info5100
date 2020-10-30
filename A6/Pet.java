
public class Pet {
	private String name;
	private String owner;
	private String color;
	protected int sex;
	static private String[] POSSIBLE_SEX = new String[]{"FEMALE", "MALE", "SPAYED", "NEUTERED"};
    
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
		this.sex = sexid;
	}
	
	// Should return the string equivalent of the gender, e.g the string “MALE” etc.
	public String getSex() {
		return 	POSSIBLE_SEX[sex];
	}
	
	// Should return the name, owner’s name, age, color, and gender (use getSex());
	public String toString() {
		String res = this.name + " owned by " + this.owner + ", Color" + this.color + ", Sex: ";
		res += this.getSex();
		return res;
	}

}
