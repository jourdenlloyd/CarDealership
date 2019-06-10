package dealership.DAO;

import dealership.Inventory;

public interface InventoryDAO {
	public void saveInventory(Inventory i);
	public Inventory loadInventory();
}
