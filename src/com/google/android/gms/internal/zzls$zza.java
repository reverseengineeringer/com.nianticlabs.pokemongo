package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class zzls$zza
  extends Drawable
{
  private static final zza zzaeu = new zza();
  private static final zza zzaev = new zza(null);
  
  public void draw(Canvas paramCanvas) {}
  
  public Drawable.ConstantState getConstantState()
  {
    return zzaev;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  private static final class zza
    extends Drawable.ConstantState
  {
    public int getChangingConfigurations()
    {
      return 0;
    }
    
    public Drawable newDrawable()
    {
      return zzls.zza.zzoG();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzls.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */