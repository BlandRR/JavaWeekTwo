import java.util.ArrayList;

public class Person {

	private String Name;
	private String Occupation;
	private int Age;

	ArrayList<Person> list = new ArrayList<Person>();

	public Person(String name, String occupation, int age) {
		Name = name;
		Occupation = occupation;
		Age = age;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getOccupation() {
		return Occupation;
	}

	public void setOccupation(String occupation) {
		Occupation = occupation;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public void add(Person i) {
		list.add(i);
	}

	public void printList() {
		FileReaderClass frc = new FileReaderClass();
			frc.writeToFile("C:\\Users\\Admin\\File\\src\\"+ "FileArray" + ".txt", list);
	}

	@Override
	public String toString() {
		return "Person Name=" + Name + ", Occupation=" + Occupation + ", Age=" + Age;
	}

}
