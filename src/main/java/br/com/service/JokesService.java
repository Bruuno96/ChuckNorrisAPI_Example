package br.com.service;

import br.com.model.Joke;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class JokesService {

    public static Map<Integer,String> findJokesCategories() throws Exception{
        String endpointGET = "https://api.chucknorris.io/jokes/categories";

        try {
            // indica o endpoint a ser conectado
            URL url = new URL(endpointGET);

            // efetiva a conexão
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            // Pega a resposta e transforma em um BufferedReader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            // Transforma em string
            String s = bufferedReader.readLine();

            // Trata essa string e deixa apenas com separador de vírgula
            String[] separatedStrings = s
                    .replaceAll("\\[", "")
                    .replaceAll("]", "")
                    .replaceAll(String.valueOf('"'),"")
                    .split(",");

            // Coloca cada categoria como item de uma coleçao
            Map<Integer,String> map = new HashMap<>();
            for(int i = 0; i < separatedStrings.length; i++){
                map.put(i,separatedStrings[i]);
            }

            // Retorna coleção
            return map;
        }catch (Exception e){
            throw new Exception("Error: "+e.getMessage());
        }
    }

    public static Joke getRandomJoke() throws Exception{
        String path = "https://api.chucknorris.io/jokes/random";

        try {

            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStreamReader readerIn = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(readerIn);

            String jsonString = bufferedReader.readLine();
            Joke joke = new ObjectMapper().readValue(jsonString, Joke.class);

            return joke;

        }catch (Exception e){
            throw new IOException("Erro: "+e.getMessage());
        }
    }

    public static Joke getRandomJokeByCategoryName(String category) throws IOException{
        String path = "https://api.chucknorris.io/jokes/random?category="+category;

        try {

            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            Joke joke = new ObjectMapper().readValue(reader.readLine(), Joke.class);

            return joke;

        }catch (Exception exception){
            throw new IOException("Erro: "+exception.getMessage());
        }
    }
}
