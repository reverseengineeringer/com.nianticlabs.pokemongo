package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzz;

public final class PublisherAdView
  extends ViewGroup
{
  private final zzz zznT;
  
  public PublisherAdView(Context paramContext)
  {
    super(paramContext);
    zznT = new zzz(this);
  }
  
  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    zznT = new zzz(this, paramAttributeSet, true);
  }
  
  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    zznT = new zzz(this, paramAttributeSet, true);
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
  
  public AdSize[] getAdSizes()
  {
    return zznT.getAdSizes();
  }
  
  public String getAdUnitId()
  {
    return zznT.getAdUnitId();
  }
  
  public AppEventListener getAppEventListener()
  {
    return zznT.getAppEventListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return zznT.getMediationAdapterClassName();
  }
  
  public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return zznT.getOnCustomRenderedAdLoadedListener();
  }
  
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    zznT.zza(paramPublisherAdRequest.zzaF());
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
  
  public void recordManualImpression()
  {
    zznT.recordManualImpression();
  }
  
  public void resume()
  {
    zznT.resume();
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    zznT.setAdListener(paramAdListener);
  }
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
      throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
    }
    zznT.zza(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    zznT.setAdUnitId(paramString);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    zznT.setAppEventListener(paramAppEventListener);
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    zznT.setManualImpressionsEnabled(paramBoolean);
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    zznT.setOnCustomRenderedAdLoadedListener(paramOnCustomRenderedAdLoadedListener);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.doubleclick.PublisherAdView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */