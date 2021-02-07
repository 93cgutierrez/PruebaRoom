package cf.cgingenieria.pruebaroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cf.cgingenieria.pruebaroom.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonCreated.setOnClickListener(view -> {

        });
        binding.buttonRead.setOnClickListener(view -> {

        });
        binding.buttonUpdate.setOnClickListener(view -> {

        });
        binding.buttonDelete.setOnClickListener(view -> {

        });
    }
}