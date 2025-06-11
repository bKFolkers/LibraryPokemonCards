package nl.miwnn.ch16.bas.librarypokemoncards.model;

import jakarta.persistence.*;

/**
 * @author Bas Folkers
 * The concept of a Pokemon card for which the library can have copies
 */

@Entity
public class PokemonCard {
    public static final boolean DEFAULT_AVAILABLE = true;
    @Id @GeneratedValue
    private Long pokemonCardId;

    private String name;
    private String rarity;
    private Boolean available;

    @ManyToOne
    private PokemonSet pokemonSet;

    public PokemonCard(PokemonSet pokemonSet) {
        this.pokemonSet = pokemonSet;
        this.available = DEFAULT_AVAILABLE;
    }

//  Exists for JPA
    public PokemonCard() {
    }

    @Override
    public String toString() {
        return String.format("name: %s, rarity: %s", this.name, this.rarity);
    }

    public long getPokemonCardId() {
        return pokemonCardId;
    }

    public void setPokemonCardId(Long pokemonCardId) {
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
