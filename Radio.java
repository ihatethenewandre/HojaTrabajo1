public class Radio implements IRadio {
    private boolean isOn;
    private boolean isAM;

    public Radio() {
        isOn = false;
        isAM = true;
    }

    @Override
    public void switchOnOff() {
        isOn = !isOn;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void switchAMFM() {
        isAM = !isAM;
    }

    @Override
    public boolean isAM() {
        return isAM;
    }
}