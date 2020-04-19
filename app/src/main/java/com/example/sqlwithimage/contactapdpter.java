package com.example.sqlwithimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class contactapdpter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<pojocontact> contactlist;

    public contactapdpter(contactList context, int layout, ArrayList<pojocontact> list) {
        this.context = context;
        this.layout = layout;
        this.contactlist = list;
    }

    @Override
    public int getCount() {
        return contactlist.size();
    }

    @Override
    public Object getItem(int position) {
        return contactlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    private class ViewHolder{
        TextView txtName, txtemail,txtnumber;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName =  row.findViewById(R.id.name);
            holder.txtemail =  row.findViewById(R.id.email);
            holder.txtnumber =  row.findViewById(R.id.number);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        pojocontact contact = contactlist.get(position);

        holder.txtName.setText(contact.getName());
        holder.txtemail.setText(contact.getEmail());
        holder.txtnumber.setText(contact.getNumber());

        return row;
    }
}
