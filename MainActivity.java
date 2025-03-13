package com.example.a25_03_13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextPaint;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> lista;
    ListView listaW;
    EditText wejscie;
    Button dodaj;
    String path = "data.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaW = findViewById(R.id.lista);
        wejscie = findViewById(R.id.wejscie);
        dodaj = findViewById(R.id.dodanie);

        wczytanie();
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                lista
        );
        listaW.setAdapter(adapter);
        dodaj.setOnClickListener(view -> dodanie());
    }

    private void dodanie() {
        lista.add(wejscie.getText().toString());
        zapis(wejscie.getText().toString());
    }

    private void zapis(String danedododania) {
        try {
            FileWriter writer = new FileWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void wczytanie() {
        lista=new ArrayList<>();
        File file = new File(path);
        Scanner reader = null;
        try {
            reader = new Scanner(file);
            while (reader.hasNextLine())
            {
                lista.add(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}