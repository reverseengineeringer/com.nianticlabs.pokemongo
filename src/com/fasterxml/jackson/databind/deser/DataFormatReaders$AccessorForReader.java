package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.format.InputAccessor.Std;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.databind.ObjectReader;
import java.io.InputStream;

public class DataFormatReaders$AccessorForReader
  extends InputAccessor.Std
{
  public DataFormatReaders$AccessorForReader(DataFormatReaders paramDataFormatReaders, InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    super(paramInputStream, paramArrayOfByte);
  }
  
  public DataFormatReaders$AccessorForReader(DataFormatReaders paramDataFormatReaders, byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public DataFormatReaders$AccessorForReader(DataFormatReaders paramDataFormatReaders, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public DataFormatReaders.Match createMatcher(ObjectReader paramObjectReader, MatchStrength paramMatchStrength)
  {
    return new DataFormatReaders.Match(_in, _buffer, _bufferedStart, _bufferedEnd - _bufferedStart, paramObjectReader, paramMatchStrength);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.DataFormatReaders.AccessorForReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */