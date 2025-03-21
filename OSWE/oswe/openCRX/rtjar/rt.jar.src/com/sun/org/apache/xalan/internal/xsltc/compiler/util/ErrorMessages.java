/*    */ package com.sun.org.apache.xalan.internal.xsltc.compiler.util;
/*    */ 
/*    */ import java.util.ListResourceBundle;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ErrorMessages
/*    */   extends ListResourceBundle
/*    */ {
/*    */   public Object[][] getContents() {
/* 96 */     return new Object[][] { { "MULTIPLE_STYLESHEET_ERR", "More than one stylesheet defined in the same file." }, { "TEMPLATE_REDEF_ERR", "Template ''{0}'' already defined in this stylesheet." }, { "TEMPLATE_UNDEF_ERR", "Template ''{0}'' not defined in this stylesheet." }, { "VARIABLE_REDEF_ERR", "Variable ''{0}'' is multiply defined in the same scope." }, { "VARIABLE_UNDEF_ERR", "Variable or parameter ''{0}'' is undefined." }, { "CLASS_NOT_FOUND_ERR", "Cannot find class ''{0}''." }, { "METHOD_NOT_FOUND_ERR", "Cannot find external method ''{0}'' (must be public)." }, { "ARGUMENT_CONVERSION_ERR", "Cannot convert argument/return type in call to method ''{0}''" }, { "FILE_NOT_FOUND_ERR", "File or URI ''{0}'' not found." }, { "INVALID_URI_ERR", "Invalid URI ''{0}''." }, { "FILE_ACCESS_ERR", "Cannot open file or URI ''{0}''." }, { "MISSING_ROOT_ERR", "<xsl:stylesheet> or <xsl:transform> element expected." }, { "NAMESPACE_UNDEF_ERR", "Namespace prefix ''{0}'' is undeclared." }, { "FUNCTION_RESOLVE_ERR", "Unable to resolve call to function ''{0}''." }, { "NEED_LITERAL_ERR", "Argument to ''{0}'' must be a literal string." }, { "XPATH_PARSER_ERR", "Error parsing XPath expression ''{0}''." }, { "REQUIRED_ATTR_ERR", "Required attribute ''{0}'' is missing." }, { "ILLEGAL_CHAR_ERR", "Illegal character ''{0}'' in XPath expression." }, { "ILLEGAL_PI_ERR", "Illegal name ''{0}'' for processing instruction." }, { "STRAY_ATTRIBUTE_ERR", "Attribute ''{0}'' outside of element." }, { "ILLEGAL_ATTRIBUTE_ERR", "Illegal attribute ''{0}''." }, { "CIRCULAR_INCLUDE_ERR", "Circular import/include. Stylesheet ''{0}'' already loaded." }, { "RESULT_TREE_SORT_ERR", "Result-tree fragments cannot be sorted (<xsl:sort> elements are ignored). You must sort the nodes when creating the result tree." }, { "SYMBOLS_REDEF_ERR", "Decimal formatting ''{0}'' is already defined." }, { "XSL_VERSION_ERR", "XSL version ''{0}'' is not supported by XSLTC." }, { "CIRCULAR_VARIABLE_ERR", "Circular variable/parameter reference in ''{0}''." }, { "ILLEGAL_BINARY_OP_ERR", "Unknown operator for binary expression." }, { "ILLEGAL_ARG_ERR", "Illegal argument(s) for function call." }, { "DOCUMENT_ARG_ERR", "Second argument to document() function must be a node-set." }, { "MISSING_WHEN_ERR", "At least one <xsl:when> element required in <xsl:choose>." }, { "MULTIPLE_OTHERWISE_ERR", "Only one <xsl:otherwise> element allowed in <xsl:choose>." }, { "STRAY_OTHERWISE_ERR", "<xsl:otherwise> can only be used within <xsl:choose>." }, { "STRAY_WHEN_ERR", "<xsl:when> can only be used within <xsl:choose>." }, { "WHEN_ELEMENT_ERR", "Only <xsl:when> and <xsl:otherwise> elements allowed in <xsl:choose>." }, { "UNNAMED_ATTRIBSET_ERR", "<xsl:attribute-set> is missing the 'name' attribute." }, { "ILLEGAL_CHILD_ERR", "Illegal child element." }, { "ILLEGAL_ELEM_NAME_ERR", "You cannot call an element ''{0}''" }, { "ILLEGAL_ATTR_NAME_ERR", "You cannot call an attribute ''{0}''" }, { "ILLEGAL_TEXT_NODE_ERR", "Text data outside of top-level <xsl:stylesheet> element." }, { "SAX_PARSER_CONFIG_ERR", "JAXP parser not configured correctly" }, { "INTERNAL_ERR", "Unrecoverable XSLTC-internal error: ''{0}''" }, { "UNSUPPORTED_XSL_ERR", "Unsupported XSL element ''{0}''." }, { "UNSUPPORTED_EXT_ERR", "Unrecognised XSLTC extension ''{0}''." }, { "MISSING_XSLT_URI_ERR", "The input document is not a stylesheet (the XSL namespace is not declared in the root element)." }, { "MISSING_XSLT_TARGET_ERR", "Could not find stylesheet target ''{0}''." }, { "ACCESSING_XSLT_TARGET_ERR", "Could not read stylesheet target ''{0}'', because ''{1}'' access is not allowed due to restriction set by the accessExternalStylesheet property." }, { "NOT_IMPLEMENTED_ERR", "Not implemented: ''{0}''." }, { "NOT_STYLESHEET_ERR", "The input document does not contain an XSL stylesheet." }, { "ELEMENT_PARSE_ERR", "Could not parse element ''{0}''" }, { "KEY_USE_ATTR_ERR", "The use attribute of <key> must be node, node-set, string or number." }, { "OUTPUT_VERSION_ERR", "Output XML document version should be 1.0" }, { "ILLEGAL_RELAT_OP_ERR", "Unknown operator for relational expression" }, { "ATTRIBSET_UNDEF_ERR", "Attempting to use non-existing attribute set ''{0}''." }, { "ATTR_VAL_TEMPLATE_ERR", "Cannot parse attribute value template ''{0}''." }, { "UNKNOWN_SIG_TYPE_ERR", "Unknown data-type in signature for class ''{0}''." }, { "DATA_CONVERSION_ERR", "Cannot convert data-type ''{0}'' to ''{1}''." }, { "NO_TRANSLET_CLASS_ERR", "This Templates does not contain a valid translet class definition." }, { "NO_MAIN_TRANSLET_ERR", "This Templates does not contain a class with the name ''{0}''." }, { "TRANSLET_CLASS_ERR", "Could not load the translet class ''{0}''." }, { "TRANSLET_OBJECT_ERR", "Translet class loaded, but unable to create translet instance." }, { "ERROR_LISTENER_NULL_ERR", "Attempting to set ErrorListener for ''{0}'' to null" }, { "JAXP_UNKNOWN_SOURCE_ERR", "Only StreamSource, SAXSource and DOMSource are supported by XSLTC" }, { "JAXP_NO_SOURCE_ERR", "Source object passed to ''{0}'' has no contents." }, { "JAXP_COMPILE_ERR", "Could not compile stylesheet" }, { "JAXP_INVALID_ATTR_ERR", "TransformerFactory does not recognise attribute ''{0}''." }, { "JAXP_INVALID_ATTR_VALUE_ERR", "Incorrect value specified for ''{0}'' attribute." }, { "JAXP_SET_RESULT_ERR", "setResult() must be called prior to startDocument()." }, { "JAXP_NO_TRANSLET_ERR", "The Transformer has no encapsulated translet object." }, { "JAXP_NO_HANDLER_ERR", "No defined output handler for transformation result." }, { "JAXP_NO_RESULT_ERR", "Result object passed to ''{0}'' is invalid." }, { "JAXP_UNKNOWN_PROP_ERR", "Attempting to access invalid Transformer property ''{0}''." }, { "SAX2DOM_ADAPTER_ERR", "Could not create SAX2DOM adapter: ''{0}''." }, { "XSLTC_SOURCE_ERR", "XSLTCSource.build() called without systemId being set." }, { "ER_RESULT_NULL", "Result should not be null" }, { "JAXP_INVALID_SET_PARAM_VALUE", "The value of param {0} must be a valid Java Object" }, { "COMPILE_STDIN_ERR", "The -i option must be used with the -o option." }, { "COMPILE_USAGE_STR", "SYNOPSIS\n   java com.sun.org.apache.xalan.internal.xsltc.cmdline.Compile [-o <output>]\n      [-d <directory>] [-j <jarfile>] [-p <package>]\n      [-n] [-x] [-u] [-v] [-h] { <stylesheet> | -i }\n\nOPTIONS\n   -o <output>    assigns the name <output> to the generated\n                  translet.  By default the translet name is\n                  derived from the <stylesheet> name.  This option\n                  is ignored if compiling multiple stylesheets.\n   -d <directory> specifies a destination directory for translet\n   -j <jarfile>   packages translet classes into a jar file of the\n                  name specified as <jarfile>\n   -p <package>   specifies a package name prefix for all generated\n                  translet classes.\n   -n             enables template inlining (default behavior better\n                  on average).\n   -x             turns on additional debugging message output\n   -u             interprets <stylesheet> arguments as URLs\n   -i             forces compiler to read stylesheet from stdin\n   -v             prints the version of the compiler\n   -h             prints this usage statement\n" }, { "TRANSFORM_USAGE_STR", "SYNOPSIS \n   java com.sun.org.apache.xalan.internal.xsltc.cmdline.Transform [-j <jarfile>]\n      [-x] [-n <iterations>] {-u <document_url> | <document>}\n      <class> [<param1>=<value1> ...]\n\n   uses the translet <class> to transform an XML document \n   specified as <document>. The translet <class> is either in\n   the user's CLASSPATH or in the optionally specified <jarfile>.\nOPTIONS\n   -j <jarfile>    specifies a jarfile from which to load translet\n   -x              turns on additional debugging message output\n   -n <iterations> runs the transformation <iterations> times and\n                   displays profiling information\n   -u <document_url> specifies XML input document as a URL\n" }, { "STRAY_SORT_ERR", "<xsl:sort> can only be used within <xsl:for-each> or <xsl:apply-templates>." }, { "UNSUPPORTED_ENCODING", "Output encoding ''{0}'' is not supported on this JVM." }, { "SYNTAX_ERR", "Syntax error in ''{0}''." }, { "CONSTRUCTOR_NOT_FOUND", "Cannot find external constructor ''{0}''." }, { "NO_JAVA_FUNCT_THIS_REF", "The first argument to the non-static Java function ''{0}'' is not a valid object reference." }, { "TYPE_CHECK_ERR", "Error checking type of the expression ''{0}''." }, { "TYPE_CHECK_UNK_LOC_ERR", "Error checking type of an expression at an unknown location." }, { "ILLEGAL_CMDLINE_OPTION_ERR", "The command-line option ''{0}'' is not valid." }, { "CMDLINE_OPT_MISSING_ARG_ERR", "The command-line option ''{0}'' is missing a required argument." }, { "WARNING_PLUS_WRAPPED_MSG", "WARNING:  ''{0}''\n       :{1}" }, { "WARNING_MSG", "WARNING:  ''{0}''" }, { "FATAL_ERR_PLUS_WRAPPED_MSG", "FATAL ERROR:  ''{0}''\n           :{1}" }, { "FATAL_ERR_MSG", "FATAL ERROR:  ''{0}''" }, { "ERROR_PLUS_WRAPPED_MSG", "ERROR:  ''{0}''\n     :{1}" }, { "ERROR_MSG", "ERROR:  ''{0}''" }, { "TRANSFORM_WITH_TRANSLET_STR", "Transform using translet ''{0}'' " }, { "TRANSFORM_WITH_JAR_STR", "Transform using translet ''{0}'' from jar file ''{1}''" }, { "COULD_NOT_CREATE_TRANS_FACT", "Could not create an instance of the TransformerFactory class ''{0}''." }, { "TRANSLET_NAME_JAVA_CONFLICT", "The name ''{0}'' could not be used as the name of the translet class because it contains characters that are not permitted in the name of Java class.  The name ''{1}'' was used instead." }, { "COMPILER_ERROR_KEY", "Compiler errors:" }, { "COMPILER_WARNING_KEY", "Compiler warnings:" }, { "RUNTIME_ERROR_KEY", "Translet errors:" }, { "INVALID_QNAME_ERR", "An attribute whose value must be a QName or whitespace-separated list of QNames had the value ''{0}''" }, { "INVALID_NCNAME_ERR", "An attribute whose value must be an NCName had the value ''{0}''" }, { "INVALID_METHOD_IN_OUTPUT", "The method attribute of an <xsl:output> element had the value ''{0}''.  The value must be one of ''xml'', ''html'', ''text'', or qname-but-not-ncname" }, { "JAXP_GET_FEATURE_NULL_NAME", "The feature name cannot be null in TransformerFactory.getFeature(String name)." }, { "JAXP_SET_FEATURE_NULL_NAME", "The feature name cannot be null in TransformerFactory.setFeature(String name, boolean value)." }, { "JAXP_UNSUPPORTED_FEATURE", "Cannot set the feature ''{0}'' on this TransformerFactory." }, { "JAXP_SECUREPROCESSING_FEATURE", "FEATURE_SECURE_PROCESSING: Cannot set the feature to false when security manager is present." }, { "OUTLINE_ERR_TRY_CATCH", "Internal XSLTC error:  the generated byte code contains a try-catch-finally block and cannot be outlined." }, { "OUTLINE_ERR_UNBALANCED_MARKERS", "Internal XSLTC error:  OutlineableChunkStart and OutlineableChunkEnd markers must be balanced and properly nested." }, { "OUTLINE_ERR_DELETED_TARGET", "Internal XSLTC error:  an instruction that was part of a block of byte code that was outlined is still referred to in the original method." }, { "OUTLINE_ERR_METHOD_TOO_BIG", "Internal XSLTC error:  a method in the translet exceeds the Java Virtual Machine limitation on the length of a method of 64 kilobytes.  This is usually caused by templates in a stylesheet that are very large.  Try restructuring your stylesheet to use smaller templates." }, { "DESERIALIZE_TEMPLATES_ERR", "When Java security is enabled, support for deserializing TemplatesImpl is disabled.This can be overridden by setting the jdk.xml.enableTemplatesImplDeserialization system property to true." } };
/*    */   }
/*    */ }


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/com/sun/org/apache/xalan/internal/xsltc/compiler/util/ErrorMessages.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */