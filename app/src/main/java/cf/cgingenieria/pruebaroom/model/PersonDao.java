package cf.cgingenieria.pruebaroom.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by CGIngenieria on 07/02/2021.
 */
@Dao
public interface PersonDao {
    //CRUD
    //getAll
    @Query("SELECT * FROM Person")
    List<Person> getAllPerson();

    //getById para acceder args : antes de variable
    @Query("SELECT * FROM Person WHERE id = :id")
    Person getPersonById(int id);

    //Created funciona con list o object devuelve id asignado al nuevo elemento en la bd
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long createdPerson(Person person);

    //Update devuelve cantidad de filas actualizadas
    @Update
    int updatePerson(Person person);

    //Delete devuelve cantidad de filas eliminadas
    @Delete
    int deletePerson(Person person);
}
