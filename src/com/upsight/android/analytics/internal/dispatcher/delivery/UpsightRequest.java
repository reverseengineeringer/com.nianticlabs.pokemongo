package com.upsight.android.analytics.internal.dispatcher.delivery;

import android.text.TextUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.internal.DataStoreRecord;
import com.upsight.android.analytics.internal.dispatcher.routing.Packet;
import com.upsight.android.analytics.internal.dispatcher.schema.Schema;
import com.upsight.android.analytics.internal.session.Clock;
import com.upsight.android.analytics.provider.UpsightOptOutStatus;
import com.upsight.android.internal.util.PreferencesHelper;
import com.upsight.android.logger.UpsightLogger;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@JsonSerialize(using=RequestSerializer.class)
class UpsightRequest
{
  private long mInstallTs;
  private final UpsightLogger mLogger;
  private final ObjectMapper mObjectMapper;
  private boolean mOptOut;
  private long mRequestTs;
  private Schema mSchema;
  private Session[] mSessions;
  private UpsightContext mUpsight;
  
  public UpsightRequest(UpsightContext paramUpsightContext, BatchSender.Request paramRequest, ObjectMapper paramObjectMapper, Clock paramClock, UpsightLogger paramUpsightLogger)
  {
    mUpsight = paramUpsightContext;
    mObjectMapper = paramObjectMapper;
    mLogger = paramUpsightLogger;
    mInstallTs = PreferencesHelper.getLong(paramUpsightContext, "install_ts", 0L);
    mSessions = getSessions(batch);
    mOptOut = UpsightOptOutStatus.get(mUpsight);
    mRequestTs = paramClock.currentTimeSeconds();
    mSchema = schema;
  }
  
  private Session[] getSessions(Batch paramBatch)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBatch.getPackets().iterator();
    while (localIterator.hasNext())
    {
      DataStoreRecord localDataStoreRecord = ((Packet)localIterator.next()).getRecord();
      Session localSession = (Session)localHashMap.get(Long.valueOf(localDataStoreRecord.getSessionID()));
      paramBatch = localSession;
      if (localSession == null)
      {
        paramBatch = new Session(localDataStoreRecord, mObjectMapper, mLogger, mInstallTs);
        localHashMap.put(Long.valueOf(localDataStoreRecord.getSessionID()), paramBatch);
      }
      paramBatch.addEvent(localDataStoreRecord);
    }
    return (Session[])localHashMap.values().toArray(new Session[localHashMap.values().size()]);
  }
  
  static class RequestSerializer
    extends JsonSerializer<UpsightRequest>
  {
    private static final String IDENTIFIERS_KEY = "identifiers";
    private static final String LOCALE_KEY = "locale";
    private static final String OPT_OUT_KEY = "opt_out";
    private static final String REQUEST_TS_KEY = "request_ts";
    private static final String SESSIONS_KEY = "sessions";
    
    public void serialize(UpsightRequest paramUpsightRequest, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException
    {
      paramJsonGenerator.writeStartObject();
      Object localObject1 = mSchema.availableKeys().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = mSchema.getValueFor(str);
        if (localObject2 != null) {
          paramJsonGenerator.writeObjectField(str, localObject2);
        }
      }
      paramJsonGenerator.writeObjectField("request_ts", Long.valueOf(mRequestTs));
      paramJsonGenerator.writeObjectField("opt_out", Boolean.valueOf(mOptOut));
      localObject1 = mSchema;
      if (localObject1 != null)
      {
        localObject1 = ((Schema)localObject1).getName();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramJsonGenerator.writeObjectField("identifiers", localObject1);
        }
      }
      localObject1 = Locale.getDefault();
      if (localObject1 != null)
      {
        localObject1 = ((Locale)localObject1).toString();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramJsonGenerator.writeObjectField("locale", localObject1);
        }
      }
      paramJsonGenerator.writeArrayFieldStart("sessions");
      paramUpsightRequest = mSessions;
      int j = paramUpsightRequest.length;
      int i = 0;
      while (i < j)
      {
        paramSerializerProvider.defaultSerializeValue(paramUpsightRequest[i], paramJsonGenerator);
        i += 1;
      }
      paramJsonGenerator.writeEndArray();
      paramJsonGenerator.writeEndObject();
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.UpsightRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */