package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.google.android.gms.common.internal.zzb;
import java.util.HashSet;
import java.util.Map;

final class ImageManager$zzd
  implements Runnable
{
  private final zza zzadT;
  
  public ImageManager$zzd(ImageManager paramImageManager, zza paramzza)
  {
    zzadT = paramzza;
  }
  
  public void run()
  {
    zzb.zzci("LoadImageRunnable must be executed on the main thread");
    Object localObject1 = (ImageManager.ImageReceiver)ImageManager.zza(zzadR).get(zzadT);
    if (localObject1 != null)
    {
      ImageManager.zza(zzadR).remove(zzadT);
      ((ImageManager.ImageReceiver)localObject1).zzc(zzadT);
    }
    zza.zza localzza = zzadT.zzadV;
    if (uri == null)
    {
      zzadT.zza(ImageManager.zzb(zzadR), ImageManager.zzc(zzadR), true);
      return;
    }
    localObject1 = ImageManager.zza(zzadR, localzza);
    if (localObject1 != null)
    {
      zzadT.zza(ImageManager.zzb(zzadR), (Bitmap)localObject1, true);
      return;
    }
    localObject1 = (Long)ImageManager.zzd(zzadR).get(uri);
    if (localObject1 != null)
    {
      if (SystemClock.elapsedRealtime() - ((Long)localObject1).longValue() < 3600000L)
      {
        zzadT.zza(ImageManager.zzb(zzadR), ImageManager.zzc(zzadR), true);
        return;
      }
      ImageManager.zzd(zzadR).remove(uri);
    }
    zzadT.zza(ImageManager.zzb(zzadR), ImageManager.zzc(zzadR));
    ??? = (ImageManager.ImageReceiver)ImageManager.zze(zzadR).get(uri);
    localObject1 = ???;
    if (??? == null)
    {
      localObject1 = new ImageManager.ImageReceiver(zzadR, uri);
      ImageManager.zze(zzadR).put(uri, localObject1);
    }
    ((ImageManager.ImageReceiver)localObject1).zzb(zzadT);
    if (!(zzadT instanceof zza.zzc)) {
      ImageManager.zza(zzadR).put(zzadT, localObject1);
    }
    synchronized (ImageManager.zzoC())
    {
      if (!ImageManager.zzoD().contains(uri))
      {
        ImageManager.zzoD().add(uri);
        ((ImageManager.ImageReceiver)localObject1).zzoE();
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */