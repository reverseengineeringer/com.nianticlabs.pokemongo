package com.upsight.android.googlepushservices.internal;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.upsight.android.Upsight;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightGooglePushServicesExtension;
import com.upsight.android.analytics.event.comm.UpsightCommClickEvent;
import com.upsight.android.analytics.event.comm.UpsightCommClickEvent.Builder;
import com.upsight.android.analytics.internal.session.ApplicationStatus;
import com.upsight.android.analytics.internal.session.ApplicationStatus.State;
import com.upsight.android.analytics.internal.session.SessionInitializerImpl;
import com.upsight.android.analytics.internal.session.SessionManager;
import com.upsight.android.googlepushservices.UpsightGooglePushServicesComponent;
import com.upsight.android.persistence.UpsightDataStore;
import javax.inject.Inject;
import rx.Observable;
import rx.observables.BlockingObservable;

public class PushClickIntentService
  extends IntentService
{
  private static final String BUNDLE_KEY_MESSAGE_INTENT = "messageIntent";
  private static final Integer NO_CMP_ID = Integer.valueOf(Integer.MIN_VALUE);
  private static final Integer NO_MSG_ID = Integer.valueOf(Integer.MIN_VALUE);
  private static final String SERVICE_NAME = "UpsightGcmPushClickIntentService";
  @Inject
  SessionManager mSessionManager;
  
  public PushClickIntentService()
  {
    super("UpsightGcmPushClickIntentService");
  }
  
  protected static Intent appendMessageIntentBundle(Intent paramIntent, Integer paramInteger1, Integer paramInteger2)
  {
    Bundle localBundle = new Bundle();
    if (paramInteger1 != null) {
      localBundle.putInt("campaign_id", paramInteger1.intValue());
    }
    if (paramInteger2 != null) {
      localBundle.putInt("message_id", paramInteger2.intValue());
    }
    paramIntent.putExtra("pushMessage", true);
    paramIntent.addFlags(268435456);
    return paramIntent.putExtra("session_extra", localBundle);
  }
  
  static Intent newIntent(Context paramContext, Intent paramIntent, Integer paramInteger1, Integer paramInteger2)
  {
    return new Intent(paramContext.getApplicationContext(), PushClickIntentService.class).putExtra("messageIntent", appendMessageIntentBundle(paramIntent, paramInteger1, paramInteger2));
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    Object localObject1 = Upsight.createContext(this);
    ((UpsightGooglePushServicesComponent)((UpsightGooglePushServicesExtension)((UpsightContext)localObject1).getUpsightExtension("com.upsight.extension.googlepushservices")).getComponent()).inject(this);
    paramIntent = (Intent)paramIntent.getParcelableExtra("messageIntent");
    Object localObject2 = paramIntent.getBundleExtra("session_extra");
    SessionManager localSessionManager = mSessionManager;
    if (ApplicationStatus.State.BACKGROUND.name().equals(((ApplicationStatus)((UpsightContext)localObject1).getDataStore().fetchObservable(ApplicationStatus.class).toBlocking().first()).getState().name())) {
      localSessionManager.startSession(SessionInitializerImpl.fromPush((Bundle)localObject2));
    }
    localObject1 = UpsightCommClickEvent.createBuilder(Integer.valueOf(((Bundle)localObject2).getInt("message_id", NO_MSG_ID.intValue())));
    localObject2 = Integer.valueOf(((Bundle)localObject2).getInt("campaign_id", NO_CMP_ID.intValue()));
    if (!((Integer)localObject2).equals(NO_CMP_ID)) {
      ((UpsightCommClickEvent.Builder)localObject1).setMsgCampaignId((Integer)localObject2);
    }
    ((UpsightCommClickEvent.Builder)localObject1).record(Upsight.createContext(this));
    startActivity(paramIntent);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.PushClickIntentService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */