package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Map;

@zzgr
public final class zzel
  extends zzem.zza
{
  private Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> zzzH;
  
  private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> zzen zzag(String paramString)
    throws RemoteException
  {
    try
    {
      Object localObject = Class.forName(paramString, false, zzel.class.getClassLoader());
      if (com.google.ads.mediation.MediationAdapter.class.isAssignableFrom((Class)localObject))
      {
        localObject = (com.google.ads.mediation.MediationAdapter)((Class)localObject).newInstance();
        return new zzey((com.google.ads.mediation.MediationAdapter)localObject, (com.google.ads.mediation.NetworkExtras)zzzH.get(((com.google.ads.mediation.MediationAdapter)localObject).getAdditionalParametersType()));
      }
      if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom((Class)localObject)) {
        return new zzet((com.google.android.gms.ads.mediation.MediationAdapter)((Class)localObject).newInstance());
      }
      zzb.zzaH("Could not instantiate mediation adapter: " + paramString + " (not a valid adapter).");
      throw new RemoteException();
    }
    catch (Throwable localThrowable)
    {
      zzb.zzaH("Could not instantiate mediation adapter: " + paramString + ". " + localThrowable.getMessage());
      throw new RemoteException();
    }
  }
  
  public zzen zzae(String paramString)
    throws RemoteException
  {
    return zzag(paramString);
  }
  
  public boolean zzaf(String paramString)
    throws RemoteException
  {
    try
    {
      boolean bool = CustomEvent.class.isAssignableFrom(Class.forName(paramString, false, zzel.class.getClassLoader()));
      return bool;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzaH("Could not load custom event implementation class: " + paramString + ", assuming old implementation.");
    }
    return false;
  }
  
  public void zze(Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> paramMap)
  {
    zzzH = paramMap;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */