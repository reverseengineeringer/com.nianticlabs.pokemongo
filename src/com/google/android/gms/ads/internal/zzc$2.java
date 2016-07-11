package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzcj;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziz;

class zzc$2
  implements Runnable
{
  zzc$2(zzc paramzzc, zzhs.zza paramzza, zzcg paramzzcg) {}
  
  public void run()
  {
    if ((zzoB.zzHD.zzET) && (zzoC.zzot.zzqC != null))
    {
      Object localObject = null;
      if (zzoB.zzHD.zzBF != null) {
        localObject = zzp.zzbv().zzaz(zzoB.zzHD.zzBF);
      }
      localObject = new zzch(zzoC, (String)localObject, zzoB.zzHD.body);
      zzoC.zzot.zzqH = 1;
      try
      {
        zzoC.zzot.zzqC.zza((zzcj)localObject);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        zzb.zzd("Could not call the onCustomRenderedAdLoadedListener.", localRemoteException);
      }
    }
    final zze localzze = new zze();
    zziz localzziz = zzoC.zza(zzoB, localzze);
    localzze.zza(new zze.zzb(zzoB, localzziz));
    localzziz.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        localzze.recordClick();
        return false;
      }
    });
    localzziz.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localzze.recordClick();
      }
    });
    zzoC.zzot.zzqH = 0;
    zzoC.zzot.zzqm = zzp.zzbu().zza(zzoC.zzot.context, zzoC, zzoB, zzoC.zzot.zzqi, localzziz, zzoC.zzox, zzoC, zzoD);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzc.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */