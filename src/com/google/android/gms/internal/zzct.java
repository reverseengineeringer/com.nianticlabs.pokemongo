package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzgr
public class zzct
  extends NativeContentAd
{
  private final List<NativeAd.Image> zzxe = new ArrayList();
  private final zzcs zzxg;
  private final zzcn zzxh;
  
  public zzct(zzcs paramzzcs)
  {
    zzxg = paramzzcs;
    try
    {
      paramzzcs = zzxg.getImages().iterator();
      while (paramzzcs.hasNext())
      {
        zzcm localzzcm = zzd(paramzzcs.next());
        if (localzzcm != null) {
          zzxe.add(new zzcn(localzzcm));
        }
      }
      try
      {
        paramzzcs = zzxg.zzdA();
        if (paramzzcs == null) {
          break label123;
        }
        paramzzcs = new zzcn(paramzzcs);
      }
      catch (RemoteException paramzzcs)
      {
        for (;;)
        {
          zzb.zzb("Failed to get icon.", paramzzcs);
          paramzzcs = null;
        }
      }
    }
    catch (RemoteException paramzzcs)
    {
      zzb.zzb("Failed to get image.", paramzzcs);
    }
    zzxh = paramzzcs;
  }
  
  public CharSequence getAdvertiser()
  {
    try
    {
      String str = zzxg.getAdvertiser();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get attribution.", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getBody()
  {
    try
    {
      String str = zzxg.getBody();
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
      String str = zzxg.getCallToAction();
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
      Bundle localBundle = zzxg.getExtras();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Failed to get extras", localRemoteException);
    }
    return null;
  }
  
  public CharSequence getHeadline()
  {
    try
    {
      String str = zzxg.getHeadline();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to get headline.", localRemoteException);
    }
    return null;
  }
  
  public List<NativeAd.Image> getImages()
  {
    return zzxe;
  }
  
  public NativeAd.Image getLogo()
  {
    return zzxh;
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
      zzd localzzd = zzxg.zzdx();
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
 * Qualified Name:     com.google.android.gms.internal.zzct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */