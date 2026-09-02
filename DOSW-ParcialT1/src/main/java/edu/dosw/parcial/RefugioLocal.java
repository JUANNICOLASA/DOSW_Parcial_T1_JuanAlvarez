package main.java.edu.dosw.parcial;

import java.util.List;
import java.util.ArrayList;

public class RefugioLocal implements ComponenteRefugio {
    private String nombre;
    private List<Mascota> mascotas;

    public RefugioLocal(String nombre, List<Mascota> mascotas) {
        this.nombre = nombre;
        this.mascotas = mascotas;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public List<Mascota> getMascotas() {
        return mascotas;
    }
}