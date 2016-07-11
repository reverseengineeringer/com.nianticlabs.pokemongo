package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable>
  extends AbstractDataBuffer<T>
{
  private static final String[] zzadn = { "data" };
  private final Parcelable.Creator<T> zzado;
  
  public zzd(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator)
  {
    super(paramDataHolder);
    zzado = paramCreator;
  }
  
  public T zzbs(int paramInt)
  {
    Object localObject = zzabq.zzg("data", paramInt, zzabq.zzbt(paramInt));
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall((byte[])localObject, 0, localObject.length);
    localParcel.setDataPosition(0);
    localObject = (SafeParcelable)zzado.createFromParcel(localParcel);
    localParcel.recycle();
    return (T)localObject;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */