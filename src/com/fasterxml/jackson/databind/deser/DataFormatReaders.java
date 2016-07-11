package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.format.InputAccessor.Std;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.MergedStream;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class DataFormatReaders
{
  public static final int DEFAULT_MAX_INPUT_LOOKAHEAD = 64;
  protected final int _maxInputLookahead;
  protected final MatchStrength _minimalMatch;
  protected final MatchStrength _optimalMatch;
  protected final ObjectReader[] _readers;
  
  public DataFormatReaders(Collection<ObjectReader> paramCollection)
  {
    this((ObjectReader[])paramCollection.toArray(new ObjectReader[paramCollection.size()]));
  }
  
  public DataFormatReaders(ObjectReader... paramVarArgs)
  {
    this(paramVarArgs, MatchStrength.SOLID_MATCH, MatchStrength.WEAK_MATCH, 64);
  }
  
  private DataFormatReaders(ObjectReader[] paramArrayOfObjectReader, MatchStrength paramMatchStrength1, MatchStrength paramMatchStrength2, int paramInt)
  {
    _readers = paramArrayOfObjectReader;
    _optimalMatch = paramMatchStrength1;
    _minimalMatch = paramMatchStrength2;
    _maxInputLookahead = paramInt;
  }
  
  private Match _findFormat(AccessorForReader paramAccessorForReader)
    throws IOException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    ObjectReader[] arrayOfObjectReader = _readers;
    int j = arrayOfObjectReader.length;
    int i = 0;
    Object localObject4 = localObject2;
    Object localObject3 = localObject1;
    if (i < j)
    {
      ObjectReader localObjectReader = arrayOfObjectReader[i];
      paramAccessorForReader.reset();
      MatchStrength localMatchStrength = localObjectReader.getFactory().hasFormat(paramAccessorForReader);
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (localMatchStrength != null)
      {
        if (localMatchStrength.ordinal() >= _minimalMatch.ordinal()) {
          break label103;
        }
        localObject4 = localObject1;
        localObject3 = localObject2;
      }
      label103:
      label129:
      do
      {
        do
        {
          i += 1;
          localObject2 = localObject3;
          localObject1 = localObject4;
          break;
          if (localObject2 == null) {
            break label129;
          }
          localObject3 = localObject2;
          localObject4 = localObject1;
        } while (((MatchStrength)localObject1).ordinal() >= localMatchStrength.ordinal());
        localObject1 = localObjectReader;
        localObject2 = localMatchStrength;
        localObject3 = localObject1;
        localObject4 = localObject2;
      } while (localMatchStrength.ordinal() < _optimalMatch.ordinal());
      localObject3 = localObject2;
      localObject4 = localObject1;
    }
    return paramAccessorForReader.createMatcher((ObjectReader)localObject4, (MatchStrength)localObject3);
  }
  
  public Match findFormat(InputStream paramInputStream)
    throws IOException
  {
    return _findFormat(new AccessorForReader(paramInputStream, new byte[_maxInputLookahead]));
  }
  
  public Match findFormat(byte[] paramArrayOfByte)
    throws IOException
  {
    return _findFormat(new AccessorForReader(paramArrayOfByte));
  }
  
  public Match findFormat(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return _findFormat(new AccessorForReader(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    int j = _readers.length;
    if (j > 0)
    {
      localStringBuilder.append(_readers[0].getFactory().getFormatName());
      int i = 1;
      while (i < j)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(_readers[i].getFactory().getFormatName());
        i += 1;
      }
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public DataFormatReaders with(DeserializationConfig paramDeserializationConfig)
  {
    int j = _readers.length;
    ObjectReader[] arrayOfObjectReader = new ObjectReader[j];
    int i = 0;
    while (i < j)
    {
      arrayOfObjectReader[i] = _readers[i].with(paramDeserializationConfig);
      i += 1;
    }
    return new DataFormatReaders(arrayOfObjectReader, _optimalMatch, _minimalMatch, _maxInputLookahead);
  }
  
  public DataFormatReaders with(ObjectReader[] paramArrayOfObjectReader)
  {
    return new DataFormatReaders(paramArrayOfObjectReader, _optimalMatch, _minimalMatch, _maxInputLookahead);
  }
  
  public DataFormatReaders withMaxInputLookahead(int paramInt)
  {
    if (paramInt == _maxInputLookahead) {
      return this;
    }
    return new DataFormatReaders(_readers, _optimalMatch, _minimalMatch, paramInt);
  }
  
  public DataFormatReaders withMinimalMatch(MatchStrength paramMatchStrength)
  {
    if (paramMatchStrength == _minimalMatch) {
      return this;
    }
    return new DataFormatReaders(_readers, _optimalMatch, paramMatchStrength, _maxInputLookahead);
  }
  
  public DataFormatReaders withOptimalMatch(MatchStrength paramMatchStrength)
  {
    if (paramMatchStrength == _optimalMatch) {
      return this;
    }
    return new DataFormatReaders(_readers, paramMatchStrength, _minimalMatch, _maxInputLookahead);
  }
  
  public DataFormatReaders withType(JavaType paramJavaType)
  {
    int j = _readers.length;
    ObjectReader[] arrayOfObjectReader = new ObjectReader[j];
    int i = 0;
    while (i < j)
    {
      arrayOfObjectReader[i] = _readers[i].forType(paramJavaType);
      i += 1;
    }
    return new DataFormatReaders(arrayOfObjectReader, _optimalMatch, _minimalMatch, _maxInputLookahead);
  }
  
  protected class AccessorForReader
    extends InputAccessor.Std
  {
    public AccessorForReader(InputStream paramInputStream, byte[] paramArrayOfByte)
    {
      super(paramArrayOfByte);
    }
    
    public AccessorForReader(byte[] paramArrayOfByte)
    {
      super();
    }
    
    public AccessorForReader(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    public DataFormatReaders.Match createMatcher(ObjectReader paramObjectReader, MatchStrength paramMatchStrength)
    {
      return new DataFormatReaders.Match(_in, _buffer, _bufferedStart, _bufferedEnd - _bufferedStart, paramObjectReader, paramMatchStrength);
    }
  }
  
  public static class Match
  {
    protected final byte[] _bufferedData;
    protected final int _bufferedLength;
    protected final int _bufferedStart;
    protected final ObjectReader _match;
    protected final MatchStrength _matchStrength;
    protected final InputStream _originalStream;
    
    protected Match(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ObjectReader paramObjectReader, MatchStrength paramMatchStrength)
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
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.DataFormatReaders
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */