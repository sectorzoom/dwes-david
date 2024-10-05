package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AnimalShelter {
    private final List<Animal> animales = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public AnimalShelter() {}

    public List<Animal> getAnimales() {
        return animales;
    }

    public void loadXML(Path XML_FILE) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            AnimalShelter animalShelter = xmlMapper.readValue(new File(XML_FILE.toString()), AnimalShelter.class);
            this.animales.addAll(animalShelter.getAnimales());
            System.out.println("Informacion cargada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar el fichero XML: " + e.getMessage());
        }
    }

    public void saveXML(Path XML_FILE) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(XML_FILE.toString()), this);
            System.out.println("Informacion guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero XML: " + e.getMessage());
        }
    }

    public void addAnimal() {
        Animal animal = new Animal();
        System.out.print("ID: ");
        animal.setId(scanner.nextLine());
        System.out.print("Nombre: ");
        animal.setName(scanner.nextLine());
        System.out.print("Especie: ");
        animal.setSpecie(scanner.nextLine());
        System.out.print("Edad: ");
        animal.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.print("Sexo (Macho/Hembra): ");
        animal.setGenre(scanner.nextLine());

        // Captura de la fecha de ingreso
        System.out.print("Fecha de ingreso (YYYY-MM-DD): ");
        String fechaInput = scanner.nextLine();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        formatoFecha.setLenient(false);

        try {
            Date fechaIngreso = formatoFecha.parse(fechaInput);
            animal.setDateOfEntry(fechaIngreso); // Establecer la fecha en el objeto Animal
            System.out.println("Fecha de ingreso: " + formatoFecha.format(fechaIngreso));
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Asegúrate de usar el formato YYYY-MM-DD.");
            return; // Salir si la fecha es inválida
        }

        // Captura de adopción
        System.out.print("¿Adoptado? (Sí/No): ");
        String respuesta = scanner.nextLine().trim();
        if ("sí".equalsIgnoreCase(respuesta)) {
            animal.setAdopted(true);
        } else if ("no".equalsIgnoreCase(respuesta)) {
            animal.setAdopted(false);
        } else {
            System.out.println("Respuesta inválida. Por favor, introduce 'sí' o 'no'.");
            return; // Salir si la respuesta es inválida
        }

        animales.add(animal);
        System.out.println("Animal añadido correctamente.");
    }


    public void deleteAnimal() {
        System.out.print("Introduce el ID del animal a borrar: ");
        String id = scanner.nextLine();
        animales.removeIf(animal -> animal.getId().equals(id));
        System.out.println("Animal borrado si existía.");
    }

    public void searchAnimal() {
        System.out.print("Introduce el ID del animal a consultar: ");
        String id = scanner.nextLine();
        animales.stream()
                .filter(animal -> animal.getId().equals(id))
                .forEach(animal -> {
                    System.out.println("Nombre: " + animal.getName());
                    System.out.println("Especie: " + animal.getSpecie());
                    System.out.println("Edad: " + animal.getAge());
                    System.out.println("Sexo: " + animal.getGenre());
                    System.out.println("Fecha de ingreso: " + animal.getDateOfEntry());
                    System.out.println("Adoptado: " + animal.getAdopted());
                });
    }

    public void showAllAnimals() {
        animales.forEach(animal -> {
            System.out.println("ID: " + animal.getId());
            System.out.println("Nombre: " + animal.getName());
            System.out.println("Especie: " + animal.getSpecie());
            System.out.println("Edad: " + animal.getAge());
            System.out.println("Sexo: " + animal.getGenre());

            // Formatear y mostrar la fecha
            SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy/MM/dd");
            String fechaFormateada = formatoSalida.format(animal.getDateOfEntry());
            System.out.println("Fecha de ingreso: " + fechaFormateada);

            System.out.println("Adoptado: " + (animal.getAdopted() ? "sí" : "no"));
            System.out.println("---------------------");
        });
    }
}