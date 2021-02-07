package cf.cgingenieria.pruebaroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import cf.cgingenieria.pruebaroom.databinding.ActivityMainBinding;
import cf.cgingenieria.pruebaroom.model.Person;
import cf.cgingenieria.pruebaroom.model.PersonDatabase;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getCanonicalName();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonCreated.setOnClickListener(view -> {

        });
        binding.buttonRead.setOnClickListener(view -> {
            new Thread(() -> {
                PersonDatabase personDatabase = Room.databaseBuilder(
                        this,
                        PersonDatabase.class,
                        "database-person")
                        .build();
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