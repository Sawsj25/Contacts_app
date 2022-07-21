package com.example.contacts;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  private  MyRecyclerViewAdapter adapter;
  private Button importButton;
  private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inja chandta tabe besaz hamaro tooye onCreate nazar mese initView o initData o ina
        importButton = findViewById(R.id.importButton);
        // data to populate the RecyclerView with
        ArrayList<String> contactNames = new ArrayList<>();
        contactNames.add("ali");
        contactNames.add("mohammad");
        contactNames.add("hasan");
        contactNames.add("zahra");
        contactNames.add("saeid");
        contactNames.add("yousef");
        contactNames.add("mohammadamin");
        contactNames.add("susan");
        contactNames.add("fateme");
        contactNames.add("sam");
        contactNames.add("alireza");
        contactNames.add("saba");
        contactNames.add("majid");
        contactNames.add("xaniar");
        contactNames.add("nilofar");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, contactNames);
        recyclerView.setAdapter(adapter);
        //be in modele 2 ta do noghte zadan migan delegation. harja toonesti azin estefade kon
        importButton.setOnClickListener(this::startContactGetProcess);
    }
    public void findview (){
        recyclerView = findViewById(R.id.my_recycler_view);
    }

    private void startContactGetProcess(View view) {
        if (checkSelfPermission(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED){

        } else {

            requestPermissions(new String[] {Manifest.permission.READ_CONTACTS}, 100);
        }
    }
}