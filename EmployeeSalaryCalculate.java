package info5100;

import java.util.Map;
import java.util.TreeMap;

public class EmployeeSalaryCalculate {
	
	
	/**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
	public double socialSecurityTax(Employee employee) {
        //write your code here
    	double salary = employee.salary;
    	if(salary <= 8900) {
    		System.out.println(employee.getName() + "'s Social Security Tax is " + salary * 0.062);
    		return salary * 0.062;
    	} 
    	System.out.println( employee.getName() + "'s Social Security Tax is " + 106800 * 0.062);
    	return 106800 * 0.062;
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) {
        //write your code here
    	int age = employee.age;
    	double salary = employee.salary;
    	double insuranceCover = 0;
    	
    	if(age < 35) {
    		insuranceCover = salary * 0.03;
    	} 
    	else if ( age >= 35 && age <= 50) {
    		insuranceCover = salary * 0.04;
    	}
    	else if( age > 50 && age < 60) {
    		insuranceCover = salary * 0.05;
    	} else {
    		insuranceCover = salary * 0.06;
    	}
    	
    	System.out.println( employee.getName() + "'s insurance coverage is " + insuranceCover);
    	return insuranceCover;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) {
        //write your code here
    	
    	Map< Double , String> salaries = new TreeMap< Double , String>();
    	salaries.put(e1.salary, e1.getName());
    	
    	if(salaries.containsKey(e2.salary)) {
    		String names = e1.getName() + " " + e2.getName();
    		salaries.replace(e2.salary, names);
    	} else {
    		salaries.put(e2.salary, e2.getName());
    	}
    	
    	if(salaries.containsKey(e3.salary)) {
    		String names = salaries.get(e3.salary) + " " + e3.getName();
    		salaries.replace(e3.salary, names);
    	} else {
    		salaries.put(e3.salary, e3.getName());
    	}
    	
    	String res = "";
    	for(String name : salaries.values()) {
    		res += name + " ";
    	}
    	
    	System.out.print(res.substring(0, res.length() - 1));
    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {
        //write your code here
    	employee.raiseSalary(200);
    }
    
    

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     write your understanding here.
     
     What gets passed to a method is a copy of the reference of the object,
     which means we cannot equal a to x or b to y. They are actually different
     references that both point to the same object. 
     So, no matter how many times we re-assign or swap the references, 
     the original reference will not be affected.
     
     In the high level, java is always passed by value. 
    */
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 9000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        Employee c = new Employee("Phoebe", 20, Gender.FEMALE, 1000);
        
        EmployeeSalaryCalculate e = new EmployeeSalaryCalculate();
        e.sortSalary(a, b, c);
        System.out.println();
        
        e.socialSecurityTax(a);
        e.insuranceCoverage(a);
        
        System.out.println("Before: a=" + a.getName() + " "+ a);
        System.out.println("Before: b=" + b.getName() + " " + b);
        swap(a, b);
        System.out.println("After: a=" + a.getName() + " " + a);
        System.out.println("After: b=" + b.getName() + "" + b);
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
}

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month

    // Constructor. Please set all the data in constructor.
    public Employee(String name, int age, Gender gender, double salary) {
        //write your code here
    	this.name = name;
    	this.age = age;
    	this.gender = gender;
    	this.salary = salary;
    }

    // Getter for `name`. Return the current `name` data
    public String getName() {
        //write your code here
    	return this.name;
    }

    // Setter for `name`. Set `name` data
    public void setName(String name) {
        //write your code here
    	this.name = name;
    }
    
    public void raiseSalary(double byPercent) {
    	this.salary = this.salary * (1 + byPercent * 0.01);
    }
}

enum Gender {
    MALE,
    FEMALE;
}
