package com.breakingbadspringboot.breakingbad.character.contract;

import com.breakingbadspringboot.breakingbad.character.entity.CharacterEntity;

public interface CharacterContract {

    Iterable<CharacterEntity> findAllCharacters();

    CharacterEntity findCharacterById(Long id);

    void removeCharacterById(Long id);

    CharacterEntity createCharacter(CharacterEntity character);

    void updateCharacter( Long id, CharacterEntity character);

}
