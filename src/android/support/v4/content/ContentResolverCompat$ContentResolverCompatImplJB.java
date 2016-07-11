package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.os.CancellationSignal;
import android.support.v4.os.OperationCanceledException;

class ContentResolverCompat$ContentResolverCompatImplJB
  extends ContentResolverCompat.ContentResolverCompatImplBase
{
  public Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null) {}
    for (;;)
    {
      try
      {
        paramCancellationSignal = paramCancellationSignal.getCancellationSignalObject();
        paramContentResolver = ContentResolverCompatJellybean.query(paramContentResolver, paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramCancellationSignal);
        return paramContentResolver;
      }
      catch (Exception paramContentResolver)
      {
        if (!ContentResolverCompatJellybean.isFrameworkOperationCanceledException(paramContentResolver)) {
          continue;
        }
        throw new OperationCanceledException();
        throw paramContentResolver;
      }
      paramCancellationSignal = null;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.ContentResolverCompat.ContentResolverCompatImplJB
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */