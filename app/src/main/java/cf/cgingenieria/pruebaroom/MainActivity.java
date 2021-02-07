package cf.cgingenieria.pruebaroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import cf.cgingenieria.pruebaroom.databinding.ActivityMainBinding;
import cf.cgingenieria.pruebaroom.model.Person;
import cf.cgingenieria.pruebaroom.model.PersonDatabase;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getCanonicalName();
    private ActivityMainBinding binding;
    private PersonDatabase personDatabase = AppBase.getPersonDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonCreated.setOnClickListener(view -> {
            //Realizar operacion bd en hilos secundarios
            new Thread(() -> {
                int random = (int) (Math.random() * 10) + 1;
                Person person = new Person(null, "_" + random, "_ln" + random, "Calle falsa 123_" + random);
                long id = personDatabase
                        .personDao()
                        .createdPerson(person);
                Log.d(TAG, "onClick: PersonListCreated:: " + random + " id:: " + id);
                Snackbar.make(view, "PersonListCreated:: " + random + " id:: " + id, Snackbar.LENGTH_LONG)
                        .show();
            }).start();
        });
        binding.buttonRead.setOnClickListener(view -> {
            new Thread(() -> {
                List<Person> personList = personDatabase.personDao().getAllPerson();
                Log.d(TAG, "onCreate: personListSize:: " + personList.size());
            }).start();
        });
        binding.buttonUpdate.setOnClickListener(view -> {

        });
        binding.buttonDelete.setOnClickListener(view -> {

        });
    }
}