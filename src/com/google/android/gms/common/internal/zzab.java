package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.Button;
import com.google.android.gms.R.color;
import com.google.android.gms.R.drawable;
import com.google.android.gms.R.string;

public final class zzab
  extends Button
{
  public zzab(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public zzab(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 16842824);
  }
  
  private void zza(Resources paramResources)
  {
    setTypeface(Typeface.DEFAULT_BOLD);
    setTextSize(14.0F);
    float f = getDisplayMetricsdensity;
    setMinHeight((int)(f * 48.0F + 0.5F));
    setMinWidth((int)(f * 48.0F + 0.5F));
  }
  
  private void zzb(Resources paramResources, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException("Unknown button size: " + paramInt1);
    }
    for (paramInt1 = zzd(paramInt2, R.drawable.common_signin_btn_text_dark, R.drawable.common_signin_btn_text_light); paramInt1 == -1; paramInt1 = zzd(paramInt2, R.drawable.common_signin_btn_icon_dark, R.drawable.common_signin_btn_icon_light)) {
      throw new IllegalStateException("Could not find background resource!");
    }
    setBackgroundDrawable(paramResources.getDrawable(paramInt1));
  }
  
  private void zzc(Resources paramResources, int paramInt1, int paramInt2)
  {
    setTextColor(paramResources.getColorStateList(zzd(paramInt2, R.color.common_signin_btn_text_dark, R.color.common_signin_btn_text_light)));
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException("Unknown button size: " + paramInt1);
    case 0: 
      setText(paramResources.getString(R.string.common_signin_button_text));
      return;
    case 1: 
      setText(paramResources.getString(R.string.common_signin_button_text_long));
      return;
    }
    setText(null);
  }
  
  private int zzd(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException("Unknown color scheme: " + paramInt1);
    case 1: 
      paramInt2 = paramInt3;
    }
    return paramInt2;
  }
  
  public void zza(Resources paramResources, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < 3))
    {
      bool = true;
      zzx.zza(bool, "Unknown button size %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt2 < 0) || (paramInt2 >= 2)) {
        break label86;
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Unknown color scheme %s", new Object[] { Integer.valueOf(paramInt2) });
      zza(paramResources);
      zzb(paramResources, paramInt1, paramInt2);
      zzc(paramResources, paramInt1, paramInt2);
      return;
      bool = false;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzab
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */