package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class zzib$1
  extends zzib.zza
{
  zzib$1(Context paramContext, boolean paramBoolean)
  {
    super(null);
  }
  
  public void zzbn()
  {
    SharedPreferences.Editor localEditor = zzib.zzG(zzry).edit();
    localEditor.putBoolean("use_https", zzIo);
    localEditor.apply();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzib.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */