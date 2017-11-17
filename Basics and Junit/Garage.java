import java.awt.List;
import java.util.ArrayList;

public class Garage {

	Van van = new Van(0,0, 0, 0, null, null, 0);
	Car car = new Car(0,0, 0, 0, null, null, null);
	Bike bike = new Bike(0,0, 0, 0, null, null, false);
	
	ArrayList<Vehicle> list = new ArrayList<Vehicle>();

	public void priceofRepair() {
		for (int i = 0; i < list.size(); i++) {
		

			if (list.get(i) instanceof Car) {
				System.out.println("\n" +list.get(i).toString() + "\n" + "Price to fix Car = " + car.getRepairCar());
			} else if (list.get(i) instanceof Van) {
				System.out.println("\n" +list.get(i).toString() + "\n" + "Price to fix Van = " + van.getRepairVan());
			} else if (list.get(i) instanceof Bike) {
				System.out.println("\n" +list.get(i).toString() + "\n" + "Price to fix Bike = " + bike.getRepairBike());
			}
		}
	}

	public void addvehicle(Vehicle g) {
		list.add(g);
	}

	public void printlist() {
		for (Vehicle i : list)
			System.out.println(i);
	}
	
	
	public void printID(int id) {
		for (Vehicle i : list)
			if (i.getReg() == id)
			System.out.println(i);
	}
	
	

	public void removeVehicle(Vehicle g) {
		list.remove(g);
	}

	public void removevehicleType(String type) {
		for (int i = 0; i < list.size(); i++) {
			if (type.equals(list.get(i).getType())) {
				list.remove(i);
			}
		}
	}
	
	

	public void removevehicleInstanceCar() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Car) {
				list.remove(i);
			}
		}
	}
	
	
	public void removeByClassType(String type) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getClass().getCanonicalName().equals(type)) {
				list.remove(i);
			}
		}
	}
	
	public void emptyGarage() {
		for (int i = 0; i < list.size(); i++) {
			list.removeAll(list);
		}
	}
	
	
	public void removeId(int a) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getReg()==a) {
			list.remove(i);
			}
		}
	}
	
	
	

}
