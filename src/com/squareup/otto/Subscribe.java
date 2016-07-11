package com.squareup.otto;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface Subscribe {}

/* Location:
 * Qualified Name:     com.squareup.otto.Subscribe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */