package main.java.edu.dosw.parcial;

import java.util.List;
import java.util.ArrayList;

public class RedRefugios implements ComponenteRefugio {
    private String nombre;
    private List<ComponenteRefugio> hijos = new ArrayList<>();

    public RedRefugios(String nombre) {
        this.nombre = nombre;
    }

    public void agregarHijo(ComponenteRefugio componente) {
        hijos.add(componente);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> todasLasMascotas = new ArrayList<>();
        for (ComponenteRefugio hijo : hijos) {
            todasLasMascotas.addAll(hijo.getMascotas());
        }
        return todasLasMascotas;
    }
}