package com.upsight.android.analytics.internal.provider;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.provider.UpsightUserAttributes;
import com.upsight.android.analytics.provider.UpsightUserAttributes.Entry;
import com.upsight.android.internal.util.PreferencesHelper;
import com.upsight.android.logger.UpsightLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
final class UserAttributes
  extends UpsightUserAttributes
{
  private UpsightLogger mLogger;
  private UpsightContext mUpsight;
  private Map<String, UpsightUserAttributes.Entry> mUserAttributes = new HashMap();
  private Set<UpsightUserAttributes.Entry> mUserAttributesSet = new HashSet();
  
  @Inject
  UserAttributes(UpsightContext paramUpsightContext)
  {
    mUpsight = paramUpsightContext;
    mLogger = paramUpsightContext.getLogger();
    loadDefaultAttributes();
  }
  
  private void loadDefaultAttributes()
  {
    try
    {
      Bundle localBundle = mUpsight.getPackageManager().getApplicationInfo(mUpsight.getPackageName(), 128).metaData;
      if (localBundle != null)
      {
        Iterator localIterator = localBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("com.upsight.user_attribute.")))
          {
            String str = ((String)localObject).substring(((String)localObject).lastIndexOf('.') + 1);
            localObject = new UpsightUserAttributes.Entry(str, localBundle.get((String)localObject));
            mUserAttributes.put(str, localObject);
            mUserAttributesSet.add(localObject);
          }
        }
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      mLogger.e("Upsight", "Unexpected error: Package name missing!?", new Object[] { localNameNotFoundException });
    }
  }
  
  public Boolean getBoolean(String paramString)
  {
    if (!mUserAttributes.containsKey(paramString))
    {
      mLogger.w("Upsight", String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString }), new Object[0]);
      throw new IllegalArgumentException(String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString }));
    }
    if (!Boolean.class.equals(((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType()))
    {
      mLogger.w("Upsight", String.format("The user attribute %s must be of type: %s", new Object[] { paramString, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType() }), new Object[0]);
      throw new IllegalArgumentException(String.format("The user attribute %s must be of type: %s", new Object[] { paramString, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType() }));
    }
    return Boolean.valueOf(PreferencesHelper.getBoolean(mUpsight, "com.upsight.user_attribute." + paramString, ((Boolean)((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getDefaultValue()).booleanValue()));
  }
  
  public Set<UpsightUserAttributes.Entry> getDefault()
  {
    return mUserAttributesSet;
  }
  
  public Float getFloat(String paramString)
  {
    if (!mUserAttributes.containsKey(paramString))
    {
      mLogger.w("Upsight", String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString }), new Object[0]);
      throw new IllegalArgumentException(String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString }));
    }
    if (!Float.class.equals(((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType()))
    {
      mLogger.w("Upsight", String.format("The user attribute %s must be of type: %s", new Object[] { paramString, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType() }), new Object[0]);
      throw new IllegalArgumentException(String.format("The user attribute %s must be of type: %s", new Object[] { paramString, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType() }));
    }
    return Float.valueOf(PreferencesHelper.getFloat(mUpsight, "com.upsight.user_attribute." + paramString, ((Float)((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getDefaultValue()).floatValue()));
  }
  
  public Integer getInt(String paramString)
  {
    if (!mUserAttributes.containsKey(paramString))
    {
      mLogger.w("Upsight", String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString }), new Object[0]);
      throw new IllegalArgumentException(String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString }));
    }
    if (!Integer.class.equals(((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType()))
    {
      mLogger.w("Upsight", String.format("The user attribute %s must be of type: %s", new Object[] { paramString, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType() }), new Object[0]);
      throw new IllegalArgumentException(String.format("The user attribute %s must be of type: %s", new Object[] { paramString, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType() }));
    }
    return Integer.valueOf(PreferencesHelper.getInt(mUpsight, "com.upsight.user_attribute." + paramString, ((Integer)((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getDefaultValue()).intValue()));
  }
  
  public String getString(String paramString)
  {
    if (!mUserAttributes.containsKey(paramString))
    {
      mLogger.w("Upsight", String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString }), new Object[0]);
      throw new IllegalArgumentException(String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString }));
    }
    if (!String.class.equals(((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType()))
    {
      mLogger.w("Upsight", String.format("The user attribute %s must be of type: %s", new Object[] { paramString, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType() }), new Object[0]);
      throw new IllegalArgumentException(String.format("The user attribute %s must be of type: %s", new Object[] { paramString, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType() }));
    }
    return PreferencesHelper.getString(mUpsight, "com.upsight.user_attribute." + paramString, (String)((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getDefaultValue());
  }
  
  public void put(String paramString, Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      PreferencesHelper.clear(mUpsight, paramString);
    }
    if (mUserAttributes.containsKey(paramString))
    {
      if (!Boolean.class.equals(((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType()))
      {
        mLogger.w("Upsight", String.format("The user attribute %s must be of type: %s", new Object[] { paramString, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType() }), new Object[0]);
        throw new IllegalArgumentException(String.format("The user attribute %s must be of type: %s", new Object[] { paramString, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType() }));
      }
      PreferencesHelper.putBoolean(mUpsight, "com.upsight.user_attribute." + paramString, paramBoolean.booleanValue());
      return;
    }
    mLogger.w("Upsight", String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString }), new Object[0]);
    throw new IllegalArgumentException(String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString }));
  }
  
  public void put(String paramString, Float paramFloat)
  {
    if (paramFloat == null) {
      PreferencesHelper.clear(mUpsight, paramString);
    }
    if (mUserAttributes.containsKey(paramString))
    {
      if (!Float.class.equals(((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType()))
      {
        mLogger.w("Upsight", String.format("The user attribute %s must be of type: %s", new Object[] { paramString, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType() }), new Object[0]);
        throw new IllegalArgumentException(String.format("The user attribute %s must be of type: %s", new Object[] { paramString, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType() }));
      }
      PreferencesHelper.putFloat(mUpsight, "com.upsight.user_attribute." + paramString, paramFloat.floatValue());
      return;
    }
    mLogger.w("Upsight", String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString }), new Object[0]);
    throw new IllegalArgumentException(String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString }));
  }
  
  public void put(String paramString, Integer paramInteger)
  {
    if (paramInteger == null) {
      PreferencesHelper.clear(mUpsight, paramString);
    }
    if (mUserAttributes.containsKey(paramString))
    {
      if (!Integer.class.equals(((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType()))
      {
        mLogger.w("Upsight", String.format("The user attribute %s must be of type: %s", new Object[] { paramString, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType() }), new Object[0]);
        throw new IllegalArgumentException(String.format("The user attribute %s must be of type: %s", new Object[] { paramString, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString)).getType() }));
      }
      PreferencesHelper.putInt(mUpsight, "com.upsight.user_attribute." + paramString, paramInteger.intValue());
      return;
    }
    mLogger.w("Upsight", String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString }), new Object[0]);
    throw new IllegalArgumentException(String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString }));
  }
  
  public void put(String paramString1, String paramString2)
    throws IllegalArgumentException
  {
    if (paramString2 == null) {
      PreferencesHelper.clear(mUpsight, paramString1);
    }
    if (mUserAttributes.containsKey(paramString1))
    {
      if (!String.class.equals(((UpsightUserAttributes.Entry)mUserAttributes.get(paramString1)).getType()))
      {
        mLogger.w("Upsight", String.format("The user attribute %s must be of type: %s", new Object[] { paramString1, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString1)).getType() }), new Object[0]);
        throw new IllegalArgumentException(String.format("The user attribute %s must be of type: %s", new Object[] { paramString1, ((UpsightUserAttributes.Entry)mUserAttributes.get(paramString1)).getType() }));
      }
      PreferencesHelper.putString(mUpsight, "com.upsight.user_attribute." + paramString1, paramString2);
      return;
    }
    mLogger.w("Upsight", String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString1 }), new Object[0]);
    throw new IllegalArgumentException(String.format("No metadata found with android:name %s%s in the Android Manifest", new Object[] { "com.upsight.user_attribute.", paramString1 }));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.provider.UserAttributes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */