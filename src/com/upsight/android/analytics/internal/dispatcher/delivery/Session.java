package com.upsight.android.analytics.internal.dispatcher.delivery;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.analytics.internal.DataStoreRecord;
import com.upsight.android.logger.UpsightLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Session
{
  private Set<DataStoreRecord> mEvents = new HashSet();
  private long mInstallTs;
  private final UpsightLogger mLogger;
  private Integer mMsgCampaignId;
  private Integer mMsgId;
  private final ObjectMapper mObjectMapper;
  private long mPastSessionTime;
  private int mSessionNum;
  private long mSessionStart;
  
  public Session(DataStoreRecord paramDataStoreRecord, ObjectMapper paramObjectMapper, UpsightLogger paramUpsightLogger, long paramLong)
  {
    mSessionStart = paramDataStoreRecord.getSessionID();
    mObjectMapper = paramObjectMapper;
    mLogger = paramUpsightLogger;
    mInstallTs = paramLong;
    mMsgId = paramDataStoreRecord.getMessageID();
    mMsgCampaignId = paramDataStoreRecord.getCampaignID();
    mPastSessionTime = paramDataStoreRecord.getPastSessionTime();
    mSessionNum = paramDataStoreRecord.getSessionNumber();
  }
  
  public void addEvent(DataStoreRecord paramDataStoreRecord)
  {
    mEvents.add(paramDataStoreRecord);
  }
  
  @JsonProperty("events")
  public ObjectNode[] getEvents()
  {
    ArrayList localArrayList = new ArrayList(mEvents.size());
    Iterator localIterator = mEvents.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (DataStoreRecord)localIterator.next();
      try
      {
        localObject = ((DataStoreRecord)localObject).getSource();
        localObject = mObjectMapper.readTree((String)localObject);
        if (((JsonNode)localObject).isObject()) {
          localArrayList.add((ObjectNode)localObject);
        }
      }
      catch (IOException localIOException)
      {
        mLogger.e(getClass().getSimpleName(), localIOException, "Error parsing JSON object.", new Object[0]);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return (ObjectNode[])localArrayList.toArray(new ObjectNode[mEvents.size()]);
  }
  
  @JsonProperty("install_ts")
  public long getInstallTs()
  {
    return mInstallTs;
  }
  
  @JsonProperty("msg_campaign_id")
  @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
  public Integer getMsgCampaignId()
  {
    return mMsgCampaignId;
  }
  
  @JsonProperty("msg_id")
  @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
  public Integer getMsgId()
  {
    return mMsgId;
  }
  
  @JsonProperty("past_session_time")
  public long getPastSessionTime()
  {
    return mPastSessionTime;
  }
  
  @JsonProperty("session_num")
  public int getSessionNum()
  {
    return mSessionNum;
  }
  
  @JsonProperty("session_start")
  public long getSessionStart()
  {
    return mSessionStart;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.Session
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */