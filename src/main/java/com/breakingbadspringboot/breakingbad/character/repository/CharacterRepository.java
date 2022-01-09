package com.breakingbadspringboot.breakingbad.character.repository;


import com.breakingbadspringboot.breakingbad.character.entity.CharacterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CharacterRepository extends CrudRepository<CharacterEntity, Long> {

    // @Query("")
    // custom composite repository here

}
