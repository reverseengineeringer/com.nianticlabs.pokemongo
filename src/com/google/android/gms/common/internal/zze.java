package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class zze
{
  public static final zze zzaeL = zza("\t\n\013\f\r     　 ᠎ ").zza(zza(' ', ' '));
  public static final zze zzaeM = zza("\t\n\013\f\r     　").zza(zza(' ', ' ')).zza(zza(' ', ' '));
  public static final zze zzaeN = zza('\000', '');
  public static final zze zzaeO;
  public static final zze zzaeP = zza('\t', '\r').zza(zza('\034', ' ')).zza(zzc(' ')).zza(zzc('᠎')).zza(zza(' ', ' ')).zza(zza(' ', '​')).zza(zza(' ', ' ')).zza(zzc(' ')).zza(zzc('　'));
  public static final zze zzaeQ = new zze()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isDigit(paramAnonymousChar);
    }
  };
  public static final zze zzaeR = new zze()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isLetter(paramAnonymousChar);
    }
  };
  public static final zze zzaeS = new zze()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isLetterOrDigit(paramAnonymousChar);
    }
  };
  public static final zze zzaeT = new zze()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isUpperCase(paramAnonymousChar);
    }
  };
  public static final zze zzaeU = new zze()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isLowerCase(paramAnonymousChar);
    }
  };
  public static final zze zzaeV = zza('\000', '\037').zza(zza('', ''));
  public static final zze zzaeW = zza('\000', ' ').zza(zza('', ' ')).zza(zzc('­')).zza(zza('؀', '؃')).zza(zza("۝܏ ឴឵᠎")).zza(zza(' ', '‏')).zza(zza(' ', ' ')).zza(zza(' ', '⁤')).zza(zza('⁪', '⁯')).zza(zzc('　')).zza(zza(55296, 63743)).zza(zza("﻿￹￺￻"));
  public static final zze zzaeX = zza('\000', 'ӹ').zza(zzc('־')).zza(zza('א', 'ת')).zza(zzc('׳')).zza(zzc('״')).zza(zza('؀', 'ۿ')).zza(zza('ݐ', 'ݿ')).zza(zza('฀', '๿')).zza(zza('Ḁ', '₯')).zza(zza('℀', '℺')).zza(zza(64336, 65023)).zza(zza(65136, 65279)).zza(zza(65377, 65500));
  public static final zze zzaeY = new zze()
  {
    public zze zza(zze paramAnonymouszze)
    {
      zzx.zzw(paramAnonymouszze);
      return this;
    }
    
    public boolean zzb(CharSequence paramAnonymousCharSequence)
    {
      zzx.zzw(paramAnonymousCharSequence);
      return true;
    }
    
    public boolean zzd(char paramAnonymousChar)
    {
      return true;
    }
  };
  public static final zze zzaeZ = new zze()
  {
    public zze zza(zze paramAnonymouszze)
    {
      return (zze)zzx.zzw(paramAnonymouszze);
    }
    
    public boolean zzb(CharSequence paramAnonymousCharSequence)
    {
      return paramAnonymousCharSequence.length() == 0;
    }
    
    public boolean zzd(char paramAnonymousChar)
    {
      return false;
    }
  };
  
  static
  {
    zze localzze = zza('0', '9');
    char[] arrayOfChar = "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
    int j = arrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      char c = arrayOfChar[i];
      localzze = localzze.zza(zza(c, (char)(c + '\t')));
      i += 1;
    }
    zzaeO = localzze;
  }
  
  public static zze zza(char paramChar1, final char paramChar2)
  {
    if (paramChar2 >= paramChar1) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzaa(bool);
      new zze()
      {
        public boolean zzd(char paramAnonymousChar)
        {
          return (zzafd <= paramAnonymousChar) && (paramAnonymousChar <= paramChar2);
        }
      };
    }
  }
  
  public static zze zza(CharSequence paramCharSequence)
  {
    switch (paramCharSequence.length())
    {
    default: 
      paramCharSequence = paramCharSequence.toString().toCharArray();
      Arrays.sort(paramCharSequence);
      new zze()
      {
        public boolean zzd(char paramAnonymousChar)
        {
          return Arrays.binarySearch(zzafc, paramAnonymousChar) >= 0;
        }
      };
    case 0: 
      return zzaeZ;
    case 1: 
      return zzc(paramCharSequence.charAt(0));
    }
    new zze()
    {
      public boolean zzd(char paramAnonymousChar)
      {
        return (paramAnonymousChar == zzafa) || (paramAnonymousChar == zzafb);
      }
    };
  }
  
  public static zze zzc(char paramChar)
  {
    new zze()
    {
      public zze zza(zze paramAnonymouszze)
      {
        if (paramAnonymouszze.zzd(zzaff)) {
          return paramAnonymouszze;
        }
        return super.zza(paramAnonymouszze);
      }
      
      public boolean zzd(char paramAnonymousChar)
      {
        return paramAnonymousChar == zzaff;
      }
    };
  }
  
  public zze zza(zze paramzze)
  {
    return new zza(Arrays.asList(new zze[] { this, (zze)zzx.zzw(paramzze) }));
  }
  
  public boolean zzb(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length() - 1;
    while (i >= 0)
    {
      if (!zzd(paramCharSequence.charAt(i))) {
        return false;
      }
      i -= 1;
    }
    return true;
  }
  
  public abstract boolean zzd(char paramChar);
  
  private static class zza
    extends zze
  {
    List<zze> zzafg;
    
    zza(List<zze> paramList)
    {
      zzafg = paramList;
    }
    
    public zze zza(zze paramzze)
    {
      ArrayList localArrayList = new ArrayList(zzafg);
      localArrayList.add(zzx.zzw(paramzze));
      return new zza(localArrayList);
    }
    
    public boolean zzd(char paramChar)
    {
      Iterator localIterator = zzafg.iterator();
      while (localIterator.hasNext()) {
        if (((zze)localIterator.next()).zzd(paramChar)) {
          return true;
        }
      }
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */