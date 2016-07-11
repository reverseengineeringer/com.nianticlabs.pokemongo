package com.google.android.gms.auth.api.credentials;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class PasswordSpecification$zza
{
  private final TreeSet<Character> zzSB = new TreeSet();
  private final List<String> zzSw = new ArrayList();
  private final List<Integer> zzSx = new ArrayList();
  private int zzSy = 12;
  private int zzSz = 16;
  
  private void zzlL()
  {
    Iterator localIterator = zzSx.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((Integer)localIterator.next()).intValue() + i) {}
    if (i > zzSz) {
      throw new PasswordSpecification.zzb("required character count cannot be greater than the max password size");
    }
  }
  
  private void zzlM()
  {
    boolean[] arrayOfBoolean = new boolean[95];
    Iterator localIterator = zzSw.iterator();
    while (localIterator.hasNext())
    {
      char[] arrayOfChar = ((String)localIterator.next()).toCharArray();
      int j = arrayOfChar.length;
      int i = 0;
      while (i < j)
      {
        char c = arrayOfChar[i];
        if (arrayOfBoolean[(c - ' ')] != 0) {
          throw new PasswordSpecification.zzb("character " + c + " occurs in more than one required character set");
        }
        arrayOfBoolean[(c - ' ')] = true;
        i += 1;
      }
    }
  }
  
  private TreeSet<Character> zzr(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new PasswordSpecification.zzb(paramString2 + " cannot be null or empty");
    }
    TreeSet localTreeSet = new TreeSet();
    paramString1 = paramString1.toCharArray();
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      char c = paramString1[i];
      if (PasswordSpecification.zzc(c, 32, 126)) {
        throw new PasswordSpecification.zzb(paramString2 + " must only contain ASCII printable characters");
      }
      localTreeSet.add(Character.valueOf(c));
      i += 1;
    }
    return localTreeSet;
  }
  
  public zza zzbD(String paramString)
  {
    zzSB.addAll(zzr(paramString, "allowedChars"));
    return this;
  }
  
  public zza zzf(String paramString, int paramInt)
  {
    if (paramInt < 1) {
      throw new PasswordSpecification.zzb("count must be at least 1");
    }
    paramString = zzr(paramString, "requiredChars");
    zzSw.add(PasswordSpecification.zzc(paramString));
    zzSx.add(Integer.valueOf(paramInt));
    return this;
  }
  
  public zza zzg(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 1) {
      throw new PasswordSpecification.zzb("minimumSize must be at least 1");
    }
    if (paramInt1 > paramInt2) {
      throw new PasswordSpecification.zzb("maximumSize must be greater than or equal to minimumSize");
    }
    zzSy = paramInt1;
    zzSz = paramInt2;
    return this;
  }
  
  public PasswordSpecification zzlK()
  {
    if (zzSB.isEmpty()) {
      throw new PasswordSpecification.zzb("no allowed characters specified");
    }
    zzlL();
    zzlM();
    return new PasswordSpecification(1, PasswordSpecification.zzc(zzSB), zzSw, zzSx, zzSy, zzSz);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.PasswordSpecification.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */