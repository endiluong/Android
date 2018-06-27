package com.example.admin.yournotemygrade.purepackagesupport.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.yournotemygrade.R;
import com.example.admin.yournotemygrade.purepackagesupport.Model.DataModel;
import com.example.admin.yournotemygrade.purepackagesupport.Repository.Data_Access_Object_DAO;
import com.example.admin.yournotemygrade.purepackagesupport.Ultility.Constant;
import com.example.admin.yournotemygrade.purepackagesupport.Ultility.Support;

import java.util.ArrayList;

public class UpDelActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    DataModel note;
    TextView udtvId;
    EditText udTit, udCon;
    Data_Access_Object_DAO dao;
    ArrayList<DataModel> arrData;
    Button btnU, btnD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_del);
        udtvId = (TextView) findViewById(R.id.udtvId);
        udTit = (EditText) findViewById(R.id.udetTit);
        udCon = (EditText) findViewById(R.id.udetContent);
        btnU = (Button) findViewById(R.id.udbtnAdd);
        btnD = (Button) findViewById(R.id.udpbtnDel);

        // GET SELECTED NOTE FOR FURTHUR PROCESS
        note = getIntent().getParcelableExtra("notes");
        // PUT DATA TO VIEW
        udtvId.setText(note.getId());
        udTit.setText(note.getTitle());
        udCon.setText(note.getContent());
        //////////////////////////////////////////
        dao = Data_Access_Object_DAO.getInstance(getBaseContext());
        btnU.setOnClickListener(this);
        btnD.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.udbtnAdd:
                DataModel update = new DataModel();
                int sucess;
                if (note != null) {
                    update.setId(note.getId());
                    update.setTitle(udTit.getText().toString());
                    update.setContent(udCon.getText().toString());
//                  update.setPicture(temp.getPicture());
                    sucess = dao.updateProduct(update);
                    if (sucess > 0) {
                        Support.displayNotify(getBaseContext(), Constant.Sucess);
                        finish();
                    }
                    break;
                }
            case R.id.udpbtnDel:
                if (note != null) {
                    sucess=dao.deleteProduct(note);
                    if (sucess > 0) {
                        // Re-run initial to refresh the Spinner
                        Support.displayNotify(getBaseContext(), Constant.Sucess);
                        finish();
                    }
                }
                break;
        }
    }
}
