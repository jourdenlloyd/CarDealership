package dealership;

import dealership.DAO.InventorySerialDAO;

public class OS {
	public static InventorySerialDAO dao = new InventorySerialDAO();
	
	public static void main(String[] args) {
		Inventory inv;
		
		if(dao.loadInventory() == null) {
			inv = new Inventory();
			Homescreen homescreen = new Homescreen(inv);
		} else {
			inv = dao.loadInventory();
			Homescreen homescreen = new Homescreen(inv);
		}
	}
}
