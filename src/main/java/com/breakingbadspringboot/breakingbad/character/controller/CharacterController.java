package com.breakingbadspringboot.breakingbad.character.controller;

import com.breakingbadspringboot.breakingbad.character.dto.CharacterDto;
import com.breakingbadspringboot.breakingbad.character.entity.CharacterEntity;
import com.breakingbadspringboot.breakingbad.character.service.CharacterService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


@GetMapping("/{id}")
public CharacterDto getCharacterById(Long id) {
        return convertToDto(characterService.findCharacterById(id));
}

@DeleteMapping("/{id}")
public void deleteCharacterById(@PathVariable("id") Long id) {
        characterService.removeCharacterById(id);
}

@PostMapping
public CharacterDto createCharacter(@Valid @RequestBody CharacterDto characterDto) {
   var entity = convertToEntity(characterDto);
   var savedEntity = characterService.createCharacter(entity);

   return convertToDto(savedEntity);

}

    @PutMapping("/{id}")
    public void updateCharacter(@PathVariable("id") Long id, @Valid @RequestBody CharacterDto characterDto) {

        if (!id.equals(characterDto.getChar_Id())) {
            characterService.updateCharacter(id, convertToEntity(characterDto));
        }
    }


    private CharacterDto convertToDto(CharacterEntity entity) {
        return mapper.map(entity, CharacterDto.class);
    }

    private CharacterEntity convertToEntity(CharacterDto dto) {
        return mapper.map(dto, CharacterEntity.class);
    }




    }