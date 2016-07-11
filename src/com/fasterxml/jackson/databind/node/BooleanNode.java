package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class BooleanNode
  extends ValueNode
{
  public static final BooleanNode FALSE = new BooleanNode(false);
  public static final BooleanNode TRUE = new BooleanNode(true);
  private final boolean _value;
  
  private BooleanNode(boolean paramBoolean)
  {
    _value = paramBoolean;
  }
  
  public static BooleanNode getFalse()
  {
    return FALSE;
  }
  
  public static BooleanNode getTrue()
  {
    return TRUE;
  }
  
  public static BooleanNode valueOf(boolean paramBoolean)
  {
    if (paramBoolean) {
      return TRUE;
    }
    return FALSE;
  }
  
  public boolean asBoolean()
  {
    return _value;
  }
  
  public boolean asBoolean(boolean paramBoolean)
  {
    return _value;
  }
  
  public double asDouble(double paramDouble)
  {
    if (_value) {
      return 1.0D;
    }
    return 0.0D;
  }
  
  public int asInt(int paramInt)
  {
    if (_value) {
      return 1;
    }
    return 0;
  }
  
  public long asLong(long paramLong)
  {
    if (_value) {
      return 1L;
    }
    return 0L;
  }
  
  public String asText()
  {
    if (_value) {
      return "true";
    }
    return "false";
  }
  
  public JsonToken asToken()
  {
    if (_value) {
      return JsonToken.VALUE_TRUE;
    }
    return JsonToken.VALUE_FALSE;
  }
  
  public boolean booleanValue()
  {
    return _value;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof BooleanNode)) {
        return false;
      }
    } while (_value == _value);
    return false;
  }
  
  public JsonNodeType getNodeType()
  {
    return JsonNodeType.BOOLEAN;
  }
  
  public int hashCode()
  {
    if (_value) {
      return 3;
    }
    return 1;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    paramJsonGenerator.writeBoolean(_value);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.BooleanNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */