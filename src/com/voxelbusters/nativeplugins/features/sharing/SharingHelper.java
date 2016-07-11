package com.voxelbusters.nativeplugins.features.sharing;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.voxelbusters.nativeplugins.defines.Enums.eShareOptions;
import com.voxelbusters.nativeplugins.utilities.ApplicationUtility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SharingHelper
{
  public static HashMap<String, Enums.eShareOptions> packageNameMap = null;
  
  static
  {
    packageNameMap = new HashMap();
    packageNameMap.put("com.facebook.katana", Enums.eShareOptions.FB);
    packageNameMap.put("com.facebook.katana.LoginActivity", Enums.eShareOptions.FB);
    packageNameMap.put("com.twitter.android", Enums.eShareOptions.TWITTER);
    packageNameMap.put("com.google.android.apps.plus", Enums.eShareOptions.GOOGLE_PLUS);
    packageNameMap.put("com.instagram.android", Enums.eShareOptions.INSTAGRAM);
    packageNameMap.put("com.whatsapp", Enums.eShareOptions.WHATSAPP);
  }
  
  public static boolean checkIfPackageMatchesShareOptions(String paramString, String[] paramArrayOfString)
  {
    paramString = (Enums.eShareOptions)packageNameMap.get(paramString);
    int j;
    int i;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramString != null))
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        return false;
      }
      if (Integer.parseInt(paramArrayOfString[i]) == paramString.ordinal()) {
        return true;
      }
      i += 1;
    }
  }
  
  public static Intent[] getPriorityIntents(Intent paramIntent)
  {
    paramIntent = new ArrayList();
    Iterator localIterator = packageNameMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return (Intent[])paramIntent.toArray(new Intent[paramIntent.size()]);
      }
      String str = (String)localIterator.next();
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setPackage(str);
      paramIntent.add(localIntent);
    }
  }
  
  public static Intent[] getPrioritySocialNetworkingIntents(Intent paramIntent)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = packageNameMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return (Intent[])localArrayList.toArray(new Intent[localArrayList.size()]);
      }
      String str = (String)localIterator.next();
      if (isSocialNetwork(str))
      {
        Intent localIntent = new Intent(paramIntent);
        localIntent.setPackage(str);
        localArrayList.add(localIntent);
      }
    }
  }
  
  public static boolean isServiceAvailable(Context paramContext, Enums.eShareOptions parameShareOptions)
  {
    boolean bool = false;
    if (parameShareOptions == Enums.eShareOptions.FB) {
      if ((ApplicationUtility.isIntentAvailable(paramContext, "android.intent.action.SEND", "text/plain", "com.facebook.katana")) || (ApplicationUtility.isIntentAvailable(paramContext, "android.intent.action.SEND", "text/plain", "com.facebook.katana.LoginActivity"))) {
        bool = true;
      }
    }
    do
    {
      return bool;
      if (parameShareOptions == Enums.eShareOptions.TWITTER) {
        return ApplicationUtility.isIntentAvailable(paramContext, "android.intent.action.SEND", "text/plain", "com.twitter.android");
      }
      if (parameShareOptions == Enums.eShareOptions.WHATSAPP) {
        return ApplicationUtility.isIntentAvailable(paramContext, "android.intent.action.SEND", "text/plain", "com.whatsapp");
      }
      if (parameShareOptions == Enums.eShareOptions.MESSAGE)
      {
        parameShareOptions = new Intent("android.intent.action.SENDTO");
        parameShareOptions.setData(Uri.parse("smsto:"));
        return ApplicationUtility.isIntentAvailable(paramContext, parameShareOptions);
      }
    } while (parameShareOptions != Enums.eShareOptions.MAIL);
    return ApplicationUtility.isIntentAvailable(paramContext, "android.intent.action.SEND", "message/rfc822", null);
  }
  
  public static boolean isSocialNetwork(String paramString)
  {
    paramString = (Enums.eShareOptions)packageNameMap.get(paramString);
    return (paramString != null) && ((Enums.eShareOptions.FB == paramString) || (Enums.eShareOptions.TWITTER == paramString) || (Enums.eShareOptions.GOOGLE_PLUS == paramString) || (Enums.eShareOptions.INSTAGRAM == paramString));
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.sharing.SharingHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */