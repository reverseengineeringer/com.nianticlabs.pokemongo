package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;

public abstract class JsonGeneratorImpl
  extends GeneratorBase
{
  protected static final int[] sOutputEscapes = ;
  protected CharacterEscapes _characterEscapes;
  protected final IOContext _ioContext;
  protected int _maximumNonEscapedChar;
  protected int[] _outputEscapes = sOutputEscapes;
  protected SerializableString _rootValueSeparator = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
  
  public JsonGeneratorImpl(IOContext paramIOContext, int paramInt, ObjectCodec paramObjectCodec)
  {
    super(paramInt, paramObjectCodec);
    _ioContext = paramIOContext;
    if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
      setHighestNonEscapedChar(127);
    }
  }
  
  public CharacterEscapes getCharacterEscapes()
  {
    return _characterEscapes;
  }
  
  public int getHighestEscapedChar()
  {
    return _maximumNonEscapedChar;
  }
  
  public JsonGenerator setCharacterEscapes(CharacterEscapes paramCharacterEscapes)
  {
    _characterEscapes = paramCharacterEscapes;
    if (paramCharacterEscapes == null)
    {
      _outputEscapes = sOutputEscapes;
      return this;
    }
    _outputEscapes = paramCharacterEscapes.getEscapeCodesForAscii();
    return this;
  }
  
  public JsonGenerator setHighestNonEscapedChar(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    _maximumNonEscapedChar = i;
    return this;
  }
  
  public JsonGenerator setRootValueSeparator(SerializableString paramSerializableString)
  {
    _rootValueSeparator = paramSerializableString;
    return this;
  }
  
  public Version version()
  {
    return VersionUtil.versionFor(getClass());
  }
  
  public final void writeStringField(String paramString1, String paramString2)
    throws IOException
  {
    writeFieldName(paramString1);
    writeString(paramString2);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.json.JsonGeneratorImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */