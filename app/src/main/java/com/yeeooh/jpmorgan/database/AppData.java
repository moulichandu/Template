package com.yeeooh.jpmorgan.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.yeeooh.jpmorgan.models.User;

/**
 * Created by Employee on 8/2/2018.
 */

public class AppData extends SQLiteOpenHelper {

    private static final String NAME="Socea";
    private static final int VERSION=1;

    private final String USER_TABLE="user";
    private final String CREATE_USER_TABLE="create table user (id text,name text, email text, mobile text,token text)";

    SQLiteDatabase db;
    public AppData(Context context) {
        super(context, NAME, null, VERSION);
    }

    public void openDatabase()
    {
        db=getWritableDatabase();
    }
    public void cloaseDb()
    {
        if(db!=null)
            db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertUser(User user)
    {
        ContentValues values=new ContentValues();
        values.put("id",user.id);
        values.put("name",user.name);
        values.put("email",user.email);
        values.put("mobile",user.mobile);
        values.put("token",user.token);
        openDatabase();
        db.insert(USER_TABLE,null,values);
        cloaseDb();
    }

    public User getUser()
    {
        openDatabase();
        Cursor c=db.rawQuery("select * from "+USER_TABLE,null);
        if(c.getCount()>0)
        {
            c.moveToNext();
            User user=new User();
            user.id=c.getString(c.getColumnIndex("id"));
            user.name=c.getString(c.getColumnIndex("name"));
            user.email=c.getString(c.getColumnIndex("email"));
            user.mobile=c.getString(c.getColumnIndex("mobile"));
            user.token=c.getString(c.getColumnIndex("token"));
            c.close();
            return user;
        }
        c.close();
        cloaseDb();
        return null;
    }
}
