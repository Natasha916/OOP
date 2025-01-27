package week3;

interface PaymentMethod {
    void processPayment(double amount);
}

class Esewa implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of NPR " + amount + " through Esewa.");
    }
}
class Khalti implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of NPR " + amount + " through Khalti.");
    }
}
