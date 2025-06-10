package nl.miwnn.ch16.bas.librarypokemoncards.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Bas Folkers
 * The concept of a Pokemon card for which the library can have copies
 */

@Entity
public class PokemonCard {
    @Id @GeneratedValue
    private long pokemonCardId;

    private String name;
    private String rarity;

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
