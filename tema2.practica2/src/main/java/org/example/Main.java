package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    private static final Path XML_FILE = Path.of("C:/Users/david/Documents/2 DAW/dwes-david/tema2.practica2/src/main/resources/protectoraDeAnimales.xml");
    private static ProtectoraDeAnimales protectora = new ProtectoraDeAnimales();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            showMenu();
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> loadXML();
                case 2 -> saveXML();
                case 3 -> addAnimal();
                case 4 -> deleteAnimal();
                case 5 -> checkAnimal();
                case 6 -> showAllAnimals();
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (option != 7);
    }

    private static void showMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Cargar informacion de fichero XML");
        System.out.println("2. Guardar informacion en fichero XML");
        System.out.println("3. Anyadir animal");
        System.out.println("4. Borrar animal");
        System.out.println("5. Consultar animal");
        System.out.println("6. Mostrar todos los animales");
        System.out.println("7. Salir");
        System.out.print("Elige una opcion: ");
    }

    // Función para cargar la información desde un archivo XML utilizando Jackson
    private static void loadXML() {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            protectora = xmlMapper.readValue(new File(XML_FILE.toString()), ProtectoraDeAnimales.class);
            System.out.println("Informacion cargada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar el fichero XML: " + e.getMessage());
        }
    }

    // Función para guardar la información en un archivo XML utilizando Jackson
    private static void saveXML() {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(XML_FILE.toString()), protectora);
            System.out.println("Informacion guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero XML: " + e.getMessage());
        }
    }

    // Función para añadir un nuevo animal a la protectora
    private static void addAnimal() {
        Animal animal = new Animal();
        System.out.print("ID: ");
        animal.setId(scanner.nextLine());
        System.out.print("Nombre: ");
        animal.setNombre(scanner.nextLine());
        System.out.print("Especie: ");
        animal.setEspecie(scanner.nextLine());
        System.out.print("Edad: ");
        animal.setEdad(Integer.parseInt(scanner.nextLine()));
        System.out.print("Sexo (Macho/Hembra): ");
        animal.setSexo(scanner.nextLine());
        System.out.print("Fecha de ingreso (YYYY-MM-DD): ");
        animal.setFechaIngreso(scanner.nextLine());
        System.out.print("¿Adoptado? (Si/No): ");
        animal.setAdoptado(scanner.nextLine());

        protectora.getAnimales().add(animal);
        System.out.println("Animal añadido correctamente.");
    }

    // Función para borrar un animal por su ID
    private static void deleteAnimal() {
        System.out.print("Introduce el ID del animal a borrar: ");
        String id = scanner.nextLine();
        protectora.getAnimales().removeIf(animal -> animal.getId().equals(id));
        System.out.println("Animal borrado si existia.");
    }

    // Función para consultar un animal por su ID
    private static void checkAnimal() {
        System.out.print("Introduce el ID del animal a consultar: ");
        String id = scanner.nextLine();
        protectora.getAnimales().stream()
                .filter(animal -> animal.getId().equals(id))
                .forEach(animal -> {
                    System.out.println("Nombre: " + animal.getNombre());
                    System.out.println("Especie: " + animal.getEspecie());
                    System.out.println("Edad: " + animal.getEdad());
                    System.out.println("Sexo: " + animal.getSexo());
                    System.out.println("Fecha de ingreso: " + animal.getFechaIngreso());
                    System.out.println("Adoptado: " + animal.getAdoptado());
                });
    }

    // Función para mostrar todos los animales
    private static void showAllAnimals() {
        protectora.getAnimales().forEach(animal -> {
            System.out.println("ID: " + animal.getId());
            System.out.println("Nombre: " + animal.getNombre());
            System.out.println("Especie: " + animal.getEspecie());
            System.out.println("Edad: " + animal.getEdad());
            System.out.println("Sexo: " + animal.getSexo());
            System.out.println("Fecha de ingreso: " + animal.getFechaIngreso());
            System.out.println("Adoptado: " + animal.getAdoptado());
            System.out.println("---------------------");
        });
    }
}
