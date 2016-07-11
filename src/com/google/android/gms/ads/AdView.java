package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class AdView
  extends ViewGroup
{
  private final zzz zznT;
  
  public AdView(Context paramContext)
  {
    super(paramContext);
    zznT = new zzz(this);
  }
  
  public AdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    zznT = new zzz(this, paramAttributeSet, false);
  }
  
  public AdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    zznT = new zzz(this, paramAttributeSet, false);
  }
  
  public void destroy()
  {
    zznT.destroy();
  }
  
  public AdListener getAdListener()
  {
    return zznT.getAdListener();
  }
  
  public AdSize getAdSize()
  {
    return zznT.getAdSize();
  }
  
  public String getAdUnitId()
  {
    return zznT.getAdUnitId();
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return zznT.getInAppPurchaseListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return zznT.getMediationAdapterClassName();
  }
  
  public boolean isLoading()
  {
    return zznT.isLoading();
  }
  
  public void loadAd(AdRequest paramAdRequest)
  {
    zznT.zza(paramAdRequest.zzaF());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int i = localView.getMeasuredWidth();
      int j = localView.getMeasuredHeight();
      paramInt1 = (paramInt3 - paramInt1 - i) / 2;
      paramInt2 = (paramInt4 - paramInt2 - j) / 2;
      localView.layout(paramInt1, paramInt2, i + paramInt1, j + paramInt2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject = getChildAt(0);
    int j;
    if ((localObject != null) && (((View)localObject).getVisibility() != 8))
    {
      measureChild((View)localObject, paramInt1, paramInt2);
      j = ((View)localObject).getMeasuredWidth();
      i = ((View)localObject).getMeasuredHeight();
    }
    for (;;)
    {
      j = Math.max(j, getSuggestedMinimumWidth());
      i = Math.max(i, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSize(j, paramInt1), View.resolveSize(i, paramInt2));
      return;
      localObject = getAdSize();
      if (localObject != null)
      {
        Context localContext = getContext();
        j = ((AdSize)localObject).getWidthInPixels(localContext);
        i = ((AdSize)localObject).getHeightInPixels(localContext);
      }
      else
      {
        j = 0;
      }
    }
  }
  
  public void pause()
  {
    zznT.pause();
  }
  
  public void resume()
  {
    zznT.resume();
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    zznT.setAdListener(paramAdListener);
    if ((paramAdListener != null) && ((paramAdListener instanceof zza))) {
      zznT.zza((zza)paramAdListener);
    }
    while (paramAdListener != null) {
      return;
    }
    zznT.zza(null);
  }
  
  public void setAdSize(AdSize paramAdSize)
  {
    zznT.setAdSizes(new AdSize[] { paramAdSize });
  }
  
  public void setAdUnitId(String paramString)
  {
    zznT.setAdUnitId(paramString);
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    zznT.setInAppPurchaseListener(paramInAppPurchaseListener);
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    zznT.setPlayStorePurchaseParams(paramPlayStorePurchaseListener, paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.AdView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */