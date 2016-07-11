package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import java.io.Serializable;

public abstract class NopAnnotationIntrospector
  extends AnnotationIntrospector
  implements Serializable
{
  public static final NopAnnotationIntrospector instance = new NopAnnotationIntrospector()
  {
    private static final long serialVersionUID = 1L;
    
    public Version version()
    {
      return PackageVersion.VERSION;
    }
  };
  private static final long serialVersionUID = 1L;
  
  public Version version()
  {
    return Version.unknownVersion();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */