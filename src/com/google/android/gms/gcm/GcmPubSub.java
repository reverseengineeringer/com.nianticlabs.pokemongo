package com.google.android.gms.gcm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.iid.InstanceID;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GcmPubSub
{
  private static GcmPubSub zzaCk;
  private static final Pattern zzaCm = Pattern.compile("/topics/[a-zA-Z0-9-_.~%]{1,900}");
  private InstanceID zzaCl;
  
  private GcmPubSub(Context paramContext)
  {
    zzaCl = InstanceID.getInstance(paramContext);
  }
  
  public static GcmPubSub getInstance(Context paramContext)
  {
    try
    {
      if (zzaCk == null) {
        zzaCk = new GcmPubSub(paramContext);
      }
      paramContext = zzaCk;
      return paramContext;
    }
    finally {}
  }
  
  public void subscribe(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    if ((paramString1 == null) || (paramString1.isEmpty())) {
      throw new IllegalArgumentException("Invalid appInstanceToken: " + paramString1);
    }
    if ((paramString2 == null) || (!zzaCm.matcher(paramString2).matches())) {
      throw new IllegalArgumentException("Invalid topic name: " + paramString2);
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("gcm.topic", paramString2);
    zzaCl.getToken(paramString1, paramString2, localBundle);
  }
  
  public void unsubscribe(String paramString1, String paramString2)
    throws IOException
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("gcm.topic", paramString2);
    zzaCl.zzb(paramString1, paramString2, localBundle);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.GcmPubSub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */