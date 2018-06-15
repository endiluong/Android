package com.example.admin.yournotemygrade.purepackagesupport.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;


import com.example.admin.yournotemygrade.MainActivity;
import com.example.admin.yournotemygrade.R;
import com.example.admin.yournotemygrade.purepackagesupport.Functionality.EditSubmitActivity;
import com.example.admin.yournotemygrade.purepackagesupport.Repository.DataModel;
import com.example.admin.yournotemygrade.purepackagesupport.Ultility.Support;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<DataModel> {

    ///////////////////////////////////
    //CUSTOM VARIABLES CHANGE IN USE//
    /////////////////////////////////
    ArrayList<DataModel> arrayDataModel;
    int resource;
    Activity myContext;
    GridView gridView;
    View note;
    //////////////////////////////////////
    //THIS CUSTOM ADAPTER IS USING FOR //
    //LISTVIEW----------------GRIDVIEW//
    ///////////////////////////////////

    //Constructor
    //////////////////////////////////
    public CustomAdapter(@NonNull Activity context, int resource, @NonNull ArrayList<DataModel> objects) {
        super(context, resource, objects);
        arrayDataModel = objects;
        myContext = context;
        this.resource = resource;
    }

    ///////////////////////////////////////////////////////////////////////
    //Overide this getView method to get the convertView
    //Use the convertView to interact with the elements in CustomView Item
    ///////////////////////////////////////////////////////////////////////


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = myContext.getLayoutInflater();
        convertView = inflater.inflate(resource, null);
        /////////////////////////////////////////////////
        //Create Temp from DataModel to put on Custom Item
        /////////////////////////////////////////////////
        DataModel temp = arrayDataModel.get(position);
        ////////////////////////////////////////////////
        TextView tvTitle = (TextView) convertView.findViewById(R.id.cstvTittle);
        TextView tvContent = (TextView) convertView.findViewById(R.id.cstvContent);
        ///////////////////////////////////////////////

        ///////////////////////////////////////////////
        //Set Data to Item
        //////////////////////////////////////////////
        tvTitle.setText(temp.getTitle());
        tvContent.setText(temp.getContent());
        return convertView;
    }
    //////////////////////////////////////////////////////////////////////////////

}
