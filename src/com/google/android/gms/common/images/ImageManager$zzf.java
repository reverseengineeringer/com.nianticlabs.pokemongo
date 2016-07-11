package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.common.internal.zzb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class ImageManager$zzf
  implements Runnable
{
  private final Bitmap mBitmap;
  private final Uri mUri;
  private boolean zzadU;
  private final CountDownLatch zzoS;
  
  public ImageManager$zzf(ImageManager paramImageManager, Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
  {
    mUri = paramUri;
    mBitmap = paramBitmap;
    zzadU = paramBoolean;
    zzoS = paramCountDownLatch;
  }
  
  private void zza(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
  {
    paramImageReceiver = ImageManager.ImageReceiver.zza(paramImageReceiver);
    int j = paramImageReceiver.size();
    int i = 0;
    if (i < j)
    {
      zza localzza = (zza)paramImageReceiver.get(i);
      if (paramBoolean) {
        localzza.zza(ImageManager.zzb(zzadR), mBitmap, false);
      }
      for (;;)
      {
        if (!(localzza instanceof zza.zzc)) {
          ImageManager.zza(zzadR).remove(localzza);
        }
        i += 1;
        break;
        ImageManager.zzd(zzadR).put(mUri, Long.valueOf(SystemClock.elapsedRealtime()));
        localzza.zza(ImageManager.zzb(zzadR), ImageManager.zzc(zzadR), false);
      }
    }
  }
  
  public void run()
  {
    zzb.zzci("OnBitmapLoadedRunnable must be executed in the main thread");
    boolean bool;
    if (mBitmap != null) {
      bool = true;
    }
    while (ImageManager.zzh(zzadR) != null) {
      if (zzadU)
      {
        ImageManager.zzh(zzadR).evictAll();
        System.gc();
        zzadU = false;
        ImageManager.zzg(zzadR).post(this);
        return;
        bool = false;
      }
      else if (bool)
      {
        ImageManager.zzh(zzadR).put(new zza.zza(mUri), mBitmap);
      }
    }
    ??? = (ImageManager.ImageReceiver)ImageManager.zze(zzadR).remove(mUri);
    if (??? != null) {
      zza((ImageManager.ImageReceiver)???, bool);
    }
    zzoS.countDown();
    synchronized (ImageManager.zzoC())
    {
      ImageManager.zzoD().remove(mUri);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */