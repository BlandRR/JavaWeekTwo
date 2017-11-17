
public class Van extends Vehicle {

	
	int Capacity;
	int repairVan = 200;
	
	public Van(int Reg, int doors, int passangers, int price, String colour, String type, int capacity) {
		super(Reg, doors, passangers, price, colour, type);
		this.Capacity = capacity;
	}

	public int getRepairVan() {
		return repairVan;
	}
	
	public String printDetails() {
		return "Garage [Doors=" + Doors + ", Passangers=" + Passangers + ", Price=" + Price + ", Colour=" + Colour
				+ ", Type=" + Type + " Capactity =" + Capacity + "]";
	}
	
	@Override
	public String toString() {
		return "Garage " + "ID = " + Reg + "[Doors=" + Doors + ", Passangers=" + Passangers + ", Price=" + Price + ", Colour=" + Colour
				+ ", Type=" + Type + " Capactity =" + Capacity + "]";
	}
}
