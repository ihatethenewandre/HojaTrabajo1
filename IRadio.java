interface IRadio {
    double nextStation();

    void saveStation(int buttonId, double station);
    double selectStation(int buttonId);
}