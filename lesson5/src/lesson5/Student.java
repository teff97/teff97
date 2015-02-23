package lesson5;

public class Student extends Person{

	int graduationYear;
	
	public void setGraduationYear(int i){
		graduationYear = i;
	}
	
	public int getGraduationYear(){
		return graduationYear;
	}
	
	public String getFullName(){
		return firstName + " " + lastName + " " + graduationYear;
	}
}
