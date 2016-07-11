package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JsonToken;
import java.util.TreeMap;

public final class TokenBuffer$Segment
{
  public static final int TOKENS_PER_SEGMENT = 16;
  private static final JsonToken[] TOKEN_TYPES_BY_INDEX = new JsonToken[16];
  protected TreeMap<Integer, Object> _nativeIds;
  protected Segment _next;
  protected long _tokenTypes;
  protected final Object[] _tokens = new Object[16];
  
  static
  {
    JsonToken[] arrayOfJsonToken = JsonToken.values();
    System.arraycopy(arrayOfJsonToken, 1, TOKEN_TYPES_BY_INDEX, 1, Math.min(15, arrayOfJsonToken.length - 1));
  }
  
  private final int _objectIdIndex(int paramInt)
  {
    return paramInt + paramInt + 1;
  }
  
  private final int _typeIdIndex(int paramInt)
  {
    return paramInt + paramInt;
  }
  
  private final void assignNativeIds(int paramInt, Object paramObject1, Object paramObject2)
  {
    if (_nativeIds == null) {
      _nativeIds = new TreeMap();
    }
    if (paramObject1 != null) {
      _nativeIds.put(Integer.valueOf(_objectIdIndex(paramInt)), paramObject1);
    }
    if (paramObject2 != null) {
      _nativeIds.put(Integer.valueOf(_typeIdIndex(paramInt)), paramObject2);
    }
  }
  
  private void set(int paramInt1, int paramInt2, Object paramObject)
  {
    _tokens[paramInt1] = paramObject;
    long l2 = paramInt2;
    long l1 = l2;
    if (paramInt1 > 0) {
      l1 = l2 << (paramInt1 << 2);
    }
    _tokenTypes |= l1;
  }
  
  private void set(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    _tokens[paramInt1] = paramObject1;
    long l2 = paramInt2;
    long l1 = l2;
    if (paramInt1 > 0) {
      l1 = l2 << (paramInt1 << 2);
    }
    _tokenTypes |= l1;
    assignNativeIds(paramInt1, paramObject2, paramObject3);
  }
  
  private void set(int paramInt, JsonToken paramJsonToken)
  {
    long l2 = paramJsonToken.ordinal();
    long l1 = l2;
    if (paramInt > 0) {
      l1 = l2 << (paramInt << 2);
    }
    _tokenTypes |= l1;
  }
  
  private void set(int paramInt, JsonToken paramJsonToken, Object paramObject)
  {
    _tokens[paramInt] = paramObject;
    long l2 = paramJsonToken.ordinal();
    long l1 = l2;
    if (paramInt > 0) {
      l1 = l2 << (paramInt << 2);
    }
    _tokenTypes |= l1;
  }
  
  private void set(int paramInt, JsonToken paramJsonToken, Object paramObject1, Object paramObject2)
  {
    long l2 = paramJsonToken.ordinal();
    long l1 = l2;
    if (paramInt > 0) {
      l1 = l2 << (paramInt << 2);
    }
    _tokenTypes |= l1;
    assignNativeIds(paramInt, paramObject1, paramObject2);
  }
  
  private void set(int paramInt, JsonToken paramJsonToken, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    _tokens[paramInt] = paramObject1;
    long l2 = paramJsonToken.ordinal();
    long l1 = l2;
    if (paramInt > 0) {
      l1 = l2 << (paramInt << 2);
    }
    _tokenTypes |= l1;
    assignNativeIds(paramInt, paramObject2, paramObject3);
  }
  
  public Segment append(int paramInt, JsonToken paramJsonToken)
  {
    if (paramInt < 16)
    {
      set(paramInt, paramJsonToken);
      return null;
    }
    _next = new Segment();
    _next.set(0, paramJsonToken);
    return _next;
  }
  
  public Segment append(int paramInt, JsonToken paramJsonToken, Object paramObject)
  {
    if (paramInt < 16)
    {
      set(paramInt, paramJsonToken, paramObject);
      return null;
    }
    _next = new Segment();
    _next.set(0, paramJsonToken, paramObject);
    return _next;
  }
  
  public Segment append(int paramInt, JsonToken paramJsonToken, Object paramObject1, Object paramObject2)
  {
    if (paramInt < 16)
    {
      set(paramInt, paramJsonToken, paramObject1, paramObject2);
      return null;
    }
    _next = new Segment();
    _next.set(0, paramJsonToken, paramObject1, paramObject2);
    return _next;
  }
  
  public Segment append(int paramInt, JsonToken paramJsonToken, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramInt < 16)
    {
      set(paramInt, paramJsonToken, paramObject1, paramObject2, paramObject3);
      return null;
    }
    _next = new Segment();
    _next.set(0, paramJsonToken, paramObject1, paramObject2, paramObject3);
    return _next;
  }
  
  public Segment appendRaw(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramInt1 < 16)
    {
      set(paramInt1, paramInt2, paramObject);
      return null;
    }
    _next = new Segment();
    _next.set(0, paramInt2, paramObject);
    return _next;
  }
  
  public Segment appendRaw(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramInt1 < 16)
    {
      set(paramInt1, paramInt2, paramObject1, paramObject2, paramObject3);
      return null;
    }
    _next = new Segment();
    _next.set(0, paramInt2, paramObject1, paramObject2, paramObject3);
    return _next;
  }
  
  public Object findObjectId(int paramInt)
  {
    if (_nativeIds == null) {
      return null;
    }
    return _nativeIds.get(Integer.valueOf(_objectIdIndex(paramInt)));
  }
  
  public Object findTypeId(int paramInt)
  {
    if (_nativeIds == null) {
      return null;
    }
    return _nativeIds.get(Integer.valueOf(_typeIdIndex(paramInt)));
  }
  
  public Object get(int paramInt)
  {
    return _tokens[paramInt];
  }
  
  public boolean hasIds()
  {
    return _nativeIds != null;
  }
  
  public Segment next()
  {
    return _next;
  }
  
  public int rawType(int paramInt)
  {
    long l2 = _tokenTypes;
    long l1 = l2;
    if (paramInt > 0) {
      l1 = l2 >> (paramInt << 2);
    }
    return (int)l1 & 0xF;
  }
  
  public JsonToken type(int paramInt)
  {
    long l2 = _tokenTypes;
    long l1 = l2;
    if (paramInt > 0) {
      l1 = l2 >> (paramInt << 2);
    }
    paramInt = (int)l1;
    return TOKEN_TYPES_BY_INDEX[(paramInt & 0xF)];
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.TokenBuffer.Segment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */