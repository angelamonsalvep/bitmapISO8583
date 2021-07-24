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
    Field field;

    Button btnCalculate;
    EditText etBitmapString;
    public ArrayList<Field> listFieldsArray= new ArrayList<>();
    public ArrayList<String> listNameFieldsArray= new ArrayList<>();
    public ArrayList<Integer> listValuesFieldsArray=new ArrayList<>();
    ListView listFields;
    String current;
    String strnew;
    String hexa;
    String binary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFields= (ListView) findViewById(R.id.list_fields);
        etBitmapString =findViewById(R.id.etbitmap);
        btnCalculate= findViewById(R.id.calculate_submit);

        etBitmapString.setFilters(new InputFilter[] {new InputFilter.LengthFilter(16)});

        etBitmapString.setText("0000000000000000");

        hexa= etBitmapString.getText().toString();

        fillListValues(parseHexBinary(hexa));

        fillListNameFields();

        fillListFields();

        _inflateFilds();



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hexa= etBitmapString.getText().toString();

                setListValues(parseHexBinary(hexa));

                setListFields();

                _inflateFilds();

            }
        });


        listFields.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                /*Field field = new Field();
                if(listFields.isItemChecked(position)) {


                    field.setValueField(1);

                } else {
                    field.setValueField(0);
                }

                field.setNumberField(position+1);
                field.setNameField(listNameFieldsArray.get(position));
                listFieldsArray.set(position,field);

                _inflateFilds();*/



            }
        });

        etBitmapString.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {






            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                //strnew= etBitmapString.getText().subSequence(before,count).toString();

                //Character.toUpperCase(s.charAt(count));
                //current.replace(s.charAt(count-1), s.charAt(count));

                //etBitmapString.setText(etBitmapString.getText().delete(count-2, count-1));



            }

            @Override
            public void afterTextChanged(Editable s) {
                //etBitmapString.setText(strnew);

                hexa= etBitmapString.getText().toString();
                binary= parseHexBinary(hexa);
                Toast.makeText(MainActivity.this, binary, Toast.LENGTH_SHORT).show();


            }
        });







    }



    private void _inflateFilds() {
        fieldsAdapter = new FieldsAdapter(MainActivity.this, R.layout.card_field, listFieldsArray);
        listFields.setAdapter(fieldsAdapter);
    }

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
        listNameFieldsArray.add("BCurrency code, cardholder billing");
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

    private void fillListValues(String binary) {
        int i;
        for(i=0; i<binary.length(); i++) {

            listValuesFieldsArray.add(Character.getNumericValue(binary.charAt(i)));

        }


    }

    private String hexToBin (String hex){
        int i = Integer.parseInt(hex);
        String bin = Integer.toBinaryString(i);
        while (bin.length()<4){
            bin="0"+bin;
        }
        return bin;

    }

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

    private void setListValues(String binary) {
        int i;
        int l= binary.length();
        for(i=0; i<binary.length(); i++) {

            listValuesFieldsArray.set(i, Character.getNumericValue(binary.charAt(i)));

        }
    }

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