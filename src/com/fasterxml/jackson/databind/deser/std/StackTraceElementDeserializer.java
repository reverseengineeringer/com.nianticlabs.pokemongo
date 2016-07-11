package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

public class StackTraceElementDeserializer
  extends StdScalarDeserializer<StackTraceElement>
{
  private static final long serialVersionUID = 1L;
  
  public StackTraceElementDeserializer()
  {
    super(StackTraceElement.class);
  }
  
  public StackTraceElement deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    Object localObject = paramJsonParser.getCurrentToken();
    if (localObject == JsonToken.START_OBJECT)
    {
      String str2 = "";
      localObject = "";
      String str1 = "";
      int i = -1;
      for (;;)
      {
        JsonToken localJsonToken = paramJsonParser.nextValue();
        if (localJsonToken == JsonToken.END_OBJECT) {
          break;
        }
        String str3 = paramJsonParser.getCurrentName();
        if ("className".equals(str3)) {
          str2 = paramJsonParser.getText();
        } else if ("fileName".equals(str3)) {
          str1 = paramJsonParser.getText();
        } else if ("lineNumber".equals(str3))
        {
          if (localJsonToken.isNumeric()) {
            i = paramJsonParser.getIntValue();
          } else {
            throw JsonMappingException.from(paramJsonParser, "Non-numeric token (" + localJsonToken + ") for property 'lineNumber'");
          }
        }
        else if ("methodName".equals(str3)) {
          localObject = paramJsonParser.getText();
        } else if (!"nativeMethod".equals(str3)) {
          handleUnknownProperty(paramJsonParser, paramDeserializationContext, _valueClass, str3);
        }
      }
      localObject = new StackTraceElement(str2, (String)localObject, str1, i);
    }
    do
    {
      return (StackTraceElement)localObject;
      if ((localObject != JsonToken.START_ARRAY) || (!paramDeserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS))) {
        break;
      }
      paramJsonParser.nextToken();
      localObject = deserialize(paramJsonParser, paramDeserializationContext);
    } while (paramJsonParser.nextToken() == JsonToken.END_ARRAY);
    throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'java.lang.StackTraceElement' value but there was more than a single value in the array");
    throw paramDeserializationContext.mappingException(_valueClass, (JsonToken)localObject);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.StackTraceElementDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */