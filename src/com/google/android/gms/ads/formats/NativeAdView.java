package com.google.android.gms.ads.formats;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzco;
import com.google.android.gms.internal.zzda;

public abstract class NativeAdView
  extends FrameLayout
{
  private final FrameLayout zznZ = zzm(paramContext);
  private final zzco zzoa = zzaI();
  
  public NativeAdView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NativeAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NativeAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public NativeAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private zzco zzaI()
  {
    zzx.zzb(zznZ, "createDelegate must be called after mOverlayFrame has been created");
    return zzl.zzcJ().zza(zznZ.getContext(), this, zznZ);
  }
  
  private FrameLayout zzm(Context paramContext)
  {
    paramContext = zzn(paramContext);
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addView(paramContext);
    return paramContext;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    super.bringChildToFront(zznZ);
  }
  
  public void bringChildToFront(View paramView)
  {
    super.bringChildToFront(paramView);
    if (zznZ != paramView) {
      super.bringChildToFront(zznZ);
    }
  }
  
  public void removeAllViews()
  {
    super.removeAllViews();
    super.addView(zznZ);
  }
  
  public void removeView(View paramView)
  {
    if (zznZ == paramView) {
      return;
    }
    super.removeView(paramView);
  }
  
  public void setNativeAd(NativeAd paramNativeAd)
  {
    try
    {
      zzoa.zzb((zzd)paramNativeAd.zzaH());
      return;
    }
    catch (RemoteException paramNativeAd)
    {
      zzb.zzb("Unable to call setNativeAd on delegate", paramNativeAd);
    }
  }
  
  protected void zza(String paramString, View paramView)
  {
    try
    {
      zzoa.zza(paramString, zze.zzy(paramView));
      return;
    }
    catch (RemoteException paramString)
    {
      zzb.zzb("Unable to call setAssetView on delegate", paramString);
    }
  }
  
  protected View zzm(String paramString)
  {
    try
    {
      paramString = zzoa.zzW(paramString);
      if (paramString != null)
      {
        paramString = (View)zze.zzp(paramString);
        return paramString;
      }
    }
    catch (RemoteException paramString)
    {
      zzb.zzb("Unable to call getAssetView on delegate", paramString);
    }
    return null;
  }
  
  FrameLayout zzn(Context paramContext)
  {
    return new FrameLayout(paramContext);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.formats.NativeAdView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */