package com.iescarrillo.myfirstapp;

import static com.iescarrillo.myfirstapp.R.id.editName;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.i("Ciclo de vida", "Ha entrado en el método onCreate");

        EditText etName = findViewById(editName);
        EditText etSurname = findViewById(R.id.editSurname);

        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().equals("")) {
                    Toast toastName = new Toast(MainActivity.this);
                    toastName.setText("Name can´t be empty");
                    toastName.show();
                } else if (etSurname.getText().toString().equals("")) {
                    Toast toastSurname = new Toast(MainActivity.this);
                    toastSurname.setText("Surname can´t be empty");
                    toastSurname.show();
                } else {
                    /* Para navegar a otra Activity necesitamos crear un Intent(contextActivity,
                    new Intent(estadoDelActvityActual, ActivityALaQueQueremosNavegar.class)
                    */
                    Intent intentDetailActivity = new Intent(MainActivity.this, DetailActivity.class);

                    // Añado las clave-valor al intent
                    intentDetailActivity.putExtra("name", etName.getText().toString());
                    intentDetailActivity.putExtra("surname", etSurname.getText().toString());

                    // Log para ver si se está enviando bien los valores
                    Log.i("name", etName.getText().toString());
                    Log.i("surname", etSurname.getText().toString());

                    // Método para abrir otra activity
                    startActivity(intentDetailActivity);

                }
            }
        });

        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etSurname.setText("");
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();

        Log.i("Ciclo de vida", "Ha entrado en el método onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();

        Log.i("Ciclo de vida", "Ha entrado en el método onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();

        Log.i("Ciclo de vida", "Ha entrado en el método onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();

        Log.i("Ciclo de vida", "Ha entrado en el método onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        Log.i("Ciclo de vida", "Ha entrado en el método onDestroy");
    }

}