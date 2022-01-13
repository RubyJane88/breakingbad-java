package com.breakingbadspringboot.breakingbad.dataloader;

import com.breakingbadspringboot.breakingbad.character.entity.CharacterEntity;
import com.breakingbadspringboot.breakingbad.character.repository.CharacterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CharacterDataLoader implements CommandLineRunner {

    final CharacterRepository characterRepository;

    public CharacterDataLoader(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCharacterData();
    }

    private void loadCharacterData() {
        if (characterRepository.count() == 0) {

            // generate random values from 0 to 100
//            Random random = new Random();
//            int randomValue = random.nextInt(100);

            List<String> occupation = new LinkedList<>();
            occupation.add("Meth Kingpin");
            occupation.add("High School Chemist Teacher");


            List<Integer> appearances = new LinkedList<>();
            appearances.add(1);
            appearances.add(2);
            appearances.add(3);
            appearances.add(4);
            appearances.add(5);

            List<String> categories = new LinkedList<>();
            categories.add("Breaking Bad");
            categories.add("Better Call Saul");


            var character1 = new CharacterEntity(1L, "Walter White", "09-07-1958", occupation,
                    "https://images.amcnetworks.com/amc.com/wp-content/uploads/2015/04/cast_bb_700x1000_walter-white-lg.jpg", "Deceased",
                    "Heisenberg", appearances, "Bryan Cranston", categories );

                characterRepository.save(character1);

        }

        List<String> occupation2 = new LinkedList<>();
        occupation2.add("Meth Kingpin");
        occupation2.add("High School Chemist Teacher");

        List<Integer> appearances2 = new LinkedList<>();
        appearances2.add(1);
        appearances2.add(2);
        appearances2.add(3);
        appearances2.add(4);
        appearances2.add(5);

        List<String> categories2 = new LinkedList<>();
        categories2.add("Breaking Bad");
        categories2.add("Better Call Saul");

        var character2 = new CharacterEntity(1L, "Walter White Jr", "07-08-1993", occupation2,
                "https://media1.popsugar-assets.com/files/thumbor/WeLUSvbAMS_GL4iELYAUzu7Bpv0/fit-in/1024x1024/filters:format_auto-!!-:strip_icc-!!-/2018/01/12/910/n/1922283/fb758e62b5daf3c9_TCDBRBA_EC011/i/RJ-Mitte-Walter-White-Jr.jpg", "Deceased",
                "Flynn", appearances2, "RJ Mitte", categories2 );

        characterRepository.save(character2);

    }
    }

