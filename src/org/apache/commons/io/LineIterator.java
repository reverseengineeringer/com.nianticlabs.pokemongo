package org.apache.commons.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LineIterator
  implements Iterator<String>
{
  private final BufferedReader bufferedReader;
  private String cachedLine;
  private boolean finished = false;
  
  public LineIterator(Reader paramReader)
    throws IllegalArgumentException
  {
    if (paramReader == null) {
      throw new IllegalArgumentException("Reader must not be null");
    }
    if ((paramReader instanceof BufferedReader))
    {
      bufferedReader = ((BufferedReader)paramReader);
      return;
    }
    bufferedReader = new BufferedReader(paramReader);
  }
  
  public static void closeQuietly(LineIterator paramLineIterator)
  {
    if (paramLineIterator != null) {
      paramLineIterator.close();
    }
  }
  
  public void close()
  {
    finished = true;
    IOUtils.closeQuietly(bufferedReader);
    cachedLine = null;
  }
  
  public boolean hasNext()
  {
    if (cachedLine != null) {
      return true;
    }
    if (finished) {
      return false;
    }
    try
    {
      String str;
      do
      {
        str = bufferedReader.readLine();
        if (str == null)
        {
          finished = true;
          return false;
        }
      } while (!isValidLine(str));
      cachedLine = str;
      return true;
    }
    catch (IOException localIOException)
    {
      close();
      throw new IllegalStateException(localIOException);
    }
  }
  
  protected boolean isValidLine(String paramString)
  {
    return true;
  }
  
  public String next()
  {
    return nextLine();
  }
  
  public String nextLine()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("No more lines");
    }
    String str = cachedLine;
    cachedLine = null;
    return str;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Remove unsupported on LineIterator");
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.LineIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */