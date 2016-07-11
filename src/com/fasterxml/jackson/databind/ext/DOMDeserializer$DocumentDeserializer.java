package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.DeserializationContext;
import org.w3c.dom.Document;

public class DOMDeserializer$DocumentDeserializer
  extends DOMDeserializer<Document>
{
  private static final long serialVersionUID = 1L;
  
  public DOMDeserializer$DocumentDeserializer()
  {
    super(Document.class);
  }
  
  public Document _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IllegalArgumentException
  {
    return parse(paramString);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ext.DOMDeserializer.DocumentDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */