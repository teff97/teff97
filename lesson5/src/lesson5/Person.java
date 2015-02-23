package lesson5;

public class Person {
	String firstName;
	String lastName;

	public void setFirstName(String s){
		firstName = s;
	}
	
	public void setLastName(String s){
		lastName = s;
	}
	
	public String getFullName(){
		return firstName + " " + lastName;
	}
}
