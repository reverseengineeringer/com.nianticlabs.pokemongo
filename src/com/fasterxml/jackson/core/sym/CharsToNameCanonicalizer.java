package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.BitSet;

public final class CharsToNameCanonicalizer
{
  protected static final int DEFAULT_T_SIZE = 64;
  public static final int HASH_MULT = 33;
  static final int MAX_COLL_CHAIN_LENGTH = 100;
  static final int MAX_ENTRIES_FOR_REUSE = 12000;
  protected static final int MAX_T_SIZE = 65536;
  static final CharsToNameCanonicalizer sBootstrapSymbolTable = new CharsToNameCanonicalizer();
  protected Bucket[] _buckets;
  protected boolean _canonicalize;
  protected boolean _dirty;
  protected final int _flags;
  private final int _hashSeed;
  protected int _indexMask;
  protected int _longestCollisionList;
  protected BitSet _overflows;
  protected CharsToNameCanonicalizer _parent;
  protected int _size;
  protected int _sizeThreshold;
  protected String[] _symbols;
  
  private CharsToNameCanonicalizer()
  {
    _canonicalize = true;
    _flags = -1;
    _dirty = true;
    _hashSeed = 0;
    _longestCollisionList = 0;
    initTables(64);
  }
  
  private CharsToNameCanonicalizer(CharsToNameCanonicalizer paramCharsToNameCanonicalizer, int paramInt1, String[] paramArrayOfString, Bucket[] paramArrayOfBucket, int paramInt2, int paramInt3, int paramInt4)
  {
    _parent = paramCharsToNameCanonicalizer;
    _flags = paramInt1;
    _canonicalize = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(paramInt1);
    _symbols = paramArrayOfString;
    _buckets = paramArrayOfBucket;
    _size = paramInt2;
    _hashSeed = paramInt3;
    paramInt1 = paramArrayOfString.length;
    _sizeThreshold = _thresholdSize(paramInt1);
    _indexMask = (paramInt1 - 1);
    _longestCollisionList = paramInt4;
    _dirty = false;
  }
  
  private String _addSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!_dirty)
    {
      copyArrays();
      _dirty = true;
    }
    for (;;)
    {
      localObject = new String(paramArrayOfChar, paramInt1, paramInt2);
      paramArrayOfChar = (char[])localObject;
      if (JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(_flags)) {
        paramArrayOfChar = InternCache.instance.intern((String)localObject);
      }
      _size += 1;
      if (_symbols[paramInt4] != null) {
        break;
      }
      _symbols[paramInt4] = paramArrayOfChar;
      return paramArrayOfChar;
      if (_size >= _sizeThreshold)
      {
        rehash();
        paramInt4 = _hashToIndex(calcHash(paramArrayOfChar, paramInt1, paramInt2));
      }
    }
    paramInt1 = paramInt4 >> 1;
    Object localObject = new Bucket(paramArrayOfChar, _buckets[paramInt1]);
    paramInt2 = length;
    if (paramInt2 > 100)
    {
      _handleSpillOverflow(paramInt1, (Bucket)localObject);
      return paramArrayOfChar;
    }
    _buckets[paramInt1] = localObject;
    _longestCollisionList = Math.max(paramInt2, _longestCollisionList);
    return paramArrayOfChar;
  }
  
  private String _findSymbol2(char[] paramArrayOfChar, int paramInt1, int paramInt2, Bucket paramBucket)
  {
    while (paramBucket != null)
    {
      String str = paramBucket.has(paramArrayOfChar, paramInt1, paramInt2);
      if (str != null) {
        return str;
      }
      paramBucket = next;
    }
    return null;
  }
  
  private void _handleSpillOverflow(int paramInt, Bucket paramBucket)
  {
    if (_overflows == null)
    {
      _overflows = new BitSet();
      _overflows.set(paramInt);
    }
    for (;;)
    {
      _symbols[(paramInt + paramInt)] = symbol;
      _buckets[paramInt] = null;
      _size -= length;
      _longestCollisionList = -1;
      return;
      if (_overflows.get(paramInt))
      {
        if (JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(_flags)) {
          reportTooManyCollisions(100);
        }
        _canonicalize = false;
      }
      else
      {
        _overflows.set(paramInt);
      }
    }
  }
  
  private static int _thresholdSize(int paramInt)
  {
    return paramInt - (paramInt >> 2);
  }
  
  private void copyArrays()
  {
    Object localObject = _symbols;
    _symbols = ((String[])Arrays.copyOf((Object[])localObject, localObject.length));
    localObject = _buckets;
    _buckets = ((Bucket[])Arrays.copyOf((Object[])localObject, localObject.length));
  }
  
  public static CharsToNameCanonicalizer createRoot()
  {
    long l = System.currentTimeMillis();
    return createRoot((int)l + (int)(l >>> 32) | 0x1);
  }
  
  protected static CharsToNameCanonicalizer createRoot(int paramInt)
  {
    return sBootstrapSymbolTable.makeOrphan(paramInt);
  }
  
  private void initTables(int paramInt)
  {
    _symbols = new String[paramInt];
    _buckets = new Bucket[paramInt >> 1];
    _indexMask = (paramInt - 1);
    _size = 0;
    _longestCollisionList = 0;
    _sizeThreshold = _thresholdSize(paramInt);
  }
  
  private CharsToNameCanonicalizer makeOrphan(int paramInt)
  {
    return new CharsToNameCanonicalizer(null, -1, _symbols, _buckets, _size, paramInt, _longestCollisionList);
  }
  
  private void mergeChild(CharsToNameCanonicalizer paramCharsToNameCanonicalizer)
  {
    if (paramCharsToNameCanonicalizer.size() > 12000) {
      try
      {
        initTables(256);
        _dirty = false;
        return;
      }
      finally {}
    }
    if (paramCharsToNameCanonicalizer.size() > size()) {
      try
      {
        _symbols = _symbols;
        _buckets = _buckets;
        _size = _size;
        _sizeThreshold = _sizeThreshold;
        _indexMask = _indexMask;
        _longestCollisionList = _longestCollisionList;
        _dirty = false;
        return;
      }
      finally {}
    }
  }
  
  private void rehash()
  {
    int i1 = _symbols.length;
    int i = i1 + i1;
    if (i > 65536)
    {
      _size = 0;
      _canonicalize = false;
      _symbols = new String[64];
      _buckets = new Bucket[32];
      _indexMask = 63;
      _dirty = true;
    }
    int k;
    label182:
    do
    {
      return;
      Object localObject1 = _symbols;
      Bucket[] arrayOfBucket = _buckets;
      _symbols = new String[i];
      _buckets = new Bucket[i >> 1];
      _indexMask = (i - 1);
      _sizeThreshold = _thresholdSize(i);
      int j = 0;
      i = 0;
      k = 0;
      Object localObject2;
      if (k < i1)
      {
        localObject2 = localObject1[k];
        m = j;
        int n = i;
        if (localObject2 != null)
        {
          m = j + 1;
          j = _hashToIndex(calcHash((String)localObject2));
          if (_symbols[j] != null) {
            break label182;
          }
          _symbols[j] = localObject2;
        }
        for (n = i;; n = Math.max(i, length))
        {
          k += 1;
          j = m;
          i = n;
          break;
          j >>= 1;
          localObject2 = new Bucket((String)localObject2, _buckets[j]);
          _buckets[j] = localObject2;
        }
      }
      k = 0;
      int m = i;
      i = k;
      k = j;
      while (i < i1 >> 1)
      {
        localObject1 = arrayOfBucket[i];
        j = m;
        if (localObject1 != null)
        {
          k += 1;
          localObject2 = symbol;
          m = _hashToIndex(calcHash((String)localObject2));
          if (_symbols[m] == null) {
            _symbols[m] = localObject2;
          }
          for (;;)
          {
            localObject1 = next;
            break;
            m >>= 1;
            localObject2 = new Bucket((String)localObject2, _buckets[m]);
            _buckets[m] = localObject2;
            j = Math.max(j, length);
          }
        }
        i += 1;
        m = j;
      }
      _longestCollisionList = m;
      _overflows = null;
    } while (k == _size);
    throw new Error("Internal error on SymbolTable.rehash(): had " + _size + " entries; now have " + k + ".");
  }
  
  public int _hashToIndex(int paramInt)
  {
    paramInt += (paramInt >>> 15);
    paramInt ^= paramInt << 7;
    return _indexMask & paramInt + (paramInt >>> 3);
  }
  
  public int bucketCount()
  {
    return _symbols.length;
  }
  
  public int calcHash(String paramString)
  {
    int k = paramString.length();
    int i = _hashSeed;
    int j = 0;
    while (j < k)
    {
      i = i * 33 + paramString.charAt(j);
      j += 1;
    }
    j = i;
    if (i == 0) {
      j = 1;
    }
    return j;
  }
  
  public int calcHash(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = _hashSeed;
    int j = paramInt1;
    while (j < paramInt1 + paramInt2)
    {
      i = i * 33 + paramArrayOfChar[j];
      j += 1;
    }
    paramInt1 = i;
    if (i == 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  public int collisionCount()
  {
    int j = 0;
    Bucket[] arrayOfBucket = _buckets;
    int m = arrayOfBucket.length;
    int i = 0;
    while (i < m)
    {
      Bucket localBucket = arrayOfBucket[i];
      int k = j;
      if (localBucket != null) {
        k = j + length;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public String findSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramInt2 < 1) {
      localObject = "";
    }
    int k;
    String str;
    do
    {
      Bucket localBucket;
      do
      {
        return (String)localObject;
        if (!_canonicalize) {
          return new String(paramArrayOfChar, paramInt1, paramInt2);
        }
        k = _hashToIndex(paramInt3);
        localObject = _symbols[k];
        if (localObject == null) {
          break;
        }
        if (((String)localObject).length() == paramInt2)
        {
          int i = 0;
          while (((String)localObject).charAt(i) == paramArrayOfChar[(paramInt1 + i)])
          {
            int j = i + 1;
            i = j;
            if (j == paramInt2) {
              return (String)localObject;
            }
          }
        }
        localBucket = _buckets[(k >> 1)];
        if (localBucket == null) {
          break;
        }
        str = localBucket.has(paramArrayOfChar, paramInt1, paramInt2);
        localObject = str;
      } while (str != null);
      str = _findSymbol2(paramArrayOfChar, paramInt1, paramInt2, next);
      localObject = str;
    } while (str != null);
    return _addSymbol(paramArrayOfChar, paramInt1, paramInt2, paramInt3, k);
  }
  
  public int hashSeed()
  {
    return _hashSeed;
  }
  
  public CharsToNameCanonicalizer makeChild(int paramInt)
  {
    try
    {
      String[] arrayOfString = _symbols;
      Bucket[] arrayOfBucket = _buckets;
      int i = _size;
      int j = _hashSeed;
      int k = _longestCollisionList;
      return new CharsToNameCanonicalizer(this, paramInt, arrayOfString, arrayOfBucket, i, j, k);
    }
    finally {}
  }
  
  public int maxCollisionLength()
  {
    return _longestCollisionList;
  }
  
  public boolean maybeDirty()
  {
    return _dirty;
  }
  
  public void release()
  {
    if (!maybeDirty()) {}
    while ((_parent == null) || (!_canonicalize)) {
      return;
    }
    _parent.mergeChild(this);
    _dirty = false;
  }
  
  protected void reportTooManyCollisions(int paramInt)
  {
    throw new IllegalStateException("Longest collision chain in symbol table (of size " + _size + ") now exceeds maximum, " + paramInt + " -- suspect a DoS attack based on hash collisions");
  }
  
  public int size()
  {
    return _size;
  }
  
  static final class Bucket
  {
    public final int length;
    public final Bucket next;
    public final String symbol;
    
    public Bucket(String paramString, Bucket paramBucket)
    {
      symbol = paramString;
      next = paramBucket;
      if (paramBucket == null) {}
      for (int i = 1;; i = length + 1)
      {
        length = i;
        return;
      }
    }
    
    public String has(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      if (symbol.length() != paramInt2) {}
      int j;
      do
      {
        while (symbol.charAt(i) != paramArrayOfChar[(paramInt1 + i)])
        {
          return null;
          i = 0;
        }
        j = i + 1;
        int i = j;
      } while (j < paramInt2);
      return symbol;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */