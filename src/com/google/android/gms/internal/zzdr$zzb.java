package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzdr$zzb
{
  public Intent zza(Intent paramIntent, ResolveInfo paramResolveInfo)
  {
    paramIntent = new Intent(paramIntent);
    paramIntent.setClassName(activityInfo.packageName, activityInfo.name);
    return paramIntent;
  }
  
  public ResolveInfo zza(Context paramContext, Intent paramIntent)
  {
    return zza(paramContext, paramIntent, new ArrayList());
  }
  
  public ResolveInfo zza(Context paramContext, Intent paramIntent, ArrayList<ResolveInfo> paramArrayList)
  {
    paramContext = paramContext.getPackageManager();
    if (paramContext == null) {
      return null;
    }
    List localList = paramContext.queryIntentActivities(paramIntent, 65536);
    paramContext = paramContext.resolveActivity(paramIntent, 65536);
    int i;
    if ((localList != null) && (paramContext != null))
    {
      i = 0;
      if (i < localList.size())
      {
        paramIntent = (ResolveInfo)localList.get(i);
        if ((paramContext == null) || (!activityInfo.name.equals(activityInfo.name))) {}
      }
    }
    for (;;)
    {
      paramArrayList.addAll(localList);
      return paramContext;
      i += 1;
      break;
      paramContext = null;
    }
  }
  
  public Intent zzb(Context paramContext, Map<String, String> paramMap)
  {
    Object localObject1 = null;
    Object localObject2 = (ActivityManager)paramContext.getSystemService("activity");
    Object localObject3 = (String)paramMap.get("u");
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      paramMap = (Map<String, String>)localObject1;
      return paramMap;
    }
    localObject1 = Uri.parse((String)localObject3);
    boolean bool1 = Boolean.parseBoolean((String)paramMap.get("use_first_package"));
    boolean bool2 = Boolean.parseBoolean((String)paramMap.get("use_running_process"));
    if ("http".equalsIgnoreCase(((Uri)localObject1).getScheme())) {
      paramMap = ((Uri)localObject1).buildUpon().scheme("https").build();
    }
    for (;;)
    {
      localObject3 = new ArrayList();
      Intent localIntent = zzd((Uri)localObject1);
      paramMap = zzd(paramMap);
      localObject1 = zza(paramContext, localIntent, (ArrayList)localObject3);
      if (localObject1 != null)
      {
        return zza(localIntent, (ResolveInfo)localObject1);
        if ("https".equalsIgnoreCase(((Uri)localObject1).getScheme())) {
          paramMap = ((Uri)localObject1).buildUpon().scheme("http").build();
        }
      }
      else
      {
        if (paramMap != null)
        {
          paramMap = zza(paramContext, paramMap);
          if (paramMap != null)
          {
            localObject1 = zza(localIntent, paramMap);
            paramMap = (Map<String, String>)localObject1;
            if (zza(paramContext, (Intent)localObject1) != null) {
              break;
            }
          }
        }
        if (((ArrayList)localObject3).size() == 0) {
          return localIntent;
        }
        if ((bool2) && (localObject2 != null))
        {
          paramContext = ((ActivityManager)localObject2).getRunningAppProcesses();
          if (paramContext != null)
          {
            do
            {
              paramMap = ((ArrayList)localObject3).iterator();
              while (!((Iterator)localObject2).hasNext())
              {
                if (!paramMap.hasNext()) {
                  break;
                }
                localObject1 = (ResolveInfo)paramMap.next();
                localObject2 = paramContext.iterator();
              }
            } while (!nextprocessName.equals(activityInfo.packageName));
            return zza(localIntent, (ResolveInfo)localObject1);
          }
        }
        if (bool1) {
          return zza(localIntent, (ResolveInfo)((ArrayList)localObject3).get(0));
        }
        return localIntent;
      }
      paramMap = null;
    }
  }
  
  public Intent zzd(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setData(paramUri);
    localIntent.setAction("android.intent.action.VIEW");
    return localIntent;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdr.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */