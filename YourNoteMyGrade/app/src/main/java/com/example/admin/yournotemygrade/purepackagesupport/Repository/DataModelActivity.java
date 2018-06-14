package com.example.admin.yournotemygrade.purepackagesupport.Repository;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.purepackagesupport.Adapter.CustomAdapter;
import com.example.admin.purepackagesupport.R;

import java.util.ArrayList;

public class DataModelActivity extends AppCompatActivity {
    ListView DataList;
    ArrayList<DataModel> listAllDataModel;
    Data_Access_Object_DAO daoModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_model);

        DataList= (ListView)findViewById(R.id.dmaListView);
        /////////////////////////////////////////////////////////////////
        //Basically put it, where the ListView or GridView item located//
        ////////////////////////////////////////////////////////////////
        daoModel= Data_Access_Object_DAO.getInstance(getBaseContext());
        listAllDataModel= daoModel.getAllItem();
        //////////////////////////////////////
        // GET DATA
        ///////////
        //Get Intent from Input Activity
        /////////////////////
        Intent intent= getIntent();
        ////////////////////
        // Create Adapter put the whole list and layout put to Adapter
        ///////////
        ArrayAdapter<DataModel> adapter= new CustomAdapter(this,R.layout.itemcustom,listAllDataModel);
        //////////
        // DataList get adapter
        /////////
        DataList.setAdapter(adapter);
    }
}
