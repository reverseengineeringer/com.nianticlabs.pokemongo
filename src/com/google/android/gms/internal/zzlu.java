package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class zzlu
  extends ImageView
{
  private int zzaeA;
  private zza zzaeB;
  private int zzaeC;
  private float zzaeD;
  private Uri zzaey;
  private int zzaez;
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (zzaeB != null) {
      paramCanvas.clipPath(zzaeB.zzk(getWidth(), getHeight()));
    }
    super.onDraw(paramCanvas);
    if (zzaeA != 0) {
      paramCanvas.drawColor(zzaeA);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    switch (zzaeC)
    {
    default: 
      return;
    case 1: 
      paramInt1 = getMeasuredHeight();
      paramInt2 = (int)(paramInt1 * zzaeD);
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt2 = getMeasuredWidth();
      paramInt1 = (int)(paramInt2 / zzaeD);
    }
  }
  
  public void zzbA(int paramInt)
  {
    zzaez = paramInt;
  }
  
  public void zzj(Uri paramUri)
  {
    zzaey = paramUri;
  }
  
  public int zzoH()
  {
    return zzaez;
  }
  
  public static abstract interface zza
  {
    public abstract Path zzk(int paramInt1, int paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */