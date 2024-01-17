import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * La clase RadioTest contiene pruebas unitarias para la clase Radio.
 */
public class RadioTest {
    // Instancia de la clase Radio que se utilizará en las pruebas
    private Radio radio;

    /**
     * Método que se ejecuta antes de cada prueba.
     * Inicializa la instancia de Radio.
     */
    @Before
    public void setUp() {
        radio = new Radio();
    }

    /**
     * Prueba el método switchOnOff de la clase Radio.
     * Verifica que el estado de la radio cambie correctamente al llamar al método.
     */
    @Test
    public void testSwitchOnOff() {
        assertFalse(radio.isOn());
        radio.switchOnOff();
        assertTrue(radio.isOn());
        radio.switchOnOff();
        assertFalse(radio.isOn());
    }

    /**
     * Prueba el método switchAMFM de la clase Radio.
     * Verifica que la banda de la radio cambie correctamente al llamar al método.
     */
    @Test
    public void testSwitchAmFm() {
        assertTrue(radio.isAM());
        radio.switchAMFM();
        assertFalse(radio.isAM());
        radio.switchAMFM();
        assertTrue(radio.isAM());
    }

    /**
     * Prueba los métodos saveStation y selectStation de la clase Radio.
     * Verifica que las estaciones se guarden y seleccionen correctamente.
     */
    @Test
    public void testSaveAndSelectStation() {
        int buttonId;
        double station;

        buttonId = 1;
        station = 550;
        radio.saveStation(buttonId, station);
        assertEquals(radio.selectStation(buttonId), station, 0.01);
        buttonId = 2;
        station = 90.1;
        radio.switchAMFM();
        radio.saveStation(buttonId, station);
        assertEquals(radio.selectStation(buttonId), station, 0.01);
        buttonId = 3;
        station = radio.selectStation(buttonId);
        assertEquals(0, station, 0.01);
    }
}