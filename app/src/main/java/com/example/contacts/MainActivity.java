package com.example.contacts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contacts.MyRecyclerViewAdapter;
import com.example.contacts.R;

import java.util.ArrayList;
//import ezafi age hast pak she
public class MainActivity extends AppCompatActivity {
//public private rayat she
  private  MyRecyclerViewAdapter adapter;
  private Button importButton;

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

        // set up the RecyclerView
        //recycler ro bala tarif kon va inja faghat findview kon
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, contactNames);
        recyclerView.setAdapter(adapter);
        //be in modele 2 ta do noghte zadan migan delegation. harja toonesti azin estefade kon
        importButton.setOnClickListener(this::startContactGetProcess);
    }

    private void startContactGetProcess(View view) {
        //check permission
        //if no permission request permission
        //if has permission get contacts
    }
}