package com.example.bitmapiso8583;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.bitmapiso8583.Adapters.FieldsAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    public ArrayList<Field> listFieldsArray;
    public ArrayList listNameFieldsArray;
    ListView listFields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFields= (ListView) findViewById(R.id.list_fields);

        _inflateFilds();


    }

    private void _inflateFilds() {
        FieldsAdapter fieldsAdapter = new FieldsAdapter(getApplicationContext(), R.layout.card_field, listFieldsArray);
        listFields.setAdapter(fieldsAdapter);
    }

    private void fillListNameFields() {
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Bit Map Extended");


    }

    private void fillListFields() {
        Field field = new Field();
        field.setNumberField(1);
        field.setNameField("Bit Map Extended");
        int i;
        for(i=0; i<64; i++) {
        }
    }
}