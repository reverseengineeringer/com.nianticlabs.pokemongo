package com.upsight.android.marketing.internal.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public final class MarketingContentModel
{
  @JsonProperty("content_id")
  String contentId;
  @JsonProperty("context")
  JsonNode context;
  @JsonProperty("presentation")
  Presentation presentation;
  @JsonProperty("url")
  String templateUrl;
  
  static MarketingContentModel from(JsonNode paramJsonNode, ObjectMapper paramObjectMapper)
    throws IOException
  {
    return (MarketingContentModel)paramObjectMapper.treeToValue(paramJsonNode, MarketingContentModel.class);
  }
  
  public String getContentID()
  {
    return contentId;
  }
  
  public JsonNode getContext()
  {
    return context;
  }
  
  public MarketingContentModel.Presentation.DialogLayout getDialogLayouts()
  {
    return presentation.layout;
  }
  
  public String getPresentationStyle()
  {
    return presentation.style;
  }
  
  public String getTemplateUrl()
  {
    return templateUrl;
  }
  
  public static class Presentation
  {
    public static final String STYLE_DIALOG = "dialog";
    public static final String STYLE_FULLSCREEN = "fullscreen";
    @JsonProperty("layout")
    DialogLayout layout;
    @JsonProperty("style")
    String style;
    
    public static class DialogLayout
    {
      @JsonProperty("landscape")
      public Dimensions landscape;
      @JsonProperty("portrait")
      public Dimensions portrait;
      
      public static class Dimensions
      {
        @JsonProperty("h")
        public int h;
        @JsonProperty("w")
        public int w;
        @JsonProperty("x")
        public int x;
        @JsonProperty("y")
        public int y;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */