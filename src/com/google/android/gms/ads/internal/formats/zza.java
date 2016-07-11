package com.google.android.gms.ads.internal.formats;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import java.util.List;

public class zza
{
  private static final int zzwa = Color.rgb(12, 174, 206);
  private static final int zzwb = Color.rgb(204, 204, 204);
  static final int zzwc = zzwb;
  static final int zzwd = zzwa;
  private final int mTextColor;
  private final String zzwe;
  private final List<Drawable> zzwf;
  private final int zzwg;
  private final int zzwh;
  private final int zzwi;
  
  public zza(String paramString, List<Drawable> paramList, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, int paramInt)
  {
    zzwe = paramString;
    zzwf = paramList;
    if (paramInteger1 != null)
    {
      i = paramInteger1.intValue();
      zzwg = i;
      if (paramInteger2 == null) {
        break label81;
      }
      i = paramInteger2.intValue();
      label42:
      mTextColor = i;
      if (paramInteger3 == null) {
        break label89;
      }
    }
    label81:
    label89:
    for (int i = paramInteger3.intValue();; i = 12)
    {
      zzwh = i;
      zzwi = paramInt;
      return;
      i = zzwc;
      break;
      i = zzwd;
      break label42;
    }
  }
  
  public int getBackgroundColor()
  {
    return zzwg;
  }
  
  public String getText()
  {
    return zzwe;
  }
  
  public int getTextColor()
  {
    return mTextColor;
  }
  
  public int getTextSize()
  {
    return zzwh;
  }
  
  public List<Drawable> zzds()
  {
    return zzwf;
  }
  
  public int zzdt()
  {
    return zzwi;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */