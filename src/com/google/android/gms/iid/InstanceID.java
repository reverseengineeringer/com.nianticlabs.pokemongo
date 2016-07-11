package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class InstanceID
{
  public static final String ERROR_BACKOFF = "RETRY_LATER";
  public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
  public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
  public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
  public static final String ERROR_TIMEOUT = "TIMEOUT";
  static String zzaDC;
  static Map<String, InstanceID> zzaDw = new HashMap();
  private static zzd zzaDx;
  private static zzc zzaDy;
  Context mContext;
  String zzaDA = "";
  long zzaDB;
  KeyPair zzaDz;
  
  protected InstanceID(Context paramContext, String paramString, Bundle paramBundle)
  {
    mContext = paramContext.getApplicationContext();
    zzaDA = paramString;
  }
  
  public static InstanceID getInstance(Context paramContext)
  {
    return zza(paramContext, null);
  }
  
  public static InstanceID zza(Context paramContext, Bundle paramBundle)
  {
    String str;
    if (paramBundle == null) {
      str = "";
    }
    for (;;)
    {
      try
      {
        Context localContext = paramContext.getApplicationContext();
        if (zzaDx == null)
        {
          zzaDx = new zzd(localContext);
          zzaDy = new zzc(localContext);
        }
        zzaDC = Integer.toString(zzaC(localContext));
        InstanceID localInstanceID = (InstanceID)zzaDw.get(str);
        paramContext = localInstanceID;
        if (localInstanceID == null)
        {
          paramContext = new InstanceID(localContext, str, paramBundle);
          zzaDw.put(str, paramContext);
        }
        return paramContext;
      }
      finally {}
      str = paramBundle.getString("subtype");
      while (str != null) {
        break;
      }
      str = "";
    }
  }
  
  static String zza(KeyPair paramKeyPair)
  {
    paramKeyPair = paramKeyPair.getPublic().getEncoded();
    try
    {
      paramKeyPair = MessageDigest.getInstance("SHA1").digest(paramKeyPair);
      paramKeyPair[0] = ((byte)((paramKeyPair[0] & 0xF) + 112 & 0xFF));
      paramKeyPair = Base64.encodeToString(paramKeyPair, 0, 8, 11);
      return paramKeyPair;
    }
    catch (NoSuchAlgorithmException paramKeyPair)
    {
      Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
    }
    return null;
  }
  
  static int zzaC(Context paramContext)
  {
    try
    {
      int i = getPackageManagergetPackageInfogetPackageName0versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.w("InstanceID", "Never happens: can't find own package " + paramContext);
    }
    return 0;
  }
  
  static String zzm(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 11);
  }
  
  public void deleteInstanceID()
    throws IOException
  {
    zzb("*", "*", null);
    zzwn();
  }
  
  public void deleteToken(String paramString1, String paramString2)
    throws IOException
  {
    zzb(paramString1, paramString2, null);
  }
  
  public long getCreationTime()
  {
    if (zzaDB == 0L)
    {
      String str = zzaDx.get(zzaDA, "cre");
      if (str != null) {
        zzaDB = Long.parseLong(str);
      }
    }
    return zzaDB;
  }
  
  public String getId()
  {
    return zza(zzwm());
  }
  
  public String getToken(String paramString1, String paramString2)
    throws IOException
  {
    return getToken(paramString1, paramString2, null);
  }
  
  public String getToken(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    int j = 0;
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw new IOException("MAIN_THREAD");
    }
    int i = 1;
    if (zzwq()) {}
    for (Object localObject = null; localObject != null; localObject = zzaDx.zzg(zzaDA, paramString1, paramString2)) {
      return (String)localObject;
    }
    localObject = paramBundle;
    if (paramBundle == null) {
      localObject = new Bundle();
    }
    if (((Bundle)localObject).getString("ttl") != null) {
      i = 0;
    }
    if ("jwt".equals(((Bundle)localObject).getString("type"))) {
      i = j;
    }
    for (;;)
    {
      paramBundle = zzc(paramString1, paramString2, (Bundle)localObject);
      Log.w("InstanceID", "token: " + paramBundle);
      localObject = paramBundle;
      if (paramBundle == null) {
        break;
      }
      localObject = paramBundle;
      if (i == 0) {
        break;
      }
      zzaDx.zza(zzaDA, paramString1, paramString2, paramBundle, zzaDC);
      return paramBundle;
    }
  }
  
  public void zzb(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw new IOException("MAIN_THREAD");
    }
    zzaDx.zzh(zzaDA, paramString1, paramString2);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("sender", paramString1);
    if (paramString2 != null) {
      localBundle.putString("scope", paramString2);
    }
    localBundle.putString("subscription", paramString1);
    localBundle.putString("delete", "1");
    localBundle.putString("X-delete", "1");
    if ("".equals(zzaDA))
    {
      paramString2 = paramString1;
      localBundle.putString("subtype", paramString2);
      if (!"".equals(zzaDA)) {
        break label173;
      }
    }
    for (;;)
    {
      localBundle.putString("X-subtype", paramString1);
      paramString1 = zzaDy.zza(localBundle, zzwm());
      zzaDy.zzp(paramString1);
      return;
      paramString2 = zzaDA;
      break;
      label173:
      paramString1 = zzaDA;
    }
  }
  
  public String zzc(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    if (paramString2 != null) {
      paramBundle.putString("scope", paramString2);
    }
    paramBundle.putString("sender", paramString1);
    if ("".equals(zzaDA)) {}
    for (paramString2 = paramString1;; paramString2 = zzaDA)
    {
      if (!paramBundle.containsKey("legacy.register"))
      {
        paramBundle.putString("subscription", paramString1);
        paramBundle.putString("subtype", paramString2);
        paramBundle.putString("X-subscription", paramString1);
        paramBundle.putString("X-subtype", paramString2);
      }
      paramString1 = zzaDy.zza(paramBundle, zzwm());
      return zzaDy.zzp(paramString1);
    }
  }
  
  KeyPair zzwm()
  {
    if (zzaDz == null) {
      zzaDz = zzaDx.zzdq(zzaDA);
    }
    if (zzaDz == null)
    {
      zzaDB = System.currentTimeMillis();
      zzaDz = zzaDx.zze(zzaDA, zzaDB);
    }
    return zzaDz;
  }
  
  void zzwn()
  {
    zzaDB = 0L;
    zzaDx.zzdr(zzaDA);
    zzaDz = null;
  }
  
  zzd zzwo()
  {
    return zzaDx;
  }
  
  zzc zzwp()
  {
    return zzaDy;
  }
  
  boolean zzwq()
  {
    String str = zzaDx.get("appVersion");
    if ((str == null) || (!str.equals(zzaDC))) {}
    long l;
    do
    {
      do
      {
        return true;
        str = zzaDx.get("lastToken");
      } while (str == null);
      l = Long.parseLong(str);
    } while (System.currentTimeMillis() / 1000L - Long.valueOf(l).longValue() > 604800L);
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.iid.InstanceID
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */