package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcm.zza;
import com.google.android.gms.internal.zzgr;

@zzgr
public class zzc
  extends zzcm.zza
{
  private final Uri mUri;
  private final Drawable zzwm;
  private final double zzwn;
  
  public zzc(Drawable paramDrawable, Uri paramUri, double paramDouble)
  {
    zzwm = paramDrawable;
    mUri = paramUri;
    zzwn = paramDouble;
  }
  
  public double getScale()
  {
    return zzwn;
  }
  
  public Uri getUri()
    throws RemoteException
  {
    return mUri;
  }
  
  public zzd zzdv()
    throws RemoteException
  {
    return zze.zzy(zzwm);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */