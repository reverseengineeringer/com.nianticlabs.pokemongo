package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class zzfe$1
  implements DialogInterface.OnClickListener
{
  zzfe$1(zzfe paramzzfe, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (DownloadManager)zzfe.zza(zzAu).getSystemService("download");
    try
    {
      paramDialogInterface.enqueue(zzAu.zzg(zzAs, zzAt));
      return;
    }
    catch (IllegalStateException paramDialogInterface)
    {
      zzAu.zzak("Could not store picture.");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfe.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */