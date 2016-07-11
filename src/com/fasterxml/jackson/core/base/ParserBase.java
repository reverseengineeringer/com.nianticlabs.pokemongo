package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class ParserBase
  extends ParserMinimalBase
{
  static final BigDecimal BD_MAX_INT = new BigDecimal(BI_MAX_INT);
  static final BigDecimal BD_MAX_LONG;
  static final BigDecimal BD_MIN_INT;
  static final BigDecimal BD_MIN_LONG;
  static final BigInteger BI_MAX_INT;
  static final BigInteger BI_MAX_LONG;
  static final BigInteger BI_MIN_INT = BigInteger.valueOf(-2147483648L);
  static final BigInteger BI_MIN_LONG;
  protected static final char CHAR_NULL = '\000';
  protected static final int INT_0 = 48;
  protected static final int INT_9 = 57;
  protected static final int INT_MINUS = 45;
  protected static final int INT_PLUS = 43;
  static final double MAX_INT_D = 2.147483647E9D;
  static final long MAX_INT_L = 2147483647L;
  static final double MAX_LONG_D = 9.223372036854776E18D;
  static final double MIN_INT_D = -2.147483648E9D;
  static final long MIN_INT_L = -2147483648L;
  static final double MIN_LONG_D = -9.223372036854776E18D;
  protected static final int NR_BIGDECIMAL = 16;
  protected static final int NR_BIGINT = 4;
  protected static final int NR_DOUBLE = 8;
  protected static final int NR_INT = 1;
  protected static final int NR_LONG = 2;
  protected static final int NR_UNKNOWN = 0;
  protected byte[] _binaryValue;
  protected ByteArrayBuilder _byteArrayBuilder = null;
  protected boolean _closed;
  protected long _currInputProcessed = 0L;
  protected int _currInputRow = 1;
  protected int _currInputRowStart = 0;
  protected int _expLength;
  protected int _fractLength;
  protected int _inputEnd = 0;
  protected int _inputPtr = 0;
  protected int _intLength;
  protected final IOContext _ioContext;
  protected boolean _nameCopied = false;
  protected char[] _nameCopyBuffer = null;
  protected JsonToken _nextToken;
  protected int _numTypesValid = 0;
  protected BigDecimal _numberBigDecimal;
  protected BigInteger _numberBigInt;
  protected double _numberDouble;
  protected int _numberInt;
  protected long _numberLong;
  protected boolean _numberNegative;
  protected JsonReadContext _parsingContext;
  protected final TextBuffer _textBuffer;
  protected int _tokenInputCol = 0;
  protected int _tokenInputRow = 1;
  protected long _tokenInputTotal = 0L;
  
  static
  {
    BI_MAX_INT = BigInteger.valueOf(2147483647L);
    BI_MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
    BI_MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
    BD_MIN_LONG = new BigDecimal(BI_MIN_LONG);
    BD_MAX_LONG = new BigDecimal(BI_MAX_LONG);
    BD_MIN_INT = new BigDecimal(BI_MIN_INT);
  }
  
  protected ParserBase(IOContext paramIOContext, int paramInt)
  {
    super(paramInt);
    _ioContext = paramIOContext;
    _textBuffer = paramIOContext.constructTextBuffer();
    paramIOContext = (IOContext)localObject;
    if (JsonParser.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(paramInt)) {
      paramIOContext = DupDetector.rootDetector(this);
    }
    _parsingContext = JsonReadContext.createRootContext(paramIOContext);
  }
  
  private void _parseSlowFloat(int paramInt)
    throws IOException
  {
    if (paramInt == 16) {}
    try
    {
      _numberBigDecimal = _textBuffer.contentsAsDecimal();
      _numTypesValid = 16;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      _wrapError("Malformed numeric value '" + _textBuffer.contentsAsString() + "'", localNumberFormatException);
    }
    _numberDouble = _textBuffer.contentsAsDouble();
    _numTypesValid = 8;
    return;
  }
  
  private void _parseSlowInt(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
    throws IOException
  {
    String str = _textBuffer.contentsAsString();
    try
    {
      if (NumberInput.inLongRange(paramArrayOfChar, paramInt2, paramInt3, _numberNegative))
      {
        _numberLong = Long.parseLong(str);
        _numTypesValid = 2;
        return;
      }
      _numberBigInt = new BigInteger(str);
      _numTypesValid = 4;
      return;
    }
    catch (NumberFormatException paramArrayOfChar)
    {
      _wrapError("Malformed numeric value '" + str + "'", paramArrayOfChar);
    }
  }
  
  protected abstract void _closeInput()
    throws IOException;
  
  protected final int _decodeBase64Escape(Base64Variant paramBase64Variant, char paramChar, int paramInt)
    throws IOException
  {
    if (paramChar != '\\') {
      throw reportInvalidBase64Char(paramBase64Variant, paramChar, paramInt);
    }
    char c1 = _decodeEscaped();
    if ((c1 <= ' ') && (paramInt == 0)) {
      paramChar = '￿';
    }
    char c2;
    do
    {
      return paramChar;
      c2 = paramBase64Variant.decodeBase64Char(c1);
      paramChar = c2;
    } while (c2 >= 0);
    throw reportInvalidBase64Char(paramBase64Variant, c1, paramInt);
  }
  
  protected final int _decodeBase64Escape(Base64Variant paramBase64Variant, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt1 != 92) {
      throw reportInvalidBase64Char(paramBase64Variant, paramInt1, paramInt2);
    }
    int j = _decodeEscaped();
    if ((j <= 32) && (paramInt2 == 0)) {
      paramInt1 = -1;
    }
    int i;
    do
    {
      return paramInt1;
      i = paramBase64Variant.decodeBase64Char(j);
      paramInt1 = i;
    } while (i >= 0);
    throw reportInvalidBase64Char(paramBase64Variant, j, paramInt2);
  }
  
  protected char _decodeEscaped()
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  protected final int _eofAsNextChar()
    throws JsonParseException
  {
    _handleEOF();
    return -1;
  }
  
  protected abstract void _finishString()
    throws IOException;
  
  public ByteArrayBuilder _getByteArrayBuilder()
  {
    if (_byteArrayBuilder == null) {
      _byteArrayBuilder = new ByteArrayBuilder();
    }
    for (;;)
    {
      return _byteArrayBuilder;
      _byteArrayBuilder.reset();
    }
  }
  
  protected void _handleEOF()
    throws JsonParseException
  {
    if (!_parsingContext.inRoot()) {
      _reportInvalidEOF(": expected close marker for " + _parsingContext.getTypeDesc() + " (from " + _parsingContext.getStartLocation(_ioContext.getSourceReference()) + ")");
    }
  }
  
  protected int _parseIntValue()
    throws IOException
  {
    if (_currToken == JsonToken.VALUE_NUMBER_INT)
    {
      char[] arrayOfChar = _textBuffer.getTextBuffer();
      int j = _textBuffer.getTextOffset();
      int k = _intLength;
      int i = j;
      if (_numberNegative) {
        i = j + 1;
      }
      if (k <= 9)
      {
        j = NumberInput.parseInt(arrayOfChar, i, k);
        i = j;
        if (_numberNegative) {
          i = -j;
        }
        _numberInt = i;
        _numTypesValid = 1;
        return i;
      }
    }
    _parseNumericValue(1);
    if ((_numTypesValid & 0x1) == 0) {
      convertNumberToInt();
    }
    return _numberInt;
  }
  
  protected void _parseNumericValue(int paramInt)
    throws IOException
  {
    if (_currToken == JsonToken.VALUE_NUMBER_INT)
    {
      char[] arrayOfChar = _textBuffer.getTextBuffer();
      int j = _textBuffer.getTextOffset();
      int k = _intLength;
      int i = j;
      if (_numberNegative) {
        i = j + 1;
      }
      if (k <= 9)
      {
        i = NumberInput.parseInt(arrayOfChar, i, k);
        paramInt = i;
        if (_numberNegative) {
          paramInt = -i;
        }
        _numberInt = paramInt;
        _numTypesValid = 1;
        return;
      }
      if (k <= 18)
      {
        long l2 = NumberInput.parseLong(arrayOfChar, i, k);
        long l1 = l2;
        if (_numberNegative) {
          l1 = -l2;
        }
        if (k == 10) {
          if (_numberNegative)
          {
            if (l1 >= -2147483648L)
            {
              _numberInt = ((int)l1);
              _numTypesValid = 1;
            }
          }
          else if (l1 <= 2147483647L)
          {
            _numberInt = ((int)l1);
            _numTypesValid = 1;
            return;
          }
        }
        _numberLong = l1;
        _numTypesValid = 2;
        return;
      }
      _parseSlowInt(paramInt, arrayOfChar, i, k);
      return;
    }
    if (_currToken == JsonToken.VALUE_NUMBER_FLOAT)
    {
      _parseSlowFloat(paramInt);
      return;
    }
    _reportError("Current token (" + _currToken + ") not numeric, can not use numeric value accessors");
  }
  
  protected void _releaseBuffers()
    throws IOException
  {
    _textBuffer.releaseBuffers();
    char[] arrayOfChar = _nameCopyBuffer;
    if (arrayOfChar != null)
    {
      _nameCopyBuffer = null;
      _ioContext.releaseNameCopyBuffer(arrayOfChar);
    }
  }
  
  protected void _reportMismatchedEndMarker(int paramInt, char paramChar)
    throws JsonParseException
  {
    String str = "" + _parsingContext.getStartLocation(_ioContext.getSourceReference());
    _reportError("Unexpected close marker '" + (char)paramInt + "': expected '" + paramChar + "' (for " + _parsingContext.getTypeDesc() + " starting at " + str + ")");
  }
  
  public void close()
    throws IOException
  {
    if (!_closed) {
      _closed = true;
    }
    try
    {
      _closeInput();
      return;
    }
    finally
    {
      _releaseBuffers();
    }
  }
  
  protected void convertNumberToBigDecimal()
    throws IOException
  {
    if ((_numTypesValid & 0x8) != 0) {
      _numberBigDecimal = NumberInput.parseBigDecimal(getText());
    }
    for (;;)
    {
      _numTypesValid |= 0x10;
      return;
      if ((_numTypesValid & 0x4) != 0) {
        _numberBigDecimal = new BigDecimal(_numberBigInt);
      } else if ((_numTypesValid & 0x2) != 0) {
        _numberBigDecimal = BigDecimal.valueOf(_numberLong);
      } else if ((_numTypesValid & 0x1) != 0) {
        _numberBigDecimal = BigDecimal.valueOf(_numberInt);
      } else {
        _throwInternal();
      }
    }
  }
  
  protected void convertNumberToBigInteger()
    throws IOException
  {
    if ((_numTypesValid & 0x10) != 0) {
      _numberBigInt = _numberBigDecimal.toBigInteger();
    }
    for (;;)
    {
      _numTypesValid |= 0x4;
      return;
      if ((_numTypesValid & 0x2) != 0) {
        _numberBigInt = BigInteger.valueOf(_numberLong);
      } else if ((_numTypesValid & 0x1) != 0) {
        _numberBigInt = BigInteger.valueOf(_numberInt);
      } else if ((_numTypesValid & 0x8) != 0) {
        _numberBigInt = BigDecimal.valueOf(_numberDouble).toBigInteger();
      } else {
        _throwInternal();
      }
    }
  }
  
  protected void convertNumberToDouble()
    throws IOException
  {
    if ((_numTypesValid & 0x10) != 0) {
      _numberDouble = _numberBigDecimal.doubleValue();
    }
    for (;;)
    {
      _numTypesValid |= 0x8;
      return;
      if ((_numTypesValid & 0x4) != 0) {
        _numberDouble = _numberBigInt.doubleValue();
      } else if ((_numTypesValid & 0x2) != 0) {
        _numberDouble = _numberLong;
      } else if ((_numTypesValid & 0x1) != 0) {
        _numberDouble = _numberInt;
      } else {
        _throwInternal();
      }
    }
  }
  
  protected void convertNumberToInt()
    throws IOException
  {
    if ((_numTypesValid & 0x2) != 0)
    {
      int i = (int)_numberLong;
      if (i != _numberLong) {
        _reportError("Numeric value (" + getText() + ") out of range of int");
      }
      _numberInt = i;
    }
    for (;;)
    {
      _numTypesValid |= 0x1;
      return;
      if ((_numTypesValid & 0x4) != 0)
      {
        if ((BI_MIN_INT.compareTo(_numberBigInt) > 0) || (BI_MAX_INT.compareTo(_numberBigInt) < 0)) {
          reportOverflowInt();
        }
        _numberInt = _numberBigInt.intValue();
      }
      else if ((_numTypesValid & 0x8) != 0)
      {
        if ((_numberDouble < -2.147483648E9D) || (_numberDouble > 2.147483647E9D)) {
          reportOverflowInt();
        }
        _numberInt = ((int)_numberDouble);
      }
      else if ((_numTypesValid & 0x10) != 0)
      {
        if ((BD_MIN_INT.compareTo(_numberBigDecimal) > 0) || (BD_MAX_INT.compareTo(_numberBigDecimal) < 0)) {
          reportOverflowInt();
        }
        _numberInt = _numberBigDecimal.intValue();
      }
      else
      {
        _throwInternal();
      }
    }
  }
  
  protected void convertNumberToLong()
    throws IOException
  {
    if ((_numTypesValid & 0x1) != 0) {
      _numberLong = _numberInt;
    }
    for (;;)
    {
      _numTypesValid |= 0x2;
      return;
      if ((_numTypesValid & 0x4) != 0)
      {
        if ((BI_MIN_LONG.compareTo(_numberBigInt) > 0) || (BI_MAX_LONG.compareTo(_numberBigInt) < 0)) {
          reportOverflowLong();
        }
        _numberLong = _numberBigInt.longValue();
      }
      else if ((_numTypesValid & 0x8) != 0)
      {
        if ((_numberDouble < -9.223372036854776E18D) || (_numberDouble > 9.223372036854776E18D)) {
          reportOverflowLong();
        }
        _numberLong = (_numberDouble);
      }
      else if ((_numTypesValid & 0x10) != 0)
      {
        if ((BD_MIN_LONG.compareTo(_numberBigDecimal) > 0) || (BD_MAX_LONG.compareTo(_numberBigDecimal) < 0)) {
          reportOverflowLong();
        }
        _numberLong = _numberBigDecimal.longValue();
      }
      else
      {
        _throwInternal();
      }
    }
  }
  
  public JsonParser disable(JsonParser.Feature paramFeature)
  {
    _features &= (paramFeature.getMask() ^ 0xFFFFFFFF);
    if (paramFeature == JsonParser.Feature.STRICT_DUPLICATE_DETECTION) {
      _parsingContext = _parsingContext.withDupDetector(null);
    }
    return this;
  }
  
  public JsonParser enable(JsonParser.Feature paramFeature)
  {
    _features |= paramFeature.getMask();
    if ((paramFeature == JsonParser.Feature.STRICT_DUPLICATE_DETECTION) && (_parsingContext.getDupDetector() == null)) {
      _parsingContext = _parsingContext.withDupDetector(DupDetector.rootDetector(this));
    }
    return this;
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException
  {
    if ((_numTypesValid & 0x4) == 0)
    {
      if (_numTypesValid == 0) {
        _parseNumericValue(4);
      }
      if ((_numTypesValid & 0x4) == 0) {
        convertNumberToBigInteger();
      }
    }
    return _numberBigInt;
  }
  
  public JsonLocation getCurrentLocation()
  {
    int i = _inputPtr;
    int j = _currInputRowStart;
    return new JsonLocation(_ioContext.getSourceReference(), -1L, _currInputProcessed + _inputPtr, _currInputRow, i - j + 1);
  }
  
  public String getCurrentName()
    throws IOException
  {
    if ((_currToken == JsonToken.START_OBJECT) || (_currToken == JsonToken.START_ARRAY)) {
      return _parsingContext.getParent().getCurrentName();
    }
    return _parsingContext.getCurrentName();
  }
  
  public Object getCurrentValue()
  {
    return _parsingContext.getCurrentValue();
  }
  
  public BigDecimal getDecimalValue()
    throws IOException
  {
    if ((_numTypesValid & 0x10) == 0)
    {
      if (_numTypesValid == 0) {
        _parseNumericValue(16);
      }
      if ((_numTypesValid & 0x10) == 0) {
        convertNumberToBigDecimal();
      }
    }
    return _numberBigDecimal;
  }
  
  public double getDoubleValue()
    throws IOException
  {
    if ((_numTypesValid & 0x8) == 0)
    {
      if (_numTypesValid == 0) {
        _parseNumericValue(8);
      }
      if ((_numTypesValid & 0x8) == 0) {
        convertNumberToDouble();
      }
    }
    return _numberDouble;
  }
  
  public Object getEmbeddedObject()
    throws IOException
  {
    return null;
  }
  
  public float getFloatValue()
    throws IOException
  {
    return (float)getDoubleValue();
  }
  
  public int getIntValue()
    throws IOException
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
  
  public long getLongValue()
    throws IOException
  {
    if ((_numTypesValid & 0x2) == 0)
    {
      if (_numTypesValid == 0) {
        _parseNumericValue(2);
      }
      if ((_numTypesValid & 0x2) == 0) {
        convertNumberToLong();
      }
    }
    return _numberLong;
  }
  
  public JsonParser.NumberType getNumberType()
    throws IOException
  {
    if (_numTypesValid == 0) {
      _parseNumericValue(0);
    }
    if (_currToken == JsonToken.VALUE_NUMBER_INT)
    {
      if ((_numTypesValid & 0x1) != 0) {
        return JsonParser.NumberType.INT;
      }
      if ((_numTypesValid & 0x2) != 0) {
        return JsonParser.NumberType.LONG;
      }
      return JsonParser.NumberType.BIG_INTEGER;
    }
    if ((_numTypesValid & 0x10) != 0) {
      return JsonParser.NumberType.BIG_DECIMAL;
    }
    return JsonParser.NumberType.DOUBLE;
  }
  
  public Number getNumberValue()
    throws IOException
  {
    if (_numTypesValid == 0) {
      _parseNumericValue(0);
    }
    if (_currToken == JsonToken.VALUE_NUMBER_INT)
    {
      if ((_numTypesValid & 0x1) != 0) {
        return Integer.valueOf(_numberInt);
      }
      if ((_numTypesValid & 0x2) != 0) {
        return Long.valueOf(_numberLong);
      }
      if ((_numTypesValid & 0x4) != 0) {
        return _numberBigInt;
      }
      return _numberBigDecimal;
    }
    if ((_numTypesValid & 0x10) != 0) {
      return _numberBigDecimal;
    }
    if ((_numTypesValid & 0x8) == 0) {
      _throwInternal();
    }
    return Double.valueOf(_numberDouble);
  }
  
  public JsonReadContext getParsingContext()
  {
    return _parsingContext;
  }
  
  public long getTokenCharacterOffset()
  {
    return _tokenInputTotal;
  }
  
  public int getTokenColumnNr()
  {
    int i = _tokenInputCol;
    if (i < 0) {
      return i;
    }
    return i + 1;
  }
  
  public int getTokenLineNr()
  {
    return _tokenInputRow;
  }
  
  public JsonLocation getTokenLocation()
  {
    return new JsonLocation(_ioContext.getSourceReference(), -1L, getTokenCharacterOffset(), getTokenLineNr(), getTokenColumnNr());
  }
  
  public boolean hasTextCharacters()
  {
    if (_currToken == JsonToken.VALUE_STRING) {
      return true;
    }
    if (_currToken == JsonToken.FIELD_NAME) {
      return _nameCopied;
    }
    return false;
  }
  
  public boolean isClosed()
  {
    return _closed;
  }
  
  protected abstract boolean loadMore()
    throws IOException;
  
  protected final void loadMoreGuaranteed()
    throws IOException
  {
    if (!loadMore()) {
      _reportInvalidEOF();
    }
  }
  
  public void overrideCurrentName(String paramString)
  {
    JsonReadContext localJsonReadContext2 = _parsingContext;
    JsonReadContext localJsonReadContext1;
    if (_currToken != JsonToken.START_OBJECT)
    {
      localJsonReadContext1 = localJsonReadContext2;
      if (_currToken != JsonToken.START_ARRAY) {}
    }
    else
    {
      localJsonReadContext1 = localJsonReadContext2.getParent();
    }
    try
    {
      localJsonReadContext1.setCurrentName(paramString);
      return;
    }
    catch (IOException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  protected IllegalArgumentException reportInvalidBase64Char(Base64Variant paramBase64Variant, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    return reportInvalidBase64Char(paramBase64Variant, paramInt1, paramInt2, null);
  }
  
  protected IllegalArgumentException reportInvalidBase64Char(Base64Variant paramBase64Variant, int paramInt1, int paramInt2, String paramString)
    throws IllegalArgumentException
  {
    if (paramInt1 <= 32) {
      paramBase64Variant = "Illegal white space character (code 0x" + Integer.toHexString(paramInt1) + ") as character #" + (paramInt2 + 1) + " of 4-char base64 unit: can only used between units";
    }
    for (;;)
    {
      Object localObject = paramBase64Variant;
      if (paramString != null) {
        localObject = paramBase64Variant + ": " + paramString;
      }
      return new IllegalArgumentException((String)localObject);
      if (paramBase64Variant.usesPaddingChar(paramInt1)) {
        paramBase64Variant = "Unexpected padding character ('" + paramBase64Variant.getPaddingChar() + "') as character #" + (paramInt2 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
      } else if ((!Character.isDefined(paramInt1)) || (Character.isISOControl(paramInt1))) {
        paramBase64Variant = "Illegal character (code 0x" + Integer.toHexString(paramInt1) + ") in base64 content";
      } else {
        paramBase64Variant = "Illegal character '" + (char)paramInt1 + "' (code 0x" + Integer.toHexString(paramInt1) + ") in base64 content";
      }
    }
  }
  
  protected void reportInvalidNumber(String paramString)
    throws JsonParseException
  {
    _reportError("Invalid numeric value: " + paramString);
  }
  
  protected void reportOverflowInt()
    throws IOException
  {
    _reportError("Numeric value (" + getText() + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
  }
  
  protected void reportOverflowLong()
    throws IOException
  {
    _reportError("Numeric value (" + getText() + ") out of range of long (" + Long.MIN_VALUE + " - " + Long.MAX_VALUE + ")");
  }
  
  protected void reportUnexpectedNumberChar(int paramInt, String paramString)
    throws JsonParseException
  {
    String str2 = "Unexpected character (" + _getCharDesc(paramInt) + ") in numeric value";
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + ": " + paramString;
    }
    _reportError(str1);
  }
  
  protected final JsonToken reset(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < 1) && (paramInt3 < 1)) {
      return resetInt(paramBoolean, paramInt1);
    }
    return resetFloat(paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  protected final JsonToken resetAsNaN(String paramString, double paramDouble)
  {
    _textBuffer.resetWithString(paramString);
    _numberDouble = paramDouble;
    _numTypesValid = 8;
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  protected final JsonToken resetFloat(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    _numberNegative = paramBoolean;
    _intLength = paramInt1;
    _fractLength = paramInt2;
    _expLength = paramInt3;
    _numTypesValid = 0;
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  protected final JsonToken resetInt(boolean paramBoolean, int paramInt)
  {
    _numberNegative = paramBoolean;
    _intLength = paramInt;
    _fractLength = 0;
    _expLength = 0;
    _numTypesValid = 0;
    return JsonToken.VALUE_NUMBER_INT;
  }
  
  public void setCurrentValue(Object paramObject)
  {
    _parsingContext.setCurrentValue(paramObject);
  }
  
  public JsonParser setFeatureMask(int paramInt)
  {
    if ((_features ^ paramInt) != 0)
    {
      _features = paramInt;
      if (!JsonParser.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(paramInt)) {
        break label51;
      }
      if (_parsingContext.getDupDetector() == null) {
        _parsingContext = _parsingContext.withDupDetector(DupDetector.rootDetector(this));
      }
    }
    return this;
    label51:
    _parsingContext = _parsingContext.withDupDetector(null);
    return this;
  }
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.base.ParserBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */