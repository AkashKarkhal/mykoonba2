package com.example.mykoonba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactSelectionActivity extends AppCompatActivity {

     ListView listView;
    AppCompatButton confirmButton,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_selection);

        back=findViewById(R.id.bakContactSelection);
        listView = findViewById(R.id.listViewContactSelection);
        confirmButton = findViewById(R.id.confirmButtonContactSelection);

        // Sample data for the list
        ArrayList<String> itemList = new ArrayList<>();
        itemList.add("John Doe");
        itemList.add("Jane Doe");
        itemList.add("Alice Johnson");
        itemList.add("Bob Smith");
        itemList.add("Eva Brown");
        itemList.add("Michael Johnson");
        itemList.add("Sophia Davis");
        itemList.add("David Wilson");
        itemList.add("Olivia Miller");
        itemList.add("Daniel Taylor");

        // Adapter to populate the list
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_multiple_choice, itemList);
        listView.setAdapter(adapter);

        // Set choice mode to multiple selection
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // Set item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item selection here if needed
            }
        });

        // Set button click listener to get selected items
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected items
                StringBuilder selectedItems = new StringBuilder();
                for (int i = 0; i < listView.getCount(); i++) {
                    if (listView.isItemChecked(i)) {
                        selectedItems.append(itemList.get(i)).append("\n");
                    }
                }

                // Display selected items (you can customize this part)
                Toast.makeText(getApplicationContext(), "Selected Items:\n" + selectedItems.toString(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}