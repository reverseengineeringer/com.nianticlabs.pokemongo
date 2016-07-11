package crittercism.android;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.math.BigInteger;

public final class bx$u
  implements bw
{
  private String a = null;
  
  public bx$u()
  {
    try
    {
      BigInteger.valueOf(-1L);
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      a = BigInteger.valueOf(localStatFs.getAvailableBlocks()).multiply(BigInteger.valueOf(localStatFs.getBlockSize())).toString();
      return;
    }
    catch (ThreadDeath localThreadDeath)
    {
      throw localThreadDeath;
    }
    catch (Throwable localThrowable)
    {
      a = null;
    }
  }
  
  public final String a()
  {
    return "sd_space_free";
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bx.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */