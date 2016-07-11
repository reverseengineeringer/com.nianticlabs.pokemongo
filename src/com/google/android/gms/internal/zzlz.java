package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zzlz
  implements zzly
{
  public PendingResult<Status> zzb(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zzma.zza(paramGoogleApiClient)
    {
      protected void zza(zzmb paramAnonymouszzmb)
        throws RemoteException
      {
        ((zzmd)paramAnonymouszzmb.zzpc()).zza(new zzlz.zza(this));
      }
    });
  }
  
  private static class zza
    extends zzlw
  {
    private final zzlb.zzb<Status> zzagy;
    
    public zza(zzlb.zzb<Status> paramzzb)
    {
      zzagy = paramzzb;
    }
    
    public void zzbN(int paramInt)
      throws RemoteException
    {
      zzagy.zzp(new Status(paramInt));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */