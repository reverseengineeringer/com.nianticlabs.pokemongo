package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

class zza$4
  implements zza.zza
{
  zza$4(zza paramzza, FrameLayout paramFrameLayout, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {}
  
  public int getState()
  {
    return 2;
  }
  
  public void zzb(LifecycleDelegate paramLifecycleDelegate)
  {
    zzapv.removeAllViews();
    zzapv.addView(zza.zzb(zzapr).onCreateView(zzapw, zzapx, zzapu));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.dynamic.zza.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */