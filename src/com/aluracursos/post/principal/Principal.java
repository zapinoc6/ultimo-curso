package com.aluracursos.post.principal;

import com.aluracursos.post.Modelos.Episodio;
import com.aluracursos.post.Modelos.Pelicula;
import com.aluracursos.post.Modelos.Serie;
import com.aluracursos.post.calculos.CalculadoraDeTiempo;
import com.aluracursos.post.calculos.FiltroRecomendaciones;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {


        Pelicula pelicula1 = new Pelicula("Scooby Doo", 2001);
        pelicula1.setDuracionEnMinutos(160);
        pelicula1.setIncluidoEnElPlan(true);
        pelicula1.evalua(10);
        pelicula1.evalua(7.9);
        pelicula1.evalua(5.3);

        pelicula1.muestraFichaTecnica();
        System.out.println("***************************************************************************");
        System.out.println(pelicula1.getTotalDeLasEvaluaciones());
        System.out.println(pelicula1.calculaMedia());
        System.out.println("***************************************************************************");
        System.out.println("Média de evaluaciones de la película: " +pelicula1.calculaMedia());

        Pelicula otraPelicula = new Pelicula("Matrix", 1998);
        otraPelicula.setDuracionEnMinutos(188);

        System.out.println("\n***************************************************************************");
        otraPelicula.muestraFichaTecnica();


        Serie miSerie = new Serie("Alucard",2023 );
        miSerie.setTemporada(2);
        miSerie.setEpisodioPorTemporada(26);
        miSerie.setMinutosPorEpisodio(24);

        System.out.println("\n***************************************************************************");
        miSerie.muestraFichaTecnica();


        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(pelicula1);
        calculadora.incluye(miSerie);
        calculadora.incluye(otraPelicula);
        System.out.println("\n***************************************************************************");
        System.out.println("Tiempo necesario para ver los Titulos: " + calculadora.getTiempoTotal() + " minutos..");

        FiltroRecomendaciones filtroRecomendaciones = new FiltroRecomendaciones();
        filtroRecomendaciones.filtro(pelicula1);

        Episodio muestra = new Episodio();
        muestra.setNumero(1);
        muestra.setNombre("LA casa De papel");
        muestra.setSerie("Alucard");
        muestra.setTotalVisualizaciones(300);

        filtroRecomendaciones.filtro(muestra);

        var peliculaBruno = new Pelicula("El señor de los anillos", 2001);
        peliculaBruno.setDuracionEnMinutos(180);



        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(peliculaBruno);
        listaDePeliculas.add(pelicula1);
        listaDePeliculas.add(otraPelicula);

        System.out.println("\n***************************************************************************");
        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());
        System.out.println("Tamaño de la lista: " + listaDePeliculas.get(0).getNombre());

        System.out.println("\n***************************************************************************");
        System.out.println(listaDePeliculas.toString());
        System.out.println("toString de la Pelicula: " + listaDePeliculas.get(0).toString());








    }
}



