package com.smokynote.note.impl;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.smokynote.note.Note;
import com.smokynote.note.NotesRepository;
import com.smokynote.orm.DatabaseHelper;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

/**
 * @author Maksim Zakharov
 * @since 1.0
 */
public class NotesRepositoryOrmImpl implements NotesRepository {

    private final DatabaseHelper databaseHelper;

    @Inject
    public NotesRepositoryOrmImpl(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    @Override
    public List<Note> getAll() {
        try {
            return dao().queryBuilder().orderBy("schedule", false).query();
        } catch (SQLException e) {
            // RuntimeExceptionDao is not so runtime in some cases.
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Note note) {
        dao().create(note);
    }

    @Override
    public void save(Note note) {
        dao().update(note);
    }

    @Override
    public void clear() {
        try {
            dao().deleteBuilder().delete();
        } catch (SQLException e) {
            // TODO:
        }
    }

    private RuntimeExceptionDao<Note, Integer> dao() {
        return databaseHelper.getRuntimeExceptionDao(Note.class);
    }
}