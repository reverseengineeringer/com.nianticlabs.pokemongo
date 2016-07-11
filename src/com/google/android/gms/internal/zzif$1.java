package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzp;

class zzif$1
  implements DialogInterface.OnClickListener
{
  zzif$1(zzif paramzzif, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    zzp.zzbv().zzb(zzif.zza(zzIN), Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", zzIM), "Share via"));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzif.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */