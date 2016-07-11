package com.upsight.android;

import android.content.Context;
import android.content.ContextWrapper;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Named;

public class UpsightContext
  extends ContextWrapper
{
  private final String mAppToken;
  private UpsightCoreComponent mCoreComponent;
  private final UpsightDataStore mDataStore;
  private final Map<String, UpsightExtension> mExtensionsMap = new ConcurrentHashMap();
  private final UpsightLogger mLogger;
  private final String mPublicKey;
  private final String mSdkPlugin;
  private final String mSid;
  
  public UpsightContext(Context paramContext, @Named("com.upsight.sdk_plugin") String paramString1, @Named("com.upsight.app_token") String paramString2, @Named("com.upsight.public_key") String paramString3, String paramString4, UpsightDataStore paramUpsightDataStore, UpsightLogger paramUpsightLogger)
  {
    super(paramContext);
    mSdkPlugin = paramString1;
    mAppToken = paramString2;
    mPublicKey = paramString3;
    mSid = paramString4;
    mDataStore = paramUpsightDataStore;
    mLogger = paramUpsightLogger;
  }
  
  public String getApplicationToken()
  {
    return mAppToken;
  }
  
  public UpsightCoreComponent getCoreComponent()
  {
    return mCoreComponent;
  }
  
  public UpsightDataStore getDataStore()
  {
    return mDataStore;
  }
  
  public UpsightLogger getLogger()
  {
    return mLogger;
  }
  
  public String getPublicKey()
  {
    return mPublicKey;
  }
  
  public String getSdkBuild()
  {
    return getString(R.string.upsight_sdk_build);
  }
  
  public String getSdkPlugin()
  {
    return mSdkPlugin;
  }
  
  public String getSdkVersion()
  {
    return getString(R.string.upsight_sdk_version);
  }
  
  public String getSid()
  {
    return mSid;
  }
  
  public UpsightExtension<?, ?> getUpsightExtension(String paramString)
  {
    return (UpsightExtension)mExtensionsMap.get(paramString);
  }
  
  void onCreate(UpsightCoreComponent paramUpsightCoreComponent, Map<String, UpsightExtension> paramMap)
  {
    mCoreComponent = paramUpsightCoreComponent;
    Object localObject = paramMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      UpsightExtension localUpsightExtension = (UpsightExtension)localEntry.getValue();
      localUpsightExtension.setComponent(localUpsightExtension.onResolve(paramUpsightCoreComponent.upsightContext()));
      mExtensionsMap.put(localEntry.getKey(), localUpsightExtension);
    }
    paramUpsightCoreComponent = paramMap.values().iterator();
    while (paramUpsightCoreComponent.hasNext())
    {
      localObject = (UpsightExtension)paramUpsightCoreComponent.next();
      ((UpsightExtension)localObject).getComponent().inject((UpsightExtension)localObject);
    }
    paramUpsightCoreComponent = paramMap.values().iterator();
    while (paramUpsightCoreComponent.hasNext()) {
      ((UpsightExtension)paramUpsightCoreComponent.next()).onCreate(this);
    }
    paramUpsightCoreComponent = paramMap.values().iterator();
    while (paramUpsightCoreComponent.hasNext()) {
      ((UpsightExtension)paramUpsightCoreComponent.next()).onPostCreate(this);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.UpsightContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */