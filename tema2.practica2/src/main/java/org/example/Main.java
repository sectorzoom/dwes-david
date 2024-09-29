package org.example;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Path XML_FILE = Path.of("C:/Users/david/Documents/2 DAW/dwes-david/tema2.practica2/src/main/resources/protectoraDeAnimales.xml");
        ProtectoraDeAnimales protectora = new ProtectoraDeAnimales();
        int option;
        do {
            showMenu();
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> protectora.cargarDesdeXML(XML_FILE);
                case 2 -> protectora.guardarEnXML(XML_FILE);
                case 3 -> protectora.anyadirAnimal();
                case 4 -> protectora.borrarAnimal();
                case 5 -> protectora.consultarAnimal();
                case 6 -> protectora.mostrarTodosLosAnimales();
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (option != 7);
    }

    private static void showMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Cargar información de fichero XML");
        System.out.println("2. Guardar información en fichero XML");
        System.out.println("3. Añadir animal");
        System.out.println("4. Borrar animal");
        System.out.println("5. Consultar animal");
        System.out.println("6. Mostrar todos los animales");
        System.out.println("7. Salir");
        System.out.print("Elige una opción: ");
    }
}
