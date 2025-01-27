package Workshop2;

class Employee extends Person {
    private String department;

    public Employee(String address, String department) {
        super(address);
        this.department = department;
    }

    public void displayDetails() {
        System.out.println("Address: " + address + ", Department: " + department);
    }
    
    public static void main(String[] args) {
        Employee employee = new Employee("Grove Street", "GangBanger");
        employee.displayDetails();
    }
}