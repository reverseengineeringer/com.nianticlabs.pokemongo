package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class zzls$zzb
  extends Drawable.ConstantState
{
  int zzaew;
  int zzaex;
  
  zzls$zzb(zzb paramzzb)
  {
    if (paramzzb != null)
    {
      zzaew = zzaew;
      zzaex = zzaex;
    }
  }
  
  public int getChangingConfigurations()
  {
    return zzaew;
  }
  
  public Drawable newDrawable()
  {
    return new zzls(this);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzls.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */