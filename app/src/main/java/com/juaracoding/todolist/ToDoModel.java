package com.juaracoding.todolist;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

public class ToDoModel implements Parcelable {
    private String title;
    private Date tanggal;
    private String notes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeLong(this.tanggal != null ? this.tanggal.getTime() : -1);
        dest.writeString(this.notes);
    }

    public ToDoModel() {
    }

    protected ToDoModel(Parcel in) {
        this.title = in.readString();
        long tmpTanggal = in.readLong();
        this.tanggal = tmpTanggal == -1 ? null : new Date(tmpTanggal);
        this.notes = in.readString();
    }

    public static final Parcelable.Creator<ToDoModel> CREATOR = new Parcelable.Creator<ToDoModel>() {
        @Override
        public ToDoModel createFromParcel(Parcel source) {
            return new ToDoModel(source);
        }

        @Override
        public ToDoModel[] newArray(int size) {
            return new ToDoModel[size];
        }
    };

    public ToDoModel(String title, Date tanggal, String notes) {
        this.title = title;
        this.tanggal = tanggal;
        this.notes = notes;
    }
}
