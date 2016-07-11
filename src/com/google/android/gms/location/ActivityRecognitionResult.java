package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ActivityRecognitionResult
  implements SafeParcelable
{
  public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
  private final int mVersionCode;
  List<DetectedActivity> zzaEb;
  long zzaEc;
  long zzaEd;
  int zzaEe;
  
  public ActivityRecognitionResult(int paramInt1, List<DetectedActivity> paramList, long paramLong1, long paramLong2, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzaEb = paramList;
    zzaEc = paramLong1;
    zzaEd = paramLong2;
    zzaEe = paramInt2;
  }
  
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2)
  {
    this(paramDetectedActivity, paramLong1, paramLong2, 0);
  }
  
  public ActivityRecognitionResult(DetectedActivity paramDetectedActivity, long paramLong1, long paramLong2, int paramInt)
  {
    this(Collections.singletonList(paramDetectedActivity), paramLong1, paramLong2, paramInt);
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2)
  {
    this(paramList, paramLong1, paramLong2, 0);
  }
  
  public ActivityRecognitionResult(List<DetectedActivity> paramList, long paramLong1, long paramLong2, int paramInt)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool1 = true;
      zzx.zzb(bool1, "Must have at least 1 detected activity");
      if ((paramLong1 <= 0L) || (paramLong2 <= 0L)) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "Must set times");
      mVersionCode = 2;
      zzaEb = paramList;
      zzaEc = paramLong1;
      zzaEd = paramLong2;
      zzaEe = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  public static ActivityRecognitionResult extractResult(Intent paramIntent)
  {
    if (!hasResult(paramIntent)) {
      return null;
    }
    paramIntent = paramIntent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    if ((paramIntent instanceof byte[]))
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall((byte[])paramIntent, 0, ((byte[])paramIntent).length);
      localParcel.setDataPosition(0);
      return CREATOR.createFromParcel(localParcel);
    }
    if ((paramIntent instanceof ActivityRecognitionResult)) {
      return (ActivityRecognitionResult)paramIntent;
    }
    return null;
  }
  
  public static boolean hasResult(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ActivityRecognitionResult)paramObject;
    } while ((zzaEc == zzaEc) && (zzaEd == zzaEd) && (zzaEe == zzaEe) && (zzw.equal(zzaEb, zzaEb)));
    return false;
  }
  
  public int getActivityConfidence(int paramInt)
  {
    Iterator localIterator = zzaEb.iterator();
    while (localIterator.hasNext())
    {
      DetectedActivity localDetectedActivity = (DetectedActivity)localIterator.next();
      if (localDetectedActivity.getType() == paramInt) {
        return localDetectedActivity.getConfidence();
      }
    }
    return 0;
  }
  
  public long getElapsedRealtimeMillis()
  {
    return zzaEd;
  }
  
  public DetectedActivity getMostProbableActivity()
  {
    return (DetectedActivity)zzaEb.get(0);
  }
  
  public List<DetectedActivity> getProbableActivities()
  {
    return zzaEb;
  }
  
  public long getTime()
  {
    return zzaEc;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Long.valueOf(zzaEc), Long.valueOf(zzaEd), Integer.valueOf(zzaEe), zzaEb });
  }
  
  public String toString()
  {
    return "ActivityRecognitionResult [probableActivities=" + zzaEb + ", timeMillis=" + zzaEc + ", elapsedRealtimeMillis=" + zzaEd + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ActivityRecognitionResultCreator.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.ActivityRecognitionResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */