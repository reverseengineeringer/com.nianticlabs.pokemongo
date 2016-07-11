package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class FilteringGeneratorDelegate
  extends JsonGeneratorDelegate
{
  protected boolean _allowMultipleMatches;
  protected TokenFilterContext _filterContext;
  @Deprecated
  protected boolean _includeImmediateParent = false;
  protected boolean _includePath;
  protected TokenFilter _itemFilter;
  protected int _matchCount;
  protected TokenFilter rootFilter;
  
  public FilteringGeneratorDelegate(JsonGenerator paramJsonGenerator, TokenFilter paramTokenFilter, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramJsonGenerator, false);
    rootFilter = paramTokenFilter;
    _itemFilter = paramTokenFilter;
    _filterContext = TokenFilterContext.createRootContext(paramTokenFilter);
    _includePath = paramBoolean1;
    _allowMultipleMatches = paramBoolean2;
  }
  
  protected boolean _checkBinaryWrite()
    throws IOException
  {
    if (_itemFilter == null) {}
    do
    {
      return false;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        return true;
      }
    } while (!_itemFilter.includeBinary());
    _checkParentPath();
    return true;
  }
  
  protected void _checkParentPath()
    throws IOException
  {
    _matchCount += 1;
    if (_includePath) {
      _filterContext.writePath(delegate);
    }
    if (!_allowMultipleMatches) {
      _filterContext.skipParentChecks();
    }
  }
  
  protected void _checkPropertyParentPath()
    throws IOException
  {
    _matchCount += 1;
    if (_includePath) {
      _filterContext.writePath(delegate);
    }
    for (;;)
    {
      if (!_allowMultipleMatches) {
        _filterContext.skipParentChecks();
      }
      return;
      if (_includeImmediateParent) {
        _filterContext.writeImmediatePath(delegate);
      }
    }
  }
  
  protected boolean _checkRawValueWrite()
    throws IOException
  {
    if (_itemFilter == null) {}
    do
    {
      return false;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        return true;
      }
    } while (!_itemFilter.includeRawValue());
    _checkParentPath();
    return true;
  }
  
  public TokenFilter getFilter()
  {
    return rootFilter;
  }
  
  public JsonStreamContext getFilterContext()
  {
    return _filterContext;
  }
  
  public int getMatchCount()
  {
    return _matchCount;
  }
  
  public JsonStreamContext getOutputContext()
  {
    return _filterContext;
  }
  
  public int writeBinary(Base64Variant paramBase64Variant, InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if (_checkBinaryWrite()) {
      return delegate.writeBinary(paramBase64Variant, paramInputStream, paramInt);
    }
    return -1;
  }
  
  public void writeBinary(Base64Variant paramBase64Variant, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (_checkBinaryWrite()) {
      delegate.writeBinary(paramBase64Variant, paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public void writeBoolean(boolean paramBoolean)
    throws IOException
  {
    if (_itemFilter == null) {}
    TokenFilter localTokenFilter;
    do
    {
      return;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        break;
      }
      localTokenFilter = _filterContext.checkValue(_itemFilter);
    } while ((localTokenFilter == null) || ((localTokenFilter != TokenFilter.INCLUDE_ALL) && (!localTokenFilter.includeBoolean(paramBoolean))));
    _checkParentPath();
    delegate.writeBoolean(paramBoolean);
  }
  
  public void writeEndArray()
    throws IOException
  {
    _filterContext = _filterContext.closeArray(delegate);
    if (_filterContext != null) {
      _itemFilter = _filterContext.getFilter();
    }
  }
  
  public void writeEndObject()
    throws IOException
  {
    _filterContext = _filterContext.closeObject(delegate);
    if (_filterContext != null) {
      _itemFilter = _filterContext.getFilter();
    }
  }
  
  public void writeFieldName(SerializableString paramSerializableString)
    throws IOException
  {
    TokenFilter localTokenFilter = _filterContext.setFieldName(paramSerializableString.getValue());
    if (localTokenFilter == null) {
      _itemFilter = null;
    }
    do
    {
      return;
      if (localTokenFilter == TokenFilter.INCLUDE_ALL)
      {
        _itemFilter = localTokenFilter;
        delegate.writeFieldName(paramSerializableString);
        return;
      }
      paramSerializableString = localTokenFilter.includeProperty(paramSerializableString.getValue());
      _itemFilter = paramSerializableString;
    } while (paramSerializableString != TokenFilter.INCLUDE_ALL);
    _checkPropertyParentPath();
  }
  
  public void writeFieldName(String paramString)
    throws IOException
  {
    TokenFilter localTokenFilter = _filterContext.setFieldName(paramString);
    if (localTokenFilter == null) {
      _itemFilter = null;
    }
    do
    {
      return;
      if (localTokenFilter == TokenFilter.INCLUDE_ALL)
      {
        _itemFilter = localTokenFilter;
        delegate.writeFieldName(paramString);
        return;
      }
      paramString = localTokenFilter.includeProperty(paramString);
      _itemFilter = paramString;
    } while (paramString != TokenFilter.INCLUDE_ALL);
    _checkPropertyParentPath();
  }
  
  public void writeNull()
    throws IOException
  {
    if (_itemFilter == null) {}
    TokenFilter localTokenFilter;
    do
    {
      return;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        break;
      }
      localTokenFilter = _filterContext.checkValue(_itemFilter);
    } while ((localTokenFilter == null) || ((localTokenFilter != TokenFilter.INCLUDE_ALL) && (!localTokenFilter.includeNull())));
    _checkParentPath();
    delegate.writeNull();
  }
  
  public void writeNumber(double paramDouble)
    throws IOException
  {
    if (_itemFilter == null) {}
    TokenFilter localTokenFilter;
    do
    {
      return;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        break;
      }
      localTokenFilter = _filterContext.checkValue(_itemFilter);
    } while ((localTokenFilter == null) || ((localTokenFilter != TokenFilter.INCLUDE_ALL) && (!localTokenFilter.includeNumber(paramDouble))));
    _checkParentPath();
    delegate.writeNumber(paramDouble);
  }
  
  public void writeNumber(float paramFloat)
    throws IOException
  {
    if (_itemFilter == null) {}
    TokenFilter localTokenFilter;
    do
    {
      return;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        break;
      }
      localTokenFilter = _filterContext.checkValue(_itemFilter);
    } while ((localTokenFilter == null) || ((localTokenFilter != TokenFilter.INCLUDE_ALL) && (!localTokenFilter.includeNumber(paramFloat))));
    _checkParentPath();
    delegate.writeNumber(paramFloat);
  }
  
  public void writeNumber(int paramInt)
    throws IOException
  {
    if (_itemFilter == null) {}
    TokenFilter localTokenFilter;
    do
    {
      return;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        break;
      }
      localTokenFilter = _filterContext.checkValue(_itemFilter);
    } while ((localTokenFilter == null) || ((localTokenFilter != TokenFilter.INCLUDE_ALL) && (!localTokenFilter.includeNumber(paramInt))));
    _checkParentPath();
    delegate.writeNumber(paramInt);
  }
  
  public void writeNumber(long paramLong)
    throws IOException
  {
    if (_itemFilter == null) {}
    TokenFilter localTokenFilter;
    do
    {
      return;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        break;
      }
      localTokenFilter = _filterContext.checkValue(_itemFilter);
    } while ((localTokenFilter == null) || ((localTokenFilter != TokenFilter.INCLUDE_ALL) && (!localTokenFilter.includeNumber(paramLong))));
    _checkParentPath();
    delegate.writeNumber(paramLong);
  }
  
  public void writeNumber(String paramString)
    throws IOException, UnsupportedOperationException
  {
    if (_itemFilter == null) {}
    TokenFilter localTokenFilter;
    do
    {
      return;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        break;
      }
      localTokenFilter = _filterContext.checkValue(_itemFilter);
    } while ((localTokenFilter == null) || ((localTokenFilter != TokenFilter.INCLUDE_ALL) && (!localTokenFilter.includeRawValue())));
    _checkParentPath();
    delegate.writeNumber(paramString);
  }
  
  public void writeNumber(BigDecimal paramBigDecimal)
    throws IOException
  {
    if (_itemFilter == null) {}
    TokenFilter localTokenFilter;
    do
    {
      return;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        break;
      }
      localTokenFilter = _filterContext.checkValue(_itemFilter);
    } while ((localTokenFilter == null) || ((localTokenFilter != TokenFilter.INCLUDE_ALL) && (!localTokenFilter.includeNumber(paramBigDecimal))));
    _checkParentPath();
    delegate.writeNumber(paramBigDecimal);
  }
  
  public void writeNumber(BigInteger paramBigInteger)
    throws IOException
  {
    if (_itemFilter == null) {}
    TokenFilter localTokenFilter;
    do
    {
      return;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        break;
      }
      localTokenFilter = _filterContext.checkValue(_itemFilter);
    } while ((localTokenFilter == null) || ((localTokenFilter != TokenFilter.INCLUDE_ALL) && (!localTokenFilter.includeNumber(paramBigInteger))));
    _checkParentPath();
    delegate.writeNumber(paramBigInteger);
  }
  
  public void writeNumber(short paramShort)
    throws IOException
  {
    if (_itemFilter == null) {}
    TokenFilter localTokenFilter;
    do
    {
      return;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        break;
      }
      localTokenFilter = _filterContext.checkValue(_itemFilter);
    } while ((localTokenFilter == null) || ((localTokenFilter != TokenFilter.INCLUDE_ALL) && (!localTokenFilter.includeNumber(paramShort))));
    _checkParentPath();
    delegate.writeNumber(paramShort);
  }
  
  public void writeObjectId(Object paramObject)
    throws IOException
  {
    if (_itemFilter != null) {
      delegate.writeObjectId(paramObject);
    }
  }
  
  public void writeObjectRef(Object paramObject)
    throws IOException
  {
    if (_itemFilter != null) {
      delegate.writeObjectRef(paramObject);
    }
  }
  
  public void writeOmittedField(String paramString)
    throws IOException
  {
    if (_itemFilter != null) {
      delegate.writeOmittedField(paramString);
    }
  }
  
  public void writeRaw(char paramChar)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(paramChar);
    }
  }
  
  public void writeRaw(SerializableString paramSerializableString)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(paramSerializableString);
    }
  }
  
  public void writeRaw(String paramString)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(paramString);
    }
  }
  
  public void writeRaw(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(paramString);
    }
  }
  
  public void writeRaw(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
  
  public void writeRawUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRawUTF8String(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public void writeRawValue(String paramString)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(paramString);
    }
  }
  
  public void writeRawValue(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(paramString, paramInt1, paramInt2);
    }
  }
  
  public void writeRawValue(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRaw(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
  
  public void writeStartArray()
    throws IOException
  {
    if (_itemFilter == null)
    {
      _filterContext = _filterContext.createChildArrayContext(null, false);
      return;
    }
    if (_itemFilter == TokenFilter.INCLUDE_ALL)
    {
      _filterContext = _filterContext.createChildArrayContext(_itemFilter, true);
      delegate.writeStartArray();
      return;
    }
    _itemFilter = _filterContext.checkValue(_itemFilter);
    if (_itemFilter == null)
    {
      _filterContext = _filterContext.createChildArrayContext(null, false);
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL) {
      _itemFilter = _itemFilter.filterStartArray();
    }
    if (_itemFilter == TokenFilter.INCLUDE_ALL)
    {
      _checkParentPath();
      _filterContext = _filterContext.createChildArrayContext(_itemFilter, true);
      delegate.writeStartArray();
      return;
    }
    _filterContext = _filterContext.createChildArrayContext(_itemFilter, false);
  }
  
  public void writeStartArray(int paramInt)
    throws IOException
  {
    if (_itemFilter == null)
    {
      _filterContext = _filterContext.createChildArrayContext(null, false);
      return;
    }
    if (_itemFilter == TokenFilter.INCLUDE_ALL)
    {
      _filterContext = _filterContext.createChildArrayContext(_itemFilter, true);
      delegate.writeStartArray(paramInt);
      return;
    }
    _itemFilter = _filterContext.checkValue(_itemFilter);
    if (_itemFilter == null)
    {
      _filterContext = _filterContext.createChildArrayContext(null, false);
      return;
    }
    if (_itemFilter != TokenFilter.INCLUDE_ALL) {
      _itemFilter = _itemFilter.filterStartArray();
    }
    if (_itemFilter == TokenFilter.INCLUDE_ALL)
    {
      _checkParentPath();
      _filterContext = _filterContext.createChildArrayContext(_itemFilter, true);
      delegate.writeStartArray(paramInt);
      return;
    }
    _filterContext = _filterContext.createChildArrayContext(_itemFilter, false);
  }
  
  public void writeStartObject()
    throws IOException
  {
    if (_itemFilter == null) {
      _filterContext = _filterContext.createChildObjectContext(_itemFilter, false);
    }
    TokenFilter localTokenFilter2;
    do
    {
      return;
      if (_itemFilter == TokenFilter.INCLUDE_ALL)
      {
        _filterContext = _filterContext.createChildObjectContext(_itemFilter, true);
        delegate.writeStartObject();
        return;
      }
      localTokenFilter2 = _filterContext.checkValue(_itemFilter);
    } while (localTokenFilter2 == null);
    TokenFilter localTokenFilter1 = localTokenFilter2;
    if (localTokenFilter2 != TokenFilter.INCLUDE_ALL) {
      localTokenFilter1 = localTokenFilter2.filterStartObject();
    }
    if (localTokenFilter1 == TokenFilter.INCLUDE_ALL)
    {
      _checkParentPath();
      _filterContext = _filterContext.createChildObjectContext(localTokenFilter1, true);
      delegate.writeStartObject();
      return;
    }
    _filterContext = _filterContext.createChildObjectContext(localTokenFilter1, false);
  }
  
  public void writeString(SerializableString paramSerializableString)
    throws IOException
  {
    if (_itemFilter == null) {}
    TokenFilter localTokenFilter;
    do
    {
      return;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        break;
      }
      localTokenFilter = _filterContext.checkValue(_itemFilter);
    } while ((localTokenFilter == null) || ((localTokenFilter != TokenFilter.INCLUDE_ALL) && (!localTokenFilter.includeString(paramSerializableString.getValue()))));
    _checkParentPath();
    delegate.writeString(paramSerializableString);
  }
  
  public void writeString(String paramString)
    throws IOException
  {
    if (_itemFilter == null) {}
    TokenFilter localTokenFilter;
    do
    {
      return;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        break;
      }
      localTokenFilter = _filterContext.checkValue(_itemFilter);
    } while ((localTokenFilter == null) || ((localTokenFilter != TokenFilter.INCLUDE_ALL) && (!localTokenFilter.includeString(paramString))));
    _checkParentPath();
    delegate.writeString(paramString);
  }
  
  public void writeString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (_itemFilter == null) {}
    String str;
    TokenFilter localTokenFilter;
    do
    {
      return;
      if (_itemFilter == TokenFilter.INCLUDE_ALL) {
        break;
      }
      str = new String(paramArrayOfChar, paramInt1, paramInt2);
      localTokenFilter = _filterContext.checkValue(_itemFilter);
    } while ((localTokenFilter == null) || ((localTokenFilter != TokenFilter.INCLUDE_ALL) && (!localTokenFilter.includeString(str))));
    _checkParentPath();
    delegate.writeString(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void writeTypeId(Object paramObject)
    throws IOException
  {
    if (_itemFilter != null) {
      delegate.writeTypeId(paramObject);
    }
  }
  
  public void writeUTF8String(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (_checkRawValueWrite()) {
      delegate.writeRawUTF8String(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */