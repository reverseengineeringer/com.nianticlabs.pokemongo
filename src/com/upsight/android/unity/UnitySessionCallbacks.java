package com.upsight.android.unity;

import android.util.Log;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.session.UpsightSessionCallbacks;
import com.upsight.android.managedvariables.experience.UpsightUserExperience;
import com.upsight.android.managedvariables.experience.UpsightUserExperience.Handler;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class UnitySessionCallbacks
  implements UpsightSessionCallbacks
{
  protected static final String TAG = "UnitySessionCallbacks";
  
  public void onStart(UpsightContext paramUpsightContext)
  {
    UpsightUserExperience.registerHandler(paramUpsightContext, new UpsightUserExperience.Handler()
    {
      public boolean onReceive()
      {
        return UpsightPlugin.instance().getShouldSynchronizeManagedVariables();
      }
      
      public void onSynchronize(List<String> paramAnonymousList)
      {
        Log.i("UnitySessionCallbacks", "onSynchronize");
        JSONArray localJSONArray = new JSONArray();
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext()) {
          localJSONArray.put((String)paramAnonymousList.next());
        }
        UpsightPlugin.instance().UnitySendMessage("managedVariablesDidSynchronize", localJSONArray.toString());
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.unity.UnitySessionCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */