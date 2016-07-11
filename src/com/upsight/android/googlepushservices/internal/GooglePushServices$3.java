package com.upsight.android.googlepushservices.internal;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class GooglePushServices$3
  implements Observable.OnSubscribe<String>
{
  GooglePushServices$3(GooglePushServices paramGooglePushServices) {}
  
  public void call(Subscriber<? super String> paramSubscriber)
  {
    try
    {
      GoogleCloudMessaging.getInstance(GooglePushServices.access$000(this$0)).unregister();
      paramSubscriber.onCompleted();
      return;
    }
    catch (IOException localIOException)
    {
      paramSubscriber.onError(localIOException);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.GooglePushServices.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */