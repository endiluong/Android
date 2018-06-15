package com.example.admin.yournotemygrade.purepackagesupport.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Data_Access_Object_DAO {

    private SQLiteDatabase db;
    private static Data_Access_Object_DAO instance;

    public Data_Access_Object_DAO(Context context) {
        SQLiteHelper sqlHelper = new SQLiteHelper(context);
        db = sqlHelper.getWritableDatabase();
    }

    //Get One ITEM
    public ArrayList<DataModel> getDataModels(String sql, String... selectionArgs) {
        ArrayList<DataModel> result = new ArrayList<>();
        Cursor c = db.rawQuery(sql, selectionArgs);
        DataModel temp;
//For bitmap image
//        ByteArrayInputStream imgStream;
//        byte[] imgFromData
///////////////////////////////////////
        while (c.moveToNext()) {
            temp = new DataModel();
            temp.setId(c.getString(c.getColumnIndex(SQLiteHelper.DATA_MODEL_ID)));
            temp.setTitle(c.getString(c.getColumnIndex(SQLiteHelper.DATA_MODEL_TITLE)));
            temp.setContent(c.getString(c.getColumnIndex(SQLiteHelper.DATA_MODEL_CONTENT)));

            //////////////////////////////////
            //BITMAP PICTURE
            //////////////////////////////////
//                imgFromData=c.getBlob(c.getColumnIndex(SQLiteHelper.xxxxx));
//                imgStream= new ByteArrayInputStream(imgFromData);
//                temp.setXXX(BitmapFactory.decodeStream(imgStream));
            //////////////////////////////////////////////////////
            result.add(temp);
        }
        return result;
    }

    //Get All List
    public ArrayList<DataModel> getAllItem() {
        String sql = "SELECT * FROM " + SQLiteHelper.DATA_TABLE_NAME;
        return getDataModels(sql);
    }

    //get By Id
    public DataModel getById(String Id) {
        String sql = "SELECT * FROM " + SQLiteHelper.DATA_TABLE_NAME + " WHERE ID=? ";
        ArrayList<DataModel> list = getDataModels(sql, Id);
        return list.get(0);
    }

    //get By Title
    public DataModel getByName(String title) {
        String sql = "SELECT * FROM " + SQLiteHelper.DATA_TABLE_NAME + " WHERE TITLE=? ";
        ArrayList<DataModel> list = getDataModels(sql, title);
        return list.get(0);
    }

    /////////////////////////////////////////////////
    //////////
    /// ADD ITEM TO DATABASE
    ///////////////////////////////////////////////
    public long insertItem(DataModel datamodel) {
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.DATA_MODEL_ID , datamodel.getId());
        values.put(SQLiteHelper.DATA_MODEL_TITLE , datamodel.getTitle());
        values.put(SQLiteHelper.DATA_MODEL_CONTENT , datamodel.getContent());
        // FOR IMAGE BITMAP
        /////////////////////////////////
//        ByteArrayOutputStream baos= new ByteArrayOutputStream();
//        Bitmap bitmap= datamodel.getXXX;
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos);
//        byte[] image= baos.toByteArray();
//          values.put(SQLiteHelper.DATABASE_XXXX,image);
        return db.insert(SQLiteHelper.DATA_TABLE_NAME, null, values);
    }

    /////////////////////////////////////////////////
    /////////
    /// UPDATE
    ////////////////////////////////////////////////
    //Update
    public int updateProduct(DataModel dataModel) {
        ContentValues values = new ContentValues();

        values.put(SQLiteHelper.DATA_MODEL_ID, dataModel.getId());
        values.put(SQLiteHelper.DATA_MODEL_TITLE, dataModel.getTitle());
        values.put(SQLiteHelper.DATA_MODEL_CONTENT, dataModel.getContent());
        // image
        ///////////////////////////////////////////////////////////
        //picture
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        Bitmap bitmap = dataModel.getXXXX();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//        byte[] image = baos.toByteArray();
//        values.put(SQLHelper.DATA_XXXX, image);
        return db.update(SQLiteHelper.DATA_TABLE_NAME, values, "id=?", new String[]{dataModel.getId()});
    }

    ///////////////////////////////////////////////
    ////////
    /// DELETE
    //////////////////////////////////////////////
    public int deleteProduct(DataModel dataModel) {
        return db.delete(SQLiteHelper.DATA_TABLE_NAME, "id=?", new String[]{dataModel.getId()});
    }

    //////////////////////////////////////////////
    /////////////
    /// CREATE INSTANCE for other class recall
    ///////////////////////////////////////////
    public static Data_Access_Object_DAO getInstance(Context context) {
        if (instance == null) {
            instance = new Data_Access_Object_DAO(context);
        }
        return instance;
    }
}
