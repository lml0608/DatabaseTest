package com.android.examole.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by lfs-ios on 2017/2/5.
 */

public class MydatabaseHelper extends SQLiteOpenHelper {

    //建表语句
    private static final String CREATE_BOOK = "create table Book ("
            + "id integer primary key autoincrement,"
            + "author text,"
            + "price real,"
            + "pages integer,"
            + "name text)";


    private static final String CREATE_CATEGORY = "create table Category ("
            + "id integer primary key autoincrement,"
            + "category_name text,"
            + "category_code integer)";

    private Context mContext;

    //fule构造方法  name是数据库名称 第三个参数是查询数据看返回的一个Cursor，一般传入nul，version是数据看版本号，用于对数据看升级
    public MydatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        mContext = context;
    }

    //重写父类的2个抽象方法
    @Override
    public void onCreate(SQLiteDatabase db) {
        //执行建表语句
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        //Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    //升级数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");

        onCreate(db);

    }
}
