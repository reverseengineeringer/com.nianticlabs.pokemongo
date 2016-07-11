package com.google.android.gms.common.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.CONSTRUCTOR})
public @interface KeepName {}

/* Location:
 * Qualified Name:     com.google.android.gms.common.annotation.KeepName
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */