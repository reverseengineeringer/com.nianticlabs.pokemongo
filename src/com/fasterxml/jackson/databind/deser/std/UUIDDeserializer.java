package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

public class UUIDDeserializer
  extends FromStringDeserializer<UUID>
{
  static final int[] HEX_DIGITS = new int[127];
  private static final long serialVersionUID = 1L;
  
  static
  {
    Arrays.fill(HEX_DIGITS, -1);
    int i = 0;
    while (i < 10)
    {
      HEX_DIGITS[(i + 48)] = i;
      i += 1;
    }
    i = 0;
    while (i < 6)
    {
      HEX_DIGITS[(i + 97)] = (i + 10);
      HEX_DIGITS[(i + 65)] = (i + 10);
      i += 1;
    }
  }
  
  public UUIDDeserializer()
  {
    super(UUID.class);
  }
  
  static int _badChar(String paramString, int paramInt, char paramChar)
  {
    throw new NumberFormatException("Non-hex character '" + paramChar + "', not valid character for a UUID String" + "' (value 0x" + Integer.toHexString(paramChar) + ") for UUID String \"" + paramString + "\"");
  }
  
  private void _badFormat(String paramString)
  {
    throw new NumberFormatException("UUID has to be represented by the standard 36-char representation");
  }
  
  private UUID _fromBytes(byte[] paramArrayOfByte, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (paramArrayOfByte.length != 16) {
      paramDeserializationContext.mappingException("Can only construct UUIDs from byte[16]; got %d bytes", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    }
    return new UUID(_long(paramArrayOfByte, 0), _long(paramArrayOfByte, 8));
  }
  
  private static int _int(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF;
  }
  
  private static long _long(byte[] paramArrayOfByte, int paramInt)
  {
    return _int(paramArrayOfByte, paramInt) << 32 | _int(paramArrayOfByte, paramInt + 4) << 32 >>> 32;
  }
  
  static int byteFromChars(String paramString, int paramInt)
  {
    char c1 = paramString.charAt(paramInt);
    char c2 = paramString.charAt(paramInt + 1);
    if ((c1 <= '') && (c2 <= ''))
    {
      int i = HEX_DIGITS[c1] << 4 | HEX_DIGITS[c2];
      if (i >= 0) {
        return i;
      }
    }
    if ((c1 > '') || (HEX_DIGITS[c1] < 0)) {
      return _badChar(paramString, paramInt, c1);
    }
    return _badChar(paramString, paramInt + 1, c2);
  }
  
  static int intFromChars(String paramString, int paramInt)
  {
    return (byteFromChars(paramString, paramInt) << 24) + (byteFromChars(paramString, paramInt + 2) << 16) + (byteFromChars(paramString, paramInt + 4) << 8) + byteFromChars(paramString, paramInt + 6);
  }
  
  static int shortFromChars(String paramString, int paramInt)
  {
    return (byteFromChars(paramString, paramInt) << 8) + byteFromChars(paramString, paramInt + 2);
  }
  
  protected UUID _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (paramString.length() != 36)
    {
      if (paramString.length() == 24) {
        return _fromBytes(Base64Variants.getDefaultVariant().decode(paramString), paramDeserializationContext);
      }
      _badFormat(paramString);
    }
    if ((paramString.charAt(8) != '-') || (paramString.charAt(13) != '-') || (paramString.charAt(18) != '-') || (paramString.charAt(23) != '-')) {
      _badFormat(paramString);
    }
    return new UUID((intFromChars(paramString, 0) << 32) + (shortFromChars(paramString, 9) << 16 | shortFromChars(paramString, 14)), (shortFromChars(paramString, 19) << 16 | shortFromChars(paramString, 24)) << 32 | intFromChars(paramString, 28) << 32 >>> 32);
  }
  
  protected UUID _deserializeEmbedded(Object paramObject, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if ((paramObject instanceof byte[])) {
      return _fromBytes((byte[])paramObject, paramDeserializationContext);
    }
    super._deserializeEmbedded(paramObject, paramDeserializationContext);
    return null;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.UUIDDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */