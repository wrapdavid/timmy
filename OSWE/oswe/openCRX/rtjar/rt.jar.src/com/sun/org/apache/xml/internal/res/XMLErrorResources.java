/*     */ package com.sun.org.apache.xml.internal.res;
/*     */ 
/*     */ import java.util.ListResourceBundle;
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
/*     */ public class XMLErrorResources
/*     */   extends ListResourceBundle
/*     */ {
/*     */   public static final int MAX_CODE = 61;
/*     */   public static final int MAX_WARNING = 0;
/*     */   public static final int MAX_OTHERS = 4;
/*     */   public static final int MAX_MESSAGES = 62;
/*     */   public static final String ER_FUNCTION_NOT_SUPPORTED = "ER_FUNCTION_NOT_SUPPORTED";
/*     */   public static final String ER_CANNOT_OVERWRITE_CAUSE = "ER_CANNOT_OVERWRITE_CAUSE";
/*     */   public static final String ER_NO_DEFAULT_IMPL = "ER_NO_DEFAULT_IMPL";
/*     */   public static final String ER_CHUNKEDINTARRAY_NOT_SUPPORTED = "ER_CHUNKEDINTARRAY_NOT_SUPPORTED";
/*     */   public static final String ER_OFFSET_BIGGER_THAN_SLOT = "ER_OFFSET_BIGGER_THAN_SLOT";
/*     */   public static final String ER_COROUTINE_NOT_AVAIL = "ER_COROUTINE_NOT_AVAIL";
/*     */   public static final String ER_COROUTINE_CO_EXIT = "ER_COROUTINE_CO_EXIT";
/*     */   public static final String ER_COJOINROUTINESET_FAILED = "ER_COJOINROUTINESET_FAILED";
/*     */   public static final String ER_COROUTINE_PARAM = "ER_COROUTINE_PARAM";
/*     */   public static final String ER_PARSER_DOTERMINATE_ANSWERS = "ER_PARSER_DOTERMINATE_ANSWERS";
/*     */   public static final String ER_NO_PARSE_CALL_WHILE_PARSING = "ER_NO_PARSE_CALL_WHILE_PARSING";
/*     */   public static final String ER_TYPED_ITERATOR_AXIS_NOT_IMPLEMENTED = "ER_TYPED_ITERATOR_AXIS_NOT_IMPLEMENTED";
/*     */   public static final String ER_ITERATOR_AXIS_NOT_IMPLEMENTED = "ER_ITERATOR_AXIS_NOT_IMPLEMENTED";
/*     */   public static final String ER_ITERATOR_CLONE_NOT_SUPPORTED = "ER_ITERATOR_CLONE_NOT_SUPPORTED";
/*     */   public static final String ER_UNKNOWN_AXIS_TYPE = "ER_UNKNOWN_AXIS_TYPE";
/*     */   public static final String ER_AXIS_NOT_SUPPORTED = "ER_AXIS_NOT_SUPPORTED";
/*     */   public static final String ER_NO_DTMIDS_AVAIL = "ER_NO_DTMIDS_AVAIL";
/*     */   public static final String ER_NOT_SUPPORTED = "ER_NOT_SUPPORTED";
/*     */   public static final String ER_NODE_NON_NULL = "ER_NODE_NON_NULL";
/*     */   public static final String ER_COULD_NOT_RESOLVE_NODE = "ER_COULD_NOT_RESOLVE_NODE";
/*     */   public static final String ER_STARTPARSE_WHILE_PARSING = "ER_STARTPARSE_WHILE_PARSING";
/*     */   public static final String ER_STARTPARSE_NEEDS_SAXPARSER = "ER_STARTPARSE_NEEDS_SAXPARSER";
/*     */   public static final String ER_COULD_NOT_INIT_PARSER = "ER_COULD_NOT_INIT_PARSER";
/*     */   public static final String ER_EXCEPTION_CREATING_POOL = "ER_EXCEPTION_CREATING_POOL";
/*     */   public static final String ER_PATH_CONTAINS_INVALID_ESCAPE_SEQUENCE = "ER_PATH_CONTAINS_INVALID_ESCAPE_SEQUENCE";
/*     */   public static final String ER_SCHEME_REQUIRED = "ER_SCHEME_REQUIRED";
/*     */   public static final String ER_NO_SCHEME_IN_URI = "ER_NO_SCHEME_IN_URI";
/*     */   public static final String ER_NO_SCHEME_INURI = "ER_NO_SCHEME_INURI";
/*     */   public static final String ER_PATH_INVALID_CHAR = "ER_PATH_INVALID_CHAR";
/*     */   public static final String ER_SCHEME_FROM_NULL_STRING = "ER_SCHEME_FROM_NULL_STRING";
/*     */   public static final String ER_SCHEME_NOT_CONFORMANT = "ER_SCHEME_NOT_CONFORMANT";
/*     */   public static final String ER_HOST_ADDRESS_NOT_WELLFORMED = "ER_HOST_ADDRESS_NOT_WELLFORMED";
/*     */   public static final String ER_PORT_WHEN_HOST_NULL = "ER_PORT_WHEN_HOST_NULL";
/*     */   public static final String ER_INVALID_PORT = "ER_INVALID_PORT";
/*     */   public static final String ER_FRAG_FOR_GENERIC_URI = "ER_FRAG_FOR_GENERIC_URI";
/*     */   public static final String ER_FRAG_WHEN_PATH_NULL = "ER_FRAG_WHEN_PATH_NULL";
/*     */   public static final String ER_FRAG_INVALID_CHAR = "ER_FRAG_INVALID_CHAR";
/*     */   public static final String ER_PARSER_IN_USE = "ER_PARSER_IN_USE";
/*     */   public static final String ER_CANNOT_CHANGE_WHILE_PARSING = "ER_CANNOT_CHANGE_WHILE_PARSING";
/*     */   public static final String ER_SELF_CAUSATION_NOT_PERMITTED = "ER_SELF_CAUSATION_NOT_PERMITTED";
/*     */   public static final String ER_NO_USERINFO_IF_NO_HOST = "ER_NO_USERINFO_IF_NO_HOST";
/*     */   public static final String ER_NO_PORT_IF_NO_HOST = "ER_NO_PORT_IF_NO_HOST";
/*     */   public static final String ER_NO_QUERY_STRING_IN_PATH = "ER_NO_QUERY_STRING_IN_PATH";
/*     */   public static final String ER_NO_FRAGMENT_STRING_IN_PATH = "ER_NO_FRAGMENT_STRING_IN_PATH";
/*     */   public static final String ER_CANNOT_INIT_URI_EMPTY_PARMS = "ER_CANNOT_INIT_URI_EMPTY_PARMS";
/*     */   public static final String ER_METHOD_NOT_SUPPORTED = "ER_METHOD_NOT_SUPPORTED";
/*     */   public static final String ER_INCRSAXSRCFILTER_NOT_RESTARTABLE = "ER_INCRSAXSRCFILTER_NOT_RESTARTABLE";
/*     */   public static final String ER_XMLRDR_NOT_BEFORE_STARTPARSE = "ER_XMLRDR_NOT_BEFORE_STARTPARSE";
/*     */   public static final String ER_AXIS_TRAVERSER_NOT_SUPPORTED = "ER_AXIS_TRAVERSER_NOT_SUPPORTED";
/*     */   public static final String ER_ERRORHANDLER_CREATED_WITH_NULL_PRINTWRITER = "ER_ERRORHANDLER_CREATED_WITH_NULL_PRINTWRITER";
/*     */   public static final String ER_SYSTEMID_UNKNOWN = "ER_SYSTEMID_UNKNOWN";
/*     */   public static final String ER_LOCATION_UNKNOWN = "ER_LOCATION_UNKNOWN";
/*     */   public static final String ER_PREFIX_MUST_RESOLVE = "ER_PREFIX_MUST_RESOLVE";
/*     */   public static final String ER_CREATEDOCUMENT_NOT_SUPPORTED = "ER_CREATEDOCUMENT_NOT_SUPPORTED";
/*     */   public static final String ER_CHILD_HAS_NO_OWNER_DOCUMENT = "ER_CHILD_HAS_NO_OWNER_DOCUMENT";
/*     */   public static final String ER_CHILD_HAS_NO_OWNER_DOCUMENT_ELEMENT = "ER_CHILD_HAS_NO_OWNER_DOCUMENT_ELEMENT";
/*     */   public static final String ER_CANT_OUTPUT_TEXT_BEFORE_DOC = "ER_CANT_OUTPUT_TEXT_BEFORE_DOC";
/*     */   public static final String ER_CANT_HAVE_MORE_THAN_ONE_ROOT = "ER_CANT_HAVE_MORE_THAN_ONE_ROOT";
/*     */   public static final String ER_ARG_LOCALNAME_NULL = "ER_ARG_LOCALNAME_NULL";
/*     */   public static final String ER_ARG_LOCALNAME_INVALID = "ER_ARG_LOCALNAME_INVALID";
/*     */   public static final String ER_ARG_PREFIX_INVALID = "ER_ARG_PREFIX_INVALID";
/*     */   public static final String ER_NAME_CANT_START_WITH_COLON = "ER_NAME_CANT_START_WITH_COLON";
/*     */   public static final String ER_RESOURCE_COULD_NOT_FIND = "ER_RESOURCE_COULD_NOT_FIND";
/*     */   public static final String ER_RESOURCE_COULD_NOT_LOAD = "ER_RESOURCE_COULD_NOT_LOAD";
/*     */   public static final String ER_BUFFER_SIZE_LESSTHAN_ZERO = "ER_BUFFER_SIZE_LESSTHAN_ZERO";
/*     */   public static final String ER_INVALID_UTF16_SURROGATE = "ER_INVALID_UTF16_SURROGATE";
/*     */   public static final String ER_OIERROR = "ER_OIERROR";
/*     */   public static final String ER_NAMESPACE_PREFIX = "ER_NAMESPACE_PREFIX";
/*     */   public static final String ER_STRAY_ATTRIBUTE = "ER_STRAY_ATTIRBUTE";
/*     */   public static final String ER_STRAY_NAMESPACE = "ER_STRAY_NAMESPACE";
/*     */   public static final String ER_COULD_NOT_LOAD_RESOURCE = "ER_COULD_NOT_LOAD_RESOURCE";
/*     */   public static final String ER_COULD_NOT_LOAD_METHOD_PROPERTY = "ER_COULD_NOT_LOAD_METHOD_PROPERTY";
/*     */   public static final String ER_SERIALIZER_NOT_CONTENTHANDLER = "ER_SERIALIZER_NOT_CONTENTHANDLER";
/*     */   public static final String ER_ILLEGAL_ATTRIBUTE_POSITION = "ER_ILLEGAL_ATTRIBUTE_POSITION";
/*     */   public static final String ER_ILLEGAL_CHARACTER = "ER_ILLEGAL_CHARACTER";
/* 179 */   private static final Object[][] contents = new Object[][] { { "ER0000", "{0}" }, { "ER_FUNCTION_NOT_SUPPORTED", "Function not supported!" }, { "ER_CANNOT_OVERWRITE_CAUSE", "Cannot overwrite cause" }, { "ER_NO_DEFAULT_IMPL", "No default implementation found " }, { "ER_CHUNKEDINTARRAY_NOT_SUPPORTED", "ChunkedIntArray({0}) not currently supported" }, { "ER_OFFSET_BIGGER_THAN_SLOT", "Offset bigger than slot" }, { "ER_COROUTINE_NOT_AVAIL", "Coroutine not available, id={0}" }, { "ER_COROUTINE_CO_EXIT", "CoroutineManager received co_exit() request" }, { "ER_COJOINROUTINESET_FAILED", "co_joinCoroutineSet() failed" }, { "ER_COROUTINE_PARAM", "Coroutine parameter error ({0})" }, { "ER_PARSER_DOTERMINATE_ANSWERS", "\nUNEXPECTED: Parser doTerminate answers {0}" }, { "ER_NO_PARSE_CALL_WHILE_PARSING", "parse may not be called while parsing" }, { "ER_TYPED_ITERATOR_AXIS_NOT_IMPLEMENTED", "Error: typed iterator for axis  {0} not implemented" }, { "ER_ITERATOR_AXIS_NOT_IMPLEMENTED", "Error: iterator for axis {0} not implemented " }, { "ER_ITERATOR_CLONE_NOT_SUPPORTED", "Iterator clone not supported" }, { "ER_UNKNOWN_AXIS_TYPE", "Unknown axis traversal type: {0}" }, { "ER_AXIS_NOT_SUPPORTED", "Axis traverser not supported: {0}" }, { "ER_NO_DTMIDS_AVAIL", "No more DTM IDs are available" }, { "ER_NOT_SUPPORTED", "Not supported: {0}" }, { "ER_NODE_NON_NULL", "Node must be non-null for getDTMHandleFromNode" }, { "ER_COULD_NOT_RESOLVE_NODE", "Could not resolve the node to a handle" }, { "ER_STARTPARSE_WHILE_PARSING", "startParse may not be called while parsing" }, { "ER_STARTPARSE_NEEDS_SAXPARSER", "startParse needs a non-null SAXParser" }, { "ER_COULD_NOT_INIT_PARSER", "could not initialize parser with" }, { "ER_EXCEPTION_CREATING_POOL", "exception creating new instance for pool" }, { "ER_PATH_CONTAINS_INVALID_ESCAPE_SEQUENCE", "Path contains invalid escape sequence" }, { "ER_SCHEME_REQUIRED", "Scheme is required!" }, { "ER_NO_SCHEME_IN_URI", "No scheme found in URI: {0}" }, { "ER_NO_SCHEME_INURI", "No scheme found in URI" }, { "ER_PATH_INVALID_CHAR", "Path contains invalid character: {0}" }, { "ER_SCHEME_FROM_NULL_STRING", "Cannot set scheme from null string" }, { "ER_SCHEME_NOT_CONFORMANT", "The scheme is not conformant." }, { "ER_HOST_ADDRESS_NOT_WELLFORMED", "Host is not a well formed address" }, { "ER_PORT_WHEN_HOST_NULL", "Port cannot be set when host is null" }, { "ER_INVALID_PORT", "Invalid port number" }, { "ER_FRAG_FOR_GENERIC_URI", "Fragment can only be set for a generic URI" }, { "ER_FRAG_WHEN_PATH_NULL", "Fragment cannot be set when path is null" }, { "ER_FRAG_INVALID_CHAR", "Fragment contains invalid character" }, { "ER_PARSER_IN_USE", "Parser is already in use" }, { "ER_CANNOT_CHANGE_WHILE_PARSING", "Cannot change {0} {1} while parsing" }, { "ER_SELF_CAUSATION_NOT_PERMITTED", "Self-causation not permitted" }, { "ER_NO_USERINFO_IF_NO_HOST", "Userinfo may not be specified if host is not specified" }, { "ER_NO_PORT_IF_NO_HOST", "Port may not be specified if host is not specified" }, { "ER_NO_QUERY_STRING_IN_PATH", "Query string cannot be specified in path and query string" }, { "ER_NO_FRAGMENT_STRING_IN_PATH", "Fragment cannot be specified in both the path and fragment" }, { "ER_CANNOT_INIT_URI_EMPTY_PARMS", "Cannot initialize URI with empty parameters" }, { "ER_METHOD_NOT_SUPPORTED", "Method not yet supported " }, { "ER_INCRSAXSRCFILTER_NOT_RESTARTABLE", "IncrementalSAXSource_Filter not currently restartable" }, { "ER_XMLRDR_NOT_BEFORE_STARTPARSE", "XMLReader not before startParse request" }, { "ER_AXIS_TRAVERSER_NOT_SUPPORTED", "Axis traverser not supported: {0}" }, { "ER_ERRORHANDLER_CREATED_WITH_NULL_PRINTWRITER", "ListingErrorHandler created with null PrintWriter!" }, { "ER_SYSTEMID_UNKNOWN", "SystemId Unknown" }, { "ER_LOCATION_UNKNOWN", "Location of error unknown" }, { "ER_PREFIX_MUST_RESOLVE", "Prefix must resolve to a namespace: {0}" }, { "ER_CREATEDOCUMENT_NOT_SUPPORTED", "createDocument() not supported in XPathContext!" }, { "ER_CHILD_HAS_NO_OWNER_DOCUMENT", "Attribute child does not have an owner document!" }, { "ER_CHILD_HAS_NO_OWNER_DOCUMENT_ELEMENT", "Attribute child does not have an owner document element!" }, { "ER_CANT_OUTPUT_TEXT_BEFORE_DOC", "Warning: can't output text before document element!  Ignoring..." }, { "ER_CANT_HAVE_MORE_THAN_ONE_ROOT", "Can't have more than one root on a DOM!" }, { "ER_ARG_LOCALNAME_NULL", "Argument 'localName' is null" }, { "ER_ARG_LOCALNAME_INVALID", "Localname in QNAME should be a valid NCName" }, { "ER_ARG_PREFIX_INVALID", "Prefix in QNAME should be a valid NCName" }, { "ER_NAME_CANT_START_WITH_COLON", "Name cannot start with a colon" }, { "BAD_CODE", "Parameter to createMessage was out of bounds" }, { "FORMAT_FAILED", "Exception thrown during messageFormat call" }, { "line", "Line #" }, { "column", "Column #" }, { "ER_SERIALIZER_NOT_CONTENTHANDLER", "The serializer class ''{0}'' does not implement org.xml.sax.ContentHandler." }, { "ER_RESOURCE_COULD_NOT_FIND", "The resource [ {0} ] could not be found.\n {1}" }, { "ER_RESOURCE_COULD_NOT_LOAD", "The resource [ {0} ] could not load: {1} \n {2} \t {3}" }, { "ER_BUFFER_SIZE_LESSTHAN_ZERO", "Buffer size <=0" }, { "ER_INVALID_UTF16_SURROGATE", "Invalid UTF-16 surrogate detected: {0} ?" }, { "ER_OIERROR", "IO error" }, { "ER_ILLEGAL_ATTRIBUTE_POSITION", "Cannot add attribute {0} after child nodes or before an element is produced.  Attribute will be ignored." }, { "ER_NAMESPACE_PREFIX", "Namespace for prefix ''{0}'' has not been declared." }, { "ER_STRAY_ATTIRBUTE", "Attribute ''{0}'' outside of element." }, { "ER_STRAY_NAMESPACE", "Namespace declaration ''{0}''=''{1}'' outside of element." }, { "ER_COULD_NOT_LOAD_RESOURCE", "Could not load ''{0}'' (check CLASSPATH), now using just the defaults" }, { "ER_ILLEGAL_CHARACTER", "Attempt to output character of integral value {0} that is not represented in specified output encoding of {1}." }, { "ER_COULD_NOT_LOAD_METHOD_PROPERTY", "Could not load the propery file ''{0}'' for output method ''{1}'' (check CLASSPATH)" } };
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
/*     */   protected Object[][] getContents() {
/* 447 */     return contents;
/*     */   }
/*     */ }


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/com/sun/org/apache/xml/internal/res/XMLErrorResources.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */