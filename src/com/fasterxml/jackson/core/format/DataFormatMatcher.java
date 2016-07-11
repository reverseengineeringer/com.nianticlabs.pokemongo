package com.fasterxml.jackson.core.format;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.MergedStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataFormatMatcher
{
  protected final byte[] _bufferedData;
  protected final int _bufferedLength;
  protected final int _bufferedStart;
  protected final JsonFactory _match;
  protected final MatchStrength _matchStrength;
  protected final InputStream _originalStream;
  
  protected DataFormatMatcher(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, JsonFactory paramJsonFactory, MatchStrength paramMatchStrength)
  {
    _originalStream = paramInputStream;
    _bufferedData = paramArrayOfByte;
    _bufferedStart = paramInt1;
    _bufferedLength = paramInt2;
    _match = paramJsonFactory;
    _matchStrength = paramMatchStrength;
  }
  
  public JsonParser createParserWithMatch()
    throws IOException
  {
    if (_match == null) {
      return null;
    }
    if (_originalStream == null) {
      return _match.createParser(_bufferedData, _bufferedStart, _bufferedLength);
    }
    return _match.createParser(getDataStream());
  }
  
  public InputStream getDataStream()
  {
    if (_originalStream == null) {
      return new ByteArrayInputStream(_bufferedData, _bufferedStart, _bufferedLength);
    }
    return new MergedStream(null, _originalStream, _bufferedData, _bufferedStart, _bufferedLength);
  }
  
  public JsonFactory getMatch()
  {
    return _match;
  }
  
  public MatchStrength getMatchStrength()
  {
    if (_matchStrength == null) {
      return MatchStrength.INCONCLUSIVE;
    }
    return _matchStrength;
  }
  
  public String getMatchedFormatName()
  {
    return _match.getFormatName();
  }
  
  public boolean hasMatch()
  {
    return _match != null;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.format.DataFormatMatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */