package com.aluracursos.post.calculos;

import com.aluracursos.post.Modelos.Titulo;
import com.aluracursos.post.Modelos.Serie;
import com.aluracursos.post.Modelos.Pelicula;

public class CalculadoraDeTiempo {

    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void incluye(Titulo titulo) {
        this.tiempoTotal += titulo.getDuracionEnMinutos();
    }


}
