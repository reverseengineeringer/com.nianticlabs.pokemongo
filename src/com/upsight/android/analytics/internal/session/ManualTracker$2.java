package com.upsight.android.analytics.internal.session;

import com.upsight.android.UpsightException;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightDataStoreListener;
import java.util.Iterator;
import java.util.Set;

class ManualTracker$2
  implements UpsightDataStoreListener<Set<ApplicationStatus>>
{
  ManualTracker$2(ManualTracker paramManualTracker) {}
  
  public void onFailure(UpsightException paramUpsightException) {}
  
  public void onSuccess(Set<ApplicationStatus> paramSet)
  {
    if (paramSet.isEmpty()) {
      ManualTracker.access$000(this$0).store(new ApplicationStatus(ApplicationStatus.State.BACKGROUND));
    }
    for (;;)
    {
      return;
      paramSet = paramSet.iterator();
      int i = 0;
      while (paramSet.hasNext())
      {
        ApplicationStatus localApplicationStatus = (ApplicationStatus)paramSet.next();
        if (i == 0)
        {
          state = ApplicationStatus.State.BACKGROUND;
          ManualTracker.access$000(this$0).store(localApplicationStatus);
          i = 1;
        }
        else
        {
          ManualTracker.access$000(this$0).remove(localApplicationStatus);
          paramSet.remove();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.ManualTracker.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */