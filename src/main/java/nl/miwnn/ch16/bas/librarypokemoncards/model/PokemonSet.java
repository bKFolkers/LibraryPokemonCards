package nl.miwnn.ch16.bas.librarypokemoncards.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * @author Bas Folkers
 * Represents the specific set with which a Pokemon card was released.
 */

@Entity
public class PokemonSet {

    @Id @GeneratedValue
    private Long pokemonSetId;
    private String name;

    @OneToMany(mappedBy = "pokemonSet")
    private List<PokemonCard> pokemonCard;

    public List<PokemonCard> getPokemonCard() {
        return pokemonCard;
    }

    public void setPokemonCard(List<PokemonCard> pokemonCard) {
        this.pokemonCard = pokemonCard;
    }

    public Long getPokemonSetId() {
        return pokemonSetId;
    }

    public void setPokemonSetId(Long pokemonSetId) {
        this.pokemonSetId = pokemonSetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
