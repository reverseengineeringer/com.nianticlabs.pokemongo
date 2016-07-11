package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.MergedStream;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataFormatReaders$Match
{
  protected final byte[] _bufferedData;
  protected final int _bufferedLength;
  protected final int _bufferedStart;
  protected final ObjectReader _match;
  protected final MatchStrength _matchStrength;
  protected final InputStream _originalStream;
  
  protected DataFormatReaders$Match(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ObjectReader paramObjectReader, MatchStrength paramMatchStrength)
  {
    _originalStream = paramInputStream;
    _bufferedData = paramArrayOfByte;
    _bufferedStart = paramInt1;
    _bufferedLength = paramInt2;
    _match = paramObjectReader;
    _matchStrength = paramMatchStrength;
  }
  
  public JsonParser createParserWithMatch()
    throws IOException
  {
    if (_match == null) {
      return null;
    }
    JsonFactory localJsonFactory = _match.getFactory();
    if (_originalStream == null) {
      return localJsonFactory.createParser(_bufferedData, _bufferedStart, _bufferedLength);
    }
    return localJsonFactory.createParser(getDataStream());
  }
  
  public InputStream getDataStream()
  {
    if (_originalStream == null) {
      return new ByteArrayInputStream(_bufferedData, _bufferedStart, _bufferedLength);
    }
    return new MergedStream(null, _originalStream, _bufferedData, _bufferedStart, _bufferedLength);
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
    return _match.getFactory().getFormatName();
  }
  
  public ObjectReader getReader()
  {
    return _match;
  }
  
  public boolean hasMatch()
  {
    return _match != null;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.DataFormatReaders.Match
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */