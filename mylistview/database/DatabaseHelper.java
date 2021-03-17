package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by risha on 29-Dec-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private final static int DATABASE_VERSION=1;
    private final static String DATABASE_NAME="college.db";
    //to initialize to execute query
    public static class Student{
        public static final String TABLE_NAME="Student";
        public static class ColumnName{
            public static final String ID="id";
            public static final String NAME="name";
            public static final String EMAIL="email";
            public static final String PASSWORD="password";
            public static final String IMAGE_PATH="image_path";

        }
    }
    private void initializeDb(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+Student.TABLE_NAME+"("+
                Student.ColumnName.ID+" integer ,"+
                Student.ColumnName.NAME+" varchar(50),"+
                Student.ColumnName.EMAIL+" text,"+      //test uses any length.
                Student.ColumnName.PASSWORD+" varchar(20), "+
                Student.ColumnName.IMAGE_PATH+" text"+")"
        );
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        initializeDb(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
