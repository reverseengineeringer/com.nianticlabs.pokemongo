package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.os.CancellationSignal;

abstract interface ContentResolverCompat$ContentResolverCompatImpl
{
  public abstract Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, CancellationSignal paramCancellationSignal);
}

/* Location:
 * Qualified Name:     android.support.v4.content.ContentResolverCompat.ContentResolverCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */