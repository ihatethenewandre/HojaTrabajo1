import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IRadio radio = new Radio();
        int option;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Encender la radio");
            System.out.println("2. Cambiar de AM a FM y viceversa");
            System.out.println("3. Avanzar en el dial de las emisoras");
            System.out.println("4. Guardar una emisora en un botón");
            System.out.println("5. Seleccionar la emisora guardada en un botón");
            System.out.println("6. Apagar la radio");
            System.out.println("7. Salir");
            System.out.print("Por favor, elige una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    if (radio.isOn()) {
                        System.out.println("La radio ya está encendida.");
                    } else {
                        radio.switchOnOff();
                        System.out.println("La radio está encendida.");
                    }
                    break;
                case 2:
                    if (radio.isOn()) {
                        radio.switchAMFM();
                        System.out.println("La radio está en " + (radio.isAM() ? "AM" : "FM"));
                    } else {
                        System.out.println("La radio está apagada. Por favor, enciéndela primero.");
                    }
                    break;
                case 3:
                    if (radio.isOn()) {
                        double station = radio.nextStation();
                        System.out.println("La estación actual es " + station);
                    } else {
                        System.out.println("La radio está apagada. Por favor, enciéndela primero.");
                    }
                    break;
                case 4:
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
                    if (!radio.isOn()) {
                        System.out.println("La radio ya está apagada.");
                    } else {
                        radio.switchOnOff();
                        System.out.println("La radio está apagada.");
                    }
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }
        } while (option != 7);
        scanner.close();
    }
}