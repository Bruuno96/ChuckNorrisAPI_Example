package br.com;

import br.com.model.Joke;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static br.com.service.JokesService.findJokesCategories;
import static br.com.service.JokesService.getRandomJokeByCategoryName;

public class Main {



    public static void main(String[] args) throws Exception {

        System.out.println("Hy, I'm joke teller, so please , choose a category below");
        Map<Integer, String> jokesCategories = findJokesCategories();

        jokesCategories.forEach((key,value) -> {
            System.out.println(key+" - "+value);
        });

        System.out.println(">");
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        String categoryChosen = jokesCategories.get(opcao);

        Joke randomJokeByCategoryName = getRandomJokeByCategoryName(categoryChosen);

        System.out.println("I have a joke about "+categoryChosen+", let me tell you...");

        System.out.println(randomJokeByCategoryName.getValue());

    }
}
