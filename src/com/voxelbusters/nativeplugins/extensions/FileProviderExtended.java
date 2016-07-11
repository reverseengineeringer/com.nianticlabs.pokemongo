package com.voxelbusters.nativeplugins.extensions;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import java.util.Arrays;

public class FileProviderExtended
  extends FileProvider
{
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramArrayOfString2 = super.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    paramString1 = paramArrayOfString2.getColumnNames();
    paramUri = null;
    int j = paramString1.length;
    int i = 0;
    if (i >= j)
    {
      paramArrayOfString1 = paramUri;
      if (paramUri == null)
      {
        paramArrayOfString1 = (String[])Arrays.copyOf(paramString1, paramString1.length + 1);
        paramArrayOfString1[paramString1.length] = "_data";
      }
      paramUri = new MatrixCursor(paramArrayOfString1, paramArrayOfString2.getCount());
      paramArrayOfString2.moveToPosition(-1);
    }
    for (;;)
    {
      if (!paramArrayOfString2.moveToNext())
      {
        return paramUri;
        if ("_data".equals(paramString1[i])) {
          paramUri = paramString1;
        }
        i += 1;
        break;
      }
      paramArrayOfString1 = paramUri.newRow();
      i = 0;
      while (i < paramString1.length)
      {
        paramArrayOfString1.add(paramArrayOfString2.getString(i));
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.extensions.FileProviderExtended
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */