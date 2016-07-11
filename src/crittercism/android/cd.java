package crittercism.android;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cd
  implements ch
{
  private JSONObject a;
  private JSONObject b;
  private JSONArray c;
  private JSONArray d;
  private File e;
  private String f;
  
  public cd(File paramFile, bs parambs1, bs parambs2, bs parambs3, bs parambs4)
  {
    paramFile.exists();
    f = cg.a.a();
    e = paramFile;
    a = new bu().a(new bx.c()).a(new bx.b()).a(new bx.d()).a(new bx.f()).a(new bx.o()).a(new bx.p()).a(new bx.j()).a(new bx.h()).a(new bx.z()).a(new bx.aa()).a(new bx.k()).a(new bx.r()).a(new bx.m()).a(new bx.s()).a(new bx.w()).a(new bx.x()).a();
    paramFile = new HashMap();
    paramFile.put("crashed_session", boa);
    if (parambs2.b() > 0) {
      paramFile.put("previous_session", boa);
    }
    b = new JSONObject(paramFile);
    c = boa;
    d = boa;
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_state", a);
    localHashMap.put("breadcrumbs", b);
    localHashMap.put("endpoints", c);
    localHashMap.put("systemBreadcrumbs", d);
    Object localObject1 = new byte[0];
    byte[] arrayOfByte = new byte[' '];
    FileInputStream localFileInputStream = new FileInputStream(e);
    for (;;)
    {
      int i = localFileInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localObject2 = new byte[localObject1.length + i];
      System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
      System.arraycopy(arrayOfByte, 0, localObject2, localObject1.length, i);
      localObject1 = localObject2;
    }
    localFileInputStream.close();
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("dmp_name", e.getName());
    ((Map)localObject2).put("dmp_file", cr.a((byte[])localObject1));
    localHashMap.put("ndk_dmp_info", new JSONObject((Map)localObject2));
    paramOutputStream.write(new JSONObject(localHashMap).toString().getBytes());
  }
  
  public final String e()
  {
    return f;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.cd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */