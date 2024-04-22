package com.aluracursos.post.principal;

import com.aluracursos.post.Modelos.Pelicula;
import com.aluracursos.post.Modelos.Serie;
import com.aluracursos.post.Modelos.Titulo;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PrincipalConListas {
    public static void main(String[] args) {

        //Peliculas
        Pelicula pelicula1 = new Pelicula("Scooby Doo", 2001);
        pelicula1.evalua(9);

        Pelicula otraPelicula = new Pelicula("Matrix", 1998);
        otraPelicula.evalua(8);

        var peliculaBruno = new Pelicula("El señor de los anillos", 2001);
        peliculaBruno.evalua(10);

        // Series
        Serie miSerie = new Serie("Alucard",2023 );
        miSerie.evalua(10);

        List<Titulo> listas = new LinkedList<>();
        listas.add(peliculaBruno);
        listas.add(pelicula1);
        listas.add(otraPelicula);
        listas.add(miSerie);

        for (Titulo item: listas ) {
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 3){
                System.out.println(pelicula.getClasificacion());
            }
        }

        List<String>listaDeArtistas = new LinkedList<>();
        listaDeArtistas.add("Penélope Cruz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Ricardo Darín");

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas ordenadas: " + listaDeArtistas);

        Collections.sort(listas);
        System.out.println("Lista de peliculas ordenadas: " + listas);

        listas.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordeanda por fecha: " + listas);


    }
}