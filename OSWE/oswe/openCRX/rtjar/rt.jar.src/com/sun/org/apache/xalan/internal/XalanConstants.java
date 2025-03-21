/*     */ package com.sun.org.apache.xalan.internal;
/*     */ 
/*     */ import com.sun.org.apache.xalan.internal.utils.SecuritySupport;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class XalanConstants
/*     */ {
/*     */   public static final String SECURITY_MANAGER = "http://apache.org/xml/properties/security-manager";
/*     */   public static final String ORACLE_JAXP_PROPERTY_PREFIX = "http://www.oracle.com/xml/jaxp/properties/";
/*     */   public static final String JDK_ENTITY_EXPANSION_LIMIT = "http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit";
/*     */   public static final String JDK_ELEMENT_ATTRIBUTE_LIMIT = "http://www.oracle.com/xml/jaxp/properties/elementAttributeLimit";
/*     */   public static final String JDK_MAX_OCCUR_LIMIT = "http://www.oracle.com/xml/jaxp/properties/maxOccurLimit";
/*     */   public static final String JDK_TOTAL_ENTITY_SIZE_LIMIT = "http://www.oracle.com/xml/jaxp/properties/totalEntitySizeLimit";
/*     */   public static final String JDK_GENERAL_ENTITY_SIZE_LIMIT = "http://www.oracle.com/xml/jaxp/properties/maxGeneralEntitySizeLimit";
/*     */   public static final String JDK_ENTITY_REPLACEMENT_LIMIT = "http://www.oracle.com/xml/jaxp/properties/entityReplacementLimit";
/*     */   public static final String JDK_PARAMETER_ENTITY_SIZE_LIMIT = "http://www.oracle.com/xml/jaxp/properties/maxParameterEntitySizeLimit";
/*     */   public static final String JDK_XML_NAME_LIMIT = "http://www.oracle.com/xml/jaxp/properties/maxXMLNameLimit";
/*     */   public static final String JDK_MAX_ELEMENT_DEPTH = "http://www.oracle.com/xml/jaxp/properties/maxElementDepth";
/*     */   public static final String JDK_ENTITY_COUNT_INFO = "http://www.oracle.com/xml/jaxp/properties/getEntityCountInfo";
/*     */   public static final String SP_ENTITY_EXPANSION_LIMIT = "jdk.xml.entityExpansionLimit";
/*     */   public static final String SP_ELEMENT_ATTRIBUTE_LIMIT = "jdk.xml.elementAttributeLimit";
/*     */   public static final String SP_MAX_OCCUR_LIMIT = "jdk.xml.maxOccurLimit";
/*     */   public static final String SP_TOTAL_ENTITY_SIZE_LIMIT = "jdk.xml.totalEntitySizeLimit";
/*     */   public static final String SP_GENERAL_ENTITY_SIZE_LIMIT = "jdk.xml.maxGeneralEntitySizeLimit";
/*     */   public static final String SP_ENTITY_REPLACEMENT_LIMIT = "jdk.xml.entityReplacementLimit";
/*     */   public static final String SP_PARAMETER_ENTITY_SIZE_LIMIT = "jdk.xml.maxParameterEntitySizeLimit";
/*     */   public static final String SP_XML_NAME_LIMIT = "jdk.xml.maxXMLNameLimit";
/*     */   public static final String SP_MAX_ELEMENT_DEPTH = "jdk.xml.maxElementDepth";
/*     */   public static final String JDK_EXTENSION_CLASSLOADER = "jdk.xml.transform.extensionClassLoader";
/*     */   public static final String ENTITY_EXPANSION_LIMIT = "entityExpansionLimit";
/*     */   public static final String ELEMENT_ATTRIBUTE_LIMIT = "elementAttributeLimit";
/*     */   public static final String MAX_OCCUR_LIMIT = "maxOccurLimit";
/*     */   public static final String JDK_YES = "yes";
/*     */   public static final String ORACLE_FEATURE_SERVICE_MECHANISM = "http://www.oracle.com/feature/use-service-mechanism";
/*     */   public static final String SP_ACCESS_EXTERNAL_STYLESHEET = "javax.xml.accessExternalStylesheet";
/*     */   public static final String SP_ACCESS_EXTERNAL_DTD = "javax.xml.accessExternalDTD";
/*     */   public static final String ACCESS_EXTERNAL_ALL = "all";
/*     */   public static final String EXTERNAL_ACCESS_DEFAULT_FSP = "";
/*     */   public static final String EXTERNAL_ACCESS_DEFAULT = "all";
/*     */   public static final String XML_SECURITY_PROPERTY_MANAGER = "http://www.oracle.com/xml/jaxp/properties/xmlSecurityPropertyManager";
/*     */   public static final String ORACLE_ENABLE_EXTENSION_FUNCTION = "http://www.oracle.com/xml/jaxp/properties/enableExtensionFunctions";
/*     */   public static final String SP_ORACLE_ENABLE_EXTENSION_FUNCTION = "javax.xml.enableExtensionFunctions";
/*     */   public static final String FEATURE_TRUE = "true";
/*     */   public static final String FEATURE_FALSE = "false";
/* 243 */   public static final boolean IS_JDK8_OR_ABOVE = isJavaVersionAtLeast(8);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isJavaVersionAtLeast(int compareTo) {
/* 258 */     String javaVersion = SecuritySupport.getSystemProperty("java.version");
/* 259 */     String[] versions = javaVersion.split("\\.", 3);
/* 260 */     if (Integer.parseInt(versions[0]) >= compareTo || 
/* 261 */       Integer.parseInt(versions[1]) >= compareTo) {
/* 262 */       return true;
/*     */     }
/* 264 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/com/sun/org/apache/xalan/internal/XalanConstants.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */