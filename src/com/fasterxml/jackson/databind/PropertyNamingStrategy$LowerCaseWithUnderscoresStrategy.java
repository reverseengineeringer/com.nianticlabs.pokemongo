package com.fasterxml.jackson.databind;

public class PropertyNamingStrategy$LowerCaseWithUnderscoresStrategy
  extends PropertyNamingStrategy.PropertyNamingStrategyBase
{
  public String translate(String paramString)
  {
    if (paramString == null) {}
    StringBuilder localStringBuilder;
    int i;
    label155:
    do
    {
      return paramString;
      int i1 = paramString.length();
      localStringBuilder = new StringBuilder(i1 * 2);
      i = 0;
      int m = 0;
      int k = 0;
      if (k < i1)
      {
        char c = paramString.charAt(k);
        int n;
        int j;
        if (k <= 0)
        {
          n = i;
          j = m;
          if (c == '_') {}
        }
        else
        {
          if (!Character.isUpperCase(c)) {
            break label155;
          }
          j = i;
          if (m == 0)
          {
            j = i;
            if (i > 0)
            {
              j = i;
              if (localStringBuilder.charAt(i - 1) != '_')
              {
                localStringBuilder.append('_');
                j = i + 1;
              }
            }
          }
          c = Character.toLowerCase(c);
        }
        for (i = 1;; i = m)
        {
          localStringBuilder.append(c);
          n = j + 1;
          j = i;
          k += 1;
          i = n;
          m = j;
          break;
          m = 0;
          j = i;
        }
      }
    } while (i <= 0);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */