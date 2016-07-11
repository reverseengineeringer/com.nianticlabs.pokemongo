package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzg.zza;

public final class SignInButton
  extends FrameLayout
  implements View.OnClickListener
{
  public static final int COLOR_DARK = 0;
  public static final int COLOR_LIGHT = 1;
  public static final int SIZE_ICON_ONLY = 2;
  public static final int SIZE_STANDARD = 0;
  public static final int SIZE_WIDE = 1;
  private int mColor;
  private int mSize;
  private View zzaat;
  private View.OnClickListener zzaau = null;
  
  public SignInButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setStyle(0, 0);
  }
  
  private static Button zza(Context paramContext, int paramInt1, int paramInt2)
  {
    zzab localzzab = new zzab(paramContext);
    localzzab.zza(paramContext.getResources(), paramInt1, paramInt2);
    return localzzab;
  }
  
  private void zzai(Context paramContext)
  {
    if (zzaat != null) {
      removeView(zzaat);
    }
    try
    {
      zzaat = zzaa.zzb(paramContext, mSize, mColor);
      addView(zzaat);
      zzaat.setEnabled(isEnabled());
      zzaat.setOnClickListener(this);
      return;
    }
    catch (zzg.zza localzza)
    {
      for (;;)
      {
        Log.w("SignInButton", "Sign in button not found, using placeholder instead");
        zzaat = zza(paramContext, mSize, mColor);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((zzaau != null) && (paramView == zzaat)) {
      zzaau.onClick(this);
    }
  }
  
  public void setColorScheme(int paramInt)
  {
    setStyle(mSize, paramInt);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    zzaat.setEnabled(paramBoolean);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    zzaau = paramOnClickListener;
    if (zzaat != null) {
      zzaat.setOnClickListener(this);
    }
  }
  
  public void setSize(int paramInt)
  {
    setStyle(paramInt, mColor);
  }
  
  public void setStyle(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < 3))
    {
      bool = true;
      zzx.zza(bool, "Unknown button size %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt2 < 0) || (paramInt2 >= 2)) {
        break label80;
      }
    }
    label80:
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Unknown color scheme %s", new Object[] { Integer.valueOf(paramInt2) });
      mSize = paramInt1;
      mColor = paramInt2;
      zzai(getContext());
      return;
      bool = false;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.SignInButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */