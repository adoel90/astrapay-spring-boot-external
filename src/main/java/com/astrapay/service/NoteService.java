package com.astrapay.service;

import com.astrapay.entity.Note;
import com.astrapay.exception.NoteException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService {

    private final List<Note> notes = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public List<Note> getAll() {
        return new ArrayList<>(notes);
    }

    public Note add(Note note) {
        note.setId(idCounter.incrementAndGet());
        notes.add(note);
        return note;
    }

    public boolean delete(Long id) {

        Optional<Note> match = notes.stream().filter(n -> n.getId().equals(id)).findFirst();

        boolean result = false;
        if (match.isPresent()) {
            notes.remove(match.get());
            result = true;

        } else {

            throw new NoteException(id);
        }


        return result;


    }
}
