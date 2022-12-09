package ru.telegram.familyBot.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import ru.telegram.familyBot.model.Person;

import javax.annotation.Nullable;

public class PersonToBytesConverter implements Converter<Person, byte[]> {
    private final Jackson2JsonRedisSerializer<Person> serializer;

    public PersonToBytesConverter() {
        serializer = new Jackson2JsonRedisSerializer<>(Person.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public byte[] convert(@Nullable Person value) {
        return serializer.serialize(value);
    }
}
