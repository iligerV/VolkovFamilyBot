package ru.telegram.familyBot.api.tasks;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import ru.telegram.familyBot.exceptions.EventNotFoundException;
import ru.telegram.familyBot.exceptions.PersonNotFoundException;
import ru.telegram.familyBot.model.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class EventService {
    public static final String COL_NAME = "events";

    public List<Event> getEventsDetails() throws InterruptedException, ExecutionException, EventNotFoundException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        if (documents.size() > 0) {
            List<Event> eventsList = new ArrayList<>();

            for (QueryDocumentSnapshot document : documents) {
                eventsList.add(document.toObject(Event.class));
            }

            return eventsList;
        }

        throw new PersonNotFoundException();
    }
}
