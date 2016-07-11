package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzfv.zza;
import com.google.android.gms.internal.zzgr;

@zzgr
public final class zzg
  extends zzfv.zza
  implements ServiceConnection
{
  private Context mContext;
  zzb zzCD;
  private String zzCJ;
  private zzf zzCN;
  private boolean zzCT = false;
  private int zzCU;
  private Intent zzCV;
  
  public zzg(Context paramContext, String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, zzf paramzzf)
  {
    zzCJ = paramString;
    zzCU = paramInt;
    zzCV = paramIntent;
    zzCT = paramBoolean;
    mContext = paramContext;
    zzCN = paramzzf;
  }
  
  public void finishPurchase()
  {
    int i = zzp.zzbF().zzd(zzCV);
    if ((zzCU != -1) || (i != 0)) {
      return;
    }
    zzCD = new zzb(mContext);
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    com.google.android.gms.common.stats.zzb.zzqh().zza(mContext, localIntent, this, 1);
  }
  
  public String getProductId()
  {
    return zzCJ;
  }
  
  public Intent getPurchaseData()
  {
    return zzCV;
  }
  
  public int getResultCode()
  {
    return zzCU;
  }
  
  public boolean isVerified()
  {
    return zzCT;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaG("In-app billing service connected.");
    zzCD.zzN(paramIBinder);
    paramComponentName = zzp.zzbF().zze(zzCV);
    paramComponentName = zzp.zzbF().zzap(paramComponentName);
    if (paramComponentName == null) {
      return;
    }
    if (zzCD.zzi(mContext.getPackageName(), paramComponentName) == 0) {
      zzh.zzw(mContext).zza(zzCN);
    }
    com.google.android.gms.common.stats.zzb.zzqh().zza(mContext, this);
    zzCD.destroy();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaG("In-app billing service disconnected.");
    zzCD.destroy();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */