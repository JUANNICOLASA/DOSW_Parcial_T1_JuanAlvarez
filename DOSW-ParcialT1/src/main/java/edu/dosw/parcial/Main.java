package main.java.edu.dosw.parcial;

import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        RefugioLocal refugioNorte = new RefugioLocal("Refugio Norte", Arrays.asList(
                new Mascota("PERRO-001", "Max", "PERRO", 24, "MEDIANO", "SI", "SI", "SI", "Norte - Bogota"),
                new Mascota("PERRO-002", "Bruno", "PERRO", 72, "GRANDE", "SI", "NO", "NO", "Norte - Bogota"),
                new Mascota("GATO-001", "Luna", "GATO", 18, "PEQUEÑO", "SI", "SI", "SI", "Norte - Bogota")
        ));

        RefugioLocal refugioSur = new RefugioLocal("Refugio Sur", Arrays.asList(
                new Mascota("PERRO-003", "Toby", "PERRO", 12, "PEQUEÑO", "SI", "SI", "SI", "Sur-Bogota"),
                new Mascota("GATO-002", "Milo", "GATO", 48, "MEDIANO", "NO", "SI", "SI", "Sur-Bogota"),
                new Mascota("CONEJO-001", "Copito", "CONEJO", 10, "PEQUEÑO", "SI", "SI", "SI", "Sur-Bogota")
        ));

        RefugioLocal refugioMedellin = new RefugioLocal("Refugio Central", Arrays.asList(
                new Mascota("PERRO-004", "Rocky", "PERRO", 60, "GRANDE", "NO", "NO", "NO", "Ctral-Medellin"),
                new Mascota("GATO-003", "Nala", "GATO", 30, "PEQUEÑO", "SI", "SI", "SI", "Ctral-Medellin"),
                new Mascota("AVE-001", "Kiwi", "AVE", 20, "PEQUEÑO", "SI", "NO", "SI", "Ctral-Medellin")
        ));

        RefugioLocal refugioCali = new RefugioLocal("Refugio Oeste", Arrays.asList(
                new Mascota("PERRO-005", "Simon", "PERRO", 36, "MEDIANO", "SI", "SI", "SI", "Oeste-Cali"),
                new Mascota("REPTIL-001", "Rocco", "REPTIL", 84, "PEQUEÑO", "NO", "NO", "SI", "Oeste-Cali"),
                new Mascota("GATO-004", "Zoe", "GATO", 8, "PEQUEÑO", "SI", "SI", "SI", "Oeste-Cali")
        ));

        RedRefugios ciudadBogota = new RedRefugios("Bogota");
        ciudadBogota.agregarHijo(refugioNorte);
        ciudadBogota.agregarHijo(refugioSur);

        RedRefugios ciudadMedellin = new RedRefugios("Medellin");
        ciudadMedellin.agregarHijo(refugioMedellin);

        RedRefugios ciudadCali = new RedRefugios("Cali");
        ciudadCali.agregarHijo(refugioCali);

        RedRefugios redNacional = new RedRefugios("Red Nacional ECI Paw Connect");
        redNacional.agregarHijo(ciudadBogota);
        redNacional.agregarHijo(ciudadMedellin);
        redNacional.agregarHijo(ciudadCali);

        List<Mascota> catalogoTotal = redNacional.getMascotas();

        System.out.println("RESULTADOS BÚSQUEDA #001");

        IteradorMascota itEspecie =
                new IteradorPorEspecie(catalogoTotal, "PERRO");

        int totalPerros = 0;

        while (itEspecie.hasNext()) {
            Mascota m = itEspecie.next();

            System.out.println("  " + m.getId() + " " + m.getNombre());
            totalPerros++;
        }

        System.out.println("Total encontrados: " + totalPerros + " perros");

        System.out.println("\nRESULTADOS BÚSQUEDA #002");

        IteradorMascota itEdad =
                new IteradorPorEdad(catalogoTotal, 12, 36);

        int totalEdad = 0;

        while (itEdad.hasNext()) {
            Mascota m = itEdad.next();

            System.out.println("  " + m.getId() + " "
                    + m.getNombre() + " "
                    + m.getEdad() + " meses");

            totalEdad++;
        }

        System.out.println("Total encontrados: " + totalEdad + " mascotas");

        System.out.println("\nRESULTADOS BÚSQUEDA #003");

        IteradorMascota itComp =
                new IteradorPorCompatibilidad(catalogoTotal, "SI", "SI", "SI");

        int totalCompatibles = 0;

        while (itComp.hasNext()) {
            Mascota m = itComp.next();

            System.out.println("  " + m.getId() + " " + m.getNombre());
            totalCompatibles++;
        }

        System.out.println("Total encontrados: "
                + totalCompatibles + " mascotas");

        System.out.println("\nRESULTADOS BÚSQUEDA #004");

        List<Mascota> mascNorte = refugioNorte.getMascotas();

        System.out.println("Total encontrados:");
        System.out.println("  Refugio Norte - "
                + mascNorte.size() + " mascotas");

        System.out.println("\nRESULTADOS BÚSQUEDA #005");

        List<Mascota> mascRed = redNacional.getMascotas();

        System.out.println("Total encontrados:");
        System.out.println("  Red Nacional - "
                + mascRed.size() + " mascotas");
    }
}