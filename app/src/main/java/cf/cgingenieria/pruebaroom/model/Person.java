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

    public Person() {
    }

    public Person(Integer id, String name, String lastName, String address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
