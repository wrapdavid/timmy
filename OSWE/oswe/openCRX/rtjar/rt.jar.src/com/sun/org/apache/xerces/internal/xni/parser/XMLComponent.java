package com.sun.org.apache.xerces.internal.xni.parser;

public interface XMLComponent {
  void reset(XMLComponentManager paramXMLComponentManager) throws XMLConfigurationException;
  
  String[] getRecognizedFeatures();
  
  void setFeature(String paramString, boolean paramBoolean) throws XMLConfigurationException;
  
  String[] getRecognizedProperties();
  
  void setProperty(String paramString, Object paramObject) throws XMLConfigurationException;
  
  Boolean getFeatureDefault(String paramString);
  
  Object getPropertyDefault(String paramString);
}


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/com/sun/org/apache/xerces/internal/xni/parser/XMLComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */