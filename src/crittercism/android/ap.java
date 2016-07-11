package crittercism.android;

import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

public final class ap
  extends af
{
  private int d = -1;
  
  public ap(al paramal)
  {
    super(paramal);
  }
  
  public final boolean a(CharArrayBuffer paramCharArrayBuffer)
  {
    ParserCursor localParserCursor = new ParserCursor(0, paramCharArrayBuffer.length());
    try
    {
      paramCharArrayBuffer = BasicLineParser.DEFAULT.parseStatusLine(paramCharArrayBuffer, localParserCursor);
      d = paramCharArrayBuffer.getStatusCode();
      a.a(paramCharArrayBuffer.getStatusCode());
      return true;
    }
    catch (ParseException paramCharArrayBuffer) {}
    return false;
  }
  
  public final af b()
  {
    return new ao(this, d);
  }
  
  public final af c()
  {
    return as.d;
  }
  
  protected final int d()
  {
    return 20;
  }
  
  protected final int e()
  {
    return 64;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.ap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */