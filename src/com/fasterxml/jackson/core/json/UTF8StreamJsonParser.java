package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class UTF8StreamJsonParser
  extends ParserBase
{
  static final byte BYTE_LF = 10;
  protected static final int[] _icLatin1 = CharTypes.getInputCodeLatin1();
  private static final int[] _icUTF8 = ;
  protected boolean _bufferRecyclable;
  protected byte[] _inputBuffer;
  protected InputStream _inputStream;
  protected ObjectCodec _objectCodec;
  private int _quad1;
  protected int[] _quadBuffer = new int[16];
  protected final ByteQuadsCanonicalizer _symbols;
  protected boolean _tokenIncomplete = false;
  
  public UTF8StreamJsonParser(IOContext paramIOContext, int paramInt1, InputStream paramInputStream, ObjectCodec paramObjectCodec, ByteQuadsCanonicalizer paramByteQuadsCanonicalizer, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramIOContext, paramInt1);
    _inputStream = paramInputStream;
    _objectCodec = paramObjectCodec;
    _symbols = paramByteQuadsCanonicalizer;
    _inputBuffer = paramArrayOfByte;
    _inputPtr = paramInt2;
    _inputEnd = paramInt3;
    _currInputRowStart = paramInt2;
    _currInputProcessed = (-paramInt2);
    _bufferRecyclable = paramBoolean;
  }
  
  private final void _checkMatchEnd(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (Character.isJavaIdentifierPart((char)_decodeCharForError(paramInt2))) {
      _reportInvalidToken(paramString.substring(0, paramInt1));
    }
  }
  
  private final int _decodeUtf8_2(int paramInt)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    return (paramInt & 0x1F) << 6 | i & 0x3F;
  }
  
  private final int _decodeUtf8_3(int paramInt)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    int j = _inputPtr;
    _inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, _inputPtr);
    }
    return ((paramInt & 0xF) << 6 | i & 0x3F) << 6 | j & 0x3F;
  }
  
  private final int _decodeUtf8_3fast(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    arrayOfByte = _inputBuffer;
    int j = _inputPtr;
    _inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, _inputPtr);
    }
    return ((paramInt & 0xF) << 6 | i & 0x3F) << 6 | j & 0x3F;
  }
  
  private final int _decodeUtf8_4(int paramInt)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    int j = _inputPtr;
    _inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    int k = _inputPtr;
    _inputPtr = (k + 1);
    k = arrayOfByte[k];
    if ((k & 0xC0) != 128) {
      _reportInvalidOther(k & 0xFF, _inputPtr);
    }
    return ((((paramInt & 0x7) << 6 | i & 0x3F) << 6 | j & 0x3F) << 6 | k & 0x3F) - 65536;
  }
  
  private final void _finishString2(char[] paramArrayOfChar, int paramInt)
    throws IOException
  {
    int[] arrayOfInt = _icUTF8;
    byte[] arrayOfByte = _inputBuffer;
    int j;
    int i;
    for (char[] arrayOfChar = paramArrayOfChar;; arrayOfChar = paramArrayOfChar)
    {
      j = _inputPtr;
      i = j;
      if (j >= _inputEnd)
      {
        loadMoreGuaranteed();
        i = _inputPtr;
      }
      paramArrayOfChar = arrayOfChar;
      j = paramInt;
      if (paramInt >= arrayOfChar.length)
      {
        paramArrayOfChar = _textBuffer.finishCurrentSegment();
        j = 0;
      }
      int k = Math.min(_inputEnd, paramArrayOfChar.length - j + i);
      paramInt = j;
      while (i < k)
      {
        j = i + 1;
        i = arrayOfByte[i] & 0xFF;
        if (arrayOfInt[i] != 0)
        {
          _inputPtr = j;
          if (i != 34) {
            break label158;
          }
          _textBuffer.setCurrentLength(paramInt);
          return;
        }
        paramArrayOfChar[paramInt] = ((char)i);
        i = j;
        paramInt += 1;
      }
      _inputPtr = i;
    }
    label158:
    switch (arrayOfInt[i])
    {
    default: 
      if (i < 32) {
        _throwUnquotedSpace(i, "string value");
      }
      break;
    }
    for (;;)
    {
      arrayOfChar = paramArrayOfChar;
      j = paramInt;
      if (paramInt >= paramArrayOfChar.length)
      {
        arrayOfChar = _textBuffer.finishCurrentSegment();
        j = 0;
      }
      arrayOfChar[j] = ((char)i);
      paramInt = j + 1;
      break;
      i = _decodeEscaped();
      continue;
      i = _decodeUtf8_2(i);
      continue;
      if (_inputEnd - _inputPtr >= 2)
      {
        i = _decodeUtf8_3fast(i);
      }
      else
      {
        i = _decodeUtf8_3(i);
        continue;
        j = _decodeUtf8_4(i);
        i = paramInt + 1;
        paramArrayOfChar[paramInt] = ((char)(0xD800 | j >> 10));
        arrayOfChar = paramArrayOfChar;
        paramInt = i;
        if (i >= paramArrayOfChar.length)
        {
          arrayOfChar = _textBuffer.finishCurrentSegment();
          paramInt = 0;
        }
        i = 0xDC00 | j & 0x3FF;
        paramArrayOfChar = arrayOfChar;
        continue;
        _reportInvalidChar(i);
      }
    }
  }
  
  private final boolean _isNextTokenNameMaybe(int paramInt, SerializableString paramSerializableString)
    throws IOException
  {
    String str = _parseName(paramInt);
    _parsingContext.setCurrentName(str);
    boolean bool = str.equals(paramSerializableString.getValue());
    _currToken = JsonToken.FIELD_NAME;
    paramInt = _skipColon();
    if (paramInt == 34)
    {
      _tokenIncomplete = true;
      _nextToken = JsonToken.VALUE_STRING;
      return bool;
    }
    switch (paramInt)
    {
    default: 
      paramSerializableString = _handleUnexpectedValue(paramInt);
    }
    for (;;)
    {
      _nextToken = paramSerializableString;
      return bool;
      paramSerializableString = JsonToken.START_ARRAY;
      continue;
      paramSerializableString = JsonToken.START_OBJECT;
      continue;
      _matchToken("true", 1);
      paramSerializableString = JsonToken.VALUE_TRUE;
      continue;
      _matchToken("false", 1);
      paramSerializableString = JsonToken.VALUE_FALSE;
      continue;
      _matchToken("null", 1);
      paramSerializableString = JsonToken.VALUE_NULL;
      continue;
      paramSerializableString = _parseNegNumber();
      continue;
      paramSerializableString = _parsePosNumber(paramInt);
    }
  }
  
  private final void _isNextTokenNameYes(int paramInt)
    throws IOException
  {
    _currToken = JsonToken.FIELD_NAME;
    switch (paramInt)
    {
    default: 
      _nextToken = _handleUnexpectedValue(paramInt);
      return;
    case 34: 
      _tokenIncomplete = true;
      _nextToken = JsonToken.VALUE_STRING;
      return;
    case 91: 
      _nextToken = JsonToken.START_ARRAY;
      return;
    case 123: 
      _nextToken = JsonToken.START_OBJECT;
      return;
    case 116: 
      _matchToken("true", 1);
      _nextToken = JsonToken.VALUE_TRUE;
      return;
    case 102: 
      _matchToken("false", 1);
      _nextToken = JsonToken.VALUE_FALSE;
      return;
    case 110: 
      _matchToken("null", 1);
      _nextToken = JsonToken.VALUE_NULL;
      return;
    case 45: 
      _nextToken = _parseNegNumber();
      return;
    }
    _nextToken = _parsePosNumber(paramInt);
  }
  
  private final void _matchToken2(String paramString, int paramInt)
    throws IOException
  {
    int j = paramString.length();
    int i;
    do
    {
      if (((_inputPtr >= _inputEnd) && (!loadMore())) || (_inputBuffer[_inputPtr] != paramString.charAt(paramInt))) {
        _reportInvalidToken(paramString.substring(0, paramInt));
      }
      _inputPtr += 1;
      i = paramInt + 1;
      paramInt = i;
    } while (i < j);
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {}
    do
    {
      return;
      paramInt = _inputBuffer[_inputPtr] & 0xFF;
    } while ((paramInt < 48) || (paramInt == 93) || (paramInt == 125));
    _checkMatchEnd(paramString, i, paramInt);
  }
  
  private final JsonToken _nextAfterName()
  {
    _nameCopied = false;
    JsonToken localJsonToken = _nextToken;
    _nextToken = null;
    if (localJsonToken == JsonToken.START_ARRAY) {
      _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
    }
    for (;;)
    {
      _currToken = localJsonToken;
      return localJsonToken;
      if (localJsonToken == JsonToken.START_OBJECT) {
        _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
      }
    }
  }
  
  private final JsonToken _nextTokenNotInObject(int paramInt)
    throws IOException
  {
    if (paramInt == 34)
    {
      _tokenIncomplete = true;
      localJsonToken = JsonToken.VALUE_STRING;
      _currToken = localJsonToken;
      return localJsonToken;
    }
    switch (paramInt)
    {
    default: 
      localJsonToken = _handleUnexpectedValue(paramInt);
      _currToken = localJsonToken;
      return localJsonToken;
    case 91: 
      _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
      localJsonToken = JsonToken.START_ARRAY;
      _currToken = localJsonToken;
      return localJsonToken;
    case 123: 
      _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
      localJsonToken = JsonToken.START_OBJECT;
      _currToken = localJsonToken;
      return localJsonToken;
    case 116: 
      _matchToken("true", 1);
      localJsonToken = JsonToken.VALUE_TRUE;
      _currToken = localJsonToken;
      return localJsonToken;
    case 102: 
      _matchToken("false", 1);
      localJsonToken = JsonToken.VALUE_FALSE;
      _currToken = localJsonToken;
      return localJsonToken;
    case 110: 
      _matchToken("null", 1);
      localJsonToken = JsonToken.VALUE_NULL;
      _currToken = localJsonToken;
      return localJsonToken;
    case 45: 
      localJsonToken = _parseNegNumber();
      _currToken = localJsonToken;
      return localJsonToken;
    }
    JsonToken localJsonToken = _parsePosNumber(paramInt);
    _currToken = localJsonToken;
    return localJsonToken;
  }
  
  private final JsonToken _parseFloat(char[] paramArrayOfChar, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    throws IOException
  {
    int i1 = 0;
    int n = 0;
    int i = 0;
    int i2 = 0;
    Object localObject = paramArrayOfChar;
    int j = paramInt1;
    int k = paramInt2;
    if (paramInt2 == 46)
    {
      paramArrayOfChar[paramInt1] = ((char)paramInt2);
      paramInt1 += 1;
      m = paramInt2;
      paramInt2 = n;
      if ((_inputPtr < _inputEnd) || (loadMore())) {
        break label493;
      }
      n = 1;
      label63:
      i = n;
      i1 = paramInt2;
      localObject = paramArrayOfChar;
      j = paramInt1;
      k = m;
      if (paramInt2 == 0)
      {
        reportUnexpectedNumberChar(m, "Decimal point not followed by a digit");
        k = m;
        j = paramInt1;
        localObject = paramArrayOfChar;
        i1 = paramInt2;
        i = n;
      }
    }
    int m = 0;
    n = 0;
    int i3;
    if (k != 101)
    {
      paramInt1 = i;
      i2 = j;
      i3 = k;
      if (k != 69) {}
    }
    else
    {
      paramArrayOfChar = (char[])localObject;
      paramInt2 = j;
      if (j >= localObject.length)
      {
        paramArrayOfChar = _textBuffer.finishCurrentSegment();
        paramInt2 = 0;
      }
      paramInt1 = paramInt2 + 1;
      paramArrayOfChar[paramInt2] = ((char)k);
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      localObject = _inputBuffer;
      paramInt2 = _inputPtr;
      _inputPtr = (paramInt2 + 1);
      paramInt2 = localObject[paramInt2] & 0xFF;
      if ((paramInt2 != 45) && (paramInt2 != 43)) {
        break label643;
      }
      if (paramInt1 < paramArrayOfChar.length) {
        break label640;
      }
      paramArrayOfChar = _textBuffer.finishCurrentSegment();
      paramInt1 = 0;
      label245:
      paramArrayOfChar[paramInt1] = ((char)paramInt2);
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      localObject = _inputBuffer;
      paramInt2 = _inputPtr;
      _inputPtr = (paramInt2 + 1);
      paramInt2 = localObject[paramInt2] & 0xFF;
      paramInt1 += 1;
      m = n;
    }
    for (;;)
    {
      n = i;
      k = m;
      j = paramInt1;
      if (paramInt2 <= 57)
      {
        n = i;
        k = m;
        j = paramInt1;
        if (paramInt2 >= 48)
        {
          k = m + 1;
          localObject = paramArrayOfChar;
          j = paramInt1;
          if (paramInt1 >= paramArrayOfChar.length)
          {
            localObject = _textBuffer.finishCurrentSegment();
            j = 0;
          }
          paramInt1 = j + 1;
          localObject[j] = ((char)paramInt2);
          if ((_inputPtr < _inputEnd) || (loadMore())) {
            break label605;
          }
          n = 1;
          j = paramInt1;
        }
      }
      paramInt1 = n;
      m = k;
      i2 = j;
      i3 = paramInt2;
      if (k == 0)
      {
        reportUnexpectedNumberChar(paramInt2, "Exponent indicator not followed by a digit");
        i3 = paramInt2;
        i2 = j;
        m = k;
        paramInt1 = n;
      }
      if (paramInt1 == 0)
      {
        _inputPtr -= 1;
        if (_parsingContext.inRoot()) {
          _verifyRootSpace(i3);
        }
      }
      _textBuffer.setCurrentLength(i2);
      return resetFloat(paramBoolean, paramInt3, i1, m);
      label493:
      localObject = _inputBuffer;
      i = _inputPtr;
      _inputPtr = (i + 1);
      i = localObject[i] & 0xFF;
      n = i2;
      m = i;
      if (i < 48) {
        break label63;
      }
      n = i2;
      m = i;
      if (i > 57) {
        break label63;
      }
      j = paramInt2 + 1;
      localObject = paramArrayOfChar;
      paramInt2 = paramInt1;
      if (paramInt1 >= paramArrayOfChar.length)
      {
        localObject = _textBuffer.finishCurrentSegment();
        paramInt2 = 0;
      }
      localObject[paramInt2] = ((char)i);
      paramInt1 = paramInt2 + 1;
      paramInt2 = j;
      paramArrayOfChar = (char[])localObject;
      m = i;
      break;
      label605:
      paramArrayOfChar = _inputBuffer;
      paramInt2 = _inputPtr;
      _inputPtr = (paramInt2 + 1);
      paramInt2 = paramArrayOfChar[paramInt2] & 0xFF;
      m = k;
      paramArrayOfChar = (char[])localObject;
      continue;
      label640:
      break label245;
      label643:
      m = n;
    }
  }
  
  private final JsonToken _parseNumber2(char[] paramArrayOfChar, int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException
  {
    for (;;)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore()))
      {
        _textBuffer.setCurrentLength(paramInt1);
        return resetInt(paramBoolean, paramInt2);
      }
      Object localObject = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      int j = localObject[i] & 0xFF;
      if ((j > 57) || (j < 48))
      {
        if ((j != 46) && (j != 101) && (j != 69)) {
          break;
        }
        return _parseFloat(paramArrayOfChar, paramInt1, j, paramBoolean, paramInt2);
      }
      localObject = paramArrayOfChar;
      i = paramInt1;
      if (paramInt1 >= paramArrayOfChar.length)
      {
        localObject = _textBuffer.finishCurrentSegment();
        i = 0;
      }
      localObject[i] = ((char)j);
      paramInt2 += 1;
      paramInt1 = i + 1;
      paramArrayOfChar = (char[])localObject;
    }
    _inputPtr -= 1;
    _textBuffer.setCurrentLength(paramInt1);
    if (_parsingContext.inRoot())
    {
      paramArrayOfChar = _inputBuffer;
      paramInt1 = _inputPtr;
      _inputPtr = (paramInt1 + 1);
      _verifyRootSpace(paramArrayOfChar[paramInt1] & 0xFF);
    }
    return resetInt(paramBoolean, paramInt2);
  }
  
  private final void _skipCComment()
    throws IOException
  {
    int[] arrayOfInt = CharTypes.getInputCodeComment();
    for (;;)
    {
      int i;
      int j;
      if ((_inputPtr < _inputEnd) || (loadMore()))
      {
        byte[] arrayOfByte = _inputBuffer;
        i = _inputPtr;
        _inputPtr = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        j = arrayOfInt[i];
        if (j == 0) {}
      }
      else
      {
        switch (j)
        {
        default: 
          _reportInvalidChar(i);
          break;
        case 42: 
          if ((_inputPtr >= _inputEnd) && (!loadMore()))
          {
            _reportInvalidEOF(" in a comment");
            return;
          }
          if (_inputBuffer[_inputPtr] == 47)
          {
            _inputPtr += 1;
            return;
          }
          break;
        case 10: 
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
          break;
        case 13: 
          _skipCR();
          break;
        case 2: 
          _skipUtf8_2(i);
          break;
        case 3: 
          _skipUtf8_3(i);
          break;
        case 4: 
          _skipUtf8_4(i);
        }
      }
    }
  }
  
  private final int _skipColon()
    throws IOException
  {
    if (_inputPtr + 4 >= _inputEnd) {
      return _skipColon2(false);
    }
    int j = _inputBuffer[_inputPtr];
    byte[] arrayOfByte;
    int i;
    if (j == 58)
    {
      arrayOfByte = _inputBuffer;
      i = _inputPtr + 1;
      _inputPtr = i;
      i = arrayOfByte[i];
      if (i > 32)
      {
        if ((i == 47) || (i == 35)) {
          return _skipColon2(true);
        }
        _inputPtr += 1;
        return i;
      }
      if ((i == 32) || (i == 9))
      {
        arrayOfByte = _inputBuffer;
        i = _inputPtr + 1;
        _inputPtr = i;
        i = arrayOfByte[i];
        if (i > 32)
        {
          if ((i == 47) || (i == 35)) {
            return _skipColon2(true);
          }
          _inputPtr += 1;
          return i;
        }
      }
      return _skipColon2(true);
    }
    if (j != 32)
    {
      i = j;
      if (j != 9) {}
    }
    else
    {
      arrayOfByte = _inputBuffer;
      i = _inputPtr + 1;
      _inputPtr = i;
      i = arrayOfByte[i];
    }
    if (i == 58)
    {
      arrayOfByte = _inputBuffer;
      i = _inputPtr + 1;
      _inputPtr = i;
      i = arrayOfByte[i];
      if (i > 32)
      {
        if ((i == 47) || (i == 35)) {
          return _skipColon2(true);
        }
        _inputPtr += 1;
        return i;
      }
      if ((i == 32) || (i == 9))
      {
        arrayOfByte = _inputBuffer;
        i = _inputPtr + 1;
        _inputPtr = i;
        i = arrayOfByte[i];
        if (i > 32)
        {
          if ((i == 47) || (i == 35)) {
            return _skipColon2(true);
          }
          _inputPtr += 1;
          return i;
        }
      }
      return _skipColon2(true);
    }
    return _skipColon2(false);
  }
  
  private final int _skipColon2(boolean paramBoolean)
    throws IOException
  {
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (i > 32)
      {
        if (i == 47)
        {
          _skipComment();
        }
        else if ((i != 35) || (!_skipYAMLComment()))
        {
          if (paramBoolean) {
            return i;
          }
          if (i != 58)
          {
            if (i < 32) {
              _throwInvalidSpace(i);
            }
            _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
          }
          paramBoolean = true;
        }
      }
      else if (i != 32) {
        if (i == 10)
        {
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
        }
        else if (i == 13)
        {
          _skipCR();
        }
        else if (i != 9)
        {
          _throwInvalidSpace(i);
        }
      }
    }
    throw _constructError("Unexpected end-of-input within/between " + _parsingContext.getTypeDesc() + " entries");
  }
  
  private final int _skipColonFast(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = _inputBuffer;
    int j = paramInt + 1;
    int k = arrayOfByte[paramInt];
    int i;
    if (k == 58)
    {
      arrayOfByte = _inputBuffer;
      i = j + 1;
      j = arrayOfByte[j];
      if (j > 32)
      {
        paramInt = i;
        if (j != 47)
        {
          paramInt = i;
          if (j != 35)
          {
            _inputPtr = i;
            return j;
          }
        }
      }
      else if (j != 32)
      {
        paramInt = i;
        if (j != 9) {}
      }
      else
      {
        arrayOfByte = _inputBuffer;
        paramInt = i + 1;
        i = arrayOfByte[i];
        if ((i > 32) && (i != 47) && (i != 35))
        {
          _inputPtr = paramInt;
          return i;
        }
      }
      _inputPtr = (paramInt - 1);
      return _skipColon2(true);
    }
    if (k != 32)
    {
      i = k;
      paramInt = j;
      if (k != 9) {}
    }
    else
    {
      i = _inputBuffer[j];
      paramInt = j + 1;
    }
    if (i == 58)
    {
      arrayOfByte = _inputBuffer;
      i = paramInt + 1;
      j = arrayOfByte[paramInt];
      if (j > 32)
      {
        paramInt = i;
        if (j != 47)
        {
          paramInt = i;
          if (j != 35)
          {
            _inputPtr = i;
            return j;
          }
        }
      }
      else if (j != 32)
      {
        paramInt = i;
        if (j != 9) {}
      }
      else
      {
        arrayOfByte = _inputBuffer;
        paramInt = i + 1;
        i = arrayOfByte[i];
        if ((i > 32) && (i != 47) && (i != 35))
        {
          _inputPtr = paramInt;
          return i;
        }
      }
      _inputPtr = (paramInt - 1);
      return _skipColon2(true);
    }
    _inputPtr = (paramInt - 1);
    return _skipColon2(false);
  }
  
  private final void _skipComment()
    throws IOException
  {
    if (!isEnabled(JsonParser.Feature.ALLOW_COMMENTS)) {
      _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
    }
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in a comment");
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (i == 47)
    {
      _skipLine();
      return;
    }
    if (i == 42)
    {
      _skipCComment();
      return;
    }
    _reportUnexpectedChar(i, "was expecting either '*' or '/' for a comment");
  }
  
  private final void _skipLine()
    throws IOException
  {
    int[] arrayOfInt = CharTypes.getInputCodeComment();
    for (;;)
    {
      int i;
      int j;
      if ((_inputPtr < _inputEnd) || (loadMore()))
      {
        byte[] arrayOfByte = _inputBuffer;
        i = _inputPtr;
        _inputPtr = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        j = arrayOfInt[i];
        if (j == 0) {}
      }
      else
      {
        switch (j)
        {
        case 42: 
        default: 
          if (j < 0) {
            _reportInvalidChar(i);
          }
          break;
        case 10: 
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
          return;
        case 13: 
          _skipCR();
          return;
        case 2: 
          _skipUtf8_2(i);
          break;
        case 3: 
          _skipUtf8_3(i);
          break;
        case 4: 
          _skipUtf8_4(i);
        }
      }
    }
  }
  
  private final void _skipUtf8_2(int paramInt)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    paramInt = _inputPtr;
    _inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, _inputPtr);
    }
  }
  
  private final void _skipUtf8_3(int paramInt)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    paramInt = _inputPtr;
    _inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    paramInt = _inputPtr;
    _inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, _inputPtr);
    }
  }
  
  private final void _skipUtf8_4(int paramInt)
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    paramInt = _inputPtr;
    _inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    paramInt = _inputPtr;
    _inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, _inputPtr);
    }
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = _inputBuffer;
    paramInt = _inputPtr;
    _inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, _inputPtr);
    }
  }
  
  private final int _skipWS()
    throws IOException
  {
    while (_inputPtr < _inputEnd)
    {
      byte[] arrayOfByte = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      int j = arrayOfByte[i] & 0xFF;
      if (j > 32)
      {
        if (j != 47)
        {
          i = j;
          if (j != 35) {}
        }
        else
        {
          _inputPtr -= 1;
          i = _skipWS2();
        }
        return i;
      }
      if (j != 32) {
        if (j == 10)
        {
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
        }
        else if (j == 13)
        {
          _skipCR();
        }
        else if (j != 9)
        {
          _throwInvalidSpace(j);
        }
      }
    }
    return _skipWS2();
  }
  
  private final int _skipWS2()
    throws IOException
  {
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (i > 32)
      {
        if (i == 47) {
          _skipComment();
        } else if ((i != 35) || (!_skipYAMLComment())) {
          return i;
        }
      }
      else if (i != 32) {
        if (i == 10)
        {
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
        }
        else if (i == 13)
        {
          _skipCR();
        }
        else if (i != 9)
        {
          _throwInvalidSpace(i);
        }
      }
    }
    throw _constructError("Unexpected end-of-input within/between " + _parsingContext.getTypeDesc() + " entries");
  }
  
  private final int _skipWSOrEnd()
    throws IOException
  {
    int i;
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      i = _eofAsNextChar();
    }
    byte[] arrayOfByte;
    int j;
    do
    {
      return i;
      arrayOfByte = _inputBuffer;
      i = _inputPtr;
      _inputPtr = (i + 1);
      j = arrayOfByte[i] & 0xFF;
      if (j <= 32) {
        break label85;
      }
      if (j == 47) {
        break;
      }
      i = j;
    } while (j != 35);
    _inputPtr -= 1;
    return _skipWSOrEnd2();
    label85:
    if (j != 32)
    {
      if (j != 10) {
        break label186;
      }
      _currInputRow += 1;
      _currInputRowStart = _inputPtr;
    }
    for (;;)
    {
      if (_inputPtr >= _inputEnd) {
        break label273;
      }
      arrayOfByte = _inputBuffer;
      i = _inputPtr;
      _inputPtr = (i + 1);
      j = arrayOfByte[i] & 0xFF;
      if (j > 32)
      {
        if (j != 47)
        {
          i = j;
          if (j != 35) {
            break;
          }
        }
        _inputPtr -= 1;
        return _skipWSOrEnd2();
        label186:
        if (j == 13)
        {
          _skipCR();
          continue;
        }
        if (j == 9) {
          continue;
        }
        _throwInvalidSpace(j);
        continue;
      }
      if (j != 32) {
        if (j == 10)
        {
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
        }
        else if (j == 13)
        {
          _skipCR();
        }
        else if (j != 9)
        {
          _throwInvalidSpace(j);
        }
      }
    }
    label273:
    return _skipWSOrEnd2();
  }
  
  private final int _skipWSOrEnd2()
    throws IOException
  {
    while ((_inputPtr < _inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (i > 32)
      {
        if (i == 47) {
          _skipComment();
        } else if ((i != 35) || (!_skipYAMLComment())) {
          return i;
        }
      }
      else if (i != 32) {
        if (i == 10)
        {
          _currInputRow += 1;
          _currInputRowStart = _inputPtr;
        }
        else if (i == 13)
        {
          _skipCR();
        }
        else if (i != 9)
        {
          _throwInvalidSpace(i);
        }
      }
    }
    return _eofAsNextChar();
  }
  
  private final boolean _skipYAMLComment()
    throws IOException
  {
    if (!isEnabled(JsonParser.Feature.ALLOW_YAML_COMMENTS)) {
      return false;
    }
    _skipLine();
    return true;
  }
  
  private final int _verifyNoLeadingZeroes()
    throws IOException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {}
    int j;
    do
    {
      for (int i = 48; (_inputPtr >= _inputEnd) && (!loadMore()); i = j) {
        do
        {
          return i;
          j = _inputBuffer[_inputPtr] & 0xFF;
          if ((j < 48) || (j > 57)) {
            return 48;
          }
          if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            reportInvalidNumber("Leading zeroes not allowed");
          }
          _inputPtr += 1;
          i = j;
        } while (j != 48);
      }
      j = _inputBuffer[_inputPtr] & 0xFF;
      if ((j < 48) || (j > 57)) {
        return 48;
      }
      _inputPtr += 1;
      i = j;
    } while (j == 48);
    return j;
  }
  
  private final void _verifyRootSpace(int paramInt)
    throws IOException
  {
    _inputPtr += 1;
    switch (paramInt)
    {
    default: 
      _reportMissingRootWS(paramInt);
    case 9: 
    case 32: 
      return;
    case 13: 
      _skipCR();
      return;
    }
    _currInputRow += 1;
    _currInputRowStart = _inputPtr;
  }
  
  private final String addName(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    throws JsonParseException
  {
    int i3 = (paramInt1 << 2) - 4 + paramInt2;
    int i2;
    Object localObject1;
    int i;
    int m;
    label49:
    int j;
    int i1;
    int n;
    label120:
    Object localObject2;
    if (paramInt2 < 4)
    {
      i2 = paramArrayOfInt[(paramInt1 - 1)];
      paramArrayOfInt[(paramInt1 - 1)] = (i2 << (4 - paramInt2 << 3));
      localObject1 = _textBuffer.emptyAndGetCurrentSegment();
      i = 0;
      m = 0;
      if (i >= i3) {
        break label521;
      }
      j = paramArrayOfInt[(i >> 2)] >> (3 - (i & 0x3) << 3) & 0xFF;
      int k = i + 1;
      i1 = j;
      n = k;
      if (j <= 127) {
        break label559;
      }
      if ((j & 0xE0) != 192) {
        break label456;
      }
      i = j & 0x1F;
      j = 1;
      if (k + j > i3) {
        _reportInvalidEOF(" in field name");
      }
      i1 = paramArrayOfInt[(k >> 2)] >> (3 - (k & 0x3) << 3);
      n = k + 1;
      if ((i1 & 0xC0) != 128) {
        _reportInvalidOther(i1);
      }
      i1 = i << 6 | i1 & 0x3F;
      k = i1;
      i = n;
      if (j > 1)
      {
        i = paramArrayOfInt[(n >> 2)] >> (3 - (n & 0x3) << 3);
        n += 1;
        if ((i & 0xC0) != 128) {
          _reportInvalidOther(i);
        }
        i1 = i1 << 6 | i & 0x3F;
        k = i1;
        i = n;
        if (j > 2)
        {
          k = paramArrayOfInt[(n >> 2)] >> (3 - (n & 0x3) << 3);
          i = n + 1;
          if ((k & 0xC0) != 128) {
            _reportInvalidOther(k & 0xFF);
          }
          k = i1 << 6 | k & 0x3F;
        }
      }
      i1 = k;
      n = i;
      if (j <= 2) {
        break label559;
      }
      k -= 65536;
      localObject2 = localObject1;
      if (m >= localObject1.length) {
        localObject2 = _textBuffer.expandCurrentSegment();
      }
      j = m + 1;
      localObject2[m] = ((char)(55296 + (k >> 10)));
      i1 = 0xDC00 | k & 0x3FF;
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (j >= localObject1.length) {
        localObject2 = _textBuffer.expandCurrentSegment();
      }
      m = j + 1;
      localObject2[j] = ((char)i1);
      localObject1 = localObject2;
      break label49;
      i2 = 0;
      break;
      label456:
      if ((j & 0xF0) == 224)
      {
        i = j & 0xF;
        j = 2;
        break label120;
      }
      if ((j & 0xF8) == 240)
      {
        i = j & 0x7;
        j = 3;
        break label120;
      }
      _reportInvalidInitial(j);
      i = 1;
      j = 1;
      break label120;
      label521:
      localObject1 = new String((char[])localObject1, 0, m);
      if (paramInt2 < 4) {
        paramArrayOfInt[(paramInt1 - 1)] = i2;
      }
      return _symbols.addName((String)localObject1, paramArrayOfInt, paramInt1);
      label559:
      j = m;
      i = n;
    }
  }
  
  private final String findName(int paramInt1, int paramInt2)
    throws JsonParseException
  {
    paramInt1 = pad(paramInt1, paramInt2);
    String str = _symbols.findName(paramInt1);
    if (str != null) {
      return str;
    }
    _quadBuffer[0] = paramInt1;
    return addName(_quadBuffer, 1, paramInt2);
  }
  
  private final String findName(int paramInt1, int paramInt2, int paramInt3)
    throws JsonParseException
  {
    paramInt2 = pad(paramInt2, paramInt3);
    String str = _symbols.findName(paramInt1, paramInt2);
    if (str != null) {
      return str;
    }
    _quadBuffer[0] = paramInt1;
    _quadBuffer[1] = paramInt2;
    return addName(_quadBuffer, 2, paramInt3);
  }
  
  private final String findName(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws JsonParseException
  {
    paramInt3 = pad(paramInt3, paramInt4);
    Object localObject = _symbols.findName(paramInt1, paramInt2, paramInt3);
    if (localObject != null) {
      return (String)localObject;
    }
    localObject = _quadBuffer;
    localObject[0] = paramInt1;
    localObject[1] = paramInt2;
    localObject[2] = pad(paramInt3, paramInt4);
    return addName((int[])localObject, 3, paramInt4);
  }
  
  private final String findName(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
    throws JsonParseException
  {
    int[] arrayOfInt = paramArrayOfInt;
    if (paramInt1 >= paramArrayOfInt.length)
    {
      arrayOfInt = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
      _quadBuffer = arrayOfInt;
    }
    int i = paramInt1 + 1;
    arrayOfInt[paramInt1] = pad(paramInt2, paramInt3);
    String str = _symbols.findName(arrayOfInt, i);
    paramArrayOfInt = str;
    if (str == null) {
      paramArrayOfInt = addName(arrayOfInt, i, paramInt3);
    }
    return paramArrayOfInt;
  }
  
  public static int[] growArrayBy(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return new int[paramInt];
    }
    return Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length + paramInt);
  }
  
  private int nextByte()
    throws IOException
  {
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  private static final int pad(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 4) {
      return paramInt1;
    }
    return paramInt1 | -1 << (paramInt2 << 3);
  }
  
  private final String parseName(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    return parseEscapedName(_quadBuffer, 0, paramInt1, paramInt2, paramInt3);
  }
  
  private final String parseName(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException
  {
    _quadBuffer[0] = paramInt1;
    return parseEscapedName(_quadBuffer, 1, paramInt2, paramInt3, paramInt4);
  }
  
  private final String parseName(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    throws IOException
  {
    _quadBuffer[0] = paramInt1;
    _quadBuffer[1] = paramInt2;
    return parseEscapedName(_quadBuffer, 2, paramInt3, paramInt4, paramInt5);
  }
  
  protected void _closeInput()
    throws IOException
  {
    if (_inputStream != null)
    {
      if ((_ioContext.isResourceManaged()) || (isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE))) {
        _inputStream.close();
      }
      _inputStream = null;
    }
  }
  
  protected final byte[] _decodeBase64(Base64Variant paramBase64Variant)
    throws IOException
  {
    ByteArrayBuilder localByteArrayBuilder = _getByteArrayBuilder();
    for (;;)
    {
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      byte[] arrayOfByte = _inputBuffer;
      int i = _inputPtr;
      _inputPtr = (i + 1);
      int k = arrayOfByte[i] & 0xFF;
      if (k > 32)
      {
        int j = paramBase64Variant.decodeBase64Char(k);
        i = j;
        if (j < 0)
        {
          if (k == 34) {
            return localByteArrayBuilder.toByteArray();
          }
          i = _decodeBase64Escape(paramBase64Variant, k, 0);
          if (i < 0) {}
        }
        else
        {
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = _inputBuffer;
          j = _inputPtr;
          _inputPtr = (j + 1);
          int m = arrayOfByte[j] & 0xFF;
          k = paramBase64Variant.decodeBase64Char(m);
          j = k;
          if (k < 0) {
            j = _decodeBase64Escape(paramBase64Variant, m, 1);
          }
          m = i << 6 | j;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          int n = arrayOfByte[i] & 0xFF;
          j = paramBase64Variant.decodeBase64Char(n);
          k = j;
          if (j < 0)
          {
            i = j;
            if (j != -2)
            {
              if ((n == 34) && (!paramBase64Variant.usesPadding()))
              {
                localByteArrayBuilder.append(m >> 4);
                return localByteArrayBuilder.toByteArray();
              }
              i = _decodeBase64Escape(paramBase64Variant, n, 2);
            }
            k = i;
            if (i == -2)
            {
              if (_inputPtr >= _inputEnd) {
                loadMoreGuaranteed();
              }
              arrayOfByte = _inputBuffer;
              i = _inputPtr;
              _inputPtr = (i + 1);
              i = arrayOfByte[i] & 0xFF;
              if (!paramBase64Variant.usesPaddingChar(i)) {
                throw reportInvalidBase64Char(paramBase64Variant, i, 3, "expected padding character '" + paramBase64Variant.getPaddingChar() + "'");
              }
              localByteArrayBuilder.append(m >> 4);
              continue;
            }
          }
          m = m << 6 | k;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          n = arrayOfByte[i] & 0xFF;
          j = paramBase64Variant.decodeBase64Char(n);
          k = j;
          if (j < 0)
          {
            i = j;
            if (j != -2)
            {
              if ((n == 34) && (!paramBase64Variant.usesPadding()))
              {
                localByteArrayBuilder.appendTwoBytes(m >> 2);
                return localByteArrayBuilder.toByteArray();
              }
              i = _decodeBase64Escape(paramBase64Variant, n, 3);
            }
            k = i;
            if (i == -2)
            {
              localByteArrayBuilder.appendTwoBytes(m >> 2);
              continue;
            }
          }
          localByteArrayBuilder.appendThreeBytes(m << 6 | k);
        }
      }
    }
  }
  
  protected int _decodeCharForError(int paramInt)
    throws IOException
  {
    paramInt &= 0xFF;
    int i = paramInt;
    if (paramInt > 127)
    {
      if ((paramInt & 0xE0) != 192) {
        break label153;
      }
      i = paramInt & 0x1F;
      paramInt = 1;
    }
    for (;;)
    {
      int j = nextByte();
      if ((j & 0xC0) != 128) {
        _reportInvalidOther(j & 0xFF);
      }
      j = i << 6 | j & 0x3F;
      i = j;
      if (paramInt > 1)
      {
        i = nextByte();
        if ((i & 0xC0) != 128) {
          _reportInvalidOther(i & 0xFF);
        }
        j = j << 6 | i & 0x3F;
        i = j;
        if (paramInt > 2)
        {
          paramInt = nextByte();
          if ((paramInt & 0xC0) != 128) {
            _reportInvalidOther(paramInt & 0xFF);
          }
          i = j << 6 | paramInt & 0x3F;
        }
      }
      return i;
      label153:
      if ((paramInt & 0xF0) == 224)
      {
        i = paramInt & 0xF;
        paramInt = 2;
      }
      else if ((paramInt & 0xF8) == 240)
      {
        i = paramInt & 0x7;
        paramInt = 3;
      }
      else
      {
        _reportInvalidInitial(paramInt & 0xFF);
        j = 1;
        i = paramInt;
        paramInt = j;
      }
    }
  }
  
  protected char _decodeEscaped()
    throws IOException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in character escape sequence");
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i];
    switch (i)
    {
    default: 
      return _handleUnrecognizedCharacterEscape((char)_decodeCharForError(i));
    case 98: 
      return '\b';
    case 116: 
      return '\t';
    case 110: 
      return '\n';
    case 102: 
      return '\f';
    case 114: 
      return '\r';
    case 34: 
    case 47: 
    case 92: 
      return (char)i;
    }
    int j = 0;
    i = 0;
    while (i < 4)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in character escape sequence");
      }
      arrayOfByte = _inputBuffer;
      int k = _inputPtr;
      _inputPtr = (k + 1);
      k = arrayOfByte[k];
      int m = CharTypes.charToHex(k);
      if (m < 0) {
        _reportUnexpectedChar(k, "expected a hex-digit for character escape sequence");
      }
      j = j << 4 | m;
      i += 1;
    }
    return (char)j;
  }
  
  protected String _finishAndReturnString()
    throws IOException
  {
    int j = _inputPtr;
    int i = j;
    if (j >= _inputEnd)
    {
      loadMoreGuaranteed();
      i = _inputPtr;
    }
    char[] arrayOfChar = _textBuffer.emptyAndGetCurrentSegment();
    int[] arrayOfInt = _icUTF8;
    int m = Math.min(_inputEnd, arrayOfChar.length + i);
    byte[] arrayOfByte = _inputBuffer;
    int k = 0;
    j = i;
    i = k;
    while (j < m)
    {
      k = arrayOfByte[j] & 0xFF;
      if (arrayOfInt[k] != 0)
      {
        if (k != 34) {
          break;
        }
        _inputPtr = (j + 1);
        return _textBuffer.setCurrentAndReturn(i);
      }
      j += 1;
      arrayOfChar[i] = ((char)k);
      i += 1;
    }
    _inputPtr = j;
    _finishString2(arrayOfChar, i);
    return _textBuffer.contentsAsString();
  }
  
  protected void _finishString()
    throws IOException
  {
    int j = _inputPtr;
    int i = j;
    if (j >= _inputEnd)
    {
      loadMoreGuaranteed();
      i = _inputPtr;
    }
    char[] arrayOfChar = _textBuffer.emptyAndGetCurrentSegment();
    int[] arrayOfInt = _icUTF8;
    int m = Math.min(_inputEnd, arrayOfChar.length + i);
    byte[] arrayOfByte = _inputBuffer;
    int k = 0;
    j = i;
    i = k;
    while (j < m)
    {
      k = arrayOfByte[j] & 0xFF;
      if (arrayOfInt[k] != 0)
      {
        if (k != 34) {
          break;
        }
        _inputPtr = (j + 1);
        _textBuffer.setCurrentLength(i);
        return;
      }
      j += 1;
      arrayOfChar[i] = ((char)k);
      i += 1;
    }
    _inputPtr = j;
    _finishString2(arrayOfChar, i);
  }
  
  protected final String _getText2(JsonToken paramJsonToken)
  {
    if (paramJsonToken == null) {
      return null;
    }
    switch (paramJsonToken.id())
    {
    default: 
      return paramJsonToken.asString();
    case 5: 
      return _parsingContext.getCurrentName();
    }
    return _textBuffer.contentsAsString();
  }
  
  protected JsonToken _handleApos()
    throws IOException
  {
    int i = 0;
    Object localObject2 = _textBuffer.emptyAndGetCurrentSegment();
    int[] arrayOfInt = _icUTF8;
    byte[] arrayOfByte = _inputBuffer;
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    Object localObject1 = localObject2;
    int k = i;
    if (i >= localObject2.length)
    {
      localObject1 = _textBuffer.finishCurrentSegment();
      k = 0;
    }
    i = _inputEnd;
    int n = _inputPtr + (localObject1.length - k);
    int m = i;
    int j = k;
    if (n < i)
    {
      m = n;
      j = k;
    }
    for (;;)
    {
      localObject2 = localObject1;
      i = j;
      if (_inputPtr >= m) {
        break;
      }
      i = _inputPtr;
      _inputPtr = (i + 1);
      n = arrayOfByte[i] & 0xFF;
      if ((n == 39) || (arrayOfInt[n] != 0))
      {
        if (n != 39) {
          break label180;
        }
        _textBuffer.setCurrentLength(j);
        return JsonToken.VALUE_STRING;
      }
      localObject1[j] = ((char)n);
      j += 1;
    }
    label180:
    switch (arrayOfInt[n])
    {
    default: 
      if (n < 32) {
        _throwUnquotedSpace(n, "string value");
      }
      _reportInvalidChar(n);
      k = j;
      localObject2 = localObject1;
      i = n;
    case 1: 
    case 2: 
    case 3: 
      for (;;)
      {
        localObject1 = localObject2;
        j = k;
        if (k >= localObject2.length)
        {
          localObject1 = _textBuffer.finishCurrentSegment();
          j = 0;
        }
        localObject1[j] = ((char)i);
        i = j + 1;
        localObject2 = localObject1;
        break;
        i = n;
        localObject2 = localObject1;
        k = j;
        if (n != 39)
        {
          i = _decodeEscaped();
          localObject2 = localObject1;
          k = j;
          continue;
          i = _decodeUtf8_2(n);
          localObject2 = localObject1;
          k = j;
          continue;
          if (_inputEnd - _inputPtr >= 2)
          {
            i = _decodeUtf8_3fast(n);
            localObject2 = localObject1;
            k = j;
          }
          else
          {
            i = _decodeUtf8_3(n);
            localObject2 = localObject1;
            k = j;
          }
        }
      }
    }
    i = _decodeUtf8_4(n);
    k = j + 1;
    localObject1[j] = ((char)(0xD800 | i >> 10));
    if (k >= localObject1.length)
    {
      localObject1 = _textBuffer.finishCurrentSegment();
      k = 0;
    }
    for (;;)
    {
      i = 0xDC00 | i & 0x3FF;
      localObject2 = localObject1;
      break;
    }
  }
  
  protected JsonToken _handleInvalidNumberStart(int paramInt, boolean paramBoolean)
    throws IOException
  {
    int i;
    for (;;)
    {
      i = paramInt;
      if (paramInt != 73) {
        break;
      }
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOFInValue();
      }
      Object localObject = _inputBuffer;
      paramInt = _inputPtr;
      _inputPtr = (paramInt + 1);
      paramInt = localObject[paramInt];
      if (paramInt == 78) {
        if (paramBoolean)
        {
          localObject = "-INF";
          _matchToken((String)localObject, 3);
          if (!isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            break label146;
          }
          if (!paramBoolean) {
            break label139;
          }
        }
      }
      label139:
      for (double d = Double.NEGATIVE_INFINITY;; d = Double.POSITIVE_INFINITY)
      {
        return resetAsNaN((String)localObject, d);
        localObject = "+INF";
        break;
        i = paramInt;
        if (paramInt != 110) {
          break label180;
        }
        if (paramBoolean) {}
        for (localObject = "-Infinity";; localObject = "+Infinity") {
          break;
        }
      }
      label146:
      _reportError("Non-standard token '" + (String)localObject + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
    }
    label180:
    reportUnexpectedNumberChar(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
    return null;
  }
  
  protected String _handleOddName(int paramInt)
    throws IOException
  {
    if ((paramInt == 39) && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)))
    {
      localObject1 = _parseAposName();
      return (String)localObject1;
    }
    if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
      _reportUnexpectedChar((char)_decodeCharForError(paramInt), "was expecting double-quote to start field name");
    }
    Object localObject3 = CharTypes.getInputCodeUtf8JsNames();
    if (localObject3[paramInt] != 0) {
      _reportUnexpectedChar(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
    }
    Object localObject1 = _quadBuffer;
    int j = 0;
    int k = 0;
    int m = 0;
    int i = paramInt;
    paramInt = m;
    for (;;)
    {
      if (k < 4)
      {
        k += 1;
        j = j << 8 | i;
        i = k;
      }
      for (;;)
      {
        if ((_inputPtr >= _inputEnd) && (!loadMore())) {
          _reportInvalidEOF(" in field name");
        }
        m = _inputBuffer[_inputPtr] & 0xFF;
        if (localObject3[m] == 0) {
          break label290;
        }
        k = paramInt;
        Object localObject2 = localObject1;
        if (i > 0)
        {
          localObject2 = localObject1;
          if (paramInt >= localObject1.length)
          {
            localObject2 = growArrayBy((int[])localObject1, localObject1.length);
            _quadBuffer = ((int[])localObject2);
          }
          localObject2[paramInt] = j;
          k = paramInt + 1;
        }
        localObject3 = _symbols.findName((int[])localObject2, k);
        localObject1 = localObject3;
        if (localObject3 != null) {
          break;
        }
        return addName((int[])localObject2, k, i);
        localObject2 = localObject1;
        if (paramInt >= localObject1.length)
        {
          localObject2 = growArrayBy((int[])localObject1, localObject1.length);
          _quadBuffer = ((int[])localObject2);
        }
        k = paramInt + 1;
        localObject2[paramInt] = j;
        paramInt = 1;
        j = i;
        i = paramInt;
        paramInt = k;
        localObject1 = localObject2;
      }
      label290:
      _inputPtr += 1;
      k = i;
      i = m;
    }
  }
  
  protected JsonToken _handleUnexpectedValue(int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
    case 93: 
    case 125: 
    case 39: 
    case 78: 
    case 73: 
      for (;;)
      {
        if (Character.isJavaIdentifierStart(paramInt)) {
          _reportInvalidToken("" + (char)paramInt, "('true', 'false' or 'null')");
        }
        _reportUnexpectedChar(paramInt, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
        _reportUnexpectedChar(paramInt, "expected a value");
        if (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))
        {
          return _handleApos();
          _matchToken("NaN", 1);
          if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            return resetAsNaN("NaN", NaN.0D);
          }
          _reportError("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
          continue;
          _matchToken("Infinity", 1);
          if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            return resetAsNaN("Infinity", Double.POSITIVE_INFINITY);
          }
          _reportError("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        }
      }
    }
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOFInValue();
    }
    byte[] arrayOfByte = _inputBuffer;
    paramInt = _inputPtr;
    _inputPtr = (paramInt + 1);
    return _handleInvalidNumberStart(arrayOfByte[paramInt] & 0xFF, false);
  }
  
  protected final boolean _loadToHaveAtLeast(int paramInt)
    throws IOException
  {
    if (_inputStream == null) {
      return false;
    }
    int i = _inputEnd - _inputPtr;
    if ((i > 0) && (_inputPtr > 0))
    {
      _currInputProcessed += _inputPtr;
      _currInputRowStart -= _inputPtr;
      System.arraycopy(_inputBuffer, _inputPtr, _inputBuffer, 0, i);
      _inputEnd = i;
      label79:
      _inputPtr = 0;
    }
    for (;;)
    {
      if (_inputEnd >= paramInt) {
        break label186;
      }
      int j = _inputStream.read(_inputBuffer, _inputEnd, _inputBuffer.length - _inputEnd);
      if (j < 1)
      {
        _closeInput();
        if (j != 0) {
          break;
        }
        throw new IOException("InputStream.read() returned 0 characters when trying to read " + i + " bytes");
        _inputEnd = 0;
        break label79;
      }
      _inputEnd += j;
    }
    label186:
    return true;
  }
  
  protected final void _matchToken(String paramString, int paramInt)
    throws IOException
  {
    int j = paramString.length();
    int i = paramInt;
    if (_inputPtr + j >= _inputEnd) {
      _matchToken2(paramString, paramInt);
    }
    do
    {
      return;
      do
      {
        if (_inputBuffer[_inputPtr] != paramString.charAt(i)) {
          _reportInvalidToken(paramString.substring(0, i));
        }
        _inputPtr += 1;
        paramInt = i + 1;
        i = paramInt;
      } while (paramInt < j);
      i = _inputBuffer[_inputPtr] & 0xFF;
    } while ((i < 48) || (i == 93) || (i == 125));
    _checkMatchEnd(paramString, paramInt, i);
  }
  
  protected String _parseAposName()
    throws IOException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing ''' for name");
    }
    Object localObject1 = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    int m = localObject1[i] & 0xFF;
    if (m == 39) {
      localObject1 = "";
    }
    int j;
    Object localObject3;
    do
    {
      return (String)localObject1;
      localObject1 = _quadBuffer;
      k = 0;
      j = 0;
      localObject3 = _icLatin1;
      i = 0;
      if (m != 39) {
        break;
      }
      if (j <= 0) {
        break label623;
      }
      localObject2 = localObject1;
      if (i >= localObject1.length)
      {
        localObject2 = growArrayBy((int[])localObject1, localObject1.length);
        _quadBuffer = ((int[])localObject2);
      }
      m = i + 1;
      localObject2[i] = pad(k, j);
      i = m;
      localObject3 = _symbols.findName((int[])localObject2, i);
      localObject1 = localObject3;
    } while (localObject3 != null);
    return addName((int[])localObject2, i, j);
    int n = m;
    int i3 = k;
    int i4 = j;
    int i2 = i;
    Object localObject2 = localObject1;
    if (m != 34)
    {
      n = m;
      i3 = k;
      i4 = j;
      i2 = i;
      localObject2 = localObject1;
      if (localObject3[m] != 0)
      {
        if (m == 92) {
          break label462;
        }
        _throwUnquotedSpace(m, "name");
      }
    }
    label356:
    label403:
    label462:
    for (int i1 = m;; i1 = _decodeEscaped())
    {
      n = i1;
      i3 = k;
      i4 = j;
      i2 = i;
      localObject2 = localObject1;
      if (i1 > 127)
      {
        i2 = k;
        n = j;
        m = i;
        localObject2 = localObject1;
        if (j >= 4)
        {
          localObject2 = localObject1;
          if (i >= localObject1.length)
          {
            localObject2 = growArrayBy((int[])localObject1, localObject1.length);
            _quadBuffer = ((int[])localObject2);
          }
          localObject2[i] = k;
          i2 = 0;
          n = 0;
          m = i + 1;
        }
        if (i1 >= 2048) {
          break label471;
        }
        i = i2 << 8 | i1 >> 6 | 0xC0;
        k = n + 1;
        j = m;
        n = i1 & 0x3F | 0x80;
        i2 = j;
        i4 = k;
        i3 = i;
      }
      if (i4 >= 4) {
        break label575;
      }
      j = i4 + 1;
      k = i3 << 8 | n;
      i = i2;
      localObject1 = localObject2;
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in field name");
      }
      localObject2 = _inputBuffer;
      m = _inputPtr;
      _inputPtr = (m + 1);
      m = localObject2[m] & 0xFF;
      break;
    }
    label471:
    int k = i2 << 8 | i1 >> 12 | 0xE0;
    i = n + 1;
    if (i >= 4)
    {
      localObject1 = localObject2;
      if (m >= localObject2.length)
      {
        localObject1 = growArrayBy((int[])localObject2, localObject2.length);
        _quadBuffer = ((int[])localObject1);
      }
      j = m + 1;
      localObject1[m] = k;
      k = 0;
      i = 0;
    }
    for (;;)
    {
      k = k << 8 | i1 >> 6 & 0x3F | 0x80;
      m = i + 1;
      i = k;
      k = m;
      localObject2 = localObject1;
      break label356;
      label575:
      localObject1 = localObject2;
      if (i2 >= localObject2.length)
      {
        localObject1 = growArrayBy((int[])localObject2, localObject2.length);
        _quadBuffer = ((int[])localObject1);
      }
      i = i2 + 1;
      localObject1[i2] = i3;
      k = n;
      j = 1;
      break label403;
      label623:
      localObject2 = localObject1;
      break;
      j = m;
      localObject1 = localObject2;
    }
  }
  
  protected final String _parseName(int paramInt)
    throws IOException
  {
    if (paramInt != 34) {
      return _handleOddName(paramInt);
    }
    if (_inputPtr + 13 > _inputEnd) {
      return slowParseName();
    }
    byte[] arrayOfByte = _inputBuffer;
    int[] arrayOfInt = _icLatin1;
    paramInt = _inputPtr;
    _inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt] & 0xFF;
    if (arrayOfInt[paramInt] == 0)
    {
      int i = _inputPtr;
      _inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (arrayOfInt[i] == 0)
      {
        paramInt = paramInt << 8 | i;
        i = _inputPtr;
        _inputPtr = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        if (arrayOfInt[i] == 0)
        {
          paramInt = paramInt << 8 | i;
          i = _inputPtr;
          _inputPtr = (i + 1);
          i = arrayOfByte[i] & 0xFF;
          if (arrayOfInt[i] == 0)
          {
            paramInt = paramInt << 8 | i;
            i = _inputPtr;
            _inputPtr = (i + 1);
            i = arrayOfByte[i] & 0xFF;
            if (arrayOfInt[i] == 0)
            {
              _quad1 = paramInt;
              return parseMediumName(i);
            }
            if (i == 34) {
              return findName(paramInt, 4);
            }
            return parseName(paramInt, i, 4);
          }
          if (i == 34) {
            return findName(paramInt, 3);
          }
          return parseName(paramInt, i, 3);
        }
        if (i == 34) {
          return findName(paramInt, 2);
        }
        return parseName(paramInt, i, 2);
      }
      if (i == 34) {
        return findName(paramInt, 1);
      }
      return parseName(paramInt, i, 1);
    }
    if (paramInt == 34) {
      return "";
    }
    return parseName(0, paramInt, 0);
  }
  
  protected JsonToken _parseNegNumber()
    throws IOException
  {
    char[] arrayOfChar = _textBuffer.emptyAndGetCurrentSegment();
    int k = 0 + 1;
    arrayOfChar[0] = '-';
    if (_inputPtr >= _inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    int j = arrayOfByte[i] & 0xFF;
    if ((j < 48) || (j > 57)) {
      return _handleInvalidNumberStart(j, true);
    }
    i = j;
    if (j == 48) {
      i = _verifyNoLeadingZeroes();
    }
    int m = k + 1;
    arrayOfChar[k] = ((char)i);
    int n = 1;
    int i1 = _inputPtr + arrayOfChar.length - 2;
    j = m;
    k = n;
    i = i1;
    if (i1 > _inputEnd)
    {
      i = _inputEnd;
      k = n;
      j = m;
    }
    for (;;)
    {
      if (_inputPtr >= i) {
        return _parseNumber2(arrayOfChar, j, true, k);
      }
      arrayOfByte = _inputBuffer;
      m = _inputPtr;
      _inputPtr = (m + 1);
      m = arrayOfByte[m] & 0xFF;
      if ((m < 48) || (m > 57))
      {
        if ((m != 46) && (m != 101) && (m != 69)) {
          break;
        }
        return _parseFloat(arrayOfChar, j, m, true, k);
      }
      k += 1;
      arrayOfChar[j] = ((char)m);
      j += 1;
    }
    _inputPtr -= 1;
    _textBuffer.setCurrentLength(j);
    if (_parsingContext.inRoot()) {
      _verifyRootSpace(m);
    }
    return resetInt(true, k);
  }
  
  protected JsonToken _parsePosNumber(int paramInt)
    throws IOException
  {
    char[] arrayOfChar = _textBuffer.emptyAndGetCurrentSegment();
    int i = paramInt;
    if (paramInt == 48) {
      i = _verifyNoLeadingZeroes();
    }
    arrayOfChar[0] = ((char)i);
    int k = 1;
    int m = 1;
    int n = _inputPtr + arrayOfChar.length - 1;
    i = m;
    int j = k;
    paramInt = n;
    if (n > _inputEnd)
    {
      paramInt = _inputEnd;
      j = k;
      i = m;
    }
    for (;;)
    {
      if (_inputPtr >= paramInt) {
        return _parseNumber2(arrayOfChar, i, false, j);
      }
      byte[] arrayOfByte = _inputBuffer;
      k = _inputPtr;
      _inputPtr = (k + 1);
      k = arrayOfByte[k] & 0xFF;
      if ((k < 48) || (k > 57))
      {
        if ((k != 46) && (k != 101) && (k != 69)) {
          break;
        }
        return _parseFloat(arrayOfChar, i, k, false, j);
      }
      j += 1;
      arrayOfChar[i] = ((char)k);
      i += 1;
    }
    _inputPtr -= 1;
    _textBuffer.setCurrentLength(i);
    if (_parsingContext.inRoot()) {
      _verifyRootSpace(k);
    }
    return resetInt(false, j);
  }
  
  protected int _readBinary(Base64Variant paramBase64Variant, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    int i = 0;
    int i1 = paramArrayOfByte.length;
    int k = 0;
    for (;;)
    {
      if (_inputPtr >= _inputEnd) {
        loadMoreGuaranteed();
      }
      byte[] arrayOfByte = _inputBuffer;
      int j = _inputPtr;
      _inputPtr = (j + 1);
      int m = arrayOfByte[j] & 0xFF;
      if (m > 32)
      {
        j = paramBase64Variant.decodeBase64Char(m);
        int n = j;
        if (j < 0) {
          if (m == 34) {
            j = k;
          }
        }
        int i2;
        int i3;
        for (;;)
        {
          _tokenIncomplete = false;
          k = j;
          if (i > 0)
          {
            k = j + i;
            paramOutputStream.write(paramArrayOfByte, 0, i);
          }
          return k;
          n = _decodeBase64Escape(paramBase64Variant, m, 0);
          if (n < 0) {
            break;
          }
          j = k;
          m = i;
          if (i > i1 - 3)
          {
            j = k + i;
            paramOutputStream.write(paramArrayOfByte, 0, i);
            m = 0;
          }
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          i2 = arrayOfByte[i] & 0xFF;
          k = paramBase64Variant.decodeBase64Char(i2);
          i = k;
          if (k < 0) {
            i = _decodeBase64Escape(paramBase64Variant, i2, 1);
          }
          i2 = n << 6 | i;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          i3 = arrayOfByte[i] & 0xFF;
          k = paramBase64Variant.decodeBase64Char(i3);
          n = k;
          if (k < 0)
          {
            i = k;
            if (k != -2)
            {
              if ((i3 == 34) && (!paramBase64Variant.usesPadding()))
              {
                paramArrayOfByte[m] = ((byte)(i2 >> 4));
                i = m + 1;
                continue;
              }
              i = _decodeBase64Escape(paramBase64Variant, i3, 2);
            }
            n = i;
            if (i == -2)
            {
              if (_inputPtr >= _inputEnd) {
                loadMoreGuaranteed();
              }
              arrayOfByte = _inputBuffer;
              i = _inputPtr;
              _inputPtr = (i + 1);
              i = arrayOfByte[i] & 0xFF;
              if (!paramBase64Variant.usesPaddingChar(i)) {
                throw reportInvalidBase64Char(paramBase64Variant, i, 3, "expected padding character '" + paramBase64Variant.getPaddingChar() + "'");
              }
              paramArrayOfByte[m] = ((byte)(i2 >> 4));
              i = m + 1;
              k = j;
              break;
            }
          }
          i2 = i2 << 6 | n;
          if (_inputPtr >= _inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = _inputBuffer;
          i = _inputPtr;
          _inputPtr = (i + 1);
          i3 = arrayOfByte[i] & 0xFF;
          k = paramBase64Variant.decodeBase64Char(i3);
          n = k;
          if (k >= 0) {
            break label697;
          }
          i = k;
          if (k == -2) {
            break label644;
          }
          if ((i3 != 34) || (paramBase64Variant.usesPadding())) {
            break label634;
          }
          k = i2 >> 2;
          n = m + 1;
          paramArrayOfByte[m] = ((byte)(k >> 8));
          i = n + 1;
          paramArrayOfByte[n] = ((byte)k);
        }
        label634:
        i = _decodeBase64Escape(paramBase64Variant, i3, 3);
        label644:
        n = i;
        if (i == -2)
        {
          k = i2 >> 2;
          n = m + 1;
          paramArrayOfByte[m] = ((byte)(k >> 8));
          i = n + 1;
          paramArrayOfByte[n] = ((byte)k);
          k = j;
        }
        else
        {
          label697:
          i = i2 << 6 | n;
          k = m + 1;
          paramArrayOfByte[m] = ((byte)(i >> 16));
          m = k + 1;
          paramArrayOfByte[k] = ((byte)(i >> 8));
          paramArrayOfByte[m] = ((byte)i);
          i = m + 1;
          k = j;
        }
      }
    }
  }
  
  protected void _releaseBuffers()
    throws IOException
  {
    super._releaseBuffers();
    _symbols.release();
    if (_bufferRecyclable)
    {
      byte[] arrayOfByte = _inputBuffer;
      if (arrayOfByte != null)
      {
        _inputBuffer = ByteArrayBuilder.NO_BYTES;
        _ioContext.releaseReadIOBuffer(arrayOfByte);
      }
    }
  }
  
  protected void _reportInvalidChar(int paramInt)
    throws JsonParseException
  {
    if (paramInt < 32) {
      _throwInvalidSpace(paramInt);
    }
    _reportInvalidInitial(paramInt);
  }
  
  protected void _reportInvalidInitial(int paramInt)
    throws JsonParseException
  {
    _reportError("Invalid UTF-8 start byte 0x" + Integer.toHexString(paramInt));
  }
  
  protected void _reportInvalidOther(int paramInt)
    throws JsonParseException
  {
    _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(paramInt));
  }
  
  protected void _reportInvalidOther(int paramInt1, int paramInt2)
    throws JsonParseException
  {
    _inputPtr = paramInt2;
    _reportInvalidOther(paramInt1);
  }
  
  protected void _reportInvalidToken(String paramString)
    throws IOException
  {
    _reportInvalidToken(paramString, "'null', 'true', 'false' or NaN");
  }
  
  protected void _reportInvalidToken(String paramString1, String paramString2)
    throws IOException
  {
    paramString1 = new StringBuilder(paramString1);
    for (;;)
    {
      if ((_inputPtr >= _inputEnd) && (!loadMore())) {}
      char c;
      do
      {
        _reportError("Unrecognized token '" + paramString1.toString() + "': was expecting " + paramString2);
        return;
        byte[] arrayOfByte = _inputBuffer;
        int i = _inputPtr;
        _inputPtr = (i + 1);
        c = (char)_decodeCharForError(arrayOfByte[i]);
      } while (!Character.isJavaIdentifierPart(c));
      paramString1.append(c);
    }
  }
  
  protected final void _skipCR()
    throws IOException
  {
    if (((_inputPtr < _inputEnd) || (loadMore())) && (_inputBuffer[_inputPtr] == 10)) {
      _inputPtr += 1;
    }
    _currInputRow += 1;
    _currInputRowStart = _inputPtr;
  }
  
  protected void _skipString()
    throws IOException
  {
    _tokenIncomplete = false;
    int[] arrayOfInt = _icUTF8;
    byte[] arrayOfByte = _inputBuffer;
    int k = _inputPtr;
    int m = _inputEnd;
    int j = m;
    int i = k;
    if (k >= m)
    {
      loadMoreGuaranteed();
      i = _inputPtr;
      j = _inputEnd;
    }
    label198:
    for (;;)
    {
      if (i < j)
      {
        k = i + 1;
        m = arrayOfByte[i] & 0xFF;
        i = k;
        if (arrayOfInt[m] == 0) {
          break label198;
        }
        _inputPtr = k;
        if (m != 34) {}
      }
      else
      {
        _inputPtr = i;
        break;
      }
      switch (arrayOfInt[m])
      {
      default: 
        if (m < 32) {
          _throwUnquotedSpace(m, "string value");
        }
        break;
      case 1: 
        _decodeEscaped();
        break;
      case 2: 
        _skipUtf8_2(m);
        break;
      case 3: 
        _skipUtf8_3(m);
        break;
      case 4: 
        _skipUtf8_4(m);
        break;
        _reportInvalidChar(m);
        break;
      }
    }
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
    throws IOException
  {
    if ((_currToken != JsonToken.VALUE_STRING) && ((_currToken != JsonToken.VALUE_EMBEDDED_OBJECT) || (_binaryValue == null))) {
      _reportError("Current token (" + _currToken + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
    }
    if (_tokenIncomplete) {}
    for (;;)
    {
      try
      {
        _binaryValue = _decodeBase64(paramBase64Variant);
        _tokenIncomplete = false;
        return _binaryValue;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw _constructError("Failed to decode VALUE_STRING as base64 (" + paramBase64Variant + "): " + localIllegalArgumentException.getMessage());
      }
      if (_binaryValue == null)
      {
        ByteArrayBuilder localByteArrayBuilder = _getByteArrayBuilder();
        _decodeBase64(getText(), localByteArrayBuilder, paramBase64Variant);
        _binaryValue = localByteArrayBuilder.toByteArray();
      }
    }
  }
  
  public ObjectCodec getCodec()
  {
    return _objectCodec;
  }
  
  public JsonLocation getCurrentLocation()
  {
    int i = _inputPtr;
    int j = _currInputRowStart;
    return new JsonLocation(_ioContext.getSourceReference(), _currInputProcessed + _inputPtr, -1L, _currInputRow, i - j + 1);
  }
  
  public Object getInputSource()
  {
    return _inputStream;
  }
  
  public String getText()
    throws IOException
  {
    if (_currToken == JsonToken.VALUE_STRING)
    {
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        return _finishAndReturnString();
      }
      return _textBuffer.contentsAsString();
    }
    return _getText2(_currToken);
  }
  
  public char[] getTextCharacters()
    throws IOException
  {
    if (_currToken != null)
    {
      switch (_currToken.id())
      {
      default: 
        return _currToken.asCharArray();
      case 5: 
        String str;
        int i;
        if (!_nameCopied)
        {
          str = _parsingContext.getCurrentName();
          i = str.length();
          if (_nameCopyBuffer != null) {
            break label112;
          }
          _nameCopyBuffer = _ioContext.allocNameCopyBuffer(i);
        }
        for (;;)
        {
          str.getChars(0, i, _nameCopyBuffer, 0);
          _nameCopied = true;
          return _nameCopyBuffer;
          if (_nameCopyBuffer.length < i) {
            _nameCopyBuffer = new char[i];
          }
        }
      case 6: 
        label112:
        if (_tokenIncomplete)
        {
          _tokenIncomplete = false;
          _finishString();
        }
        break;
      }
      return _textBuffer.getTextBuffer();
    }
    return null;
  }
  
  public int getTextLength()
    throws IOException
  {
    int i = 0;
    if (_currToken != null) {}
    switch (_currToken.id())
    {
    default: 
      i = _currToken.asCharArray().length;
      return i;
    case 5: 
      return _parsingContext.getCurrentName().length();
    case 6: 
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        _finishString();
      }
      break;
    }
    return _textBuffer.size();
  }
  
  public int getTextOffset()
    throws IOException
  {
    if (_currToken != null) {}
    switch (_currToken.id())
    {
    case 5: 
    default: 
      return 0;
    case 6: 
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        _finishString();
      }
      break;
    }
    return _textBuffer.getTextOffset();
  }
  
  public JsonLocation getTokenLocation()
  {
    return new JsonLocation(_ioContext.getSourceReference(), getTokenCharacterOffset(), -1L, getTokenLineNr(), getTokenColumnNr());
  }
  
  public int getValueAsInt()
    throws IOException
  {
    JsonToken localJsonToken = _currToken;
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT))
    {
      if ((_numTypesValid & 0x1) == 0)
      {
        if (_numTypesValid == 0) {
          return _parseIntValue();
        }
        if ((_numTypesValid & 0x1) == 0) {
          convertNumberToInt();
        }
      }
      return _numberInt;
    }
    return super.getValueAsInt(0);
  }
  
  public int getValueAsInt(int paramInt)
    throws IOException
  {
    JsonToken localJsonToken = _currToken;
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT))
    {
      if ((_numTypesValid & 0x1) == 0)
      {
        if (_numTypesValid == 0) {
          return _parseIntValue();
        }
        if ((_numTypesValid & 0x1) == 0) {
          convertNumberToInt();
        }
      }
      return _numberInt;
    }
    return super.getValueAsInt(paramInt);
  }
  
  public String getValueAsString()
    throws IOException
  {
    if (_currToken == JsonToken.VALUE_STRING)
    {
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        return _finishAndReturnString();
      }
      return _textBuffer.contentsAsString();
    }
    if (_currToken == JsonToken.FIELD_NAME) {
      return getCurrentName();
    }
    return super.getValueAsString(null);
  }
  
  public String getValueAsString(String paramString)
    throws IOException
  {
    if (_currToken == JsonToken.VALUE_STRING)
    {
      if (_tokenIncomplete)
      {
        _tokenIncomplete = false;
        return _finishAndReturnString();
      }
      return _textBuffer.contentsAsString();
    }
    if (_currToken == JsonToken.FIELD_NAME) {
      return getCurrentName();
    }
    return super.getValueAsString(paramString);
  }
  
  protected final boolean loadMore()
    throws IOException
  {
    _currInputProcessed += _inputEnd;
    _currInputRowStart -= _inputEnd;
    int i;
    if (_inputStream != null)
    {
      i = _inputBuffer.length;
      if (i != 0) {
        break label46;
      }
    }
    label46:
    do
    {
      return false;
      i = _inputStream.read(_inputBuffer, 0, i);
      if (i > 0)
      {
        _inputPtr = 0;
        _inputEnd = i;
        return true;
      }
      _closeInput();
    } while (i != 0);
    throw new IOException("InputStream.read() returned 0 characters when trying to read " + _inputBuffer.length + " bytes");
  }
  
  public Boolean nextBooleanValue()
    throws IOException
  {
    Boolean localBoolean = null;
    JsonToken localJsonToken;
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nameCopied = false;
      localJsonToken = _nextToken;
      _nextToken = null;
      _currToken = localJsonToken;
      if (localJsonToken == JsonToken.VALUE_TRUE) {
        localBoolean = Boolean.TRUE;
      }
    }
    do
    {
      do
      {
        return localBoolean;
        if (localJsonToken == JsonToken.VALUE_FALSE) {
          return Boolean.FALSE;
        }
        if (localJsonToken == JsonToken.START_ARRAY)
        {
          _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
          return null;
        }
      } while (localJsonToken != JsonToken.START_OBJECT);
      _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
      return null;
      localJsonToken = nextToken();
      if (localJsonToken == JsonToken.VALUE_TRUE) {
        return Boolean.TRUE;
      }
    } while (localJsonToken != JsonToken.VALUE_FALSE);
    return Boolean.FALSE;
  }
  
  public String nextFieldName()
    throws IOException
  {
    _numTypesValid = 0;
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nextAfterName();
      return null;
    }
    if (_tokenIncomplete) {
      _skipString();
    }
    int j = _skipWSOrEnd();
    if (j < 0)
    {
      close();
      _currToken = null;
      return null;
    }
    _tokenInputTotal = (_currInputProcessed + _inputPtr - 1L);
    _tokenInputRow = _currInputRow;
    _tokenInputCol = (_inputPtr - _currInputRowStart - 1);
    _binaryValue = null;
    if (j == 93)
    {
      if (!_parsingContext.inArray()) {
        _reportMismatchedEndMarker(j, '}');
      }
      _parsingContext = _parsingContext.getParent();
      _currToken = JsonToken.END_ARRAY;
      return null;
    }
    if (j == 125)
    {
      if (!_parsingContext.inObject()) {
        _reportMismatchedEndMarker(j, ']');
      }
      _parsingContext = _parsingContext.getParent();
      _currToken = JsonToken.END_OBJECT;
      return null;
    }
    int i = j;
    if (_parsingContext.expectComma())
    {
      if (j != 44) {
        _reportUnexpectedChar(j, "was expecting comma to separate " + _parsingContext.getTypeDesc() + " entries");
      }
      i = _skipWS();
    }
    if (!_parsingContext.inObject())
    {
      _nextTokenNotInObject(i);
      return null;
    }
    String str = _parseName(i);
    _parsingContext.setCurrentName(str);
    _currToken = JsonToken.FIELD_NAME;
    i = _skipColon();
    if (i == 34)
    {
      _tokenIncomplete = true;
      _nextToken = JsonToken.VALUE_STRING;
      return str;
    }
    JsonToken localJsonToken;
    switch (i)
    {
    default: 
      localJsonToken = _handleUnexpectedValue(i);
    }
    for (;;)
    {
      _nextToken = localJsonToken;
      return str;
      localJsonToken = _parseNegNumber();
      continue;
      localJsonToken = _parsePosNumber(i);
      continue;
      _matchToken("false", 1);
      localJsonToken = JsonToken.VALUE_FALSE;
      continue;
      _matchToken("null", 1);
      localJsonToken = JsonToken.VALUE_NULL;
      continue;
      _matchToken("true", 1);
      localJsonToken = JsonToken.VALUE_TRUE;
      continue;
      localJsonToken = JsonToken.START_ARRAY;
      continue;
      localJsonToken = JsonToken.START_OBJECT;
    }
  }
  
  public boolean nextFieldName(SerializableString paramSerializableString)
    throws IOException
  {
    _numTypesValid = 0;
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nextAfterName();
      return false;
    }
    if (_tokenIncomplete) {
      _skipString();
    }
    int j = _skipWSOrEnd();
    if (j < 0)
    {
      close();
      _currToken = null;
      return false;
    }
    _tokenInputTotal = (_currInputProcessed + _inputPtr - 1L);
    _tokenInputRow = _currInputRow;
    _tokenInputCol = (_inputPtr - _currInputRowStart - 1);
    _binaryValue = null;
    if (j == 93)
    {
      if (!_parsingContext.inArray()) {
        _reportMismatchedEndMarker(j, '}');
      }
      _parsingContext = _parsingContext.getParent();
      _currToken = JsonToken.END_ARRAY;
      return false;
    }
    if (j == 125)
    {
      if (!_parsingContext.inObject()) {
        _reportMismatchedEndMarker(j, ']');
      }
      _parsingContext = _parsingContext.getParent();
      _currToken = JsonToken.END_OBJECT;
      return false;
    }
    int i = j;
    if (_parsingContext.expectComma())
    {
      if (j != 44) {
        _reportUnexpectedChar(j, "was expecting comma to separate " + _parsingContext.getTypeDesc() + " entries");
      }
      i = _skipWS();
    }
    if (!_parsingContext.inObject())
    {
      _nextTokenNotInObject(i);
      return false;
    }
    byte[] arrayOfByte;
    int m;
    int k;
    if (i == 34)
    {
      arrayOfByte = paramSerializableString.asQuotedUTF8();
      j = arrayOfByte.length;
      if (_inputPtr + j + 4 < _inputEnd)
      {
        m = _inputPtr + j;
        if (_inputBuffer[m] == 34)
        {
          k = 0;
          j = _inputPtr;
        }
      }
    }
    for (;;)
    {
      if (j == m)
      {
        _parsingContext.setCurrentName(paramSerializableString.getValue());
        _isNextTokenNameYes(_skipColonFast(j + 1));
        return true;
      }
      if (arrayOfByte[k] != _inputBuffer[j]) {
        return _isNextTokenNameMaybe(i, paramSerializableString);
      }
      k += 1;
      j += 1;
    }
  }
  
  public int nextIntValue(int paramInt)
    throws IOException
  {
    JsonToken localJsonToken;
    int i;
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nameCopied = false;
      localJsonToken = _nextToken;
      _nextToken = null;
      _currToken = localJsonToken;
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
        i = getIntValue();
      }
    }
    do
    {
      do
      {
        return i;
        if (localJsonToken == JsonToken.START_ARRAY)
        {
          _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
          return paramInt;
        }
        i = paramInt;
      } while (localJsonToken != JsonToken.START_OBJECT);
      _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
      return paramInt;
      i = paramInt;
    } while (nextToken() != JsonToken.VALUE_NUMBER_INT);
    return getIntValue();
  }
  
  public long nextLongValue(long paramLong)
    throws IOException
  {
    JsonToken localJsonToken;
    long l;
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nameCopied = false;
      localJsonToken = _nextToken;
      _nextToken = null;
      _currToken = localJsonToken;
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
        l = getLongValue();
      }
    }
    do
    {
      do
      {
        return l;
        if (localJsonToken == JsonToken.START_ARRAY)
        {
          _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
          return paramLong;
        }
        l = paramLong;
      } while (localJsonToken != JsonToken.START_OBJECT);
      _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
      return paramLong;
      l = paramLong;
    } while (nextToken() != JsonToken.VALUE_NUMBER_INT);
    return getLongValue();
  }
  
  public String nextTextValue()
    throws IOException
  {
    String str = null;
    if (_currToken == JsonToken.FIELD_NAME)
    {
      _nameCopied = false;
      localJsonToken = _nextToken;
      _nextToken = null;
      _currToken = localJsonToken;
      if (localJsonToken == JsonToken.VALUE_STRING) {
        if (_tokenIncomplete)
        {
          _tokenIncomplete = false;
          str = _finishAndReturnString();
        }
      }
    }
    while (nextToken() != JsonToken.VALUE_STRING)
    {
      JsonToken localJsonToken;
      do
      {
        return str;
        return _textBuffer.contentsAsString();
        if (localJsonToken == JsonToken.START_ARRAY)
        {
          _parsingContext = _parsingContext.createChildArrayContext(_tokenInputRow, _tokenInputCol);
          return null;
        }
      } while (localJsonToken != JsonToken.START_OBJECT);
      _parsingContext = _parsingContext.createChildObjectContext(_tokenInputRow, _tokenInputCol);
      return null;
    }
    return getText();
  }
  
  public JsonToken nextToken()
    throws IOException
  {
    _numTypesValid = 0;
    if (_currToken == JsonToken.FIELD_NAME) {
      return _nextAfterName();
    }
    if (_tokenIncomplete) {
      _skipString();
    }
    int j = _skipWSOrEnd();
    if (j < 0)
    {
      close();
      _currToken = null;
      return null;
    }
    _tokenInputTotal = (_currInputProcessed + _inputPtr - 1L);
    _tokenInputRow = _currInputRow;
    _tokenInputCol = (_inputPtr - _currInputRowStart - 1);
    _binaryValue = null;
    if (j == 93)
    {
      if (!_parsingContext.inArray()) {
        _reportMismatchedEndMarker(j, '}');
      }
      _parsingContext = _parsingContext.getParent();
      localObject = JsonToken.END_ARRAY;
      _currToken = ((JsonToken)localObject);
      return (JsonToken)localObject;
    }
    if (j == 125)
    {
      if (!_parsingContext.inObject()) {
        _reportMismatchedEndMarker(j, ']');
      }
      _parsingContext = _parsingContext.getParent();
      localObject = JsonToken.END_OBJECT;
      _currToken = ((JsonToken)localObject);
      return (JsonToken)localObject;
    }
    int i = j;
    if (_parsingContext.expectComma())
    {
      if (j != 44) {
        _reportUnexpectedChar(j, "was expecting comma to separate " + _parsingContext.getTypeDesc() + " entries");
      }
      i = _skipWS();
    }
    if (!_parsingContext.inObject()) {
      return _nextTokenNotInObject(i);
    }
    Object localObject = _parseName(i);
    _parsingContext.setCurrentName((String)localObject);
    _currToken = JsonToken.FIELD_NAME;
    i = _skipColon();
    if (i == 34)
    {
      _tokenIncomplete = true;
      _nextToken = JsonToken.VALUE_STRING;
      return _currToken;
    }
    switch (i)
    {
    default: 
      localObject = _handleUnexpectedValue(i);
    }
    for (;;)
    {
      _nextToken = ((JsonToken)localObject);
      return _currToken;
      localObject = _parseNegNumber();
      continue;
      localObject = _parsePosNumber(i);
      continue;
      _matchToken("false", 1);
      localObject = JsonToken.VALUE_FALSE;
      continue;
      _matchToken("null", 1);
      localObject = JsonToken.VALUE_NULL;
      continue;
      _matchToken("true", 1);
      localObject = JsonToken.VALUE_TRUE;
      continue;
      localObject = JsonToken.START_ARRAY;
      continue;
      localObject = JsonToken.START_OBJECT;
    }
  }
  
  protected final String parseEscapedName(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException
  {
    Object localObject2 = _icLatin1;
    int i = paramInt3;
    Object localObject1;
    if (localObject2[paramInt3] != 0)
    {
      if (paramInt3 == 34)
      {
        localObject1 = paramArrayOfInt;
        paramInt3 = paramInt1;
        if (paramInt4 > 0)
        {
          localObject1 = paramArrayOfInt;
          if (paramInt1 >= paramArrayOfInt.length)
          {
            localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
            _quadBuffer = ((int[])localObject1);
          }
          localObject1[paramInt1] = pad(paramInt2, paramInt4);
          paramInt3 = paramInt1 + 1;
        }
        localObject2 = _symbols.findName((int[])localObject1, paramInt3);
        paramArrayOfInt = (int[])localObject2;
        if (localObject2 == null) {
          paramArrayOfInt = addName((int[])localObject1, paramInt3, paramInt4);
        }
        return paramArrayOfInt;
      }
      if (paramInt3 != 92)
      {
        _throwUnquotedSpace(paramInt3, "name");
        label123:
        i = paramInt3;
        if (paramInt3 <= 127) {
          break label496;
        }
        if (paramInt4 < 4) {
          break label493;
        }
        localObject1 = paramArrayOfInt;
        if (paramInt1 >= paramArrayOfInt.length)
        {
          localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
          _quadBuffer = ((int[])localObject1);
        }
        i = paramInt1 + 1;
        localObject1[paramInt1] = paramInt2;
        paramInt2 = 0;
        paramInt4 = 0;
        paramArrayOfInt = (int[])localObject1;
        paramInt1 = i;
        label184:
        if (paramInt3 >= 2048) {
          break label330;
        }
        i = paramInt2 << 8 | paramInt3 >> 6 | 0xC0;
        paramInt2 = paramInt4 + 1;
        paramInt4 = paramInt1;
        paramInt1 = i;
        paramInt3 = paramInt3 & 0x3F | 0x80;
        i = paramInt2;
        paramInt2 = paramInt3;
        paramInt3 = paramInt1;
        paramInt1 = paramInt4;
      }
    }
    for (;;)
    {
      if (i < 4)
      {
        paramInt4 = i + 1;
        paramInt2 = paramInt3 << 8 | paramInt2;
        label262:
        if ((_inputPtr >= _inputEnd) && (!loadMore())) {
          _reportInvalidEOF(" in field name");
        }
        localObject1 = _inputBuffer;
        paramInt3 = _inputPtr;
        _inputPtr = (paramInt3 + 1);
        paramInt3 = localObject1[paramInt3] & 0xFF;
        break;
        paramInt3 = _decodeEscaped();
        break label123;
        label330:
        paramInt2 = paramInt2 << 8 | paramInt3 >> 12 | 0xE0;
        i = paramInt4 + 1;
        if (i < 4) {
          break label484;
        }
        localObject1 = paramArrayOfInt;
        if (paramInt1 >= paramArrayOfInt.length)
        {
          localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
          _quadBuffer = ((int[])localObject1);
        }
        i = paramInt1 + 1;
        localObject1[paramInt1] = paramInt2;
        paramInt4 = 0;
        paramInt2 = 0;
        paramInt1 = i;
        paramArrayOfInt = (int[])localObject1;
      }
      for (;;)
      {
        i = paramInt4 << 8 | paramInt3 >> 6 & 0x3F | 0x80;
        paramInt2 += 1;
        paramInt4 = paramInt1;
        paramInt1 = i;
        break;
        localObject1 = paramArrayOfInt;
        if (paramInt1 >= paramArrayOfInt.length)
        {
          localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
          _quadBuffer = ((int[])localObject1);
        }
        paramInt4 = paramInt1 + 1;
        localObject1[paramInt1] = paramInt3;
        paramInt3 = 1;
        paramArrayOfInt = (int[])localObject1;
        paramInt1 = paramInt4;
        paramInt4 = paramInt3;
        break label262;
        label484:
        paramInt4 = paramInt2;
        paramInt2 = i;
      }
      label493:
      break label184;
      label496:
      paramInt3 = paramInt2;
      paramInt2 = i;
      i = paramInt4;
    }
  }
  
  protected final String parseLongName(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    _quadBuffer[0] = _quad1;
    _quadBuffer[1] = paramInt2;
    _quadBuffer[2] = paramInt3;
    byte[] arrayOfByte = _inputBuffer;
    int[] arrayOfInt = _icLatin1;
    paramInt3 = 3;
    paramInt2 = paramInt1;
    paramInt1 = paramInt3;
    while (_inputPtr + 4 <= _inputEnd)
    {
      paramInt3 = _inputPtr;
      _inputPtr = (paramInt3 + 1);
      paramInt3 = arrayOfByte[paramInt3] & 0xFF;
      if (arrayOfInt[paramInt3] != 0)
      {
        if (paramInt3 == 34) {
          return findName(_quadBuffer, paramInt1, paramInt2, 1);
        }
        return parseEscapedName(_quadBuffer, paramInt1, paramInt2, paramInt3, 1);
      }
      paramInt2 = paramInt2 << 8 | paramInt3;
      paramInt3 = _inputPtr;
      _inputPtr = (paramInt3 + 1);
      paramInt3 = arrayOfByte[paramInt3] & 0xFF;
      if (arrayOfInt[paramInt3] != 0)
      {
        if (paramInt3 == 34) {
          return findName(_quadBuffer, paramInt1, paramInt2, 2);
        }
        return parseEscapedName(_quadBuffer, paramInt1, paramInt2, paramInt3, 2);
      }
      paramInt2 = paramInt2 << 8 | paramInt3;
      paramInt3 = _inputPtr;
      _inputPtr = (paramInt3 + 1);
      paramInt3 = arrayOfByte[paramInt3] & 0xFF;
      if (arrayOfInt[paramInt3] != 0)
      {
        if (paramInt3 == 34) {
          return findName(_quadBuffer, paramInt1, paramInt2, 3);
        }
        return parseEscapedName(_quadBuffer, paramInt1, paramInt2, paramInt3, 3);
      }
      paramInt3 = paramInt2 << 8 | paramInt3;
      paramInt2 = _inputPtr;
      _inputPtr = (paramInt2 + 1);
      paramInt2 = arrayOfByte[paramInt2] & 0xFF;
      if (arrayOfInt[paramInt2] != 0)
      {
        if (paramInt2 == 34) {
          return findName(_quadBuffer, paramInt1, paramInt3, 4);
        }
        return parseEscapedName(_quadBuffer, paramInt1, paramInt3, paramInt2, 4);
      }
      if (paramInt1 >= _quadBuffer.length) {
        _quadBuffer = growArrayBy(_quadBuffer, paramInt1);
      }
      _quadBuffer[paramInt1] = paramInt3;
      paramInt1 += 1;
    }
    return parseEscapedName(_quadBuffer, paramInt1, 0, paramInt2, 0);
  }
  
  protected final String parseMediumName(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = _inputBuffer;
    int[] arrayOfInt = _icLatin1;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (arrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, paramInt, 1);
      }
      return parseName(_quad1, paramInt, i, 1);
    }
    paramInt = paramInt << 8 | i;
    i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (arrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, paramInt, 2);
      }
      return parseName(_quad1, paramInt, i, 2);
    }
    paramInt = paramInt << 8 | i;
    i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (arrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, paramInt, 3);
      }
      return parseName(_quad1, paramInt, i, 3);
    }
    paramInt = paramInt << 8 | i;
    i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (arrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, paramInt, 4);
      }
      return parseName(_quad1, paramInt, i, 4);
    }
    return parseMediumName2(i, paramInt);
  }
  
  protected final String parseMediumName2(int paramInt1, int paramInt2)
    throws IOException
  {
    byte[] arrayOfByte = _inputBuffer;
    int[] arrayOfInt = _icLatin1;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (arrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, paramInt2, paramInt1, 1);
      }
      return parseName(_quad1, paramInt2, paramInt1, i, 1);
    }
    paramInt1 = paramInt1 << 8 | i;
    i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (arrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, paramInt2, paramInt1, 2);
      }
      return parseName(_quad1, paramInt2, paramInt1, i, 2);
    }
    paramInt1 = paramInt1 << 8 | i;
    i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (arrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, paramInt2, paramInt1, 3);
      }
      return parseName(_quad1, paramInt2, paramInt1, i, 3);
    }
    paramInt1 = paramInt1 << 8 | i;
    i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (arrayOfInt[i] != 0)
    {
      if (i == 34) {
        return findName(_quad1, paramInt2, paramInt1, 4);
      }
      return parseName(_quad1, paramInt2, paramInt1, i, 4);
    }
    return parseLongName(i, paramInt2, paramInt1);
  }
  
  public int readBinaryValue(Base64Variant paramBase64Variant, OutputStream paramOutputStream)
    throws IOException
  {
    if ((!_tokenIncomplete) || (_currToken != JsonToken.VALUE_STRING))
    {
      paramBase64Variant = getBinaryValue(paramBase64Variant);
      paramOutputStream.write(paramBase64Variant);
      return paramBase64Variant.length;
    }
    byte[] arrayOfByte = _ioContext.allocBase64Buffer();
    try
    {
      int i = _readBinary(paramBase64Variant, paramOutputStream, arrayOfByte);
      return i;
    }
    finally
    {
      _ioContext.releaseBase64Buffer(arrayOfByte);
    }
  }
  
  public int releaseBuffered(OutputStream paramOutputStream)
    throws IOException
  {
    int i = _inputEnd - _inputPtr;
    if (i < 1) {
      return 0;
    }
    int j = _inputPtr;
    paramOutputStream.write(_inputBuffer, j, i);
    return i;
  }
  
  public void setCodec(ObjectCodec paramObjectCodec)
  {
    _objectCodec = paramObjectCodec;
  }
  
  protected String slowParseName()
    throws IOException
  {
    if ((_inputPtr >= _inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing '\"' for name");
    }
    byte[] arrayOfByte = _inputBuffer;
    int i = _inputPtr;
    _inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (i == 34) {
      return "";
    }
    return parseEscapedName(_quadBuffer, 0, 0, i, 0);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.json.UTF8StreamJsonParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */