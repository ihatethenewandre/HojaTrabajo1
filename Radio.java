/**
 * La clase Radio implementa la interfaz IRadio y define el comportamiento de una radio.
 */
public class Radio implements IRadio {
    private boolean isOn; // Indica si la radio está encendida o apagada
    private boolean isAM; // Indica si la radio está en la banda AM o FM

    private double currentStation; // La estación actual de la radio

    // Arreglos para guardar las estaciones favoritas del usuario en las bandas AM y FM
    private double[] stationsAM = new double[12];
    private double[] stationsFM = new double[12];

    /**
     * Constructor de la clase Radio.
     * Inicializa la radio apagada, en la banda AM y en la estación mínima de la banda AM.
     */
    public Radio() {
        isOn = false;
        isAM = true;
        currentStation = isAM ? 530 : 87.9;
    }

    /**
     * Cambia el estado de la radio (encendida/apagada).
     */
    @Override
    public void switchOnOff() {
        isOn = !isOn;
    }

    /**
     * Verifica si la radio está encendida.
     * @return true si la radio está encendida, false en caso contrario.
     */
    @Override
    public boolean isOn() {
        return isOn;
    }

    /**
     * Cambia la banda de la radio (AM/FM).
     */
    @Override
    public void switchAMFM() {
        isAM = !isAM;
    }

    /**
     * Verifica si la radio está en la banda AM.
     * @return true si la radio está en la banda AM, false en caso contrario.
     */
    @Override
    public boolean isAM() {
        return isAM;
    }

    /**
     * Cambia a la siguiente estación de radio.
     * @return la frecuencia de la nueva estación.
     */
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

    /**
     * Guarda la estación actual en el botón especificado.
     * @param buttonId el ID del botón donde se guardará la estación.
     * @param station la frecuencia de la estación a guardar.
     */
    @Override
    public void saveStation(int buttonId, double station) {
        if (isAM) {
            stationsAM[buttonId - 1] = station;
        } else {
            stationsFM[buttonId - 1] = station;
        }
    }

    /**
     * Selecciona la estación guardada en el botón especificado.
     * @param buttonId el ID del botón cuya estación se seleccionará.
     * @return la frecuencia de la estación seleccionada.
     */
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