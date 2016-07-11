package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class MediaSessionCompat$Token
  implements Parcelable
{
  public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator()
  {
    public MediaSessionCompat.Token createFromParcel(Parcel paramAnonymousParcel)
    {
      if (Build.VERSION.SDK_INT >= 21) {}
      for (paramAnonymousParcel = paramAnonymousParcel.readParcelable(null);; paramAnonymousParcel = paramAnonymousParcel.readStrongBinder()) {
        return new MediaSessionCompat.Token(paramAnonymousParcel);
      }
    }
    
    public MediaSessionCompat.Token[] newArray(int paramAnonymousInt)
    {
      return new MediaSessionCompat.Token[paramAnonymousInt];
    }
  };
  private final Object mInner;
  
  MediaSessionCompat$Token(Object paramObject)
  {
    mInner = paramObject;
  }
  
  public static Token fromToken(Object paramObject)
  {
    if ((paramObject == null) || (Build.VERSION.SDK_INT < 21)) {
      return null;
    }
    return new Token(MediaSessionCompatApi21.verifyToken(paramObject));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Object getToken()
  {
    return mInner;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramParcel.writeParcelable((Parcelable)mInner, paramInt);
      return;
    }
    paramParcel.writeStrongBinder((IBinder)mInner);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.Token
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */