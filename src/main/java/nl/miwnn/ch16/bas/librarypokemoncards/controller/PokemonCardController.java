package nl.miwnn.ch16.bas.librarypokemoncards.controller;

import nl.miwnn.ch16.bas.librarypokemoncards.model.PokemonCard;
import nl.miwnn.ch16.bas.librarypokemoncards.model.PokemonSet;
import nl.miwnn.ch16.bas.librarypokemoncards.repositories.PokemonCardRepository;
import nl.miwnn.ch16.bas.librarypokemoncards.repositories.PokemonSetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Bas Folkers
 * Handle all requests related directly or primalily to Pokemon cards
 */

@Controller
@RequestMapping("/pokemoncard")
public class PokemonCardController {
    private final PokemonSetRepository pokemonSetRepository;
    private final PokemonCardRepository pokemonCardRepository;

    public PokemonCardController(PokemonCardRepository pokemonCardRepository,
                                 PokemonSetRepository pokemonSetRepository) {
        this.pokemonSetRepository = pokemonSetRepository;
        this.pokemonCardRepository = pokemonCardRepository;
    }

    @GetMapping("/new/{pokemonSetId}")
    private String addNewPokemonCard(@PathVariable("pokemonSetId") Long pokemonSetId) {
        Optional<PokemonSet> optionalPokemonSet = pokemonSetRepository.findById(pokemonSetId);

        if(optionalPokemonSet.isPresent()) {
            PokemonCard pokemonCard = new PokemonCard(optionalPokemonSet.get());
            pokemonCardRepository.save(pokemonCard);
        }

        return "redirect:/";
    }

    @GetMapping({"/pokemoncard/overview"})
    private String showPokemonCardOverview(Model datamodel) {
        datamodel.addAttribute("allPokemonCards", pokemonCardRepository.findAll());

        return "pokemonCardOverview";
    }

//    @GetMapping("/pokemoncard/new")
//    private String showNewPokemonCardForm(Model datamodel) {
//        datamodel.addAttribute("formPokemonCard", new PokemonCard());
//        datamodel.addAttribute("allSets", pokemonSetRepository.findAll());
//        return "pokemonCardForm";
//    }

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
