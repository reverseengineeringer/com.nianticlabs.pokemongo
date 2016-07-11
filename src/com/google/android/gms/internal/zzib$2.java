package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

final class zzib$2
  extends zzib.zza
{
  zzib$2(Context paramContext, zzib.zzb paramzzb)
  {
    super(null);
  }
  
  public void zzbn()
  {
    SharedPreferences localSharedPreferences = zzib.zzG(zzry);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("use_https", localSharedPreferences.getBoolean("use_https", true));
    if (zzIp != null) {
      zzIp.zzd(localBundle);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzib.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */