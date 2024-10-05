package org.example;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Path XML_FILE = Path.of("C:/Users/david/Documents/2 DAW/dwes-david/tema2.practica2/src/main/resources/protectoraDeAnimales.xml");
        AnimalShelter animalShelter = new AnimalShelter();
        int option;
        do {
            showMenu();
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> animalShelter.loadXML(XML_FILE);
                case 2 -> animalShelter.saveXML(XML_FILE);
                case 3 -> animalShelter.addAnimal();
                case 4 -> animalShelter.deleteAnimal();
                case 5 -> animalShelter.searchAnimal();
                case 6 -> animalShelter.showAllAnimals();
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