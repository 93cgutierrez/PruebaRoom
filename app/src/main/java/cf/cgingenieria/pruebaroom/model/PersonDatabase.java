package cf.cgingenieria.pruebaroom.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by CGIngenieria on 07/02/2021.
 */
@Database(entities = {Person.class}, version = 1)
public abstract class PersonDatabase extends RoomDatabase {
    public abstract PersonDao personDao();
}
