package com.nianticlabs.nia.platform;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings.Secure;
import android.util.Base64;
import com.nianticlabs.nia.contextservice.ContextService;
import java.io.File;
import java.util.Locale;

public class AndroidPlatformContext
  extends ContextService
{
  private final SharedPreferences prefs;
  
  public AndroidPlatformContext(Context paramContext, long paramLong)
  {
    super(paramContext, paramLong);
    prefs = paramContext.getSharedPreferences(paramContext.getPackageName() + ".PREFS", 0);
  }
  
  public String concatPath(String paramString1, String paramString2)
  {
    return new File(paramString1, paramString2).getPath();
  }
  
  public boolean deleteFile(String paramString)
  {
    return new File(paramString).delete();
  }
  
  public boolean deleteSetting(String paramString)
  {
    return prefs.edit().remove(paramString).commit();
  }
  
  public long fileSize(String paramString)
  {
    return new File(paramString).length();
  }
  
  public String getCacheDirectory()
  {
    return context.getCacheDir().getPath();
  }
  
  public String getDeviceCountryCode()
  {
    return Locale.getDefault().getCountry();
  }
  
  public String getDeviceId()
  {
    return Settings.Secure.getString(context.getContentResolver(), "android_id");
  }
  
  public String getDeviceLanguageCode()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public byte[] getSetting(String paramString)
  {
    Object localObject = null;
    String str = prefs.getString(paramString, null);
    paramString = (String)localObject;
    if (str != null) {
      paramString = Base64.decode(str.getBytes(), 0);
    }
    return paramString;
  }
  
  public boolean makePathRecursive(String paramString)
  {
    return new File(paramString).mkdirs();
  }
  
  public boolean pathExists(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public boolean setSetting(String paramString, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 0);
    return prefs.edit().putString(paramString, paramArrayOfByte).commit();
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.platform.AndroidPlatformContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */