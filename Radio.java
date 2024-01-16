public class Radio implements IRadio {
    private boolean isOn;

    public Radio() {
        isOn = false;
    }

    @Override
    public void switchOnOff() {
        isOn = !isOn;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}