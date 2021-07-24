package com.example.bitmapiso8583.Adapters;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bitmapiso8583.Field;
import com.example.bitmapiso8583.MainActivity;
import com.example.bitmapiso8583.R;

import java.util.ArrayList;

public class FieldsAdapter extends BaseAdapter {


    int valueTemp;


    private Context _context;
    private int _layout;
    private ArrayList<Field> _fields;

    public FieldsAdapter(Context _context, int _layout, ArrayList<Field> _fields) {
        this._context = _context;
        this._layout = _layout;
        this._fields = _fields;
    }

    @Override
    public int getCount() {
        return this._fields.size();
    }

    @Override
    public Object getItem(int position) {
        return this._fields.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView== null) {
            // inflamos los campos
            LayoutInflater layoutInflater = LayoutInflater.from(this._context);
            convertView = layoutInflater.inflate(this._layout, null);
            holder= new ViewHolder();
            holder.checkNumberField= (CheckBox) convertView.findViewById(R.id.checkField);
            holder.tvNameField= (TextView) convertView.findViewById(R.id.tvnameField);
            convertView.setTag(holder);

        } else{
            holder=(ViewHolder) convertView.getTag();
        }

        // nos traemos los datos dependiendo del valor
        Field field= this._fields.get(position);
        if(field.getValueField()==1) {
            holder.checkNumberField.setChecked(true);
        } else {
            holder.checkNumberField.setChecked(false);
        }
        holder.checkNumberField.setText("Campo " + field.getNumberField());
        holder.tvNameField.setText(field.getNameField());

        holder.checkNumberField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etStringHexa = (EditText) ((MainActivity)_context).findViewById(R.id.etbitmap);
                if(holder.checkNumberField.isChecked()==true) {

                    field.setValueField(1);


                } else {
                    field.setValueField(0);
                }

                field.setNumberField(position+1);
                field.setNameField(_fields.get(position).getNameField());
                _fields.set(position,field);

                etStringHexa.setText(stringHexa().toUpperCase());

            }
        });


        return convertView;


    }

    private String stringHexa() {
        int i;
        int j;
        int decimal;
        String strHexa="";
        String aux;
        String strn;
        for (i=0; i<64; i+=4) {
            strn=createStringforCovertion(i);
            decimal = Integer.parseInt(strn, 2);
            aux=Integer.toHexString(decimal);
            strHexa=strHexa+aux;
        }
        return strHexa;


    }


    private String createStringforCovertion(int start) {
        int i;
        String strbinary="";
        for (i=start; i<start+4; i++) {
            strbinary=strbinary+Integer.toString(_fields.get(i).getValueField());
        }
        return strbinary;
    }


    static class ViewHolder {
        public CheckBox checkNumberField;
        public TextView tvNameField;
    }
}
