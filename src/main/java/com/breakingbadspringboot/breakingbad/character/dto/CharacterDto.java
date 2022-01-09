package com.breakingbadspringboot.breakingbad.character.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterDto {

    private Long Char_Id;
    private String Name;
    private String Birthday;
    private List<String> Occupations;
    private String img;
    private String Status;
    private String Nickname;
    private List<Integer> Appearances;
    private String Portrayed;
    private List<String> Categories;





}
