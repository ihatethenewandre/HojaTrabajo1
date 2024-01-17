import java.util.Scanner;

/**
 * La clase Main contiene el método principal (main) que se ejecuta al iniciar el programa.
 * Esta clase se encarga de interactuar con el usuario a través de la consola y de controlar la radio.
 */
public class Main {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Crear un objeto Radio
        IRadio radio = new Radio();

        // Variable para almacenar la opción seleccionada por el usuario en el menú
        int option;

        // Bucle principal del programa
        do {
            // Mostrar el menú al usuario
            System.out.println("\n--- Menú ---");
            System.out.println("1. Encender la radio");
            System.out.println("2. Cambiar de AM a FM y viceversa");
            System.out.println("3. Avanzar en el dial de las emisoras");
            System.out.println("4. Guardar una emisora en un botón");
            System.out.println("5. Seleccionar la emisora guardada en un botón");
            System.out.println("6. Apagar la radio");
            System.out.println("7. Salir");
            System.out.print("Por favor, elige una opción: ");

            // Leer la opción seleccionada por el usuario
            option = scanner.nextInt();

            // Realizar una acción dependiendo de la opción seleccionada
            switch (option) {
                case 1:
                    // Encender o apagar la radio
                    if (radio.isOn()) {
                        System.out.println("La radio ya está encendida.");
                    } else {
                        radio.switchOnOff();
                        System.out.println("La radio está encendida.");
                    }
                    break;
                case 2:
                    // Cambiar de AM a FM y viceversa
                    if (radio.isOn()) {
                        radio.switchAMFM();
                        System.out.println("La radio está en " + (radio.isAM() ? "AM" : "FM"));
                    } else {
                        System.out.println("La radio está apagada. Por favor, enciéndela primero.");
                    }
                    break;
                case 3:
                    // Avanzar en el dial de las emisoras
                    if (radio.isOn()) {
                        double station = radio.nextStation();
                        System.out.println("La estación actual es " + station);
                    } else {
                        System.out.println("La radio está apagada. Por favor, enciéndela primero.");
                    }
                    break;
                case 4:
                    // Guardar una emisora en un botón
                    if (radio.isOn()) {
                        System.out.print("Por favor, introduce el número del botón (1-12) para guardar la estación: ");
                        int buttonId = scanner.nextInt();
                        if (buttonId >= 1 && buttonId <= 12) {
                            radio.saveStation(buttonId, radio.nextStation());
                            System.out.println("La estación ha sido guardada en el botón " + buttonId);
                        } else {
                            System.out.println("El número del botón debe estar entre 1 y 12. Volviendo al menú principal...");
                        }
                    } else {
                        System.out.println("La radio está apagada. Por favor, enciéndela primero.");
                    }
                    break;
                case 5:
                    // Seleccionar la emisora guardada en un botón
                    if (radio.isOn()) {
                        System.out.print("Por favor, introduce el número del botón (1-12) para seleccionar la estación: ");
                        int button = scanner.nextInt();
                        if (button >= 1 && button <= 12) {
                            double station = radio.selectStation(button);
                            if (station == 0) {
                                System.out.println("No hay ninguna estación guardada en el botón " + button + ". Volviendo al menú principal...");
                            } else {
                                System.out.println("La estación seleccionada es " + station);
                            }
                        } else {
                            System.out.println("El número del botón debe estar entre 1 y 12. Volviendo al menú principal...");
                        }
                    } else {
                        System.out.println("La radio está apagada. Por favor, enciéndela primero.");
                    }
                    break;
                case 6:
                    // Apagar la radio
                    if (!radio.isOn()) {
                        System.out.println("La radio ya está apagada.");
                    } else {
                        radio.switchOnOff();
                        System.out.println("La radio está apagada.");
                    }
                    break;
                case 7:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    // Opción no válida
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        // Repetir el menú hasta que el usuario elija la opción de salir
        } while (option != 7);

        // Cerrar el objeto Scanner para evitar fugas de memoria
        scanner.close();
    }
}