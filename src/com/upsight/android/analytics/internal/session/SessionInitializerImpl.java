package com.upsight.android.analytics.internal.session;

import android.os.Bundle;

public class SessionInitializerImpl
  implements SessionInitializer
{
  private static final int NO_CMP_ID = Integer.MIN_VALUE;
  private static final int NO_MSG_ID = Integer.MIN_VALUE;
  private static final String SESSION_CAMPAIGN_ID = "campaign_id";
  private static final String SESSION_MESSAGE_ID = "message_id";
  private int mCampaignId;
  private int mMessageId;
  
  private SessionInitializerImpl(int paramInt1, int paramInt2)
  {
    mCampaignId = paramInt1;
    mMessageId = paramInt2;
  }
  
  public static SessionInitializer fromPush(Bundle paramBundle)
  {
    return new SessionInitializerImpl(paramBundle.getInt("campaign_id", Integer.MIN_VALUE), paramBundle.getInt("message_id", Integer.MIN_VALUE));
  }
  
  public Integer getCampaignID()
  {
    if (mCampaignId == Integer.MIN_VALUE) {
      return null;
    }
    return Integer.valueOf(mCampaignId);
  }
  
  public Integer getMessageID()
  {
    if (mMessageId == Integer.MIN_VALUE) {
      return null;
    }
    return Integer.valueOf(mMessageId);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.SessionInitializerImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */