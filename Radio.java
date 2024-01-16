public class Radio implements IRadio{
    private boolean isAM;

    public Radio() {
        isAM = true;
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