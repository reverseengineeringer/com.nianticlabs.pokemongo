package com.upsight.android.unity;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;
import com.upsight.android.marketing.UpsightBillboard.Dimensions;
import com.upsight.android.marketing.UpsightBillboard.PresentationStyle;
import com.upsight.android.marketing.UpsightBillboardHandlers.DefaultHandler;
import com.upsight.android.marketing.UpsightPurchase;
import com.upsight.android.marketing.UpsightReward;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class BillboardHandler
  extends UpsightBillboardHandlers.DefaultHandler
{
  protected static final String TAG = "UpsightBillboardHandler";
  private String mCurrentScope;
  private UpsightPlugin mPlugin;
  
  public BillboardHandler(Activity paramActivity, UpsightPlugin paramUpsightPlugin)
  {
    super(paramActivity);
    mPlugin = paramUpsightPlugin;
  }
  
  public ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet)
  {
    mCurrentScope = paramString;
    paramPresentationStyle = super.onAttach(paramString, paramPresentationStyle, paramSet);
    if (paramPresentationStyle != null)
    {
      mPlugin.setHasActiveBillboard(true);
      mPlugin.UnitySendMessage("onBillboardAppear", paramString);
    }
    return paramPresentationStyle;
  }
  
  public void onDetach()
  {
    super.onDetach();
    Log.i("UpsightBillboardHandler", "onDetach");
    mPlugin.UnitySendMessage("onBillboardDismiss", mCurrentScope);
    mPlugin.removeBillboardFromMap(mCurrentScope);
    mPlugin.setHasActiveBillboard(false);
  }
  
  public void onNextView()
  {
    super.onNextView();
    Log.i("UpsightBillboardHandler", "onNextView");
  }
  
  public void onPurchases(List<UpsightPurchase> paramList)
  {
    super.onPurchases(paramList);
    Log.i("UpsightBillboardHandler", "onPurchases");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      UpsightPurchase localUpsightPurchase = (UpsightPurchase)paramList.next();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("productIdentifier", localUpsightPurchase.getProduct());
        localJSONObject.put("quantity", localUpsightPurchase.getQuantity());
        localJSONObject.put("billboardScope", mCurrentScope);
        mPlugin.UnitySendMessage("billboardDidReceivePurchase", localJSONObject.toString());
      }
      catch (Exception localException)
      {
        Log.i("UpsightBillboardHandler", "Error creating JSON" + localException.getMessage());
      }
    }
  }
  
  public void onRewards(List<UpsightReward> paramList)
  {
    super.onRewards(paramList);
    Log.i("UpsightBillboardHandler", "onRewards");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      UpsightReward localUpsightReward = (UpsightReward)paramList.next();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("productIdentifier", localUpsightReward.getProduct());
        localJSONObject.put("quantity", localUpsightReward.getQuantity());
        localJSONObject.put("signatureData", localUpsightReward.getSignatureData());
        localJSONObject.put("billboardScope", mCurrentScope);
        mPlugin.UnitySendMessage("billboardDidReceiveReward", localJSONObject.toString());
      }
      catch (Exception localException)
      {
        Log.i("UpsightBillboardHandler", "Error creating JSON" + localException.getMessage());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.unity.BillboardHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */