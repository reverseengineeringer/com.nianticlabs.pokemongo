package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class zzls
  extends Drawable
  implements Drawable.Callback
{
  private int mFrom;
  private long zzNY;
  private boolean zzaea = true;
  private int zzaeh = 0;
  private int zzaei;
  private int zzaej = 255;
  private int zzaek;
  private int zzael = 0;
  private boolean zzaem;
  private zzb zzaen;
  private Drawable zzaeo;
  private Drawable zzaep;
  private boolean zzaeq;
  private boolean zzaer;
  private boolean zzaes;
  private int zzaet;
  
  public zzls(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    Object localObject = paramDrawable1;
    if (paramDrawable1 == null) {
      localObject = zza.zzoG();
    }
    zzaeo = ((Drawable)localObject);
    ((Drawable)localObject).setCallback(this);
    paramDrawable1 = zzaen;
    zzaex |= ((Drawable)localObject).getChangingConfigurations();
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = zza.zzoG();
    }
    zzaep = paramDrawable1;
    paramDrawable1.setCallback(this);
    paramDrawable2 = zzaen;
    zzaex |= paramDrawable1.getChangingConfigurations();
  }
  
  zzls(zzb paramzzb)
  {
    zzaen = new zzb(paramzzb);
  }
  
  public boolean canConstantState()
  {
    if (!zzaeq) {
      if ((zzaeo.getConstantState() == null) || (zzaep.getConstantState() == null)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      zzaer = bool;
      zzaeq = true;
      return zzaer;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    int k = 0;
    switch (zzaeh)
    {
    }
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    do
    {
      for (;;)
      {
        j = zzael;
        bool = zzaea;
        localDrawable1 = zzaeo;
        localDrawable2 = zzaep;
        if (i == 0) {
          break;
        }
        if ((!bool) || (j == 0)) {
          localDrawable1.draw(paramCanvas);
        }
        if (j == zzaej)
        {
          localDrawable2.setAlpha(zzaej);
          localDrawable2.draw(paramCanvas);
        }
        return;
        zzNY = SystemClock.uptimeMillis();
        zzaeh = 2;
        i = k;
      }
    } while (zzNY < 0L);
    float f1 = (float)(SystemClock.uptimeMillis() - zzNY) / zzaek;
    if (f1 >= 1.0F) {}
    for (i = j;; i = 0)
    {
      if (i != 0) {
        zzaeh = 0;
      }
      f1 = Math.min(f1, 1.0F);
      float f2 = mFrom;
      zzael = ((int)(f1 * (zzaei - mFrom) + f2));
      break;
    }
    if (bool) {
      localDrawable1.setAlpha(zzaej - j);
    }
    localDrawable1.draw(paramCanvas);
    if (bool) {
      localDrawable1.setAlpha(zzaej);
    }
    if (j > 0)
    {
      localDrawable2.setAlpha(j);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(zzaej);
    }
    invalidateSelf();
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | zzaen.zzaew | zzaen.zzaex;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (canConstantState())
    {
      zzaen.zzaew = getChangingConfigurations();
      return zzaen;
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    return Math.max(zzaeo.getIntrinsicHeight(), zzaep.getIntrinsicHeight());
  }
  
  public int getIntrinsicWidth()
  {
    return Math.max(zzaeo.getIntrinsicWidth(), zzaep.getIntrinsicWidth());
  }
  
  public int getOpacity()
  {
    if (!zzaes)
    {
      zzaet = Drawable.resolveOpacity(zzaeo.getOpacity(), zzaep.getOpacity());
      zzaes = true;
    }
    return zzaet;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (zzmx.zzqu())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.invalidateDrawable(this);
      }
    }
  }
  
  public Drawable mutate()
  {
    if ((!zzaem) && (super.mutate() == this))
    {
      if (!canConstantState()) {
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      }
      zzaeo.mutate();
      zzaep.mutate();
      zzaem = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    zzaeo.setBounds(paramRect);
    zzaep.setBounds(paramRect);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (zzmx.zzqu())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (zzael == zzaej) {
      zzael = paramInt;
    }
    zzaej = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    zzaeo.setColorFilter(paramColorFilter);
    zzaep.setColorFilter(paramColorFilter);
  }
  
  public void startTransition(int paramInt)
  {
    mFrom = 0;
    zzaei = zzaej;
    zzael = 0;
    zzaek = paramInt;
    zzaeh = 1;
    invalidateSelf();
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (zzmx.zzqu())
    {
      paramDrawable = getCallback();
      if (paramDrawable != null) {
        paramDrawable.unscheduleDrawable(this, paramRunnable);
      }
    }
  }
  
  public Drawable zzoF()
  {
    return zzaep;
  }
  
  private static final class zza
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
  
  static final class zzb
    extends Drawable.ConstantState
  {
    int zzaew;
    int zzaex;
    
    zzb(zzb paramzzb)
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzls
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */