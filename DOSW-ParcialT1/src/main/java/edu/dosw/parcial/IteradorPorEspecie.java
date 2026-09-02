package main.java.edu.dosw.parcial;

import java.util.List;
import java.util.ArrayList;

public class IteradorPorEspecie implements IteradorMascota {
    private List<Mascota> filtradas;
    private int posicion = 0;

    public IteradorPorEspecie(List<Mascota> mascotas, String especie) {
        filtradas = new ArrayList<>();

        for (Mascota m : mascotas) {
            if (m.getEspecie().equalsIgnoreCase(especie)) {
                filtradas.add(m);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return posicion < filtradas.size();
    }

    @Override
    public Mascota next() {
        return filtradas.get(posicion++);
    }
}