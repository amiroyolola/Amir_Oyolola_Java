package com.company.summative.Controller;

import com.company.summative.model.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class DefinitionController {
    private List<Definition> definitionList;
    public DefinitionController(){
        Definition d1 = new Definition("Because", "For the reason that");
        Definition d2 = new Definition("Eruct", "To belch, as gas from the stomach");
        Definition d3 = new Definition("Instruct", "To furnish with information ");
        Definition d4 = new Definition("Exhausted", "Drained of strength or energy");
        Definition d5 = new Definition("Euphoria", "A state of intense happiness");
        Definition d6 = new Definition("Elevated", "Raised up, especially above the ground or above the normal level");

        Definition d7 = new Definition("Brume", "Mist");
        Definition d8 = new Definition("Fabricable", "Able to be shaped or formed");
        Definition d9 = new Definition("Momentus", "Of great or far-reaching importance or consequence");
        Definition d10 = new Definition("Ganymede", "The largest moon of planet Jupiter");
        definitionList = Arrays.asList(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10);
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getWord() {
        Random rand = new Random();
        return definitionList.get(rand.nextInt(10));
    }

}
