
public class Test {
	
	public static void main(String[] args) {
		//initial instance of the Student object
        Student phoebe = new Student("Phoebe", "123456");
        Student zico = new Student("Zico", "145678");
        
        //test the getName method
        System.out.println(phoebe.getName());
        //test the getID method
        System.out.println(phoebe.getId());
        //test the setName method
        phoebe.setName("Linda");
        System.out.println(phoebe.getName());
        //test the setId method
        phoebe.setId("111");
        System.out.println(phoebe.getId());
        System.out.println(" ");
        
        //initial instance of Course object
        Course math = new Course("Math");
        //test get
        System.out.println(math.getClassName());
        //test isFull
        System.out.println(math.isFull());
        //test getResgisterStudentNum
        System.out.println(math.getResgisterStudentNum());
        
        //test registerStudent
        math.registerStudent(phoebe);
        math.registerStudent(zico);
        System.out.println(math.getResgisterStudentNum());
        
        //in a loop test the corresponding methods
        for(int i = 0; i < 15; i++) {
        	String name = "student" + i;
        	Student s = new Student(name, "" + i);
        	System.out.println(s.getName());
            System.out.println(s.getId());
            math.registerStudent(s);
            System.out.println(math.isFull());
            System.out.println(math.getResgisterStudentNum());
            System.out.println(" ");
        }
        
        // print out results.
        Student[] arr = math.getStudents();
        String[] names = new String[arr.length];
        for(int i = 0; i < arr.length; i++) {
        	names[i] = arr[i].getName();
        	System.out.println(names[i]);
        }
        
    }
}

class Student {
	private String name;
	private String id;
	
	
	 Student(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
}


class Course{
	private String name;
	private int numberOfStudent;
	static final int MAX = 10;
	private Student[] registeredStudent;
	
	Course(String name) {
		this.name = name;
		this.numberOfStudent = 0;
		this.registeredStudent = new Student[MAX];
	}
	
	public Student[] getStudents() {
		Student[] result = new Student[this.numberOfStudent];
		for(int i = 0; i < this.numberOfStudent; i++) {
			result[i] = this.registeredStudent[i];
		}
		return result;
	}
	
	public Boolean isFull() {
		return this.numberOfStudent >= MAX;
	}
	
	public int getResgisterStudentNum() {
		return this.numberOfStudent;
	}
	
	public String getClassName() {
		return this.name;
	}
	
	public void registerStudent(Student student) {
		if (this.numberOfStudent < MAX) {
			this.registeredStudent[this.numberOfStudent] = student;
			this.numberOfStudent++;
		}
		
	}
}
