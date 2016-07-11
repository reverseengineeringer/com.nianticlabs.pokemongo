package com.upsight.android.internal.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

final class SQLiteDataHelper$DatabaseHelper
  extends SQLiteOpenHelper
{
  public SQLiteDataHelper$DatabaseHelper(Context paramContext)
  {
    super(paramContext, "upsight.db", null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE models (_id TEXT PRIMARY KEY NOT NULL, type TEXT NOT NULL, data TEXT NOT NULL  );");
    paramSQLiteDatabase.execSQL("CREATE INDEX ID_INDEX ON models (_id);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS models");
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.SQLiteDataHelper.DatabaseHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */