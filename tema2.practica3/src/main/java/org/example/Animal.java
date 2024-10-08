package org.example;
public class Animal {
    private int id;
    private String nombre;
    private String especie;
    private int edad;
    private String sexo;
    private String fechaIngreso;
    private String adoptado;

    // Getters y setters

    @Override
    public String toString() {
        return "Animal [id=" + id + ", nombre=" + nombre + ", especie=" + especie +
                ", edad=" + edad + ", sexo=" + sexo + ", fechaIngreso=" + fechaIngreso +
                ", adoptado=" + adoptado + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getAdoptado() {
        return adoptado;
    }

    public void setAdoptado(String adoptado) {
        this.adoptado = adoptado;
    }
}
