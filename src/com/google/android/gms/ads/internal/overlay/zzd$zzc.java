package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zziz;

@zzgr
public class zzd$zzc
{
  public final Context context;
  public final int index;
  public final ViewGroup.LayoutParams zzBw;
  public final ViewGroup zzBx;
  
  public zzd$zzc(zziz paramzziz)
    throws zzd.zza
  {
    zzBw = paramzziz.getLayoutParams();
    ViewParent localViewParent = paramzziz.getParent();
    context = paramzziz.zzha();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
    {
      zzBx = ((ViewGroup)localViewParent);
      index = zzBx.indexOfChild(paramzziz.getView());
      zzBx.removeView(paramzziz.getView());
      paramzziz.zzC(true);
      return;
    }
    throw new zzd.zza("Could not get the parent of the WebView for an overlay.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzd.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */