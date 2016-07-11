package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.google.android.gms.ads.internal.zzp;

class zzfb$1
  implements DialogInterface.OnClickListener
{
  zzfb$1(zzfb paramzzfb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = zzAa.createIntent();
    zzp.zzbv().zzb(zzfb.zza(zzAa), paramDialogInterface);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfb.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */