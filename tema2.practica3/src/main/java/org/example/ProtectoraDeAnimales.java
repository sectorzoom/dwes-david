package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProtectoraDeAnimales {
    private List<Animal> animales;

    public ProtectoraDeAnimales() {
        this.animales = new ArrayList<>();
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }

    // Métodos para añadir, borrar, consultar animales
    public void añadirAnimal(Animal animal) {
        animales.add(animal);
    }

    public void borrarAnimal(int id) {
        animales.removeIf(animal -> animal.getId() == id);
    }

    public Animal consultarAnimal(int id) {
        return animales.stream()
                .filter(animal -> animal.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "ProtectoraDeAnimales [animales=" + animales + "]";
    }
}


