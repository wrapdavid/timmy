package com.sun.org.glassfish.gmbal;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritedAttribute {
  String description();
  
  String id() default "";
  
  String methodName() default "";
}


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/com/sun/org/glassfish/gmbal/InheritedAttribute.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */