package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public abstract class DOMDeserializer<T>
  extends FromStringDeserializer<T>
{
  private static final DocumentBuilderFactory _parserFactory = ;
  private static final long serialVersionUID = 1L;
  
  static
  {
    _parserFactory.setNamespaceAware(true);
  }
  
  protected DOMDeserializer(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  public abstract T _deserialize(String paramString, DeserializationContext paramDeserializationContext);
  
  protected final Document parse(String paramString)
    throws IllegalArgumentException
  {
    try
    {
      paramString = _parserFactory.newDocumentBuilder().parse(new InputSource(new StringReader(paramString)));
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new IllegalArgumentException("Failed to parse JSON String as XML: " + paramString.getMessage(), paramString);
    }
  }
  
  public static class DocumentDeserializer
    extends DOMDeserializer<Document>
  {
    private static final long serialVersionUID = 1L;
    
    public DocumentDeserializer()
    {
      super();
    }
    
    public Document _deserialize(String paramString, DeserializationContext paramDeserializationContext)
      throws IllegalArgumentException
    {
      return parse(paramString);
    }
  }
  
  public static class NodeDeserializer
    extends DOMDeserializer<Node>
  {
    private static final long serialVersionUID = 1L;
    
    public NodeDeserializer()
    {
      super();
    }
    
    public Node _deserialize(String paramString, DeserializationContext paramDeserializationContext)
      throws IllegalArgumentException
    {
      return parse(paramString);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ext.DOMDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */