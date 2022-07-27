package com.example.contacts;
import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MyRecyclerViewAdapter adapter;
    private Button importButton;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        importButton = findViewById(R.id.importButton);
//        importButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
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
        adapter = new MyRecyclerViewAdapter(this, contactNames);
        findview();
        recyclerView.setAdapter(adapter);

        //be in modele 2 ta do noghte zadan migan delegation. harja toonesti azin estefade kon
        importButton.setOnClickListener(this::startContactGetProcess);
    }

    public void findview() {
        recyclerView = findViewById(R.id.my_recycler_view);
    }

    private void startContactGetProcess(View view) {
        if (checkSelfPermission(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            findContact(MainActivity.this, "B");

        } else {

            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, 100);
        }

    }
    public void findContact(Context context, String name) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = ContactsContract.Data.CONTENT_URI;
        String[] projection = new String[]{ContactsContract.PhoneLookup.CONTACT_ID};
        String selection = ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME + " = ?";
        String[] selectionArguments = {name};
        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArguments, null);
        if (cursor != null && cursor.moveToFirst()) {
            Long number = cursor.getLong(Math.max(0, cursor.getColumnIndex(ContactsContract.PhoneLookup.CONTACT_ID)));
            Toast.makeText(getApplicationContext(), String.valueOf(number), Toast.LENGTH_LONG).show();
            cursor.close();
        }
    }
}