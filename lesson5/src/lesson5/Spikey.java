package lesson5;

public class Spikey {

	public static void main (String[]args){
		Person p1 = new Person();
		p1.setFirstName("Chris");
		p1.setLastName("Barth");
		System.out.println(p1.getFullName());
		System.out.println();
		Teacher t1 = new Teacher();
		t1.setFirstName("Norm");
		t1.setLastName("Hardy");
		t1.setDepartment("Math");
		System.out.println(t1.getFullName());
		System.out.println(t1.getDepartment());
		System.out.println();
		Student s1 = new Student();
		s1.setFirstName("Conor");
		s1.setLastName("Garand");
		s1.setGraduationYear(2016);
		System.out.println(s1.getFullName());
	}
}
