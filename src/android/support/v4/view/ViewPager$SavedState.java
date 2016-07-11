package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.view.View.BaseSavedState;

public class ViewPager$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks()
  {
    public ViewPager.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
    {
      return new ViewPager.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
    }
    
    public ViewPager.SavedState[] newArray(int paramAnonymousInt)
    {
      return new ViewPager.SavedState[paramAnonymousInt];
    }
  });
  Parcelable adapterState;
  ClassLoader loader;
  int position;
  
  ViewPager$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel);
    ClassLoader localClassLoader = paramClassLoader;
    if (paramClassLoader == null) {
      localClassLoader = getClass().getClassLoader();
    }
    position = paramParcel.readInt();
    adapterState = paramParcel.readParcelable(localClassLoader);
    loader = localClassLoader;
  }
  
  public ViewPager$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + position + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(position);
    paramParcel.writeParcelable(adapterState, paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewPager.SavedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */