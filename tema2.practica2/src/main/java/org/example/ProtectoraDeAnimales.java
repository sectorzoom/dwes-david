package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProtectoraDeAnimales {
    private final List<Animal> animales = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public ProtectoraDeAnimales() {}

    public List<Animal> getAnimales() {
        return animales;
    }

    public void cargarDesdeXML(Path XML_FILE) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            ProtectoraDeAnimales protectora = xmlMapper.readValue(new File(XML_FILE.toString()), ProtectoraDeAnimales.class);
            this.animales.addAll(protectora.getAnimales());
            System.out.println("Informacion cargada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar el fichero XML: " + e.getMessage());
        }
    }

    public void guardarEnXML(Path XML_FILE) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(XML_FILE.toString()), this);
            System.out.println("Informacion guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero XML: " + e.getMessage());
        }
    }

    public void anyadirAnimal() {
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

        animales.add(animal);
        System.out.println("Animal añadido correctamente.");
    }

    public void borrarAnimal() {
        System.out.print("Introduce el ID del animal a borrar: ");
        String id = scanner.nextLine();
        animales.removeIf(animal -> animal.getId().equals(id));
        System.out.println("Animal borrado si existía.");
    }

    public void consultarAnimal() {
        System.out.print("Introduce el ID del animal a consultar: ");
        String id = scanner.nextLine();
        animales.stream()
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

    public void mostrarTodosLosAnimales() {
        animales.forEach(animal -> {
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
