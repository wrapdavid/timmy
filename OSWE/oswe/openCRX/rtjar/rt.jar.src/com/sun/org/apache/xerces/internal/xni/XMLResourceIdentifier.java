package com.sun.org.apache.xerces.internal.xni;

public interface XMLResourceIdentifier {
  void setPublicId(String paramString);
  
  String getPublicId();
  
  void setExpandedSystemId(String paramString);
  
  String getExpandedSystemId();
  
  void setLiteralSystemId(String paramString);
  
  String getLiteralSystemId();
  
  void setBaseSystemId(String paramString);
  
  String getBaseSystemId();
  
  void setNamespace(String paramString);
  
  String getNamespace();
}


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/com/sun/org/apache/xerces/internal/xni/XMLResourceIdentifier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */