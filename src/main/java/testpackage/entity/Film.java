package testpackage.entity;

import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public  class Film {

   private String nameFilm;

   private String description;

   private String genre;

   private String voiceLanguage;

   private String format;

   private  String[] session;

   private  int ageLimit;

   private LocalDate date;

}
