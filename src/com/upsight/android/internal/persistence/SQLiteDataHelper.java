package com.upsight.android.internal.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class SQLiteDataHelper
  implements DataHelper
{
  private static final String DATABASE_NAME = "upsight.db";
  private static final int DATABASE_VERSION = 1;
  private static final String TABLE_MODELS = "models";
  private SQLiteOpenHelper mOpenHelper;
  
  SQLiteDataHelper(Context paramContext)
  {
    mOpenHelper = new DatabaseHelper(paramContext);
  }
  
  public int delete(String paramString, String[] paramArrayOfString)
  {
    return mOpenHelper.getWritableDatabase().delete("models", paramString, paramArrayOfString);
  }
  
  public long insert(ContentValues paramContentValues)
  {
    return mOpenHelper.getWritableDatabase().insert("models", null, paramContentValues);
  }
  
  public Cursor query(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return mOpenHelper.getReadableDatabase().query("models", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
  }
  
  public int update(ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return mOpenHelper.getWritableDatabase().update("models", paramContentValues, paramString, paramArrayOfString);
  }
  
  private static final class DatabaseHelper
    extends SQLiteOpenHelper
  {
    public DatabaseHelper(Context paramContext)
    {
      super("upsight.db", null, 1);
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
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.SQLiteDataHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */