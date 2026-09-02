package main.java.edu.dosw.parcial;

public class Mascota {
    private String id;
    private String nombre;
    private String especie;
    private int edad; // en meses
    private String tamano;
    private String compNinos;
    private String compMascotas;
    private String compEspacios;
    private String refugio;

    public Mascota(String id, String nombre, String especie, int edad, String tamano,
                   String compNinos, String compMascotas, String compEspacios, String refugio) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.tamano = tamano;
        this.compNinos = compNinos;
        this.compMascotas = compMascotas;
        this.compEspacios = compEspacios;
        this.refugio = refugio;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public int getEdad() { return edad; }
    public String getTamano() { return tamano; }
    public String getCompNinos() { return compNinos; }
    public String getCompMascotas() { return compMascotas; }
    public String getCompEspacios() { return compEspacios; }
    public String getRefugio() { return refugio; }

    @Override
    public String toString() {
        return "  " + id + " " + nombre + " (" + edad + " meses)";
    }
}