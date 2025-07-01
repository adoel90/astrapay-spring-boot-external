package com.astrapay.controller;

import com.astrapay.entity.Note;
import com.astrapay.exception.NoteException;
import com.astrapay.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("${api.prefix}/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService service;

    @GetMapping
    public List<Note> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<Note> create(@Valid @RequestBody Note note) {
        return ResponseEntity.ok(service.add(note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {


        return service.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
