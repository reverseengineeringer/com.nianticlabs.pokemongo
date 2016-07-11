package com.upsight.android.unity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import com.upsight.android.Upsight;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightException;
import com.upsight.android.analytics.UpsightGooglePlayHelper;
import com.upsight.android.analytics.event.UpsightCustomEvent;
import com.upsight.android.analytics.event.UpsightCustomEvent.Builder;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.event.milestone.UpsightMilestoneEvent;
import com.upsight.android.analytics.event.milestone.UpsightMilestoneEvent.Builder;
import com.upsight.android.analytics.event.monetization.UpsightMonetizationEvent;
import com.upsight.android.analytics.event.monetization.UpsightMonetizationEvent.Builder;
import com.upsight.android.analytics.provider.UpsightLocationTracker;
import com.upsight.android.analytics.provider.UpsightLocationTracker.Data;
import com.upsight.android.analytics.provider.UpsightOptOutStatus;
import com.upsight.android.analytics.provider.UpsightUserAttributes;
import com.upsight.android.googlepushservices.UpsightGooglePushServices;
import com.upsight.android.googlepushservices.UpsightGooglePushServices.OnRegisterListener;
import com.upsight.android.googlepushservices.UpsightGooglePushServices.OnUnregisterListener;
import com.upsight.android.googlepushservices.UpsightPushBillboard;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.logger.UpsightLogger.Level;
import com.upsight.android.managedvariables.type.UpsightManagedBoolean;
import com.upsight.android.managedvariables.type.UpsightManagedFloat;
import com.upsight.android.managedvariables.type.UpsightManagedInt;
import com.upsight.android.managedvariables.type.UpsightManagedString;
import com.upsight.android.marketing.UpsightBillboard;
import com.upsight.android.marketing.UpsightMarketingContentStore;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class UpsightPlugin
  extends AbstractUpsightPlugin
  implements Application.ActivityLifecycleCallbacks
{
  private static UpsightPlugin sInstance;
  private BillboardHandler mBillboardHandler;
  private Map<String, UpsightBillboard> mBillboardMap = new HashMap();
  private boolean mHasActiveBillboard = false;
  private List<String> mJettisonedBillboardScopes;
  private UpsightBillboard mPushBillboard;
  private boolean mShouldSynchronizeManagedVariables = true;
  private UpsightContext mUpsight;
  
  @SuppressLint({"NewApi"})
  public static UpsightPlugin instance()
  {
    try
    {
      if (sInstance == null)
      {
        sInstance = new UpsightPlugin();
        localObject1 = sInstance.getActivity();
        if (localObject1 != null)
        {
          sInstancemUpsight = Upsight.createContext((Context)localObject1);
          sInstancemBillboardHandler = new BillboardHandler((Activity)localObject1, sInstance);
          Log.i("Upsight", "creating UpsightPushBillboard");
          sInstancemPushBillboard = UpsightPushBillboard.create(sInstancemUpsight, sInstancemBillboardHandler);
          if (Build.VERSION.SDK_INT >= 14)
          {
            Log.i("Upsight", "wiring up an ActivityLifecycleCallback listener since we are on API 14+");
            ((Activity)localObject1).getApplication().registerActivityLifecycleCallbacks(sInstance);
          }
        }
      }
      Object localObject1 = sInstance;
      return (UpsightPlugin)localObject1;
    }
    finally {}
  }
  
  private static UpsightPublisherData publisherDataFromJsonString(String paramString)
  {
    UpsightPublisherData.Builder localBuilder = new UpsightPublisherData.Builder();
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (;;)
    {
      Object localObject;
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            localObject = paramString.get(str);
            if (!(localObject instanceof String)) {
              break label99;
            }
            localBuilder.put(str, (String)localObject);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          continue;
        }
        return localBuilder.build();
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      label99:
      if ((localObject instanceof Float)) {
        localBuilder.put(localJSONException, ((Float)localObject).floatValue());
      } else if ((localObject instanceof Double)) {
        localBuilder.put(localJSONException, ((Double)localObject).doubleValue());
      } else if ((localObject instanceof Long)) {
        localBuilder.put(localJSONException, ((Long)localObject).longValue());
      } else if ((localObject instanceof Boolean)) {
        localBuilder.put(localJSONException, ((Boolean)localObject).booleanValue());
      }
    }
  }
  
  public void destroyBillboard(String paramString)
  {
    if ((mBillboardMap.containsKey(paramString)) && (!getHasActiveBillboard()))
    {
      Log.i("Upsight", "Destroying billboard for scope: " + paramString);
      ((UpsightBillboard)mBillboardMap.get(paramString)).destroy();
      mBillboardMap.remove(paramString);
    }
  }
  
  public String getAppToken()
  {
    return mUpsight.getApplicationToken();
  }
  
  boolean getHasActiveBillboard()
  {
    return mHasActiveBillboard;
  }
  
  public boolean getManagedBool(String paramString)
  {
    try
    {
      UpsightManagedBoolean localUpsightManagedBoolean = UpsightManagedBoolean.fetch(mUpsight, paramString);
      if (localUpsightManagedBoolean != null) {
        return ((Boolean)localUpsightManagedBoolean.get()).booleanValue();
      }
      Log.e("Upsight", "Unknown tag " + paramString + " for managed bool, please check your UXM schema");
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public float getManagedFloat(String paramString)
  {
    try
    {
      UpsightManagedFloat localUpsightManagedFloat = UpsightManagedFloat.fetch(mUpsight, paramString);
      if (localUpsightManagedFloat != null) {
        return ((Float)localUpsightManagedFloat.get()).floatValue();
      }
      Log.e("Upsight", "Unknown tag " + paramString + " for managed float, please check your UXM schema");
      return 0.0F;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0.0F;
  }
  
  public int getManagedInt(String paramString)
  {
    try
    {
      UpsightManagedInt localUpsightManagedInt = UpsightManagedInt.fetch(mUpsight, paramString);
      if (localUpsightManagedInt != null) {
        return ((Integer)localUpsightManagedInt.get()).intValue();
      }
      Log.e("Upsight", "Unknown tag " + paramString + " for managed int, please check your UXM schema");
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public String getManagedString(String paramString)
  {
    try
    {
      UpsightManagedString localUpsightManagedString = UpsightManagedString.fetch(mUpsight, paramString);
      if (localUpsightManagedString != null) {
        return (String)localUpsightManagedString.get();
      }
      Log.e("Upsight", "Unknown tag " + paramString + " for managed string, please check your UXM schema");
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public boolean getOptOutStatus()
  {
    return UpsightOptOutStatus.get(mUpsight);
  }
  
  public String getPluginVersion()
  {
    return mUpsight.getSdkPlugin();
  }
  
  public String getPublicKey()
  {
    return mUpsight.getPublicKey();
  }
  
  public boolean getShouldSynchronizeManagedVariables()
  {
    return mShouldSynchronizeManagedVariables;
  }
  
  public String getSid()
  {
    return mUpsight.getSid();
  }
  
  public boolean getUserAttributesBool(String paramString)
  {
    try
    {
      boolean bool = UpsightUserAttributes.getBoolean(mUpsight, paramString).booleanValue();
      return bool;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public float getUserAttributesFloat(String paramString)
  {
    try
    {
      float f = UpsightUserAttributes.getFloat(mUpsight, paramString).floatValue();
      return f;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0.0F;
  }
  
  public int getUserAttributesInt(String paramString)
  {
    try
    {
      int i = UpsightUserAttributes.getInteger(mUpsight, paramString).intValue();
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public String getUserAttributesString(String paramString)
  {
    try
    {
      paramString = UpsightUserAttributes.getString(mUpsight, paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public boolean isContentReadyForBillboardWithScope(String paramString)
  {
    return UpsightMarketingContentStore.isContentReady(mUpsight, paramString);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    mPushBillboard.destroy();
    mPushBillboard = null;
    mJettisonedBillboardScopes = new ArrayList();
    paramActivity = mBillboardMap.keySet().iterator();
    while (paramActivity.hasNext())
    {
      String str = (String)paramActivity.next();
      mJettisonedBillboardScopes.add(str);
      ((UpsightBillboard)mBillboardMap.get(str)).destroy();
    }
    mBillboardMap.clear();
    Log.i("Upsight", "tombstoned " + mJettisonedBillboardScopes.size() + " scopes when pausing");
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    Log.i("Upsight", "resurrecting " + mJettisonedBillboardScopes.size() + " scopes when resuming and push billboard");
    if (mPushBillboard == null) {
      mPushBillboard = UpsightPushBillboard.create(mUpsight, mBillboardHandler);
    }
    paramActivity = mJettisonedBillboardScopes.iterator();
    while (paramActivity.hasNext()) {
      prepareBillboard((String)paramActivity.next());
    }
    mJettisonedBillboardScopes = null;
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void prepareBillboard(String paramString)
  {
    if ((mBillboardMap.containsKey(paramString)) || (getHasActiveBillboard())) {
      return;
    }
    if (mBillboardMap.size() > 0)
    {
      localObject = mBillboardMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Log.i("Upsight", "clearing out cached billboard [" + str + "] to make room for the new billboard: " + paramString);
        ((UpsightBillboard)mBillboardMap.get(str)).destroy();
      }
      mBillboardMap.clear();
    }
    Object localObject = UpsightBillboard.create(mUpsight, paramString, mBillboardHandler);
    mBillboardMap.put(paramString, localObject);
  }
  
  public void purgeLocation()
  {
    UpsightLocationTracker.purge(mUpsight);
  }
  
  public void recordAnalyticsEvent(String paramString1, String paramString2)
  {
    paramString1 = UpsightCustomEvent.createBuilder(paramString1);
    paramString1.put(publisherDataFromJsonString(paramString2));
    paramString1.record(mUpsight);
  }
  
  public void recordGooglePlayPurchase(int paramInt1, String paramString1, double paramDouble1, double paramDouble2, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    UpsightPublisherData.Builder localBuilder = new UpsightPublisherData.Builder();
    localBuilder.put(publisherDataFromJsonString(paramString5));
    try
    {
      paramString5 = new Intent();
      paramString5.putExtra("RESPONSE_CODE", paramInt2);
      paramString5.putExtra("INAPP_PURCHASE_DATA", paramString3);
      paramString5.putExtra("INAPP_DATA_SIGNATURE", paramString4);
      UpsightGooglePlayHelper.trackPurchase(mUpsight, paramInt1, paramString1, paramDouble1, paramDouble2, paramString2, paramString5, localBuilder.build());
      return;
    }
    catch (UpsightException paramString1)
    {
      Log.i("Upsight", "Failed to recordGooglePlayPurchase: " + paramString1.getMessage());
      paramString1.printStackTrace();
    }
  }
  
  public void recordMilestoneEvent(String paramString1, String paramString2)
  {
    paramString1 = UpsightMilestoneEvent.createBuilder(paramString1);
    paramString1.put(publisherDataFromJsonString(paramString2));
    paramString1.record(mUpsight);
  }
  
  public void recordMonetizationEvent(double paramDouble1, String paramString1, String paramString2, double paramDouble2, String paramString3, int paramInt, String paramString4)
  {
    paramString1 = UpsightMonetizationEvent.createBuilder(Double.valueOf(paramDouble1), paramString1);
    paramString1.put(publisherDataFromJsonString(paramString4));
    if (paramString2 != null) {
      paramString1.setProduct(paramString2);
    }
    if (paramDouble2 >= 0.0D) {
      paramString1.setPrice(Double.valueOf(paramDouble2));
    }
    if (paramString3 != null) {
      paramString1.setResolution(paramString3);
    }
    if (paramInt > 0) {
      paramString1.setQuantity(Integer.valueOf(paramInt));
    }
    paramString1.record(mUpsight);
  }
  
  public void registerForPushNotifications()
  {
    Log.i("Upsight", "registering for push notifications");
    UpsightGooglePushServices.register(mUpsight, new UpsightGooglePushServices.OnRegisterListener()
    {
      public void onFailure(UpsightException paramAnonymousUpsightException)
      {
        Log.e("Upsight", "registration failed: " + paramAnonymousUpsightException);
      }
      
      public void onSuccess(String paramAnonymousString)
      {
        Log.e("Upsight", "registration succeeded");
      }
    });
  }
  
  public void removeBillboardFromMap(String paramString)
  {
    if (mBillboardMap.containsKey(paramString))
    {
      Log.i("Upsight", "Removing used billboard from internal map for scope: " + paramString);
      mBillboardMap.remove(paramString);
    }
  }
  
  void setHasActiveBillboard(boolean paramBoolean)
  {
    mHasActiveBillboard = paramBoolean;
  }
  
  public void setLocation(double paramDouble1, double paramDouble2, String paramString)
  {
    UpsightLocationTracker.Data localData = UpsightLocationTracker.Data.create(paramDouble1, paramDouble2);
    if ((paramString != null) && (paramString.length() > 0)) {
      localData.setTimeZone(paramString);
    }
    UpsightLocationTracker.track(mUpsight, localData);
  }
  
  public void setLoggerLevel(String paramString)
  {
    if (paramString.toLowerCase().equals("verbose"))
    {
      Log.i("Upsight", "enabling verbose logs");
      mUpsight.getLogger().setLogLevel("Upsight", EnumSet.allOf(UpsightLogger.Level.class));
      return;
    }
    paramString = EnumSet.of(UpsightLogger.Level.valueOf(paramString));
    mUpsight.getLogger().setLogLevel("Upsight", paramString);
  }
  
  public void setOptOutStatus(boolean paramBoolean)
  {
    UpsightOptOutStatus.set(mUpsight, paramBoolean);
  }
  
  public void setShouldSynchronizeManagedVariables(boolean paramBoolean)
  {
    mShouldSynchronizeManagedVariables = paramBoolean;
  }
  
  public void setUserAttributesBool(String paramString, boolean paramBoolean)
  {
    try
    {
      UpsightUserAttributes.put(mUpsight, paramString, Boolean.valueOf(paramBoolean));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setUserAttributesFloat(String paramString, float paramFloat)
  {
    try
    {
      UpsightUserAttributes.put(mUpsight, paramString, Float.valueOf(paramFloat));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setUserAttributesInt(String paramString, int paramInt)
  {
    try
    {
      UpsightUserAttributes.put(mUpsight, paramString, Integer.valueOf(paramInt));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setUserAttributesString(String paramString1, String paramString2)
  {
    try
    {
      UpsightUserAttributes.put(mUpsight, paramString1, paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void unregisterForPushNotifications()
  {
    Log.i("Upsight", "unregistering for push notifications");
    UpsightGooglePushServices.unregister(mUpsight, new UpsightGooglePushServices.OnUnregisterListener()
    {
      public void onFailure(UpsightException paramAnonymousUpsightException)
      {
        Log.e("Upsight", "unregistration failed: " + paramAnonymousUpsightException);
      }
      
      public void onSuccess()
      {
        Log.e("Upsight", "unregistration succeeded");
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.unity.UpsightPlugin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */