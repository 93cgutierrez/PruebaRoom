package cf.cgingenieria.pruebaroom.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by CGIngenieria on 07/02/2021.
 */
@Entity
public class Person {
    @PrimaryKey(autoGenerate = true)
    Integer id;
    @ColumnInfo(name = "names")
    String name;
    @ColumnInfo(name = "last_name")
    String lastName;
    @ColumnInfo(name = "address")
    String address;
}