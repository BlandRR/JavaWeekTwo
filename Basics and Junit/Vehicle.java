import java.util.ArrayList;

public abstract class Vehicle  {

	
	int Reg;
	int Doors;
	int Passangers;
	int Price;
	String Colour;
	String Type;

	
	public Vehicle(int Reg, int doors, int passangers, int price , String colour, String type) {
		this.Reg = Reg; 
		Doors = doors;
		Passangers = passangers;
		Price = price;
		Colour = colour;
		Type = type;
	}
	
	
	
	

	ArrayList<Garage> list = new ArrayList<Garage>();

	public int getReg() {
		return Reg;
	}
	
	public String getType() {
		return Type;
	}
	
	
	public int getDoors() {
		return Doors;
	}

	public int getPassangers() {
		return Passangers;
	}

	public int getPrice() {
		return Price;
	}

	public String getColour() {
		return Colour;
	}

	public void setType(String type) {
		Type = type;
	}




	
	public String toString() {
		return "Garage " + "ID = " + Reg + "[Doors=" + Doors + ", Passangers=" + Passangers + ", Price=" + Price + ", Colour=" + Colour
				+ ", Type=" + Type + "]";
	}
}
