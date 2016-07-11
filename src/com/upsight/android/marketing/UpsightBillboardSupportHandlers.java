package com.upsight.android.marketing;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;
import com.upsight.android.marketing.internal.billboard.BillboardSupportFragment;
import java.util.List;
import java.util.Set;

public final class UpsightBillboardSupportHandlers
{
  private static final int STYLE_DIALOG = R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_UpsightDialog;
  private static final int STYLE_FULLSCREEN = 16974122;
  
  public static UpsightBillboard.Handler forDefault(FragmentActivity paramFragmentActivity)
  {
    return new DefaultHandler(paramFragmentActivity);
  }
  
  public static UpsightBillboard.Handler forDialog(FragmentActivity paramFragmentActivity)
  {
    return new DialogHandler(paramFragmentActivity);
  }
  
  private static UpsightBillboard.Handler forEmbedded(FragmentActivity paramFragmentActivity, int paramInt)
  {
    return new EmbeddedHandler(paramFragmentActivity, paramInt);
  }
  
  public static UpsightBillboard.Handler forFullscreen(FragmentActivity paramFragmentActivity)
  {
    return new FullscreenHandler(paramFragmentActivity);
  }
  
  public static class DefaultHandler
    extends UpsightBillboardSupportHandlers.SimpleHandler
  {
    public DefaultHandler(FragmentActivity paramFragmentActivity)
    {
      super();
    }
    
    public ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet)
    {
      if ((mActivity == null) || (mActivity.isFinishing())) {
        return null;
      }
      paramString = null;
      switch (UpsightBillboardSupportHandlers.1.$SwitchMap$com$upsight$android$marketing$UpsightBillboard$PresentationStyle[paramPresentationStyle.ordinal()])
      {
      }
      for (int i = 16974122;; i = UpsightBillboardSupportHandlers.STYLE_DIALOG)
      {
        mFragment = BillboardSupportFragment.newInstance(mActivity, paramString);
        mFragment.setStyle(1, i);
        mFragment.setCancelable(false);
        mFragment.show(mActivity.getSupportFragmentManager(), null);
        return mFragment.getContentViewContainer();
        paramString = paramSet;
      }
    }
  }
  
  public static class DialogHandler
    extends UpsightBillboardSupportHandlers.SimpleHandler
  {
    public DialogHandler(FragmentActivity paramFragmentActivity)
    {
      super();
    }
    
    public ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet)
    {
      if ((mActivity == null) || (mActivity.isFinishing())) {
        return null;
      }
      mFragment = BillboardSupportFragment.newInstance(mActivity, paramSet);
      mFragment.setStyle(1, UpsightBillboardSupportHandlers.STYLE_DIALOG);
      mFragment.setCancelable(false);
      mFragment.show(mActivity.getSupportFragmentManager(), null);
      return mFragment.getContentViewContainer();
    }
  }
  
  private static class EmbeddedHandler
    extends UpsightBillboardSupportHandlers.SimpleHandler
  {
    protected int mContainerViewId;
    
    public EmbeddedHandler(FragmentActivity paramFragmentActivity, int paramInt)
    {
      super();
      mContainerViewId = paramInt;
    }
    
    public ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet)
    {
      if ((mActivity == null) || (mActivity.isFinishing())) {
        return null;
      }
      mFragment = BillboardSupportFragment.newInstance(mActivity, paramSet);
      mActivity.getSupportFragmentManager().beginTransaction().add(mContainerViewId, mFragment).commit();
      return mFragment.getContentViewContainer();
    }
  }
  
  public static class FullscreenHandler
    extends UpsightBillboardSupportHandlers.SimpleHandler
  {
    public FullscreenHandler(FragmentActivity paramFragmentActivity)
    {
      super();
    }
    
    public ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet)
    {
      if ((mActivity == null) || (mActivity.isFinishing())) {
        return null;
      }
      mFragment = BillboardSupportFragment.newInstance(mActivity, null);
      mFragment.setStyle(1, 16974122);
      mFragment.setCancelable(false);
      mFragment.show(mActivity.getSupportFragmentManager(), null);
      return mFragment.getContentViewContainer();
    }
  }
  
  private static abstract class SimpleHandler
    implements UpsightBillboard.Handler
  {
    protected FragmentActivity mActivity;
    protected BillboardSupportFragment mFragment = null;
    
    protected SimpleHandler(FragmentActivity paramFragmentActivity)
    {
      mActivity = paramFragmentActivity;
    }
    
    public void onDetach()
    {
      BillboardSupportFragment localBillboardSupportFragment = mFragment;
      if (localBillboardSupportFragment != null)
      {
        localBillboardSupportFragment.dismissAllowingStateLoss();
        mFragment = null;
      }
    }
    
    public void onNextView() {}
    
    public void onPurchases(List<UpsightPurchase> paramList) {}
    
    public void onRewards(List<UpsightReward> paramList) {}
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightBillboardSupportHandlers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */