package week3;

public interface RemoteControl {
    void powerOn();
    void powerOff();
}
class TV implements RemoteControl {
    @Override
    public void powerOn() {
        System.out.println("The TV is now ON.");
    }

    @Override
    public void powerOff() {
        System.out.println("The TV is now OFF.");
    }
}

class AC implements RemoteControl {
    @Override
    public void powerOn() {
        System.out.println("The AC is now ON.");
    }

    @Override
    public void powerOff() {
        System.out.println("The AC is now OFF.");
    }
}