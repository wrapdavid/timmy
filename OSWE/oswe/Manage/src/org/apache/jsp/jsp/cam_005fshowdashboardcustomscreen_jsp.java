/*      */ package org.apache.jsp.jsp;
/*      */ 
/*      */ import com.adventnet.appmanager.cam.CAMDBUtil;
/*      */ import com.adventnet.appmanager.cam.beans.CAMGraphs;
/*      */ import com.adventnet.appmanager.client.resourcemanagement.ManagedApplication;
/*      */ import com.adventnet.appmanager.db.AMConnectionPool;
/*      */ import com.adventnet.appmanager.dbcache.ConfMonitorConfiguration;
/*      */ import com.adventnet.appmanager.logging.AMLog;
/*      */ import com.adventnet.appmanager.util.BreadcrumbUtil;
/*      */ import com.adventnet.appmanager.util.EnterpriseUtil;
/*      */ import com.adventnet.appmanager.util.FormatUtil;
/*      */ import com.adventnet.awolf.tags.TimeChart;
/*      */ import java.net.InetAddress;
/*      */ import java.net.URLEncoder;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashMap;
/*      */ import java.util.Hashtable;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Properties;
/*      */ import java.util.StringTokenizer;
/*      */ import java.util.Vector;
/*      */ import javax.servlet.http.HttpServletRequest;
/*      */ import javax.servlet.http.HttpSession;
/*      */ import javax.servlet.jsp.JspFactory;
/*      */ import javax.servlet.jsp.JspWriter;
/*      */ import javax.servlet.jsp.PageContext;
/*      */ import javax.servlet.jsp.tagext.JspTag;
/*      */ import javax.servlet.jsp.tagext.Tag;
/*      */ import javax.swing.tree.DefaultMutableTreeNode;
/*      */ import org.apache.jasper.runtime.TagHandlerPool;
/*      */ import org.apache.struts.taglib.bean.DefineTag;
/*      */ import org.apache.struts.taglib.tiles.InsertTag;
/*      */ import org.apache.struts.taglib.tiles.PutTag;
/*      */ import org.apache.taglibs.standard.tag.common.core.CatchTag;
/*      */ import org.apache.taglibs.standard.tag.el.core.IfTag;
/*      */ import org.apache.taglibs.standard.tag.el.fmt.ParseNumberTag;
/*      */ 
/*      */ public final class cam_005fshowdashboardcustomscreen_jsp extends org.apache.jasper.runtime.HttpJspBase implements org.apache.jasper.runtime.JspSourceDependent
/*      */ {
/*      */   public static final String NAME_SEPARATOR = ">";
/*   48 */   public static final String ALERTCONFIG_TEXT = FormatUtil.getString("am.webclient.common.util.ALERTCONFIG_TEXT");
/*      */   public static final String STATUS_SEPARATOR = "#";
/*      */   public static final String MESSAGE_SEPARATOR = "MESSAGE";
/*   51 */   public static final String MGSTR = FormatUtil.getString("am.webclient.common.util.MGSTR");
/*   52 */   public static final String WEBMG = FormatUtil.getString("am.webclient.common.util.WEBMG");
/*   53 */   public static final String MGSTRs = FormatUtil.getString("am.webclient.common.util.MGSTRs");
/*      */   public static final String MISTR = "Monitor";
/*      */   public static final String MISTRs = "Monitors";
/*      */   public static final String RCA_SEPARATOR = " --> ";
/*      */   
/*      */   public String getOptions(String value, String text, String tableName, boolean distinct)
/*      */   {
/*   60 */     return getOptions(value, text, tableName, distinct, "");
/*      */   }
/*      */   
/*      */   public String getOptions(String value, String text, String tableName, boolean distinct, String condition)
/*      */   {
/*   65 */     ArrayList list = null;
/*   66 */     StringBuffer sbf = new StringBuffer();
/*   67 */     ManagedApplication mo = new ManagedApplication();
/*   68 */     if (distinct)
/*      */     {
/*   70 */       list = mo.getRows("SELECT distinct(" + value + ") FROM " + tableName);
/*      */     }
/*      */     else
/*      */     {
/*   74 */       list = mo.getRows("SELECT " + value + "," + text + " FROM " + tableName + " " + condition);
/*      */     }
/*      */     
/*   77 */     for (int i = 0; i < list.size(); i++)
/*      */     {
/*   79 */       ArrayList row = (ArrayList)list.get(i);
/*   80 */       sbf.append("<option value='" + row.get(0) + "'>");
/*   81 */       if (distinct) {
/*   82 */         sbf.append(row.get(0));
/*      */       } else
/*   84 */         sbf.append(row.get(1));
/*   85 */       sbf.append("</option>");
/*      */     }
/*      */     
/*   88 */     return sbf.toString(); }
/*      */   
/*   90 */   long j = 0L;
/*      */   
/*      */   private String getSeverityImageForAvailability(Object severity) {
/*   93 */     if (severity == null)
/*      */     {
/*   95 */       return "<img border=\"0\" src=\"/images/icon_availability_unknown.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*   97 */     if (severity.equals("5"))
/*      */     {
/*   99 */       return "<img border=\"0\" src=\"/images/icon_availability_up.gif\"  name=\"Image" + ++this.j + "\">";
/*      */     }
/*  101 */     if (severity.equals("1"))
/*      */     {
/*  103 */       return "<img border=\"0\" src=\"/images/icon_availability_down.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  108 */     return "<img border=\"0\" src=\"/images/icon_availability_unknown.gif\" name=\"Image" + ++this.j + "\">";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private String getSeverityImage(Object severity)
/*      */   {
/*  115 */     if (severity == null)
/*      */     {
/*  117 */       return "<img border=\"0\" src=\"/images/icon_unknown_status.gif\" alt=\"Unknown\" title=\"" + FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.unknown") + "\" align=\"absmiddle\">";
/*      */     }
/*  119 */     if (severity.equals("1"))
/*      */     {
/*  121 */       return "<img border=\"0\" src=\"/images/icon_critical.gif\" alt=\"Critical\" title=\"" + FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.critical") + "\" align=\"absmiddle\">";
/*      */     }
/*  123 */     if (severity.equals("4"))
/*      */     {
/*  125 */       return "<img border=\"0\" src=\"/images/icon_warning.gif\" alt=\"Warning\" title=\"" + FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.warning") + "\" align=\"absmiddle\">";
/*      */     }
/*  127 */     if (severity.equals("5"))
/*      */     {
/*  129 */       return "<img border=\"0\" src=\"/images/icon_clear.gif\"  alt=\"Clear\" title=\"" + FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.clear") + "\" align=\"absmiddle\" >";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  134 */     return "<img border=\"0\" src=\"/images/icon_unknown_status.gif\" alt=\"Unknown\" title=\"Unknown\" align=\"absmiddle\">";
/*      */   }
/*      */   
/*      */ 
/*      */   private String getSeverityStateForAvailability(Object severity)
/*      */   {
/*  140 */     if (severity == null)
/*      */     {
/*  142 */       return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.unknown");
/*      */     }
/*  144 */     if (severity.equals("5"))
/*      */     {
/*  146 */       return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.up");
/*      */     }
/*  148 */     if (severity.equals("1"))
/*      */     {
/*  150 */       return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.down");
/*      */     }
/*      */     
/*      */ 
/*  154 */     return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.unknown");
/*      */   }
/*      */   
/*      */ 
/*      */   private String getSeverityState(Object severity)
/*      */   {
/*  160 */     if (severity == null)
/*      */     {
/*  162 */       return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.unknown");
/*      */     }
/*  164 */     if (severity.equals("1"))
/*      */     {
/*  166 */       return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.critical");
/*      */     }
/*  168 */     if (severity.equals("4"))
/*      */     {
/*  170 */       return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.warning");
/*      */     }
/*  172 */     if (severity.equals("5"))
/*      */     {
/*  174 */       return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.clear");
/*      */     }
/*      */     
/*      */ 
/*  178 */     return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.unknown");
/*      */   }
/*      */   
/*      */ 
/*      */   private String getSeverityImage(int severity)
/*      */   {
/*  184 */     return getSeverityImage("" + severity);
/*      */   }
/*      */   
/*      */ 
/*      */   private String getSeverityImageForAvailability(int severity)
/*      */   {
/*  190 */     if (severity == 5)
/*      */     {
/*  192 */       return "<img border=\"0\" src=\"/images/icon_availability_up.gif\"  alt=\"Up\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*  194 */     if (severity == 1)
/*      */     {
/*  196 */       return "<img border=\"0\" src=\"/images/icon_availability_down.gif\" alt=\"Down\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  201 */     return "<img border=\"0\" src=\"/images/icon_availability_unknown.gif\" alt=\"Unknown\" name=\"Image" + ++this.j + "\">";
/*      */   }
/*      */   
/*      */ 
/*      */   private String getSeverityImageForConfMonitor(String severity, boolean isAvailability)
/*      */   {
/*  207 */     if (severity == null)
/*      */     {
/*  209 */       return "<img border=\"0\" src=\"/images/icon_unknown_conf.png\" alt=\"Unknown\">";
/*      */     }
/*  211 */     if (severity.equals("5"))
/*      */     {
/*  213 */       if (isAvailability) {
/*  214 */         return "<img border=\"0\" src=\"/images/icon_up_conf.png\" alt='" + FormatUtil.getString("Up") + "' >";
/*      */       }
/*      */       
/*  217 */       return "<img border=\"0\" src=\"/images/icon_conf_hlt_clear.png\" alt='" + FormatUtil.getString("Clear") + "' >";
/*      */     }
/*      */     
/*  220 */     if ((severity.equals("4")) && (!isAvailability))
/*      */     {
/*  222 */       return "<img border=\"0\" src=\"/images/icon_warning_conf.png\" alt=\"Warning\">";
/*      */     }
/*  224 */     if (severity.equals("1"))
/*      */     {
/*  226 */       if (isAvailability) {
/*  227 */         return "<img border=\"0\" src=\"/images/icon_down_conf.png\" alt=\"Down\">";
/*      */       }
/*      */       
/*  230 */       return "<img border=\"0\" src=\"/images/icon_conf_hlt_critical.png\" alt=\"Critical\">";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  237 */     return "<img border=\"0\" src=\"/images/icon_unknown_conf.png\" alt=\"Unknown\">";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private String getSeverityImageForHealth(String severity)
/*      */   {
/*  244 */     if (severity == null)
/*      */     {
/*  246 */       return "<img border=\"0\" src=\"/images/icon_health_unknown.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*  248 */     if (severity.equals("5"))
/*      */     {
/*  250 */       return "<img border=\"0\" src=\"/images/icon_health_clear.gif\"  name=\"Image" + ++this.j + "\">";
/*      */     }
/*  252 */     if (severity.equals("4"))
/*      */     {
/*  254 */       return "<img border=\"0\" src=\"/images/icon_health_warning.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*  256 */     if (severity.equals("1"))
/*      */     {
/*  258 */       return "<img border=\"0\" src=\"/images/icon_health_critical.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  263 */     return "<img border=\"0\" src=\"/images/icon_health_unknown.gif\" name=\"Image" + ++this.j + "\">";
/*      */   }
/*      */   
/*      */ 
/*      */   private String getas400SeverityImageForHealth(String severity)
/*      */   {
/*  269 */     if (severity == null)
/*      */     {
/*  271 */       return "<img border=\"0\" src=\"/images/icon_as400health_clear.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*  273 */     if (severity.equals("5"))
/*      */     {
/*  275 */       return "<img border=\"0\" src=\"/images/icon_as400health_clear.gif\"  name=\"Image" + ++this.j + "\">";
/*      */     }
/*  277 */     if (severity.equals("4"))
/*      */     {
/*  279 */       return "<img border=\"0\" src=\"/images/icon_as400health_warning.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*  281 */     if (severity.equals("1"))
/*      */     {
/*  283 */       return "<img border=\"0\" src=\"/images/icon_as400health_critical.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  288 */     return "<img border=\"0\" src=\"/images/icon_as400health_clear.gif\" name=\"Image" + ++this.j + "\">";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private String getSeverityImageForHealthWithoutMouseOver(String severity)
/*      */   {
/*  295 */     if (severity == null)
/*      */     {
/*  297 */       return "<img border=\"0\" src=\"/images/icon_health_unknown_nm.gif\" alt=\"Unknown\">";
/*      */     }
/*  299 */     if (severity.equals("5"))
/*      */     {
/*  301 */       return "<img border=\"0\" src=\"/images/icon_health_clear_nm.gif\" alt=\"Clear\" >";
/*      */     }
/*  303 */     if (severity.equals("4"))
/*      */     {
/*  305 */       return "<img border=\"0\" src=\"/images/icon_health_warning_nm.gif\" alt=\"Warning\">";
/*      */     }
/*  307 */     if (severity.equals("1"))
/*      */     {
/*  309 */       return "<img border=\"0\" src=\"/images/icon_health_critical_nm.gif\" alt=\"Critical\">";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  314 */     return "<img border=\"0\" src=\"/images/icon_health_unknown_nm.gif\" alt=\"Unknown\">";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private String getSearchStrip(String map)
/*      */   {
/*  322 */     StringBuffer out = new StringBuffer();
/*  323 */     out.append("<form action=\"/Search.do\" style=\"display:inline;\" >");
/*  324 */     out.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"breadcrumbs\">");
/*  325 */     out.append("<tr class=\"breadcrumbs\"> ");
/*  326 */     out.append("  <td width=\"72%\" height=\"20\">&nbsp;&nbsp;&nbsp;&nbsp;" + map + "&nbsp; &nbsp;&nbsp;</td>");
/*  327 */     out.append("  <td width=\"9%\"> <input name=\"query\" type=\"text\" class=\"formtextsearch\" size=\"15\"></td>");
/*  328 */     out.append("  <td width=\"5%\"> &nbsp; <input name=\"Submit\" type=\"submit\" class=\"buttons\" value=\"Find\"></td>");
/*  329 */     out.append("</tr>");
/*  330 */     out.append("</form></table>");
/*  331 */     return out.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private String formatNumberForDotNet(String val)
/*      */   {
/*  338 */     if (val == null)
/*      */     {
/*  340 */       return "-";
/*      */     }
/*      */     
/*  343 */     String ret = FormatUtil.formatNumber(val);
/*  344 */     String troubleshootlink = com.adventnet.appmanager.util.OEMUtil.getOEMString("company.troubleshoot.link");
/*  345 */     if (ret.indexOf("-1") != -1)
/*      */     {
/*      */ 
/*  348 */       return "- &nbsp;<a class=\"staticlinks\" href=\"http://" + troubleshootlink + "#m44\" target=\"_blank\">" + FormatUtil.getString("am.webclient.dotnet.troubleshoot") + "</a>";
/*      */     }
/*      */     
/*      */ 
/*  352 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getHTMLTable(String[] headers, List tableData, String link, String deleteLink)
/*      */   {
/*  360 */     StringBuffer out = new StringBuffer();
/*  361 */     out.append("<table align=\"center\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"  border=\"0\">");
/*  362 */     out.append("<tr>");
/*  363 */     for (int i = 0; i < headers.length; i++)
/*      */     {
/*  365 */       out.append("<td valign=\"center\"height=\"28\" bgcolor=\"ACD5FE\" class=\"columnheading\">" + headers[i] + "</td>");
/*      */     }
/*  367 */     out.append("</tr>");
/*  368 */     for (int j = 0; j < tableData.size(); j++)
/*      */     {
/*      */ 
/*      */ 
/*  372 */       if (j % 2 == 0)
/*      */       {
/*  374 */         out.append("<tr class=\"whitegrayborder\">");
/*      */       }
/*      */       else
/*      */       {
/*  378 */         out.append("<tr class=\"yellowgrayborder\">");
/*      */       }
/*      */       
/*  381 */       List rowVector = (List)tableData.get(j);
/*      */       
/*  383 */       for (int k = 0; k < rowVector.size(); k++)
/*      */       {
/*      */ 
/*  386 */         out.append("<td height=\"22\" >" + rowVector.get(k) + "</td>");
/*      */       }
/*      */       
/*      */ 
/*  390 */       out.append("</tr>");
/*      */     }
/*  392 */     out.append("</table>");
/*  393 */     out.append("<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"tablebottom\">");
/*  394 */     out.append("<tr>");
/*  395 */     out.append("<td width=\"72%\" height=\"26\" ><A HREF=\"" + deleteLink + "\" class=\"staticlinks\">Delete</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href=\"" + link + "\" class=\"staticlinks\">Add New</a>&nbsp;&nbsp;</td>");
/*  396 */     out.append("</tr>");
/*  397 */     out.append("</table>");
/*  398 */     return out.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public static String getSingleColumnDisplay(String header, Vector tableColumns)
/*      */   {
/*  404 */     StringBuffer out = new StringBuffer();
/*  405 */     out.append("<table width=\"95%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
/*  406 */     out.append("<table width=\"95%\" height=\"5\" cellpadding=\"5\" cellspacing=\"5\" class=\"lrbborder\">");
/*  407 */     out.append("<tr>");
/*  408 */     out.append("<td align=\"center\"> <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"lrborder\">");
/*  409 */     out.append("<tr>");
/*  410 */     out.append("<td width=\"3%\" bgcolor=\"ACD5FE\" class=\"columnheading\"> <input type=\"checkbox\" name=\"maincheckbox\" value=\"checkbox\"></td>");
/*  411 */     out.append("<td width=\"15%\" bgcolor=\"ACD5FE\" class=\"columnheading\"> Name </td>");
/*  412 */     out.append("</tr>");
/*  413 */     for (int k = 0; k < tableColumns.size(); k++)
/*      */     {
/*      */ 
/*  416 */       out.append("<tr>");
/*  417 */       out.append("<td class=\"yellowgrayborder\"><input type=\"checkbox\" name=\"checkbox" + k + "\" value=\"checkbox\"></td>");
/*  418 */       out.append("<td height=\"22\" class=\"yellowgrayborder\">" + tableColumns.elementAt(k) + "</td>");
/*  419 */       out.append("</tr>");
/*      */     }
/*      */     
/*  422 */     out.append("</table>");
/*  423 */     out.append("</table>");
/*  424 */     return out.toString();
/*      */   }
/*      */   
/*      */   private String getAvailabilityImage(String severity)
/*      */   {
/*  429 */     if (severity.equals("0"))
/*      */     {
/*  431 */       return "<img src=\"/images/icon_critical.gif\" alt=\"Critical\" border=0 >";
/*      */     }
/*      */     
/*      */ 
/*  435 */     return "<img src=\"/images/icon_clear.gif\" alt=\"Clear\"  border=0>";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getQuickLinksAndNotes(String quickLinkHeader, ArrayList quickLinkText, ArrayList quickLink, String quickNote, HttpSession session)
/*      */   {
/*  442 */     return getQuickLinksAndNotes(quickLinkHeader, quickLinkText, quickLink, null, null, quickNote, session);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getQuickLinksAndNotes(String quickLinkHeader, ArrayList quickLinkText, ArrayList quickLink, String secondLevelLinkTitle, List[] secondLevelOfLinks, String quickNote, HttpSession session)
/*      */   {
/*  455 */     StringBuffer out = new StringBuffer();
/*  456 */     out.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmnutables\">");
/*  457 */     if ((quickLinkText != null) && (quickLink != null) && (quickLinkText.size() == quickLink.size()))
/*      */     {
/*  459 */       out.append("<tr>");
/*  460 */       out.append("<td   class=\"leftlinksheading\">" + quickLinkHeader + "d,.mfnjh.mdfnh.m,dfnh,.dfmn</td>");
/*  461 */       out.append("</tr>");
/*      */       
/*      */ 
/*  464 */       for (int i = 0; i < quickLinkText.size(); i++)
/*      */       {
/*  466 */         String borderclass = "";
/*      */         
/*      */ 
/*  469 */         borderclass = "class=\"leftlinkstd\"";
/*      */         
/*  471 */         out.append("<tr>");
/*      */         
/*  473 */         out.append("<td width=\"81%\" height=\"21\" " + borderclass + ">");
/*  474 */         out.append("<a href=\"" + (String)quickLink.get(i) + "\" class=\"staticlinks\">" + (String)quickLinkText.get(i) + "</a></td>");
/*  475 */         out.append("</tr>");
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  481 */     out.append("</table><br>");
/*  482 */     out.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmnutables\">");
/*  483 */     if ((secondLevelOfLinks != null) && (secondLevelLinkTitle != null))
/*      */     {
/*  485 */       List sLinks = secondLevelOfLinks[0];
/*  486 */       List sText = secondLevelOfLinks[1];
/*  487 */       if ((sText != null) && (sLinks != null) && (sLinks.size() == sText.size()))
/*      */       {
/*      */ 
/*  490 */         out.append("<tr>");
/*  491 */         out.append("<td   class=\"leftlinksheading\">" + secondLevelLinkTitle + "</td>");
/*  492 */         out.append("</tr>");
/*  493 */         for (int i = 0; i < sText.size(); i++)
/*      */         {
/*  495 */           String borderclass = "";
/*      */           
/*      */ 
/*  498 */           borderclass = "class=\"leftlinkstd\"";
/*      */           
/*  500 */           out.append("<tr>");
/*      */           
/*  502 */           out.append("<td width=\"81%\" height=\"21\" " + borderclass + ">");
/*  503 */           if (sLinks.get(i).toString().length() == 0) {
/*  504 */             out.append((String)sText.get(i) + "</td>");
/*      */           }
/*      */           else {
/*  507 */             out.append("<a href=\"" + (String)sLinks.get(i) + "\" class=\"staticlinks\">" + (String)sText.get(i) + "</a></td>");
/*      */           }
/*  509 */           out.append("</tr>");
/*      */         }
/*      */       }
/*      */     }
/*  513 */     out.append("</table>");
/*  514 */     return out.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getQuickLinksAndNote(String quickLinkHeader, ArrayList quickLinkText, ArrayList quickLink, String secondLevelLinkTitle, List[] secondLevelOfLinks, String quickNote, HttpSession session, HttpServletRequest request)
/*      */   {
/*  521 */     StringBuffer out = new StringBuffer();
/*  522 */     out.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmnutables\">");
/*  523 */     if ((quickLinkText != null) && (quickLink != null) && (quickLinkText.size() == quickLink.size()))
/*      */     {
/*  525 */       if ((request.isUserInRole("DEMO")) || (request.isUserInRole("ADMIN")) || (request.isUserInRole("ENTERPRISEADMIN")))
/*      */       {
/*  527 */         out.append("<tr>");
/*  528 */         out.append("<td   class=\"leftlinksheading\">" + quickLinkHeader + "</td>");
/*  529 */         out.append("</tr>");
/*      */         
/*      */ 
/*      */ 
/*  533 */         for (int i = 0; i < quickLinkText.size(); i++)
/*      */         {
/*  535 */           String borderclass = "";
/*      */           
/*      */ 
/*  538 */           borderclass = "class=\"leftlinkstd\"";
/*      */           
/*  540 */           out.append("<tr>");
/*      */           
/*  542 */           out.append("<td width=\"81%\" height=\"21\" " + borderclass + ">");
/*  543 */           if (((String)quickLinkText.get(i)).indexOf("a href") == -1) {
/*  544 */             out.append("<a href=\"" + (String)quickLink.get(i) + "\" class=\"new-left-links\">" + (String)quickLinkText.get(i) + "</a>");
/*      */           }
/*      */           else {
/*  547 */             out.append((String)quickLinkText.get(i));
/*      */           }
/*      */           
/*  550 */           out.append("</td></tr>");
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  555 */     out.append("</table><br>");
/*  556 */     out.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmnutables\">");
/*  557 */     if ((secondLevelOfLinks != null) && (secondLevelLinkTitle != null))
/*      */     {
/*  559 */       List sLinks = secondLevelOfLinks[0];
/*  560 */       List sText = secondLevelOfLinks[1];
/*  561 */       if ((sText != null) && (sLinks != null) && (sLinks.size() == sText.size()))
/*      */       {
/*      */ 
/*  564 */         out.append("<tr>");
/*  565 */         out.append("<td   class=\"leftlinksheading\">" + secondLevelLinkTitle + "</td>");
/*  566 */         out.append("</tr>");
/*  567 */         for (int i = 0; i < sText.size(); i++)
/*      */         {
/*  569 */           String borderclass = "";
/*      */           
/*      */ 
/*  572 */           borderclass = "class=\"leftlinkstd\"";
/*      */           
/*  574 */           out.append("<tr>");
/*      */           
/*  576 */           out.append("<td width=\"81%\" height=\"21\" " + borderclass + ">");
/*  577 */           if (sLinks.get(i).toString().length() == 0) {
/*  578 */             out.append((String)sText.get(i) + "</td>");
/*      */           }
/*      */           else {
/*  581 */             out.append("<a href=\"" + (String)sLinks.get(i) + "\" class=\"new-left-links\">" + (String)sText.get(i) + "</a></td>");
/*      */           }
/*  583 */           out.append("</tr>");
/*      */         }
/*      */       }
/*      */     }
/*  587 */     out.append("</table>");
/*  588 */     return out.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private String getSeverityClass(int status)
/*      */   {
/*  601 */     switch (status)
/*      */     {
/*      */     case 1: 
/*  604 */       return "class=\"errorgrayborder\"";
/*      */     
/*      */     case 2: 
/*  607 */       return "class=\"errorgrayborder\"";
/*      */     
/*      */     case 3: 
/*  610 */       return "class=\"errorgrayborder\"";
/*      */     
/*      */     case 4: 
/*  613 */       return "class=\"errorgrayborder\"";
/*      */     
/*      */     case 5: 
/*  616 */       return "class=\"whitegrayborder\"";
/*      */     
/*      */     case 6: 
/*  619 */       return "class=\"whitegrayborder\"";
/*      */     }
/*      */     
/*  622 */     return "class=\"whitegrayborder\"";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getTrimmedText(String stringToTrim, int lengthOfTrimmedString)
/*      */   {
/*  630 */     return FormatUtil.getTrimmedText(stringToTrim, lengthOfTrimmedString);
/*      */   }
/*      */   
/*      */   public String getformatedText(String stringToTrim, int lengthOfTrimmedString, int lastPartStartsfrom)
/*      */   {
/*  635 */     return FormatUtil.getformatedText(stringToTrim, lengthOfTrimmedString, lastPartStartsfrom);
/*      */   }
/*      */   
/*      */   private String getTruncatedAlertMessage(String messageArg)
/*      */   {
/*  640 */     return FormatUtil.getTruncatedAlertMessage(messageArg);
/*      */   }
/*      */   
/*      */   private String formatDT(String val)
/*      */   {
/*  645 */     return FormatUtil.formatDT(val);
/*      */   }
/*      */   
/*      */   private String formatDT(Long val)
/*      */   {
/*  650 */     if (val != null)
/*      */     {
/*  652 */       return FormatUtil.formatDT(val.toString());
/*      */     }
/*      */     
/*      */ 
/*  656 */     return "-";
/*      */   }
/*      */   
/*      */   private String formatDTwithOutYear(String val)
/*      */   {
/*  661 */     if (val == null) {
/*  662 */       return val;
/*      */     }
/*      */     try
/*      */     {
/*  666 */       val = new java.text.SimpleDateFormat("MMM d h:mm a").format(new Date(Long.parseLong(val)));
/*      */     }
/*      */     catch (Exception e) {}
/*      */     
/*      */ 
/*  671 */     return val;
/*      */   }
/*      */   
/*      */ 
/*      */   private String formatDTwithOutYear(Long val)
/*      */   {
/*  677 */     if (val != null)
/*      */     {
/*  679 */       return formatDTwithOutYear(val.toString());
/*      */     }
/*      */     
/*      */ 
/*  683 */     return "-";
/*      */   }
/*      */   
/*      */ 
/*      */   private String formatAlertDT(String val)
/*      */   {
/*  689 */     return val.substring(0, val.lastIndexOf(":")) + val.substring(val.lastIndexOf(":") + 3);
/*      */   }
/*      */   
/*      */   private String formatNumber(Object val)
/*      */   {
/*  694 */     return FormatUtil.formatNumber(val);
/*      */   }
/*      */   
/*      */   private String formatNumber(long val) {
/*  698 */     return FormatUtil.formatNumber(val);
/*      */   }
/*      */   
/*      */   private String formatBytesToKB(String val)
/*      */   {
/*  703 */     return FormatUtil.formatBytesToKB(val) + " " + FormatUtil.getString("KB");
/*      */   }
/*      */   
/*      */   private String formatBytesToMB(String val)
/*      */   {
/*  708 */     return FormatUtil.formatBytesToMB(val) + " " + FormatUtil.getString("MB");
/*      */   }
/*      */   
/*      */   private String getHostAddress(HttpServletRequest request) throws Exception
/*      */   {
/*  713 */     String hostaddress = "";
/*  714 */     String ip = request.getHeader("x-forwarded-for");
/*  715 */     if (ip == null)
/*  716 */       ip = request.getRemoteAddr();
/*  717 */     InetAddress add = null;
/*  718 */     if (ip.equals("127.0.0.1")) {
/*  719 */       add = InetAddress.getLocalHost();
/*      */     }
/*      */     else
/*      */     {
/*  723 */       add = InetAddress.getByName(ip);
/*      */     }
/*  725 */     hostaddress = add.getHostName();
/*  726 */     if (hostaddress.indexOf('.') != -1) {
/*  727 */       StringTokenizer st = new StringTokenizer(hostaddress, ".");
/*  728 */       hostaddress = st.nextToken();
/*      */     }
/*      */     
/*      */ 
/*  732 */     return hostaddress;
/*      */   }
/*      */   
/*      */   private String removeBr(String arg)
/*      */   {
/*  737 */     return FormatUtil.replaceStringBySpecifiedString(arg, "<br>", "", 0);
/*      */   }
/*      */   
/*      */ 
/*      */   private String getSeverityImageForMssqlAvailability(Object severity)
/*      */   {
/*  743 */     if (severity == null)
/*      */     {
/*  745 */       return "<img border=\"0\" src=\"/images/icon_esx_unknown.gif\" name=\"Image" + ++this.j + "\"  onMouseOut=\"javascript:MM_swapImgRestore()\" onMouseOver=\"javascript:MM_swapImage('Image" + this.j + "','','/images/icon_esx_unknown.gif',1)\">";
/*      */     }
/*  747 */     if (severity.equals("5"))
/*      */     {
/*  749 */       return "<img border=\"0\" src=\"/images/up_icon.gif\"  name=\"Image" + ++this.j + "\"  onMouseOut=\"javascript:MM_swapImgRestore()\" onMouseOver=\"javascript:MM_swapImage('Image" + this.j + "','','/images/up_icon.gif',1)\">";
/*      */     }
/*  751 */     if (severity.equals("1"))
/*      */     {
/*  753 */       return "<img border=\"0\" src=\"/images/down_icon.gif\" name=\"Image" + ++this.j + "\"  onMouseOut=\"javascript:MM_swapImgRestore()\" onMouseOver=\"javascript:MM_swapImage('Image" + this.j + "','','/images/down_icon.gif',1)\">";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  758 */     return "<img border=\"0\" src=\"/images/icon_esx_unknown.gif\" name=\"Image" + ++this.j + "\"  onMouseOut=\"javascript:MM_swapImgRestore()\" onMouseOver=\"javascript:MM_swapImage('Image" + this.j + "','','/images/icon_esx_unknown.gif',1)\">";
/*      */   }
/*      */   
/*      */   public String getDependentChildAttribs(String resid, String attributeId)
/*      */   {
/*  763 */     ResultSet set = null;
/*  764 */     AMConnectionPool cp = AMConnectionPool.getInstance();
/*  765 */     String dependentChildQry = "select ANYCONDITIONVALUE from AM_RCARULESMAPPER where RESOURCEID=" + resid + " and ATTRIBUTE=" + attributeId;
/*      */     try {
/*  767 */       set = AMConnectionPool.executeQueryStmt(dependentChildQry);
/*  768 */       if (set.next()) { String str1;
/*  769 */         if (set.getString("ANYCONDITIONVALUE").equals("-1")) {
/*  770 */           return FormatUtil.getString("am.fault.rcatree.allrule.text");
/*      */         }
/*      */         
/*  773 */         return FormatUtil.getString("am.fault.rcatree.anyrule.text", new String[] { set.getString("ANYCONDITIONVALUE") });
/*      */       }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  778 */       e.printStackTrace();
/*      */     }
/*      */     finally {
/*  781 */       AMConnectionPool.closeStatement(set);
/*      */     }
/*  783 */     return FormatUtil.getString("am.fault.rcatree.anyonerule.text");
/*      */   }
/*      */   
/*      */   public String getConfHealthRCA(String key) {
/*  787 */     StringBuffer rca = new StringBuffer();
/*  788 */     if ((key != null) && (key.indexOf("Root Cause :") != -1)) {
/*  789 */       key = key.substring(key.indexOf("Root Cause :") + 17, key.length());
/*      */     }
/*      */     
/*  792 */     int rcalength = key.length();
/*  793 */     String split = "6. ";
/*  794 */     int splitPresent = key.indexOf(split);
/*  795 */     String div1 = "";String div2 = "";
/*  796 */     if ((rcalength < 300) || (splitPresent < 0))
/*      */     {
/*  798 */       if (rcalength > 180) {
/*  799 */         rca.append("<span class=\"rca-critical-text\">");
/*  800 */         getRCATrimmedText(key, rca);
/*  801 */         rca.append("</span>");
/*      */       } else {
/*  803 */         rca.append("<span class=\"rca-critical-text\">");
/*  804 */         rca.append(key);
/*  805 */         rca.append("</span>");
/*      */       }
/*  807 */       return rca.toString();
/*      */     }
/*  809 */     div1 = key.substring(0, key.indexOf(split) - 4);
/*  810 */     div2 = key.substring(key.indexOf(split), rcalength - 4);
/*  811 */     rca.append("<div style='overflow: hidden; display: block; width: 100%; height: auto;'>");
/*  812 */     String rcaMesg = com.adventnet.utilities.stringutils.StrUtil.findReplace(div1, " --> ", "&nbsp;<img src=\"/images/img_arrow.gif\">&nbsp;");
/*  813 */     getRCATrimmedText(div1, rca);
/*  814 */     rca.append("<span id=\"confrcashow\" class=\"confrcashow\" onclick=\"javascript:toggleSlide('confrcahide','confrcashow','confrcahidden');\"><img src=\"/images/icon_plus.gif\" width=\"9\" height=\"7\"> " + FormatUtil.getString("am.webclient.monitorinformation.show.text") + " </span></div>");
/*      */     
/*      */ 
/*  817 */     rca.append("<div id='confrcahidden' style='display: none; width: 100%;'>");
/*  818 */     rcaMesg = com.adventnet.utilities.stringutils.StrUtil.findReplace(div2, " --> ", "&nbsp;<img src=\"/images/img_arrow.gif\">&nbsp;");
/*  819 */     getRCATrimmedText(div2, rca);
/*  820 */     rca.append("<span id=\"confrcahide\" class=\"confrcashow\" onclick=\"javascript:toggleSlide('confrcashow','confrcahide','confrcahidden')\"><img src=\"/images/icon_minus.gif\" width=\"9\" height=\"7\"> " + FormatUtil.getString("am.webclient.monitorinformation.hide.text") + " </span></div>");
/*      */     
/*  822 */     return rca.toString();
/*      */   }
/*      */   
/*      */   public void getRCATrimmedText(String msg, StringBuffer rca)
/*      */   {
/*  827 */     String[] st = msg.split("<br>");
/*  828 */     for (int i = 0; i < st.length; i++) {
/*  829 */       String s = st[i];
/*  830 */       if (s.length() > 180) {
/*  831 */         s = s.substring(0, 175) + ".....";
/*      */       }
/*  833 */       rca.append(s + "<br>");
/*      */     }
/*      */   }
/*      */   
/*  837 */   public String getConfHealthTime(String time) { if ((time != null) && (!time.trim().equals(""))) {
/*  838 */       return new Date(com.adventnet.appmanager.reporting.ReportUtilities.roundOffToNearestSeconds(Long.parseLong(time))).toString();
/*      */     }
/*  840 */     return "";
/*      */   }
/*      */   
/*      */   public String getHelpLink(String key) {
/*  844 */     String helpText = FormatUtil.getString("am.webclient.contexthelplink.text");
/*  845 */     ret = "<a href=\"/help/index.html\" title=\"" + helpText + "\" target=\"newwindow\" class=\"headerwhitelinks\" ><img src=\"/images/helpIcon.png\"/></a>";
/*  846 */     ResultSet set = null;
/*      */     try {
/*      */       String str1;
/*  849 */       if (key == null) {
/*  850 */         return ret;
/*      */       }
/*      */       
/*  853 */       if (com.adventnet.appmanager.util.DBUtil.searchLinks.containsKey(key)) {
/*  854 */         return "<a href=\"" + (String)com.adventnet.appmanager.util.DBUtil.searchLinks.get(key) + "\" title=\"" + helpText + "\" target=\"newwindow\" class=\"headerwhitelinks\" ><img src=\"/images/helpIcon.png\"/></a>";
/*      */       }
/*      */       
/*  857 */       String query = "select LINK from AM_SearchDocLinks where NAME ='" + key + "'";
/*  858 */       AMConnectionPool cp = AMConnectionPool.getInstance();
/*  859 */       set = AMConnectionPool.executeQueryStmt(query);
/*  860 */       if (set.next())
/*      */       {
/*  862 */         String helpLink = set.getString("LINK");
/*  863 */         com.adventnet.appmanager.util.DBUtil.searchLinks.put(key, helpLink);
/*      */         try
/*      */         {
/*  866 */           AMConnectionPool.closeStatement(set);
/*      */         }
/*      */         catch (Exception exc) {}
/*      */         
/*      */ 
/*      */ 
/*  872 */         return "<a href=\"" + helpLink + "\" title=\"" + helpText + "\" target=\"newwindow\" class=\"headerwhitelinks\" ><img src=\"/images/helpIcon.png\"/></a>";
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  891 */       return ret;
/*      */     }
/*      */     catch (Exception ex) {}finally
/*      */     {
/*      */       try
/*      */       {
/*  882 */         if (set != null) {
/*  883 */           AMConnectionPool.closeStatement(set);
/*      */         }
/*      */       }
/*      */       catch (Exception nullexc) {}
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Properties getStatus(List entitylist)
/*      */   {
/*  897 */     Properties temp = com.adventnet.appmanager.fault.FaultUtil.getStatus(entitylist, false);
/*  898 */     for (Enumeration keys = temp.propertyNames(); keys.hasMoreElements();)
/*      */     {
/*  900 */       String entityStr = (String)keys.nextElement();
/*  901 */       String mmessage = temp.getProperty(entityStr);
/*  902 */       mmessage = mmessage.replaceAll("\"", "&quot;");
/*  903 */       temp.setProperty(entityStr, mmessage);
/*      */     }
/*  905 */     return temp;
/*      */   }
/*      */   
/*      */ 
/*      */   public Properties getStatus(List listOfResourceIDs, List listOfAttributeIDs)
/*      */   {
/*  911 */     Properties temp = com.adventnet.appmanager.fault.FaultUtil.getStatus(listOfResourceIDs, listOfAttributeIDs);
/*  912 */     for (Enumeration keys = temp.propertyNames(); keys.hasMoreElements();)
/*      */     {
/*  914 */       String entityStr = (String)keys.nextElement();
/*  915 */       String mmessage = temp.getProperty(entityStr);
/*  916 */       mmessage = mmessage.replaceAll("\"", "&quot;");
/*  917 */       temp.setProperty(entityStr, mmessage);
/*      */     }
/*  919 */     return temp;
/*      */   }
/*      */   
/*      */   private void debug(String debugMessage)
/*      */   {
/*  924 */     AMLog.debug("JSP : " + debugMessage);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private String findReplace(String str, String find, String replace)
/*      */   {
/*  934 */     String des = new String();
/*  935 */     while (str.indexOf(find) != -1) {
/*  936 */       des = des + str.substring(0, str.indexOf(find));
/*  937 */       des = des + replace;
/*  938 */       str = str.substring(str.indexOf(find) + find.length());
/*      */     }
/*  940 */     des = des + str;
/*  941 */     return des;
/*      */   }
/*      */   
/*      */   private String getHideAndShowRCAMessage(String test, String id, String alert, String resourceid)
/*      */   {
/*      */     try
/*      */     {
/*  948 */       if (alert == null)
/*      */       {
/*  950 */         return "&nbsp;&nbsp;" + FormatUtil.getString("am.webclient.rcamessage.healthunknown.text");
/*      */       }
/*  952 */       if ((test == null) || (test.equals("")))
/*      */       {
/*  954 */         return "&nbsp;";
/*      */       }
/*      */       
/*  957 */       if ((alert != null) && (alert.equals("5")))
/*      */       {
/*  959 */         return "&nbsp;&nbsp;" + FormatUtil.getString("am.fault.rca.healthisclear.text") + ".&nbsp;" + FormatUtil.getString("am.webclient.nocriticalalarms.current.text");
/*      */       }
/*      */       
/*  962 */       int rcalength = test.length();
/*  963 */       if (rcalength < 300)
/*      */       {
/*  965 */         return test;
/*      */       }
/*      */       
/*      */ 
/*  969 */       StringBuffer out = new StringBuffer();
/*  970 */       out.append("<div id='rcahidden' style='overflow: hidden; display: block; word-wrap: break-word; width: 500px; height: 100px'>");
/*  971 */       out.append(com.adventnet.utilities.stringutils.StrUtil.findReplace(test, " --> ", "&nbsp;<img src=\"/images/img_arrow.gif\">&nbsp;"));
/*  972 */       out.append("</div>");
/*  973 */       out.append("<div align=\"right\" id=\"rcashow" + id + "\" style=\"display:block;\" onclick=\"javascript:document.getElementById('rcahidden').style.height='auto';hideDiv('rcashow" + id + "');showDiv('rcahide" + id + "');\"><span class=\"bcactive\"><img src=\"/images/icon_plus.gif\" width=\"9\" height=\"9\"> " + FormatUtil.getString("am.webclient.monitorinformation.show.text") + " </span> </div>");
/*  974 */       out.append("<div align=\"right\" id=\"rcahide" + id + "\" style=\"display:none;\" onclick=\"javascript:document.getElementById('rcahidden').style.height='100px',hideDiv('rcahide" + id + "');showDiv('rcashow" + id + "')\"><span class=\"bcactive\"><img src=\"/images/icon_minus.gif\" width=\"9\" height=\"9\"> " + FormatUtil.getString("am.webclient.monitorinformation.hide.text") + " </span> </div>");
/*  975 */       return out.toString();
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  980 */       ex.printStackTrace();
/*      */     }
/*  982 */     return test;
/*      */   }
/*      */   
/*      */ 
/*      */   public Properties getAlerts(List monitorList, Hashtable availabilitykeys, Hashtable healthkeys)
/*      */   {
/*  988 */     return getAlerts(monitorList, availabilitykeys, healthkeys, 1);
/*      */   }
/*      */   
/*      */   public Properties getAlerts(List monitorList, Hashtable availabilitykeys, Hashtable healthkeys, int type)
/*      */   {
/*  993 */     ArrayList attribIDs = new ArrayList();
/*  994 */     ArrayList resIDs = new ArrayList();
/*  995 */     ArrayList entitylist = new ArrayList();
/*      */     
/*  997 */     for (int j = 0; (monitorList != null) && (j < monitorList.size()); j++)
/*      */     {
/*  999 */       ArrayList row = (ArrayList)monitorList.get(j);
/*      */       
/* 1001 */       String resourceid = "";
/* 1002 */       String resourceType = "";
/* 1003 */       if (type == 2) {
/* 1004 */         resourceid = (String)row.get(0);
/* 1005 */         resourceType = (String)row.get(3);
/*      */       }
/* 1007 */       else if (type == 3) {
/* 1008 */         resourceid = (String)row.get(0);
/* 1009 */         resourceType = "EC2Instance";
/*      */       }
/*      */       else {
/* 1012 */         resourceid = (String)row.get(6);
/* 1013 */         resourceType = (String)row.get(7);
/*      */       }
/* 1015 */       resIDs.add(resourceid);
/* 1016 */       String healthid = com.adventnet.appmanager.dbcache.AMAttributesCache.getHealthId(resourceType);
/* 1017 */       String availid = com.adventnet.appmanager.dbcache.AMAttributesCache.getAvailabilityId(resourceType);
/*      */       
/* 1019 */       String healthentity = null;
/* 1020 */       String availentity = null;
/* 1021 */       if (healthid != null) {
/* 1022 */         healthentity = resourceid + "_" + healthid;
/* 1023 */         entitylist.add(healthentity);
/*      */       }
/*      */       
/* 1026 */       if (availid != null) {
/* 1027 */         availentity = resourceid + "_" + availid;
/* 1028 */         entitylist.add(availentity);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1042 */     Properties alert = getStatus(entitylist);
/* 1043 */     return alert;
/*      */   }
/*      */   
/*      */   public void getSortedMonitorList(ArrayList monitorList, Properties alert, Hashtable availabilitykeys, Hashtable healthkeys)
/*      */   {
/* 1048 */     int size = monitorList.size();
/*      */     
/* 1050 */     String[] severity = new String[size];
/*      */     
/* 1052 */     for (int j = 0; j < monitorList.size(); j++)
/*      */     {
/* 1054 */       ArrayList row1 = (ArrayList)monitorList.get(j);
/* 1055 */       String resourceName1 = (String)row1.get(7);
/* 1056 */       String resourceid1 = (String)row1.get(6);
/* 1057 */       severity[j] = alert.getProperty(resourceid1 + "#" + availabilitykeys.get(resourceName1));
/* 1058 */       if (severity[j] == null)
/*      */       {
/* 1060 */         severity[j] = "6";
/*      */       }
/*      */     }
/*      */     
/* 1064 */     for (j = 0; j < severity.length; j++)
/*      */     {
/* 1066 */       for (int k = j + 1; k < severity.length; k++)
/*      */       {
/* 1068 */         int sev = severity[j].compareTo(severity[k]);
/*      */         
/*      */ 
/* 1071 */         if (sev > 0) {
/* 1072 */           ArrayList t = (ArrayList)monitorList.get(k);
/* 1073 */           monitorList.set(k, monitorList.get(j));
/* 1074 */           monitorList.set(j, t);
/* 1075 */           String temp = severity[k];
/* 1076 */           severity[k] = severity[j];
/* 1077 */           severity[j] = temp;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1083 */     int z = 0;
/* 1084 */     for (j = 0; j < monitorList.size(); j++)
/*      */     {
/*      */ 
/* 1087 */       int i = 0;
/* 1088 */       if ((!severity[j].equals("0")) && (!severity[j].equals("1")) && (!severity[j].equals("4")))
/*      */       {
/*      */ 
/* 1091 */         i++;
/*      */       }
/*      */       else
/*      */       {
/* 1095 */         z++;
/*      */       }
/*      */     }
/*      */     
/* 1099 */     String[] hseverity = new String[monitorList.size()];
/*      */     
/* 1101 */     for (j = 0; j < z; j++)
/*      */     {
/*      */ 
/* 1104 */       hseverity[j] = severity[j];
/*      */     }
/*      */     
/*      */ 
/* 1108 */     for (j = z; j < severity.length; j++)
/*      */     {
/*      */ 
/* 1111 */       ArrayList row1 = (ArrayList)monitorList.get(j);
/* 1112 */       String resourceName1 = (String)row1.get(7);
/* 1113 */       String resourceid1 = (String)row1.get(6);
/* 1114 */       hseverity[j] = alert.getProperty(resourceid1 + "#" + healthkeys.get(resourceName1));
/* 1115 */       if (hseverity[j] == null)
/*      */       {
/* 1117 */         hseverity[j] = "6";
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1122 */     for (j = 0; j < hseverity.length; j++)
/*      */     {
/* 1124 */       for (int k = j + 1; k < hseverity.length; k++)
/*      */       {
/*      */ 
/* 1127 */         int hsev = hseverity[j].compareTo(hseverity[k]);
/*      */         
/*      */ 
/* 1130 */         if (hsev > 0) {
/* 1131 */           ArrayList t = (ArrayList)monitorList.get(k);
/* 1132 */           monitorList.set(k, monitorList.get(j));
/* 1133 */           monitorList.set(j, t);
/* 1134 */           String temp1 = hseverity[k];
/* 1135 */           hseverity[k] = hseverity[j];
/* 1136 */           hseverity[j] = temp1;
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getAllChildNodestoDisplay(ArrayList singlechilmos, String resIdTOCheck, String currentresourceidtree, Hashtable childmos, Hashtable availhealth, int level, HttpServletRequest request, HashMap extDeviceMap, HashMap site24x7List)
/*      */   {
/* 1148 */     boolean isIt360 = com.adventnet.appmanager.util.Constants.isIt360;
/* 1149 */     boolean forInventory = false;
/* 1150 */     String trdisplay = "none";
/* 1151 */     String plusstyle = "inline";
/* 1152 */     String minusstyle = "none";
/* 1153 */     String haidTopLevel = "";
/* 1154 */     if (request.getAttribute("forInventory") != null)
/*      */     {
/* 1156 */       if ("true".equals((String)request.getAttribute("forInventory")))
/*      */       {
/* 1158 */         haidTopLevel = request.getParameter("haid");
/* 1159 */         forInventory = true;
/* 1160 */         trdisplay = "table-row;";
/* 1161 */         plusstyle = "none";
/* 1162 */         minusstyle = "inline";
/*      */       }
/*      */       
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 1169 */       haidTopLevel = resIdTOCheck;
/*      */     }
/*      */     
/* 1172 */     ArrayList listtoreturn = new ArrayList();
/* 1173 */     StringBuffer toreturn = new StringBuffer();
/* 1174 */     Hashtable availabilitykeys = (Hashtable)availhealth.get("avail");
/* 1175 */     Hashtable healthkeys = (Hashtable)availhealth.get("health");
/* 1176 */     Properties alert = (Properties)availhealth.get("alert");
/*      */     
/* 1178 */     for (int j = 0; j < singlechilmos.size(); j++)
/*      */     {
/* 1180 */       ArrayList singlerow = (ArrayList)singlechilmos.get(j);
/* 1181 */       String childresid = (String)singlerow.get(0);
/* 1182 */       String childresname = (String)singlerow.get(1);
/* 1183 */       childresname = com.adventnet.appmanager.util.ExtProdUtil.decodeString(childresname);
/* 1184 */       String childtype = ((String)singlerow.get(2) + "").trim();
/* 1185 */       String imagepath = ((String)singlerow.get(3) + "").trim();
/* 1186 */       String shortname = ((String)singlerow.get(4) + "").trim();
/* 1187 */       String unmanagestatus = (String)singlerow.get(5);
/* 1188 */       String actionstatus = (String)singlerow.get(6);
/* 1189 */       String linkclass = "monitorgp-links";
/* 1190 */       String titleforres = childresname;
/* 1191 */       String titilechildresname = childresname;
/* 1192 */       String childimg = "/images/trcont.png";
/* 1193 */       String flag = "enable";
/* 1194 */       String dcstarted = (String)singlerow.get(8);
/* 1195 */       String configMonitor = "";
/* 1196 */       String configmsg = FormatUtil.getString("am.webclient.vcenter.esx.notconfigured.text");
/* 1197 */       if (("VMWare ESX/ESXi".equals(childtype)) && (!"2".equals(dcstarted)))
/*      */       {
/* 1199 */         configMonitor = "&nbsp;&nbsp;<img src='/images/icon_ack.gif' align='absmiddle' style='width=16px;heigth:16px' border='0' title='" + configmsg + "' />";
/*      */       }
/* 1201 */       if (singlerow.get(7) != null)
/*      */       {
/* 1203 */         flag = (String)singlerow.get(7);
/*      */       }
/* 1205 */       String haiGroupType = "0";
/* 1206 */       if ("HAI".equals(childtype))
/*      */       {
/* 1208 */         haiGroupType = (String)singlerow.get(9);
/*      */       }
/* 1210 */       childimg = "/images/trend.png";
/* 1211 */       String actionmsg = FormatUtil.getString("Actions Enabled");
/* 1212 */       String actionimg = "<img src=\"/images/alarm-icon.png\" border=\"0\"  title=\"" + actionmsg + "\"  />";
/* 1213 */       if ((actionstatus == null) || (actionstatus.equalsIgnoreCase("null")) || (actionstatus.equals("1")))
/*      */       {
/* 1215 */         actionimg = "<img src=\"/images/alarm-icon.png\" border=\"0\" title=\"" + actionmsg + "\" />";
/*      */       }
/* 1217 */       else if (actionstatus.equals("0"))
/*      */       {
/* 1219 */         actionmsg = FormatUtil.getString("Actions Disabled");
/* 1220 */         actionimg = "<img src=\"/images/icon_actions_disabled.gif\" border=\"0\"   title=\"" + actionmsg + "\" />";
/*      */       }
/*      */       
/* 1223 */       if ((unmanagestatus != null) && (!unmanagestatus.trim().equalsIgnoreCase("null")))
/*      */       {
/* 1225 */         linkclass = "disabledtext";
/* 1226 */         titleforres = titleforres + "-UnManaged";
/*      */       }
/* 1228 */       String availkey = childresid + "#" + availabilitykeys.get(childtype) + "#" + "MESSAGE";
/* 1229 */       String availmouseover = "";
/* 1230 */       if (alert.getProperty(availkey) != null)
/*      */       {
/* 1232 */         availmouseover = "onmouseover=\"ddrivetip(this,event,'" + alert.getProperty(availkey).replace("\"", "&quot;") + "<br><span style=color: #000000;font-weight:bold;>" + FormatUtil.getString("am.webclient.tooltip.text") + "</span>',null,true,'#000000')\"  onmouseout=\"hideddrivetip()\" ";
/*      */       }
/* 1234 */       String healthkey = childresid + "#" + healthkeys.get(childtype) + "#" + "MESSAGE";
/* 1235 */       String healthmouseover = "";
/* 1236 */       if (alert.getProperty(healthkey) != null)
/*      */       {
/* 1238 */         healthmouseover = "onmouseover=\"ddrivetip(this,event,'" + alert.getProperty(healthkey).replace("\"", "&quot;") + "<br><span style=color: #000000;font-weight:bold;>" + FormatUtil.getString("am.webclient.tooltip.text") + "</span>',null,true,'#000000')\"  onmouseout=\"hideddrivetip()\" ";
/*      */       }
/*      */       
/* 1241 */       String tempbgcolor = "class=\"whitegrayrightalign\"";
/* 1242 */       int spacing = 0;
/* 1243 */       if (level >= 1)
/*      */       {
/* 1245 */         spacing = 40 * level;
/*      */       }
/* 1247 */       if (childtype.equals("HAI"))
/*      */       {
/* 1249 */         ArrayList singlechilmos1 = (ArrayList)childmos.get(childresid + "");
/* 1250 */         String tempresourceidtree = currentresourceidtree + "|" + childresid;
/* 1251 */         String availimage = getSeverityImageForAvailability(alert.getProperty(childresid + "#" + availabilitykeys.get(childtype)));
/*      */         
/* 1253 */         String availlink = "<a href=\"javascript:void(0);\" " + availmouseover + " onClick=\"fnOpenNewWindow('/jsp/RCA.jsp?resourceid=" + childresid + "&attributeid=" + availabilitykeys.get(childtype) + "')\"> " + availimage + "</a>";
/* 1254 */         String healthimage = getSeverityImageForHealth(alert.getProperty(childresid + "#" + healthkeys.get(childtype)));
/* 1255 */         String healthlink = "<a href=\"javascript:void(0);\" " + healthmouseover + " onClick=\"fnOpenNewWindow('/jsp/RCA.jsp?resourceid=" + childresid + "&attributeid=" + healthkeys.get(childtype) + "')\"> " + healthimage + "</a>";
/* 1256 */         String editlink = "<a href=\"/showapplication.do?method=editApplication&fromwhere=allmonitorgroups&haid=" + childresid + "\" class=\"staticlinks\" title=\"" + FormatUtil.getString("am.webclient.maintenance.edit") + "\"><img align=\"center\" src=\"/images/icon_edit.gif\" border=\"0\" /></a>";
/* 1257 */         String imglink = "<img src=\"" + childimg + "\" align=\"center\"    align=\"left\" border=\"0\" height=\"24\" width=\"24\">";
/* 1258 */         String checkbox = "<input type=\"checkbox\" name=\"select\" id=\"" + tempresourceidtree + "\" value=\"" + childresid + "\"  onclick=\"selectAllChildCKbs('" + tempresourceidtree + "',this,this.form),deselectParentCKbs('" + tempresourceidtree + "',this,this.form)\"  >";
/* 1259 */         String thresholdurl = "/showActionProfiles.do?method=getHAProfiles&haid=" + childresid;
/* 1260 */         String configalertslink = " <a title='" + FormatUtil.getString("am.webclient.common.util.ALERTCONFIG_TEXT") + "' href=\"" + thresholdurl + "\" ><img src=\"images/icon_associateaction.gif\" align=\"center\" border=\"0\" title=\"" + FormatUtil.getString("am.webclient.common.util.ALERTCONFIG_TEXT") + "\" /></a>";
/* 1261 */         String associatelink = "<a href=\"/showresource.do?method=getMonitorForm&type=All&fromwhere=monitorgroupview&haid=" + childresid + "\" title=\"" + FormatUtil.getString("am.webclient.monitorgroupdetails.associatemonitors.text") + "\" ><img align=\"center\" src=\"images/icon_assoicatemonitors.gif\" border=\"0\" /></a>";
/* 1262 */         String removefromgroup = "<a class='staticlinks' href=\"javascript: removeMonitorFromGroup ('" + resIdTOCheck + "','" + childresid + "','" + haidTopLevel + "');\" title='" + FormatUtil.getString("am.webclient.monitorgroupdetails.remove.text") + "'><img width='13' align=\"center\"  height='14' border='0' src='/images/icon_removefromgroup.gif'/></a>&nbsp;&nbsp;";
/* 1263 */         String configcustomfields = "<a href=\"javascript:void(0)\" onclick=\"fnOpenNewWindow('/jsp/MyField_Alarms.jsp?resourceid=" + childresid + "&mgview=true')\" title='" + FormatUtil.getString("am.myfield.assign.text") + "'><img align=\"center\" src=\"/images/icon_assigncustomfields.gif\" border=\"0\" /></a>";
/*      */         
/* 1265 */         if (!forInventory)
/*      */         {
/* 1267 */           removefromgroup = "";
/*      */         }
/*      */         
/* 1270 */         String actions = "&nbsp;&nbsp;" + configalertslink + "&nbsp;&nbsp;" + removefromgroup + "&nbsp;&nbsp;";
/*      */         
/* 1272 */         if ((haiGroupType == null) || ((haiGroupType != null) && (!"1009".equals(haiGroupType)) && (!"1010".equals(haiGroupType)) && (!"1012".equals(haiGroupType))))
/*      */         {
/* 1274 */           actions = editlink + actions;
/*      */         }
/* 1276 */         if ((haiGroupType == null) || ((haiGroupType != null) && (!"1009".equals(haiGroupType)) && (!"1010".equals(haiGroupType)) && (!"3".equals(haiGroupType)) && (!"1012".equals(haiGroupType))))
/*      */         {
/* 1278 */           actions = actions + associatelink;
/*      */         }
/* 1280 */         actions = actions + "&nbsp;&nbsp;&nbsp;&nbsp;" + configcustomfields;
/* 1281 */         String arrowimg = "";
/* 1282 */         if (request.isUserInRole("ENTERPRISEADMIN"))
/*      */         {
/* 1284 */           actions = "";
/* 1285 */           arrowimg = "<img align=\"center\" hspace=\"3\" border=\"0\" src=\"/images/icon_arrow_childattribute_grey.gif\"/>";
/* 1286 */           checkbox = "";
/* 1287 */           childresname = childresname + "_" + com.adventnet.appmanager.server.framework.comm.CommDBUtil.getManagedServerNameWithPort(childresid);
/*      */         }
/* 1289 */         if (isIt360)
/*      */         {
/* 1291 */           actionimg = "";
/* 1292 */           actions = "";
/* 1293 */           arrowimg = "<img align=\"center\" hspace=\"3\" border=\"0\" src=\"/images/icon_arrow_childattribute_grey.gif\"/>";
/* 1294 */           checkbox = "";
/*      */         }
/*      */         
/* 1297 */         if (!request.isUserInRole("ADMIN"))
/*      */         {
/* 1299 */           actions = "";
/*      */         }
/* 1301 */         if (request.isUserInRole("OPERATOR"))
/*      */         {
/* 1303 */           checkbox = "";
/*      */         }
/*      */         
/* 1306 */         String resourcelink = "";
/*      */         
/* 1308 */         if ((flag != null) && (flag.equals("enable")))
/*      */         {
/* 1310 */           resourcelink = "<a href=\"javascript:void(0);\" onclick=\"toggleChildMos('#monitor" + tempresourceidtree + "'),toggleTreeImage('" + tempresourceidtree + "');\"><div id=\"monitorShow" + tempresourceidtree + "\" style=\"display:" + plusstyle + ";\"><img src=\"/images/icon_plus.gif\" border=\"0\" hspace=\"5\"></div><div id=\"monitorHide" + tempresourceidtree + "\" style=\"display:" + minusstyle + ";\"><img src=\"/images/icon_minus.gif\" border=\"0\" hspace=\"5\"></div> </a>" + checkbox + "<a href=\"/showapplication.do?haid=" + childresid + "&method=showApplication\" class=\"" + linkclass + "\">" + getTrimmedText(titilechildresname, 45) + "</a> ";
/*      */         }
/*      */         else
/*      */         {
/* 1314 */           resourcelink = "<a href=\"javascript:void(0);\" onclick=\"toggleChildMos('#monitor" + tempresourceidtree + "'),toggleTreeImage('" + tempresourceidtree + "');\"><div id=\"monitorShow" + tempresourceidtree + "\" style=\"display:" + plusstyle + ";\"><img src=\"/images/icon_plus.gif\" border=\"0\" hspace=\"5\"></div><div id=\"monitorHide" + tempresourceidtree + "\" style=\"display:" + minusstyle + ";\"><img src=\"/images/icon_minus.gif\" border=\"0\" hspace=\"5\"></div> </a>" + checkbox + "" + getTrimmedText(titilechildresname, 45);
/*      */         }
/*      */         
/* 1317 */         toreturn.append("<tr " + tempbgcolor + " id=\"#monitor" + currentresourceidtree + "\" style=\"display:" + trdisplay + ";\" width='100%'>");
/* 1318 */         toreturn.append("<td " + tempbgcolor + " width=\"3%\" >&nbsp;</td> ");
/* 1319 */         toreturn.append("<td " + tempbgcolor + " width=\"47%\"  style=\"padding-left: " + spacing + "px !important;\" title=" + childresname + ">" + arrowimg + resourcelink + "</td>");
/* 1320 */         toreturn.append("<td " + tempbgcolor + " width=\"15%\" align=\"left\">" + "<table><tr class='whitegrayrightalign'><td><div id='mgaction'>" + actions + "</div></td></tr></table></td>");
/* 1321 */         toreturn.append("<td " + tempbgcolor + " width=\"8%\" align=\"center\">" + availlink + "</td>");
/* 1322 */         toreturn.append("<td " + tempbgcolor + " width=\"7%\" align=\"center\">" + healthlink + "</td>");
/* 1323 */         if (!isIt360)
/*      */         {
/* 1325 */           toreturn.append("<td " + tempbgcolor + " width=\"7%\" align=\"left\">" + actionimg + "</td>");
/*      */         }
/*      */         else
/*      */         {
/* 1329 */           toreturn.append("<td " + tempbgcolor + " width=\"7%\" align=\"left\">&nbsp;</td>");
/*      */         }
/*      */         
/* 1332 */         toreturn.append("</tr>");
/* 1333 */         if (childmos.get(childresid + "") != null)
/*      */         {
/* 1335 */           String toappend = getAllChildNodestoDisplay(singlechilmos1, childresid + "", tempresourceidtree, childmos, availhealth, level + 1, request, extDeviceMap, site24x7List);
/* 1336 */           toreturn.append(toappend);
/*      */         }
/*      */         else
/*      */         {
/* 1340 */           String assocMessage = "<td  " + tempbgcolor + " colspan=\"2\"><span class=\"bodytext\" style=\"padding-left: " + (spacing + 10) + "px !important;\"> &nbsp;&nbsp;&nbsp;&nbsp;" + FormatUtil.getString("am.webclient.monitorgroupdetails.nomonitormessage.text") + "</span><span class=\"bodytext\">";
/* 1341 */           if ((!request.isUserInRole("ENTERPRISEADMIN")) && (!request.isUserInRole("DEMO")) && (!request.isUserInRole("OPERATOR")))
/*      */           {
/*      */ 
/* 1344 */             assocMessage = assocMessage + FormatUtil.getString("am.webclient.monitorgroupdetails.click.text") + " <a href=\"/showresource.do?method=getMonitorForm&type=All&haid=" + childresid + "&fromwhere=monitorgroupview\" class=\"staticlinks\" >" + FormatUtil.getString("am.webclient.monitorgroupdetails.linktoadd.text") + "</span></td>";
/*      */           }
/*      */           
/*      */ 
/* 1348 */           if ((haiGroupType == null) || ((haiGroupType != null) && (!"1009".equals(haiGroupType)) && (!"1010".equals(haiGroupType)) && (!"3".equals(haiGroupType)) && (!"1012".equals(haiGroupType))))
/*      */           {
/* 1350 */             toreturn.append("<tr  " + tempbgcolor + "  id=\"#monitor" + tempresourceidtree + "\" style=\"display: " + trdisplay + ";\" width='100%'>");
/* 1351 */             toreturn.append("<td  " + tempbgcolor + "  width=\"3%\" >&nbsp;</td> ");
/* 1352 */             toreturn.append(assocMessage);
/* 1353 */             toreturn.append("<td  " + tempbgcolor + "  >&nbsp;</td> ");
/* 1354 */             toreturn.append("<td  " + tempbgcolor + "  >&nbsp;</td> ");
/* 1355 */             toreturn.append("<td  " + tempbgcolor + "  >&nbsp;</td> ");
/* 1356 */             toreturn.append("</tr>");
/*      */           }
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1362 */         String resourcelink = null;
/* 1363 */         boolean hideEditLink = false;
/* 1364 */         if ((extDeviceMap != null) && (extDeviceMap.get(childresid) != null))
/*      */         {
/* 1366 */           String link1 = (String)extDeviceMap.get(childresid);
/* 1367 */           hideEditLink = true;
/* 1368 */           if (isIt360)
/*      */           {
/* 1370 */             resourcelink = "<a href=" + link1 + "  class=\"" + linkclass + "\" title=\"" + titleforres + "\">" + getTrimmedText(childresname, 45) + "</a>";
/*      */           }
/*      */           else
/*      */           {
/* 1374 */             resourcelink = "<a href=\"javascript:MM_openBrWindow('" + link1 + "','ExternalDevice','width=950,height=600,top=50,left=75,scrollbars=yes,resizable=yes')\" class=\"" + linkclass + "\" title=\"" + titleforres + "\">" + getTrimmedText(childresname, 45) + "</a>";
/*      */           }
/* 1376 */         } else if ((site24x7List != null) && (site24x7List.containsKey(childresid)))
/*      */         {
/* 1378 */           hideEditLink = true;
/* 1379 */           String link2 = URLEncoder.encode((String)site24x7List.get(childresid));
/* 1380 */           resourcelink = "<a href=\"javascript:MM_openBrWindow('" + link2 + "','Site24x7','width=950,height=600,top=50,left=75,scrollbars=yes,resizable=yes')\" class=\"" + linkclass + "\" title=\"" + titleforres + "\">" + getTrimmedText(childresname, 45) + "</a>";
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/* 1385 */           resourcelink = "<a href=\"/showresource.do?resourceid=" + childresid + "&method=showResourceForResourceID&haid=" + resIdTOCheck + "\" class=\"" + linkclass + "\" title=\"" + titleforres + "\">" + getTrimmedText(childresname, 45) + "</a>";
/*      */         }
/*      */         
/* 1388 */         String imglink = "<img src=\"" + childimg + "\"  align=\"left\" border=\"0\" height=\"24\" width=\"24\"  />";
/* 1389 */         String checkbox = "<input type=\"checkbox\" name=\"select\" id=\"" + currentresourceidtree + "|" + childresid + "\"  value=\"" + childresid + "\"  onclick=\"deselectParentCKbs('" + currentresourceidtree + "|" + childresid + "',this,this.form);\" >";
/* 1390 */         String key = childresid + "#" + availabilitykeys.get(childtype) + "#" + "MESSAGE";
/* 1391 */         String availimage = getSeverityImageForAvailability(alert.getProperty(childresid + "#" + availabilitykeys.get(childtype)));
/* 1392 */         String healthimage = getSeverityImageForHealth(alert.getProperty(childresid + "#" + healthkeys.get(childtype)));
/* 1393 */         String availlink = "<a href=\"javascript:void(0);\" " + availmouseover + "onClick=\"fnOpenNewWindow('/jsp/RCA.jsp?resourceid=" + childresid + "&attributeid=" + availabilitykeys.get(childtype) + "')\"> " + availimage + "</a>";
/* 1394 */         String healthlink = "<a href=\"javascript:void(0);\" " + healthmouseover + " onClick=\"fnOpenNewWindow('/jsp/RCA.jsp?resourceid=" + childresid + "&attributeid=" + healthkeys.get(childtype) + "')\"> " + healthimage + "</a>";
/* 1395 */         String editlink = "<a href=\"/showresource.do?haid=" + resIdTOCheck + "&resourceid=" + childresid + "&resourcename=" + childresname + "&type=" + childtype + "&method=showdetails&editPage=true&moname=" + childresname + "\" class=\"staticlinks\" title=\"" + FormatUtil.getString("am.webclient.maintenance.edit") + "\"><img align=\"center\" src=\"/images/icon_edit.gif\" border=\"0\" /></a>";
/* 1396 */         String thresholdurl = "/showActionProfiles.do?method=getResourceProfiles&admin=true&all=true&resourceid=" + childresid;
/* 1397 */         String configalertslink = " <a href=\"" + thresholdurl + "\" title='" + FormatUtil.getString("am.webclient.common.util.ALERTCONFIG_TEXT") + "'><img src=\"images/icon_associateaction.gif\" align=\"center\" border=\"0\" /></a>";
/* 1398 */         String img2 = "<img src=\"/images/trvline.png\" align=\"absmiddle\" border=\"0\" height=\"15\" width=\"15\"/>";
/* 1399 */         String removefromgroup = "<a class='staticlinks' href=\"javascript: removeMonitorFromGroup ('" + resIdTOCheck + "','" + childresid + "','" + haidTopLevel + "');\" title='" + FormatUtil.getString("am.webclient.monitorgroupdetails.remove.text") + "'><img width='13' align=\"center\"  height='14' border='0' src='/images/icon_removefromgroup.gif'/></a>";
/* 1400 */         String configcustomfields = "<a href=\"javascript:void(0)\" onclick=\"fnOpenNewWindow('/jsp/MyField_Alarms.jsp?resourceid=" + childresid + "&mgview=true')\" title='" + FormatUtil.getString("am.myfield.assign.text") + "'><img align=\"center\" src=\"/images/icon_assigncustomfields.gif\" border=\"0\" /></a>";
/*      */         
/* 1402 */         if (hideEditLink)
/*      */         {
/* 1404 */           editlink = "&nbsp;&nbsp;&nbsp;";
/*      */         }
/* 1406 */         if (!forInventory)
/*      */         {
/* 1408 */           removefromgroup = "";
/*      */         }
/* 1410 */         String actions = "&nbsp;&nbsp;" + configalertslink + "&nbsp;&nbsp;" + removefromgroup + "&nbsp;&nbsp;";
/* 1411 */         if (!com.adventnet.appmanager.util.Constants.sqlManager) {
/* 1412 */           actions = actions + configcustomfields;
/*      */         }
/* 1414 */         if ((haiGroupType == null) || ((haiGroupType != null) && (!"1009".equals(haiGroupType)) && (!"1010".equals(haiGroupType)) && (!"1012".equals(haiGroupType))))
/*      */         {
/* 1416 */           actions = editlink + actions;
/*      */         }
/* 1418 */         String managedLink = "";
/* 1419 */         if ((request.isUserInRole("ENTERPRISEADMIN")) && (!com.adventnet.appmanager.util.Constants.isIt360))
/*      */         {
/* 1421 */           checkbox = "<img hspace=\"3\" border=\"0\" src=\"/images/icon_arrow_childattribute_grey.gif\"/>";
/* 1422 */           actions = "";
/* 1423 */           if (Integer.parseInt(childresid) >= com.adventnet.appmanager.server.framework.comm.Constants.RANGE) {
/* 1424 */             managedLink = "&nbsp; <a target=\"mas_window\" href=\"/showresource.do?resourceid=" + childresid + "&type=" + childtype + "&moname=" + URLEncoder.encode(childresname) + "&resourcename=" + URLEncoder.encode(childresname) + "&method=showdetails&aam_jump=true&useHTTP=" + (!isIt360) + "\"><img border=\"0\" title=\"View Monitor details in Managed Server console\" src=\"/images/jump.gif\"/></a>";
/*      */           }
/*      */         }
/* 1427 */         if ((isIt360) || (request.isUserInRole("OPERATOR")))
/*      */         {
/* 1429 */           checkbox = "";
/*      */         }
/*      */         
/* 1432 */         if (!request.isUserInRole("ADMIN"))
/*      */         {
/* 1434 */           actions = "";
/*      */         }
/* 1436 */         toreturn.append("<tr " + tempbgcolor + " id=\"#monitor" + currentresourceidtree + "\" style=\"display: " + trdisplay + ";\" width='100%'>");
/* 1437 */         toreturn.append("<td " + tempbgcolor + " width=\"3%\"  >&nbsp;</td> ");
/* 1438 */         toreturn.append("<td " + tempbgcolor + " width=\"47%\" nowrap=\"false\" style=\"padding-left: " + spacing + "px !important;\" >" + checkbox + "&nbsp;<img align='absmiddle' border=\"0\"  title='" + shortname + "' src=\"" + imagepath + "\"/>&nbsp;" + resourcelink + managedLink + configMonitor + "</td>");
/* 1439 */         if (isIt360)
/*      */         {
/* 1441 */           toreturn.append("<td " + tempbgcolor + " width=\"15%\" align=\"left\">&nbsp;</td>");
/*      */         }
/*      */         else
/*      */         {
/* 1445 */           toreturn.append("<td " + tempbgcolor + " width=\"15%\" align=\"left\">" + "<table><tr class='whitegrayrightalign'><td><div id='mgaction'>" + actions + "</div></td></tr></table></td>");
/*      */         }
/* 1447 */         toreturn.append("<td " + tempbgcolor + " width=\"8%\" align=\"center\">" + availlink + "</td>");
/* 1448 */         toreturn.append("<td " + tempbgcolor + " width=\"7%\" align=\"center\">" + healthlink + "</td>");
/* 1449 */         if (!isIt360)
/*      */         {
/* 1451 */           toreturn.append("<td " + tempbgcolor + " width=\"7%\" align=\"left\">" + actionimg + "</td>");
/*      */         }
/*      */         else
/*      */         {
/* 1455 */           toreturn.append("<td " + tempbgcolor + " width=\"7%\" align=\"left\">&nbsp;</td>");
/*      */         }
/* 1457 */         toreturn.append("</tr>");
/*      */       }
/*      */     }
/* 1460 */     return toreturn.toString();
/*      */   }
/*      */   
/*      */   public String getSeverityImageForHealthWithLink(Properties alert, String resourceid, String healthid)
/*      */   {
/*      */     try
/*      */     {
/* 1467 */       StringBuilder toreturn = new StringBuilder();
/* 1468 */       String severity = alert.getProperty(resourceid + "#" + healthid);
/* 1469 */       String v = "<script>var v = '<span style=\"color: #000000;font-weight:bold;\">';</script>";
/* 1470 */       String message = alert.getProperty(resourceid + "#" + healthid + "#" + "MESSAGE");
/* 1471 */       String title = "";
/* 1472 */       message = EnterpriseUtil.decodeString(message);
/* 1473 */       message = FormatUtil.findReplace(message, "'", "\\'");
/* 1474 */       message = FormatUtil.findReplace(message, "\"", "&quot;");
/* 1475 */       if (("1".equals(severity)) || ("4".equals(severity)))
/*      */       {
/* 1477 */         title = " onmouseover=\"ddrivetip(this,event,'" + message + "<br>'+v+'" + FormatUtil.getString("am.webclient.tooltip.text") + "</span>',null,true,'#000000')\" onmouseout='hideddrivetip()'";
/*      */       }
/* 1479 */       else if ("5".equals(severity))
/*      */       {
/* 1481 */         title = "title='" + FormatUtil.getString("am.fault.rca.healthisclear.text") + "'";
/*      */       }
/*      */       else
/*      */       {
/* 1485 */         title = "title='" + FormatUtil.getString("am.webclient.rcamessage.healthunknown.text") + "'";
/*      */       }
/* 1487 */       String link = "<a href='javascript:void(0)' " + title + " onClick=\"fnOpenNewWindow('/jsp/RCA.jsp?resourceid=" + resourceid + "&attributeid=" + healthid + "')\">";
/* 1488 */       toreturn.append(v);
/*      */       
/* 1490 */       toreturn.append(link);
/* 1491 */       if (severity == null)
/*      */       {
/* 1493 */         toreturn.append("<img border=\"0\" src=\"/images/icon_health_unknown.gif\" name=\"Image" + ++this.j + "\">");
/*      */       }
/* 1495 */       else if (severity.equals("5"))
/*      */       {
/* 1497 */         toreturn.append("<img border=\"0\" src=\"/images/icon_health_clear.gif\"  name=\"Image" + ++this.j + "\">");
/*      */       }
/* 1499 */       else if (severity.equals("4"))
/*      */       {
/* 1501 */         toreturn.append("<img border=\"0\" src=\"/images/icon_health_warning.gif\" name=\"Image" + ++this.j + "\">");
/*      */       }
/* 1503 */       else if (severity.equals("1"))
/*      */       {
/* 1505 */         toreturn.append("<img border=\"0\" src=\"/images/icon_health_critical.gif\" name=\"Image" + ++this.j + "\">");
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1510 */         toreturn.append("<img border=\"0\" src=\"/images/icon_health_unknown.gif\" name=\"Image" + ++this.j + "\">");
/*      */       }
/* 1512 */       toreturn.append("</a>");
/* 1513 */       return toreturn.toString();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1517 */       ex.printStackTrace();
/*      */     }
/* 1519 */     return "<img border=\"0\" src=\"/images/icon_health_unknown.gif\" name=\"Image" + ++this.j + "\">";
/*      */   }
/*      */   
/*      */   private String getSeverityImageForAvailabilitywithLink(Properties alert, String resourceid, String availabilityid)
/*      */   {
/*      */     try
/*      */     {
/* 1526 */       StringBuilder toreturn = new StringBuilder();
/* 1527 */       String severity = alert.getProperty(resourceid + "#" + availabilityid);
/* 1528 */       String v = "<script>var v = '<span style=\"color: #000000;font-weight:bold;\">';</script>";
/* 1529 */       String message = alert.getProperty(resourceid + "#" + availabilityid + "#" + "MESSAGE");
/* 1530 */       if (message == null)
/*      */       {
/* 1532 */         message = "";
/*      */       }
/*      */       
/* 1535 */       message = FormatUtil.findReplace(message, "'", "\\'");
/* 1536 */       message = FormatUtil.findReplace(message, "\"", "&quot;");
/*      */       
/* 1538 */       String link = "<a href='javascript:void(0)'  onmouseover=\"ddrivetip(this,event,'" + message + "<br>'+v+'" + FormatUtil.getString("am.webclient.tooltip.text") + "</span>',null,true,'#000000')\" onmouseout='hideddrivetip()' onClick=\"fnOpenNewWindow('/jsp/RCA.jsp?resourceid=" + resourceid + "&attributeid=" + availabilityid + "')\">";
/* 1539 */       toreturn.append(v);
/*      */       
/* 1541 */       toreturn.append(link);
/*      */       
/* 1543 */       if (severity == null)
/*      */       {
/* 1545 */         toreturn.append("<img border=\"0\" src=\"/images/icon_availability_unknown.gif\" name=\"Image" + ++this.j + "\">");
/*      */       }
/* 1547 */       else if (severity.equals("5"))
/*      */       {
/* 1549 */         toreturn.append("<img border=\"0\" src=\"/images/icon_availability_up.gif\"  name=\"Image" + ++this.j + "\">");
/*      */       }
/* 1551 */       else if (severity.equals("1"))
/*      */       {
/* 1553 */         toreturn.append("<img border=\"0\" src=\"/images/icon_availability_down.gif\" name=\"Image" + ++this.j + "\">");
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1558 */         toreturn.append("<img border=\"0\" src=\"/images/icon_availability_unknown.gif\" name=\"Image" + ++this.j + "\">");
/*      */       }
/* 1560 */       toreturn.append("</a>");
/* 1561 */       return toreturn.toString();
/*      */     }
/*      */     catch (Exception ex) {}
/*      */     
/*      */ 
/*      */ 
/* 1567 */     return "<img border=\"0\" src=\"/images/icon_availabilitynunknown.gif\" name=\"Image" + ++this.j + "\">";
/*      */   }
/*      */   
/* 1570 */   public ArrayList getPermittedActions(HashMap actionmap, HashMap invokeActions) { ArrayList actionsavailable = new ArrayList();
/* 1571 */     if (invokeActions != null) {
/* 1572 */       Iterator iterator = invokeActions.keySet().iterator();
/* 1573 */       while (iterator.hasNext()) {
/* 1574 */         String actionid = (String)invokeActions.get((String)iterator.next());
/* 1575 */         if (actionmap.containsKey(actionid)) {
/* 1576 */           actionsavailable.add(actionid);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1581 */     return actionsavailable;
/*      */   }
/*      */   
/*      */   public String getActionParams(HashMap methodArgumentsMap, String rowId, String managedObjectName, String resID, String resourcetype, Properties commonValues) {
/* 1585 */     String actionLink = "";
/* 1586 */     AMConnectionPool cp = AMConnectionPool.getInstance();
/* 1587 */     String query = "";
/* 1588 */     ResultSet rs = null;
/* 1589 */     String methodName = (String)methodArgumentsMap.get("METHODNAME");
/* 1590 */     String isJsp = (String)methodArgumentsMap.get("ISPOPUPJSP");
/* 1591 */     if ((isJsp != null) && (isJsp.equalsIgnoreCase("No"))) {
/* 1592 */       actionLink = "method=" + methodName;
/*      */     }
/* 1594 */     else if ((isJsp != null) && (isJsp.equalsIgnoreCase("Yes"))) {
/* 1595 */       actionLink = methodName;
/*      */     }
/* 1597 */     ArrayList methodarglist = (ArrayList)methodArgumentsMap.get(methodName);
/* 1598 */     Iterator itr = methodarglist.iterator();
/* 1599 */     boolean isfirstparam = true;
/* 1600 */     HashMap popupProps = (HashMap)methodArgumentsMap.get("POPUP-PROPS");
/* 1601 */     while (itr.hasNext()) {
/* 1602 */       HashMap argmap = (HashMap)itr.next();
/* 1603 */       String argtype = (String)argmap.get("TYPE");
/* 1604 */       String argname = (String)argmap.get("IDENTITY");
/* 1605 */       String paramname = (String)argmap.get("PARAMETER");
/* 1606 */       String typeId = com.adventnet.appmanager.util.Constants.getTypeId(resourcetype);
/* 1607 */       if ((isfirstparam) && (isJsp != null) && (isJsp.equalsIgnoreCase("Yes"))) {
/* 1608 */         isfirstparam = false;
/* 1609 */         if (actionLink.indexOf("?") > 0)
/*      */         {
/* 1611 */           actionLink = actionLink + "&";
/*      */         }
/*      */         else
/*      */         {
/* 1615 */           actionLink = actionLink + "?";
/*      */         }
/*      */       }
/*      */       else {
/* 1619 */         actionLink = actionLink + "&";
/*      */       }
/* 1621 */       String paramValue = null;
/* 1622 */       String tempargname = argname;
/* 1623 */       if (commonValues.getProperty(tempargname) != null) {
/* 1624 */         paramValue = commonValues.getProperty(tempargname);
/*      */       }
/*      */       else {
/* 1627 */         if (argtype.equalsIgnoreCase("Argument")) {
/* 1628 */           String dbType = com.adventnet.appmanager.db.DBQueryUtil.getDBType();
/* 1629 */           if (dbType.equals("mysql")) {
/* 1630 */             argname = "`" + argname + "`";
/*      */           }
/*      */           else {
/* 1633 */             argname = "\"" + argname + "\"";
/*      */           }
/* 1635 */           query = "select " + argname + " as VALUE from AM_ARGS_" + typeId + " where RESOURCEID=" + resID;
/*      */           try {
/* 1637 */             rs = AMConnectionPool.executeQueryStmt(query);
/* 1638 */             if (rs.next()) {
/* 1639 */               paramValue = rs.getString("VALUE");
/* 1640 */               commonValues.setProperty(tempargname, paramValue);
/*      */             }
/*      */           }
/*      */           catch (SQLException e) {
/* 1644 */             e.printStackTrace();
/*      */           }
/*      */           finally {
/*      */             try {
/* 1648 */               AMConnectionPool.closeStatement(rs);
/*      */             }
/*      */             catch (Exception exc) {
/* 1651 */               exc.printStackTrace();
/*      */             }
/*      */           }
/*      */         }
/*      */         
/* 1656 */         if ((argtype.equalsIgnoreCase("Rowid")) && (rowId != null)) {
/* 1657 */           paramValue = rowId;
/*      */         }
/* 1659 */         else if ((argtype.equalsIgnoreCase("MO")) && (managedObjectName != null)) {
/* 1660 */           paramValue = managedObjectName;
/*      */         }
/* 1662 */         else if (argtype.equalsIgnoreCase("ResourceId")) {
/* 1663 */           paramValue = resID;
/*      */         }
/* 1665 */         else if (argtype.equalsIgnoreCase("TypeId")) {
/* 1666 */           paramValue = com.adventnet.appmanager.util.Constants.getTypeId(resourcetype);
/*      */         }
/*      */       }
/* 1669 */       actionLink = actionLink + paramname + "=" + paramValue;
/*      */     }
/* 1671 */     if ((popupProps != null) && (popupProps.size() > 0)) {
/* 1672 */       actionLink = actionLink + "|" + (String)popupProps.get("WinName") + "|";
/* 1673 */       actionLink = actionLink + "width=" + (String)popupProps.get("Width") + ",height=" + (String)popupProps.get("Height") + ",Top=" + (String)popupProps.get("Top") + ",Left=" + (String)popupProps.get("Left") + ",scrollbars=" + (String)popupProps.get("IsScrollBar") + ",resizable=" + (String)popupProps.get("IsResizable");
/*      */     }
/* 1675 */     return actionLink;
/*      */   }
/*      */   
/* 1678 */   public String getActionColDetails(HashMap columnDetails, ArrayList actionsavailable, HashMap actionmap, float width, HashMap rowDetails, String rowid, String resourcetype, String resID, String id1, String availValue, String healthValue, String bgclass, Boolean isdisable, String primaryColId, Properties commonValues) { StringBuilder toreturn = new StringBuilder();
/* 1679 */     String dependentAttribute = null;
/* 1680 */     String align = "left";
/*      */     
/* 1682 */     dependentAttribute = (String)columnDetails.get("DEPENDENTATTRIBUTE");
/* 1683 */     String displayType = (String)columnDetails.get("DISPLAYTYPE");
/* 1684 */     HashMap invokeActionsMap = (HashMap)((HashMap)columnDetails.get("INVOCATION")).get("ACTIONS");
/* 1685 */     HashMap invokeTooltip = (HashMap)((HashMap)columnDetails.get("INVOCATION")).get("TOOLTIP");
/* 1686 */     HashMap textOrImageValue = (HashMap)((HashMap)columnDetails.get("INVOCATION")).get("VALUES");
/* 1687 */     HashMap dependentValueMap = (HashMap)((HashMap)columnDetails.get("INVOCATION")).get("DEPENDENTVALUE");
/* 1688 */     HashMap dependentImageMap = (HashMap)((HashMap)columnDetails.get("INVOCATION")).get("DEPENDENTIMAGE");
/* 1689 */     if ((displayType != null) && (displayType.equals("Image"))) {
/* 1690 */       align = "center";
/*      */     }
/*      */     
/* 1693 */     boolean iscolumntoDisplay = actionsavailable != null;
/* 1694 */     String actualdata = "";
/*      */     
/* 1696 */     if ((dependentAttribute != null) && (!dependentAttribute.trim().equals(""))) {
/* 1697 */       if (dependentAttribute.equalsIgnoreCase("Availability")) {
/* 1698 */         actualdata = availValue;
/*      */       }
/* 1700 */       else if (dependentAttribute.equalsIgnoreCase("Health")) {
/* 1701 */         actualdata = healthValue;
/*      */       } else {
/*      */         try
/*      */         {
/* 1705 */           String attributeName = ConfMonitorConfiguration.getInstance().getAttributeName(resourcetype, dependentAttribute).toUpperCase();
/* 1706 */           actualdata = (String)rowDetails.get(attributeName);
/*      */         }
/*      */         catch (Exception e) {
/* 1709 */           e.printStackTrace();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1715 */     if ((actionmap != null) && (actionmap.size() > 0) && (iscolumntoDisplay)) {
/* 1716 */       toreturn.append("<td width='" + width + "%'  align='" + align + "' class='" + bgclass + "' >");
/* 1717 */       toreturn.append("<table>");
/* 1718 */       toreturn.append("<tr>");
/* 1719 */       for (int orderId = 1; orderId <= textOrImageValue.size(); orderId++) {
/* 1720 */         String displayValue = (String)textOrImageValue.get(Integer.toString(orderId));
/* 1721 */         String actionName = (String)invokeActionsMap.get(Integer.toString(orderId));
/* 1722 */         String dependentValue = (String)dependentValueMap.get(Integer.toString(orderId));
/* 1723 */         String toolTip = "";
/* 1724 */         String hideClass = "";
/* 1725 */         String textStyle = "";
/* 1726 */         boolean isreferenced = true;
/* 1727 */         if (invokeTooltip.get(Integer.toString(orderId)) != null) {
/* 1728 */           toolTip = (String)invokeTooltip.get(Integer.toString(orderId));
/* 1729 */           toolTip = toolTip.replaceAll("\"", "&quot;");
/* 1730 */           hideClass = "hideddrivetip()";
/*      */         }
/* 1732 */         if ((dependentValue != null) && (!dependentValue.equals("Null")) && (!dependentValue.equals(""))) {
/* 1733 */           StringTokenizer valueList = new StringTokenizer(dependentValue, ",");
/* 1734 */           while (valueList.hasMoreTokens()) {
/* 1735 */             String dependentVal = valueList.nextToken();
/* 1736 */             if ((actualdata != null) && (actualdata.equals(dependentVal))) {
/* 1737 */               if ((dependentImageMap != null) && (dependentImageMap.get(dependentValue) != null)) {
/* 1738 */                 displayValue = (String)dependentImageMap.get(dependentValue);
/*      */               }
/* 1740 */               toolTip = "";
/* 1741 */               hideClass = "";
/* 1742 */               isreferenced = false;
/* 1743 */               textStyle = "disabledtext";
/* 1744 */               break;
/*      */             }
/*      */           }
/*      */         }
/* 1748 */         if ((isdisable.booleanValue()) || (actualdata == null)) {
/* 1749 */           toolTip = "";
/* 1750 */           hideClass = "";
/* 1751 */           isreferenced = false;
/* 1752 */           textStyle = "disabledtext";
/* 1753 */           if (dependentImageMap != null) {
/* 1754 */             if ((dependentValue != null) && (!dependentValue.equals("Null")) && (!dependentValue.equals("")) && (dependentImageMap.get(dependentValue) != null)) {
/* 1755 */               displayValue = (String)dependentImageMap.get(dependentValue);
/*      */             }
/*      */             else {
/* 1758 */               displayValue = (String)dependentImageMap.get(Integer.toString(orderId));
/*      */             }
/*      */           }
/*      */         }
/* 1762 */         if ((actionsavailable.contains(actionName)) && (actionmap.get(actionName) != null)) {
/* 1763 */           Boolean confirmBox = (Boolean)((HashMap)actionmap.get(actionName)).get("CONFIRMATION");
/* 1764 */           String confirmmsg = (String)((HashMap)actionmap.get(actionName)).get("MESSAGE");
/* 1765 */           String isJSP = (String)((HashMap)actionmap.get(actionName)).get("ISPOPUPJSP");
/* 1766 */           String managedObject = (String)rowDetails.get(primaryColId);
/* 1767 */           String actionLinks = getActionParams((HashMap)actionmap.get(actionName), rowid, managedObject, resID, resourcetype, commonValues);
/*      */           
/* 1769 */           toreturn.append("<td width='" + width / actionsavailable.size() + "%' align='" + align + "' class='staticlinks'>");
/* 1770 */           if (isreferenced) {
/* 1771 */             toreturn.append("<a href=\"javascript:triggerAction('" + actionLinks + "','" + id1 + "','" + confirmBox + "','" + FormatUtil.getString(confirmmsg) + "','" + isJSP + "');\" class='staticlinks' onMouseOver=\"ddrivetip(this,event,'" + FormatUtil.getString(toolTip).replace("\"", "&quot;") + "',false,true,'#000000',100,'lightyellow')\" onmouseout=\"" + hideClass + "\">");
/*      */           }
/*      */           else
/*      */           {
/* 1775 */             toreturn.append("<a href=\"javascript:void(0);\" class='staticlinks' onMouseOver=\"ddrivetip(this,event,'" + FormatUtil.getString(toolTip).replace("\"", "&quot;") + "',false,true,'#000000',100,'lightyellow')\" onmouseout=\"" + hideClass + "\">"); }
/* 1776 */           if ((displayValue != null) && (displayType != null) && (displayType.equals("Image"))) {
/* 1777 */             toreturn.append("<img src=\"" + displayValue + "\" hspace=\"4\" border=\"0\" align=\"absmiddle\"/>");
/* 1778 */           } else if ((displayValue != null) && (displayType != null) && (displayType.equals("Text"))) {
/* 1779 */             toreturn.append("<span class=\"" + textStyle + "\">");
/* 1780 */             toreturn.append(FormatUtil.getString(displayValue));
/*      */           }
/* 1782 */           toreturn.append("</span>");
/* 1783 */           toreturn.append("</a>");
/* 1784 */           toreturn.append("</td>");
/*      */         }
/*      */       }
/* 1787 */       toreturn.append("</tr>");
/* 1788 */       toreturn.append("</table>");
/* 1789 */       toreturn.append("</td>");
/*      */     } else {
/* 1791 */       toreturn.append("<td width='" + width + "%'  align='" + align + "' class='" + bgclass + "' > - </td>");
/*      */     }
/*      */     
/* 1794 */     return toreturn.toString();
/*      */   }
/*      */   
/*      */   public String getMOCollectioTime(ArrayList rows, String tablename, String attributeid, String resColumn) {
/* 1798 */     String colTime = null;
/* 1799 */     AMConnectionPool cp = AMConnectionPool.getInstance();
/* 1800 */     if ((rows != null) && (rows.size() > 0)) {
/* 1801 */       Iterator<String> itr = rows.iterator();
/* 1802 */       String maxColQuery = "";
/* 1803 */       for (;;) { if (itr.hasNext()) {
/* 1804 */           maxColQuery = "select max(COLLECTIONTIME) from " + tablename + " where ATTRIBUTEID=" + attributeid + " and " + resColumn + "=" + (String)itr.next();
/* 1805 */           ResultSet maxCol = null;
/*      */           try {
/* 1807 */             maxCol = AMConnectionPool.executeQueryStmt(maxColQuery);
/* 1808 */             while (maxCol.next()) {
/* 1809 */               if (colTime == null) {
/* 1810 */                 colTime = Long.toString(maxCol.getLong(1));
/*      */               }
/*      */               else {
/* 1813 */                 colTime = colTime + "," + Long.toString(maxCol.getLong(1));
/*      */               }
/*      */             }
/*      */             
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1822 */             AMLog.debug("Graph Query for att " + attributeid + " :" + maxColQuery);
/*      */             try {
/* 1824 */               if (maxCol != null)
/* 1825 */                 AMConnectionPool.closeStatement(maxCol);
/*      */             } catch (Exception e) {
/* 1827 */               e.printStackTrace();
/*      */             }
/*      */           }
/*      */           catch (Exception e) {}finally
/*      */           {
/* 1822 */             AMLog.debug("Graph Query for att " + attributeid + " :" + maxColQuery);
/*      */             try {
/* 1824 */               if (maxCol != null)
/* 1825 */                 AMConnectionPool.closeStatement(maxCol);
/*      */             } catch (Exception e) {
/* 1827 */               e.printStackTrace();
/*      */             }
/*      */           }
/*      */         }
/*      */       } }
/* 1832 */     return colTime;
/*      */   }
/*      */   
/* 1835 */   public String getTableName(String attributeid, String baseid) { String tablenameqry = "select ATTRIBUTEID,DATATABLE,VALUE_COL from AM_ATTRIBUTES_EXT where ATTRIBUTEID=" + attributeid;
/* 1836 */     tablename = null;
/* 1837 */     ResultSet rsTable = null;
/* 1838 */     AMConnectionPool cp = AMConnectionPool.getInstance();
/*      */     try {
/* 1840 */       rsTable = AMConnectionPool.executeQueryStmt(tablenameqry);
/* 1841 */       while (rsTable.next()) {
/* 1842 */         tablename = rsTable.getString("DATATABLE");
/* 1843 */         if ((tablename.equals("AM_ManagedObjectData")) && (rsTable.getString("VALUE_COL").equals("RESPONSETIME"))) {
/* 1844 */           tablename = "AM_Script_Numeric_Data_" + baseid;
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1857 */       return tablename;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1848 */       e.printStackTrace();
/*      */     } finally {
/*      */       try {
/* 1851 */         if (rsTable != null)
/* 1852 */           AMConnectionPool.closeStatement(rsTable);
/*      */       } catch (Exception e) {
/* 1854 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public String getArgsListtoShowonClick(HashMap showArgsMap, String row) {
/* 1860 */     String argsList = "";
/* 1861 */     ArrayList showArgslist = new ArrayList();
/*      */     try {
/* 1863 */       if (showArgsMap.get(row) != null) {
/* 1864 */         showArgslist = (ArrayList)showArgsMap.get(row);
/* 1865 */         if (showArgslist != null) {
/* 1866 */           for (int i = 0; i < showArgslist.size(); i++) {
/* 1867 */             if (argsList.trim().equals("")) {
/* 1868 */               argsList = (String)showArgslist.get(i);
/*      */             }
/*      */             else {
/* 1871 */               argsList = argsList + "," + (String)showArgslist.get(i);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1878 */       e.printStackTrace();
/* 1879 */       return "";
/*      */     }
/* 1881 */     return argsList;
/*      */   }
/*      */   
/*      */   public String getArgsListToHideOnClick(HashMap hideArgsMap, String row)
/*      */   {
/* 1886 */     String argsList = "";
/* 1887 */     ArrayList hideArgsList = new ArrayList();
/*      */     try
/*      */     {
/* 1890 */       if (hideArgsMap.get(row) != null)
/*      */       {
/* 1892 */         hideArgsList = (ArrayList)hideArgsMap.get(row);
/* 1893 */         if (hideArgsList != null)
/*      */         {
/* 1895 */           for (int i = 0; i < hideArgsList.size(); i++)
/*      */           {
/* 1897 */             if (argsList.trim().equals(""))
/*      */             {
/* 1899 */               argsList = (String)hideArgsList.get(i);
/*      */             }
/*      */             else
/*      */             {
/* 1903 */               argsList = argsList + "," + (String)hideArgsList.get(i);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1911 */       ex.printStackTrace();
/*      */     }
/* 1913 */     return argsList;
/*      */   }
/*      */   
/*      */   public String getTableActionsList(ArrayList tActionList, HashMap actionmap, String tableName, Properties commonValues, String resourceId, String resourceType) {
/* 1917 */     StringBuilder toreturn = new StringBuilder();
/* 1918 */     StringBuilder addtoreturn = new StringBuilder();
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1925 */     if ((tActionList != null) && (tActionList.size() > 0)) {
/* 1926 */       Iterator itr = tActionList.iterator();
/* 1927 */       while (itr.hasNext()) {
/* 1928 */         Boolean confirmBox = Boolean.valueOf(false);
/* 1929 */         String confirmmsg = "";
/* 1930 */         String link = "";
/* 1931 */         String isJSP = "NO";
/* 1932 */         HashMap tactionMap = (HashMap)itr.next();
/* 1933 */         boolean isTableAction = tactionMap.containsKey("ACTION-NAME");
/* 1934 */         String actionName = isTableAction ? (String)tactionMap.get("ACTION-NAME") : (String)tactionMap.get("LINK-NAME");
/* 1935 */         String actionId = (String)tactionMap.get("ACTIONID");
/* 1936 */         if ((actionId != null) && (actionName != null) && (!actionName.trim().equals("")) && (!actionId.trim().equals("")) && 
/* 1937 */           (actionmap.containsKey(actionId))) {
/* 1938 */           HashMap methodArgumentsMap = (HashMap)actionmap.get(actionId);
/* 1939 */           HashMap popupProps = (HashMap)methodArgumentsMap.get("POPUP-PROPS");
/* 1940 */           confirmBox = (Boolean)methodArgumentsMap.get("CONFIRMATION");
/* 1941 */           confirmmsg = (String)methodArgumentsMap.get("MESSAGE");
/* 1942 */           isJSP = (String)methodArgumentsMap.get("ISPOPUPJSP");
/*      */           
/* 1944 */           link = getActionParams(methodArgumentsMap, null, null, resourceId, resourceType, commonValues);
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1950 */           if (isTableAction) {
/* 1951 */             toreturn.append("<option value=" + actionId + ">" + FormatUtil.getString(actionName) + "</option>");
/*      */           }
/*      */           else {
/* 1954 */             tableName = "Link";
/* 1955 */             toreturn.append("<td align=\"right\" style=\"padding-right:10px\">");
/* 1956 */             toreturn.append("<a class=\"bodytextboldwhiteun\" style='cursor:pointer' ");
/* 1957 */             toreturn.append("onClick=\"javascript:customLinks('" + actionId + "','" + resourceId + "')\">" + FormatUtil.getString(actionName));
/* 1958 */             toreturn.append("</a></td>");
/*      */           }
/* 1960 */           addtoreturn.append("<input type='hidden' id='" + tableName + "_" + actionId + "_isJSP' value='" + isJSP + "'/>");
/* 1961 */           addtoreturn.append("<input type='hidden' id='" + tableName + "_" + actionId + "_confirmBox' value='" + confirmBox + "'/>");
/* 1962 */           addtoreturn.append("<input type='hidden' id='" + tableName + "_" + actionId + "_confirmmsg' value='" + FormatUtil.getString(confirmmsg) + "'/>");
/* 1963 */           addtoreturn.append("<input type='hidden' id='" + tableName + "_" + actionId + "_link' value='" + link + "'/>");
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1969 */     return toreturn.toString() + addtoreturn.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public void printMGTree(DefaultMutableTreeNode rootNode, StringBuilder builder)
/*      */   {
/* 1975 */     for (Enumeration<DefaultMutableTreeNode> enu = rootNode.children(); enu.hasMoreElements();)
/*      */     {
/* 1977 */       DefaultMutableTreeNode node = (DefaultMutableTreeNode)enu.nextElement();
/* 1978 */       Properties prop = (Properties)node.getUserObject();
/* 1979 */       String mgID = prop.getProperty("label");
/* 1980 */       String mgName = prop.getProperty("value");
/* 1981 */       String isParent = prop.getProperty("isParent");
/* 1982 */       int mgIDint = Integer.parseInt(mgID);
/* 1983 */       if ((EnterpriseUtil.isAdminServer()) && (mgIDint > EnterpriseUtil.RANGE))
/*      */       {
/* 1985 */         mgName = mgName + "(" + com.adventnet.appmanager.server.framework.comm.CommDBUtil.getManagedServerNameWithPort(mgID) + ")";
/*      */       }
/* 1987 */       builder.append("<LI id='" + prop.getProperty("label") + "_list' ><A ");
/* 1988 */       if (node.getChildCount() > 0)
/*      */       {
/* 1990 */         if ((prop.getProperty("isParent") != null) && (prop.getProperty("isParent").equals("true")))
/*      */         {
/* 1992 */           builder.append("style='background-color:#f9f9f9;border-bottom: 1px solid #ECECEC;border-top:none; border-right:none; border-left:none;'");
/*      */         }
/* 1994 */         else if ((prop.getProperty("isParent") != null) && (prop.getProperty("isParent").equals("false")))
/*      */         {
/* 1996 */           builder.append(" style='padding-left:").append(node.getLevel() * 15 + "px;'");
/*      */         }
/*      */         else
/*      */         {
/* 2000 */           builder.append(" style='padding-left:").append(node.getLevel() * 15 + "px;'");
/*      */         }
/*      */         
/*      */ 
/*      */       }
/* 2005 */       else if ((prop.getProperty("isParent") != null) && (prop.getProperty("isParent").equals("true")))
/*      */       {
/* 2007 */         builder.append("style='background-color:#f9f9f9;border-bottom: 1px solid #ECECEC;border-top:none; border-right:none; border-left:none;'");
/*      */       }
/* 2009 */       else if ((prop.getProperty("isParent") != null) && (prop.getProperty("isParent").equals("false")))
/*      */       {
/* 2011 */         builder.append(" style='padding-left:").append(node.getLevel() * 15 + "px;'");
/*      */       }
/*      */       else
/*      */       {
/* 2015 */         builder.append(" style='padding-left:").append(node.getLevel() * 15 + "px;'");
/*      */       }
/*      */       
/* 2018 */       builder.append(" onmouseout=\"changeStyle(this);\" onmouseover=\"SetSelected(this)\" onclick=\"SelectMonitorGroup('service_list_left1','" + prop.getProperty("value") + "','" + prop.getProperty("label") + "','leftimage1')\"> ");
/* 2019 */       if ((prop.getProperty("isParent") != null) && (prop.getProperty("isParent").equals("true")))
/*      */       {
/* 2021 */         builder.append("<img src='images/icon_monitors_mg.png' alt='' style='position:relative; top:5px;'/><b>" + prop.getProperty("value") + "</b></a></li>");
/*      */       }
/*      */       else
/*      */       {
/* 2025 */         builder.append(prop.getProperty("value") + "</a></li>");
/*      */       }
/* 2027 */       if (node.getChildCount() > 0)
/*      */       {
/* 2029 */         builder.append("<UL>");
/* 2030 */         printMGTree(node, builder);
/* 2031 */         builder.append("</UL>");
/*      */       }
/*      */     }
/*      */   }
/*      */   
/* 2036 */   public String getColumnGraph(LinkedHashMap graphData, HashMap attidMap) { Iterator it = graphData.keySet().iterator();
/* 2037 */     StringBuffer toReturn = new StringBuffer();
/* 2038 */     String table = "-";
/*      */     try {
/* 2040 */       java.text.DecimalFormat twoDecPer = new java.text.DecimalFormat("###,###.##");
/* 2041 */       LinkedHashMap attVsWidthProps = new LinkedHashMap();
/* 2042 */       float total = 0.0F;
/* 2043 */       while (it.hasNext()) {
/* 2044 */         String attName = (String)it.next();
/* 2045 */         String data = (String)attidMap.get(attName.toUpperCase());
/* 2046 */         boolean roundOffData = false;
/* 2047 */         if ((data != null) && (!data.equals(""))) {
/* 2048 */           if (data.indexOf(",") != -1) {
/* 2049 */             data = data.replaceAll(",", "");
/*      */           }
/*      */           try {
/* 2052 */             float value = Float.parseFloat(data);
/* 2053 */             if (value == 0.0F) {
/*      */               continue;
/*      */             }
/* 2056 */             total += value;
/* 2057 */             attVsWidthProps.put(attName, value + "");
/*      */           }
/*      */           catch (Exception e) {
/* 2060 */             e.printStackTrace();
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 2065 */       Iterator attVsWidthList = attVsWidthProps.keySet().iterator();
/* 2066 */       while (attVsWidthList.hasNext()) {
/* 2067 */         String attName = (String)attVsWidthList.next();
/* 2068 */         String data = (String)attVsWidthProps.get(attName);
/* 2069 */         HashMap graphDetails = (HashMap)graphData.get(attName);
/* 2070 */         String unit = graphDetails.get("Unit") != null ? "(" + FormatUtil.getString((String)graphDetails.get("Unit")) + ")" : "";
/* 2071 */         String toolTip = graphDetails.get("ToolTip") != null ? "title=\"" + FormatUtil.getString((String)graphDetails.get("ToolTip")) + " - " + data + unit + "\"" : "";
/* 2072 */         String className = (String)graphDetails.get("ClassName");
/* 2073 */         float percentage = Float.parseFloat(data) * 100.0F / total;
/* 2074 */         if (percentage < 1.0F)
/*      */         {
/* 2076 */           data = percentage + "";
/*      */         }
/* 2078 */         toReturn.append("<td class=\"" + className + "\" width=\"" + twoDecPer.format(percentage) + "%\"" + toolTip + "><img src=\"/images/spacer.gif\"  height=\"10\" width=\"90%\"></td>");
/*      */       }
/* 2080 */       if (toReturn.length() > 0) {
/* 2081 */         table = "<table align=\"center\" width =\"90%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"graphborder\"><tr>" + toReturn.toString() + "</tr></table>";
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 2085 */       e.printStackTrace();
/*      */     }
/* 2087 */     return table;
/*      */   }
/*      */   
/*      */ 
/*      */   public String[] splitMultiConditionThreshold(String criticalcondition, String criticalThValue)
/*      */   {
/* 2093 */     String[] splitvalues = { criticalcondition, criticalThValue };
/* 2094 */     List<String> criticalThresholdValues = com.adventnet.appmanager.util.AMRegexUtil.getThresholdGroups(criticalcondition, true);
/* 2095 */     System.out.println("CRITICALTHGROPS " + criticalThresholdValues);
/* 2096 */     if ((criticalThresholdValues != null) && (criticalThresholdValues.size() > 5)) {
/* 2097 */       String condition1 = (String)criticalThresholdValues.get(0);
/* 2098 */       String thvalue1 = (String)criticalThresholdValues.get(1);
/* 2099 */       String conditionjoiner = (String)criticalThresholdValues.get(4);
/* 2100 */       String condition2 = (String)criticalThresholdValues.get(5);
/* 2101 */       String thvalue2 = (String)criticalThresholdValues.get(6);
/*      */       
/*      */ 
/* 2104 */       StringBuilder multiplecondition = new StringBuilder(condition1);
/* 2105 */       multiplecondition.append(" ").append(thvalue1).append(" ").append(conditionjoiner).append(" ").append(condition2).append(" ").append(thvalue2);
/* 2106 */       splitvalues[0] = multiplecondition.toString();
/* 2107 */       splitvalues[1] = "";
/*      */     }
/*      */     
/* 2110 */     return splitvalues;
/*      */   }
/*      */   
/*      */   public Map<String, String[]> setSelectedCondition(String condition, int thresholdType)
/*      */   {
/* 2115 */     LinkedHashMap<String, String[]> conditionsMap = new LinkedHashMap();
/* 2116 */     if (thresholdType != 3) {
/* 2117 */       conditionsMap.put("LT", new String[] { "", "<" });
/* 2118 */       conditionsMap.put("GT", new String[] { "", ">" });
/* 2119 */       conditionsMap.put("EQ", new String[] { "", "=" });
/* 2120 */       conditionsMap.put("LE", new String[] { "", "<=" });
/* 2121 */       conditionsMap.put("GE", new String[] { "", ">=" });
/* 2122 */       conditionsMap.put("NE", new String[] { "", "!=" });
/*      */     } else {
/* 2124 */       conditionsMap.put("CT", new String[] { "", "am.fault.conditions.string.contains" });
/* 2125 */       conditionsMap.put("DC", new String[] { "", "am.fault.conditions.string.doesnotcontain" });
/* 2126 */       conditionsMap.put("QL", new String[] { "", "am.fault.conditions.string.equalto" });
/* 2127 */       conditionsMap.put("NQ", new String[] { "", "am.fault.conditions.string.notequalto" });
/* 2128 */       conditionsMap.put("SW", new String[] { "", "am.fault.conditions.string.startswith" });
/* 2129 */       conditionsMap.put("EW", new String[] { "", "am.fault.conditions.string.endswith" });
/*      */     }
/* 2131 */     String[] updateSelected = (String[])conditionsMap.get(condition);
/* 2132 */     if (updateSelected != null) {
/* 2133 */       updateSelected[0] = "selected";
/*      */     }
/* 2135 */     return conditionsMap;
/*      */   }
/*      */   
/*      */   public String getCustomMessage(String monitorType, String commaSeparatedMsgId, String uiElement, ArrayList<String> listOfIdsToRemove) {
/*      */     try {
/* 2140 */       StringBuffer toreturn = new StringBuffer("");
/* 2141 */       if (commaSeparatedMsgId != null) {
/* 2142 */         StringTokenizer msgids = new StringTokenizer(commaSeparatedMsgId, ",");
/* 2143 */         int count = 0;
/* 2144 */         while (msgids.hasMoreTokens()) {
/* 2145 */           String id = msgids.nextToken();
/* 2146 */           String message = ConfMonitorConfiguration.getInstance().getMessageTextForId(monitorType, id);
/* 2147 */           String image = ConfMonitorConfiguration.getInstance().getMessageImageForId(monitorType, id);
/* 2148 */           count++;
/* 2149 */           if (!listOfIdsToRemove.contains("MESSAGE_" + id)) {
/* 2150 */             if (toreturn.length() == 0) {
/* 2151 */               toreturn.append("<table width=\"100%\">");
/*      */             }
/* 2153 */             toreturn.append("<tr><td width=\"100%\" class=\"msg-table-width\"><table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"><tbody><tr>");
/* 2154 */             if (!image.trim().equals("")) {
/* 2155 */               toreturn.append("<td class=\"msg-table-width-bg\"><img width=\"18\" height=\"18\" alt=\"Icon\" src=\"" + image + "\">&nbsp;</td>");
/*      */             }
/* 2157 */             toreturn.append("<td class=\"msg-table-width\"><div id=\"htmlMessage\">" + message + "</div></td>");
/* 2158 */             toreturn.append("</tr></tbody></table></td></tr>");
/*      */           }
/*      */         }
/* 2161 */         if (toreturn.length() > 0) {
/* 2162 */           toreturn.append("TABLE".equals(uiElement) ? "<tr><td><img src=\"../images/spacer.gif\" width=\"10\"></td></tr></table>" : "</table>");
/*      */         }
/*      */       }
/*      */       
/* 2166 */       return toreturn.toString();
/*      */     }
/*      */     catch (Exception e) {
/* 2169 */       e.printStackTrace(); }
/* 2170 */     return "";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/* 2176 */   private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2182 */   private static Map<String, Long> _jspx_dependants = new HashMap(1);
/* 2183 */   static { _jspx_dependants.put("/jsp/util.jspf", Long.valueOf(1473429417000L)); }
/*      */   
/*      */ 
/*      */   private TagHandlerPool _005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody;
/*      */   
/*      */   private TagHandlerPool _005fjspx_005ftagPool_005ftiles_005finsert_0026_005fpage;
/*      */   private TagHandlerPool _005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody;
/*      */   private TagHandlerPool _005fjspx_005ftagPool_005ftiles_005fput_0026_005ftype_005fname;
/*      */   private TagHandlerPool _005fjspx_005ftagPool_005fc_005fcatch_0026_005fvar;
/*      */   private TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fparseNumber_0026_005fvar_005fvalue_005fnobody;
/*      */   private TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
/*      */   private TagHandlerPool _005fjspx_005ftagPool_005fawolf_005ftimechart_0026_005fyaxisLabel_005fxaxisLabel_005fwidth_005flegend_005fheight_005fdataSetProducer;
/*      */   private javax.el.ExpressionFactory _el_expressionfactory;
/*      */   private org.apache.tomcat.InstanceManager _jsp_instancemanager;
/*      */   public Map<String, Long> getDependants()
/*      */   {
/* 2199 */     return _jspx_dependants;
/*      */   }
/*      */   
/*      */   public void _jspInit() {
/* 2203 */     this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody = TagHandlerPool.getTagHandlerPool(getServletConfig());
/* 2204 */     this._005fjspx_005ftagPool_005ftiles_005finsert_0026_005fpage = TagHandlerPool.getTagHandlerPool(getServletConfig());
/* 2205 */     this._005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody = TagHandlerPool.getTagHandlerPool(getServletConfig());
/* 2206 */     this._005fjspx_005ftagPool_005ftiles_005fput_0026_005ftype_005fname = TagHandlerPool.getTagHandlerPool(getServletConfig());
/* 2207 */     this._005fjspx_005ftagPool_005fc_005fcatch_0026_005fvar = TagHandlerPool.getTagHandlerPool(getServletConfig());
/* 2208 */     this._005fjspx_005ftagPool_005ffmt_005fparseNumber_0026_005fvar_005fvalue_005fnobody = TagHandlerPool.getTagHandlerPool(getServletConfig());
/* 2209 */     this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest = TagHandlerPool.getTagHandlerPool(getServletConfig());
/* 2210 */     this._005fjspx_005ftagPool_005fawolf_005ftimechart_0026_005fyaxisLabel_005fxaxisLabel_005fwidth_005flegend_005fheight_005fdataSetProducer = TagHandlerPool.getTagHandlerPool(getServletConfig());
/* 2211 */     this._el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
/* 2212 */     this._jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
/*      */   }
/*      */   
/*      */   public void _jspDestroy() {
/* 2216 */     this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.release();
/* 2217 */     this._005fjspx_005ftagPool_005ftiles_005finsert_0026_005fpage.release();
/* 2218 */     this._005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.release();
/* 2219 */     this._005fjspx_005ftagPool_005ftiles_005fput_0026_005ftype_005fname.release();
/* 2220 */     this._005fjspx_005ftagPool_005fc_005fcatch_0026_005fvar.release();
/* 2221 */     this._005fjspx_005ftagPool_005ffmt_005fparseNumber_0026_005fvar_005fvalue_005fnobody.release();
/* 2222 */     this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
/* 2223 */     this._005fjspx_005ftagPool_005fawolf_005ftimechart_0026_005fyaxisLabel_005fxaxisLabel_005fwidth_005flegend_005fheight_005fdataSetProducer.release();
/*      */   }
/*      */   
/*      */ 
/*      */   public void _jspService(HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
/*      */     throws java.io.IOException, javax.servlet.ServletException
/*      */   {
/* 2230 */     HttpSession session = null;
/*      */     
/*      */ 
/* 2233 */     JspWriter out = null;
/* 2234 */     Object page = this;
/* 2235 */     JspWriter _jspx_out = null;
/* 2236 */     PageContext _jspx_page_context = null;
/*      */     
/*      */     try
/*      */     {
/* 2240 */       response.setContentType("text/html;charset=UTF-8");
/* 2241 */       PageContext pageContext = _jspxFactory.getPageContext(this, request, response, "/jsp/ErrorPage.jsp", true, 8192, true);
/*      */       
/* 2243 */       _jspx_page_context = pageContext;
/* 2244 */       javax.servlet.ServletContext application = pageContext.getServletContext();
/* 2245 */       javax.servlet.ServletConfig config = pageContext.getServletConfig();
/* 2246 */       session = pageContext.getSession();
/* 2247 */       out = pageContext.getOut();
/* 2248 */       _jspx_out = out;
/*      */       
/* 2250 */       out.write("<!DOCTYPE html>\n");
/* 2251 */       out.write("\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n<!--$Id$-->\n\n\n\n\n\n\n\n \n\n\n\n\n\n");
/* 2252 */       out.write("<!--$Id$ -->\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
/*      */       
/* 2254 */       DefineTag _jspx_th_bean_005fdefine_005f0 = (DefineTag)this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.get(DefineTag.class);
/* 2255 */       _jspx_th_bean_005fdefine_005f0.setPageContext(_jspx_page_context);
/* 2256 */       _jspx_th_bean_005fdefine_005f0.setParent(null);
/*      */       
/* 2258 */       _jspx_th_bean_005fdefine_005f0.setId("available");
/*      */       
/* 2260 */       _jspx_th_bean_005fdefine_005f0.setName("colors");
/*      */       
/* 2262 */       _jspx_th_bean_005fdefine_005f0.setProperty("AVAILABLE");
/*      */       
/* 2264 */       _jspx_th_bean_005fdefine_005f0.setType("java.lang.String");
/* 2265 */       int _jspx_eval_bean_005fdefine_005f0 = _jspx_th_bean_005fdefine_005f0.doStartTag();
/* 2266 */       if (_jspx_th_bean_005fdefine_005f0.doEndTag() == 5) {
/* 2267 */         this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f0);
/*      */       }
/*      */       else {
/* 2270 */         this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f0);
/* 2271 */         String available = null;
/* 2272 */         available = (String)_jspx_page_context.findAttribute("available");
/* 2273 */         out.write(10);
/*      */         
/* 2275 */         DefineTag _jspx_th_bean_005fdefine_005f1 = (DefineTag)this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.get(DefineTag.class);
/* 2276 */         _jspx_th_bean_005fdefine_005f1.setPageContext(_jspx_page_context);
/* 2277 */         _jspx_th_bean_005fdefine_005f1.setParent(null);
/*      */         
/* 2279 */         _jspx_th_bean_005fdefine_005f1.setId("unavailable");
/*      */         
/* 2281 */         _jspx_th_bean_005fdefine_005f1.setName("colors");
/*      */         
/* 2283 */         _jspx_th_bean_005fdefine_005f1.setProperty("UNAVAILABLE");
/*      */         
/* 2285 */         _jspx_th_bean_005fdefine_005f1.setType("java.lang.String");
/* 2286 */         int _jspx_eval_bean_005fdefine_005f1 = _jspx_th_bean_005fdefine_005f1.doStartTag();
/* 2287 */         if (_jspx_th_bean_005fdefine_005f1.doEndTag() == 5) {
/* 2288 */           this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f1);
/*      */         }
/*      */         else {
/* 2291 */           this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f1);
/* 2292 */           String unavailable = null;
/* 2293 */           unavailable = (String)_jspx_page_context.findAttribute("unavailable");
/* 2294 */           out.write(10);
/*      */           
/* 2296 */           DefineTag _jspx_th_bean_005fdefine_005f2 = (DefineTag)this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.get(DefineTag.class);
/* 2297 */           _jspx_th_bean_005fdefine_005f2.setPageContext(_jspx_page_context);
/* 2298 */           _jspx_th_bean_005fdefine_005f2.setParent(null);
/*      */           
/* 2300 */           _jspx_th_bean_005fdefine_005f2.setId("unmanaged");
/*      */           
/* 2302 */           _jspx_th_bean_005fdefine_005f2.setName("colors");
/*      */           
/* 2304 */           _jspx_th_bean_005fdefine_005f2.setProperty("UNMANAGED");
/*      */           
/* 2306 */           _jspx_th_bean_005fdefine_005f2.setType("java.lang.String");
/* 2307 */           int _jspx_eval_bean_005fdefine_005f2 = _jspx_th_bean_005fdefine_005f2.doStartTag();
/* 2308 */           if (_jspx_th_bean_005fdefine_005f2.doEndTag() == 5) {
/* 2309 */             this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f2);
/*      */           }
/*      */           else {
/* 2312 */             this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f2);
/* 2313 */             String unmanaged = null;
/* 2314 */             unmanaged = (String)_jspx_page_context.findAttribute("unmanaged");
/* 2315 */             out.write(10);
/*      */             
/* 2317 */             DefineTag _jspx_th_bean_005fdefine_005f3 = (DefineTag)this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.get(DefineTag.class);
/* 2318 */             _jspx_th_bean_005fdefine_005f3.setPageContext(_jspx_page_context);
/* 2319 */             _jspx_th_bean_005fdefine_005f3.setParent(null);
/*      */             
/* 2321 */             _jspx_th_bean_005fdefine_005f3.setId("scheduled");
/*      */             
/* 2323 */             _jspx_th_bean_005fdefine_005f3.setName("colors");
/*      */             
/* 2325 */             _jspx_th_bean_005fdefine_005f3.setProperty("SCHEDULED");
/*      */             
/* 2327 */             _jspx_th_bean_005fdefine_005f3.setType("java.lang.String");
/* 2328 */             int _jspx_eval_bean_005fdefine_005f3 = _jspx_th_bean_005fdefine_005f3.doStartTag();
/* 2329 */             if (_jspx_th_bean_005fdefine_005f3.doEndTag() == 5) {
/* 2330 */               this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f3);
/*      */             }
/*      */             else {
/* 2333 */               this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f3);
/* 2334 */               String scheduled = null;
/* 2335 */               scheduled = (String)_jspx_page_context.findAttribute("scheduled");
/* 2336 */               out.write(10);
/*      */               
/* 2338 */               DefineTag _jspx_th_bean_005fdefine_005f4 = (DefineTag)this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.get(DefineTag.class);
/* 2339 */               _jspx_th_bean_005fdefine_005f4.setPageContext(_jspx_page_context);
/* 2340 */               _jspx_th_bean_005fdefine_005f4.setParent(null);
/*      */               
/* 2342 */               _jspx_th_bean_005fdefine_005f4.setId("critical");
/*      */               
/* 2344 */               _jspx_th_bean_005fdefine_005f4.setName("colors");
/*      */               
/* 2346 */               _jspx_th_bean_005fdefine_005f4.setProperty("CRITICAL");
/*      */               
/* 2348 */               _jspx_th_bean_005fdefine_005f4.setType("java.lang.String");
/* 2349 */               int _jspx_eval_bean_005fdefine_005f4 = _jspx_th_bean_005fdefine_005f4.doStartTag();
/* 2350 */               if (_jspx_th_bean_005fdefine_005f4.doEndTag() == 5) {
/* 2351 */                 this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f4);
/*      */               }
/*      */               else {
/* 2354 */                 this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f4);
/* 2355 */                 String critical = null;
/* 2356 */                 critical = (String)_jspx_page_context.findAttribute("critical");
/* 2357 */                 out.write(10);
/*      */                 
/* 2359 */                 DefineTag _jspx_th_bean_005fdefine_005f5 = (DefineTag)this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.get(DefineTag.class);
/* 2360 */                 _jspx_th_bean_005fdefine_005f5.setPageContext(_jspx_page_context);
/* 2361 */                 _jspx_th_bean_005fdefine_005f5.setParent(null);
/*      */                 
/* 2363 */                 _jspx_th_bean_005fdefine_005f5.setId("clear");
/*      */                 
/* 2365 */                 _jspx_th_bean_005fdefine_005f5.setName("colors");
/*      */                 
/* 2367 */                 _jspx_th_bean_005fdefine_005f5.setProperty("CLEAR");
/*      */                 
/* 2369 */                 _jspx_th_bean_005fdefine_005f5.setType("java.lang.String");
/* 2370 */                 int _jspx_eval_bean_005fdefine_005f5 = _jspx_th_bean_005fdefine_005f5.doStartTag();
/* 2371 */                 if (_jspx_th_bean_005fdefine_005f5.doEndTag() == 5) {
/* 2372 */                   this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f5);
/*      */                 }
/*      */                 else {
/* 2375 */                   this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f5);
/* 2376 */                   String clear = null;
/* 2377 */                   clear = (String)_jspx_page_context.findAttribute("clear");
/* 2378 */                   out.write(10);
/*      */                   
/* 2380 */                   DefineTag _jspx_th_bean_005fdefine_005f6 = (DefineTag)this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.get(DefineTag.class);
/* 2381 */                   _jspx_th_bean_005fdefine_005f6.setPageContext(_jspx_page_context);
/* 2382 */                   _jspx_th_bean_005fdefine_005f6.setParent(null);
/*      */                   
/* 2384 */                   _jspx_th_bean_005fdefine_005f6.setId("warning");
/*      */                   
/* 2386 */                   _jspx_th_bean_005fdefine_005f6.setName("colors");
/*      */                   
/* 2388 */                   _jspx_th_bean_005fdefine_005f6.setProperty("WARNING");
/*      */                   
/* 2390 */                   _jspx_th_bean_005fdefine_005f6.setType("java.lang.String");
/* 2391 */                   int _jspx_eval_bean_005fdefine_005f6 = _jspx_th_bean_005fdefine_005f6.doStartTag();
/* 2392 */                   if (_jspx_th_bean_005fdefine_005f6.doEndTag() == 5) {
/* 2393 */                     this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f6);
/*      */                   }
/*      */                   else {
/* 2396 */                     this._005fjspx_005ftagPool_005fbean_005fdefine_0026_005ftype_005fproperty_005fname_005fid_005fnobody.reuse(_jspx_th_bean_005fdefine_005f6);
/* 2397 */                     String warning = null;
/* 2398 */                     warning = (String)_jspx_page_context.findAttribute("warning");
/* 2399 */                     out.write(10);
/* 2400 */                     out.write(10);
/*      */                     
/* 2402 */                     String isTabletStr = (String)request.getSession().getAttribute("isTablet");
/* 2403 */                     boolean isTablet = (isTabletStr != null) && (isTabletStr.trim().equals("true"));
/*      */                     
/* 2405 */                     out.write(10);
/* 2406 */                     out.write(10);
/* 2407 */                     out.write(10);
/* 2408 */                     out.write("\n\n  \n\n");
/* 2409 */                     CAMGraphs camGraph = null;
/* 2410 */                     camGraph = (CAMGraphs)_jspx_page_context.getAttribute("camGraph", 1);
/* 2411 */                     if (camGraph == null) {
/* 2412 */                       camGraph = new CAMGraphs();
/* 2413 */                       _jspx_page_context.setAttribute("camGraph", camGraph, 1);
/*      */                     }
/* 2415 */                     out.write(10);
/* 2416 */                     out.write(10);
/*      */                     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2429 */                     String camID = (String)request.getAttribute("camid");
/* 2430 */                     String haid = (String)request.getAttribute("haid");
/* 2431 */                     String screenID = (String)request.getAttribute("screenid");
/*      */                     
/*      */ 
/* 2434 */                     List list = CAMDBUtil.getCAMDetails(camID);
/* 2435 */                     String camName = (String)list.get(0);
/* 2436 */                     String camDescription = (String)list.get(2);
/*      */                     
/* 2438 */                     request.setAttribute("camname", camName);
/* 2439 */                     request.setAttribute("camdesc", camDescription);
/*      */                     
/* 2441 */                     request.setAttribute("needCustomizeScreen", "hint for cam_leftlinks.jsp");
/* 2442 */                     request.setAttribute("needDeleteScreen", "hint for cam_leftlinks.jsp");
/*      */                     
/* 2444 */                     List screenInfo = null;
/* 2445 */                     if (request.getAttribute("screeninfo") == null) {
/* 2446 */                       screenInfo = CAMDBUtil.getScreenInfo(Long.parseLong(screenID));
/*      */                     } else {
/* 2448 */                       screenInfo = (List)request.getAttribute("screeninfo");
/*      */                     }
/*      */                     
/* 2451 */                     Map dcTimeMap = CAMDBUtil.getLatestCollectionTimes(Long.parseLong(screenID));
/* 2452 */                     List screenAttribInfo = CAMDBUtil.getScreenAttributeInfo(Long.parseLong(screenID), Integer.parseInt((String)screenInfo.get(3)), dcTimeMap);
/* 2453 */                     boolean anyAttribs = screenAttribInfo.size() > 0;
/*      */                     
/*      */ 
/* 2456 */                     String quickNote = FormatUtil.getString("am.webclient.cam.dashboard.quicknote") + FormatUtil.getString("am.webclient.cam.dashboard.quicknote1");
/*      */                     
/*      */ 
/* 2459 */                     request.setAttribute("quicknote", quickNote);
/*      */                     
/*      */ 
/* 2462 */                     List sLinks = new ArrayList();
/* 2463 */                     List sText = new ArrayList();
/*      */                     
/* 2465 */                     sLinks.add("Add Screen");
/* 2466 */                     if (request.isUserInRole("DEMO"))
/*      */                     {
/* 2468 */                       sText.add("javascript:alertUser()");
/*      */                     }
/*      */                     else
/*      */                     {
/* 2472 */                       sText.add("/ShowCAM.do?method=addScreen&camid=" + camID + "&haid=" + haid);
/*      */                     }
/*      */                     
/*      */ 
/* 2476 */                     String configureLink = "/ShowCAM.do?method=configureScreen&screenid=" + screenID + "&camid=" + camID + "&haid=" + haid;
/* 2477 */                     sLinks.add("Customize");
/* 2478 */                     if (request.isUserInRole("DEMO"))
/*      */                     {
/* 2480 */                       sText.add("javascript:alertUser()");
/*      */                     }
/*      */                     else
/*      */                     {
/* 2484 */                       sText.add(configureLink);
/*      */                     }
/*      */                     
/*      */ 
/* 2488 */                     if (request.isUserInRole("DEMO"))
/*      */                     {
/* 2490 */                       sText.add("<a href=\"javascript:alertUser()\" class='staticlinks'>Delete Screen</a>");
/*      */                     }
/*      */                     else
/*      */                     {
/* 2494 */                       sLinks.add("<a href=\"/CAMDeleteScreen.do?method=deleteScreen&screenid=" + screenID + "&camid=" + camID + "&haid=" + haid + "\" onclick=\"return deleteScreen();\" class='staticlinks'>Delete Screen</a>");
/*      */                     }
/* 2496 */                     sText.add("");
/*      */                     
/*      */ 
/*      */ 
/* 2500 */                     List[] secondLevelOfLinks = { sText, sLinks };
/* 2501 */                     String secondLevelLinkTitle = "Admin Activity";
/*      */                     
/* 2503 */                     request.setAttribute("secondLevelOfLinks", secondLevelOfLinks);
/* 2504 */                     request.setAttribute("secondLevelLinkTitle", secondLevelLinkTitle);
/*      */                     
/*      */ 
/*      */ 
/*      */ 
/* 2509 */                     String configureThresholdRedirectLink = "/ShowCAM.do?method=showScreen&haid=" + haid + "&camid=" + camID + "&screenid=" + screenID;
/* 2510 */                     configureThresholdRedirectLink = URLEncoder.encode(configureThresholdRedirectLink);
/*      */                     
/*      */ 
/*      */ 
/* 2514 */                     List attributesList = (List)request.getAttribute("attributeslist");
/*      */                     
/*      */ 
/* 2517 */                     out.write("\n\n\n\n\n");
/*      */                     
/* 2519 */                     InsertTag _jspx_th_tiles_005finsert_005f0 = (InsertTag)this._005fjspx_005ftagPool_005ftiles_005finsert_0026_005fpage.get(InsertTag.class);
/* 2520 */                     _jspx_th_tiles_005finsert_005f0.setPageContext(_jspx_page_context);
/* 2521 */                     _jspx_th_tiles_005finsert_005f0.setParent(null);
/*      */                     
/* 2523 */                     _jspx_th_tiles_005finsert_005f0.setPage("/jsp/ServerLayout.jsp");
/* 2524 */                     int _jspx_eval_tiles_005finsert_005f0 = _jspx_th_tiles_005finsert_005f0.doStartTag();
/* 2525 */                     if (_jspx_eval_tiles_005finsert_005f0 != 0) {
/*      */                       for (;;) {
/* 2527 */                         out.write(10);
/* 2528 */                         if (_jspx_meth_tiles_005fput_005f0(_jspx_th_tiles_005finsert_005f0, _jspx_page_context))
/*      */                           return;
/* 2530 */                         out.write(10);
/* 2531 */                         if (_jspx_meth_tiles_005fput_005f1(_jspx_th_tiles_005finsert_005f0, _jspx_page_context))
/*      */                           return;
/* 2533 */                         out.write(10);
/* 2534 */                         if (_jspx_meth_tiles_005fput_005f2(_jspx_th_tiles_005finsert_005f0, _jspx_page_context))
/*      */                           return;
/* 2536 */                         out.write(10);
/*      */                         
/* 2538 */                         PutTag _jspx_th_tiles_005fput_005f3 = (PutTag)this._005fjspx_005ftagPool_005ftiles_005fput_0026_005ftype_005fname.get(PutTag.class);
/* 2539 */                         _jspx_th_tiles_005fput_005f3.setPageContext(_jspx_page_context);
/* 2540 */                         _jspx_th_tiles_005fput_005f3.setParent(_jspx_th_tiles_005finsert_005f0);
/*      */                         
/* 2542 */                         _jspx_th_tiles_005fput_005f3.setName("UserArea");
/*      */                         
/* 2544 */                         _jspx_th_tiles_005fput_005f3.setType("string");
/* 2545 */                         int _jspx_eval_tiles_005fput_005f3 = _jspx_th_tiles_005fput_005f3.doStartTag();
/* 2546 */                         if (_jspx_eval_tiles_005fput_005f3 != 0) {
/* 2547 */                           if (_jspx_eval_tiles_005fput_005f3 != 1) {
/* 2548 */                             out = _jspx_page_context.pushBody();
/* 2549 */                             _jspx_th_tiles_005fput_005f3.setBodyContent((javax.servlet.jsp.tagext.BodyContent)out);
/* 2550 */                             _jspx_th_tiles_005fput_005f3.doInitBody();
/*      */                           }
/*      */                           for (;;) {
/* 2553 */                             out.write("\n<script>\nfunction deleteScreen() { \n    \n    if(confirm(\"Are you sure you want to delete this screen and all its attributes ?\")) { \n        //var url = \"/CAMDeleteScreen.do?method=deleteScreen&screenid=");
/* 2554 */                             out.print(screenID);
/* 2555 */                             out.write("&camid=");
/* 2556 */                             out.print(camID);
/* 2557 */                             out.write("&haid=");
/* 2558 */                             out.print(haid);
/* 2559 */                             out.write("\";\n        //document.CAMDeleteAttribsForm.action = url;\n        //document.CAMDeleteAttribsForm.submit();\n        return true;\n    }\n    return false;\n}\n</script>\n\n<table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n  <tr>\n\t");
/*      */                             
/* 2561 */                             Hashtable ht = (Hashtable)pageContext.findAttribute("applications");
/* 2562 */                             String aid = request.getParameter("haid");
/* 2563 */                             String haName = null;
/* 2564 */                             if (aid != null)
/*      */                             {
/* 2566 */                               haName = (String)ht.get(aid);
/*      */                             }
/*      */                             
/* 2569 */                             out.write(10);
/* 2570 */                             out.write(9);
/* 2571 */                             if (_jspx_meth_c_005fcatch_005f0(_jspx_th_tiles_005fput_005f3, _jspx_page_context))
/*      */                               return;
/* 2573 */                             out.write(10);
/* 2574 */                             out.write(9);
/*      */                             
/* 2576 */                             IfTag _jspx_th_c_005fif_005f0 = (IfTag)this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(IfTag.class);
/* 2577 */                             _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
/* 2578 */                             _jspx_th_c_005fif_005f0.setParent(_jspx_th_tiles_005fput_005f3);
/*      */                             
/* 2580 */                             _jspx_th_c_005fif_005f0.setTest("${!empty param.haid && (empty invalidhaid)}");
/* 2581 */                             int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
/* 2582 */                             if (_jspx_eval_c_005fif_005f0 != 0) {
/*      */                               for (;;) {
/* 2584 */                                 out.write("\n      <td class=\"bcsign\"  height=\"22\" valign=\"top\"> ");
/* 2585 */                                 out.print(BreadcrumbUtil.getHomePage(request));
/* 2586 */                                 out.write(" &gt; ");
/* 2587 */                                 out.print(BreadcrumbUtil.getHAPage(aid, haName));
/* 2588 */                                 out.write(" &gt; ");
/* 2589 */                                 out.print(BreadcrumbUtil.getCAMDetailsPage(camID, aid, camName));
/* 2590 */                                 out.write(" &gt; <span class=\"bcactive\"> ");
/* 2591 */                                 out.print(screenInfo.get(1));
/* 2592 */                                 out.write(" </span></td>\n\t");
/* 2593 */                                 int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
/* 2594 */                                 if (evalDoAfterBody != 2)
/*      */                                   break;
/*      */                               }
/*      */                             }
/* 2598 */                             if (_jspx_th_c_005fif_005f0.doEndTag() == 5) {
/* 2599 */                               this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0); return;
/*      */                             }
/*      */                             
/* 2602 */                             this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
/* 2603 */                             out.write(10);
/* 2604 */                             out.write(9);
/*      */                             
/* 2606 */                             IfTag _jspx_th_c_005fif_005f1 = (IfTag)this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(IfTag.class);
/* 2607 */                             _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
/* 2608 */                             _jspx_th_c_005fif_005f1.setParent(_jspx_th_tiles_005fput_005f3);
/*      */                             
/* 2610 */                             _jspx_th_c_005fif_005f1.setTest("${(!empty param.haid && (!empty invalidhaid)) || (empty param.haid)}");
/* 2611 */                             int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
/* 2612 */                             if (_jspx_eval_c_005fif_005f1 != 0) {
/*      */                               for (;;) {
/* 2614 */                                 out.write("\t\n      <td class=\"bcsign\"  height=\"22\" valign=\"top\"> ");
/* 2615 */                                 out.print(BreadcrumbUtil.getMonitorsPage());
/* 2616 */                                 out.write(" &gt; ");
/* 2617 */                                 out.print(BreadcrumbUtil.getMonitorResourceTypes("Custom-Application"));
/* 2618 */                                 out.write(" &gt; ");
/* 2619 */                                 out.print(BreadcrumbUtil.getCAMDetailsPage(camID, aid, camName));
/* 2620 */                                 out.write(" &gt; <span class=\"bcactive\"> ");
/* 2621 */                                 out.print(screenInfo.get(1));
/* 2622 */                                 out.write(" </span></td>\n\t");
/* 2623 */                                 int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
/* 2624 */                                 if (evalDoAfterBody != 2)
/*      */                                   break;
/*      */                               }
/*      */                             }
/* 2628 */                             if (_jspx_th_c_005fif_005f1.doEndTag() == 5) {
/* 2629 */                               this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1); return;
/*      */                             }
/*      */                             
/* 2632 */                             this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
/* 2633 */                             out.write("\t\n    </tr>\n\t<tr>\n\t\t<td  height=\"2\" class=\"bcstrip\"><img src=\"../images/spacer.gif\" width=\"10\" height=\"2\"></td>\n\t</tr>\n\t<tr>\n\t\t<td  height=\"2\"><img src=\"../images/spacer.gif\" width=\"10\" height=\"9\"></td>\n\t</tr>\n</table>\n\n<table width=\"99%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"lrtbdarkborder\">\n<tr>\n\t<td class=\"tableheadingbborder\" colspan=3  height=\"29\" > <span> \n      &nbsp;");
/* 2634 */                             out.print(screenInfo.get(1));
/* 2635 */                             out.write(32);
/* 2636 */                             out.write(58);
/* 2637 */                             out.write(32);
/* 2638 */                             out.print(screenInfo.get(2));
/* 2639 */                             out.write(" \n      </span> </td>\n</tr>\n\n");
/* 2640 */                             if (!anyAttribs) {
/* 2641 */                               out.write("\n\n<tr>\n\t<td class=\"whitegrayborder\" colspan=3  height=\"29\" >&nbsp; </td>\n</tr>\n\n<tr>\n\t<td class=\"whitegrayborder\" colspan=3  height=\"29\" > <span class=\"bodytext\"> \n      ");
/* 2642 */                               out.print(FormatUtil.getString("am.webclient.cam.message"));
/* 2643 */                               out.write(" '<a class='staticlinks' href=\"");
/* 2644 */                               out.print(configureLink);
/* 2645 */                               out.write(34);
/* 2646 */                               out.write(62);
/* 2647 */                               out.print(FormatUtil.getString("am.webclient.cam.customize.link"));
/* 2648 */                               out.write("</a>' ");
/* 2649 */                               out.print(FormatUtil.getString("am.webclient.cam.message1"));
/* 2650 */                               out.write("\n\n      </span> </td>\n</tr>\n\n");
/*      */                             }
/* 2652 */                             out.write(10);
/* 2653 */                             out.write(10);
/* 2654 */                             out.write(10);
/*      */                             
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2668 */                             List row = null;
/* 2669 */                             int posOfAttribName = 1;
/* 2670 */                             int posOfAttribValue = 5;
/* 2671 */                             int posOfResourceID = 4;
/* 2672 */                             int posOfAttribID = 0;
/* 2673 */                             int posOfAttribType = 2;
/* 2674 */                             String className = "whitegrayborder";
/* 2675 */                             String yaxisLabel = null;
/* 2676 */                             int size = screenAttribInfo.size();
/* 2677 */                             for (int i = 0; i < screenAttribInfo.size(); i++) {
/* 2678 */                               row = (List)screenAttribInfo.get(i);
/* 2679 */                               int attribID = Integer.parseInt((String)row.get(posOfAttribID));
/* 2680 */                               camGraph.setParam(attribID);
/* 2681 */                               yaxisLabel = getTrimmedText((String)row.get(posOfAttribName), 20);
/*      */                               
/* 2683 */                               if (i % 2 == 0) {
/* 2684 */                                 out.println("<tr>");
/*      */                               }
/*      */                               
/*      */ 
/*      */ 
/*      */ 
/* 2690 */                               out.write("\n    <td>\n             <table width=\"100%\" border=\"0\" align=center cellspacing=\"0\" cellpadding=\"0\" >\n             <tr> <td><span class='bodytextbold'><br>&nbsp;&nbsp;&nbsp;&nbsp;Attribute :</span><span class='bodytext'> ");
/* 2691 */                               out.print(row.get(posOfAttribName));
/* 2692 */                               out.write("  \n&nbsp;&nbsp;\n[ <A class='staticlinks' href='/jsp/ThresholdActionConfiguration.jsp?resourceid=");
/* 2693 */                               out.print(row.get(posOfResourceID));
/* 2694 */                               out.write("&attributeIDs=");
/* 2695 */                               out.print(row.get(posOfAttribID));
/* 2696 */                               out.write("&attributeToSelect=");
/* 2697 */                               out.print(row.get(posOfAttribID));
/* 2698 */                               out.write("&redirectto=");
/* 2699 */                               out.print(configureThresholdRedirectLink);
/* 2700 */                               out.write(39);
/* 2701 */                               out.write(62);
/* 2702 */                               out.print(ALERTCONFIG_TEXT);
/* 2703 */                               out.write("</A> ]&nbsp;&nbsp;\n</span>\n                    <br><br>\n                  </td>\n             </tr>\n              <tr>  \n               <td> \n                   ");
/*      */                               
/* 2705 */                               TimeChart _jspx_th_awolf_005ftimechart_005f0 = (TimeChart)this._005fjspx_005ftagPool_005fawolf_005ftimechart_0026_005fyaxisLabel_005fxaxisLabel_005fwidth_005flegend_005fheight_005fdataSetProducer.get(TimeChart.class);
/* 2706 */                               _jspx_th_awolf_005ftimechart_005f0.setPageContext(_jspx_page_context);
/* 2707 */                               _jspx_th_awolf_005ftimechart_005f0.setParent(_jspx_th_tiles_005fput_005f3);
/*      */                               
/* 2709 */                               _jspx_th_awolf_005ftimechart_005f0.setDataSetProducer("camGraph");
/*      */                               
/* 2711 */                               _jspx_th_awolf_005ftimechart_005f0.setWidth("300");
/*      */                               
/* 2713 */                               _jspx_th_awolf_005ftimechart_005f0.setHeight("170");
/*      */                               
/* 2715 */                               _jspx_th_awolf_005ftimechart_005f0.setLegend("false");
/*      */                               
/* 2717 */                               _jspx_th_awolf_005ftimechart_005f0.setXaxisLabel("Time");
/*      */                               
/* 2719 */                               _jspx_th_awolf_005ftimechart_005f0.setYaxisLabel(yaxisLabel);
/* 2720 */                               int _jspx_eval_awolf_005ftimechart_005f0 = _jspx_th_awolf_005ftimechart_005f0.doStartTag();
/* 2721 */                               if (_jspx_eval_awolf_005ftimechart_005f0 != 0) {
/* 2722 */                                 if (_jspx_eval_awolf_005ftimechart_005f0 != 1) {
/* 2723 */                                   out = _jspx_page_context.pushBody();
/* 2724 */                                   _jspx_th_awolf_005ftimechart_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent)out);
/* 2725 */                                   _jspx_th_awolf_005ftimechart_005f0.doInitBody();
/*      */                                 }
/*      */                                 for (;;) {
/* 2728 */                                   out.write("\n      ");
/* 2729 */                                   int evalDoAfterBody = _jspx_th_awolf_005ftimechart_005f0.doAfterBody();
/* 2730 */                                   if (evalDoAfterBody != 2)
/*      */                                     break;
/*      */                                 }
/* 2733 */                                 if (_jspx_eval_awolf_005ftimechart_005f0 != 1) {
/* 2734 */                                   out = _jspx_page_context.popBody();
/*      */                                 }
/*      */                               }
/* 2737 */                               if (_jspx_th_awolf_005ftimechart_005f0.doEndTag() == 5) {
/* 2738 */                                 this._005fjspx_005ftagPool_005fawolf_005ftimechart_0026_005fyaxisLabel_005fxaxisLabel_005fwidth_005flegend_005fheight_005fdataSetProducer.reuse(_jspx_th_awolf_005ftimechart_005f0); return;
/*      */                               }
/*      */                               
/* 2741 */                               this._005fjspx_005ftagPool_005fawolf_005ftimechart_0026_005fyaxisLabel_005fxaxisLabel_005fwidth_005flegend_005fheight_005fdataSetProducer.reuse(_jspx_th_awolf_005ftimechart_005f0);
/* 2742 */                               out.write("\n\t\t\t  \n                </td>\n              <tr>\n             </table>   \n    </td>    \n");
/*      */                               
/* 2744 */                               if (i % 2 == 1) {
/* 2745 */                                 out.println("</tr>");
/* 2746 */                               } else if (i == size - 1) {
/* 2747 */                                 out.println("<td>&nbsp;</td>");
/* 2748 */                                 out.println("</tr>");
/*      */                               }
/*      */                             }
/*      */                             
/*      */ 
/*      */ 
/* 2754 */                             out.write("\n</table>\n<br>\n    \n  \n\n\n");
/* 2755 */                             int evalDoAfterBody = _jspx_th_tiles_005fput_005f3.doAfterBody();
/* 2756 */                             if (evalDoAfterBody != 2)
/*      */                               break;
/*      */                           }
/* 2759 */                           if (_jspx_eval_tiles_005fput_005f3 != 1) {
/* 2760 */                             out = _jspx_page_context.popBody();
/*      */                           }
/*      */                         }
/* 2763 */                         if (_jspx_th_tiles_005fput_005f3.doEndTag() == 5) {
/* 2764 */                           this._005fjspx_005ftagPool_005ftiles_005fput_0026_005ftype_005fname.reuse(_jspx_th_tiles_005fput_005f3); return;
/*      */                         }
/*      */                         
/* 2767 */                         this._005fjspx_005ftagPool_005ftiles_005fput_0026_005ftype_005fname.reuse(_jspx_th_tiles_005fput_005f3);
/* 2768 */                         out.write(32);
/* 2769 */                         out.write(10);
/* 2770 */                         out.write(32);
/* 2771 */                         if (_jspx_meth_tiles_005fput_005f4(_jspx_th_tiles_005finsert_005f0, _jspx_page_context))
/*      */                           return;
/* 2773 */                         out.write(10);
/* 2774 */                         int evalDoAfterBody = _jspx_th_tiles_005finsert_005f0.doAfterBody();
/* 2775 */                         if (evalDoAfterBody != 2)
/*      */                           break;
/*      */                       }
/*      */                     }
/* 2779 */                     if (_jspx_th_tiles_005finsert_005f0.doEndTag() == 5) {
/* 2780 */                       this._005fjspx_005ftagPool_005ftiles_005finsert_0026_005fpage.reuse(_jspx_th_tiles_005finsert_005f0);
/*      */                     }
/*      */                     else {
/* 2783 */                       this._005fjspx_005ftagPool_005ftiles_005finsert_0026_005fpage.reuse(_jspx_th_tiles_005finsert_005f0);
/* 2784 */                       out.write("\n\n\n\n\n\n\n");
/*      */                     }
/* 2786 */                   } } } } } } } } catch (Throwable t) { if (!(t instanceof javax.servlet.jsp.SkipPageException)) {
/* 2787 */         out = _jspx_out;
/* 2788 */         if ((out != null) && (out.getBufferSize() != 0))
/* 2789 */           try { out.clearBuffer(); } catch (java.io.IOException e) {}
/* 2790 */         if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
/*      */       }
/*      */     } finally {
/* 2793 */       _jspxFactory.releasePageContext(_jspx_page_context);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean _jspx_meth_tiles_005fput_005f0(JspTag _jspx_th_tiles_005finsert_005f0, PageContext _jspx_page_context) throws Throwable
/*      */   {
/* 2799 */     PageContext pageContext = _jspx_page_context;
/* 2800 */     JspWriter out = _jspx_page_context.getOut();
/*      */     
/* 2802 */     PutTag _jspx_th_tiles_005fput_005f0 = (PutTag)this._005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(PutTag.class);
/* 2803 */     _jspx_th_tiles_005fput_005f0.setPageContext(_jspx_page_context);
/* 2804 */     _jspx_th_tiles_005fput_005f0.setParent((Tag)_jspx_th_tiles_005finsert_005f0);
/*      */     
/* 2806 */     _jspx_th_tiles_005fput_005f0.setName("title");
/*      */     
/* 2808 */     _jspx_th_tiles_005fput_005f0.setValue("Custom Screen");
/* 2809 */     int _jspx_eval_tiles_005fput_005f0 = _jspx_th_tiles_005fput_005f0.doStartTag();
/* 2810 */     if (_jspx_th_tiles_005fput_005f0.doEndTag() == 5) {
/* 2811 */       this._005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f0);
/* 2812 */       return true;
/*      */     }
/* 2814 */     this._005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f0);
/* 2815 */     return false;
/*      */   }
/*      */   
/*      */   private boolean _jspx_meth_tiles_005fput_005f1(JspTag _jspx_th_tiles_005finsert_005f0, PageContext _jspx_page_context) throws Throwable
/*      */   {
/* 2820 */     PageContext pageContext = _jspx_page_context;
/* 2821 */     JspWriter out = _jspx_page_context.getOut();
/*      */     
/* 2823 */     PutTag _jspx_th_tiles_005fput_005f1 = (PutTag)this._005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(PutTag.class);
/* 2824 */     _jspx_th_tiles_005fput_005f1.setPageContext(_jspx_page_context);
/* 2825 */     _jspx_th_tiles_005fput_005f1.setParent((Tag)_jspx_th_tiles_005finsert_005f0);
/*      */     
/* 2827 */     _jspx_th_tiles_005fput_005f1.setName("Header");
/*      */     
/* 2829 */     _jspx_th_tiles_005fput_005f1.setValue("/jsp/header.jsp");
/* 2830 */     int _jspx_eval_tiles_005fput_005f1 = _jspx_th_tiles_005fput_005f1.doStartTag();
/* 2831 */     if (_jspx_th_tiles_005fput_005f1.doEndTag() == 5) {
/* 2832 */       this._005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f1);
/* 2833 */       return true;
/*      */     }
/* 2835 */     this._005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f1);
/* 2836 */     return false;
/*      */   }
/*      */   
/*      */   private boolean _jspx_meth_tiles_005fput_005f2(JspTag _jspx_th_tiles_005finsert_005f0, PageContext _jspx_page_context) throws Throwable
/*      */   {
/* 2841 */     PageContext pageContext = _jspx_page_context;
/* 2842 */     JspWriter out = _jspx_page_context.getOut();
/*      */     
/* 2844 */     PutTag _jspx_th_tiles_005fput_005f2 = (PutTag)this._005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(PutTag.class);
/* 2845 */     _jspx_th_tiles_005fput_005f2.setPageContext(_jspx_page_context);
/* 2846 */     _jspx_th_tiles_005fput_005f2.setParent((Tag)_jspx_th_tiles_005finsert_005f0);
/*      */     
/* 2848 */     _jspx_th_tiles_005fput_005f2.setName("ServerLeftArea");
/*      */     
/* 2850 */     _jspx_th_tiles_005fput_005f2.setValue("/jsp/cam_leftlinksarea.jsp");
/* 2851 */     int _jspx_eval_tiles_005fput_005f2 = _jspx_th_tiles_005fput_005f2.doStartTag();
/* 2852 */     if (_jspx_th_tiles_005fput_005f2.doEndTag() == 5) {
/* 2853 */       this._005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f2);
/* 2854 */       return true;
/*      */     }
/* 2856 */     this._005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f2);
/* 2857 */     return false;
/*      */   }
/*      */   
/*      */   private boolean _jspx_meth_c_005fcatch_005f0(JspTag _jspx_th_tiles_005fput_005f3, PageContext _jspx_page_context) throws Throwable
/*      */   {
/* 2862 */     PageContext pageContext = _jspx_page_context;
/* 2863 */     JspWriter out = _jspx_page_context.getOut();
/*      */     
/* 2865 */     CatchTag _jspx_th_c_005fcatch_005f0 = (CatchTag)this._005fjspx_005ftagPool_005fc_005fcatch_0026_005fvar.get(CatchTag.class);
/* 2866 */     _jspx_th_c_005fcatch_005f0.setPageContext(_jspx_page_context);
/* 2867 */     _jspx_th_c_005fcatch_005f0.setParent((Tag)_jspx_th_tiles_005fput_005f3);
/*      */     
/* 2869 */     _jspx_th_c_005fcatch_005f0.setVar("invalidhaid");
/* 2870 */     int[] _jspx_push_body_count_c_005fcatch_005f0 = { 0 };
/*      */     try {
/* 2872 */       int _jspx_eval_c_005fcatch_005f0 = _jspx_th_c_005fcatch_005f0.doStartTag();
/* 2873 */       int evalDoAfterBody; if (_jspx_eval_c_005fcatch_005f0 != 0) {
/*      */         for (;;) {
/* 2875 */           out.write("\n\t    ");
/* 2876 */           if (_jspx_meth_fmt_005fparseNumber_005f0(_jspx_th_c_005fcatch_005f0, _jspx_page_context, _jspx_push_body_count_c_005fcatch_005f0))
/* 2877 */             return true;
/* 2878 */           out.write(10);
/* 2879 */           out.write(9);
/* 2880 */           evalDoAfterBody = _jspx_th_c_005fcatch_005f0.doAfterBody();
/* 2881 */           if (evalDoAfterBody != 2)
/*      */             break;
/*      */         }
/*      */       }
/* 2885 */       if (_jspx_th_c_005fcatch_005f0.doEndTag() == 5)
/* 2886 */         return 1;
/*      */     } catch (Throwable _jspx_exception) {
/*      */       for (;;) {
/* 2889 */         int tmp191_190 = 0; int[] tmp191_188 = _jspx_push_body_count_c_005fcatch_005f0; int tmp193_192 = tmp191_188[tmp191_190];tmp191_188[tmp191_190] = (tmp193_192 - 1); if (tmp193_192 <= 0) break;
/* 2890 */         out = _jspx_page_context.popBody(); }
/* 2891 */       _jspx_th_c_005fcatch_005f0.doCatch(_jspx_exception);
/*      */     } finally {
/* 2893 */       _jspx_th_c_005fcatch_005f0.doFinally();
/* 2894 */       this._005fjspx_005ftagPool_005fc_005fcatch_0026_005fvar.reuse(_jspx_th_c_005fcatch_005f0);
/*      */     }
/* 2896 */     return false;
/*      */   }
/*      */   
/*      */   private boolean _jspx_meth_fmt_005fparseNumber_005f0(JspTag _jspx_th_c_005fcatch_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fcatch_005f0) throws Throwable
/*      */   {
/* 2901 */     PageContext pageContext = _jspx_page_context;
/* 2902 */     JspWriter out = _jspx_page_context.getOut();
/*      */     
/* 2904 */     ParseNumberTag _jspx_th_fmt_005fparseNumber_005f0 = (ParseNumberTag)this._005fjspx_005ftagPool_005ffmt_005fparseNumber_0026_005fvar_005fvalue_005fnobody.get(ParseNumberTag.class);
/* 2905 */     _jspx_th_fmt_005fparseNumber_005f0.setPageContext(_jspx_page_context);
/* 2906 */     _jspx_th_fmt_005fparseNumber_005f0.setParent((Tag)_jspx_th_c_005fcatch_005f0);
/*      */     
/* 2908 */     _jspx_th_fmt_005fparseNumber_005f0.setVar("wnhaid");
/*      */     
/* 2910 */     _jspx_th_fmt_005fparseNumber_005f0.setValue("${param.haid}");
/* 2911 */     int _jspx_eval_fmt_005fparseNumber_005f0 = _jspx_th_fmt_005fparseNumber_005f0.doStartTag();
/* 2912 */     if (_jspx_th_fmt_005fparseNumber_005f0.doEndTag() == 5) {
/* 2913 */       this._005fjspx_005ftagPool_005ffmt_005fparseNumber_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_fmt_005fparseNumber_005f0);
/* 2914 */       return true;
/*      */     }
/* 2916 */     this._005fjspx_005ftagPool_005ffmt_005fparseNumber_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_fmt_005fparseNumber_005f0);
/* 2917 */     return false;
/*      */   }
/*      */   
/*      */   private boolean _jspx_meth_tiles_005fput_005f4(JspTag _jspx_th_tiles_005finsert_005f0, PageContext _jspx_page_context) throws Throwable
/*      */   {
/* 2922 */     PageContext pageContext = _jspx_page_context;
/* 2923 */     JspWriter out = _jspx_page_context.getOut();
/*      */     
/* 2925 */     PutTag _jspx_th_tiles_005fput_005f4 = (PutTag)this._005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.get(PutTag.class);
/* 2926 */     _jspx_th_tiles_005fput_005f4.setPageContext(_jspx_page_context);
/* 2927 */     _jspx_th_tiles_005fput_005f4.setParent((Tag)_jspx_th_tiles_005finsert_005f0);
/*      */     
/* 2929 */     _jspx_th_tiles_005fput_005f4.setName("footer");
/*      */     
/* 2931 */     _jspx_th_tiles_005fput_005f4.setValue("/jsp/footer.jsp");
/* 2932 */     int _jspx_eval_tiles_005fput_005f4 = _jspx_th_tiles_005fput_005f4.doStartTag();
/* 2933 */     if (_jspx_th_tiles_005fput_005f4.doEndTag() == 5) {
/* 2934 */       this._005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f4);
/* 2935 */       return true;
/*      */     }
/* 2937 */     this._005fjspx_005ftagPool_005ftiles_005fput_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fput_005f4);
/* 2938 */     return false;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\ManageEngine\AppManager12\working\WEB-INF\lib\AdventNetAppManagerWebClient.jar!\org\apache\jsp\jsp\cam_005fshowdashboardcustomscreen_jsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */