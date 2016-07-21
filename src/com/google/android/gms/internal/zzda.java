package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.formats.zzj;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

public class zzda
  extends zzg<zzcp>
{
  public zzda()
  {
    super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
  }
  
  private zzco zzb(Context paramContext, FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    try
    {
      zzd localzzd = zze.zzy(paramContext);
      paramFrameLayout1 = zze.zzy(paramFrameLayout1);
      paramFrameLayout2 = zze.zzy(paramFrameLayout2);
      paramContext = zzco.zza.zzu(((zzcp)zzas(paramContext)).zza(localzzd, paramFrameLayout1, paramFrameLayout2, 8115000));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      zzb.zzd("Could not create remote NativeAdViewDelegate.", paramContext);
      return null;
    }
    catch (zzg.zza paramContext)
    {
      for (;;) {}
    }
  }
  
  protected zzcp zzD(IBinder paramIBinder)
  {
    return zzcp.zza.zzv(paramIBinder);
  }
  
  public zzco zza(Context paramContext, FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    if (zzl.zzcF().zzR(paramContext))
    {
      zzco localzzco = zzb(paramContext, paramFrameLayout1, paramFrameLayout2);
      paramContext = localzzco;
      if (localzzco != null) {}
    }
    else
    {
      zzb.zzaF("Using NativeAdViewDelegate from the client jar.");
      paramContext = new zzj(paramFrameLayout1, paramFrameLayout2);
    }
    return paramContext;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzda
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */