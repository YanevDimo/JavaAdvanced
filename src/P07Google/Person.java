package P07Google;

import jdk.nashorn.api.tree.YieldTree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    // 1company,pokemons,parents,childs
    private Company company;
    private Car car;


    private List<Parent> parents;
    private List<Children> childrenList;
    private List<Pokemon> pokemons;

    public Person() {

        this.parents = new ArrayList<>();
        this.pokemons = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public void setComapany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemon() {
        return this.pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Children> getChildren() {
        return this.childrenList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Company:").append("%n");
        if (company != null) {
        builder.append(company.toString()).append("%n");
        }

        builder.append("Car:").append("%n");
        if (car != null) {
            builder.append(car.toString()).append("\n");
        }
        builder.append("Pokemon:").append("%n");
        for (Pokemon pokemon : pokemons) {
           builder.append(pokemon.toString()).append("%n");
        }
        builder.append("Parents:").append("%n");
        for (Parent parent : parents) {
            builder.append(parent.toString()).append("%n");
        }
        builder.append("Children: ").append("%n");
        for (Children children : childrenList) {
            builder.append(children.toString()).append("%n");
        }
        return builder.toString();
    }
}
