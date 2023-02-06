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
public class Event {

    /**
     * Название события
     */
    String name;

    /**
     * Дата события
     */
    Date date;
}
