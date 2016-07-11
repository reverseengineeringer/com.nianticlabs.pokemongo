package crittercism.android;

import java.io.OutputStream;
import org.json.JSONArray;

public abstract class ci
  extends bp
{
  public abstract JSONArray a();
  
  public final void a(OutputStream paramOutputStream)
  {
    String str = a().toString();
    new StringBuilder("BREADCRUMB WRITING ").append(str);
    dx.b();
    paramOutputStream.write(str.getBytes());
  }
}

/* Location:
 * Qualified Name:     crittercism.android.ci
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */