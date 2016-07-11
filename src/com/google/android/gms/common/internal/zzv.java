package com.google.android.gms.common.internal;

import java.util.Iterator;

public class zzv
{
  private final String separator;
  
  private zzv(String paramString)
  {
    separator = paramString;
  }
  
  public static zzv zzcq(String paramString)
  {
    return new zzv(paramString);
  }
  
  public final String zza(Iterable<?> paramIterable)
  {
    return zza(new StringBuilder(), paramIterable).toString();
  }
  
  public final StringBuilder zza(StringBuilder paramStringBuilder, Iterable<?> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext())
    {
      paramStringBuilder.append(zzu(paramIterable.next()));
      while (paramIterable.hasNext())
      {
        paramStringBuilder.append(separator);
        paramStringBuilder.append(zzu(paramIterable.next()));
      }
    }
    return paramStringBuilder;
  }
  
  CharSequence zzu(Object paramObject)
  {
    if ((paramObject instanceof CharSequence)) {
      return (CharSequence)paramObject;
    }
    return paramObject.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */