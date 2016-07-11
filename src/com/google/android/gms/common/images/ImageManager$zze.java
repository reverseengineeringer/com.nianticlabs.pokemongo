package com.google.android.gms.common.images;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

final class ImageManager$zze
  implements ComponentCallbacks2
{
  private final ImageManager.zzb zzadL;
  
  public ImageManager$zze(ImageManager.zzb paramzzb)
  {
    zzadL = paramzzb;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    zzadL.evictAll();
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (paramInt >= 60) {
      zzadL.evictAll();
    }
    while (paramInt < 20) {
      return;
    }
    zzadL.trimToSize(zzadL.size() / 2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */