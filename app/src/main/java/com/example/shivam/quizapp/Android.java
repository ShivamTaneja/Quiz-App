package com.example.shivam.quizapp;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

import static android.content.ContentValues.TAG;

public class Android extends SQLiteOpenHelper {

    private static final String Database_path = "/data/data/com.example.shivam.quizapp/databases/";
    private static final String Database_name = "shivam.db";//NAME of database stored in Assets folder
    private static final String Table_name = "shivam";//name of table
    private static final String uid = "_id";//name of column1
    private static final String Question = "Question";//name of column2
    private static final String OptionA = "OptionA";//name of column3
    private static final String OptionB = "OptionB";//name of column4
    private static final String OptionC = "OptionC";//name of column5
    private static final String OptionD = "OptionD";//name of column6
    private static final String Answer = "Answer";//name of column7
    private static final int version = 2;//version of database signifies if there is any upgradation or not
    public SQLiteDatabase sqlite;//object of type SQLiteDatabase
    private Context context;//Context object to get context from Question Activity

    public Android(Context context) {//constructor
        super(context, Database_name, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //No code because we have already created the database
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > oldVersion)
            try{
                Log.e("Shivam", "5");
                copyDBfromResource();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

    }

    public void createDatabase() {
        createDB();
    }

    private void createDB() {

        boolean dbexist = DBexists();//calling the function to check db exists or not
        if (!dbexist)//if database doesnot exist
        {

            this.getReadableDatabase();//Create an empty file
            copyDBfromResource();//copy the database file information of assets folder to newly create file
        }
    }

    private void copyDBfromResource() {

        InputStream is;
        OutputStream os;
        String filePath = Database_path + Database_name;
        try {
            is = context.getAssets().open(Database_name);//reading purpose
            os = new FileOutputStream(filePath);//writing purpose
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);//writing to file
            }
            os.flush();//flush the outputstream
            is.close();//close the inputstream
            os.close();//close the outputstream

        } catch (IOException e) {
            throw new Error("Problem copying database file:");
        }
    }

    public void openDatabase() throws SQLException//called by onCreate method of Questions Activity
    {

        String myPath = Database_path + Database_name;
        sqlite = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    private boolean DBexists()//Check whether the db file exists or not
    {
        SQLiteDatabase db = null;
        try {
            String databasePath = Database_path + Database_name;
            db = SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.OPEN_READWRITE);
            db.setLocale(Locale.getDefault());
            db.setVersion(version);
            db.setLockingEnabled(true);
        } catch (SQLException e) {
            Log.e("Shivam", "Database not found");
        }
        if (db != null)
            db.close();///close the opened file
        return db != null ? true : false;

    }
// uppload to github,update resume,recharge
    public String readQuestion(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {

        String Ans = "";//string that contains the required field  note that Ans is just a local string not related to Answer or Option...
        Cursor c = sqlite.rawQuery("SELECT " + Question + " FROM " + Table_name + " WHERE " + uid + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        Log.e("Android", "readQuestion: "+Ans );
        return Ans;
    }

    public String readOptionA(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {
        String Ans = "";//string that contains the required field  note that Ans is just a local string not related to Answer or Option...
        Cursor c = sqlite.rawQuery("SELECT " + OptionA + " FROM " + Table_name + " WHERE " + uid + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        return Ans;
    }

    public String readOptionB(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {
        String Ans = "";//string that contains the required field  note that Ans is just a local string not related to Answer or Option...
        Cursor c = sqlite.rawQuery("SELECT " + OptionB + " FROM " + Table_name + " WHERE " + uid + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        return Ans;
    }

    public String readOptionC(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {
        String Ans = "";//string that contains the required field  note that Ans is just a local string not related to Answer or Option...
        Cursor c = sqlite.rawQuery("SELECT " + OptionC + " FROM " + Table_name + " WHERE " + uid + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        return Ans;
    }

    public String readOptionD(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {
        String Ans = "";//string that contains the required field  note that Ans is just a local string not related to Answer or Option...
        Cursor c = sqlite.rawQuery("SELECT " + OptionD + " FROM " + Table_name + " WHERE " + uid + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        return Ans;
    }

    public String readAnswer(int i)//Used to read the data from the Des.db file where id is given and we choose id randomly
    {

        String Ans = "";//string that contains the required field
        Cursor c = sqlite.rawQuery("SELECT " + Answer + " FROM " + Table_name + " WHERE " + uid + " = " + i + "", null);//cursor to that query
        if (c.moveToFirst())
            Ans = c.getString(0);
        else
            Ans = "";
        return Ans;
    }
}




