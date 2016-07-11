package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzgr
public class zzcr
  extends NativeAppInstallAd
{
  private final zzcq zzxd;
  private final List<NativeAd.Image> zzxe = new ArrayList();
  private final zzcn zzxf;
  
  public zzcr(zzcq paramzzcq)
  {
    zzxd = paramzzcq;
    try
    {
      paramzzcq = zzxd.getImages().iterator();
      while (paramzzcq.hasNext())
      {
        zzcm localzzcm = zzd(paramzzcq.next());
        if (localzzcm != null) {
          zzxe.add(new zzcn(localzzcm));
        }
      }
      try
      {
        paramzzcq = zzxd.zzdw();
        if (paramzzcq == null) {
          break label123;
        }
        paramzzcq = new zzcn(paramzzcq);
      }
      catch (RemoteException paramzzcq)
      {
        for (;;)
        {
          zzb.zzb("Failed to get icon.", paramzzcq);
          paramzzcq = null;
        }
      }
    }
    catch (RemoteException paramzzcq)
    {
      zzb.zzb("Failed to get image.", paramzzcq);
    }
    zzxf = paramzzcq;
  }
  
  public CharSequence getBody()
  {
    try
    {
      String str = zzxd.getBody();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get body.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getCallToAction()
  {
    try
    {
      String str = zzxd.getCallToAction();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get call to action.", localRemoteException);
    }
    return null;
  }
  
  public Bundle getExtras()
  {
    try
    {
      Bundle localBundle = zzxd.getExtras();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get extras", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getHeadline()
  {
    try
    {
      String str = zzxd.getHeadline();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get headline.", localRemoteException);
    }
    return null;
  }
  
  public NativeAd.Image getIcon()
  {
    return zzxf;
  }
  
  public List<NativeAd.Image> getImages()
  {
    return zzxe;
  }
  
  public CharSequence getPrice()
  {
    try
    {
      String str = zzxd.getPrice();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get price.", localRemoteException);
    }
    return null;
  }
  
  public Double getStarRating()
  {
    try
    {
      double d = zzxd.getStarRating();
      if (d == -1.0D) {
        return null;
      }
      return Double.valueOf(d);
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get star rating.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getStore()
  {
    try
    {
      String str = zzxd.getStore();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get store", localRemoteException);
    }
    return null;
  }
  
  zzcm zzd(Object paramObject)
  {
    if ((paramObject instanceof IBinder)) {
      return zzcm.zza.zzt((IBinder)paramObject);
    }
    return null;
  }
  
  protected zzd zzdx()
  {
    try
    {
      zzd localzzd = zzxd.zzdx();
      return localzzd;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to retrieve native ad engine.", localRemoteException);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */