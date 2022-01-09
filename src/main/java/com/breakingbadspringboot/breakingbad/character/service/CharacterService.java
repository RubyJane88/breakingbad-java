package com.breakingbadspringboot.breakingbad.character.service;


import com.breakingbadspringboot.breakingbad.character.contract.CharacterContract;
import com.breakingbadspringboot.breakingbad.character.entity.CharacterEntity;
import com.breakingbadspringboot.breakingbad.character.repository.CharacterRepository;

import com.breakingbadspringboot.breakingbad.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class CharacterService implements CharacterContract {

    private final CharacterRepository characterRepository;

    @Override
    public Iterable<CharacterEntity> findAllCharacters() {

        return characterRepository.findAll();
    }

    @Override
    public CharacterEntity findCharacterById(Long id) {
        return finOrThow(id);
    }

    private CharacterEntity finOrThow(Long id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Character not found"));
    }

    @Override
    public void removeCharacterById(Long id) {
        characterRepository.deleteById(id);

    }

    @Override
    public CharacterEntity createCharacter(CharacterEntity character) {
        return characterRepository.save(character);
    }

    @Override
    public void updateCharacter(Long id, CharacterEntity character) {
        finOrThow(id);
        characterRepository.save(character);

    }
}
