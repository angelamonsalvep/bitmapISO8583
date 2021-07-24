package com.example.bitmapiso8583;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bitmapiso8583.Adapters.FieldsAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    FieldsAdapter fieldsAdapter;

    Button btnCalculate;
    EditText etBitmapString;
    public ArrayList<Field> listFieldsArray= new ArrayList<>();
    public ArrayList<String> listNameFieldsArray= new ArrayList<>();
    public ArrayList<Integer> listValuesFieldsArray=new ArrayList<>();
    ListView listFields;
    String hexa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().clearFocus();

        listFields= (ListView) findViewById(R.id.list_fields);
        etBitmapString =findViewById(R.id.etbitmap);
        btnCalculate= findViewById(R.id.calculate_submit);

        etBitmapString.setFilters(new InputFilter[] {new InputFilter.LengthFilter(16)}); //filtro que permite ingresar solo caracteres hexadecimales

        etBitmapString.setText("0000000000000000");  //mostrar en edittext string de "0"

        hexa= etBitmapString.getText().toString();  //se obtiene el string hexadecimal

        fillListValues(parseHexBinary(hexa));  //se llena la lista de binarios con el string hexadecimal

        fillListNameFields(); //se llena la lista de nombres de campos

        fillListFields(); //se llena la lista de campos

        _inflateFilds(); //se carga el list view con el adaptador



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hexa= etBitmapString.getText().toString();  //se obtiene el hexadecimal

                setListValues(parseHexBinary(hexa));  // actualiza la lista de binarios

                setListFields();        //actualiza la lista de campos

                _inflateFilds();   //vuelve a mostrar los datos en el listview

            }
        });


        etBitmapString.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {

                //esto permite completar con 0 a la derecha si el hexadecimal tiene menos de 15 caracteres
                while (s.length()<15){
                    s=s.append("0");

                }

            }
        });

    }

    //se carga el listview con cada cardview
    private void _inflateFilds() {
        fieldsAdapter = new FieldsAdapter(MainActivity.this, R.layout.card_field, listFieldsArray);
        listFields.setAdapter(fieldsAdapter);
    }

    //metodo para llenar lista de los nombres de cada campo
    private void fillListNameFields() {
        listNameFieldsArray.add("Bit Map Extended");
        listNameFieldsArray.add("Primary account number (PAN)");
        listNameFieldsArray.add("Processing code");
        listNameFieldsArray.add("Amount, transaction");
        listNameFieldsArray.add("Amount, Settlement");
        listNameFieldsArray.add("Amount, cardholder billing");
        listNameFieldsArray.add("Transmission date & time");
        listNameFieldsArray.add("Amount, Cardholder billing fee");
        listNameFieldsArray.add("Conversion rate, Settlement");
        listNameFieldsArray.add("Conversion rate, cardholder billing");
        listNameFieldsArray.add("Systems trace audit number");
        listNameFieldsArray.add("Time, Local transaction");
        listNameFieldsArray.add("Date, Local transaction (MMdd)");
        listNameFieldsArray.add("Date, Expiration");
        listNameFieldsArray.add("Date, Settlement");
        listNameFieldsArray.add("Date, conversion");
        listNameFieldsArray.add("Date, capture");
        listNameFieldsArray.add("Merchant type");
        listNameFieldsArray.add("Acquiring institution country code");
        listNameFieldsArray.add("PAN Extended, country code");
        listNameFieldsArray.add("Forwarding institution. country code");
        listNameFieldsArray.add("Point of service entry mode");
        listNameFieldsArray.add("Application PAN number");
        listNameFieldsArray.add("Function code(ISO 8583:1993)/Network International identifier (?)");
        listNameFieldsArray.add("Point of service condition code");
        listNameFieldsArray.add("BPoint of service capture code");
        listNameFieldsArray.add("Authorizing identification response length");
        listNameFieldsArray.add("Amount, transaction fee");
        listNameFieldsArray.add("Amount. settlement fee");
        listNameFieldsArray.add("Amount, transaction processing fee");
        listNameFieldsArray.add("Amount, settlement processing fee");
        listNameFieldsArray.add("Acquiring institution identification code");
        listNameFieldsArray.add("Forwarding institution identification code");
        listNameFieldsArray.add("Primary account number, extended");
        listNameFieldsArray.add("Track 2 data");
        listNameFieldsArray.add("Track 3 data");
        listNameFieldsArray.add("Retrieval reference number");
        listNameFieldsArray.add("Authorization identification response");
        listNameFieldsArray.add("Response code");
        listNameFieldsArray.add("Service restriction code");
        listNameFieldsArray.add("Card acceptor terminal identification");
        listNameFieldsArray.add("Card acceptor identification code");
        listNameFieldsArray.add("Card acceptor name/location");
        listNameFieldsArray.add("BAdditional response data");
        listNameFieldsArray.add("BTrack 1 Data");
        listNameFieldsArray.add("Additional data - ISO");
        listNameFieldsArray.add("BAdditional data - National");
        listNameFieldsArray.add("Additional data - Private");
        listNameFieldsArray.add("Currency code, transaction");
        listNameFieldsArray.add("Currency code, settlement");
        listNameFieldsArray.add("Currency code, cardholder billing");
        listNameFieldsArray.add("Personal Identification number data");
        listNameFieldsArray.add("Security related control information");
        listNameFieldsArray.add("Additional amounts");
        listNameFieldsArray.add("Reserved ISO");
        listNameFieldsArray.add("Reserved ISO");
        listNameFieldsArray.add("Reserved National");
        listNameFieldsArray.add("Reserved National");
        listNameFieldsArray.add("Reserved for national use");
        listNameFieldsArray.add("Advice/reason code (private reserved)");
        listNameFieldsArray.add("Reserved Private");
        listNameFieldsArray.add("Reserved Private");
        listNameFieldsArray.add("Reserved Private");
        listNameFieldsArray.add("Message authentication code (MAC)");


    }

    //metodo para llenar la lista de binarios de cada campo
    private void fillListValues(String binary) {
        int i;
        for(i=0; i<binary.length(); i++) {

            listValuesFieldsArray.add(Character.getNumericValue(binary.charAt(i)));

        }
    }

    //metodo para convertir un hexadecimal a binario(formato de 4 digitos)
    private String hexToBin (String hex){
        int i = Integer.parseInt(hex);
        String bin = Integer.toBinaryString(i);
        while (bin.length()<4){
            bin="0"+bin;
        }
        return bin;

    }

    //metodo para crear string con el hexadecimal completo
    private String parseHexBinary(String hex) {
        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        String binaryString = "";

        for(int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            if(d == 0)	binaryString += "0000";
            else  binaryString += hexToBin(Integer.toString(d));
        }
        int nb= binaryString.length();
        return binaryString;
    }

    //metodo para actualizar lista de binarios
    private void setListValues(String binary) {
        int i;
        int l= binary.length();
        for(i=0; i<binary.length(); i++) {

            listValuesFieldsArray.set(i, Character.getNumericValue(binary.charAt(i)));

        }
    }

    //metodo para actualizar lista de campos
    private void setListFields() {
        int i;
        for(i=0; i<64; i++) {
            Field field = new Field();
            field.setNumberField(i+1);
            field.setNameField(listNameFieldsArray.get(i));
            field.setValueField(listValuesFieldsArray.get(i));
            listFieldsArray.set(i, field);

        }
    }

    //metodo para lleanr lista de campos
    private void fillListFields() {
        int i;
        for(i=0; i<64; i++) {
            Field field = new Field();
            field.setNumberField(i+1);
            field.setNameField(listNameFieldsArray.get(i));
            field.setValueField(listValuesFieldsArray.get(i));
            listFieldsArray.add(field);

        }
    }
}