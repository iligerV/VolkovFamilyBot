package ru.telegram.familyBot.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.sql.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("person")
@Builder
public class Person {

    /**
     * Имя человека
     */
    @Id
    String name;

    /**
     * Дата рождения
     */
    Date birthday;
}
