package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface XmlElements {
  XmlElement[] value();
}


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/javax/xml/bind/annotation/XmlElements.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */