package com.example.admin.yournotemygrade.purepackagesupport.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.admin.yournotemygrade.R;
import com.example.admin.yournotemygrade.purepackagesupport.Repository.DataModel;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<DataModel> {

    ///////////////////////////////////
    //CUSTOM VARIABLES CHANGE IN USE//
    /////////////////////////////////
    ArrayList<DataModel> arrayDataModel;
    int resource;
    Activity myContext;
    //////////////////////////////////////
    //THIS CUSTOM ADAPTER IS USING FOR //
    //LISTVIEW----------------GRIDVIEW//
    ///////////////////////////////////

    //Constructor
    //////////////////////////////////
    public CustomAdapter(@NonNull Activity context, int resource, @NonNull ArrayList<DataModel> objects) {
        super(context, resource, objects);
        arrayDataModel=objects;
        myContext=context;
        this.resource=resource;
    }

    ///////////////////////////////////////////////////////////////////////
    //Overide this getView method to get the convertView
    //Use the convertView to interact with the elements in CustomView Item
    ///////////////////////////////////////////////////////////////////////


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= myContext.getLayoutInflater();
        convertView=inflater.inflate(resource,null);

        /////////////////////////////////////////////////
        //Create Temp from DataModel to put on Custom Item
        /////////////////////////////////////////////////
        DataModel temp= new DataModel();
        ////////////////////////////////////////////////
        TextView tvID=(TextView)convertView.findViewById(R.id.ictvId);
        TextView tvName=(TextView)convertView.findViewById(R.id.ictvName);
        ///////////////////////////////////////////////
        //Set Data to Item
        //////////////////////////////////////////////
        tvID.setText(temp.getId());
        tvName.setText(temp.getName());

        return convertView;
    }
}
