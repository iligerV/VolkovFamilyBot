package ru.telegram.familyBot.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    /**
     * Имя человека
     */
    String name;

    /**
     * Дата рождения
     */
    Date date;
}
