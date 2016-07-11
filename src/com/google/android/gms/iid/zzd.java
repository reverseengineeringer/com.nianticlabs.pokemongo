package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class zzd
{
  Context context;
  SharedPreferences zzaEa;
  
  public zzd(Context paramContext)
  {
    this(paramContext, "com.google.android.gms.appid");
  }
  
  public zzd(Context paramContext, String paramString)
  {
    context = paramContext;
    zzaEa = paramContext.getSharedPreferences(paramString, 4);
    zzdo(paramString + "-no-backup");
  }
  
  private void zzdo(String paramString)
  {
    paramString = new File(new ContextCompat().getNoBackupFilesDir(context), paramString);
    if (paramString.exists()) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          if ((paramString.createNewFile()) && (!isEmpty()))
          {
            Log.i("InstanceID/Store", "App restored, clearing state");
            InstanceIDListenerService.zza(context, this);
            return;
          }
        }
        catch (IOException paramString) {}
      }
    } while (!Log.isLoggable("InstanceID/Store", 3));
    Log.d("InstanceID/Store", "Error creating file in no backup dir: " + paramString.getMessage());
  }
  
  private String zzf(String paramString1, String paramString2, String paramString3)
  {
    return paramString1 + "|T|" + paramString2 + "|" + paramString3;
  }
  
  String get(String paramString)
  {
    try
    {
      paramString = zzaEa.getString(paramString, null);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  String get(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = zzaEa.getString(paramString1 + "|S|" + paramString2, null);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  boolean isEmpty()
  {
    return zzaEa.getAll().isEmpty();
  }
  
  void zza(SharedPreferences.Editor paramEditor, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramEditor.putString(paramString1 + "|S|" + paramString2, paramString3);
      return;
    }
    finally
    {
      paramEditor = finally;
      throw paramEditor;
    }
  }
  
  public void zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString1 = zzf(paramString1, paramString2, paramString3);
      paramString2 = zzaEa.edit();
      paramString2.putString(paramString1, paramString4);
      paramString2.putString("appVersion", paramString5);
      paramString2.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000L));
      paramString2.commit();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void zzdp(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = zzaEa.edit();
      Iterator localIterator = zzaEa.getAll().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString)) {
          localEditor.remove(str);
        }
      }
      localEditor.commit();
    }
    finally {}
  }
  
  public KeyPair zzdq(String paramString)
  {
    return zzdt(paramString);
  }
  
  void zzdr(String paramString)
  {
    zzdp(paramString + "|");
  }
  
  public void zzds(String paramString)
  {
    zzdp(paramString + "|T|");
  }
  
  KeyPair zzdt(String paramString)
  {
    Object localObject1 = get(paramString, "|P|");
    Object localObject2 = get(paramString, "|K|");
    if (localObject2 == null) {
      return null;
    }
    try
    {
      paramString = Base64.decode((String)localObject1, 8);
      localObject1 = Base64.decode((String)localObject2, 8);
      localObject2 = KeyFactory.getInstance("RSA");
      paramString = new KeyPair(((KeyFactory)localObject2).generatePublic(new X509EncodedKeySpec(paramString)), ((KeyFactory)localObject2).generatePrivate(new PKCS8EncodedKeySpec((byte[])localObject1)));
      return paramString;
    }
    catch (InvalidKeySpecException paramString)
    {
      Log.w("InstanceID/Store", "Invalid key stored " + paramString);
      InstanceIDListenerService.zza(context, this);
      return null;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;) {}
    }
  }
  
  KeyPair zze(String paramString, long paramLong)
  {
    try
    {
      KeyPair localKeyPair = zza.zzwl();
      SharedPreferences.Editor localEditor = zzaEa.edit();
      zza(localEditor, paramString, "|P|", InstanceID.zzm(localKeyPair.getPublic().getEncoded()));
      zza(localEditor, paramString, "|K|", InstanceID.zzm(localKeyPair.getPrivate().getEncoded()));
      zza(localEditor, paramString, "cre", Long.toString(paramLong));
      localEditor.commit();
      return localKeyPair;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String zzg(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = zzf(paramString1, paramString2, paramString3);
      paramString1 = zzaEa.getString(paramString1, null);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void zzh(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = zzf(paramString1, paramString2, paramString3);
      paramString2 = zzaEa.edit();
      paramString2.remove(paramString1);
      paramString2.commit();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void zzwt()
  {
    try
    {
      zzaEa.edit().clear().commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.iid.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */