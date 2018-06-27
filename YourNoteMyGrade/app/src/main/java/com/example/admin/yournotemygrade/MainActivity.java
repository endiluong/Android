package com.example.admin.yournotemygrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SearchView;

import com.example.admin.yournotemygrade.purepackagesupport.Adapter.CustomAdapter;
import com.example.admin.yournotemygrade.purepackagesupport.Controller.EditSubmitActivity;
import com.example.admin.yournotemygrade.purepackagesupport.Controller.UpDelActivity;
import com.example.admin.yournotemygrade.purepackagesupport.Model.DataModel;
import com.example.admin.yournotemygrade.purepackagesupport.Repository.Data_Access_Object_DAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    GridView grdView;
    Button btnAdd;
    Intent intent;
    DataModel temp;
    ArrayList<DataModel> listAllDataModel;
    Data_Access_Object_DAO daoModel;
    SearchView searchView;


    @Override
    protected void onResume() {
        super.onResume();
        grdView = (GridView) findViewById(R.id.grdView);
        daoModel = Data_Access_Object_DAO.getInstance(getBaseContext());
        listAllDataModel = daoModel.getAllItem();
        ArrayAdapter<DataModel> adapter = new CustomAdapter(this, R.layout.customitem, listAllDataModel);
        grdView.setAdapter(adapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onResume();
        searchView = (SearchView) findViewById(R.id.srchView);
        ////////////////////////////////////////////////
//        grdView = (GridView) findViewById(R.id.grdView);
        /////////////////////////////////////////////////////////////////
        //Basically put it, where the ListView or GridView item located//
        ////////////////////////////////////////////////////////////////
//        daoModel = Data_Access_Object_DAO.getInstance(getBaseContext());
//        listAllDataModel = daoModel.getAllItem();
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
        grdView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //near ly done
                temp = listAllDataModel.get(position);
                Update(temp);
            }
        });
        ///////////////////////////////////////////////
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);


    }

    private void Update(DataModel dataModel) {
        System.out.println(dataModel.getId());
        System.out.println(dataModel.getTitle());
        System.out.println(dataModel.getContent());
        intent = new Intent(MainActivity.this, UpDelActivity.class);
        intent.putExtra("notes", dataModel);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                intent = new Intent(MainActivity.this, EditSubmitActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        try {
//            ArrayList<DataModel> listSearch = new ArrayList<>();
            ArrayList<DataModel> searchResult = daoModel.getByName(newText);
//            DataModel temp =new DataModel();
//            for(searchResult:temp){
//
//            }
//            listSearch.add(searchResult);
            ArrayAdapter<DataModel> adapter = new CustomAdapter(this, R.layout.customitem, searchResult);
            grdView.setAdapter(adapter);
        } catch (IndexOutOfBoundsException e) {
//            listAllDataModel = daoModel.getAllItem();
//            ArrayAdapter<DataModel> adapter = new CustomAdapter(this, R.layout.customitem, listAllDataModel);
//            grdView.setAdapter(adapter);
//            return true;
            onClose();
        }
        return false;
    }

    @Override
    public boolean onClose() {
        listAllDataModel = daoModel.getAllItem();
        ArrayAdapter<DataModel> adapter = new CustomAdapter(this, R.layout.customitem, listAllDataModel);
        grdView.setAdapter(adapter);
        return true;
    }
}
