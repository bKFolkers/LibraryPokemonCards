package nl.miwnn.ch16.bas.librarypokemoncards.controller;

import nl.miwnn.ch16.bas.librarypokemoncards.model.PokemonCard;
import nl.miwnn.ch16.bas.librarypokemoncards.repositories.PokemonCardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping({"/", "/pokemoncard/overview"})
    private String showPokemonCardOverview(Model datamodel) {
        datamodel.addAttribute("allPokemonCards", pokemonCardRepository.findAll());

        return "pokemonCardOverview";
    }

    @GetMapping("/pokemoncard/new")
    private String showNewPokemonCardForm(Model datamodel) {
        datamodel.addAttribute("formPokemonCard", new PokemonCard());
        return "pokemonCardForm";
    }

    @PostMapping("/pokemoncard/save")
    private String saveOrUpdatePokemonCard(@ModelAttribute("formPokemonCard") PokemonCard pokemonCardToBeSaved,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.err.println(bindingResult.getAllErrors());
        } else {
            pokemonCardRepository.save(pokemonCardToBeSaved);
        }

        return "redirect:/pokemoncard/overview";
    }

    @GetMapping("/pokemoncard/delete/{pokemonCardId}")
    private String deletePokemoncard(@PathVariable("pokemonCardId") Long pokemonCardId) {
        pokemonCardRepository.deleteById(pokemonCardId);
        return "redirect:/pokemoncard/overview";
    }
}
