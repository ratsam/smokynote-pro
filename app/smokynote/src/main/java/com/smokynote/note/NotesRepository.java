package com.smokynote.note;

import java.util.List;

/**
 * @author Maksim Zakharov
 * @since 1.0
 */
public interface NotesRepository {

    /**
     * Return all the Notes sorted by schedule, descending.
     * <p/>
     * Doesn't return Notes that have been marked for deletion.
     * To retrieve such Notes use {@link #getMarkedForDeletion()}
     *
     * @return all existing active Notes
     */
    List<Note> getAll();

    /**
     * Return Notes that have been marked for deletion.
     *
     * @return all Notes marked for deletion
     */
    List<Note> getMarkedForDeletion();

    void add(Note note);

    void save(Note note);

    Note getById(Integer id);

    void markDeleted(Integer id);

    /**
     * Remove all notes from repository.
     */
    void clear();
}
