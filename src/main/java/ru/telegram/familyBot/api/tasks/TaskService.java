package ru.telegram.familyBot.api.tasks;

import ru.telegram.familyBot.api.Person.PersonRepository;
import ru.telegram.familyBot.exceptions.PersonNotFoundException;
import ru.telegram.familyBot.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskService {
    PersonRepository repository;

    public List<Person> getPerson() throws IOException {
        Iterator<Person> iterator = repository.findAll().iterator();
        List<Person> personList = new ArrayList<Person>();

        while (iterator.hasNext()) personList.add(iterator.next());

        return personList;
    }

    public Person getPerson(String personId) throws IOException {
        return repository.findById(personId).orElseThrow(PersonNotFoundException::new);
    }
}
