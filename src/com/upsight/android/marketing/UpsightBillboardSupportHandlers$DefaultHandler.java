package com.upsight.android.marketing;

import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.upsight.android.marketing.internal.billboard.BillboardSupportFragment;
import java.util.Set;

public class UpsightBillboardSupportHandlers$DefaultHandler
  extends UpsightBillboardSupportHandlers.SimpleHandler
{
  public UpsightBillboardSupportHandlers$DefaultHandler(FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
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
    for (int i = 16974122;; i = UpsightBillboardSupportHandlers.access$000())
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

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightBillboardSupportHandlers.DefaultHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */