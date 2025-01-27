package Workshop2;

public class Child extends Parent{
	
	 public void displayVariables() {
	        System.out.println("Protected: " + protectedVar); // Accessible
	        System.out.println("Public: " + publicVar); // Accessible
	        System.out.println("Private: " + getPrivateVar()); // Accessible through getter
	    }
	 
	  public static void main(String[] args) {
	        Child child = new Child();
	        child.displayVariables();
	    }
}