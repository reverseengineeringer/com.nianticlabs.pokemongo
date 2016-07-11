package crittercism.android;

import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;

public final class bz
  extends bq
{
  private bz(File paramFile)
  {
    super(paramFile);
  }
  
  public final Object a()
  {
    try
    {
      JSONArray localJSONArray = new JSONArray((String)super.a());
      return localJSONArray;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public static final class a
    extends cj
  {
    public final bq a(File paramFile)
    {
      return new bz(paramFile, (byte)0);
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */