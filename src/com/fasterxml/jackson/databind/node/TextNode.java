package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class TextNode
  extends ValueNode
{
  static final TextNode EMPTY_STRING_NODE = new TextNode("");
  protected final String _value;
  
  public TextNode(String paramString)
  {
    _value = paramString;
  }
  
  protected static void appendQuoted(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"');
    CharTypes.appendQuoted(paramStringBuilder, paramString);
    paramStringBuilder.append('"');
  }
  
  public static TextNode valueOf(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.length() == 0) {
      return EMPTY_STRING_NODE;
    }
    return new TextNode(paramString);
  }
  
  protected void _reportBase64EOF()
    throws JsonParseException
  {
    throw new JsonParseException("Unexpected end-of-String when base64 content", JsonLocation.NA);
  }
  
  protected void _reportInvalidBase64(Base64Variant paramBase64Variant, char paramChar, int paramInt)
    throws JsonParseException
  {
    _reportInvalidBase64(paramBase64Variant, paramChar, paramInt, null);
  }
  
  protected void _reportInvalidBase64(Base64Variant paramBase64Variant, char paramChar, int paramInt, String paramString)
    throws JsonParseException
  {
    if (paramChar <= ' ') {
      paramBase64Variant = "Illegal white space character (code 0x" + Integer.toHexString(paramChar) + ") as character #" + (paramInt + 1) + " of 4-char base64 unit: can only used between units";
    }
    for (;;)
    {
      Object localObject = paramBase64Variant;
      if (paramString != null) {
        localObject = paramBase64Variant + ": " + paramString;
      }
      throw new JsonParseException((String)localObject, JsonLocation.NA);
      if (paramBase64Variant.usesPaddingChar(paramChar)) {
        paramBase64Variant = "Unexpected padding character ('" + paramBase64Variant.getPaddingChar() + "') as character #" + (paramInt + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
      } else if ((!Character.isDefined(paramChar)) || (Character.isISOControl(paramChar))) {
        paramBase64Variant = "Illegal character (code 0x" + Integer.toHexString(paramChar) + ") in base64 content";
      } else {
        paramBase64Variant = "Illegal character '" + paramChar + "' (code 0x" + Integer.toHexString(paramChar) + ") in base64 content";
      }
    }
  }
  
  public boolean asBoolean(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    String str;
    if (_value != null)
    {
      str = _value.trim();
      if (!"true".equals(str)) {
        break label30;
      }
      bool = true;
    }
    label30:
    do
    {
      return bool;
      bool = paramBoolean;
    } while (!"false".equals(str));
    return false;
  }
  
  public double asDouble(double paramDouble)
  {
    return NumberInput.parseAsDouble(_value, paramDouble);
  }
  
  public int asInt(int paramInt)
  {
    return NumberInput.parseAsInt(_value, paramInt);
  }
  
  public long asLong(long paramLong)
  {
    return NumberInput.parseAsLong(_value, paramLong);
  }
  
  public String asText()
  {
    return _value;
  }
  
  public String asText(String paramString)
  {
    if (_value == null) {
      return paramString;
    }
    return _value;
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_STRING;
  }
  
  public byte[] binaryValue()
    throws IOException
  {
    return getBinaryValue(Base64Variants.getDefaultVariant());
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
    } while (!(paramObject instanceof TextNode));
    return _value.equals(_value);
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
    throws IOException
  {
    ByteArrayBuilder localByteArrayBuilder = new ByteArrayBuilder(100);
    String str = _value;
    int i = 0;
    int k = str.length();
    if (i < k) {}
    for (;;)
    {
      int j = i + 1;
      char c = str.charAt(i);
      if (j >= k) {}
      int m;
      for (;;)
      {
        return localByteArrayBuilder.toByteArray();
        if (c <= ' ') {
          break label383;
        }
        m = paramBase64Variant.decodeBase64Char(c);
        if (m < 0) {
          _reportInvalidBase64(paramBase64Variant, c, 0);
        }
        if (j >= k) {
          _reportBase64EOF();
        }
        i = j + 1;
        c = str.charAt(j);
        j = paramBase64Variant.decodeBase64Char(c);
        if (j < 0) {
          _reportInvalidBase64(paramBase64Variant, c, 1);
        }
        m = m << 6 | j;
        if (i >= k)
        {
          if (!paramBase64Variant.usesPadding()) {
            localByteArrayBuilder.append(m >> 4);
          } else {
            _reportBase64EOF();
          }
        }
        else
        {
          j = i + 1;
          c = str.charAt(i);
          i = paramBase64Variant.decodeBase64Char(c);
          if (i < 0)
          {
            if (i != -2) {
              _reportInvalidBase64(paramBase64Variant, c, 2);
            }
            if (j >= k) {
              _reportBase64EOF();
            }
            i = j + 1;
            c = str.charAt(j);
            if (!paramBase64Variant.usesPaddingChar(c)) {
              _reportInvalidBase64(paramBase64Variant, c, 3, "expected padding character '" + paramBase64Variant.getPaddingChar() + "'");
            }
            localByteArrayBuilder.append(m >> 4);
            break;
          }
          m = m << 6 | i;
          if (j < k) {
            break label316;
          }
          if (paramBase64Variant.usesPadding()) {
            break label312;
          }
          localByteArrayBuilder.appendTwoBytes(m >> 2);
        }
      }
      label312:
      _reportBase64EOF();
      label316:
      i = j + 1;
      c = str.charAt(j);
      j = paramBase64Variant.decodeBase64Char(c);
      if (j < 0)
      {
        if (j != -2) {
          _reportInvalidBase64(paramBase64Variant, c, 3);
        }
        localByteArrayBuilder.appendTwoBytes(m >> 2);
        break;
      }
      localByteArrayBuilder.appendThreeBytes(m << 6 | j);
      break;
      label383:
      i = j;
    }
  }
  
  public JsonNodeType getNodeType()
  {
    return JsonNodeType.STRING;
  }
  
  public int hashCode()
  {
    return _value.hashCode();
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    if (_value == null)
    {
      paramJsonGenerator.writeNull();
      return;
    }
    paramJsonGenerator.writeString(_value);
  }
  
  public String textValue()
  {
    return _value;
  }
  
  public String toString()
  {
    int i = _value.length();
    StringBuilder localStringBuilder = new StringBuilder(i + 2 + (i >> 4));
    appendQuoted(localStringBuilder, _value);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.TextNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */