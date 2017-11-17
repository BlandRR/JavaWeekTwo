import java.util.ArrayList;

import javax.xml.bind.util.ValidationEventCollector;

public class Main {

	public static void main(String[] args) {

		System.out.println(new Person("Ryan", "23", "Computer Stuff"));

		PersonManager run = new PersonManager();

		Person Person1 = new Person("Bob", "22", "Builder");
		run.addperson(Person1);

		// list.add(Person1);

		Person Person2 = new Person("Harry", "21", "Stuff");
		// list.add(Person2);
		run.addperson(Person2);

		Person Person3 = new Person("Joe", "12", "Living");
		// list.add(Person3);
		run.addperson(Person3);

		Person Person4 = new Person("Dumbledore", "33", "Wizarding");
		// list.add(Person4);
		run.addperson(Person4);

		run.printlist();
		System.out.println(run.searchBoolean("Bob"));
		System.out.println(run.searchBoolean("Test"));
		run.Hunter("Bob");
		run.Hunter("adsasf");

		System.out.println("==============================================================");

		Garage g = new Garage();

		Vehicle g1 = new Car(100, 5, 5, 200000, "Red", "Car", "Audi");

		g.addvehicle(g1);

		Vehicle g2 = new Van(200, 3, 3, 90000, "White", "Van", 0);
		g.addvehicle(g2);

		Vehicle g3 = new Bike(300, 0, 2, 60000, "Green", "Bike", false);

		g.addvehicle(g3);

		g.printlist();
		g.priceofRepair();

		g.removevehicleInstanceCar();

		g.printlist();

		g.removeByClassType("Van");

		g.printlist();

		g.emptyGarage();

		g.printlist();
		System.out.println();

		g.addvehicle(g1);
		g.addvehicle(g2);
		g.addvehicle(g3);
		g.printlist();

		g.removeId(100);
		System.out.println();
		g.printlist(); 
		
		
		System.out.println("Print ID");
		g.printID(300);

		System.out.println("==================================================================");

		StringClass tester = new StringClass();
		tester.findlastWord("doggoesbark");

		System.out.println(tester.findlastWord("doggoesbark"));

		System.out.println(tester.charatValue("test"));

		System.out.println(tester.replacetest("test"));

	}
}
