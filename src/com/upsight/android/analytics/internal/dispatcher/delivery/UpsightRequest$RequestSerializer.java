package com.upsight.android.analytics.internal.dispatcher.delivery;

import android.text.TextUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.upsight.android.analytics.internal.dispatcher.schema.Schema;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

class UpsightRequest$RequestSerializer
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
    Object localObject1 = UpsightRequest.access$000(paramUpsightRequest).availableKeys().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = UpsightRequest.access$000(paramUpsightRequest).getValueFor(str);
      if (localObject2 != null) {
        paramJsonGenerator.writeObjectField(str, localObject2);
      }
    }
    paramJsonGenerator.writeObjectField("request_ts", Long.valueOf(UpsightRequest.access$100(paramUpsightRequest)));
    paramJsonGenerator.writeObjectField("opt_out", Boolean.valueOf(UpsightRequest.access$200(paramUpsightRequest)));
    localObject1 = UpsightRequest.access$000(paramUpsightRequest);
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
    paramUpsightRequest = UpsightRequest.access$300(paramUpsightRequest);
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.UpsightRequest.RequestSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */