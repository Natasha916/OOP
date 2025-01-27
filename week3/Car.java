package week3;
public class Car {
    private String model;
    private double price;
    private double fuelLevel; 
    private Car(String model, double price, double fuelLevel) {
        this.model = model;
        this.price = price;
        this.fuelLevel = fuelLevel;
    }
    private String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private double getPrice() {
        return price;
    }
    private void setPrice(double price) {
        this.price = price;
    }
    private double getFuelLevel() {
        return fuelLevel;
    }

}


