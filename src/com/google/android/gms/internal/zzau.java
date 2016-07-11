package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

public abstract interface zzau
  extends IInterface
{
  public abstract Bundle zza(Account paramAccount)
    throws RemoteException;
  
  public abstract Bundle zza(Account paramAccount, String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract Bundle zza(Bundle paramBundle)
    throws RemoteException;
  
  public abstract Bundle zza(String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public abstract Bundle zza(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException;
  
  public abstract AccountChangeEventsResponse zza(AccountChangeEventsRequest paramAccountChangeEventsRequest)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzau
  {
    public static zzau zza(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.auth.IAuthManagerService");
      if ((localIInterface != null) && ((localIInterface instanceof zzau))) {
        return (zzau)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject;
      String str;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.auth.IAuthManagerService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        localObject = paramParcel1.readString();
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = zza((String)localObject, str, paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label160;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel1 = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 2: 
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        localObject = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = zza((String)localObject, paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label234;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel1 = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 3: 
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel1 = (AccountChangeEventsRequest)AccountChangeEventsRequest.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = zza(paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label300;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel1 = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 5: 
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        if (paramParcel1.readInt() != 0)
        {
          localObject = (Account)Account.CREATOR.createFromParcel(paramParcel1);
          str = paramParcel1.readString();
          if (paramParcel1.readInt() == 0) {
            break label398;
          }
          paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = zza((Account)localObject, str, paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label403;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          localObject = null;
          break;
          paramParcel1 = null;
          break label361;
          paramParcel2.writeInt(0);
        }
      case 6: 
        label160:
        label234:
        label300:
        label361:
        label398:
        label403:
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = zza(paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label469;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel1 = null;
          break;
          label469:
          paramParcel2.writeInt(0);
        }
      }
      paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
      if (paramParcel1.readInt() != 0)
      {
        paramParcel1 = (Account)Account.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = zza(paramParcel1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label535;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel1 = null;
        break;
        label535:
        paramParcel2.writeInt(0);
      }
    }
    
    private static class zza
      implements zzau
    {
      private IBinder zznJ;
      
      zza(IBinder paramIBinder)
      {
        zznJ = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return zznJ;
      }
      
      public Bundle zza(Account paramAccount)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
            if (paramAccount != null)
            {
              localParcel1.writeInt(1);
              paramAccount.writeToParcel(localParcel1, 0);
              zznJ.transact(7, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramAccount = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramAccount;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramAccount = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public Bundle zza(Account paramAccount, String paramString, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
            if (paramAccount != null)
            {
              localParcel1.writeInt(1);
              paramAccount.writeToParcel(localParcel1, 0);
              localParcel1.writeString(paramString);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                zznJ.transact(5, localParcel1, localParcel2, 0);
                localParcel2.readException();
                if (localParcel2.readInt() == 0) {
                  break label143;
                }
                paramAccount = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramAccount;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label143:
          paramAccount = null;
        }
      }
      
      public Bundle zza(Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              zznJ.transact(6, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramBundle;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramBundle = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public Bundle zza(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
            localParcel1.writeString(paramString);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              zznJ.transact(2, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramString = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramString;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public Bundle zza(String paramString1, String paramString2, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
            localParcel1.writeString(paramString1);
            localParcel1.writeString(paramString2);
            if (paramBundle != null)
            {
              localParcel1.writeInt(1);
              paramBundle.writeToParcel(localParcel1, 0);
              zznJ.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramString1 = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
                return paramString1;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString1 = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public AccountChangeEventsResponse zza(AccountChangeEventsRequest paramAccountChangeEventsRequest)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
            if (paramAccountChangeEventsRequest != null)
            {
              localParcel1.writeInt(1);
              paramAccountChangeEventsRequest.writeToParcel(localParcel1, 0);
              zznJ.transact(3, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramAccountChangeEventsRequest = (AccountChangeEventsResponse)AccountChangeEventsResponse.CREATOR.createFromParcel(localParcel2);
                return paramAccountChangeEventsRequest;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramAccountChangeEventsRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzau
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */