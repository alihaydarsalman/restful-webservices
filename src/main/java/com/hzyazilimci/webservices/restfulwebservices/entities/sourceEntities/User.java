package com.hzyazilimci.webservices.restfulwebservices.entities.sourceEntities;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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
    @Size(min = 2, max = 60, message = "2-60 arasinda bir karakter dizisi giriniz.")
    @NotEmpty(message = "Name alani bos veya null olamaz!")
    private String name;
    //@Column
    @NotNull(message = "Bos birakilamaz.")
    @Past(message = "İleri tarih ile istek atilamaz.")
    private LocalDate birthDate;

    //kullanici silebilmek
    //kullaniciyi guncellemek
    //kullanici olusturabilmek
    //kullaniciyi getirebilmek
    //kullanicilari listeleyebilmek
    //belirli kullanici icin: postu silebilmek, gunvelleyebilmek, olusturmak, listelemek...
}
