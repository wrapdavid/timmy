/*     */ package com.sun.org.apache.xml.internal.serializer.utils;
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
/*     */ public class SerializerMessages_sv
/*     */   extends ListResourceBundle
/*     */ {
/*     */   public Object[][] getContents() {
/*  71 */     Object[][] contents = { { "BAD_MSGKEY", "Meddelandenyckeln ''{0}'' är inte i meddelandeklassen ''{1}''" }, { "BAD_MSGFORMAT", "Formatet på meddelandet ''{0}'' i meddelandeklassen ''{1}'' underkändes." }, { "ER_SERIALIZER_NOT_CONTENTHANDLER", "Serializerklassen ''{0}'' implementerar inte org.xml.sax.ContentHandler." }, { "ER_RESOURCE_COULD_NOT_FIND", "Resursen [ {0} ] kunde inte hämtas.\n {1}" }, { "ER_RESOURCE_COULD_NOT_LOAD", "Resursen [ {0} ] kunde inte laddas: {1} \n {2} \t {3}" }, { "ER_BUFFER_SIZE_LESSTHAN_ZERO", "Buffertstorlek <=0" }, { "ER_INVALID_UTF16_SURROGATE", "Ogiltigt UTF-16-surrogat upptäckt: {0} ?" }, { "ER_OIERROR", "IO-fel" }, { "ER_ILLEGAL_ATTRIBUTE_POSITION", "Kan inte lägga till attributet {0} efter underordnade noder eller innan ett element har skapats. Attributet ignoreras." }, { "ER_NAMESPACE_PREFIX", "Namnrymd för prefix ''{0}'' har inte deklarerats." }, { "ER_STRAY_ATTRIBUTE", "Attributet ''{0}'' finns utanför elementet." }, { "ER_STRAY_NAMESPACE", "Namnrymdsdeklarationen ''{0}''=''{1}'' finns utanför element." }, { "ER_COULD_NOT_LOAD_RESOURCE", "Kunde inte ladda ''{0}'' (kontrollera CLASSPATH), använder nu enbart standardvärden" }, { "ER_ILLEGAL_CHARACTER", "Försök att skriva utdatatecken med integralvärdet {0} som inte är representerat i angiven utdatakodning av {1}." }, { "ER_COULD_NOT_LOAD_METHOD_PROPERTY", "Kunde inte ladda egenskapsfilen ''{0}'' för utdatametoden ''{1}'' (kontrollera CLASSPATH)" }, { "ER_INVALID_PORT", "Ogiltigt portnummer" }, { "ER_PORT_WHEN_HOST_NULL", "Port kan inte ställas in när värd är null" }, { "ER_HOST_ADDRESS_NOT_WELLFORMED", "Värd är inte en välformulerad adress" }, { "ER_SCHEME_NOT_CONFORMANT", "Schemat är inte likformigt." }, { "ER_SCHEME_FROM_NULL_STRING", "Kan inte ställa in schema från null-sträng" }, { "ER_PATH_CONTAINS_INVALID_ESCAPE_SEQUENCE", "Sökvägen innehåller en ogiltig escape-sekvens" }, { "ER_PATH_INVALID_CHAR", "Sökvägen innehåller ett ogiltigt tecken: {0}" }, { "ER_FRAG_INVALID_CHAR", "Fragment innehåller ett ogiltigt tecken" }, { "ER_FRAG_WHEN_PATH_NULL", "Fragment kan inte ställas in när sökväg är null" }, { "ER_FRAG_FOR_GENERIC_URI", "Fragment kan bara ställas in för en allmän URI" }, { "ER_NO_SCHEME_IN_URI", "Schema saknas i URI" }, { "ER_CANNOT_INIT_URI_EMPTY_PARMS", "Kan inte initiera URI med tomma parametrar" }, { "ER_NO_FRAGMENT_STRING_IN_PATH", "Fragment kan inte anges i både sökvägen och fragmentet" }, { "ER_NO_QUERY_STRING_IN_PATH", "Frågesträng kan inte anges i både sökvägen och frågesträngen" }, { "ER_NO_PORT_IF_NO_HOST", "Port får inte anges om värden inte är angiven" }, { "ER_NO_USERINFO_IF_NO_HOST", "Användarinfo får inte anges om värden inte är angiven" }, { "ER_XML_VERSION_NOT_SUPPORTED", "Varning:  Versionen av utdatadokumentet som begärts är ''{0}''.  Den här versionen av XML stöds inte.  Versionen av utdatadokumentet kommer att vara ''1.0''." }, { "ER_SCHEME_REQUIRED", "Schema krävs!" }, { "ER_FACTORY_PROPERTY_MISSING", "Egenskapsobjektet som överförts till SerializerFactory har ingen ''{0}''-egenskap." }, { "ER_ENCODING_NOT_SUPPORTED", "Varning: Kodningen ''{0}'' stöds inte av Java runtime." } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 203 */     return contents;
/*     */   }
/*     */ }


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/com/sun/org/apache/xml/internal/serializer/utils/SerializerMessages_sv.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */