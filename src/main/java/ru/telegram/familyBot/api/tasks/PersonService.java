package ru.telegram.familyBot.api.tasks;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import ru.telegram.familyBot.exceptions.PersonNotFoundException;
import ru.telegram.familyBot.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class PersonService {
    public static final String COL_NAME = "persons";

    public String savePersonDetails(Person person) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(person.getName()).set(person);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public List<Person> getPersonDetails() throws InterruptedException, ExecutionException, PersonNotFoundException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        if (documents.size() > 0) {
            List<Person> personList = new ArrayList<>();

            for (QueryDocumentSnapshot document : documents) {
                personList.add(document.toObject(Person.class));
            }

            return personList;
        }

        throw new PersonNotFoundException();
    }

    public Person getPersonDetails(String name) throws InterruptedException, ExecutionException, PersonNotFoundException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        if (document.exists()) {
            return document.toObject(Person.class);
        }

        throw new PersonNotFoundException();
    }

    public String updatePersonDetails(Person person) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(person.getName()).set(person);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deletePerson(String name) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();
        return "Document with Person ID " + name + " has been deleted";
    }
}
