package com.upsight.android.internal.persistence;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

public final class ContentProvider
  extends android.content.ContentProvider
{
  private static final int MODEL = 2;
  private static final int MODEL_ALL = 3;
  private static final int MODEL_ITEM = 1;
  private static final String TYPE_SELECTION = "type = ?";
  private static UriMatcher sMatcher;
  private DataHelper mDataHelper;
  
  private static String updatedSelection(String paramString1, String paramString2)
  {
    String str = "_id = '" + paramString2 + "'";
    paramString2 = str;
    if (paramString1 != null) {
      paramString2 = str + " AND " + paramString1;
    }
    return paramString2;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    switch (sMatcher.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Uri not supported by insert:" + paramUri);
    }
    paramString = updatedSelection(paramString, paramUri.getLastPathSegment());
    int i = mDataHelper.delete(paramString, paramArrayOfString);
    if (i > 0) {
      getContext().getContentResolver().notifyChange(paramUri, null);
    }
    return i;
  }
  
  public String getType(Uri paramUri)
  {
    String str = null;
    switch (sMatcher.match(paramUri))
    {
    default: 
      paramUri = str;
    }
    Object localObject;
    do
    {
      do
      {
        return paramUri;
        str = "vnd.android.cursor.item/vnd.com.upsight.model";
        localObject = paramUri.getPathSegments();
        if (((List)localObject).size() < 3) {
          throw new IllegalArgumentException("Unexpected content uri: " + paramUri);
        }
        paramUri = str;
      } while (TextUtils.isEmpty((String)((List)localObject).get(1)));
      return "vnd.android.cursor.item/vnd.com.upsight.model" + "." + (String)((List)localObject).get(1);
      str = "vnd.android.cursor.dir/vnd.com.upsight.model";
      localObject = paramUri.getLastPathSegment();
      paramUri = str;
    } while ("model".equals(localObject));
    return "vnd.android.cursor.dir/vnd.com.upsight.model" + "." + (String)localObject;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    switch (sMatcher.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Uri not supported by insert:" + paramUri);
    }
    if (TextUtils.isEmpty(paramContentValues.getAsString("type"))) {
      throw new IllegalArgumentException("ContentValues must have a model type");
    }
    if (0L > mDataHelper.insert(paramContentValues)) {
      throw new IllegalArgumentException("Failed to insert model for uri: " + paramUri);
    }
    paramUri = Uri.withAppendedPath(paramUri, paramContentValues.getAsString("_id"));
    getContext().getContentResolver().notifyChange(paramUri, null);
    return paramUri;
  }
  
  public boolean onCreate()
  {
    return onCreate(getContext());
  }
  
  public boolean onCreate(Context paramContext)
  {
    return onCreate(paramContext, new SQLiteDataHelper(paramContext));
  }
  
  public boolean onCreate(Context paramContext, DataHelper paramDataHelper)
  {
    mDataHelper = paramDataHelper;
    if (sMatcher == null)
    {
      sMatcher = new UriMatcher(-1);
      paramContext = Content.getAuthoritytUri(paramContext).getAuthority();
      sMatcher.addURI(paramContext, "model/*/*", 1);
      sMatcher.addURI(paramContext, "model/*", 2);
      sMatcher.addURI(paramContext, "model", 3);
    }
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    switch (sMatcher.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Uri not supported by query: " + paramUri);
    case 1: 
      paramUri = updatedSelection(paramString1, paramUri.getLastPathSegment());
      return mDataHelper.query(paramArrayOfString1, paramUri, paramArrayOfString2, paramString2);
    case 2: 
      paramUri = paramUri.getLastPathSegment();
      return mDataHelper.query(paramArrayOfString1, "type = ?", new String[] { paramUri }, paramString2);
    }
    return mDataHelper.query(paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    switch (sMatcher.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Uri not supported by update:" + paramUri);
    }
    paramString = updatedSelection(paramString, paramUri.getLastPathSegment());
    int i = mDataHelper.update(paramContentValues, paramString, paramArrayOfString);
    if (i > 0) {
      getContext().getContentResolver().notifyChange(paramUri, null);
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.ContentProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */