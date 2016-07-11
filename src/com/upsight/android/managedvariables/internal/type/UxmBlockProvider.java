package com.upsight.android.managedvariables.internal.type;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.text.TextUtils;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.internal.dispatcher.schema.AbstractUxmBlockProvider;
import com.upsight.android.internal.util.PreferencesHelper;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.managedvariables.type.UpsightManagedBoolean;
import com.upsight.android.managedvariables.type.UpsightManagedFloat;
import com.upsight.android.managedvariables.type.UpsightManagedInt;
import com.upsight.android.managedvariables.type.UpsightManagedString;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.inject.Named;

public class UxmBlockProvider
  extends AbstractUxmBlockProvider
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private static final String HASH_ALGORITHM = "SHA-1";
  private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
  private Observer mBundleHashObserver = new Observer()
  {
    public void update(Observable paramAnonymousObservable, Object paramAnonymousObject)
    {
      put("bundle.hash", getBundleHash());
    }
  };
  private MessageDigest mDigest;
  private UpsightContext mUpsight;
  private UxmSchema mUxmSchema;
  private String mUxmSchemaRawString;
  
  UxmBlockProvider(UpsightContext paramUpsightContext, @Named("stringRawUxmSchema") String paramString, UxmSchema paramUxmSchema)
  {
    mUpsight = paramUpsightContext;
    mUxmSchemaRawString = paramString;
    mUxmSchema = paramUxmSchema;
    try
    {
      mDigest = MessageDigest.getInstance("SHA-1");
      PreferencesHelper.registerListener(paramUpsightContext, this);
      subscribeManagedVariables();
      put("bundle.schema_hash", getBundleSchemaHash());
      put("bundle.id", getBundleId());
      put("bundle.hash", getBundleHash());
      return;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        paramUpsightContext.getLogger().e("Upsight", paramString, "Failed to generate UXM hashes because SHA-1 is unavailable on this device", new Object[0]);
      }
    }
  }
  
  private static String bytesToHex(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfByte != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfByte.length > 0)
      {
        localObject1 = new char[paramArrayOfByte.length * 2];
        int i = 0;
        while (i < paramArrayOfByte.length)
        {
          int j = paramArrayOfByte[i] & 0xFF;
          localObject1[(i * 2)] = HEX_ARRAY[(j >>> 4)];
          localObject1[(i * 2 + 1)] = HEX_ARRAY[(j & 0xF)];
          i += 1;
        }
        localObject1 = new String((char[])localObject1);
      }
    }
    return (String)localObject1;
  }
  
  private String generateHash(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (mDigest != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = paramString.getBytes();
          mDigest.update(paramString, 0, paramString.length);
          localObject1 = bytesToHex(mDigest.digest());
        }
      }
      return (String)localObject1;
    }
    finally {}
  }
  
  private void subscribeManagedVariables()
  {
    Iterator localIterator = mUxmSchema.getAllOrdered().iterator();
    while (localIterator.hasNext())
    {
      UxmSchema.BaseSchema localBaseSchema = (UxmSchema.BaseSchema)localIterator.next();
      if ("com.upsight.uxm.string".equals(type)) {
        UpsightManagedString.fetch(mUpsight, tag).addObserver(mBundleHashObserver);
      } else if ("com.upsight.uxm.boolean".equals(type)) {
        UpsightManagedBoolean.fetch(mUpsight, tag).addObserver(mBundleHashObserver);
      } else if ("com.upsight.uxm.integer".equals(type)) {
        UpsightManagedInt.fetch(mUpsight, tag).addObserver(mBundleHashObserver);
      } else if ("com.upsight.uxm.float".equals(type)) {
        UpsightManagedFloat.fetch(mUpsight, tag).addObserver(mBundleHashObserver);
      }
    }
  }
  
  public String getBundleHash()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = mUxmSchema.getAllOrdered().iterator();
    if (localIterator.hasNext())
    {
      UxmSchema.BaseSchema localBaseSchema = (UxmSchema.BaseSchema)localIterator.next();
      Object localObject = null;
      if ("com.upsight.uxm.string".equals(type)) {
        localObject = UpsightManagedString.fetch(mUpsight, tag).get();
      }
      for (;;)
      {
        localStringBuilder.append(tag).append(localObject).append(type);
        break;
        if ("com.upsight.uxm.boolean".equals(type)) {
          localObject = UpsightManagedBoolean.fetch(mUpsight, tag).get();
        } else if ("com.upsight.uxm.integer".equals(type)) {
          localObject = UpsightManagedInt.fetch(mUpsight, tag).get();
        } else if ("com.upsight.uxm.float".equals(type)) {
          localObject = UpsightManagedFloat.fetch(mUpsight, tag).get();
        }
      }
    }
    return generateHash(localStringBuilder.toString());
  }
  
  public String getBundleId()
  {
    return PreferencesHelper.getString(mUpsight, "uxmBundleId", null);
  }
  
  public String getBundleSchemaHash()
  {
    return generateHash(mUxmSchemaRawString);
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if ("uxmBundleId".equals(paramString)) {
      put("bundle.id", getBundleId());
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmBlockProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */