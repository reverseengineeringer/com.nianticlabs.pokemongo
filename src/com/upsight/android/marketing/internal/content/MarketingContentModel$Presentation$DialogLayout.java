package com.upsight.android.marketing.internal.content;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketingContentModel$Presentation$DialogLayout
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

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentModel.Presentation.DialogLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */