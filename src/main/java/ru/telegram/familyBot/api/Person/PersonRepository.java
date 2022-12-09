package ru.telegram.familyBot.api.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.telegram.familyBot.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
}
