package com.upsight.android.googlepushservices.internal;

import com.upsight.android.UpsightException;
import com.upsight.android.analytics.event.comm.UpsightCommRegisterEvent;
import com.upsight.android.analytics.event.comm.UpsightCommRegisterEvent.Builder;
import com.upsight.android.googlepushservices.UpsightGooglePushServices.OnRegisterListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import rx.Observer;

class GooglePushServices$2
  implements Observer<String>
{
  GooglePushServices$2(GooglePushServices paramGooglePushServices) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    synchronized (this$0)
    {
      HashSet localHashSet = new HashSet(GooglePushServices.access$100(this$0));
      GooglePushServices.access$100(this$0).clear();
      GooglePushServices.access$202(this$0, false);
      ??? = localHashSet.iterator();
      if (((Iterator)???).hasNext()) {
        ((UpsightGooglePushServices.OnRegisterListener)((Iterator)???).next()).onFailure(new UpsightException(paramThrowable));
      }
    }
  }
  
  public void onNext(String paramString)
  {
    synchronized (this$0)
    {
      GooglePushServices.access$300(this$0, paramString);
      UpsightCommRegisterEvent.createBuilder().setToken(paramString).record(GooglePushServices.access$000(this$0));
      HashSet localHashSet = new HashSet(GooglePushServices.access$100(this$0));
      GooglePushServices.access$100(this$0).clear();
      GooglePushServices.access$202(this$0, false);
      ??? = localHashSet.iterator();
      if (((Iterator)???).hasNext()) {
        ((UpsightGooglePushServices.OnRegisterListener)((Iterator)???).next()).onSuccess(paramString);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.GooglePushServices.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */