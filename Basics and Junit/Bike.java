
public class Bike extends Vehicle {

	boolean Sidecar;
	int repairBike = 100;
	
	
	
	
	
	public Bike(int Reg, int doors, int passangers, int price, String colour, String type, boolean sidecar) {
		super(Reg, doors, passangers, price, colour, type);
		Sidecar = sidecar;
	}

	public int getRepairBike() {
		return repairBike;
	}
	
	@Override
	public String toString() {
		return "Garage " + "ID = " + Reg + "[Doors=" + Doors + ", Passangers=" + Passangers + ", Price=" + Price + ", Colour=" + Colour
				+ ", Type=" + Type + " Sidecart =" + Sidecar + "]";
	}
	
}
