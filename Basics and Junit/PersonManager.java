import java.util.ArrayList;

public class PersonManager {

	
	ArrayList<Person> list = new ArrayList<Person>();
	
	
	 public ArrayList<Person> getList() {
	       return list;
	   }
	
	public boolean searchBoolean (String search) {
		for(Person i : list) {
			if (i.getName().equals(search)) 
				return true;
		}
		return false;
	}
	
	
	public void Hunter(String namefinder) {
		for(Person i : list)
			if (i.getName().equals(namefinder)) {
			System.out.println(i);
			}
	}
	
	
	
	public void printlist() {
		for(Person i : list)
			System.out.println(i);
	}
	
	public void addperson(Person person) {
		list.add(person);
	}
}
