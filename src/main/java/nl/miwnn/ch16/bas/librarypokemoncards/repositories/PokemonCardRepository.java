package nl.miwnn.ch16.bas.librarypokemoncards.repositories;

import nl.miwnn.ch16.bas.librarypokemoncards.model.PokemonCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonCardRepository extends JpaRepository<PokemonCard, Long> {

}
