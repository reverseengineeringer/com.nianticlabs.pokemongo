package com.upsight.android.marketing;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.ViewGroup;
import com.upsight.android.marketing.internal.billboard.BillboardFragment;
import java.util.List;
import java.util.Set;

public final class UpsightBillboardHandlers
{
  private static final int STYLE_DIALOG = R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_UpsightDialog;
  private static final int STYLE_FULLSCREEN = 16974122;
  
  public static UpsightBillboard.Handler forDefault(Activity paramActivity)
  {
    return new DefaultHandler(paramActivity);
  }
  
  public static UpsightBillboard.Handler forDialog(Activity paramActivity)
  {
    return new DialogHandler(paramActivity);
  }
  
  private static UpsightBillboard.Handler forEmbedded(Activity paramActivity, int paramInt)
  {
    return new EmbeddedHandler(paramActivity, paramInt);
  }
  
  public static UpsightBillboard.Handler forFullscreen(Activity paramActivity)
  {
    return new FullscreenHandler(paramActivity);
  }
  
  public static class DefaultHandler
    extends UpsightBillboardHandlers.SimpleHandler
  {
    public DefaultHandler(Activity paramActivity)
    {
      super();
    }
    
    public ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet)
    {
      if ((mActivity == null) || (mActivity.isFinishing())) {
        return null;
      }
      paramString = null;
      switch (UpsightBillboardHandlers.1.$SwitchMap$com$upsight$android$marketing$UpsightBillboard$PresentationStyle[paramPresentationStyle.ordinal()])
      {
      }
      for (int i = 16974122;; i = UpsightBillboardHandlers.STYLE_DIALOG)
      {
        mFragment = BillboardFragment.newInstance(mActivity, paramString);
        mFragment.setStyle(1, i);
        mFragment.setCancelable(false);
        mFragment.show(mActivity.getFragmentManager(), null);
        return mFragment.getContentViewContainer();
        paramString = paramSet;
      }
    }
  }
  
  public static class DialogHandler
    extends UpsightBillboardHandlers.SimpleHandler
  {
    public DialogHandler(Activity paramActivity)
    {
      super();
    }
    
    public ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet)
    {
      if ((mActivity == null) || (mActivity.isFinishing())) {
        return null;
      }
      mFragment = BillboardFragment.newInstance(mActivity, paramSet);
      mFragment.setStyle(1, UpsightBillboardHandlers.STYLE_DIALOG);
      mFragment.setCancelable(false);
      mFragment.show(mActivity.getFragmentManager(), null);
      return mFragment.getContentViewContainer();
    }
  }
  
  private static class EmbeddedHandler
    extends UpsightBillboardHandlers.SimpleHandler
  {
    protected int mContainerViewId;
    
    public EmbeddedHandler(Activity paramActivity, int paramInt)
    {
      super();
      mContainerViewId = paramInt;
    }
    
    public ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet)
    {
      if ((mActivity == null) || (mActivity.isFinishing())) {
        return null;
      }
      mFragment = BillboardFragment.newInstance(mActivity, paramSet);
      mActivity.getFragmentManager().beginTransaction().add(mContainerViewId, mFragment).commit();
      return mFragment.getContentViewContainer();
    }
  }
  
  public static class FullscreenHandler
    extends UpsightBillboardHandlers.SimpleHandler
  {
    public FullscreenHandler(Activity paramActivity)
    {
      super();
    }
    
    public ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet)
    {
      if ((mActivity == null) || (mActivity.isFinishing())) {
        return null;
      }
      mFragment = BillboardFragment.newInstance(mActivity, null);
      mFragment.setStyle(1, 16974122);
      mFragment.setCancelable(false);
      mFragment.show(mActivity.getFragmentManager(), null);
      return mFragment.getContentViewContainer();
    }
  }
  
  private static abstract class SimpleHandler
    implements UpsightBillboard.Handler
  {
    protected Activity mActivity;
    protected BillboardFragment mFragment = null;
    
    protected SimpleHandler(Activity paramActivity)
    {
      mActivity = paramActivity;
    }
    
    public void onDetach()
    {
      BillboardFragment localBillboardFragment = mFragment;
      if (localBillboardFragment != null)
      {
        localBillboardFragment.dismissAllowingStateLoss();
        mFragment = null;
      }
    }
    
    public void onNextView() {}
    
    public void onPurchases(List<UpsightPurchase> paramList) {}
    
    public void onRewards(List<UpsightReward> paramList) {}
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightBillboardHandlers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */