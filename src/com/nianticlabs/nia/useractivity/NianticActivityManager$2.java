package com.nianticlabs.nia.useractivity;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import com.nianticlabs.nia.contextservice.ServiceStatus;
import java.util.Iterator;
import java.util.List;

class NianticActivityManager$2
  implements Runnable
{
  NianticActivityManager$2(NianticActivityManager paramNianticActivityManager, ActivityRecognitionResult paramActivityRecognitionResult) {}
  
  public void run()
  {
    if (NianticActivityManager.access$000(this$0) == NianticActivityManager.AppState.RESUME)
    {
      NianticActivityManager.access$302(this$0, ServiceStatus.RUNNING);
      long[] arrayOfLong = new long[val$result.getProbableActivities().size() * 2 + 1];
      arrayOfLong[0] = val$result.getTime();
      int i = 1;
      Iterator localIterator = val$result.getProbableActivities().iterator();
      while (localIterator.hasNext())
      {
        DetectedActivity localDetectedActivity = (DetectedActivity)localIterator.next();
        int j = i + 1;
        arrayOfLong[i] = localDetectedActivity.getType();
        i = j + 1;
        arrayOfLong[j] = localDetectedActivity.getConfidence();
      }
      NianticActivityManager.access$400(this$0, arrayOfLong, NianticActivityManager.access$300(this$0).ordinal());
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.useractivity.NianticActivityManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */