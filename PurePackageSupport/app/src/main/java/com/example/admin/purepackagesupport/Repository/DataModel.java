package com.example.admin.purepackagesupport.Repository;

import android.os.Parcel;
import android.os.Parcelable;

public class DataModel implements Parcelable {
    String id,name;
    //////////////////////////////////
    //This is the Basic Data Model //
    ////////////////////////////////


    public DataModel() {
    }

    public DataModel(String id) {
        this.id = id;
    }

    public DataModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    protected DataModel(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
    }
}
