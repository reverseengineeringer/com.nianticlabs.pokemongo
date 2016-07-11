package com.upsight.android.analytics.internal.dispatcher.delivery;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.analytics.dispatcher.EndpointResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

class ResponseParser
{
  private ObjectMapper mMapper;
  
  @Inject
  public ResponseParser(@Named("config-mapper") ObjectMapper paramObjectMapper)
  {
    mMapper = paramObjectMapper;
  }
  
  public Response parse(String paramString)
    throws IOException
  {
    try
    {
      paramString = (ResponseJson)mMapper.readValue(paramString, ResponseJson.class);
      LinkedList localLinkedList = new LinkedList();
      if (response != null)
      {
        Iterator localIterator = response.iterator();
        while (localIterator.hasNext())
        {
          ResponseElementJson localResponseElementJson = (ResponseElementJson)localIterator.next();
          localLinkedList.add(EndpointResponse.create(type, mMapper.writeValueAsString(content)));
        }
      }
      paramString = new Response(localLinkedList, error);
    }
    finally {}
    return paramString;
  }
  
  public static class Response
  {
    public final String error;
    public final Collection<EndpointResponse> responses;
    
    public Response(Collection<EndpointResponse> paramCollection, String paramString)
    {
      responses = paramCollection;
      error = paramString;
    }
  }
  
  public static class ResponseElementJson
  {
    @JsonProperty("content")
    public JsonNode content;
    @JsonProperty("type")
    public String type;
  }
  
  public static class ResponseJson
  {
    @JsonProperty("error")
    public String error;
    @JsonProperty("response")
    public List<ResponseParser.ResponseElementJson> response;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.ResponseParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */