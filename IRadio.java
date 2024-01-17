interface IRadio {
    void switchOnOff();
    boolean isOn();

    void switchAMFM();
    boolean isAM();

    double nextStation();

    void saveStation(int buttonId, double station);
    double selectStation(int buttonId);
}