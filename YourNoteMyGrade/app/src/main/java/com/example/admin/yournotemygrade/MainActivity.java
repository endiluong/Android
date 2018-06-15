package com.example.admin.yournotemygrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.example.admin.yournotemygrade.purepackagesupport.Adapter.CustomAdapter;
import com.example.admin.yournotemygrade.purepackagesupport.Functionality.EditSubmitActivity;
import com.example.admin.yournotemygrade.purepackagesupport.Repository.DataModel;
import com.example.admin.yournotemygrade.purepackagesupport.Repository.Data_Access_Object_DAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    GridView grdView;
    Button btnAdd;
    Intent intent;
    ArrayList<DataModel> listAllDataModel;
    Data_Access_Object_DAO daoModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ////////////////////////////////////////////////
        grdView = (GridView) findViewById(R.id.grdView);
        /////////////////////////////////////////////////////////////////
        //Basically put it, where the ListView or GridView item located//
        ////////////////////////////////////////////////////////////////
        daoModel = Data_Access_Object_DAO.getInstance(getBaseContext());
        listAllDataModel = daoModel.getAllItem();
        //////////////////////////////////////
        // GET DATA
        ///////////
        //Get Intent from Input Activity
        /////////////////////
        Intent intent = getIntent();
        ////////////////////
        // Create Adapter put the whole list and layout put to Adapter
        ///////////
        ArrayAdapter<DataModel> adapter = new CustomAdapter(this, R.layout.customitem, listAllDataModel);
        //////////
        // DataList get adapter
        /////////
        grdView.setAdapter(adapter);

        ///////////////////////////////////////////////
        grdView = (GridView) findViewById(R.id.grdView);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        intent = new Intent(MainActivity.this, EditSubmitActivity.class);
        startActivity(intent);
    }
}
