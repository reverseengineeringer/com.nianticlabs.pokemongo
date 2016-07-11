package crittercism.android;

import org.apache.http.ParseException;
import org.apache.http.RequestLine;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

public final class an
  extends af
{
  public an(al paramal)
  {
    super(paramal);
  }
  
  public final boolean a(CharArrayBuffer paramCharArrayBuffer)
  {
    ParserCursor localParserCursor = new ParserCursor(0, paramCharArrayBuffer.length());
    try
    {
      paramCharArrayBuffer = BasicLineParser.DEFAULT.parseRequestLine(paramCharArrayBuffer, localParserCursor);
      a.a(paramCharArrayBuffer.getMethod(), paramCharArrayBuffer.getUri());
      return true;
    }
    catch (ParseException paramCharArrayBuffer) {}
    return false;
  }
  
  public final af b()
  {
    return new am(this);
  }
  
  public final af c()
  {
    return as.d;
  }
  
  protected final int d()
  {
    return 64;
  }
  
  protected final int e()
  {
    return 2048;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.an
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */