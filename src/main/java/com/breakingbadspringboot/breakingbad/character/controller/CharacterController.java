package com.breakingbadspringboot.breakingbad.character.controller;

import com.breakingbadspringboot.breakingbad.character.dto.CharacterDto;
import com.breakingbadspringboot.breakingbad.character.entity.CharacterEntity;
import com.breakingbadspringboot.breakingbad.character.service.CharacterService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/characters")
//@PreAuthorize("isAuthenticated()") // for authorization
public class CharacterController {

    private final CharacterService characterService;
    private final ModelMapper mapper;

    @GetMapping
    public List<CharacterDto> getAllCharacters() {
        var characterList = StreamSupport
                .stream(characterService.findAllCharacters().spliterator(), false).toList();

        return characterList
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    private CharacterDto convertToDto(CharacterEntity characterEntity) {
        return mapper.map(characterEntity, CharacterDto.class);
    }

    private CharacterEntity convertToEntity(CharacterDto characterDto) {
        return mapper.map(characterDto, CharacterEntity.class);
    }


}
