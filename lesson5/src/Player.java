// Seattle Prep CS class
// 12/16/2014
//
public class Player {
	// fields
	private String name;
	private Date birthday;

	// constructor
	public Player(String n, String d) {
		name = n;
		birthday = new Date(d);
	}

	// name accessor
	public String getName() {
		return name;
	}

	// birthday accessor
	public Date getBirthday() {
		return birthday;
	}

	// convert to string
	public String toString() {
		birthday.setPrintLongForm();
		return name + ", born " + birthday;
	}

}
