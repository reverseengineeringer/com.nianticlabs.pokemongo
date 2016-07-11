package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.ads.internal.util.client.zzb;

public class zzh$zza
  extends SQLiteOpenHelper
{
  public zzh$zza(zzh paramzzh, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 4);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(zzh.zzfp());
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    zzb.zzaG("Database updated from version " + paramInt1 + " to version " + paramInt2);
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zzh.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */