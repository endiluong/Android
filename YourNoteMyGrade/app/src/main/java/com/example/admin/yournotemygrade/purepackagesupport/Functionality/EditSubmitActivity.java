package com.example.admin.yournotemygrade.purepackagesupport.Functionality;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.yournotemygrade.MainActivity;
import com.example.admin.yournotemygrade.R;
import com.example.admin.yournotemygrade.purepackagesupport.Repository.DataModel;
import com.example.admin.yournotemygrade.purepackagesupport.Repository.Data_Access_Object_DAO;
import com.example.admin.yournotemygrade.purepackagesupport.Ultility.Support;

public class EditSubmitActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd2,btnPic,btnCan;
    EditText etID,etTit,etContent;
    String txtID,txtTit,txtContent;
    DataModel temp;
    Data_Access_Object_DAO dao;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_submit);
        etID=(EditText) findViewById(R.id.inpetID);
        etTit=(EditText) findViewById(R.id.inpetTitle);
        etContent=(EditText) findViewById(R.id.inpetContent);
        btnAdd2=(Button)findViewById(R.id.inpbtnAdd);
        btnPic=(Button)findViewById(R.id.inpbtnPic);
        btnCan=(Button)findViewById(R.id.inpbtnCan);

        btnAdd2.setOnClickListener(this);
        btnPic.setOnClickListener(this);
        btnCan.setOnClickListener(this);
        initial();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case (R.id.inpbtnAdd):
                InsertButton();
                break;
            case (R.id.inpbtnPic):
                break;
            case (R.id.inpbtnCan):
                break;
        }

    }


    protected void InsertButton(){
        txtID=etID.getText().toString();
        txtTit=etTit.getText().toString();
        txtContent=etContent.getText().toString();

        temp= new DataModel();
        temp.setId(txtID);
        temp.setTitle(txtTit);
        temp.setContent(txtContent);
        dao.insertItem(temp);

        i= new Intent(EditSubmitActivity.this, MainActivity.class);
        startActivity(i);

    }
    private void initial()
    {
        dao= Data_Access_Object_DAO.getInstance(getBaseContext());
    }

    public static void Update(int position){
        System.out.println(position);
    }

}
