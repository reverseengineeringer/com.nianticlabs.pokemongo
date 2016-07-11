package com.fasterxml.jackson.annotation;

public class JsonInclude$Value
  implements JacksonAnnotationValue<JsonInclude>
{
  protected static final Value EMPTY = new Value(JsonInclude.Include.USE_DEFAULTS, JsonInclude.Include.USE_DEFAULTS);
  protected final JsonInclude.Include contentInclusion;
  protected final JsonInclude.Include valueInclusion;
  
  protected JsonInclude$Value(JsonInclude.Include paramInclude1, JsonInclude.Include paramInclude2)
  {
    JsonInclude.Include localInclude = paramInclude1;
    if (paramInclude1 == null) {
      localInclude = JsonInclude.Include.USE_DEFAULTS;
    }
    valueInclusion = localInclude;
    paramInclude1 = paramInclude2;
    if (paramInclude2 == null) {
      paramInclude1 = JsonInclude.Include.USE_DEFAULTS;
    }
    contentInclusion = paramInclude1;
  }
  
  public JsonInclude$Value(JsonInclude paramJsonInclude)
  {
    this(paramJsonInclude.value(), paramJsonInclude.content());
  }
  
  public static Value construct(JsonInclude.Include paramInclude1, JsonInclude.Include paramInclude2)
  {
    if ((paramInclude1 == JsonInclude.Include.USE_DEFAULTS) && (paramInclude2 == JsonInclude.Include.USE_DEFAULTS)) {
      return EMPTY;
    }
    return new Value(paramInclude1, paramInclude2);
  }
  
  public static Value empty()
  {
    return EMPTY;
  }
  
  public static Value from(JsonInclude paramJsonInclude)
  {
    if (paramJsonInclude == null) {
      return null;
    }
    return new Value(paramJsonInclude);
  }
  
  public JsonInclude.Include getContentInclusion()
  {
    return contentInclusion;
  }
  
  public JsonInclude.Include getValueInclusion()
  {
    return valueInclusion;
  }
  
  public Class<JsonInclude> valueFor()
  {
    return JsonInclude.class;
  }
  
  public Value withContentInclusion(JsonInclude.Include paramInclude)
  {
    if (paramInclude == contentInclusion) {
      return this;
    }
    return new Value(valueInclusion, paramInclude);
  }
  
  public Value withOverrides(Value paramValue)
  {
    if (paramValue == null) {
      return this;
    }
    return withValueInclusion(valueInclusion).withContentInclusion(contentInclusion);
  }
  
  public Value withValueInclusion(JsonInclude.Include paramInclude)
  {
    if (paramInclude == valueInclusion) {
      return this;
    }
    return new Value(paramInclude, contentInclusion);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.annotation.JsonInclude.Value
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */