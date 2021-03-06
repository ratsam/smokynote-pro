package com.smokynote.dagger;

import com.smokynote.NotesListActivity;
import com.smokynote.NotesListFragment;
import com.smokynote.alarm.AlarmScheduler;
import com.smokynote.alarm.timed.TimedAlarmActivity;
import com.smokynote.note.NotesRepository;
import com.smokynote.note.impl.NotesRepositoryOrmImpl;
import com.smokynote.record.RecordFragment;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * @author Maksim Zakharov
 * @author $Author$ (current maintainer)
 * @since 1.0
 */
@Module(injects = {
        // Classes to retrieve using dagger.ObjectGraph#get
        NotesRepository.class,
        AlarmScheduler.class,

        // Actual classes to inject dependencies to
        NotesListActivity.class,
        NotesListFragment.class,
        RecordFragment.class,
        TimedAlarmActivity.class,

        NotesRepositoryOrmImpl.class,
})
public class NotesModule {

    @Provides
    @Singleton
    public NotesRepository provideNotesRepository(NotesRepositoryOrmImpl impl) {
        return impl;
    }
}
