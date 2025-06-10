package nl.miwnn.ch16.bas.librarypokemoncards.model;

import jakarta.persistence.*;

/**
 * @author Bas Folkers
 * The concept of a Pokemon card for which the library can have copies
 */

@Entity
public class PokemonCard {
    @Id @GeneratedValue
    private Long pokemonCardId;

    private String name;
    private String rarity;

    @ManyToOne
    private PokemonSet pokemonSet;

    @Override
    public String toString() {
        return String.format("name: %s, rarity: %s", this.name, this.rarity);
    }

    public long getPokemonCardId() {
        return pokemonCardId;
    }

    public void setPokemonCardId(long pokemonCardId) {
        this.pokemonCardId = pokemonCardId;
    }

    public PokemonSet getPokemonSet() {
        return pokemonSet;
    }

    public void setPokemonSet(PokemonSet pokemonSet) {
        this.pokemonSet = pokemonSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
}
