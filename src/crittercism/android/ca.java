package crittercism.android;

import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class ca
  extends bq
{
  private ca(File paramFile)
  {
    super(paramFile);
  }
  
  public final Object a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject((String)super.a());
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public static final class a
    extends cj
  {
    public final bq a(File paramFile)
    {
      return new ca(paramFile, (byte)0);
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.ca
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */