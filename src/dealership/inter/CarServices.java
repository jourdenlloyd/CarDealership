package dealership.inter;

import java.util.List;
import dealership.Car;

public interface CarServices {
public void addCar(Car c);
    
    public void removeCar(int i);
    
    public void getAllCars();
    
    public void updateCar(int i);
    
    public void viewOwnedCars(int i);
    
    

}
