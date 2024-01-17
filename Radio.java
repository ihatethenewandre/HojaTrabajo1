public class Radio implements IRadio {
    private boolean isOn;
    private boolean isAM;

    private double currentStation;

    private double[] stationsAM = new double[12];
    private double[] stationsFM = new double[12];

    public Radio() {
        isOn = false;
        isAM = true;
        currentStation = isAM ? 530 : 87.9;
    }

    @Override
    public double nextStation() {
        if (isAM) {
            currentStation += 10;
            if (currentStation > 1610) {
                currentStation = 530;
            }
        } else {
            currentStation += 0.2;
            if (currentStation > 107.9) {
                currentStation = 87.9;
            }
        }
        return currentStation;
    }

    @Override
    public void saveStation(int buttonId, double station) {
        if (isAM) {
            stationsAM[buttonId - 1] = station;
        } else {
            stationsFM[buttonId - 1] = station;
        }
    }

    @Override
    public double selectStation(int buttonId) {
        if (isAM) {
            currentStation = stationsAM[buttonId - 1];
        } else {
            currentStation = stationsFM[buttonId - 1];
        }
        return currentStation;
    }
}