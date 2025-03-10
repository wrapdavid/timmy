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
/*    */ public class ErrorMessages_ko
/*    */   extends ListResourceBundle
/*    */ {
/*    */   public Object[][] getContents() {
/* 96 */     return new Object[][] { { "MULTIPLE_STYLESHEET_ERR", "동일한 파일에 스타일시트가 두 개 이상 정의되었습니다." }, { "TEMPLATE_REDEF_ERR", "이 스타일시트에는 ''{0}'' 템플리트가 이미 정의되었습니다." }, { "TEMPLATE_UNDEF_ERR", "이 스타일시트에는 ''{0}'' 템플리트가 정의되지 않았습니다." }, { "VARIABLE_REDEF_ERR", "동일한 범위에서 ''{0}'' 변수가 여러 개 정의되었습니다." }, { "VARIABLE_UNDEF_ERR", "변수 또는 매개변수 ''{0}''이(가) 정의되지 않았습니다." }, { "CLASS_NOT_FOUND_ERR", "''{0}'' 클래스를 찾을 수 없습니다." }, { "METHOD_NOT_FOUND_ERR", "외부 메소드 ''{0}''을(를) 찾을 수 없습니다. 이 메소드는 public이어야 합니다." }, { "ARGUMENT_CONVERSION_ERR", "''{0}'' 메소드에 대한 호출에서 인수/반환 유형을 변환할 수 없습니다." }, { "FILE_NOT_FOUND_ERR", "파일 또는 URI ''{0}''을(를) 찾을 수 없습니다." }, { "INVALID_URI_ERR", "URI ''{0}''이(가) 부적합합니다." }, { "FILE_ACCESS_ERR", "파일 또는 URI ''{0}''을(를) 열 수 없습니다." }, { "MISSING_ROOT_ERR", "<xsl:stylesheet> 또는 <xsl:transform> 요소가 필요합니다." }, { "NAMESPACE_UNDEF_ERR", "네임스페이스 접두어 ''{0}''이(가) 선언되지 않았습니다." }, { "FUNCTION_RESOLVE_ERR", "''{0}'' 함수에 대한 호출을 분석할 수 없습니다." }, { "NEED_LITERAL_ERR", "''{0}''에 대한 인수는 리터럴 문자열이어야 합니다." }, { "XPATH_PARSER_ERR", "XPath 표현식 ''{0}''의 구문을 분석하는 중 오류가 발생했습니다." }, { "REQUIRED_ATTR_ERR", "필수 속성 ''{0}''이(가) 누락되었습니다." }, { "ILLEGAL_CHAR_ERR", "XPath 표현식에 잘못된 문자 ''{0}''이(가) 있습니다." }, { "ILLEGAL_PI_ERR", "''{0}''은(는) 명령 처리에 잘못된 이름입니다." }, { "STRAY_ATTRIBUTE_ERR", "''{0}'' 속성이 요소에 포함되어 있지 않습니다." }, { "ILLEGAL_ATTRIBUTE_ERR", "''{0}''은(는) 잘못된 속성입니다." }, { "CIRCULAR_INCLUDE_ERR", "순환 import/include입니다. ''{0}'' 스타일시트가 이미 로드되었습니다." }, { "RESULT_TREE_SORT_ERR", "Result-tree 부분을 정렬할 수 없습니다(<xsl:sort> 요소가 무시됨). 결과 트리를 생성할 때는 노드를 정렬해야 합니다." }, { "SYMBOLS_REDEF_ERR", "십진수 형식 ''{0}''이(가) 이미 정의되었습니다." }, { "XSL_VERSION_ERR", "XSLTC는 XSL 버전 ''{0}''을(를) 지원하지 않습니다." }, { "CIRCULAR_VARIABLE_ERR", "''{0}''에 순환 변수/매개변수 참조가 있습니다." }, { "ILLEGAL_BINARY_OP_ERR", "바이너리 표현식에 대해 알 수 없는 연산자입니다." }, { "ILLEGAL_ARG_ERR", "함수 호출에 대한 인수가 잘못되었습니다." }, { "DOCUMENT_ARG_ERR", "document() 함수에 대한 두번째 인수는 node-set여야 합니다." }, { "MISSING_WHEN_ERR", "<xsl:choose>에는 <xsl:when> 요소가 하나 이상 필요합니다." }, { "MULTIPLE_OTHERWISE_ERR", "<xsl:choose>에서는 <xsl:otherwise> 요소가 하나만 허용됩니다." }, { "STRAY_OTHERWISE_ERR", "<xsl:otherwise>는 <xsl:choose>에서만 사용할 수 있습니다." }, { "STRAY_WHEN_ERR", "<xsl:when>은 <xsl:choose>에서만 사용할 수 있습니다." }, { "WHEN_ELEMENT_ERR", "<xsl:choose>에서는 <xsl:when> 및 <xsl:otherwise> 요소만 허용됩니다." }, { "UNNAMED_ATTRIBSET_ERR", "<xsl:attribute-set>에 'name' 속성이 누락되었습니다." }, { "ILLEGAL_CHILD_ERR", "하위 요소가 잘못되었습니다." }, { "ILLEGAL_ELEM_NAME_ERR", "''{0}'' 요소를 호출할 수 없습니다." }, { "ILLEGAL_ATTR_NAME_ERR", "''{0}'' 속성을 호출할 수 없습니다." }, { "ILLEGAL_TEXT_NODE_ERR", "텍스트 데이터가 최상위 레벨 <xsl:stylesheet> 요소에 포함되어 있지 않습니다." }, { "SAX_PARSER_CONFIG_ERR", "JAXP 구문 분석기가 제대로 구성되지 않았습니다." }, { "INTERNAL_ERR", "복구할 수 없는 XSLTC 내부 오류: ''{0}''" }, { "UNSUPPORTED_XSL_ERR", "''{0}''은(는) 지원되지 않는 XSL 요소입니다." }, { "UNSUPPORTED_EXT_ERR", "''{0}''은(는) 알 수 없는 XSLTC 확장입니다." }, { "MISSING_XSLT_URI_ERR", "입력 문서는 스타일시트가 아닙니다. XSL 네임스페이스가 루트 요소에 선언되지 않았습니다." }, { "MISSING_XSLT_TARGET_ERR", "스타일시트 대상 ''{0}''을(를) 찾을 수 없습니다." }, { "ACCESSING_XSLT_TARGET_ERR", "accessExternalStylesheet 속성으로 설정된 제한으로 인해 ''{1}'' 액세스가 허용되지 않으므로 스타일시트 대상 ''{0}''을(를) 읽을 수 없습니다." }, { "NOT_IMPLEMENTED_ERR", "구현되지 않음: ''{0}''." }, { "NOT_STYLESHEET_ERR", "입력 문서에 XSL 스타일시트가 포함되어 있지 않습니다." }, { "ELEMENT_PARSE_ERR", "''{0}'' 요소의 구문을 분석할 수 없습니다." }, { "KEY_USE_ATTR_ERR", "<key>의 use 속성은 node, node-set, string 또는 number여야 합니다." }, { "OUTPUT_VERSION_ERR", "출력 XML 문서 버전은 1.0이어야 합니다." }, { "ILLEGAL_RELAT_OP_ERR", "관계 표현식에 대해 알 수 없는 연산자입니다." }, { "ATTRIBSET_UNDEF_ERR", "존재하지 않는 속성 집합 ''{0}''을(를) 사용하려고 시도하는 중입니다." }, { "ATTR_VAL_TEMPLATE_ERR", "속성값 템플리트 ''{0}''의 구문을 분석할 수 없습니다." }, { "UNKNOWN_SIG_TYPE_ERR", "''{0}'' 클래스에 대한 서명에 알 수 없는 데이터 유형이 있습니다." }, { "DATA_CONVERSION_ERR", "데이터 유형 ''{0}''을(를) ''{1}''(으)로 변환할 수 없습니다." }, { "NO_TRANSLET_CLASS_ERR", "이 Templates에는 적합한 translet 클래스 정의가 포함되어 있지 않습니다." }, { "NO_MAIN_TRANSLET_ERR", "이 Templates에는 이름이 ''{0}''인 클래스가 포함되어 있지 않습니다." }, { "TRANSLET_CLASS_ERR", "Translet 클래스 ''{0}''을(를) 로드할 수 없습니다." }, { "TRANSLET_OBJECT_ERR", "Translet 클래스가 로드되었지만 translet 인스턴스를 생성할 수 없습니다." }, { "ERROR_LISTENER_NULL_ERR", "''{0}''에 대한 ErrorListener를 null로 설정하려고 시도하는 중" }, { "JAXP_UNKNOWN_SOURCE_ERR", "XSLTC는 StreamSource, SAXSource 및 DOMSource만 지원합니다." }, { "JAXP_NO_SOURCE_ERR", "''{0}''(으)로 전달된 Source 객체에 콘텐츠가 없습니다." }, { "JAXP_COMPILE_ERR", "스타일시트를 컴파일할 수 없습니다." }, { "JAXP_INVALID_ATTR_ERR", "TransformerFactory에서 ''{0}'' 속성을 인식하지 못했습니다." }, { "JAXP_INVALID_ATTR_VALUE_ERR", "''{0}'' 속성에 대해 올바르지 않은 값이 지정되었습니다." }, { "JAXP_SET_RESULT_ERR", "setResult()는 startDocument() 앞에 호출되어야 합니다." }, { "JAXP_NO_TRANSLET_ERR", "Transformer에 캡슐화된 translet 객체가 없습니다." }, { "JAXP_NO_HANDLER_ERR", "변환 결과에 대해 정의된 출력 처리기가 없습니다." }, { "JAXP_NO_RESULT_ERR", "''{0}''(으)로 전달된 Result 객체가 부적합합니다." }, { "JAXP_UNKNOWN_PROP_ERR", "부적합한 Transformer 속성 ''{0}''에 액세스하려고 시도하는 중입니다." }, { "SAX2DOM_ADAPTER_ERR", "SAX2DOM 어댑터를 생성할 수 없음: ''{0}''." }, { "XSLTC_SOURCE_ERR", "systemId를 설정하지 않은 상태로 XSLTCSource.build()가 호출되었습니다." }, { "ER_RESULT_NULL", "결과는 널이 아니어야 합니다." }, { "JAXP_INVALID_SET_PARAM_VALUE", "{0} 매개변수의 값은 적합한 Java 객체여야 합니다." }, { "COMPILE_STDIN_ERR", "-i 옵션은 -o 옵션과 함께 사용해야 합니다." }, { "COMPILE_USAGE_STR", "사용법\n   java com.sun.org.apache.xalan.internal.xsltc.cmdline.Compile [-o <output>]\n      [-d <directory>] [-j <jarfile>] [-p <package>]\n      [-n] [-x] [-u] [-v] [-h] { <stylesheet> | -i }\n\n옵션\n   -o <output>    생성된 translet에 <output> 이름을\n                  지정합니다. 기본적으로 translet 이름은\n                  <stylesheet> 이름에서 파생됩니다. 여러 스타일시트를\n                  컴파일하는 경우 이 옵션은 무시됩니다.\n   -d <directory> translet에 대한 대상 디렉토리를 지정합니다.\n   -j <jarfile>   translet 클래스를 <jarfile>이라는 이름이 지정된 jar 파일에\n                  패키지화합니다.\n   -p <package>   생성된 모든 translet 클래스에 대해 패키지 이름 접두어를\n                  지정합니다.\n   -n             템플리트 인라인을 사용으로 설정합니다. 일반적으로 기본 동작을\n                  사용하는 것이 좋습니다.\n   -x             추가 디버깅 메시지 출력을 설정합니다.\n   -u             <stylesheet> 인수를 URL로 해석합니다.\n   -i             컴파일러가 stdin에서 스타일시트를 강제로 읽도록 합니다.\n   -v             컴파일러의 버전을 인쇄합니다.\n   -h             이 사용법 지침을 인쇄합니다.\n" }, { "TRANSFORM_USAGE_STR", "사용법 \n   java com.sun.org.apache.xalan.internal.xsltc.cmdline.Transform [-j <jarfile>]\n      [-x] [-n <iterations>] {-u <document_url> | <document>}\n      <class> [<param1>=<value1> ...]\n\n   translet <class>를 사용하여 <document>로 지정된 XML 문서를 \n   변환합니다. translet <class>는 \n   사용자의 CLASSPATH 또는 선택적으로 지정된 <jarfile>에 있습니다.\n옵션\n   -j <jarfile>    translet을 로드해 올 jarfile을 지정합니다.\n   -x              추가 디버깅 메시지 출력을 설정합니다.\n   -n <iterations> 변환을 <iterations>회 실행하고\n                   프로파일 작성 정보를 표시합니다.\n   -u <document_url> XML 입력 문서를 URL로 지정합니다.\n" }, { "STRAY_SORT_ERR", "<xsl:sort>는 <xsl:for-each> 또는 <xsl:apply-templates>에서만 사용할 수 있습니다." }, { "UNSUPPORTED_ENCODING", "이 JVM에서는 출력 인코딩 ''{0}''이(가) 지원되지 않습니다." }, { "SYNTAX_ERR", "''{0}''에 구문 오류가 있습니다." }, { "CONSTRUCTOR_NOT_FOUND", "외부 constructor ''{0}''을(를) 찾을 수 없습니다." }, { "NO_JAVA_FUNCT_THIS_REF", "비static Java 함수 ''{0}''에 대한 첫번째 인수는 적합한 객체 참조가 아닙니다." }, { "TYPE_CHECK_ERR", "''{0}'' 표현식의 유형을 확인하는 중 오류가 발생했습니다." }, { "TYPE_CHECK_UNK_LOC_ERR", "알 수 없는 위치에서 표현식의 유형을 확인하는 중 오류가 발생했습니다." }, { "ILLEGAL_CMDLINE_OPTION_ERR", "명령행 옵션 ''{0}''이(가) 부적합합니다." }, { "CMDLINE_OPT_MISSING_ARG_ERR", "명령행 옵션 ''{0}''에 필수 인수가 누락되었습니다." }, { "WARNING_PLUS_WRAPPED_MSG", "WARNING:  ''{0}''\n       :{1}" }, { "WARNING_MSG", "WARNING:  ''{0}''" }, { "FATAL_ERR_PLUS_WRAPPED_MSG", "FATAL ERROR:  ''{0}''\n           :{1}" }, { "FATAL_ERR_MSG", "FATAL ERROR:  ''{0}''" }, { "ERROR_PLUS_WRAPPED_MSG", "ERROR:  ''{0}''\n     :{1}" }, { "ERROR_MSG", "ERROR:  ''{0}''" }, { "TRANSFORM_WITH_TRANSLET_STR", "translet ''{0}''을(를) 사용하여 변환하십시오. " }, { "TRANSFORM_WITH_JAR_STR", "jar 파일 ''{1}''의 translet ''{0}''을(를) 사용하여 변환하십시오." }, { "COULD_NOT_CREATE_TRANS_FACT", "TransformerFactory 클래스 ''{0}''의 인스턴스를 생성할 수 없습니다." }, { "TRANSLET_NAME_JAVA_CONFLICT", "''{0}'' 이름에는 Java 클래스 이름에 허용되지 않는 문자가 포함되어 있어 이 이름을 translet 클래스의 이름으로 사용할 수 없습니다. 대신 ''{1}'' 이름이 사용되었습니다." }, { "COMPILER_ERROR_KEY", "컴파일러 오류:" }, { "COMPILER_WARNING_KEY", "컴파일러 경고:" }, { "RUNTIME_ERROR_KEY", "Translet 오류:" }, { "INVALID_QNAME_ERR", "값이 QName 또는 공백으로 구분된 QName 목록이어야 하는 속성의 값이 ''{0}''입니다." }, { "INVALID_NCNAME_ERR", "값이 NCName이어야 하는 속성의 값이 ''{0}''입니다." }, { "INVALID_METHOD_IN_OUTPUT", "<xsl:output> 요소에 대한 method 속성의 값이 ''{0}''입니다. 값은 ''xml'', ''html'', ''text'' 또는 qname-but-not-ncname 중 하나여야 합니다." }, { "JAXP_GET_FEATURE_NULL_NAME", "기능 이름은 TransformerFactory.getFeature(문자열 이름)에서 널일 수 없습니다." }, { "JAXP_SET_FEATURE_NULL_NAME", "기능 이름은 TransformerFactory.setFeature(문자열 이름, 부울 값)에서 널일 수 없습니다." }, { "JAXP_UNSUPPORTED_FEATURE", "이 TransformerFactory에서 ''{0}'' 기능을 설정할 수 없습니다." }, { "JAXP_SECUREPROCESSING_FEATURE", "FEATURE_SECURE_PROCESSING: 보안 관리자가 있을 경우 기능을 false로 설정할 수 없습니다." }, { "OUTLINE_ERR_TRY_CATCH", "내부 XSLTC 오류: 생성된 바이트 코드가 try-catch-finally 블록을 포함하므로 outlined 처리할 수 없습니다." }, { "OUTLINE_ERR_UNBALANCED_MARKERS", "내부 XSLTC 오류: OutlineableChunkStart 및 OutlineableChunkEnd 표시자의 짝이 맞아야 하고 올바르게 중첩되어야 합니다." }, { "OUTLINE_ERR_DELETED_TARGET", "내부 XSLTC 오류: outlined 처리된 바이트 코드 블록에 속한 명령이 여전히 원래 메소드에서 참조됩니다." }, { "OUTLINE_ERR_METHOD_TOO_BIG", "내부 XSLTC 오류: translet의 메소드가 Java Virtual Machine의 메소드 길이 제한인 64KB를 초과합니다. 대개 스타일시트의 템플리트가 매우 크기 때문에 발생합니다. 더 작은 템플리트를 사용하도록 스타일시트를 재구성해 보십시오." }, { "DESERIALIZE_TEMPLATES_ERR", "Java 보안이 사용으로 설정된 경우 TemplatesImpl 직렬화 해제에 대한 지원이 사용 안함으로 설정됩니다. jdk.xml.enableTemplatesImplDeserialization 시스템 속성을 true로 설정하면 이를 무효화할 수 있습니다." } };
/*    */   }
/*    */ }


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/com/sun/org/apache/xalan/internal/xsltc/compiler/util/ErrorMessages_ko.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */