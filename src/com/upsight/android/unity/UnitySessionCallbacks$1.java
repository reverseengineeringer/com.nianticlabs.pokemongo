package com.upsight.android.unity;

import android.util.Log;
import com.upsight.android.managedvariables.experience.UpsightUserExperience.Handler;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

class UnitySessionCallbacks$1
  implements UpsightUserExperience.Handler
{
  UnitySessionCallbacks$1(UnitySessionCallbacks paramUnitySessionCallbacks) {}
  
  public boolean onReceive()
  {
    return UpsightPlugin.instance().getShouldSynchronizeManagedVariables();
  }
  
  public void onSynchronize(List<String> paramList)
  {
    Log.i("UnitySessionCallbacks", "onSynchronize");
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put((String)paramList.next());
    }
    UpsightPlugin.instance().UnitySendMessage("managedVariablesDidSynchronize", localJSONArray.toString());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.unity.UnitySessionCallbacks.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */