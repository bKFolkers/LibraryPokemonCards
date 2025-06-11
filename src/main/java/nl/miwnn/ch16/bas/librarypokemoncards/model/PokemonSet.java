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

    private String setName;
    private String releaseYear;

    @OneToMany(mappedBy = "pokemonSet")
    private List<PokemonCard> pokemonCard;

    @Override
    public String toString() {
        return String.format("%s", this.setName);
    }

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

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
}
