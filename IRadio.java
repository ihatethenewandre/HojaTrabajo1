/**
 * La interfaz IRadio define los métodos que debe implementar una radio.
 */
public interface IRadio {

    /**
     * Cambia el estado de la radio (encendida/apagada).
     */
    void switchOnOff();

    /**
     * Verifica si la radio está encendida.
     * @return true si la radio está encendida, false en caso contrario.
     */
    boolean isOn();

    /**
     * Cambia la banda de la radio (AM/FM).
     */
    void switchAMFM();

    /**
     * Verifica si la radio está en la banda AM.
     * @return true si la radio está en la banda AM, false en caso contrario.
     */
    boolean isAM();

    /**
     * Cambia a la siguiente estación de radio.
     * @return la frecuencia de la nueva estación.
     */
    double nextStation();

    /**
     * Guarda la estación actual en el botón especificado.
     * @param buttonId el ID del botón donde se guardará la estación.
     * @param station la frecuencia de la estación a guardar.
     */
    void saveStation(int buttonId, double station);

    /**
     * Selecciona la estación guardada en el botón especificado.
     * @param buttonId el ID del botón cuya estación se seleccionará.
     * @return la frecuencia de la estación seleccionada.
     */
    double selectStation(int buttonId);
}