package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.cfg.PackageVersion;

final class NopAnnotationIntrospector$1
  extends NopAnnotationIntrospector
{
  private static final long serialVersionUID = 1L;
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */