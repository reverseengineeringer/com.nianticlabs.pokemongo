package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchase;

@zzgr
public class zzga
  implements InAppPurchase
{
  private final zzfr zzCM;
  
  public zzga(zzfr paramzzfr)
  {
    zzCM = paramzzfr;
  }
  
  public String getProductId()
  {
    try
    {
      String str = zzCM.getProductId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward getProductId to InAppPurchase", localRemoteException);
    }
    return null;
  }
  
  public void recordPlayBillingResolution(int paramInt)
  {
    try
    {
      zzCM.recordPlayBillingResolution(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward recordPlayBillingResolution to InAppPurchase", localRemoteException);
    }
  }
  
  public void recordResolution(int paramInt)
  {
    try
    {
      zzCM.recordResolution(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward recordResolution to InAppPurchase", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzga
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */