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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ErrorMessages_sk
/*    */   extends ListResourceBundle
/*    */ {
/*    */   public Object[][] getContents() {
/* 99 */     return new Object[][] { { "MULTIPLE_STYLESHEET_ERR", "Viac než jeden štýl dokumentu bol definovaný v rovnakom súbore." }, { "TEMPLATE_REDEF_ERR", "Vzor ''{0}'' je už v tomto štýle dokumentu definovaný." }, { "TEMPLATE_UNDEF_ERR", "Vzor ''{0}'' nie je v tomto štýle dokumentu definovaný." }, { "VARIABLE_REDEF_ERR", "Premenná ''{0}'' je viackrát definovaná v tom istom rozsahu." }, { "VARIABLE_UNDEF_ERR", "Premenná alebo parameter ''{0}'' nie je definovaná." }, { "CLASS_NOT_FOUND_ERR", "Nie je možné nájsť triedu ''{0}''." }, { "METHOD_NOT_FOUND_ERR", "Nie je možné nájsť externú metódu ''{0}'' (musí byť verejná)." }, { "ARGUMENT_CONVERSION_ERR", "Nie je možné konvertovať typ argumentu/návratu vo volaní metódy ''{0}''" }, { "FILE_NOT_FOUND_ERR", "Súbor alebo URI ''{0}'' sa nenašli." }, { "INVALID_URI_ERR", "Neplatný URI ''{0}''." }, { "FILE_ACCESS_ERR", "Nie je možné otvoriť súbor alebo URI ''{0}''." }, { "MISSING_ROOT_ERR", "Očakáva sa element <xsl:stylesheet> alebo <xsl:transform>." }, { "NAMESPACE_UNDEF_ERR", "Predpona názvového priestoru ''{0}'' nie je deklarovaná." }, { "FUNCTION_RESOLVE_ERR", "Nie je možné rozlíšiť volanie funkcie ''{0}''." }, { "NEED_LITERAL_ERR", "Argument pre ''{0}'' musí byť reťazcom literálu." }, { "XPATH_PARSER_ERR", "Chyba pri analýze výrazu XPath ''{0}''." }, { "REQUIRED_ATTR_ERR", "Chýba požadovaný atribút ''{0}''." }, { "ILLEGAL_CHAR_ERR", "Neplatný znak ''{0}'' vo výraze XPath." }, { "ILLEGAL_PI_ERR", "Neplatný názov ''{0}'' pre inštrukciu spracovania." }, { "STRAY_ATTRIBUTE_ERR", "Atribút ''{0}'' mimo elementu." }, { "ILLEGAL_ATTRIBUTE_ERR", "Nelegálny atribút ''{0}''." }, { "CIRCULAR_INCLUDE_ERR", "Cirkulárny import/zahrnutie. Štýl dokumentu ''{0}'' je už zavedený." }, { "RESULT_TREE_SORT_ERR", "Fragmenty stromu výsledkov nemožno triediť (elementy <xsl:sort> sú ignorované). Keď vytvárate výsledkový strom, musíte triediť uzly." }, { "SYMBOLS_REDEF_ERR", "Desiatkové formátovanie ''{0}'' je už definované." }, { "XSL_VERSION_ERR", "Verzia XSL ''{0}'' nie je podporovaná XSLTC." }, { "CIRCULAR_VARIABLE_ERR", "Cirkulárna referencia premennej/parametra v ''{0}''." }, { "ILLEGAL_BINARY_OP_ERR", "Neznámy operátor pre binárny výraz." }, { "ILLEGAL_ARG_ERR", "Neplatný argument(y) pre volanie funkcie." }, { "DOCUMENT_ARG_ERR", "Druhý argument pre funkciu dokumentu() musí byť sada uzlov." }, { "MISSING_WHEN_ERR", "V <xsl:choose> sa vyžaduje najmenej jeden element <xsl:when>." }, { "MULTIPLE_OTHERWISE_ERR", "V  <xsl:choose> je povolený len jeden element <xsl:otherwise>." }, { "STRAY_OTHERWISE_ERR", "<xsl:otherwise> možno použiť len v <xsl:choose>." }, { "STRAY_WHEN_ERR", "<xsl:when> možno použiť len v <xsl:choose>." }, { "WHEN_ELEMENT_ERR", "V <xsl:choose> sú povolené len elementy <xsl:when> a <xsl:otherwise>." }, { "UNNAMED_ATTRIBSET_ERR", "<xsl:attribute-set> chýba atribút 'name'." }, { "ILLEGAL_CHILD_ERR", "Neplatný element potomka." }, { "ILLEGAL_ELEM_NAME_ERR", "Nemôžete volať element ''{0}''" }, { "ILLEGAL_ATTR_NAME_ERR", "Nemôžete volať atribút ''{0}''" }, { "ILLEGAL_TEXT_NODE_ERR", "Textové údaje sú mimo elementu vrchnej úrovne <xsl:stylesheet>." }, { "SAX_PARSER_CONFIG_ERR", "Analyzátor JAXP nie je správne nakonfigurovaný" }, { "INTERNAL_ERR", "Neodstrániteľná interná chyba XSLTC: ''{0}''" }, { "UNSUPPORTED_XSL_ERR", "Nepodporovaný element XSL ''{0}''." }, { "UNSUPPORTED_EXT_ERR", "Nerozlíšené rozšírenie XSLTC ''{0}''." }, { "MISSING_XSLT_URI_ERR", "Vstupný dokument nie je štýlom dokumentu (názvový priestor XSL nie je deklarovaný v koreňovom elemente)." }, { "MISSING_XSLT_TARGET_ERR", "Nebolo možné nájsť cieľ štýlu dokumentu ''{0}''." }, { "ACCESSING_XSLT_TARGET_ERR", "Could not read stylesheet target ''{0}'', because ''{1}'' access is not allowed." }, { "NOT_IMPLEMENTED_ERR", "Nie je implementované: ''{0}''." }, { "NOT_STYLESHEET_ERR", "Vstupný dokument neobsahuje štýl dokumentu XSL." }, { "ELEMENT_PARSE_ERR", "Nebolo možné analyzovať element ''{0}''" }, { "KEY_USE_ATTR_ERR", "Atribút použitia <key> musí byť uzol, sada uzlov, reťazec alebo číslo." }, { "OUTPUT_VERSION_ERR", "Verzia výstupného dokumentu XML by mala byť 1.0" }, { "ILLEGAL_RELAT_OP_ERR", "Neznámy operátor pre relačný výraz" }, { "ATTRIBSET_UNDEF_ERR", "Pokus o použitie neexistujúcej sady atribútov ''{0}''." }, { "ATTR_VAL_TEMPLATE_ERR", "Nie je možné analyzovať vzor hodnoty atribútu ''{0}''." }, { "UNKNOWN_SIG_TYPE_ERR", "Neznámy typ údajov v podpise pre triedu ''{0}''." }, { "DATA_CONVERSION_ERR", "Nie je možné konvertovať typ údajov ''{0}'' na ''{1}''." }, { "NO_TRANSLET_CLASS_ERR", "Tento vzor neobsahuje platnú definíciu triedy transletu." }, { "NO_MAIN_TRANSLET_ERR", "Tento vzor neobsahuje triedu s názvom ''{0}''." }, { "TRANSLET_CLASS_ERR", "Nebolo možné zaviesť triedu transletu ''{0}''." }, { "TRANSLET_OBJECT_ERR", "Trieda transletu zavedená, ale nie je možné vytvoriť inštanciu transletu." }, { "ERROR_LISTENER_NULL_ERR", "Pokus o nastavenie ErrorListener pre ''{0}'' na null" }, { "JAXP_UNKNOWN_SOURCE_ERR", "XSLTC podporuje len StreamSource, SAXSource a DOMSource" }, { "JAXP_NO_SOURCE_ERR", "Objekt zdroja odovzdaný ''{0}'' nemá žiadny obsah." }, { "JAXP_COMPILE_ERR", "Nebolo možné skompilovať štýl dokumentu" }, { "JAXP_INVALID_ATTR_ERR", "TransformerFactory nerozoznáva atribút ''{0}''." }, { "JAXP_SET_RESULT_ERR", "setResult() sa musí volať pred startDocument()." }, { "JAXP_NO_TRANSLET_ERR", "Transformátor nemá žiadny zapuzdrený objekt transletu." }, { "JAXP_NO_HANDLER_ERR", "Pre výsledok transformácie nebol definovaný žiadny výstupný handler." }, { "JAXP_NO_RESULT_ERR", "Objekt výsledku odovzdaný ''{0}'' je neplatný." }, { "JAXP_UNKNOWN_PROP_ERR", "Pokus o prístup k neplatnému majetku transformátora ''{0}''." }, { "SAX2DOM_ADAPTER_ERR", "Nebolo možné vytvoriť adaptér SAX2DOM: ''{0}''." }, { "XSLTC_SOURCE_ERR", "XSLTCSource.build() bol zavolaný bez nastaveného systemId." }, { "COMPILE_STDIN_ERR", "Voľba -i sa musí používať s voľbou -o." }, { "COMPILE_USAGE_STR", "SYNOPSIS\n   java com.sun.org.apache.xalan.internal.xsltc.cmdline.Compile [-o <output>]\n      [-d <directory>] [-j <jarfile>] [-p <package>]\n      [-n] [-x] [-s] [-u] [-v] [-h] { <stylesheet> | -i }\n\nOPTIONS\n   -o <output>    priraďuje názov <output> generovanému transletu \n. Štandardne sa názov transletu \n berie z názvu <stylesheet>. Táto voľba sa ignoruje pri kompilovaní viacerých štýlov dokumentov\n\n.   -d <directory> uvádza cieľový adresár pre translet\n   -j <jarfile>   pakuje triedy transletov do súboru jar názvu \n uvedeného ako <jarfile>\n   -p <package>   uvádza predponu názvu balíku pre všetky generované triedy transletu.\n\n   -n             povoľuje zoradenie vzorov v riadku (štandardné chovanie v priemere lepšie). \n\n   -x             zapína   výstupy správ ladenia \n   -s             zakazuje volanie System.exit\n   -u             interpretuje<stylesheet> argumenty ako URL\n   -i             núti kompilátor čítať štýl dokumentu z stdin\n   -v             tlačí verziu kompilátora\n   -h             tlačí príkaz tohto použitia\n" }, { "TRANSFORM_USAGE_STR", "SYNOPSIS \n   java com.sun.org.apache.xalan.internal.xsltc.cmdline.Transform [-j <jarfile>]\n      [-x] [-s] [-n <iterations>] {-u <document_url> | <document>}\n      <class> [<param1>=<value1> ...]\n\n   používa translet <class> na transformáciu dokumentu XML \n   uvedeného ako <document>. <class> transletu je buď v \n užívateľovej CLASSPATH alebo vo voliteľne uvedenom <jarfile>.\nVOĽBY\n   -j <jarfile>    uvádza súbor jar, z ktorého sa má zaviesť translet\n   -x              zapína ďalší výstup správ ladenia\n   -s              zakazuje volanie System.exit\n   -n <iterations> spúšťa transformáciu <iterations> ráz a \n                   zobrazuje informácie profilovania\n   -u <document_url> uvádza vstupný dokument XML ako URL\n" }, { "STRAY_SORT_ERR", "<xsl:sort> možno použiť len v <xsl:for-each> alebo <xsl:apply-templates>." }, { "UNSUPPORTED_ENCODING", "Výstupné kódovanie ''{0}'' nie je v tomto JVM podporované." }, { "SYNTAX_ERR", "Chyba syntaxe v ''{0}''." }, { "CONSTRUCTOR_NOT_FOUND", "Nie je možné nájsť externý konštruktor ''{0}''." }, { "NO_JAVA_FUNCT_THIS_REF", "Prvý argument pre nestatickú funkciu Java ''{0}'' nie je platnou referenciou objektu." }, { "TYPE_CHECK_ERR", "Chyba pri kontrole typu výrazu ''{0}''." }, { "TYPE_CHECK_UNK_LOC_ERR", "Chyba pri kontrole typu výrazu na neznámom mieste." }, { "ILLEGAL_CMDLINE_OPTION_ERR", "Voľba príkazového riadka ''{0}'' je neplatná." }, { "CMDLINE_OPT_MISSING_ARG_ERR", "Voľbe príkazového riadka ''{0}'' chýba požadovaný argument." }, { "WARNING_PLUS_WRAPPED_MSG", "UPOZORNENIE:  ''{0}''\n       :{1}" }, { "WARNING_MSG", "UPOZORNENIE:  ''{0}''" }, { "FATAL_ERR_PLUS_WRAPPED_MSG", "KRITICKÁ CHYBA:  ''{0}''\n           :{1}" }, { "FATAL_ERR_MSG", "KRITICKÁ CHYBA:  ''{0}''" }, { "ERROR_PLUS_WRAPPED_MSG", "CHYBA:  ''{0}''\n     :{1}" }, { "ERROR_MSG", "CHYBA:  ''{0}''" }, { "TRANSFORM_WITH_TRANSLET_STR", "Transformácia pomocou transletu ''{0}'' " }, { "TRANSFORM_WITH_JAR_STR", "Transformácia pomocou transletu ''{0}'' zo súboru jar ''{1}''" }, { "COULD_NOT_CREATE_TRANS_FACT", "Nebolo možné vytvoriť inštanciu triedy TransformerFactory ''{0}''." }, { "COMPILER_ERROR_KEY", "Chyby prekladača:" }, { "COMPILER_WARNING_KEY", "Upozornenia prekladača:" }, { "RUNTIME_ERROR_KEY", "Chyby transletu:" }, { "JAXP_SECUREPROCESSING_FEATURE", "FEATURE_SECURE_PROCESSING: Cannot set the feature to false when security manager is present." } };
/*    */   }
/*    */ }


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/com/sun/org/apache/xalan/internal/xsltc/compiler/util/ErrorMessages_sk.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */