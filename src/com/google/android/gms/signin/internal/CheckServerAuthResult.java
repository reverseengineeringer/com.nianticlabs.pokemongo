package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class CheckServerAuthResult
  implements SafeParcelable
{
  public static final Parcelable.Creator<CheckServerAuthResult> CREATOR = new zzc();
  final int mVersionCode;
  final boolean zzaVi;
  final List<Scope> zzaVj;
  
  CheckServerAuthResult(int paramInt, boolean paramBoolean, List<Scope> paramList)
  {
    mVersionCode = paramInt;
    zzaVi = paramBoolean;
    zzaVj = paramList;
  }
  
  public CheckServerAuthResult(boolean paramBoolean, Set<Scope> paramSet)
  {
    this(1, paramBoolean, zze(paramSet));
  }
  
  private static List<Scope> zze(Set<Scope> paramSet)
  {
    if (paramSet == null) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(new ArrayList(paramSet));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.CheckServerAuthResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */