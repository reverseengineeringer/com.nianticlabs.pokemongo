package org.apache.commons.io;

import java.io.IOException;
import java.io.Serializable;

public class TaggedIOException
  extends IOExceptionWithCause
{
  private static final long serialVersionUID = -6994123481142850163L;
  private final Serializable tag;
  
  public TaggedIOException(IOException paramIOException, Serializable paramSerializable)
  {
    super(paramIOException.getMessage(), paramIOException);
    tag = paramSerializable;
  }
  
  public static boolean isTaggedWith(Throwable paramThrowable, Object paramObject)
  {
    return (paramObject != null) && ((paramThrowable instanceof TaggedIOException)) && (paramObject.equals(tag));
  }
  
  public static void throwCauseIfTaggedWith(Throwable paramThrowable, Object paramObject)
    throws IOException
  {
    if (isTaggedWith(paramThrowable, paramObject)) {
      throw ((TaggedIOException)paramThrowable).getCause();
    }
  }
  
  public IOException getCause()
  {
    return (IOException)super.getCause();
  }
  
  public Serializable getTag()
  {
    return tag;
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.TaggedIOException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */