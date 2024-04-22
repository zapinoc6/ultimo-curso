package com.aluracursos.post.principal;
import com.aluracursos.post.Modelos.Titulo;
import com.aluracursos.post.Modelos.TituloOmdb;
import com.aluracursos.post.Modelos.excepciones.ErrorEnConversionDeDuracionException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la Pelicula buscada:  ");
        String busqueda = lectura.nextLine();

        // Codifica el nombre de la película para evitar problemas con espacios en blanco y caracteres especiales
        String busquedaCodificada = URLEncoder.encode(busqueda, StandardCharsets.UTF_8);

        String direccion = "https://www.omdbapi.com/?t=" + busquedaCodificada + "&apikey=b87babb7";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            //Titulo miTitulo = gson.fromJson(json, Titulo.class);
            TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println("Titulo: " + miTituloOmdb);

            Titulo miTitulo = new Titulo(miTituloOmdb);
            System.out.println("Titulo ya convertido: " + miTitulo);

        } catch (NumberFormatException e) {
            System.out.println("Ocurrio un error : ");
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Ocurrio un Error: ");
            System.out.println(e.getMessage());

        } catch (ErrorEnConversionDeDuracionException e){
            System.out.println("Ocurrio un error inesperado");
            System.out.println(e.getMessage());
        }
        System.out.println("Finalizo la ejecucion del programa");
    }
}
