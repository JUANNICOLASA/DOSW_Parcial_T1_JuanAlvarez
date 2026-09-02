package main.java.edu.dosw.parcial;

import java.util.List;
import java.util.ArrayList;

public class IteradorPorCompatibilidad implements IteradorMascota {
    private List<Mascota> filtradas;
    private int posicion = 0;

    public IteradorPorCompatibilidad(List<Mascota> mascotas,
                                     String ninos,
                                     String macs,
                                     String esp) {

        filtradas = new ArrayList<>();

        for (Mascota m : mascotas) {
            if (m.getCompNinos().equalsIgnoreCase(ninos)
                    && m.getCompMascotas().equalsIgnoreCase(macs)
                    && m.getCompEspacios().equalsIgnoreCase(esp)) {

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