package com.upsight.android.marketing.internal.billboard;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import com.upsight.android.marketing.R.layout;
import com.upsight.android.marketing.UpsightBillboard.Dimensions;
import java.util.Iterator;
import java.util.Set;

public final class BillboardFragment
  extends DialogFragment
{
  private static final String BUNDLE_KEY_LANDSCAPE_HEIGHT = "landscapeHeight";
  private static final String BUNDLE_KEY_LANDSCAPE_WIDTH = "landscapeWidth";
  private static final String BUNDLE_KEY_PORTRAIT_HEIGHT = "portraitHeight";
  private static final String BUNDLE_KEY_PORTRAIT_WIDTH = "portraitWidth";
  private ViewGroup mContentViewContainer = null;
  private ViewGroup mRootView = null;
  
  public static BillboardFragment newInstance(Context paramContext, Set<UpsightBillboard.Dimensions> paramSet)
  {
    BillboardFragment localBillboardFragment = new BillboardFragment();
    Bundle localBundle = new Bundle();
    if (paramSet != null)
    {
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        UpsightBillboard.Dimensions localDimensions = (UpsightBillboard.Dimensions)paramSet.next();
        if ((width > 0) && (height > 0)) {
          switch (layout)
          {
          default: 
            break;
          case ???: 
            localBundle.putInt("portraitWidth", width);
            localBundle.putInt("portraitHeight", height);
            break;
          case ???: 
            localBundle.putInt("landscapeWidth", width);
            localBundle.putInt("landscapeHeight", height);
          }
        }
      }
    }
    localBillboardFragment.setArguments(localBundle);
    localBillboardFragment.setRetainInstance(true);
    mContentViewContainer = new LinearLayout(paramContext.getApplicationContext());
    return localBillboardFragment;
  }
  
  private void setDialogSize(int paramInt1, int paramInt2)
  {
    Window localWindow = getDialog().getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    width = paramInt1;
    height = paramInt2;
    localWindow.setAttributes(localLayoutParams);
  }
  
  public ViewGroup getContentViewContainer()
  {
    return mContentViewContainer;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getFragmentManager().beginTransaction().detach(this).attach(this).commit();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (mContentViewContainer != null)
    {
      mRootView = ((ViewGroup)paramLayoutInflater.inflate(R.layout.upsight_fragment_billboard, paramViewGroup, false));
      mRootView.addView(mContentViewContainer, new ViewGroup.LayoutParams(-1, -1));
    }
    return mRootView;
  }
  
  public void onDestroyView()
  {
    if (mContentViewContainer != null) {
      mRootView.removeView(mContentViewContainer);
    }
    Dialog localDialog = getDialog();
    if ((localDialog != null) && (getRetainInstance())) {
      localDialog.setDismissMessage(null);
    }
    super.onDestroyView();
  }
  
  public void onResume()
  {
    int i = getResourcesgetConfigurationorientation;
    Bundle localBundle = getArguments();
    if ((i == 1) && (localBundle.containsKey("portraitWidth"))) {
      setDialogSize(localBundle.getInt("portraitWidth"), localBundle.getInt("portraitHeight"));
    }
    for (;;)
    {
      super.onResume();
      return;
      if ((i == 2) && (localBundle.containsKey("landscapeWidth"))) {
        setDialogSize(localBundle.getInt("landscapeWidth"), localBundle.getInt("landscapeHeight"));
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (mContentViewContainer == null) {
      dismiss();
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.billboard.BillboardFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */