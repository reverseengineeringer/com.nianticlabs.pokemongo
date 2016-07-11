package crittercism.android;

import com.crittercism.integrations.PluginException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bk
  implements ch
{
  public long a;
  public JSONArray b;
  public String c;
  public String d = "";
  public JSONArray e;
  public String f;
  public JSONObject g;
  private JSONObject h;
  private JSONArray i;
  private JSONArray j;
  private String k;
  private JSONArray l;
  private String m;
  private int n = -1;
  private boolean o = false;
  private String p;
  
  public bk(Throwable paramThrowable, long paramLong)
  {
    o = (paramThrowable instanceof PluginException);
    p = cg.a.a();
    f = "uhe";
    bu localbu = new bu();
    localbu.a(new bx.a()).a(new bx.c()).a(new bx.b()).a(new bx.d()).a(new bx.e()).a(new bx.f()).a(new bx.o()).a(new bx.p()).a(new bx.i()).a(new bx.j()).a(new bx.h()).a(new bx.z()).a(new bx.aa()).a(new bx.k()).a(new bx.l()).a(new bx.n()).a(new bx.m()).a(new bx.q()).a(new bx.r()).a(new bx.s()).a(new bx.t()).a(new bx.u()).a(new bx.v()).a(new bx.w()).a(new bx.x()).a(new bx.y());
    g = localbu.a();
    h = new JSONObject();
    a = paramLong;
    c = a(paramThrowable);
    if (paramThrowable.getMessage() != null) {
      d = paramThrowable.getMessage();
    }
    if (!o) {
      n = c(paramThrowable);
    }
    k = "android";
    m = ed.a.a();
    l = new JSONArray();
    paramThrowable = b(paramThrowable);
    int i2 = paramThrowable.length;
    while (i1 < i2)
    {
      localbu = paramThrowable[i1];
      l.put(localbu);
      i1 += 1;
    }
  }
  
  private String a(Throwable paramThrowable)
  {
    Throwable localThrowable = paramThrowable;
    if (o) {
      return ((PluginException)paramThrowable).getExceptionName();
    }
    String str;
    do
    {
      localThrowable = paramThrowable;
      str = localThrowable.getClass().getName();
      paramThrowable = localThrowable.getCause();
    } while ((paramThrowable != null) && (paramThrowable != localThrowable));
    return str;
  }
  
  private static String[] b(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    for (;;)
    {
      paramThrowable.printStackTrace(localPrintWriter);
      Throwable localThrowable = paramThrowable.getCause();
      if ((localThrowable == null) || (localThrowable == paramThrowable)) {
        return localStringWriter.toString().split("\n");
      }
      paramThrowable = localThrowable;
    }
  }
  
  private static int c(Throwable paramThrowable)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    int i1 = 0;
    if (i1 < arrayOfStackTraceElement.length) {
      paramThrowable = arrayOfStackTraceElement[i1];
    }
    for (;;)
    {
      try
      {
        Class localClass = Class.forName(paramThrowable.getClassName());
        paramThrowable = ClassLoader.getSystemClassLoader();
        if (paramThrowable == null) {
          break label71;
        }
        if (localClass.getClassLoader() == paramThrowable)
        {
          i2 = 1;
          if (i2 == 0) {
            return i1 + 1;
          }
        }
        else
        {
          paramThrowable = paramThrowable.getParent();
          continue;
        }
      }
      catch (ClassNotFoundException paramThrowable)
      {
        i1 += 1;
      }
      return -1;
      label71:
      int i2 = 0;
    }
  }
  
  public final void a()
  {
    e = new JSONArray();
    Iterator localIterator = Thread.getAllStackTraces().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      HashMap localHashMap = new HashMap();
      Thread localThread = (Thread)localEntry.getKey();
      if (localThread.getId() != a)
      {
        localHashMap.put("name", localThread.getName());
        localHashMap.put("id", Long.valueOf(localThread.getId()));
        localHashMap.put("state", localThread.getState().name());
        localHashMap.put("stacktrace", new JSONArray(Arrays.asList((Object[])localEntry.getValue())));
        e.put(new JSONObject(localHashMap));
      }
    }
  }
  
  public final void a(bs parambs)
  {
    i = boa;
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    paramOutputStream.write(b().toString().getBytes());
  }
  
  public final void a(String paramString, bs parambs)
  {
    parambs = boa;
    try
    {
      h.put(paramString, parambs);
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public final void a(List paramList)
  {
    j = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bg localbg = (bg)paramList.next();
      try
      {
        j.put(localbg.j());
      }
      catch (JSONException localJSONException)
      {
        dx.a(localJSONException);
      }
    }
  }
  
  public final JSONObject b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("app_state", g);
    localHashMap.put("breadcrumbs", h);
    localHashMap.put("current_thread_id", Long.valueOf(a));
    if (i != null) {
      localHashMap.put("endpoints", i);
    }
    if (b != null) {
      localHashMap.put("systemBreadcrumbs", b);
    }
    if ((j != null) && (j.length() > 0)) {
      localHashMap.put("transactions", j);
    }
    localHashMap.put("exception_name", c);
    localHashMap.put("exception_reason", d);
    localHashMap.put("platform", k);
    if (e != null) {
      localHashMap.put("threads", e);
    }
    localHashMap.put("ts", m);
    String str2 = f;
    String str1 = str2;
    if (a != 1L) {
      str1 = str2 + "-bg";
    }
    localHashMap.put("type", str1);
    localHashMap.put("unsymbolized_stacktrace", l);
    if (!o) {
      localHashMap.put("suspect_line_index", Integer.valueOf(n));
    }
    return new JSONObject(localHashMap);
  }
  
  public final String e()
  {
    return p;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */