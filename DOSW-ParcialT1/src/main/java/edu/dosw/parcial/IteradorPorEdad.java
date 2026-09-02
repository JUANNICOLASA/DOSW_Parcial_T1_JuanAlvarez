package main.java.edu.dosw.parcial;

import java.util.List;
import java.util.ArrayList;

public class IteradorPorEdad implements IteradorMascota {
    private List<Mascota> filtradas;
    private int posicion = 0;

    public IteradorPorEdad(List<Mascota> mascotas, int edadMin, int edadMax) {
        filtradas = new ArrayList<>();

        for (Mascota m : mascotas) {
            if (m.getEdad() >= edadMin && m.getEdad() <= edadMax) {
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