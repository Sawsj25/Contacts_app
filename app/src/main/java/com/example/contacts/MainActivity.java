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

public class MainActivity extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;
    Button mixButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mixButton = findViewById(R.id.mixButton);
        // data to populate the RecyclerView with
        ArrayList<String> contactNames = new ArrayList<>();
        contactNames.add("ali");
        contactNames.add("mohammad");
        contactNames.add("hasan");
        contactNames.add("zahra");
        contactNames.add("saeid");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, contactNames);
        recyclerView.setAdapter(adapter);

        mixButton.setOnClickListener(this::startContactGetProcess);
    }

    private void startContactGetProcess(View view) {

        //check permission
        //get contacts
    }
}