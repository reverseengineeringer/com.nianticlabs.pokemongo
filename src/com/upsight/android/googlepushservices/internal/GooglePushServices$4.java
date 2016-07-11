package com.upsight.android.googlepushservices.internal;

import com.upsight.android.UpsightException;
import com.upsight.android.analytics.event.comm.UpsightCommUnregisterEvent;
import com.upsight.android.analytics.event.comm.UpsightCommUnregisterEvent.Builder;
import com.upsight.android.googlepushservices.UpsightGooglePushServices.OnUnregisterListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import rx.Observer;

class GooglePushServices$4
  implements Observer<String>
{
  GooglePushServices$4(GooglePushServices paramGooglePushServices) {}
  
  public void onCompleted()
  {
    synchronized (this$0)
    {
      UpsightCommUnregisterEvent.createBuilder().record(GooglePushServices.access$000(this$0));
      HashSet localHashSet = new HashSet(GooglePushServices.access$400(this$0));
      GooglePushServices.access$400(this$0).clear();
      GooglePushServices.access$502(this$0, false);
      ??? = localHashSet.iterator();
      if (((Iterator)???).hasNext()) {
        ((UpsightGooglePushServices.OnUnregisterListener)((Iterator)???).next()).onSuccess();
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    synchronized (this$0)
    {
      HashSet localHashSet = new HashSet(GooglePushServices.access$400(this$0));
      GooglePushServices.access$400(this$0).clear();
      GooglePushServices.access$502(this$0, false);
      ??? = localHashSet.iterator();
      if (((Iterator)???).hasNext()) {
        ((UpsightGooglePushServices.OnUnregisterListener)((Iterator)???).next()).onFailure(new UpsightException(paramThrowable));
      }
    }
  }
  
  public void onNext(String paramString) {}
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.GooglePushServices.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */