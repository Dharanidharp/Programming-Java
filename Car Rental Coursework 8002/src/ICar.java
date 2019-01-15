public interface ICar
{
    String getRegistrationNumber();
    int getFuelCapacity();
    int getCurrentFuel();
    boolean isTankFull();
    boolean isCarRented();
    boolean isSmall();
    int addFuel(int fuelAmount);
    int driveCar(int distance);
}