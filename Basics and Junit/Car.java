
public class Car extends Vehicle {

	
	int repairCar = 400;
	String Make;
	
	
	
	public Car(int Reg, int doors, int passangers, int price, String colour, String type, String make) {
		super(Reg, doors, passangers, price, colour, type);
		this.Make = make; 
	}



	public int getRepairCar() {
		return repairCar;
	}
	
	
	@Override
	public String toString() {
		return "Garage " + "ID = " + Reg + "[Doors=" + Doors + ", Passangers=" + Passangers + ", Price=" + Price + ", Colour=" + Colour
				+ ", Type=" + Type + " Make =" + Make + "]";
	}
	
}
