package com.upsight.android.marketing;

import android.app.Activity;
import android.view.ViewGroup;
import com.upsight.android.marketing.internal.billboard.BillboardFragment;
import java.util.Set;

public class UpsightBillboardHandlers$DefaultHandler
  extends UpsightBillboardHandlers.SimpleHandler
{
  public UpsightBillboardHandlers$DefaultHandler(Activity paramActivity)
  {
    super(paramActivity);
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
    for (int i = 16974122;; i = UpsightBillboardHandlers.access$000())
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

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightBillboardHandlers.DefaultHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */