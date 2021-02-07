package cf.cgingenieria.pruebaroom;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import cf.cgingenieria.pruebaroom.databinding.ActivityMainBinding;
import cf.cgingenieria.pruebaroom.model.Person;
import cf.cgingenieria.pruebaroom.model.PersonDatabase;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getCanonicalName();
    private ActivityMainBinding binding;
    private final PersonDatabase personDatabase = AppBase.getPersonDatabase();

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
        binding.buttonRead.setOnClickListener(view -> new Thread(() -> {
            List<Person> personList = personDatabase.personDao().getAllPerson();
            Log.d(TAG, "onCreate: personListSize:: " + personList.size());
        }).start());
        binding.buttonUpdate.setOnClickListener(view -> {
            //Realizar operacion bd en hilos secundarios
            new Thread(() -> {
                int idUpdate = 1;
                Person person = new Person(idUpdate, "PEPE", "PEREZ", "Calle falsa 123 [ACT] ");
                long id = personDatabase
                        .personDao()
                        .updatePerson(person);
                Log.d(TAG, "onClick: PersonListUpdate:: " + idUpdate + " id:: " + id);
                Snackbar.make(view, "PersonListUpdate:: " + idUpdate + " id:: " + id, Snackbar.LENGTH_LONG)
                        .show();
            }).start();
        });
        binding.buttonDelete.setOnClickListener(view -> {
            //Realizar operacion bd en hilos secundarios
            new Thread(() -> {
                int idDelete = 2;
                Person person = new Person(idDelete, "PEPE", "PEREZ", "Calle falsa 123 [ACT] ");
                long id = personDatabase
                        .personDao()
                        .deletePerson(person);
                Log.d(TAG, "onClick: PersonDelete:: " + idDelete + " id:: " + id);
                Snackbar.make(view, "PersonDelete:: " + idDelete + " id:: " + id, Snackbar.LENGTH_LONG)
                        .show();
            }).start();
        });
    }
}