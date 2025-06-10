package nl.miwnn.ch16.bas.librarypokemoncards.controller;

import nl.miwnn.ch16.bas.librarypokemoncards.repositories.PokemonCardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Bas Folkers
 * Handle all requests related dirextly or primalily to Pokemon cards
 */

@Controller
public class PokemonCardController {
    private final PokemonCardRepository pokemonCardRepository;

    public PokemonCardController(PokemonCardRepository pokemonCardRepository) {
        this.pokemonCardRepository = pokemonCardRepository;
    }

    @GetMapping("/")
    private String showPokemonCardOverview(Model datamodel) {
        datamodel.addAttribute("allPokemonCards", pokemonCardRepository.findAll());

        return "pokemonCardOverview";
    }

}
