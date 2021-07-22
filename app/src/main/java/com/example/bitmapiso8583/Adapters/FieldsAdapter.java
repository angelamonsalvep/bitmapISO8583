package com.example.bitmapiso8583.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bitmapiso8583.Field;
import com.example.bitmapiso8583.R;

import java.util.ArrayList;

public class FieldsAdapter extends BaseAdapter {


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
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
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
        field.setNumberField(position);
        if(field.getValueField()==1) {
            holder.checkNumberField.setChecked(true);
        } else {
            holder.checkNumberField.setChecked(false);
        }
        holder.checkNumberField.setText("Campo " + field.getNumberField());
        holder.tvNameField.setText(field.getNameField());
        return convertView;


    }

    static class ViewHolder {
        private CheckBox checkNumberField;
        private TextView tvNameField;
    }
}
