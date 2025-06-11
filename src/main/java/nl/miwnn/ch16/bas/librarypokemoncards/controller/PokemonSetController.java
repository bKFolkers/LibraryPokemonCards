package nl.miwnn.ch16.bas.librarypokemoncards.controller;

import nl.miwnn.ch16.bas.librarypokemoncards.model.PokemonCard;
import nl.miwnn.ch16.bas.librarypokemoncards.model.PokemonSet;
import nl.miwnn.ch16.bas.librarypokemoncards.repositories.PokemonCardRepository;
import nl.miwnn.ch16.bas.librarypokemoncards.repositories.PokemonSetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Bas Folkers
 * Handle all requests related directly or primalily to Pokemon sets
 */

@Controller
public class PokemonSetController {
    private final PokemonSetRepository pokemonSetRepository;

    public PokemonSetController(PokemonSetRepository pokemonSetRepository) {
        this.pokemonSetRepository = pokemonSetRepository;
    }

    @GetMapping({"/", "/pokemonset/overview"})
    private String showPokemonSetOverview(Model datamodel) {
        datamodel.addAttribute("allPokemonSets", pokemonSetRepository.findAll());

        return "pokemonSetOverview";
    }

    @GetMapping("/pokemonset/new")
    private String showNewPokemonSetForm(Model datamodel) {
        datamodel.addAttribute("formPokemonSet", new PokemonSet());
        return "pokemonSetForm";
    }

    @PostMapping("/pokemonset/save")
    private String saveOrUpdatePokemonSet(@ModelAttribute("formPokemonSet") PokemonSet pokemonSetToBeSaved,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.err.println(bindingResult.getAllErrors());
        } else {
            pokemonSetRepository.save(pokemonSetToBeSaved);
        }

        return "redirect:/pokemonset/overview";
    }

    @GetMapping("/pokemonset/delete/{pokemonSetId}")
    private String deletePokemonSet(@PathVariable("pokemonSetId") Long pokemonSetId) {
        pokemonSetRepository.deleteById(pokemonSetId);
        return "redirect:/";
    }
}
