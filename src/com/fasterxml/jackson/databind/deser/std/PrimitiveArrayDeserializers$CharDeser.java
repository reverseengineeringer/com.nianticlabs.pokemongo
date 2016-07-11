package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
final class PrimitiveArrayDeserializers$CharDeser
  extends PrimitiveArrayDeserializers<char[]>
{
  private static final long serialVersionUID = 1L;
  
  public PrimitiveArrayDeserializers$CharDeser()
  {
    super(char[].class);
  }
  
  public char[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    Object localObject1 = paramJsonParser.getCurrentToken();
    if (localObject1 == JsonToken.VALUE_STRING)
    {
      paramDeserializationContext = paramJsonParser.getTextCharacters();
      int i = paramJsonParser.getTextOffset();
      int j = paramJsonParser.getTextLength();
      paramJsonParser = new char[j];
      System.arraycopy(paramDeserializationContext, i, paramJsonParser, 0, j);
      return paramJsonParser;
    }
    if (paramJsonParser.isExpectedStartArrayToken())
    {
      localObject1 = new StringBuilder(64);
      for (;;)
      {
        Object localObject2 = paramJsonParser.nextToken();
        if (localObject2 == JsonToken.END_ARRAY) {
          break;
        }
        if (localObject2 != JsonToken.VALUE_STRING) {
          throw paramDeserializationContext.mappingException(Character.TYPE);
        }
        localObject2 = paramJsonParser.getText();
        if (((String)localObject2).length() != 1) {
          throw JsonMappingException.from(paramJsonParser, "Can not convert a JSON String of length " + ((String)localObject2).length() + " into a char element of char array");
        }
        ((StringBuilder)localObject1).append(((String)localObject2).charAt(0));
      }
      return ((StringBuilder)localObject1).toString().toCharArray();
    }
    if (localObject1 == JsonToken.VALUE_EMBEDDED_OBJECT)
    {
      paramJsonParser = paramJsonParser.getEmbeddedObject();
      if (paramJsonParser == null) {
        return null;
      }
      if ((paramJsonParser instanceof char[])) {
        return (char[])paramJsonParser;
      }
      if ((paramJsonParser instanceof String)) {
        return ((String)paramJsonParser).toCharArray();
      }
      if ((paramJsonParser instanceof byte[])) {
        return Base64Variants.getDefaultVariant().encode((byte[])paramJsonParser, false).toCharArray();
      }
    }
    throw paramDeserializationContext.mappingException(_valueClass);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers.CharDeser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */