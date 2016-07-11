package com.upsight.android.unity;

import android.app.Activity;
import android.widget.Toast;

class AbstractUpsightPlugin$1
  implements Runnable
{
  AbstractUpsightPlugin$1(AbstractUpsightPlugin paramAbstractUpsightPlugin, String paramString1, String paramString2) {}
  
  public void run()
  {
    Activity localActivity = this$0.getActivity();
    if (localActivity != null) {
      Toast.makeText(localActivity, "UnitySendMessage:\n" + val$method + "\n" + val$nonNullParameter, 1).show();
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.unity.AbstractUpsightPlugin.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */