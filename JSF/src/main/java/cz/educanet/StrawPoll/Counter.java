package cz.educanet.StrawPoll;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.ArrayList;

@ApplicationScoped
@Named

public class Counter {
    private ArrayList<Pokemon> pokemon = new ArrayList<>();

    public ArrayList<Pokemon> getPokemon() {
        return pokemon;
    }

    public void counterPlus(Pokemon pokemon1){
        pokemon1.setCounter(pokemon1.getCounter()+1);
    }

    public void start(){
        Pokemon pokemon1 = new Pokemon("Bulbasaur", 0);
        Pokemon pokemon2 = new Pokemon("Charmander", 0);
        Pokemon pokemon3 = new Pokemon("Squirtle", 0);
        Pokemon pokemon4 = new Pokemon("Caterpie", 0);
        pokemon.add(pokemon1);
        pokemon.add(pokemon2);
        pokemon.add(pokemon3);
        pokemon.add(pokemon4);
    }
}
