package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class zzib$3
  extends zzib.zza
{
  zzib$3(Context paramContext, int paramInt)
  {
    super(null);
  }
  
  public void zzbn()
  {
    SharedPreferences.Editor localEditor = zzib.zzG(zzry).edit();
    localEditor.putInt("webview_cache_version", zzIq);
    localEditor.apply();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzib.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */