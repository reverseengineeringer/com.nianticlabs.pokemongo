package org.apache.commons.io.input;

import java.io.IOException;

public class XmlStreamReaderException
  extends IOException
{
  private static final long serialVersionUID = 1L;
  private final String bomEncoding;
  private final String contentTypeEncoding;
  private final String contentTypeMime;
  private final String xmlEncoding;
  private final String xmlGuessEncoding;
  
  public XmlStreamReaderException(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, null, null, paramString2, paramString3, paramString4);
  }
  
  public XmlStreamReaderException(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    super(paramString1);
    contentTypeMime = paramString2;
    contentTypeEncoding = paramString3;
    bomEncoding = paramString4;
    xmlGuessEncoding = paramString5;
    xmlEncoding = paramString6;
  }
  
  public String getBomEncoding()
  {
    return bomEncoding;
  }
  
  public String getContentTypeEncoding()
  {
    return contentTypeEncoding;
  }
  
  public String getContentTypeMime()
  {
    return contentTypeMime;
  }
  
  public String getXmlEncoding()
  {
    return xmlEncoding;
  }
  
  public String getXmlGuessEncoding()
  {
    return xmlGuessEncoding;
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.XmlStreamReaderException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */