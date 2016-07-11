package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;

@zzgr
public class zzcn
  extends NativeAd.Image
{
  private final Drawable mDrawable;
  private final Uri mUri;
  private final double zzwn;
  private final zzcm zzxc;
  
  public zzcn(zzcm paramzzcm)
  {
    zzxc = paramzzcm;
    try
    {
      paramzzcm = zzxc.zzdv();
      if (paramzzcm == null) {
        break label83;
      }
      paramzzcm = (Drawable)zze.zzp(paramzzcm);
    }
    catch (RemoteException paramzzcm)
    {
      try
      {
        paramzzcm = zzxc.getUri();
        mUri = paramzzcm;
        double d1 = 1.0D;
        try
        {
          double d2 = zzxc.getScale();
          d1 = d2;
        }
        catch (RemoteException paramzzcm)
        {
          for (;;)
          {
            zzb.zzb("Failed to get scale.", paramzzcm);
          }
        }
        zzwn = d1;
        return;
        paramzzcm = paramzzcm;
        zzb.zzb("Failed to get drawable.", paramzzcm);
        paramzzcm = null;
      }
      catch (RemoteException paramzzcm)
      {
        for (;;)
        {
          zzb.zzb("Failed to get uri.", paramzzcm);
          paramzzcm = (zzcm)localObject;
        }
      }
    }
    mDrawable = paramzzcm;
  }
  
  public Drawable getDrawable()
  {
    return mDrawable;
  }
  
  public double getScale()
  {
    return zzwn;
  }
  
  public Uri getUri()
  {
    return mUri;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */