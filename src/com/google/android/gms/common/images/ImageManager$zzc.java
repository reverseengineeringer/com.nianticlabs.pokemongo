package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.internal.zzb;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

final class ImageManager$zzc
  implements Runnable
{
  private final Uri mUri;
  private final ParcelFileDescriptor zzadS;
  
  public ImageManager$zzc(ImageManager paramImageManager, Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    mUri = paramUri;
    zzadS = paramParcelFileDescriptor;
  }
  
  public void run()
  {
    zzb.zzcj("LoadBitmapFromDiskRunnable can't be executed in the main thread");
    boolean bool1 = false;
    boolean bool2 = false;
    Bitmap localBitmap = null;
    CountDownLatch localCountDownLatch = null;
    if (zzadS != null) {}
    try
    {
      localBitmap = BitmapFactory.decodeFileDescriptor(zzadS.getFileDescriptor());
      bool1 = bool2;
      Object localObject;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        for (;;)
        {
          zzadS.close();
          localCountDownLatch = new CountDownLatch(1);
          ImageManager.zzg(zzadR).post(new ImageManager.zzf(zzadR, mUri, localBitmap, bool1, localCountDownLatch));
          try
          {
            localCountDownLatch.await();
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.w("ImageManager", "Latch interrupted while posting " + mUri);
          }
          localOutOfMemoryError = localOutOfMemoryError;
          Log.e("ImageManager", "OOM while loading bitmap for uri: " + mUri, localOutOfMemoryError);
          bool1 = true;
          localObject = localCountDownLatch;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("ImageManager", "closed failed", localIOException);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */