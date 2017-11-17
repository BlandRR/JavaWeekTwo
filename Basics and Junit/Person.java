import java.util.ArrayList;

public class Person {

	
	private String Name;
	private String Age;
	private String jobTitle;

	public Person(String name, String age, String jobTitle) {
		this.Name = name;
		this.Age = age;
		this.jobTitle = jobTitle;
	}
	
	public String getName() {
		return Name;
	}

	@Override
	public String toString() {
		return "Person [Name =" + " " + Name + ", Age =" + " " + Age + ", jobTitle =" +  " " + jobTitle + "]";
	}
}
