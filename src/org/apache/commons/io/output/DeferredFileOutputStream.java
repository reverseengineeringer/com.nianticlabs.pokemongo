package org.apache.commons.io.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

public class DeferredFileOutputStream
  extends ThresholdingOutputStream
{
  private boolean closed = false;
  private OutputStream currentOutputStream;
  private final File directory;
  private ByteArrayOutputStream memoryOutputStream;
  private File outputFile;
  private final String prefix;
  private final String suffix;
  
  public DeferredFileOutputStream(int paramInt, File paramFile)
  {
    this(paramInt, paramFile, null, null, null);
  }
  
  private DeferredFileOutputStream(int paramInt, File paramFile1, String paramString1, String paramString2, File paramFile2)
  {
    super(paramInt);
    outputFile = paramFile1;
    memoryOutputStream = new ByteArrayOutputStream();
    currentOutputStream = memoryOutputStream;
    prefix = paramString1;
    suffix = paramString2;
    directory = paramFile2;
  }
  
  public DeferredFileOutputStream(int paramInt, String paramString1, String paramString2, File paramFile)
  {
    this(paramInt, null, paramString1, paramString2, paramFile);
    if (paramString1 == null) {
      throw new IllegalArgumentException("Temporary file prefix is missing");
    }
  }
  
  public void close()
    throws IOException
  {
    super.close();
    closed = true;
  }
  
  public byte[] getData()
  {
    if (memoryOutputStream != null) {
      return memoryOutputStream.toByteArray();
    }
    return null;
  }
  
  public File getFile()
  {
    return outputFile;
  }
  
  protected OutputStream getStream()
    throws IOException
  {
    return currentOutputStream;
  }
  
  public boolean isInMemory()
  {
    return !isThresholdExceeded();
  }
  
  protected void thresholdReached()
    throws IOException
  {
    if (prefix != null) {
      outputFile = File.createTempFile(prefix, suffix, directory);
    }
    FileOutputStream localFileOutputStream = new FileOutputStream(outputFile);
    memoryOutputStream.writeTo(localFileOutputStream);
    currentOutputStream = localFileOutputStream;
    memoryOutputStream = null;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    if (!closed) {
      throw new IOException("Stream not closed");
    }
    if (isInMemory())
    {
      memoryOutputStream.writeTo(paramOutputStream);
      return;
    }
    FileInputStream localFileInputStream = new FileInputStream(outputFile);
    try
    {
      IOUtils.copy(localFileInputStream, paramOutputStream);
      return;
    }
    finally
    {
      IOUtils.closeQuietly(localFileInputStream);
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.output.DeferredFileOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */