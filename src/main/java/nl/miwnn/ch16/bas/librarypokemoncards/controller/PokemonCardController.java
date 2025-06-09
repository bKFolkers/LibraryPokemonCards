package nl.miwnn.ch16.bas.librarypokemoncards.controller;

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

    @GetMapping("/")
    private String showPokemonCardOverview(Model datamodel) {
        datamodel.addAttribute("nu", LocalDateTime.now());

        return "PokemonCardOverview";
    }

}
