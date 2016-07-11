package com.squareup.otto;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface Produce {}

/* Location:
 * Qualified Name:     com.squareup.otto.Produce
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */