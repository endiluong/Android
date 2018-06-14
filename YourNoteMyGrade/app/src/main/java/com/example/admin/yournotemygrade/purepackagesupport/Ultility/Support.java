package com.example.admin.yournotemygrade.purepackagesupport.Ultility;

import android.content.Context;
import android.widget.Toast;

public class Support {

    public static void displayNotify(Context context,String contents){
        Toast.makeText(context,contents,Toast.LENGTH_SHORT).show();
    }

}
