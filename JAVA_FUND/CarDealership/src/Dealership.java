
public class Dealership {

	public static void main(String[] args) {
		
		Customer cust1 = new Customer();
		cust1.setName("Tom");
		cust1.setAddress("123 Anything St");
		cust1.setCashOnHand(1200);
		
		Vehicle vehicle = new Vehicle("Honda", "Accord", 15000);
		
//		vehicle.setMake("Honda");
//		vehicle.setModel("Accord");
//		vehicle.setPrice(15000);
		
		Employee emp = new Employee();
		
		
		cust1.purchaseCar(vehicle, emp, false);
		cust1.toString();
		
	}

}
