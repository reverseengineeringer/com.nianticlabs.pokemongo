package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public class NumberDeserializers$CharacterDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Character>
{
  static final CharacterDeserializer primitiveInstance = new CharacterDeserializer(Character.TYPE, Character.valueOf('\000'));
  private static final long serialVersionUID = 1L;
  static final CharacterDeserializer wrapperInstance = new CharacterDeserializer(Character.class, null);
  
  public NumberDeserializers$CharacterDeserializer(Class<Character> paramClass, Character paramCharacter)
  {
    super(paramClass, paramCharacter);
  }
  
  public Character deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    switch (paramJsonParser.getCurrentTokenId())
    {
    }
    do
    {
      do
      {
        int i;
        do
        {
          throw paramDeserializationContext.mappingException(_valueClass, paramJsonParser.getCurrentToken());
          i = paramJsonParser.getIntValue();
        } while ((i < 0) || (i > 65535));
        return Character.valueOf((char)i);
        localObject = paramJsonParser.getText();
        if (((String)localObject).length() == 1) {
          return Character.valueOf(((String)localObject).charAt(0));
        }
      } while (((String)localObject).length() != 0);
      return (Character)getEmptyValue(paramDeserializationContext);
    } while (!paramDeserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS));
    paramJsonParser.nextToken();
    Object localObject = deserialize(paramJsonParser, paramDeserializationContext);
    if (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
      throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single '" + _valueClass.getName() + "' value but there was more than a single value in the array");
    }
    return (Character)localObject;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.NumberDeserializers.CharacterDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */