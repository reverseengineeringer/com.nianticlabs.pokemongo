package crittercism.android;

import android.os.Build.VERSION;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONArray;

public final class cc
  implements cb
{
  private static JSONArray a(InputStream paramInputStream)
  {
    JSONArray localJSONArray = new JSONArray();
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    int i = 0;
    try
    {
      int j;
      do
      {
        String str = paramInputStream.readLine();
        if (str == null) {
          break;
        }
        localJSONArray.put(str);
        j = i + 1;
        i = j;
      } while (j <= 200);
      try
      {
        paramInputStream.close();
        return localJSONArray;
      }
      catch (IOException paramInputStream)
      {
        dx.a();
        return localJSONArray;
      }
      try
      {
        paramInputStream.close();
        throw ((Throwable)localObject);
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          dx.a();
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      dx.a();
      try
      {
        paramInputStream.close();
        return localJSONArray;
      }
      catch (IOException paramInputStream)
      {
        dx.a();
        return localJSONArray;
      }
    }
    finally {}
  }
  
  public final JSONArray a()
  {
    JSONArray localJSONArray1 = new JSONArray();
    Object localObject3 = null;
    Object localObject1 = null;
    if (Build.VERSION.SDK_INT < 10)
    {
      localJSONArray1.put("Logcat data is not collected for Android APIs before 10 (Gingerbread)");
      localJSONArray1.put("API level is " + Build.VERSION.SDK_INT + "(" + Build.VERSION.CODENAME + ")");
      localObject3 = localJSONArray1;
    }
    for (;;)
    {
      return (JSONArray)localObject3;
      try
      {
        Process localProcess = new ProcessBuilder(new String[] { "logcat", "-t", Integer.toString(100), "-v", "time" }).redirectErrorStream(true).start();
        localObject1 = localProcess;
        localObject3 = localProcess;
        JSONArray localJSONArray2 = a(localProcess.getInputStream());
        localObject1 = localJSONArray2;
        localObject3 = localObject1;
        if (localProcess == null) {
          continue;
        }
        localProcess.destroy();
        return (JSONArray)localObject1;
      }
      catch (Exception localException)
      {
        localObject3 = localObject1;
        dx.b("Unable to collect logcat data", localException);
        localObject3 = localObject1;
        localJSONArray1.put("Unable to collect logcat data due to a(n) " + localException.getClass().getName());
        localObject3 = localObject1;
        String str = localException.getMessage();
        if (str != null)
        {
          localObject3 = localObject1;
          localJSONArray1.put(str);
        }
        localObject3 = localJSONArray1;
        return localJSONArray1;
      }
      finally
      {
        if (localObject3 != null) {
          ((Process)localObject3).destroy();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.cc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */