package org.apache.commons.io.input;

public class TailerListenerAdapter
  implements TailerListener
{
  public void fileNotFound() {}
  
  public void fileRotated() {}
  
  public void handle(Exception paramException) {}
  
  public void handle(String paramString) {}
  
  public void init(Tailer paramTailer) {}
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.TailerListenerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */