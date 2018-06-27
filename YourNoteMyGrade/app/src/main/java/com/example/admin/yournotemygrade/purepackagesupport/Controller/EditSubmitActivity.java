package com.example.admin.yournotemygrade.purepackagesupport.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.admin.yournotemygrade.MainActivity;
import com.example.admin.yournotemygrade.R;
import com.example.admin.yournotemygrade.purepackagesupport.Model.DataModel;
import com.example.admin.yournotemygrade.purepackagesupport.Repository.Data_Access_Object_DAO;

public class EditSubmitActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd2, btnPic, btnCan;
    EditText etID, etTit, etContent;
    String txtID, txtTit, txtContent;
    DataModel temp;
    Data_Access_Object_DAO dao;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_submit);
        etID = (EditText) findViewById(R.id.inpetID);
        etTit = (EditText) findViewById(R.id.inpetTitle);
        etContent = (EditText) findViewById(R.id.inpetContent);
        btnAdd2 = (Button) findViewById(R.id.inpbtnAdd);
        btnCan = (Button) findViewById(R.id.inpbtnCan);


        btnAdd2.setOnClickListener(this);
        btnCan.setOnClickListener(this);


        initial();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.inpbtnAdd):
                InsertButton();
                break;
            case (R.id.inpbtnCan):
                finish();
                break;
        }

    }


    protected void InsertButton() {
        txtID = etID.getText().toString();
        txtTit = etTit.getText().toString();
        txtContent = etContent.getText().toString();

        temp = new DataModel();
        temp.setId(txtID);
        temp.setTitle(txtTit);
        temp.setContent(txtContent);
        dao.insertItem(temp);

        finish();

    }

    private void initial() {
        dao = Data_Access_Object_DAO.getInstance(getBaseContext());
    }

    public static void Update(int position) {
        System.out.println(position);
    }


}
