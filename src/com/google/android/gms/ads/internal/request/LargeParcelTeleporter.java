package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzmt;
import java.io.IOException;
import java.io.OutputStream;

public final class LargeParcelTeleporter
  implements SafeParcelable
{
  public static final Parcelable.Creator<LargeParcelTeleporter> CREATOR = new zzl();
  final int mVersionCode;
  ParcelFileDescriptor zzFc;
  private Parcelable zzFd;
  private boolean zzFe;
  
  LargeParcelTeleporter(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    mVersionCode = paramInt;
    zzFc = paramParcelFileDescriptor;
    zzFd = null;
    zzFe = true;
  }
  
  public LargeParcelTeleporter(SafeParcelable paramSafeParcelable)
  {
    mVersionCode = 1;
    zzFc = null;
    zzFd = paramSafeParcelable;
    zzFe = false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Parcel localParcel;
    if (zzFc == null) {
      localParcel = Parcel.obtain();
    }
    try
    {
      zzFd.writeToParcel(localParcel, 0);
      byte[] arrayOfByte = localParcel.marshall();
      localParcel.recycle();
      zzFc = zzf(arrayOfByte);
      zzl.zza(this, paramParcel, paramInt);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public <T extends SafeParcelable> T zza(Parcelable.Creator<T> paramCreator)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:zzFe	Z
    //   4: ifeq +95 -> 99
    //   7: aload_0
    //   8: getfield 35	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:zzFc	Landroid/os/ParcelFileDescriptor;
    //   11: ifnonnull +10 -> 21
    //   14: ldc 74
    //   16: invokestatic 80	com/google/android/gms/ads/internal/util/client/zzb:e	(Ljava/lang/String;)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 82	java/io/DataInputStream
    //   24: dup
    //   25: new 84	android/os/ParcelFileDescriptor$AutoCloseInputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 35	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:zzFc	Landroid/os/ParcelFileDescriptor;
    //   33: invokespecial 87	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   36: invokespecial 90	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 93	java/io/DataInputStream:readInt	()I
    //   44: newarray <illegal type>
    //   46: astore_3
    //   47: aload_2
    //   48: aload_3
    //   49: iconst_0
    //   50: aload_3
    //   51: arraylength
    //   52: invokevirtual 97	java/io/DataInputStream:readFully	([BII)V
    //   55: aload_2
    //   56: invokestatic 103	com/google/android/gms/internal/zzmt:zzb	(Ljava/io/Closeable;)V
    //   59: invokestatic 50	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   62: astore_2
    //   63: aload_2
    //   64: aload_3
    //   65: iconst_0
    //   66: aload_3
    //   67: arraylength
    //   68: invokevirtual 106	android/os/Parcel:unmarshall	([BII)V
    //   71: aload_2
    //   72: iconst_0
    //   73: invokevirtual 110	android/os/Parcel:setDataPosition	(I)V
    //   76: aload_0
    //   77: aload_1
    //   78: aload_2
    //   79: invokeinterface 116 2 0
    //   84: checkcast 6	com/google/android/gms/common/internal/safeparcel/SafeParcelable
    //   87: putfield 37	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:zzFd	Landroid/os/Parcelable;
    //   90: aload_2
    //   91: invokevirtual 61	android/os/Parcel:recycle	()V
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 39	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:zzFe	Z
    //   99: aload_0
    //   100: getfield 37	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:zzFd	Landroid/os/Parcelable;
    //   103: checkcast 6	com/google/android/gms/common/internal/safeparcel/SafeParcelable
    //   106: areturn
    //   107: astore_1
    //   108: new 118	java/lang/IllegalStateException
    //   111: dup
    //   112: ldc 120
    //   114: aload_1
    //   115: invokespecial 123	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: athrow
    //   119: astore_1
    //   120: aload_2
    //   121: invokestatic 103	com/google/android/gms/internal/zzmt:zzb	(Ljava/io/Closeable;)V
    //   124: aload_1
    //   125: athrow
    //   126: astore_1
    //   127: aload_2
    //   128: invokevirtual 61	android/os/Parcel:recycle	()V
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	LargeParcelTeleporter
    //   0	133	1	paramCreator	Parcelable.Creator<T>
    //   39	89	2	localObject	Object
    //   46	21	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   40	55	107	java/io/IOException
    //   40	55	119	finally
    //   108	119	119	finally
    //   63	90	126	finally
  }
  
  protected <T> ParcelFileDescriptor zzf(final byte[] paramArrayOfByte)
  {
    try
    {
      ParcelFileDescriptor[] arrayOfParcelFileDescriptor = ParcelFileDescriptor.createPipe();
      localAutoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(arrayOfParcelFileDescriptor[1]);
      zzb.zzb("Error transporting the ad response", paramArrayOfByte);
    }
    catch (IOException paramArrayOfByte)
    {
      try
      {
        new Thread(new Runnable()
        {
          /* Error */
          public void run()
          {
            // Byte code:
            //   0: new 34	java/io/DataOutputStream
            //   3: dup
            //   4: aload_0
            //   5: getfield 23	com/google/android/gms/ads/internal/request/LargeParcelTeleporter$1:zzFf	Ljava/io/OutputStream;
            //   8: invokespecial 37	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
            //   11: astore_2
            //   12: aload_2
            //   13: astore_1
            //   14: aload_2
            //   15: aload_0
            //   16: getfield 25	com/google/android/gms/ads/internal/request/LargeParcelTeleporter$1:zzFg	[B
            //   19: arraylength
            //   20: invokevirtual 41	java/io/DataOutputStream:writeInt	(I)V
            //   23: aload_2
            //   24: astore_1
            //   25: aload_2
            //   26: aload_0
            //   27: getfield 25	com/google/android/gms/ads/internal/request/LargeParcelTeleporter$1:zzFg	[B
            //   30: invokevirtual 45	java/io/DataOutputStream:write	([B)V
            //   33: aload_2
            //   34: ifnonnull +11 -> 45
            //   37: aload_0
            //   38: getfield 23	com/google/android/gms/ads/internal/request/LargeParcelTeleporter$1:zzFf	Ljava/io/OutputStream;
            //   41: invokestatic 51	com/google/android/gms/internal/zzmt:zzb	(Ljava/io/Closeable;)V
            //   44: return
            //   45: aload_2
            //   46: invokestatic 51	com/google/android/gms/internal/zzmt:zzb	(Ljava/io/Closeable;)V
            //   49: return
            //   50: astore_3
            //   51: aconst_null
            //   52: astore_2
            //   53: aload_2
            //   54: astore_1
            //   55: ldc 53
            //   57: aload_3
            //   58: invokestatic 58	com/google/android/gms/ads/internal/util/client/zzb:zzb	(Ljava/lang/String;Ljava/lang/Throwable;)V
            //   61: aload_2
            //   62: astore_1
            //   63: invokestatic 64	com/google/android/gms/ads/internal/zzp:zzby	()Lcom/google/android/gms/internal/zzhu;
            //   66: aload_3
            //   67: iconst_1
            //   68: invokevirtual 70	com/google/android/gms/internal/zzhu:zzc	(Ljava/lang/Throwable;Z)V
            //   71: aload_2
            //   72: ifnonnull +11 -> 83
            //   75: aload_0
            //   76: getfield 23	com/google/android/gms/ads/internal/request/LargeParcelTeleporter$1:zzFf	Ljava/io/OutputStream;
            //   79: invokestatic 51	com/google/android/gms/internal/zzmt:zzb	(Ljava/io/Closeable;)V
            //   82: return
            //   83: aload_2
            //   84: invokestatic 51	com/google/android/gms/internal/zzmt:zzb	(Ljava/io/Closeable;)V
            //   87: return
            //   88: astore_2
            //   89: aconst_null
            //   90: astore_1
            //   91: aload_1
            //   92: ifnonnull +12 -> 104
            //   95: aload_0
            //   96: getfield 23	com/google/android/gms/ads/internal/request/LargeParcelTeleporter$1:zzFf	Ljava/io/OutputStream;
            //   99: invokestatic 51	com/google/android/gms/internal/zzmt:zzb	(Ljava/io/Closeable;)V
            //   102: aload_2
            //   103: athrow
            //   104: aload_1
            //   105: invokestatic 51	com/google/android/gms/internal/zzmt:zzb	(Ljava/io/Closeable;)V
            //   108: goto -6 -> 102
            //   111: astore_2
            //   112: goto -21 -> 91
            //   115: astore_3
            //   116: goto -63 -> 53
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	119	0	this	1
            //   13	92	1	localDataOutputStream1	java.io.DataOutputStream
            //   11	73	2	localDataOutputStream2	java.io.DataOutputStream
            //   88	15	2	localObject1	Object
            //   111	1	2	localObject2	Object
            //   50	17	3	localIOException1	IOException
            //   115	1	3	localIOException2	IOException
            // Exception table:
            //   from	to	target	type
            //   0	12	50	java/io/IOException
            //   0	12	88	finally
            //   14	23	111	finally
            //   25	33	111	finally
            //   55	61	111	finally
            //   63	71	111	finally
            //   14	23	115	java/io/IOException
            //   25	33	115	java/io/IOException
          }
        }).start();
        paramArrayOfByte = arrayOfParcelFileDescriptor[0];
        return paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        final ParcelFileDescriptor.AutoCloseOutputStream localAutoCloseOutputStream;
        for (;;) {}
      }
      paramArrayOfByte = paramArrayOfByte;
      localAutoCloseOutputStream = null;
    }
    zzp.zzby().zzc(paramArrayOfByte, true);
    zzmt.zzb(localAutoCloseOutputStream);
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.LargeParcelTeleporter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */