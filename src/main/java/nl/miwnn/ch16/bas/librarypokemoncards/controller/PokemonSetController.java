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
@RequestMapping("/pokemonset")
public class PokemonSetController {
    private final PokemonCardRepository pokemonCardRepository;
    private final PokemonSetRepository pokemonSetRepository;

    public PokemonSetController(PokemonCardRepository pokemonCardRepository,
                                PokemonSetRepository pokemonSetRepository) {
        this.pokemonCardRepository = pokemonCardRepository;
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

    @GetMapping("/new/{pokemonCardId}")
    private String createNewPokemonSet(@PathVariable("pokemonCardId") Long pokemonCardId) {
        Optional<PokemonCard> optionalCard = pokemonCardRepository.findById(pokemonCardId);

        if (optionalCard.isPresent()) {
            PokemonSet newSet = new PokemonSet();
            newSet.setName("New set");
            pokemonSetRepository.save(newSet);

            PokemonCard card = optionalCard.get();
            card.setPokemonSet(newSet);
            pokemonCardRepository.save(card);

            return "redirect:/pokemoncard/overview";
        }

        return "redirect:/pokemoncard/overview";
    }

}
