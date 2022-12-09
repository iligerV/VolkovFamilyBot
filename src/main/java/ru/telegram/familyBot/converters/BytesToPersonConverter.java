package ru.telegram.familyBot.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import ru.telegram.familyBot.model.Person;

import javax.annotation.Nullable;

public class BytesToPersonConverter implements Converter<byte[], Person> {
    private final Jackson2JsonRedisSerializer<Person> serializer;

    public BytesToPersonConverter() {
        serializer = new Jackson2JsonRedisSerializer<>(Person.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public Person convert(@Nullable byte[] value) {
        return serializer.deserialize(value);
    }
}
