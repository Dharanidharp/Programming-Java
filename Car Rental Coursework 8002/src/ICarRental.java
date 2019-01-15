import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public interface ICarRental
{
    ArrayList<Car> getCarsList();
    HashMap<DrivingLicence, Car> getCurrentRentedCars();
    ArrayList<Car> availableCars(String typeOfCar);
    Car getCar(DrivingLicence drivingLicence);
    boolean issueCar(DrivingLicence drivingLicence, String typeOfCar);
    int dateDifference(Date date);
    int terminateRental(DrivingLicence drivingLicence);
}