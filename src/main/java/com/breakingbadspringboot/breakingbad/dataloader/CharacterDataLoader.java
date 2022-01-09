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
    }
}
