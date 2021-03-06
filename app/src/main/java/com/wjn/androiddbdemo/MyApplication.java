package com.wjn.androiddbdemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.wjn.androiddbdemo.greendao.DaoMaster;
import com.wjn.androiddbdemo.greendao.DaoSession;
import com.wjn.androiddbdemo.utils.db.MyGitHubGreenDaoOpenHelper;
import com.wjn.androiddbdemo.utils.db.MyGreenDaoOpenHelper;

public class MyApplication extends Application {

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();
    }

    /**
     * 配置数据库
     */

    private void setupDatabase() {
        //创建数据库shop.db 创建SQLite数据库的SQLiteOpenHelper的具体实现
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "greendaodemo.db", null);
//        MyGreenDaoOpenHelper helper=new MyGreenDaoOpenHelper(this,"greendaodemo.db",null);
        MyGitHubGreenDaoOpenHelper helper=new MyGitHubGreenDaoOpenHelper(this,"greendaodemo.db",null);
        //获取SQLiteDatabase对象
        SQLiteDatabase db = helper.getReadableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取dao对象管理者
        daoSession = daoMaster.newSession();
    }

    /**
     * 获取 DaoSession 外部调用
     * */

    public static DaoSession getDaoInstant() {
        return daoSession;
    }

}
