package nl.miwnn.ch16.bas.librarypokemoncards.repositories;

import nl.miwnn.ch16.bas.librarypokemoncards.model.PokemonSet;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonSetRepository extends JpaRepository<PokemonSet, Long> {

}
