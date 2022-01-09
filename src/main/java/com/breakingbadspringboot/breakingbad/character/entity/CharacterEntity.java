package com.breakingbadspringboot.breakingbad.character.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
/*the above decorators are equivalent of this @Data,
 and they don't slow down JPA*/
//@Data
@Table(name = "character")
@Entity(name = "characters")
@NoArgsConstructor
@AllArgsConstructor
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "character_id_seq")
    @Column(name = "char_id", updatable = false, nullable = false)
    private Long  Char_Id;

    @NotNull
    private String Name;
    private String Birthday;

    @ElementCollection
    private List<String> Occupations;
    private String Image;
    private String Status;
    private String Nickname;

    @ElementCollection
    private List<Integer> Appearances;
    private String Portrayed;

    @ElementCollection
    private List<String> Categories;


    /*These 2 methods, equals and hashCode, below are required if @Data is not used*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CharacterEntity that = (CharacterEntity) o;
        return Char_Id != null && Objects.equals(Char_Id, that.Char_Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
