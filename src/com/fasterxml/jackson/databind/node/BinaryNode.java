package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Arrays;

public class BinaryNode
  extends ValueNode
{
  static final BinaryNode EMPTY_BINARY_NODE = new BinaryNode(new byte[0]);
  protected final byte[] _data;
  
  public BinaryNode(byte[] paramArrayOfByte)
  {
    _data = paramArrayOfByte;
  }
  
  public BinaryNode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == paramArrayOfByte.length))
    {
      _data = paramArrayOfByte;
      return;
    }
    _data = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, _data, 0, paramInt2);
  }
  
  public static BinaryNode valueOf(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramArrayOfByte.length == 0) {
      return EMPTY_BINARY_NODE;
    }
    return new BinaryNode(paramArrayOfByte);
  }
  
  public static BinaryNode valueOf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if (paramInt2 == 0) {
      return EMPTY_BINARY_NODE;
    }
    return new BinaryNode(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public String asText()
  {
    return Base64Variants.getDefaultVariant().encode(_data, false);
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_EMBEDDED_OBJECT;
  }
  
  public byte[] binaryValue()
  {
    return _data;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (!(paramObject instanceof BinaryNode));
    return Arrays.equals(_data, _data);
  }
  
  public JsonNodeType getNodeType()
  {
    return JsonNodeType.BINARY;
  }
  
  public int hashCode()
  {
    if (_data == null) {
      return -1;
    }
    return _data.length;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeBinary(paramSerializerProvider.getConfig().getBase64Variant(), _data, 0, _data.length);
  }
  
  public String toString()
  {
    return Base64Variants.getDefaultVariant().encode(_data, true);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.BinaryNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */