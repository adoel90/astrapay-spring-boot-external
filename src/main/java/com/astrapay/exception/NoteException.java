package com.astrapay.exception;

public class NoteException extends RuntimeException {
    public NoteException(Long id) {
        super("Note dengan ID " + id + " tidak ditemukan.");
    }
}
