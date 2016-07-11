package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

public abstract class NameTransformer
{
  public static final NameTransformer NOP = new NopTransformer();
  
  public static NameTransformer chainedTransformer(NameTransformer paramNameTransformer1, NameTransformer paramNameTransformer2)
  {
    return new Chained(paramNameTransformer1, paramNameTransformer2);
  }
  
  public static NameTransformer simpleTransformer(String paramString1, final String paramString2)
  {
    int j = 1;
    int i;
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      i = 1;
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        break label49;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        if (j != 0)
        {
          new NameTransformer()
          {
            public String reverse(String paramAnonymousString)
            {
              if (paramAnonymousString.startsWith(val$prefix))
              {
                paramAnonymousString = paramAnonymousString.substring(val$prefix.length());
                if (paramAnonymousString.endsWith(paramString2)) {
                  return paramAnonymousString.substring(0, paramAnonymousString.length() - paramString2.length());
                }
              }
              return null;
            }
            
            public String toString()
            {
              return "[PreAndSuffixTransformer('" + val$prefix + "','" + paramString2 + "')]";
            }
            
            public String transform(String paramAnonymousString)
            {
              return val$prefix + paramAnonymousString + paramString2;
            }
          };
          i = 0;
          break;
          label49:
          j = 0;
          continue;
        }
        new NameTransformer()
        {
          public String reverse(String paramAnonymousString)
          {
            if (paramAnonymousString.startsWith(val$prefix)) {
              return paramAnonymousString.substring(val$prefix.length());
            }
            return null;
          }
          
          public String toString()
          {
            return "[PrefixTransformer('" + val$prefix + "')]";
          }
          
          public String transform(String paramAnonymousString)
          {
            return val$prefix + paramAnonymousString;
          }
        };
      }
    }
    if (j != 0) {
      new NameTransformer()
      {
        public String reverse(String paramAnonymousString)
        {
          if (paramAnonymousString.endsWith(val$suffix)) {
            return paramAnonymousString.substring(0, paramAnonymousString.length() - val$suffix.length());
          }
          return null;
        }
        
        public String toString()
        {
          return "[SuffixTransformer('" + val$suffix + "')]";
        }
        
        public String transform(String paramAnonymousString)
        {
          return paramAnonymousString + val$suffix;
        }
      };
    }
    return NOP;
  }
  
  public abstract String reverse(String paramString);
  
  public abstract String transform(String paramString);
  
  public static class Chained
    extends NameTransformer
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    protected final NameTransformer _t1;
    protected final NameTransformer _t2;
    
    public Chained(NameTransformer paramNameTransformer1, NameTransformer paramNameTransformer2)
    {
      _t1 = paramNameTransformer1;
      _t2 = paramNameTransformer2;
    }
    
    public String reverse(String paramString)
    {
      String str = _t1.reverse(paramString);
      paramString = str;
      if (str != null) {
        paramString = _t2.reverse(str);
      }
      return paramString;
    }
    
    public String toString()
    {
      return "[ChainedTransformer(" + _t1 + ", " + _t2 + ")]";
    }
    
    public String transform(String paramString)
    {
      return _t1.transform(_t2.transform(paramString));
    }
  }
  
  protected static final class NopTransformer
    extends NameTransformer
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    
    public String reverse(String paramString)
    {
      return paramString;
    }
    
    public String transform(String paramString)
    {
      return paramString;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.NameTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */