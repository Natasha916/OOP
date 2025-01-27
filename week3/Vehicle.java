package week3;
public abstract class Vehicle {
    public abstract void startEngine();
    public abstract void stopEngine();
}
   class Cars extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car engine started with a key or button.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car engine stopped with a key or button.");
    }
}
      class Motorcycle extends Vehicle {
	    @Override
	    public void startEngine() {
	        System.out.println("Motorcycle engine started with a kick-start or button.");
	    }

	    @Override
	    public void stopEngine() {
	        System.out.println("Motorcycle engine stopped by pressing the kill switch.");
	    }
	}




