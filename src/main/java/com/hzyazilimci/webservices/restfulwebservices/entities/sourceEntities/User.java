package com.hzyazilimci.webservices.restfulwebservices.entities.sourceEntities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * @author hzyazilimci
 */

@Data
//@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    //@Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@Column
    private String name;
    //@Column
    private LocalDate birthDate;

    //kullanici silebilmek
    //kullaniciyi guncellemek
    //kullanici olusturabilmek
    //kullaniciyi getirebilmek
    //kullanicilari listeleyebilmek
    //belirli kullanici icin: postu silebilmek, gunvelleyebilmek, olusturmak, listelemek...
}
