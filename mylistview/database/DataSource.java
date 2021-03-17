package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.risha.mylistview.activity.Main3Activity;

import java.util.ArrayList;
import java.util.List;

import utils.Model;

/**
 * Created by risha on 29-Dec-17.
 */

public class DataSource {
    private static final String TAG=DataSource.class.getName();     //for LOG activities
    private static SQLiteDatabase database;
    private static DatabaseHelper dbHelper;
    private static DataSource dbSource;
    public DataSource(Context context){
        dbHelper=new DatabaseHelper(context);
    }
    public void close(){
        dbHelper.close();
        //to close the object
    }
    public void open() throws SQLException{
        //to modify the database
        database=dbHelper.getWritableDatabase();
    }
    public static DataSource getInstance(Context context){
        if (dbSource==null){
            dbSource=new DataSource(context);
            try {
                dbSource.open();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return dbSource;
    }

    public void insertIntoStudent(String userName,String email,String password){
        ContentValues newValues=new ContentValues();
        //assign values to columns
        newValues.put(DatabaseHelper.Student.ColumnName.NAME,userName);
        newValues.put(DatabaseHelper.Student.ColumnName.EMAIL,email);
        newValues.put(DatabaseHelper.Student.ColumnName.PASSWORD,password);

        //insert into table
      long m  =  database.insert(DatabaseHelper.Student.TABLE_NAME,null,newValues);

    }

    public List getAllData(){
        List<Model> modelList=new ArrayList<Model>();
        Cursor cursor=database.rawQuery("Select * from student",null);
        if(cursor!=null) {
            cursor.moveToFirst();
            //List<String> mList = new ArrayList<String>();


            /* for (/*int i = 0; i < cursor.getCount(); i++ )
            */
            modelList.clear();
            while (!cursor.isAfterLast()){
                //mList.add();
                Model model=new Model();
                model.setID(cursor.getInt(0));
                model.setNAME(cursor.getString(1));
                model.setEMAIL(cursor.getString(2));
                model.setIMAGE_PATH(cursor.getString(3));
                modelList.add(model);
                cursor.moveToNext();
                //Log.i("cursor.data","Message: "+model.getNAME()+model.getID());
            }
            return modelList;
        }
        return null;
    }

}
