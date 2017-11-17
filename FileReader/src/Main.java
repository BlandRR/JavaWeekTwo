
public class Main {

	
	
	public static void main (String[] args) {
		
		Person p = new Person("Ryan", "Computer Stuff", 23);
		Person p1 = new Person("Joe", "Computers", 20);
		Person p2 = new Person("Billy", "Chilling", 10);
		Person p3 = new Person("Jeff", "Stuff", 50);
		Person p4 = new Person("Jerry", "Work", 21);
		
		p.add(p);
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		
	//	p.printList();
		
		
		
		
		
		//FileReaderClass read = new FileReaderClass();
		p.printList();
		FileReaderClass frc = new FileReaderClass();
		frc.readfromFile();
		
		frc.printoutprint();
	
		}
	
}

