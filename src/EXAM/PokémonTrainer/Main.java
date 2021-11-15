package EXAM.PokémonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Trainer> trainers = new LinkedHashMap<>();
//
//        String line;
//        while (!(line = reader.readLine()).equals("tournament")) {
//            String[] tokens = line.split("\\s+");
//            String trainerName = tokens[0];
//            String pokemonName = tokens[1];
//            String pokemonType = tokens[2];
//            int pokemonHelt = Integer.parseInt(tokens[3]);
//
//            Pokemon pokemon = new Pokemon(pokemonName,pokemonType,pokemonHelt);
//            if (trainers.containsKey(trainerName)) {
//                Trainer trainer  = trainers.get(trainerName);
//                List<Pokemon>pokemonList = trainer.getPokemons();
//                pokemonList.add(pokemon);
//                trainers.put(trainerName,trainer);
//            } else {
//                Trainer trainer = new Trainer(trainerName);
//                List<Pokemon> pokemonList = new ArrayList<>();
//                pokemonList.add(pokemon);
//                trainer.setPokemons(new ArrayList<>());
//                trainers.put(trainerName,trainer);
//
//            }
//        }
//        while (!(line = reader.readLine()).equals("End")) {
//            switch (line){
//                case"Fire":
//                    break;
//                case "Water":
//                    break;
//                case "Electricity":
//                    break;
//            }
//        }
    }
}
