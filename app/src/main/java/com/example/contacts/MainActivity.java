package com.example.contacts;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  private  MyRecyclerViewAdapter adapter;
  private  Button importButton;
  private  RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        importButton = findViewById(R.id.importButton);
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

    public void findContact(Context context ,String name) {

        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI;
        String[] projection = new String[] { ContactsContract.PhoneLookup._ID };
        String selection = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " = ?";
        String[] selectionArguments = { "John Johnson" };
        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArguments, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                cursor.getString(0);
                return;
            }
        }
    }
}