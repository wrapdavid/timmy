/*      */ package org.apache.jsp.jsp;
/*      */ 
/*      */ import com.adventnet.appmanager.client.resourcemanagement.ManagedApplication;
/*      */ import com.adventnet.appmanager.db.AMConnectionPool;
/*      */ import com.adventnet.appmanager.dbcache.ConfMonitorConfiguration;
/*      */ import com.adventnet.appmanager.fault.FaultUtil;
/*      */ import com.adventnet.appmanager.logging.AMLog;
/*      */ import com.adventnet.appmanager.server.framework.comm.CommDBUtil;
/*      */ import com.adventnet.appmanager.struts.actions.MyPageAction;
/*      */ import com.adventnet.appmanager.util.DBUtil;
/*      */ import com.adventnet.appmanager.util.DashboardUtil;
/*      */ import com.adventnet.appmanager.util.EnterpriseUtil;
/*      */ import com.adventnet.appmanager.util.FormatUtil;
/*      */ import com.adventnet.utilities.stringutils.StrUtil;
/*      */ import com.manageengine.it360.sp.customermanagement.CustomerManagementAPI;
/*      */ import java.io.IOException;
/*      */ import java.net.InetAddress;
/*      */ import java.net.URLEncoder;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.text.DecimalFormat;
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
/*      */ import java.util.Set;
/*      */ import java.util.StringTokenizer;
/*      */ import java.util.Vector;
/*      */ import javax.servlet.ServletConfig;
/*      */ import javax.servlet.http.HttpServletRequest;
/*      */ import javax.servlet.http.HttpServletResponse;
/*      */ import javax.servlet.http.HttpSession;
/*      */ import javax.servlet.jsp.JspFactory;
/*      */ import javax.servlet.jsp.JspWriter;
/*      */ import javax.servlet.jsp.PageContext;
/*      */ import javax.servlet.jsp.tagext.JspTag;
/*      */ import javax.servlet.jsp.tagext.Tag;
/*      */ import javax.swing.tree.DefaultMutableTreeNode;
/*      */ import org.apache.jasper.runtime.TagHandlerPool;
/*      */ import org.apache.struts.taglib.logic.PresentTag;
/*      */ import org.apache.taglibs.standard.tag.el.core.IfTag;
/*      */ import org.apache.taglibs.standard.tag.el.core.OutTag;
/*      */ 
/*      */ public final class MyPage_005fTabs_jsp extends org.apache.jasper.runtime.HttpJspBase implements org.apache.jasper.runtime.JspSourceDependent
/*      */ {
/*      */   public static final String NAME_SEPARATOR = ">";
/*   53 */   public static final String ALERTCONFIG_TEXT = FormatUtil.getString("am.webclient.common.util.ALERTCONFIG_TEXT");
/*      */   public static final String STATUS_SEPARATOR = "#";
/*      */   public static final String MESSAGE_SEPARATOR = "MESSAGE";
/*   56 */   public static final String MGSTR = FormatUtil.getString("am.webclient.common.util.MGSTR");
/*   57 */   public static final String WEBMG = FormatUtil.getString("am.webclient.common.util.WEBMG");
/*   58 */   public static final String MGSTRs = FormatUtil.getString("am.webclient.common.util.MGSTRs");
/*      */   public static final String MISTR = "Monitor";
/*      */   public static final String MISTRs = "Monitors";
/*      */   public static final String RCA_SEPARATOR = " --> ";
/*      */   
/*      */   public String getOptions(String value, String text, String tableName, boolean distinct)
/*      */   {
/*   65 */     return getOptions(value, text, tableName, distinct, "");
/*      */   }
/*      */   
/*      */   public String getOptions(String value, String text, String tableName, boolean distinct, String condition)
/*      */   {
/*   70 */     ArrayList list = null;
/*   71 */     StringBuffer sbf = new StringBuffer();
/*   72 */     ManagedApplication mo = new ManagedApplication();
/*   73 */     if (distinct)
/*      */     {
/*   75 */       list = mo.getRows("SELECT distinct(" + value + ") FROM " + tableName);
/*      */     }
/*      */     else
/*      */     {
/*   79 */       list = mo.getRows("SELECT " + value + "," + text + " FROM " + tableName + " " + condition);
/*      */     }
/*      */     
/*   82 */     for (int i = 0; i < list.size(); i++)
/*      */     {
/*   84 */       ArrayList row = (ArrayList)list.get(i);
/*   85 */       sbf.append("<option value='" + row.get(0) + "'>");
/*   86 */       if (distinct) {
/*   87 */         sbf.append(row.get(0));
/*      */       } else
/*   89 */         sbf.append(row.get(1));
/*   90 */       sbf.append("</option>");
/*      */     }
/*      */     
/*   93 */     return sbf.toString(); }
/*      */   
/*   95 */   long j = 0L;
/*      */   
/*      */   private String getSeverityImageForAvailability(Object severity) {
/*   98 */     if (severity == null)
/*      */     {
/*  100 */       return "<img border=\"0\" src=\"/images/icon_availability_unknown.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*  102 */     if (severity.equals("5"))
/*      */     {
/*  104 */       return "<img border=\"0\" src=\"/images/icon_availability_up.gif\"  name=\"Image" + ++this.j + "\">";
/*      */     }
/*  106 */     if (severity.equals("1"))
/*      */     {
/*  108 */       return "<img border=\"0\" src=\"/images/icon_availability_down.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  113 */     return "<img border=\"0\" src=\"/images/icon_availability_unknown.gif\" name=\"Image" + ++this.j + "\">";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private String getSeverityImage(Object severity)
/*      */   {
/*  120 */     if (severity == null)
/*      */     {
/*  122 */       return "<img border=\"0\" src=\"/images/icon_unknown_status.gif\" alt=\"Unknown\" title=\"" + FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.unknown") + "\" align=\"absmiddle\">";
/*      */     }
/*  124 */     if (severity.equals("1"))
/*      */     {
/*  126 */       return "<img border=\"0\" src=\"/images/icon_critical.gif\" alt=\"Critical\" title=\"" + FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.critical") + "\" align=\"absmiddle\">";
/*      */     }
/*  128 */     if (severity.equals("4"))
/*      */     {
/*  130 */       return "<img border=\"0\" src=\"/images/icon_warning.gif\" alt=\"Warning\" title=\"" + FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.warning") + "\" align=\"absmiddle\">";
/*      */     }
/*  132 */     if (severity.equals("5"))
/*      */     {
/*  134 */       return "<img border=\"0\" src=\"/images/icon_clear.gif\"  alt=\"Clear\" title=\"" + FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.clear") + "\" align=\"absmiddle\" >";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  139 */     return "<img border=\"0\" src=\"/images/icon_unknown_status.gif\" alt=\"Unknown\" title=\"Unknown\" align=\"absmiddle\">";
/*      */   }
/*      */   
/*      */ 
/*      */   private String getSeverityStateForAvailability(Object severity)
/*      */   {
/*  145 */     if (severity == null)
/*      */     {
/*  147 */       return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.unknown");
/*      */     }
/*  149 */     if (severity.equals("5"))
/*      */     {
/*  151 */       return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.up");
/*      */     }
/*  153 */     if (severity.equals("1"))
/*      */     {
/*  155 */       return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.down");
/*      */     }
/*      */     
/*      */ 
/*  159 */     return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.unknown");
/*      */   }
/*      */   
/*      */ 
/*      */   private String getSeverityState(Object severity)
/*      */   {
/*  165 */     if (severity == null)
/*      */     {
/*  167 */       return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.unknown");
/*      */     }
/*  169 */     if (severity.equals("1"))
/*      */     {
/*  171 */       return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.critical");
/*      */     }
/*  173 */     if (severity.equals("4"))
/*      */     {
/*  175 */       return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.warning");
/*      */     }
/*  177 */     if (severity.equals("5"))
/*      */     {
/*  179 */       return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.clear");
/*      */     }
/*      */     
/*      */ 
/*  183 */     return FormatUtil.getString("am.webclient.hometab.monitorssnapshot.key.unknown");
/*      */   }
/*      */   
/*      */ 
/*      */   private String getSeverityImage(int severity)
/*      */   {
/*  189 */     return getSeverityImage("" + severity);
/*      */   }
/*      */   
/*      */ 
/*      */   private String getSeverityImageForAvailability(int severity)
/*      */   {
/*  195 */     if (severity == 5)
/*      */     {
/*  197 */       return "<img border=\"0\" src=\"/images/icon_availability_up.gif\"  alt=\"Up\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*  199 */     if (severity == 1)
/*      */     {
/*  201 */       return "<img border=\"0\" src=\"/images/icon_availability_down.gif\" alt=\"Down\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  206 */     return "<img border=\"0\" src=\"/images/icon_availability_unknown.gif\" alt=\"Unknown\" name=\"Image" + ++this.j + "\">";
/*      */   }
/*      */   
/*      */ 
/*      */   private String getSeverityImageForConfMonitor(String severity, boolean isAvailability)
/*      */   {
/*  212 */     if (severity == null)
/*      */     {
/*  214 */       return "<img border=\"0\" src=\"/images/icon_unknown_conf.png\" alt=\"Unknown\">";
/*      */     }
/*  216 */     if (severity.equals("5"))
/*      */     {
/*  218 */       if (isAvailability) {
/*  219 */         return "<img border=\"0\" src=\"/images/icon_up_conf.png\" alt='" + FormatUtil.getString("Up") + "' >";
/*      */       }
/*      */       
/*  222 */       return "<img border=\"0\" src=\"/images/icon_conf_hlt_clear.png\" alt='" + FormatUtil.getString("Clear") + "' >";
/*      */     }
/*      */     
/*  225 */     if ((severity.equals("4")) && (!isAvailability))
/*      */     {
/*  227 */       return "<img border=\"0\" src=\"/images/icon_warning_conf.png\" alt=\"Warning\">";
/*      */     }
/*  229 */     if (severity.equals("1"))
/*      */     {
/*  231 */       if (isAvailability) {
/*  232 */         return "<img border=\"0\" src=\"/images/icon_down_conf.png\" alt=\"Down\">";
/*      */       }
/*      */       
/*  235 */       return "<img border=\"0\" src=\"/images/icon_conf_hlt_critical.png\" alt=\"Critical\">";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  242 */     return "<img border=\"0\" src=\"/images/icon_unknown_conf.png\" alt=\"Unknown\">";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private String getSeverityImageForHealth(String severity)
/*      */   {
/*  249 */     if (severity == null)
/*      */     {
/*  251 */       return "<img border=\"0\" src=\"/images/icon_health_unknown.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*  253 */     if (severity.equals("5"))
/*      */     {
/*  255 */       return "<img border=\"0\" src=\"/images/icon_health_clear.gif\"  name=\"Image" + ++this.j + "\">";
/*      */     }
/*  257 */     if (severity.equals("4"))
/*      */     {
/*  259 */       return "<img border=\"0\" src=\"/images/icon_health_warning.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*  261 */     if (severity.equals("1"))
/*      */     {
/*  263 */       return "<img border=\"0\" src=\"/images/icon_health_critical.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  268 */     return "<img border=\"0\" src=\"/images/icon_health_unknown.gif\" name=\"Image" + ++this.j + "\">";
/*      */   }
/*      */   
/*      */ 
/*      */   private String getas400SeverityImageForHealth(String severity)
/*      */   {
/*  274 */     if (severity == null)
/*      */     {
/*  276 */       return "<img border=\"0\" src=\"/images/icon_as400health_clear.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*  278 */     if (severity.equals("5"))
/*      */     {
/*  280 */       return "<img border=\"0\" src=\"/images/icon_as400health_clear.gif\"  name=\"Image" + ++this.j + "\">";
/*      */     }
/*  282 */     if (severity.equals("4"))
/*      */     {
/*  284 */       return "<img border=\"0\" src=\"/images/icon_as400health_warning.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*  286 */     if (severity.equals("1"))
/*      */     {
/*  288 */       return "<img border=\"0\" src=\"/images/icon_as400health_critical.gif\" name=\"Image" + ++this.j + "\">";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  293 */     return "<img border=\"0\" src=\"/images/icon_as400health_clear.gif\" name=\"Image" + ++this.j + "\">";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private String getSeverityImageForHealthWithoutMouseOver(String severity)
/*      */   {
/*  300 */     if (severity == null)
/*      */     {
/*  302 */       return "<img border=\"0\" src=\"/images/icon_health_unknown_nm.gif\" alt=\"Unknown\">";
/*      */     }
/*  304 */     if (severity.equals("5"))
/*      */     {
/*  306 */       return "<img border=\"0\" src=\"/images/icon_health_clear_nm.gif\" alt=\"Clear\" >";
/*      */     }
/*  308 */     if (severity.equals("4"))
/*      */     {
/*  310 */       return "<img border=\"0\" src=\"/images/icon_health_warning_nm.gif\" alt=\"Warning\">";
/*      */     }
/*  312 */     if (severity.equals("1"))
/*      */     {
/*  314 */       return "<img border=\"0\" src=\"/images/icon_health_critical_nm.gif\" alt=\"Critical\">";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  319 */     return "<img border=\"0\" src=\"/images/icon_health_unknown_nm.gif\" alt=\"Unknown\">";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private String getSearchStrip(String map)
/*      */   {
/*  327 */     StringBuffer out = new StringBuffer();
/*  328 */     out.append("<form action=\"/Search.do\" style=\"display:inline;\" >");
/*  329 */     out.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"breadcrumbs\">");
/*  330 */     out.append("<tr class=\"breadcrumbs\"> ");
/*  331 */     out.append("  <td width=\"72%\" height=\"20\">&nbsp;&nbsp;&nbsp;&nbsp;" + map + "&nbsp; &nbsp;&nbsp;</td>");
/*  332 */     out.append("  <td width=\"9%\"> <input name=\"query\" type=\"text\" class=\"formtextsearch\" size=\"15\"></td>");
/*  333 */     out.append("  <td width=\"5%\"> &nbsp; <input name=\"Submit\" type=\"submit\" class=\"buttons\" value=\"Find\"></td>");
/*  334 */     out.append("</tr>");
/*  335 */     out.append("</form></table>");
/*  336 */     return out.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private String formatNumberForDotNet(String val)
/*      */   {
/*  343 */     if (val == null)
/*      */     {
/*  345 */       return "-";
/*      */     }
/*      */     
/*  348 */     String ret = FormatUtil.formatNumber(val);
/*  349 */     String troubleshootlink = com.adventnet.appmanager.util.OEMUtil.getOEMString("company.troubleshoot.link");
/*  350 */     if (ret.indexOf("-1") != -1)
/*      */     {
/*      */ 
/*  353 */       return "- &nbsp;<a class=\"staticlinks\" href=\"http://" + troubleshootlink + "#m44\" target=\"_blank\">" + FormatUtil.getString("am.webclient.dotnet.troubleshoot") + "</a>";
/*      */     }
/*      */     
/*      */ 
/*  357 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getHTMLTable(String[] headers, List tableData, String link, String deleteLink)
/*      */   {
/*  365 */     StringBuffer out = new StringBuffer();
/*  366 */     out.append("<table align=\"center\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"  border=\"0\">");
/*  367 */     out.append("<tr>");
/*  368 */     for (int i = 0; i < headers.length; i++)
/*      */     {
/*  370 */       out.append("<td valign=\"center\"height=\"28\" bgcolor=\"ACD5FE\" class=\"columnheading\">" + headers[i] + "</td>");
/*      */     }
/*  372 */     out.append("</tr>");
/*  373 */     for (int j = 0; j < tableData.size(); j++)
/*      */     {
/*      */ 
/*      */ 
/*  377 */       if (j % 2 == 0)
/*      */       {
/*  379 */         out.append("<tr class=\"whitegrayborder\">");
/*      */       }
/*      */       else
/*      */       {
/*  383 */         out.append("<tr class=\"yellowgrayborder\">");
/*      */       }
/*      */       
/*  386 */       List rowVector = (List)tableData.get(j);
/*      */       
/*  388 */       for (int k = 0; k < rowVector.size(); k++)
/*      */       {
/*      */ 
/*  391 */         out.append("<td height=\"22\" >" + rowVector.get(k) + "</td>");
/*      */       }
/*      */       
/*      */ 
/*  395 */       out.append("</tr>");
/*      */     }
/*  397 */     out.append("</table>");
/*  398 */     out.append("<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"tablebottom\">");
/*  399 */     out.append("<tr>");
/*  400 */     out.append("<td width=\"72%\" height=\"26\" ><A HREF=\"" + deleteLink + "\" class=\"staticlinks\">Delete</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href=\"" + link + "\" class=\"staticlinks\">Add New</a>&nbsp;&nbsp;</td>");
/*  401 */     out.append("</tr>");
/*  402 */     out.append("</table>");
/*  403 */     return out.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public static String getSingleColumnDisplay(String header, Vector tableColumns)
/*      */   {
/*  409 */     StringBuffer out = new StringBuffer();
/*  410 */     out.append("<table width=\"95%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
/*  411 */     out.append("<table width=\"95%\" height=\"5\" cellpadding=\"5\" cellspacing=\"5\" class=\"lrbborder\">");
/*  412 */     out.append("<tr>");
/*  413 */     out.append("<td align=\"center\"> <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"lrborder\">");
/*  414 */     out.append("<tr>");
/*  415 */     out.append("<td width=\"3%\" bgcolor=\"ACD5FE\" class=\"columnheading\"> <input type=\"checkbox\" name=\"maincheckbox\" value=\"checkbox\"></td>");
/*  416 */     out.append("<td width=\"15%\" bgcolor=\"ACD5FE\" class=\"columnheading\"> Name </td>");
/*  417 */     out.append("</tr>");
/*  418 */     for (int k = 0; k < tableColumns.size(); k++)
/*      */     {
/*      */ 
/*  421 */       out.append("<tr>");
/*  422 */       out.append("<td class=\"yellowgrayborder\"><input type=\"checkbox\" name=\"checkbox" + k + "\" value=\"checkbox\"></td>");
/*  423 */       out.append("<td height=\"22\" class=\"yellowgrayborder\">" + tableColumns.elementAt(k) + "</td>");
/*  424 */       out.append("</tr>");
/*      */     }
/*      */     
/*  427 */     out.append("</table>");
/*  428 */     out.append("</table>");
/*  429 */     return out.toString();
/*      */   }
/*      */   
/*      */   private String getAvailabilityImage(String severity)
/*      */   {
/*  434 */     if (severity.equals("0"))
/*      */     {
/*  436 */       return "<img src=\"/images/icon_critical.gif\" alt=\"Critical\" border=0 >";
/*      */     }
/*      */     
/*      */ 
/*  440 */     return "<img src=\"/images/icon_clear.gif\" alt=\"Clear\"  border=0>";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getQuickLinksAndNotes(String quickLinkHeader, ArrayList quickLinkText, ArrayList quickLink, String quickNote, HttpSession session)
/*      */   {
/*  447 */     return getQuickLinksAndNotes(quickLinkHeader, quickLinkText, quickLink, null, null, quickNote, session);
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
/*  460 */     StringBuffer out = new StringBuffer();
/*  461 */     out.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmnutables\">");
/*  462 */     if ((quickLinkText != null) && (quickLink != null) && (quickLinkText.size() == quickLink.size()))
/*      */     {
/*  464 */       out.append("<tr>");
/*  465 */       out.append("<td   class=\"leftlinksheading\">" + quickLinkHeader + "d,.mfnjh.mdfnh.m,dfnh,.dfmn</td>");
/*  466 */       out.append("</tr>");
/*      */       
/*      */ 
/*  469 */       for (int i = 0; i < quickLinkText.size(); i++)
/*      */       {
/*  471 */         String borderclass = "";
/*      */         
/*      */ 
/*  474 */         borderclass = "class=\"leftlinkstd\"";
/*      */         
/*  476 */         out.append("<tr>");
/*      */         
/*  478 */         out.append("<td width=\"81%\" height=\"21\" " + borderclass + ">");
/*  479 */         out.append("<a href=\"" + (String)quickLink.get(i) + "\" class=\"staticlinks\">" + (String)quickLinkText.get(i) + "</a></td>");
/*  480 */         out.append("</tr>");
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  486 */     out.append("</table><br>");
/*  487 */     out.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmnutables\">");
/*  488 */     if ((secondLevelOfLinks != null) && (secondLevelLinkTitle != null))
/*      */     {
/*  490 */       List sLinks = secondLevelOfLinks[0];
/*  491 */       List sText = secondLevelOfLinks[1];
/*  492 */       if ((sText != null) && (sLinks != null) && (sLinks.size() == sText.size()))
/*      */       {
/*      */ 
/*  495 */         out.append("<tr>");
/*  496 */         out.append("<td   class=\"leftlinksheading\">" + secondLevelLinkTitle + "</td>");
/*  497 */         out.append("</tr>");
/*  498 */         for (int i = 0; i < sText.size(); i++)
/*      */         {
/*  500 */           String borderclass = "";
/*      */           
/*      */ 
/*  503 */           borderclass = "class=\"leftlinkstd\"";
/*      */           
/*  505 */           out.append("<tr>");
/*      */           
/*  507 */           out.append("<td width=\"81%\" height=\"21\" " + borderclass + ">");
/*  508 */           if (sLinks.get(i).toString().length() == 0) {
/*  509 */             out.append((String)sText.get(i) + "</td>");
/*      */           }
/*      */           else {
/*  512 */             out.append("<a href=\"" + (String)sLinks.get(i) + "\" class=\"staticlinks\">" + (String)sText.get(i) + "</a></td>");
/*      */           }
/*  514 */           out.append("</tr>");
/*      */         }
/*      */       }
/*      */     }
/*  518 */     out.append("</table>");
/*  519 */     return out.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getQuickLinksAndNote(String quickLinkHeader, ArrayList quickLinkText, ArrayList quickLink, String secondLevelLinkTitle, List[] secondLevelOfLinks, String quickNote, HttpSession session, HttpServletRequest request)
/*      */   {
/*  526 */     StringBuffer out = new StringBuffer();
/*  527 */     out.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmnutables\">");
/*  528 */     if ((quickLinkText != null) && (quickLink != null) && (quickLinkText.size() == quickLink.size()))
/*      */     {
/*  530 */       if ((request.isUserInRole("DEMO")) || (request.isUserInRole("ADMIN")) || (request.isUserInRole("ENTERPRISEADMIN")))
/*      */       {
/*  532 */         out.append("<tr>");
/*  533 */         out.append("<td   class=\"leftlinksheading\">" + quickLinkHeader + "</td>");
/*  534 */         out.append("</tr>");
/*      */         
/*      */ 
/*      */ 
/*  538 */         for (int i = 0; i < quickLinkText.size(); i++)
/*      */         {
/*  540 */           String borderclass = "";
/*      */           
/*      */ 
/*  543 */           borderclass = "class=\"leftlinkstd\"";
/*      */           
/*  545 */           out.append("<tr>");
/*      */           
/*  547 */           out.append("<td width=\"81%\" height=\"21\" " + borderclass + ">");
/*  548 */           if (((String)quickLinkText.get(i)).indexOf("a href") == -1) {
/*  549 */             out.append("<a href=\"" + (String)quickLink.get(i) + "\" class=\"new-left-links\">" + (String)quickLinkText.get(i) + "</a>");
/*      */           }
/*      */           else {
/*  552 */             out.append((String)quickLinkText.get(i));
/*      */           }
/*      */           
/*  555 */           out.append("</td></tr>");
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  560 */     out.append("</table><br>");
/*  561 */     out.append("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmnutables\">");
/*  562 */     if ((secondLevelOfLinks != null) && (secondLevelLinkTitle != null))
/*      */     {
/*  564 */       List sLinks = secondLevelOfLinks[0];
/*  565 */       List sText = secondLevelOfLinks[1];
/*  566 */       if ((sText != null) && (sLinks != null) && (sLinks.size() == sText.size()))
/*      */       {
/*      */ 
/*  569 */         out.append("<tr>");
/*  570 */         out.append("<td   class=\"leftlinksheading\">" + secondLevelLinkTitle + "</td>");
/*  571 */         out.append("</tr>");
/*  572 */         for (int i = 0; i < sText.size(); i++)
/*      */         {
/*  574 */           String borderclass = "";
/*      */           
/*      */ 
/*  577 */           borderclass = "class=\"leftlinkstd\"";
/*      */           
/*  579 */           out.append("<tr>");
/*      */           
/*  581 */           out.append("<td width=\"81%\" height=\"21\" " + borderclass + ">");
/*  582 */           if (sLinks.get(i).toString().length() == 0) {
/*  583 */             out.append((String)sText.get(i) + "</td>");
/*      */           }
/*      */           else {
/*  586 */             out.append("<a href=\"" + (String)sLinks.get(i) + "\" class=\"new-left-links\">" + (String)sText.get(i) + "</a></td>");
/*      */           }
/*  588 */           out.append("</tr>");
/*      */         }
/*      */       }
/*      */     }
/*  592 */     out.append("</table>");
/*  593 */     return out.toString();
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
/*  606 */     switch (status)
/*      */     {
/*      */     case 1: 
/*  609 */       return "class=\"errorgrayborder\"";
/*      */     
/*      */     case 2: 
/*  612 */       return "class=\"errorgrayborder\"";
/*      */     
/*      */     case 3: 
/*  615 */       return "class=\"errorgrayborder\"";
/*      */     
/*      */     case 4: 
/*  618 */       return "class=\"errorgrayborder\"";
/*      */     
/*      */     case 5: 
/*  621 */       return "class=\"whitegrayborder\"";
/*      */     
/*      */     case 6: 
/*  624 */       return "class=\"whitegrayborder\"";
/*      */     }
/*      */     
/*  627 */     return "class=\"whitegrayborder\"";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getTrimmedText(String stringToTrim, int lengthOfTrimmedString)
/*      */   {
/*  635 */     return FormatUtil.getTrimmedText(stringToTrim, lengthOfTrimmedString);
/*      */   }
/*      */   
/*      */   public String getformatedText(String stringToTrim, int lengthOfTrimmedString, int lastPartStartsfrom)
/*      */   {
/*  640 */     return FormatUtil.getformatedText(stringToTrim, lengthOfTrimmedString, lastPartStartsfrom);
/*      */   }
/*      */   
/*      */   private String getTruncatedAlertMessage(String messageArg)
/*      */   {
/*  645 */     return FormatUtil.getTruncatedAlertMessage(messageArg);
/*      */   }
/*      */   
/*      */   private String formatDT(String val)
/*      */   {
/*  650 */     return FormatUtil.formatDT(val);
/*      */   }
/*      */   
/*      */   private String formatDT(Long val)
/*      */   {
/*  655 */     if (val != null)
/*      */     {
/*  657 */       return FormatUtil.formatDT(val.toString());
/*      */     }
/*      */     
/*      */ 
/*  661 */     return "-";
/*      */   }
/*      */   
/*      */   private String formatDTwithOutYear(String val)
/*      */   {
/*  666 */     if (val == null) {
/*  667 */       return val;
/*      */     }
/*      */     try
/*      */     {
/*  671 */       val = new java.text.SimpleDateFormat("MMM d h:mm a").format(new Date(Long.parseLong(val)));
/*      */     }
/*      */     catch (Exception e) {}
/*      */     
/*      */ 
/*  676 */     return val;
/*      */   }
/*      */   
/*      */ 
/*      */   private String formatDTwithOutYear(Long val)
/*      */   {
/*  682 */     if (val != null)
/*      */     {
/*  684 */       return formatDTwithOutYear(val.toString());
/*      */     }
/*      */     
/*      */ 
/*  688 */     return "-";
/*      */   }
/*      */   
/*      */ 
/*      */   private String formatAlertDT(String val)
/*      */   {
/*  694 */     return val.substring(0, val.lastIndexOf(":")) + val.substring(val.lastIndexOf(":") + 3);
/*      */   }
/*      */   
/*      */   private String formatNumber(Object val)
/*      */   {
/*  699 */     return FormatUtil.formatNumber(val);
/*      */   }
/*      */   
/*      */   private String formatNumber(long val) {
/*  703 */     return FormatUtil.formatNumber(val);
/*      */   }
/*      */   
/*      */   private String formatBytesToKB(String val)
/*      */   {
/*  708 */     return FormatUtil.formatBytesToKB(val) + " " + FormatUtil.getString("KB");
/*      */   }
/*      */   
/*      */   private String formatBytesToMB(String val)
/*      */   {
/*  713 */     return FormatUtil.formatBytesToMB(val) + " " + FormatUtil.getString("MB");
/*      */   }
/*      */   
/*      */   private String getHostAddress(HttpServletRequest request) throws Exception
/*      */   {
/*  718 */     String hostaddress = "";
/*  719 */     String ip = request.getHeader("x-forwarded-for");
/*  720 */     if (ip == null)
/*  721 */       ip = request.getRemoteAddr();
/*  722 */     InetAddress add = null;
/*  723 */     if (ip.equals("127.0.0.1")) {
/*  724 */       add = InetAddress.getLocalHost();
/*      */     }
/*      */     else
/*      */     {
/*  728 */       add = InetAddress.getByName(ip);
/*      */     }
/*  730 */     hostaddress = add.getHostName();
/*  731 */     if (hostaddress.indexOf('.') != -1) {
/*  732 */       StringTokenizer st = new StringTokenizer(hostaddress, ".");
/*  733 */       hostaddress = st.nextToken();
/*      */     }
/*      */     
/*      */ 
/*  737 */     return hostaddress;
/*      */   }
/*      */   
/*      */   private String removeBr(String arg)
/*      */   {
/*  742 */     return FormatUtil.replaceStringBySpecifiedString(arg, "<br>", "", 0);
/*      */   }
/*      */   
/*      */ 
/*      */   private String getSeverityImageForMssqlAvailability(Object severity)
/*      */   {
/*  748 */     if (severity == null)
/*      */     {
/*  750 */       return "<img border=\"0\" src=\"/images/icon_esx_unknown.gif\" name=\"Image" + ++this.j + "\"  onMouseOut=\"javascript:MM_swapImgRestore()\" onMouseOver=\"javascript:MM_swapImage('Image" + this.j + "','','/images/icon_esx_unknown.gif',1)\">";
/*      */     }
/*  752 */     if (severity.equals("5"))
/*      */     {
/*  754 */       return "<img border=\"0\" src=\"/images/up_icon.gif\"  name=\"Image" + ++this.j + "\"  onMouseOut=\"javascript:MM_swapImgRestore()\" onMouseOver=\"javascript:MM_swapImage('Image" + this.j + "','','/images/up_icon.gif',1)\">";
/*      */     }
/*  756 */     if (severity.equals("1"))
/*      */     {
/*  758 */       return "<img border=\"0\" src=\"/images/down_icon.gif\" name=\"Image" + ++this.j + "\"  onMouseOut=\"javascript:MM_swapImgRestore()\" onMouseOver=\"javascript:MM_swapImage('Image" + this.j + "','','/images/down_icon.gif',1)\">";
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  763 */     return "<img border=\"0\" src=\"/images/icon_esx_unknown.gif\" name=\"Image" + ++this.j + "\"  onMouseOut=\"javascript:MM_swapImgRestore()\" onMouseOver=\"javascript:MM_swapImage('Image" + this.j + "','','/images/icon_esx_unknown.gif',1)\">";
/*      */   }
/*      */   
/*      */   public String getDependentChildAttribs(String resid, String attributeId)
/*      */   {
/*  768 */     ResultSet set = null;
/*  769 */     AMConnectionPool cp = AMConnectionPool.getInstance();
/*  770 */     String dependentChildQry = "select ANYCONDITIONVALUE from AM_RCARULESMAPPER where RESOURCEID=" + resid + " and ATTRIBUTE=" + attributeId;
/*      */     try {
/*  772 */       set = AMConnectionPool.executeQueryStmt(dependentChildQry);
/*  773 */       if (set.next()) { String str1;
/*  774 */         if (set.getString("ANYCONDITIONVALUE").equals("-1")) {
/*  775 */           return FormatUtil.getString("am.fault.rcatree.allrule.text");
/*      */         }
/*      */         
/*  778 */         return FormatUtil.getString("am.fault.rcatree.anyrule.text", new String[] { set.getString("ANYCONDITIONVALUE") });
/*      */       }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  783 */       e.printStackTrace();
/*      */     }
/*      */     finally {
/*  786 */       AMConnectionPool.closeStatement(set);
/*      */     }
/*  788 */     return FormatUtil.getString("am.fault.rcatree.anyonerule.text");
/*      */   }
/*      */   
/*      */   public String getConfHealthRCA(String key) {
/*  792 */     StringBuffer rca = new StringBuffer();
/*  793 */     if ((key != null) && (key.indexOf("Root Cause :") != -1)) {
/*  794 */       key = key.substring(key.indexOf("Root Cause :") + 17, key.length());
/*      */     }
/*      */     
/*  797 */     int rcalength = key.length();
/*  798 */     String split = "6. ";
/*  799 */     int splitPresent = key.indexOf(split);
/*  800 */     String div1 = "";String div2 = "";
/*  801 */     if ((rcalength < 300) || (splitPresent < 0))
/*      */     {
/*  803 */       if (rcalength > 180) {
/*  804 */         rca.append("<span class=\"rca-critical-text\">");
/*  805 */         getRCATrimmedText(key, rca);
/*  806 */         rca.append("</span>");
/*      */       } else {
/*  808 */         rca.append("<span class=\"rca-critical-text\">");
/*  809 */         rca.append(key);
/*  810 */         rca.append("</span>");
/*      */       }
/*  812 */       return rca.toString();
/*      */     }
/*  814 */     div1 = key.substring(0, key.indexOf(split) - 4);
/*  815 */     div2 = key.substring(key.indexOf(split), rcalength - 4);
/*  816 */     rca.append("<div style='overflow: hidden; display: block; width: 100%; height: auto;'>");
/*  817 */     String rcaMesg = StrUtil.findReplace(div1, " --> ", "&nbsp;<img src=\"/images/img_arrow.gif\">&nbsp;");
/*  818 */     getRCATrimmedText(div1, rca);
/*  819 */     rca.append("<span id=\"confrcashow\" class=\"confrcashow\" onclick=\"javascript:toggleSlide('confrcahide','confrcashow','confrcahidden');\"><img src=\"/images/icon_plus.gif\" width=\"9\" height=\"7\"> " + FormatUtil.getString("am.webclient.monitorinformation.show.text") + " </span></div>");
/*      */     
/*      */ 
/*  822 */     rca.append("<div id='confrcahidden' style='display: none; width: 100%;'>");
/*  823 */     rcaMesg = StrUtil.findReplace(div2, " --> ", "&nbsp;<img src=\"/images/img_arrow.gif\">&nbsp;");
/*  824 */     getRCATrimmedText(div2, rca);
/*  825 */     rca.append("<span id=\"confrcahide\" class=\"confrcashow\" onclick=\"javascript:toggleSlide('confrcashow','confrcahide','confrcahidden')\"><img src=\"/images/icon_minus.gif\" width=\"9\" height=\"7\"> " + FormatUtil.getString("am.webclient.monitorinformation.hide.text") + " </span></div>");
/*      */     
/*  827 */     return rca.toString();
/*      */   }
/*      */   
/*      */   public void getRCATrimmedText(String msg, StringBuffer rca)
/*      */   {
/*  832 */     String[] st = msg.split("<br>");
/*  833 */     for (int i = 0; i < st.length; i++) {
/*  834 */       String s = st[i];
/*  835 */       if (s.length() > 180) {
/*  836 */         s = s.substring(0, 175) + ".....";
/*      */       }
/*  838 */       rca.append(s + "<br>");
/*      */     }
/*      */   }
/*      */   
/*  842 */   public String getConfHealthTime(String time) { if ((time != null) && (!time.trim().equals(""))) {
/*  843 */       return new Date(com.adventnet.appmanager.reporting.ReportUtilities.roundOffToNearestSeconds(Long.parseLong(time))).toString();
/*      */     }
/*  845 */     return "";
/*      */   }
/*      */   
/*      */   public String getHelpLink(String key) {
/*  849 */     String helpText = FormatUtil.getString("am.webclient.contexthelplink.text");
/*  850 */     ret = "<a href=\"/help/index.html\" title=\"" + helpText + "\" target=\"newwindow\" class=\"headerwhitelinks\" ><img src=\"/images/helpIcon.png\"/></a>";
/*  851 */     ResultSet set = null;
/*      */     try {
/*      */       String str1;
/*  854 */       if (key == null) {
/*  855 */         return ret;
/*      */       }
/*      */       
/*  858 */       if (DBUtil.searchLinks.containsKey(key)) {
/*  859 */         return "<a href=\"" + (String)DBUtil.searchLinks.get(key) + "\" title=\"" + helpText + "\" target=\"newwindow\" class=\"headerwhitelinks\" ><img src=\"/images/helpIcon.png\"/></a>";
/*      */       }
/*      */       
/*  862 */       String query = "select LINK from AM_SearchDocLinks where NAME ='" + key + "'";
/*  863 */       AMConnectionPool cp = AMConnectionPool.getInstance();
/*  864 */       set = AMConnectionPool.executeQueryStmt(query);
/*  865 */       if (set.next())
/*      */       {
/*  867 */         String helpLink = set.getString("LINK");
/*  868 */         DBUtil.searchLinks.put(key, helpLink);
/*      */         try
/*      */         {
/*  871 */           AMConnectionPool.closeStatement(set);
/*      */         }
/*      */         catch (Exception exc) {}
/*      */         
/*      */ 
/*      */ 
/*  877 */         return "<a href=\"" + helpLink + "\" title=\"" + helpText + "\" target=\"newwindow\" class=\"headerwhitelinks\" ><img src=\"/images/helpIcon.png\"/></a>";
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
/*  896 */       return ret;
/*      */     }
/*      */     catch (Exception ex) {}finally
/*      */     {
/*      */       try
/*      */       {
/*  887 */         if (set != null) {
/*  888 */           AMConnectionPool.closeStatement(set);
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
/*  902 */     Properties temp = FaultUtil.getStatus(entitylist, false);
/*  903 */     for (Enumeration keys = temp.propertyNames(); keys.hasMoreElements();)
/*      */     {
/*  905 */       String entityStr = (String)keys.nextElement();
/*  906 */       String mmessage = temp.getProperty(entityStr);
/*  907 */       mmessage = mmessage.replaceAll("\"", "&quot;");
/*  908 */       temp.setProperty(entityStr, mmessage);
/*      */     }
/*  910 */     return temp;
/*      */   }
/*      */   
/*      */ 
/*      */   public Properties getStatus(List listOfResourceIDs, List listOfAttributeIDs)
/*      */   {
/*  916 */     Properties temp = FaultUtil.getStatus(listOfResourceIDs, listOfAttributeIDs);
/*  917 */     for (Enumeration keys = temp.propertyNames(); keys.hasMoreElements();)
/*      */     {
/*  919 */       String entityStr = (String)keys.nextElement();
/*  920 */       String mmessage = temp.getProperty(entityStr);
/*  921 */       mmessage = mmessage.replaceAll("\"", "&quot;");
/*  922 */       temp.setProperty(entityStr, mmessage);
/*      */     }
/*  924 */     return temp;
/*      */   }
/*      */   
/*      */   private void debug(String debugMessage)
/*      */   {
/*  929 */     AMLog.debug("JSP : " + debugMessage);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private String findReplace(String str, String find, String replace)
/*      */   {
/*  939 */     String des = new String();
/*  940 */     while (str.indexOf(find) != -1) {
/*  941 */       des = des + str.substring(0, str.indexOf(find));
/*  942 */       des = des + replace;
/*  943 */       str = str.substring(str.indexOf(find) + find.length());
/*      */     }
/*  945 */     des = des + str;
/*  946 */     return des;
/*      */   }
/*      */   
/*      */   private String getHideAndShowRCAMessage(String test, String id, String alert, String resourceid)
/*      */   {
/*      */     try
/*      */     {
/*  953 */       if (alert == null)
/*      */       {
/*  955 */         return "&nbsp;&nbsp;" + FormatUtil.getString("am.webclient.rcamessage.healthunknown.text");
/*      */       }
/*  957 */       if ((test == null) || (test.equals("")))
/*      */       {
/*  959 */         return "&nbsp;";
/*      */       }
/*      */       
/*  962 */       if ((alert != null) && (alert.equals("5")))
/*      */       {
/*  964 */         return "&nbsp;&nbsp;" + FormatUtil.getString("am.fault.rca.healthisclear.text") + ".&nbsp;" + FormatUtil.getString("am.webclient.nocriticalalarms.current.text");
/*      */       }
/*      */       
/*  967 */       int rcalength = test.length();
/*  968 */       if (rcalength < 300)
/*      */       {
/*  970 */         return test;
/*      */       }
/*      */       
/*      */ 
/*  974 */       StringBuffer out = new StringBuffer();
/*  975 */       out.append("<div id='rcahidden' style='overflow: hidden; display: block; word-wrap: break-word; width: 500px; height: 100px'>");
/*  976 */       out.append(StrUtil.findReplace(test, " --> ", "&nbsp;<img src=\"/images/img_arrow.gif\">&nbsp;"));
/*  977 */       out.append("</div>");
/*  978 */       out.append("<div align=\"right\" id=\"rcashow" + id + "\" style=\"display:block;\" onclick=\"javascript:document.getElementById('rcahidden').style.height='auto';hideDiv('rcashow" + id + "');showDiv('rcahide" + id + "');\"><span class=\"bcactive\"><img src=\"/images/icon_plus.gif\" width=\"9\" height=\"9\"> " + FormatUtil.getString("am.webclient.monitorinformation.show.text") + " </span> </div>");
/*  979 */       out.append("<div align=\"right\" id=\"rcahide" + id + "\" style=\"display:none;\" onclick=\"javascript:document.getElementById('rcahidden').style.height='100px',hideDiv('rcahide" + id + "');showDiv('rcashow" + id + "')\"><span class=\"bcactive\"><img src=\"/images/icon_minus.gif\" width=\"9\" height=\"9\"> " + FormatUtil.getString("am.webclient.monitorinformation.hide.text") + " </span> </div>");
/*  980 */       return out.toString();
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*  985 */       ex.printStackTrace();
/*      */     }
/*  987 */     return test;
/*      */   }
/*      */   
/*      */ 
/*      */   public Properties getAlerts(List monitorList, Hashtable availabilitykeys, Hashtable healthkeys)
/*      */   {
/*  993 */     return getAlerts(monitorList, availabilitykeys, healthkeys, 1);
/*      */   }
/*      */   
/*      */   public Properties getAlerts(List monitorList, Hashtable availabilitykeys, Hashtable healthkeys, int type)
/*      */   {
/*  998 */     ArrayList attribIDs = new ArrayList();
/*  999 */     ArrayList resIDs = new ArrayList();
/* 1000 */     ArrayList entitylist = new ArrayList();
/*      */     
/* 1002 */     for (int j = 0; (monitorList != null) && (j < monitorList.size()); j++)
/*      */     {
/* 1004 */       ArrayList row = (ArrayList)monitorList.get(j);
/*      */       
/* 1006 */       String resourceid = "";
/* 1007 */       String resourceType = "";
/* 1008 */       if (type == 2) {
/* 1009 */         resourceid = (String)row.get(0);
/* 1010 */         resourceType = (String)row.get(3);
/*      */       }
/* 1012 */       else if (type == 3) {
/* 1013 */         resourceid = (String)row.get(0);
/* 1014 */         resourceType = "EC2Instance";
/*      */       }
/*      */       else {
/* 1017 */         resourceid = (String)row.get(6);
/* 1018 */         resourceType = (String)row.get(7);
/*      */       }
/* 1020 */       resIDs.add(resourceid);
/* 1021 */       String healthid = com.adventnet.appmanager.dbcache.AMAttributesCache.getHealthId(resourceType);
/* 1022 */       String availid = com.adventnet.appmanager.dbcache.AMAttributesCache.getAvailabilityId(resourceType);
/*      */       
/* 1024 */       String healthentity = null;
/* 1025 */       String availentity = null;
/* 1026 */       if (healthid != null) {
/* 1027 */         healthentity = resourceid + "_" + healthid;
/* 1028 */         entitylist.add(healthentity);
/*      */       }
/*      */       
/* 1031 */       if (availid != null) {
/* 1032 */         availentity = resourceid + "_" + availid;
/* 1033 */         entitylist.add(availentity);
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
/* 1047 */     Properties alert = getStatus(entitylist);
/* 1048 */     return alert;
/*      */   }
/*      */   
/*      */   public void getSortedMonitorList(ArrayList monitorList, Properties alert, Hashtable availabilitykeys, Hashtable healthkeys)
/*      */   {
/* 1053 */     int size = monitorList.size();
/*      */     
/* 1055 */     String[] severity = new String[size];
/*      */     
/* 1057 */     for (int j = 0; j < monitorList.size(); j++)
/*      */     {
/* 1059 */       ArrayList row1 = (ArrayList)monitorList.get(j);
/* 1060 */       String resourceName1 = (String)row1.get(7);
/* 1061 */       String resourceid1 = (String)row1.get(6);
/* 1062 */       severity[j] = alert.getProperty(resourceid1 + "#" + availabilitykeys.get(resourceName1));
/* 1063 */       if (severity[j] == null)
/*      */       {
/* 1065 */         severity[j] = "6";
/*      */       }
/*      */     }
/*      */     
/* 1069 */     for (j = 0; j < severity.length; j++)
/*      */     {
/* 1071 */       for (int k = j + 1; k < severity.length; k++)
/*      */       {
/* 1073 */         int sev = severity[j].compareTo(severity[k]);
/*      */         
/*      */ 
/* 1076 */         if (sev > 0) {
/* 1077 */           ArrayList t = (ArrayList)monitorList.get(k);
/* 1078 */           monitorList.set(k, monitorList.get(j));
/* 1079 */           monitorList.set(j, t);
/* 1080 */           String temp = severity[k];
/* 1081 */           severity[k] = severity[j];
/* 1082 */           severity[j] = temp;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1088 */     int z = 0;
/* 1089 */     for (j = 0; j < monitorList.size(); j++)
/*      */     {
/*      */ 
/* 1092 */       int i = 0;
/* 1093 */       if ((!severity[j].equals("0")) && (!severity[j].equals("1")) && (!severity[j].equals("4")))
/*      */       {
/*      */ 
/* 1096 */         i++;
/*      */       }
/*      */       else
/*      */       {
/* 1100 */         z++;
/*      */       }
/*      */     }
/*      */     
/* 1104 */     String[] hseverity = new String[monitorList.size()];
/*      */     
/* 1106 */     for (j = 0; j < z; j++)
/*      */     {
/*      */ 
/* 1109 */       hseverity[j] = severity[j];
/*      */     }
/*      */     
/*      */ 
/* 1113 */     for (j = z; j < severity.length; j++)
/*      */     {
/*      */ 
/* 1116 */       ArrayList row1 = (ArrayList)monitorList.get(j);
/* 1117 */       String resourceName1 = (String)row1.get(7);
/* 1118 */       String resourceid1 = (String)row1.get(6);
/* 1119 */       hseverity[j] = alert.getProperty(resourceid1 + "#" + healthkeys.get(resourceName1));
/* 1120 */       if (hseverity[j] == null)
/*      */       {
/* 1122 */         hseverity[j] = "6";
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1127 */     for (j = 0; j < hseverity.length; j++)
/*      */     {
/* 1129 */       for (int k = j + 1; k < hseverity.length; k++)
/*      */       {
/*      */ 
/* 1132 */         int hsev = hseverity[j].compareTo(hseverity[k]);
/*      */         
/*      */ 
/* 1135 */         if (hsev > 0) {
/* 1136 */           ArrayList t = (ArrayList)monitorList.get(k);
/* 1137 */           monitorList.set(k, monitorList.get(j));
/* 1138 */           monitorList.set(j, t);
/* 1139 */           String temp1 = hseverity[k];
/* 1140 */           hseverity[k] = hseverity[j];
/* 1141 */           hseverity[j] = temp1;
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
/* 1153 */     boolean isIt360 = com.adventnet.appmanager.util.Constants.isIt360;
/* 1154 */     boolean forInventory = false;
/* 1155 */     String trdisplay = "none";
/* 1156 */     String plusstyle = "inline";
/* 1157 */     String minusstyle = "none";
/* 1158 */     String haidTopLevel = "";
/* 1159 */     if (request.getAttribute("forInventory") != null)
/*      */     {
/* 1161 */       if ("true".equals((String)request.getAttribute("forInventory")))
/*      */       {
/* 1163 */         haidTopLevel = request.getParameter("haid");
/* 1164 */         forInventory = true;
/* 1165 */         trdisplay = "table-row;";
/* 1166 */         plusstyle = "none";
/* 1167 */         minusstyle = "inline";
/*      */       }
/*      */       
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 1174 */       haidTopLevel = resIdTOCheck;
/*      */     }
/*      */     
/* 1177 */     ArrayList listtoreturn = new ArrayList();
/* 1178 */     StringBuffer toreturn = new StringBuffer();
/* 1179 */     Hashtable availabilitykeys = (Hashtable)availhealth.get("avail");
/* 1180 */     Hashtable healthkeys = (Hashtable)availhealth.get("health");
/* 1181 */     Properties alert = (Properties)availhealth.get("alert");
/*      */     
/* 1183 */     for (int j = 0; j < singlechilmos.size(); j++)
/*      */     {
/* 1185 */       ArrayList singlerow = (ArrayList)singlechilmos.get(j);
/* 1186 */       String childresid = (String)singlerow.get(0);
/* 1187 */       String childresname = (String)singlerow.get(1);
/* 1188 */       childresname = com.adventnet.appmanager.util.ExtProdUtil.decodeString(childresname);
/* 1189 */       String childtype = ((String)singlerow.get(2) + "").trim();
/* 1190 */       String imagepath = ((String)singlerow.get(3) + "").trim();
/* 1191 */       String shortname = ((String)singlerow.get(4) + "").trim();
/* 1192 */       String unmanagestatus = (String)singlerow.get(5);
/* 1193 */       String actionstatus = (String)singlerow.get(6);
/* 1194 */       String linkclass = "monitorgp-links";
/* 1195 */       String titleforres = childresname;
/* 1196 */       String titilechildresname = childresname;
/* 1197 */       String childimg = "/images/trcont.png";
/* 1198 */       String flag = "enable";
/* 1199 */       String dcstarted = (String)singlerow.get(8);
/* 1200 */       String configMonitor = "";
/* 1201 */       String configmsg = FormatUtil.getString("am.webclient.vcenter.esx.notconfigured.text");
/* 1202 */       if (("VMWare ESX/ESXi".equals(childtype)) && (!"2".equals(dcstarted)))
/*      */       {
/* 1204 */         configMonitor = "&nbsp;&nbsp;<img src='/images/icon_ack.gif' align='absmiddle' style='width=16px;heigth:16px' border='0' title='" + configmsg + "' />";
/*      */       }
/* 1206 */       if (singlerow.get(7) != null)
/*      */       {
/* 1208 */         flag = (String)singlerow.get(7);
/*      */       }
/* 1210 */       String haiGroupType = "0";
/* 1211 */       if ("HAI".equals(childtype))
/*      */       {
/* 1213 */         haiGroupType = (String)singlerow.get(9);
/*      */       }
/* 1215 */       childimg = "/images/trend.png";
/* 1216 */       String actionmsg = FormatUtil.getString("Actions Enabled");
/* 1217 */       String actionimg = "<img src=\"/images/alarm-icon.png\" border=\"0\"  title=\"" + actionmsg + "\"  />";
/* 1218 */       if ((actionstatus == null) || (actionstatus.equalsIgnoreCase("null")) || (actionstatus.equals("1")))
/*      */       {
/* 1220 */         actionimg = "<img src=\"/images/alarm-icon.png\" border=\"0\" title=\"" + actionmsg + "\" />";
/*      */       }
/* 1222 */       else if (actionstatus.equals("0"))
/*      */       {
/* 1224 */         actionmsg = FormatUtil.getString("Actions Disabled");
/* 1225 */         actionimg = "<img src=\"/images/icon_actions_disabled.gif\" border=\"0\"   title=\"" + actionmsg + "\" />";
/*      */       }
/*      */       
/* 1228 */       if ((unmanagestatus != null) && (!unmanagestatus.trim().equalsIgnoreCase("null")))
/*      */       {
/* 1230 */         linkclass = "disabledtext";
/* 1231 */         titleforres = titleforres + "-UnManaged";
/*      */       }
/* 1233 */       String availkey = childresid + "#" + availabilitykeys.get(childtype) + "#" + "MESSAGE";
/* 1234 */       String availmouseover = "";
/* 1235 */       if (alert.getProperty(availkey) != null)
/*      */       {
/* 1237 */         availmouseover = "onmouseover=\"ddrivetip(this,event,'" + alert.getProperty(availkey).replace("\"", "&quot;") + "<br><span style=color: #000000;font-weight:bold;>" + FormatUtil.getString("am.webclient.tooltip.text") + "</span>',null,true,'#000000')\"  onmouseout=\"hideddrivetip()\" ";
/*      */       }
/* 1239 */       String healthkey = childresid + "#" + healthkeys.get(childtype) + "#" + "MESSAGE";
/* 1240 */       String healthmouseover = "";
/* 1241 */       if (alert.getProperty(healthkey) != null)
/*      */       {
/* 1243 */         healthmouseover = "onmouseover=\"ddrivetip(this,event,'" + alert.getProperty(healthkey).replace("\"", "&quot;") + "<br><span style=color: #000000;font-weight:bold;>" + FormatUtil.getString("am.webclient.tooltip.text") + "</span>',null,true,'#000000')\"  onmouseout=\"hideddrivetip()\" ";
/*      */       }
/*      */       
/* 1246 */       String tempbgcolor = "class=\"whitegrayrightalign\"";
/* 1247 */       int spacing = 0;
/* 1248 */       if (level >= 1)
/*      */       {
/* 1250 */         spacing = 40 * level;
/*      */       }
/* 1252 */       if (childtype.equals("HAI"))
/*      */       {
/* 1254 */         ArrayList singlechilmos1 = (ArrayList)childmos.get(childresid + "");
/* 1255 */         String tempresourceidtree = currentresourceidtree + "|" + childresid;
/* 1256 */         String availimage = getSeverityImageForAvailability(alert.getProperty(childresid + "#" + availabilitykeys.get(childtype)));
/*      */         
/* 1258 */         String availlink = "<a href=\"javascript:void(0);\" " + availmouseover + " onClick=\"fnOpenNewWindow('/jsp/RCA.jsp?resourceid=" + childresid + "&attributeid=" + availabilitykeys.get(childtype) + "')\"> " + availimage + "</a>";
/* 1259 */         String healthimage = getSeverityImageForHealth(alert.getProperty(childresid + "#" + healthkeys.get(childtype)));
/* 1260 */         String healthlink = "<a href=\"javascript:void(0);\" " + healthmouseover + " onClick=\"fnOpenNewWindow('/jsp/RCA.jsp?resourceid=" + childresid + "&attributeid=" + healthkeys.get(childtype) + "')\"> " + healthimage + "</a>";
/* 1261 */         String editlink = "<a href=\"/showapplication.do?method=editApplication&fromwhere=allmonitorgroups&haid=" + childresid + "\" class=\"staticlinks\" title=\"" + FormatUtil.getString("am.webclient.maintenance.edit") + "\"><img align=\"center\" src=\"/images/icon_edit.gif\" border=\"0\" /></a>";
/* 1262 */         String imglink = "<img src=\"" + childimg + "\" align=\"center\"    align=\"left\" border=\"0\" height=\"24\" width=\"24\">";
/* 1263 */         String checkbox = "<input type=\"checkbox\" name=\"select\" id=\"" + tempresourceidtree + "\" value=\"" + childresid + "\"  onclick=\"selectAllChildCKbs('" + tempresourceidtree + "',this,this.form),deselectParentCKbs('" + tempresourceidtree + "',this,this.form)\"  >";
/* 1264 */         String thresholdurl = "/showActionProfiles.do?method=getHAProfiles&haid=" + childresid;
/* 1265 */         String configalertslink = " <a title='" + FormatUtil.getString("am.webclient.common.util.ALERTCONFIG_TEXT") + "' href=\"" + thresholdurl + "\" ><img src=\"images/icon_associateaction.gif\" align=\"center\" border=\"0\" title=\"" + FormatUtil.getString("am.webclient.common.util.ALERTCONFIG_TEXT") + "\" /></a>";
/* 1266 */         String associatelink = "<a href=\"/showresource.do?method=getMonitorForm&type=All&fromwhere=monitorgroupview&haid=" + childresid + "\" title=\"" + FormatUtil.getString("am.webclient.monitorgroupdetails.associatemonitors.text") + "\" ><img align=\"center\" src=\"images/icon_assoicatemonitors.gif\" border=\"0\" /></a>";
/* 1267 */         String removefromgroup = "<a class='staticlinks' href=\"javascript: removeMonitorFromGroup ('" + resIdTOCheck + "','" + childresid + "','" + haidTopLevel + "');\" title='" + FormatUtil.getString("am.webclient.monitorgroupdetails.remove.text") + "'><img width='13' align=\"center\"  height='14' border='0' src='/images/icon_removefromgroup.gif'/></a>&nbsp;&nbsp;";
/* 1268 */         String configcustomfields = "<a href=\"javascript:void(0)\" onclick=\"fnOpenNewWindow('/jsp/MyField_Alarms.jsp?resourceid=" + childresid + "&mgview=true')\" title='" + FormatUtil.getString("am.myfield.assign.text") + "'><img align=\"center\" src=\"/images/icon_assigncustomfields.gif\" border=\"0\" /></a>";
/*      */         
/* 1270 */         if (!forInventory)
/*      */         {
/* 1272 */           removefromgroup = "";
/*      */         }
/*      */         
/* 1275 */         String actions = "&nbsp;&nbsp;" + configalertslink + "&nbsp;&nbsp;" + removefromgroup + "&nbsp;&nbsp;";
/*      */         
/* 1277 */         if ((haiGroupType == null) || ((haiGroupType != null) && (!"1009".equals(haiGroupType)) && (!"1010".equals(haiGroupType)) && (!"1012".equals(haiGroupType))))
/*      */         {
/* 1279 */           actions = editlink + actions;
/*      */         }
/* 1281 */         if ((haiGroupType == null) || ((haiGroupType != null) && (!"1009".equals(haiGroupType)) && (!"1010".equals(haiGroupType)) && (!"3".equals(haiGroupType)) && (!"1012".equals(haiGroupType))))
/*      */         {
/* 1283 */           actions = actions + associatelink;
/*      */         }
/* 1285 */         actions = actions + "&nbsp;&nbsp;&nbsp;&nbsp;" + configcustomfields;
/* 1286 */         String arrowimg = "";
/* 1287 */         if (request.isUserInRole("ENTERPRISEADMIN"))
/*      */         {
/* 1289 */           actions = "";
/* 1290 */           arrowimg = "<img align=\"center\" hspace=\"3\" border=\"0\" src=\"/images/icon_arrow_childattribute_grey.gif\"/>";
/* 1291 */           checkbox = "";
/* 1292 */           childresname = childresname + "_" + CommDBUtil.getManagedServerNameWithPort(childresid);
/*      */         }
/* 1294 */         if (isIt360)
/*      */         {
/* 1296 */           actionimg = "";
/* 1297 */           actions = "";
/* 1298 */           arrowimg = "<img align=\"center\" hspace=\"3\" border=\"0\" src=\"/images/icon_arrow_childattribute_grey.gif\"/>";
/* 1299 */           checkbox = "";
/*      */         }
/*      */         
/* 1302 */         if (!request.isUserInRole("ADMIN"))
/*      */         {
/* 1304 */           actions = "";
/*      */         }
/* 1306 */         if (request.isUserInRole("OPERATOR"))
/*      */         {
/* 1308 */           checkbox = "";
/*      */         }
/*      */         
/* 1311 */         String resourcelink = "";
/*      */         
/* 1313 */         if ((flag != null) && (flag.equals("enable")))
/*      */         {
/* 1315 */           resourcelink = "<a href=\"javascript:void(0);\" onclick=\"toggleChildMos('#monitor" + tempresourceidtree + "'),toggleTreeImage('" + tempresourceidtree + "');\"><div id=\"monitorShow" + tempresourceidtree + "\" style=\"display:" + plusstyle + ";\"><img src=\"/images/icon_plus.gif\" border=\"0\" hspace=\"5\"></div><div id=\"monitorHide" + tempresourceidtree + "\" style=\"display:" + minusstyle + ";\"><img src=\"/images/icon_minus.gif\" border=\"0\" hspace=\"5\"></div> </a>" + checkbox + "<a href=\"/showapplication.do?haid=" + childresid + "&method=showApplication\" class=\"" + linkclass + "\">" + getTrimmedText(titilechildresname, 45) + "</a> ";
/*      */         }
/*      */         else
/*      */         {
/* 1319 */           resourcelink = "<a href=\"javascript:void(0);\" onclick=\"toggleChildMos('#monitor" + tempresourceidtree + "'),toggleTreeImage('" + tempresourceidtree + "');\"><div id=\"monitorShow" + tempresourceidtree + "\" style=\"display:" + plusstyle + ";\"><img src=\"/images/icon_plus.gif\" border=\"0\" hspace=\"5\"></div><div id=\"monitorHide" + tempresourceidtree + "\" style=\"display:" + minusstyle + ";\"><img src=\"/images/icon_minus.gif\" border=\"0\" hspace=\"5\"></div> </a>" + checkbox + "" + getTrimmedText(titilechildresname, 45);
/*      */         }
/*      */         
/* 1322 */         toreturn.append("<tr " + tempbgcolor + " id=\"#monitor" + currentresourceidtree + "\" style=\"display:" + trdisplay + ";\" width='100%'>");
/* 1323 */         toreturn.append("<td " + tempbgcolor + " width=\"3%\" >&nbsp;</td> ");
/* 1324 */         toreturn.append("<td " + tempbgcolor + " width=\"47%\"  style=\"padding-left: " + spacing + "px !important;\" title=" + childresname + ">" + arrowimg + resourcelink + "</td>");
/* 1325 */         toreturn.append("<td " + tempbgcolor + " width=\"15%\" align=\"left\">" + "<table><tr class='whitegrayrightalign'><td><div id='mgaction'>" + actions + "</div></td></tr></table></td>");
/* 1326 */         toreturn.append("<td " + tempbgcolor + " width=\"8%\" align=\"center\">" + availlink + "</td>");
/* 1327 */         toreturn.append("<td " + tempbgcolor + " width=\"7%\" align=\"center\">" + healthlink + "</td>");
/* 1328 */         if (!isIt360)
/*      */         {
/* 1330 */           toreturn.append("<td " + tempbgcolor + " width=\"7%\" align=\"left\">" + actionimg + "</td>");
/*      */         }
/*      */         else
/*      */         {
/* 1334 */           toreturn.append("<td " + tempbgcolor + " width=\"7%\" align=\"left\">&nbsp;</td>");
/*      */         }
/*      */         
/* 1337 */         toreturn.append("</tr>");
/* 1338 */         if (childmos.get(childresid + "") != null)
/*      */         {
/* 1340 */           String toappend = getAllChildNodestoDisplay(singlechilmos1, childresid + "", tempresourceidtree, childmos, availhealth, level + 1, request, extDeviceMap, site24x7List);
/* 1341 */           toreturn.append(toappend);
/*      */         }
/*      */         else
/*      */         {
/* 1345 */           String assocMessage = "<td  " + tempbgcolor + " colspan=\"2\"><span class=\"bodytext\" style=\"padding-left: " + (spacing + 10) + "px !important;\"> &nbsp;&nbsp;&nbsp;&nbsp;" + FormatUtil.getString("am.webclient.monitorgroupdetails.nomonitormessage.text") + "</span><span class=\"bodytext\">";
/* 1346 */           if ((!request.isUserInRole("ENTERPRISEADMIN")) && (!request.isUserInRole("DEMO")) && (!request.isUserInRole("OPERATOR")))
/*      */           {
/*      */ 
/* 1349 */             assocMessage = assocMessage + FormatUtil.getString("am.webclient.monitorgroupdetails.click.text") + " <a href=\"/showresource.do?method=getMonitorForm&type=All&haid=" + childresid + "&fromwhere=monitorgroupview\" class=\"staticlinks\" >" + FormatUtil.getString("am.webclient.monitorgroupdetails.linktoadd.text") + "</span></td>";
/*      */           }
/*      */           
/*      */ 
/* 1353 */           if ((haiGroupType == null) || ((haiGroupType != null) && (!"1009".equals(haiGroupType)) && (!"1010".equals(haiGroupType)) && (!"3".equals(haiGroupType)) && (!"1012".equals(haiGroupType))))
/*      */           {
/* 1355 */             toreturn.append("<tr  " + tempbgcolor + "  id=\"#monitor" + tempresourceidtree + "\" style=\"display: " + trdisplay + ";\" width='100%'>");
/* 1356 */             toreturn.append("<td  " + tempbgcolor + "  width=\"3%\" >&nbsp;</td> ");
/* 1357 */             toreturn.append(assocMessage);
/* 1358 */             toreturn.append("<td  " + tempbgcolor + "  >&nbsp;</td> ");
/* 1359 */             toreturn.append("<td  " + tempbgcolor + "  >&nbsp;</td> ");
/* 1360 */             toreturn.append("<td  " + tempbgcolor + "  >&nbsp;</td> ");
/* 1361 */             toreturn.append("</tr>");
/*      */           }
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1367 */         String resourcelink = null;
/* 1368 */         boolean hideEditLink = false;
/* 1369 */         if ((extDeviceMap != null) && (extDeviceMap.get(childresid) != null))
/*      */         {
/* 1371 */           String link1 = (String)extDeviceMap.get(childresid);
/* 1372 */           hideEditLink = true;
/* 1373 */           if (isIt360)
/*      */           {
/* 1375 */             resourcelink = "<a href=" + link1 + "  class=\"" + linkclass + "\" title=\"" + titleforres + "\">" + getTrimmedText(childresname, 45) + "</a>";
/*      */           }
/*      */           else
/*      */           {
/* 1379 */             resourcelink = "<a href=\"javascript:MM_openBrWindow('" + link1 + "','ExternalDevice','width=950,height=600,top=50,left=75,scrollbars=yes,resizable=yes')\" class=\"" + linkclass + "\" title=\"" + titleforres + "\">" + getTrimmedText(childresname, 45) + "</a>";
/*      */           }
/* 1381 */         } else if ((site24x7List != null) && (site24x7List.containsKey(childresid)))
/*      */         {
/* 1383 */           hideEditLink = true;
/* 1384 */           String link2 = URLEncoder.encode((String)site24x7List.get(childresid));
/* 1385 */           resourcelink = "<a href=\"javascript:MM_openBrWindow('" + link2 + "','Site24x7','width=950,height=600,top=50,left=75,scrollbars=yes,resizable=yes')\" class=\"" + linkclass + "\" title=\"" + titleforres + "\">" + getTrimmedText(childresname, 45) + "</a>";
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/* 1390 */           resourcelink = "<a href=\"/showresource.do?resourceid=" + childresid + "&method=showResourceForResourceID&haid=" + resIdTOCheck + "\" class=\"" + linkclass + "\" title=\"" + titleforres + "\">" + getTrimmedText(childresname, 45) + "</a>";
/*      */         }
/*      */         
/* 1393 */         String imglink = "<img src=\"" + childimg + "\"  align=\"left\" border=\"0\" height=\"24\" width=\"24\"  />";
/* 1394 */         String checkbox = "<input type=\"checkbox\" name=\"select\" id=\"" + currentresourceidtree + "|" + childresid + "\"  value=\"" + childresid + "\"  onclick=\"deselectParentCKbs('" + currentresourceidtree + "|" + childresid + "',this,this.form);\" >";
/* 1395 */         String key = childresid + "#" + availabilitykeys.get(childtype) + "#" + "MESSAGE";
/* 1396 */         String availimage = getSeverityImageForAvailability(alert.getProperty(childresid + "#" + availabilitykeys.get(childtype)));
/* 1397 */         String healthimage = getSeverityImageForHealth(alert.getProperty(childresid + "#" + healthkeys.get(childtype)));
/* 1398 */         String availlink = "<a href=\"javascript:void(0);\" " + availmouseover + "onClick=\"fnOpenNewWindow('/jsp/RCA.jsp?resourceid=" + childresid + "&attributeid=" + availabilitykeys.get(childtype) + "')\"> " + availimage + "</a>";
/* 1399 */         String healthlink = "<a href=\"javascript:void(0);\" " + healthmouseover + " onClick=\"fnOpenNewWindow('/jsp/RCA.jsp?resourceid=" + childresid + "&attributeid=" + healthkeys.get(childtype) + "')\"> " + healthimage + "</a>";
/* 1400 */         String editlink = "<a href=\"/showresource.do?haid=" + resIdTOCheck + "&resourceid=" + childresid + "&resourcename=" + childresname + "&type=" + childtype + "&method=showdetails&editPage=true&moname=" + childresname + "\" class=\"staticlinks\" title=\"" + FormatUtil.getString("am.webclient.maintenance.edit") + "\"><img align=\"center\" src=\"/images/icon_edit.gif\" border=\"0\" /></a>";
/* 1401 */         String thresholdurl = "/showActionProfiles.do?method=getResourceProfiles&admin=true&all=true&resourceid=" + childresid;
/* 1402 */         String configalertslink = " <a href=\"" + thresholdurl + "\" title='" + FormatUtil.getString("am.webclient.common.util.ALERTCONFIG_TEXT") + "'><img src=\"images/icon_associateaction.gif\" align=\"center\" border=\"0\" /></a>";
/* 1403 */         String img2 = "<img src=\"/images/trvline.png\" align=\"absmiddle\" border=\"0\" height=\"15\" width=\"15\"/>";
/* 1404 */         String removefromgroup = "<a class='staticlinks' href=\"javascript: removeMonitorFromGroup ('" + resIdTOCheck + "','" + childresid + "','" + haidTopLevel + "');\" title='" + FormatUtil.getString("am.webclient.monitorgroupdetails.remove.text") + "'><img width='13' align=\"center\"  height='14' border='0' src='/images/icon_removefromgroup.gif'/></a>";
/* 1405 */         String configcustomfields = "<a href=\"javascript:void(0)\" onclick=\"fnOpenNewWindow('/jsp/MyField_Alarms.jsp?resourceid=" + childresid + "&mgview=true')\" title='" + FormatUtil.getString("am.myfield.assign.text") + "'><img align=\"center\" src=\"/images/icon_assigncustomfields.gif\" border=\"0\" /></a>";
/*      */         
/* 1407 */         if (hideEditLink)
/*      */         {
/* 1409 */           editlink = "&nbsp;&nbsp;&nbsp;";
/*      */         }
/* 1411 */         if (!forInventory)
/*      */         {
/* 1413 */           removefromgroup = "";
/*      */         }
/* 1415 */         String actions = "&nbsp;&nbsp;" + configalertslink + "&nbsp;&nbsp;" + removefromgroup + "&nbsp;&nbsp;";
/* 1416 */         if (!com.adventnet.appmanager.util.Constants.sqlManager) {
/* 1417 */           actions = actions + configcustomfields;
/*      */         }
/* 1419 */         if ((haiGroupType == null) || ((haiGroupType != null) && (!"1009".equals(haiGroupType)) && (!"1010".equals(haiGroupType)) && (!"1012".equals(haiGroupType))))
/*      */         {
/* 1421 */           actions = editlink + actions;
/*      */         }
/* 1423 */         String managedLink = "";
/* 1424 */         if ((request.isUserInRole("ENTERPRISEADMIN")) && (!com.adventnet.appmanager.util.Constants.isIt360))
/*      */         {
/* 1426 */           checkbox = "<img hspace=\"3\" border=\"0\" src=\"/images/icon_arrow_childattribute_grey.gif\"/>";
/* 1427 */           actions = "";
/* 1428 */           if (Integer.parseInt(childresid) >= com.adventnet.appmanager.server.framework.comm.Constants.RANGE) {
/* 1429 */             managedLink = "&nbsp; <a target=\"mas_window\" href=\"/showresource.do?resourceid=" + childresid + "&type=" + childtype + "&moname=" + URLEncoder.encode(childresname) + "&resourcename=" + URLEncoder.encode(childresname) + "&method=showdetails&aam_jump=true&useHTTP=" + (!isIt360) + "\"><img border=\"0\" title=\"View Monitor details in Managed Server console\" src=\"/images/jump.gif\"/></a>";
/*      */           }
/*      */         }
/* 1432 */         if ((isIt360) || (request.isUserInRole("OPERATOR")))
/*      */         {
/* 1434 */           checkbox = "";
/*      */         }
/*      */         
/* 1437 */         if (!request.isUserInRole("ADMIN"))
/*      */         {
/* 1439 */           actions = "";
/*      */         }
/* 1441 */         toreturn.append("<tr " + tempbgcolor + " id=\"#monitor" + currentresourceidtree + "\" style=\"display: " + trdisplay + ";\" width='100%'>");
/* 1442 */         toreturn.append("<td " + tempbgcolor + " width=\"3%\"  >&nbsp;</td> ");
/* 1443 */         toreturn.append("<td " + tempbgcolor + " width=\"47%\" nowrap=\"false\" style=\"padding-left: " + spacing + "px !important;\" >" + checkbox + "&nbsp;<img align='absmiddle' border=\"0\"  title='" + shortname + "' src=\"" + imagepath + "\"/>&nbsp;" + resourcelink + managedLink + configMonitor + "</td>");
/* 1444 */         if (isIt360)
/*      */         {
/* 1446 */           toreturn.append("<td " + tempbgcolor + " width=\"15%\" align=\"left\">&nbsp;</td>");
/*      */         }
/*      */         else
/*      */         {
/* 1450 */           toreturn.append("<td " + tempbgcolor + " width=\"15%\" align=\"left\">" + "<table><tr class='whitegrayrightalign'><td><div id='mgaction'>" + actions + "</div></td></tr></table></td>");
/*      */         }
/* 1452 */         toreturn.append("<td " + tempbgcolor + " width=\"8%\" align=\"center\">" + availlink + "</td>");
/* 1453 */         toreturn.append("<td " + tempbgcolor + " width=\"7%\" align=\"center\">" + healthlink + "</td>");
/* 1454 */         if (!isIt360)
/*      */         {
/* 1456 */           toreturn.append("<td " + tempbgcolor + " width=\"7%\" align=\"left\">" + actionimg + "</td>");
/*      */         }
/*      */         else
/*      */         {
/* 1460 */           toreturn.append("<td " + tempbgcolor + " width=\"7%\" align=\"left\">&nbsp;</td>");
/*      */         }
/* 1462 */         toreturn.append("</tr>");
/*      */       }
/*      */     }
/* 1465 */     return toreturn.toString();
/*      */   }
/*      */   
/*      */   public String getSeverityImageForHealthWithLink(Properties alert, String resourceid, String healthid)
/*      */   {
/*      */     try
/*      */     {
/* 1472 */       StringBuilder toreturn = new StringBuilder();
/* 1473 */       String severity = alert.getProperty(resourceid + "#" + healthid);
/* 1474 */       String v = "<script>var v = '<span style=\"color: #000000;font-weight:bold;\">';</script>";
/* 1475 */       String message = alert.getProperty(resourceid + "#" + healthid + "#" + "MESSAGE");
/* 1476 */       String title = "";
/* 1477 */       message = EnterpriseUtil.decodeString(message);
/* 1478 */       message = FormatUtil.findReplace(message, "'", "\\'");
/* 1479 */       message = FormatUtil.findReplace(message, "\"", "&quot;");
/* 1480 */       if (("1".equals(severity)) || ("4".equals(severity)))
/*      */       {
/* 1482 */         title = " onmouseover=\"ddrivetip(this,event,'" + message + "<br>'+v+'" + FormatUtil.getString("am.webclient.tooltip.text") + "</span>',null,true,'#000000')\" onmouseout='hideddrivetip()'";
/*      */       }
/* 1484 */       else if ("5".equals(severity))
/*      */       {
/* 1486 */         title = "title='" + FormatUtil.getString("am.fault.rca.healthisclear.text") + "'";
/*      */       }
/*      */       else
/*      */       {
/* 1490 */         title = "title='" + FormatUtil.getString("am.webclient.rcamessage.healthunknown.text") + "'";
/*      */       }
/* 1492 */       String link = "<a href='javascript:void(0)' " + title + " onClick=\"fnOpenNewWindow('/jsp/RCA.jsp?resourceid=" + resourceid + "&attributeid=" + healthid + "')\">";
/* 1493 */       toreturn.append(v);
/*      */       
/* 1495 */       toreturn.append(link);
/* 1496 */       if (severity == null)
/*      */       {
/* 1498 */         toreturn.append("<img border=\"0\" src=\"/images/icon_health_unknown.gif\" name=\"Image" + ++this.j + "\">");
/*      */       }
/* 1500 */       else if (severity.equals("5"))
/*      */       {
/* 1502 */         toreturn.append("<img border=\"0\" src=\"/images/icon_health_clear.gif\"  name=\"Image" + ++this.j + "\">");
/*      */       }
/* 1504 */       else if (severity.equals("4"))
/*      */       {
/* 1506 */         toreturn.append("<img border=\"0\" src=\"/images/icon_health_warning.gif\" name=\"Image" + ++this.j + "\">");
/*      */       }
/* 1508 */       else if (severity.equals("1"))
/*      */       {
/* 1510 */         toreturn.append("<img border=\"0\" src=\"/images/icon_health_critical.gif\" name=\"Image" + ++this.j + "\">");
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1515 */         toreturn.append("<img border=\"0\" src=\"/images/icon_health_unknown.gif\" name=\"Image" + ++this.j + "\">");
/*      */       }
/* 1517 */       toreturn.append("</a>");
/* 1518 */       return toreturn.toString();
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1522 */       ex.printStackTrace();
/*      */     }
/* 1524 */     return "<img border=\"0\" src=\"/images/icon_health_unknown.gif\" name=\"Image" + ++this.j + "\">";
/*      */   }
/*      */   
/*      */   private String getSeverityImageForAvailabilitywithLink(Properties alert, String resourceid, String availabilityid)
/*      */   {
/*      */     try
/*      */     {
/* 1531 */       StringBuilder toreturn = new StringBuilder();
/* 1532 */       String severity = alert.getProperty(resourceid + "#" + availabilityid);
/* 1533 */       String v = "<script>var v = '<span style=\"color: #000000;font-weight:bold;\">';</script>";
/* 1534 */       String message = alert.getProperty(resourceid + "#" + availabilityid + "#" + "MESSAGE");
/* 1535 */       if (message == null)
/*      */       {
/* 1537 */         message = "";
/*      */       }
/*      */       
/* 1540 */       message = FormatUtil.findReplace(message, "'", "\\'");
/* 1541 */       message = FormatUtil.findReplace(message, "\"", "&quot;");
/*      */       
/* 1543 */       String link = "<a href='javascript:void(0)'  onmouseover=\"ddrivetip(this,event,'" + message + "<br>'+v+'" + FormatUtil.getString("am.webclient.tooltip.text") + "</span>',null,true,'#000000')\" onmouseout='hideddrivetip()' onClick=\"fnOpenNewWindow('/jsp/RCA.jsp?resourceid=" + resourceid + "&attributeid=" + availabilityid + "')\">";
/* 1544 */       toreturn.append(v);
/*      */       
/* 1546 */       toreturn.append(link);
/*      */       
/* 1548 */       if (severity == null)
/*      */       {
/* 1550 */         toreturn.append("<img border=\"0\" src=\"/images/icon_availability_unknown.gif\" name=\"Image" + ++this.j + "\">");
/*      */       }
/* 1552 */       else if (severity.equals("5"))
/*      */       {
/* 1554 */         toreturn.append("<img border=\"0\" src=\"/images/icon_availability_up.gif\"  name=\"Image" + ++this.j + "\">");
/*      */       }
/* 1556 */       else if (severity.equals("1"))
/*      */       {
/* 1558 */         toreturn.append("<img border=\"0\" src=\"/images/icon_availability_down.gif\" name=\"Image" + ++this.j + "\">");
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1563 */         toreturn.append("<img border=\"0\" src=\"/images/icon_availability_unknown.gif\" name=\"Image" + ++this.j + "\">");
/*      */       }
/* 1565 */       toreturn.append("</a>");
/* 1566 */       return toreturn.toString();
/*      */     }
/*      */     catch (Exception ex) {}
/*      */     
/*      */ 
/*      */ 
/* 1572 */     return "<img border=\"0\" src=\"/images/icon_availabilitynunknown.gif\" name=\"Image" + ++this.j + "\">";
/*      */   }
/*      */   
/* 1575 */   public ArrayList getPermittedActions(HashMap actionmap, HashMap invokeActions) { ArrayList actionsavailable = new ArrayList();
/* 1576 */     if (invokeActions != null) {
/* 1577 */       Iterator iterator = invokeActions.keySet().iterator();
/* 1578 */       while (iterator.hasNext()) {
/* 1579 */         String actionid = (String)invokeActions.get((String)iterator.next());
/* 1580 */         if (actionmap.containsKey(actionid)) {
/* 1581 */           actionsavailable.add(actionid);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1586 */     return actionsavailable;
/*      */   }
/*      */   
/*      */   public String getActionParams(HashMap methodArgumentsMap, String rowId, String managedObjectName, String resID, String resourcetype, Properties commonValues) {
/* 1590 */     String actionLink = "";
/* 1591 */     AMConnectionPool cp = AMConnectionPool.getInstance();
/* 1592 */     String query = "";
/* 1593 */     ResultSet rs = null;
/* 1594 */     String methodName = (String)methodArgumentsMap.get("METHODNAME");
/* 1595 */     String isJsp = (String)methodArgumentsMap.get("ISPOPUPJSP");
/* 1596 */     if ((isJsp != null) && (isJsp.equalsIgnoreCase("No"))) {
/* 1597 */       actionLink = "method=" + methodName;
/*      */     }
/* 1599 */     else if ((isJsp != null) && (isJsp.equalsIgnoreCase("Yes"))) {
/* 1600 */       actionLink = methodName;
/*      */     }
/* 1602 */     ArrayList methodarglist = (ArrayList)methodArgumentsMap.get(methodName);
/* 1603 */     Iterator itr = methodarglist.iterator();
/* 1604 */     boolean isfirstparam = true;
/* 1605 */     HashMap popupProps = (HashMap)methodArgumentsMap.get("POPUP-PROPS");
/* 1606 */     while (itr.hasNext()) {
/* 1607 */       HashMap argmap = (HashMap)itr.next();
/* 1608 */       String argtype = (String)argmap.get("TYPE");
/* 1609 */       String argname = (String)argmap.get("IDENTITY");
/* 1610 */       String paramname = (String)argmap.get("PARAMETER");
/* 1611 */       String typeId = com.adventnet.appmanager.util.Constants.getTypeId(resourcetype);
/* 1612 */       if ((isfirstparam) && (isJsp != null) && (isJsp.equalsIgnoreCase("Yes"))) {
/* 1613 */         isfirstparam = false;
/* 1614 */         if (actionLink.indexOf("?") > 0)
/*      */         {
/* 1616 */           actionLink = actionLink + "&";
/*      */         }
/*      */         else
/*      */         {
/* 1620 */           actionLink = actionLink + "?";
/*      */         }
/*      */       }
/*      */       else {
/* 1624 */         actionLink = actionLink + "&";
/*      */       }
/* 1626 */       String paramValue = null;
/* 1627 */       String tempargname = argname;
/* 1628 */       if (commonValues.getProperty(tempargname) != null) {
/* 1629 */         paramValue = commonValues.getProperty(tempargname);
/*      */       }
/*      */       else {
/* 1632 */         if (argtype.equalsIgnoreCase("Argument")) {
/* 1633 */           String dbType = com.adventnet.appmanager.db.DBQueryUtil.getDBType();
/* 1634 */           if (dbType.equals("mysql")) {
/* 1635 */             argname = "`" + argname + "`";
/*      */           }
/*      */           else {
/* 1638 */             argname = "\"" + argname + "\"";
/*      */           }
/* 1640 */           query = "select " + argname + " as VALUE from AM_ARGS_" + typeId + " where RESOURCEID=" + resID;
/*      */           try {
/* 1642 */             rs = AMConnectionPool.executeQueryStmt(query);
/* 1643 */             if (rs.next()) {
/* 1644 */               paramValue = rs.getString("VALUE");
/* 1645 */               commonValues.setProperty(tempargname, paramValue);
/*      */             }
/*      */           }
/*      */           catch (SQLException e) {
/* 1649 */             e.printStackTrace();
/*      */           }
/*      */           finally {
/*      */             try {
/* 1653 */               AMConnectionPool.closeStatement(rs);
/*      */             }
/*      */             catch (Exception exc) {
/* 1656 */               exc.printStackTrace();
/*      */             }
/*      */           }
/*      */         }
/*      */         
/* 1661 */         if ((argtype.equalsIgnoreCase("Rowid")) && (rowId != null)) {
/* 1662 */           paramValue = rowId;
/*      */         }
/* 1664 */         else if ((argtype.equalsIgnoreCase("MO")) && (managedObjectName != null)) {
/* 1665 */           paramValue = managedObjectName;
/*      */         }
/* 1667 */         else if (argtype.equalsIgnoreCase("ResourceId")) {
/* 1668 */           paramValue = resID;
/*      */         }
/* 1670 */         else if (argtype.equalsIgnoreCase("TypeId")) {
/* 1671 */           paramValue = com.adventnet.appmanager.util.Constants.getTypeId(resourcetype);
/*      */         }
/*      */       }
/* 1674 */       actionLink = actionLink + paramname + "=" + paramValue;
/*      */     }
/* 1676 */     if ((popupProps != null) && (popupProps.size() > 0)) {
/* 1677 */       actionLink = actionLink + "|" + (String)popupProps.get("WinName") + "|";
/* 1678 */       actionLink = actionLink + "width=" + (String)popupProps.get("Width") + ",height=" + (String)popupProps.get("Height") + ",Top=" + (String)popupProps.get("Top") + ",Left=" + (String)popupProps.get("Left") + ",scrollbars=" + (String)popupProps.get("IsScrollBar") + ",resizable=" + (String)popupProps.get("IsResizable");
/*      */     }
/* 1680 */     return actionLink;
/*      */   }
/*      */   
/* 1683 */   public String getActionColDetails(HashMap columnDetails, ArrayList actionsavailable, HashMap actionmap, float width, HashMap rowDetails, String rowid, String resourcetype, String resID, String id1, String availValue, String healthValue, String bgclass, Boolean isdisable, String primaryColId, Properties commonValues) { StringBuilder toreturn = new StringBuilder();
/* 1684 */     String dependentAttribute = null;
/* 1685 */     String align = "left";
/*      */     
/* 1687 */     dependentAttribute = (String)columnDetails.get("DEPENDENTATTRIBUTE");
/* 1688 */     String displayType = (String)columnDetails.get("DISPLAYTYPE");
/* 1689 */     HashMap invokeActionsMap = (HashMap)((HashMap)columnDetails.get("INVOCATION")).get("ACTIONS");
/* 1690 */     HashMap invokeTooltip = (HashMap)((HashMap)columnDetails.get("INVOCATION")).get("TOOLTIP");
/* 1691 */     HashMap textOrImageValue = (HashMap)((HashMap)columnDetails.get("INVOCATION")).get("VALUES");
/* 1692 */     HashMap dependentValueMap = (HashMap)((HashMap)columnDetails.get("INVOCATION")).get("DEPENDENTVALUE");
/* 1693 */     HashMap dependentImageMap = (HashMap)((HashMap)columnDetails.get("INVOCATION")).get("DEPENDENTIMAGE");
/* 1694 */     if ((displayType != null) && (displayType.equals("Image"))) {
/* 1695 */       align = "center";
/*      */     }
/*      */     
/* 1698 */     boolean iscolumntoDisplay = actionsavailable != null;
/* 1699 */     String actualdata = "";
/*      */     
/* 1701 */     if ((dependentAttribute != null) && (!dependentAttribute.trim().equals(""))) {
/* 1702 */       if (dependentAttribute.equalsIgnoreCase("Availability")) {
/* 1703 */         actualdata = availValue;
/*      */       }
/* 1705 */       else if (dependentAttribute.equalsIgnoreCase("Health")) {
/* 1706 */         actualdata = healthValue;
/*      */       } else {
/*      */         try
/*      */         {
/* 1710 */           String attributeName = ConfMonitorConfiguration.getInstance().getAttributeName(resourcetype, dependentAttribute).toUpperCase();
/* 1711 */           actualdata = (String)rowDetails.get(attributeName);
/*      */         }
/*      */         catch (Exception e) {
/* 1714 */           e.printStackTrace();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1720 */     if ((actionmap != null) && (actionmap.size() > 0) && (iscolumntoDisplay)) {
/* 1721 */       toreturn.append("<td width='" + width + "%'  align='" + align + "' class='" + bgclass + "' >");
/* 1722 */       toreturn.append("<table>");
/* 1723 */       toreturn.append("<tr>");
/* 1724 */       for (int orderId = 1; orderId <= textOrImageValue.size(); orderId++) {
/* 1725 */         String displayValue = (String)textOrImageValue.get(Integer.toString(orderId));
/* 1726 */         String actionName = (String)invokeActionsMap.get(Integer.toString(orderId));
/* 1727 */         String dependentValue = (String)dependentValueMap.get(Integer.toString(orderId));
/* 1728 */         String toolTip = "";
/* 1729 */         String hideClass = "";
/* 1730 */         String textStyle = "";
/* 1731 */         boolean isreferenced = true;
/* 1732 */         if (invokeTooltip.get(Integer.toString(orderId)) != null) {
/* 1733 */           toolTip = (String)invokeTooltip.get(Integer.toString(orderId));
/* 1734 */           toolTip = toolTip.replaceAll("\"", "&quot;");
/* 1735 */           hideClass = "hideddrivetip()";
/*      */         }
/* 1737 */         if ((dependentValue != null) && (!dependentValue.equals("Null")) && (!dependentValue.equals(""))) {
/* 1738 */           StringTokenizer valueList = new StringTokenizer(dependentValue, ",");
/* 1739 */           while (valueList.hasMoreTokens()) {
/* 1740 */             String dependentVal = valueList.nextToken();
/* 1741 */             if ((actualdata != null) && (actualdata.equals(dependentVal))) {
/* 1742 */               if ((dependentImageMap != null) && (dependentImageMap.get(dependentValue) != null)) {
/* 1743 */                 displayValue = (String)dependentImageMap.get(dependentValue);
/*      */               }
/* 1745 */               toolTip = "";
/* 1746 */               hideClass = "";
/* 1747 */               isreferenced = false;
/* 1748 */               textStyle = "disabledtext";
/* 1749 */               break;
/*      */             }
/*      */           }
/*      */         }
/* 1753 */         if ((isdisable.booleanValue()) || (actualdata == null)) {
/* 1754 */           toolTip = "";
/* 1755 */           hideClass = "";
/* 1756 */           isreferenced = false;
/* 1757 */           textStyle = "disabledtext";
/* 1758 */           if (dependentImageMap != null) {
/* 1759 */             if ((dependentValue != null) && (!dependentValue.equals("Null")) && (!dependentValue.equals("")) && (dependentImageMap.get(dependentValue) != null)) {
/* 1760 */               displayValue = (String)dependentImageMap.get(dependentValue);
/*      */             }
/*      */             else {
/* 1763 */               displayValue = (String)dependentImageMap.get(Integer.toString(orderId));
/*      */             }
/*      */           }
/*      */         }
/* 1767 */         if ((actionsavailable.contains(actionName)) && (actionmap.get(actionName) != null)) {
/* 1768 */           Boolean confirmBox = (Boolean)((HashMap)actionmap.get(actionName)).get("CONFIRMATION");
/* 1769 */           String confirmmsg = (String)((HashMap)actionmap.get(actionName)).get("MESSAGE");
/* 1770 */           String isJSP = (String)((HashMap)actionmap.get(actionName)).get("ISPOPUPJSP");
/* 1771 */           String managedObject = (String)rowDetails.get(primaryColId);
/* 1772 */           String actionLinks = getActionParams((HashMap)actionmap.get(actionName), rowid, managedObject, resID, resourcetype, commonValues);
/*      */           
/* 1774 */           toreturn.append("<td width='" + width / actionsavailable.size() + "%' align='" + align + "' class='staticlinks'>");
/* 1775 */           if (isreferenced) {
/* 1776 */             toreturn.append("<a href=\"javascript:triggerAction('" + actionLinks + "','" + id1 + "','" + confirmBox + "','" + FormatUtil.getString(confirmmsg) + "','" + isJSP + "');\" class='staticlinks' onMouseOver=\"ddrivetip(this,event,'" + FormatUtil.getString(toolTip).replace("\"", "&quot;") + "',false,true,'#000000',100,'lightyellow')\" onmouseout=\"" + hideClass + "\">");
/*      */           }
/*      */           else
/*      */           {
/* 1780 */             toreturn.append("<a href=\"javascript:void(0);\" class='staticlinks' onMouseOver=\"ddrivetip(this,event,'" + FormatUtil.getString(toolTip).replace("\"", "&quot;") + "',false,true,'#000000',100,'lightyellow')\" onmouseout=\"" + hideClass + "\">"); }
/* 1781 */           if ((displayValue != null) && (displayType != null) && (displayType.equals("Image"))) {
/* 1782 */             toreturn.append("<img src=\"" + displayValue + "\" hspace=\"4\" border=\"0\" align=\"absmiddle\"/>");
/* 1783 */           } else if ((displayValue != null) && (displayType != null) && (displayType.equals("Text"))) {
/* 1784 */             toreturn.append("<span class=\"" + textStyle + "\">");
/* 1785 */             toreturn.append(FormatUtil.getString(displayValue));
/*      */           }
/* 1787 */           toreturn.append("</span>");
/* 1788 */           toreturn.append("</a>");
/* 1789 */           toreturn.append("</td>");
/*      */         }
/*      */       }
/* 1792 */       toreturn.append("</tr>");
/* 1793 */       toreturn.append("</table>");
/* 1794 */       toreturn.append("</td>");
/*      */     } else {
/* 1796 */       toreturn.append("<td width='" + width + "%'  align='" + align + "' class='" + bgclass + "' > - </td>");
/*      */     }
/*      */     
/* 1799 */     return toreturn.toString();
/*      */   }
/*      */   
/*      */   public String getMOCollectioTime(ArrayList rows, String tablename, String attributeid, String resColumn) {
/* 1803 */     String colTime = null;
/* 1804 */     AMConnectionPool cp = AMConnectionPool.getInstance();
/* 1805 */     if ((rows != null) && (rows.size() > 0)) {
/* 1806 */       Iterator<String> itr = rows.iterator();
/* 1807 */       String maxColQuery = "";
/* 1808 */       for (;;) { if (itr.hasNext()) {
/* 1809 */           maxColQuery = "select max(COLLECTIONTIME) from " + tablename + " where ATTRIBUTEID=" + attributeid + " and " + resColumn + "=" + (String)itr.next();
/* 1810 */           ResultSet maxCol = null;
/*      */           try {
/* 1812 */             maxCol = AMConnectionPool.executeQueryStmt(maxColQuery);
/* 1813 */             while (maxCol.next()) {
/* 1814 */               if (colTime == null) {
/* 1815 */                 colTime = Long.toString(maxCol.getLong(1));
/*      */               }
/*      */               else {
/* 1818 */                 colTime = colTime + "," + Long.toString(maxCol.getLong(1));
/*      */               }
/*      */             }
/*      */             
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1827 */             AMLog.debug("Graph Query for att " + attributeid + " :" + maxColQuery);
/*      */             try {
/* 1829 */               if (maxCol != null)
/* 1830 */                 AMConnectionPool.closeStatement(maxCol);
/*      */             } catch (Exception e) {
/* 1832 */               e.printStackTrace();
/*      */             }
/*      */           }
/*      */           catch (Exception e) {}finally
/*      */           {
/* 1827 */             AMLog.debug("Graph Query for att " + attributeid + " :" + maxColQuery);
/*      */             try {
/* 1829 */               if (maxCol != null)
/* 1830 */                 AMConnectionPool.closeStatement(maxCol);
/*      */             } catch (Exception e) {
/* 1832 */               e.printStackTrace();
/*      */             }
/*      */           }
/*      */         }
/*      */       } }
/* 1837 */     return colTime;
/*      */   }
/*      */   
/* 1840 */   public String getTableName(String attributeid, String baseid) { String tablenameqry = "select ATTRIBUTEID,DATATABLE,VALUE_COL from AM_ATTRIBUTES_EXT where ATTRIBUTEID=" + attributeid;
/* 1841 */     tablename = null;
/* 1842 */     ResultSet rsTable = null;
/* 1843 */     AMConnectionPool cp = AMConnectionPool.getInstance();
/*      */     try {
/* 1845 */       rsTable = AMConnectionPool.executeQueryStmt(tablenameqry);
/* 1846 */       while (rsTable.next()) {
/* 1847 */         tablename = rsTable.getString("DATATABLE");
/* 1848 */         if ((tablename.equals("AM_ManagedObjectData")) && (rsTable.getString("VALUE_COL").equals("RESPONSETIME"))) {
/* 1849 */           tablename = "AM_Script_Numeric_Data_" + baseid;
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
/* 1862 */       return tablename;
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1853 */       e.printStackTrace();
/*      */     } finally {
/*      */       try {
/* 1856 */         if (rsTable != null)
/* 1857 */           AMConnectionPool.closeStatement(rsTable);
/*      */       } catch (Exception e) {
/* 1859 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public String getArgsListtoShowonClick(HashMap showArgsMap, String row) {
/* 1865 */     String argsList = "";
/* 1866 */     ArrayList showArgslist = new ArrayList();
/*      */     try {
/* 1868 */       if (showArgsMap.get(row) != null) {
/* 1869 */         showArgslist = (ArrayList)showArgsMap.get(row);
/* 1870 */         if (showArgslist != null) {
/* 1871 */           for (int i = 0; i < showArgslist.size(); i++) {
/* 1872 */             if (argsList.trim().equals("")) {
/* 1873 */               argsList = (String)showArgslist.get(i);
/*      */             }
/*      */             else {
/* 1876 */               argsList = argsList + "," + (String)showArgslist.get(i);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 1883 */       e.printStackTrace();
/* 1884 */       return "";
/*      */     }
/* 1886 */     return argsList;
/*      */   }
/*      */   
/*      */   public String getArgsListToHideOnClick(HashMap hideArgsMap, String row)
/*      */   {
/* 1891 */     String argsList = "";
/* 1892 */     ArrayList hideArgsList = new ArrayList();
/*      */     try
/*      */     {
/* 1895 */       if (hideArgsMap.get(row) != null)
/*      */       {
/* 1897 */         hideArgsList = (ArrayList)hideArgsMap.get(row);
/* 1898 */         if (hideArgsList != null)
/*      */         {
/* 1900 */           for (int i = 0; i < hideArgsList.size(); i++)
/*      */           {
/* 1902 */             if (argsList.trim().equals(""))
/*      */             {
/* 1904 */               argsList = (String)hideArgsList.get(i);
/*      */             }
/*      */             else
/*      */             {
/* 1908 */               argsList = argsList + "," + (String)hideArgsList.get(i);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/* 1916 */       ex.printStackTrace();
/*      */     }
/* 1918 */     return argsList;
/*      */   }
/*      */   
/*      */   public String getTableActionsList(ArrayList tActionList, HashMap actionmap, String tableName, Properties commonValues, String resourceId, String resourceType) {
/* 1922 */     StringBuilder toreturn = new StringBuilder();
/* 1923 */     StringBuilder addtoreturn = new StringBuilder();
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1930 */     if ((tActionList != null) && (tActionList.size() > 0)) {
/* 1931 */       Iterator itr = tActionList.iterator();
/* 1932 */       while (itr.hasNext()) {
/* 1933 */         Boolean confirmBox = Boolean.valueOf(false);
/* 1934 */         String confirmmsg = "";
/* 1935 */         String link = "";
/* 1936 */         String isJSP = "NO";
/* 1937 */         HashMap tactionMap = (HashMap)itr.next();
/* 1938 */         boolean isTableAction = tactionMap.containsKey("ACTION-NAME");
/* 1939 */         String actionName = isTableAction ? (String)tactionMap.get("ACTION-NAME") : (String)tactionMap.get("LINK-NAME");
/* 1940 */         String actionId = (String)tactionMap.get("ACTIONID");
/* 1941 */         if ((actionId != null) && (actionName != null) && (!actionName.trim().equals("")) && (!actionId.trim().equals("")) && 
/* 1942 */           (actionmap.containsKey(actionId))) {
/* 1943 */           HashMap methodArgumentsMap = (HashMap)actionmap.get(actionId);
/* 1944 */           HashMap popupProps = (HashMap)methodArgumentsMap.get("POPUP-PROPS");
/* 1945 */           confirmBox = (Boolean)methodArgumentsMap.get("CONFIRMATION");
/* 1946 */           confirmmsg = (String)methodArgumentsMap.get("MESSAGE");
/* 1947 */           isJSP = (String)methodArgumentsMap.get("ISPOPUPJSP");
/*      */           
/* 1949 */           link = getActionParams(methodArgumentsMap, null, null, resourceId, resourceType, commonValues);
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1955 */           if (isTableAction) {
/* 1956 */             toreturn.append("<option value=" + actionId + ">" + FormatUtil.getString(actionName) + "</option>");
/*      */           }
/*      */           else {
/* 1959 */             tableName = "Link";
/* 1960 */             toreturn.append("<td align=\"right\" style=\"padding-right:10px\">");
/* 1961 */             toreturn.append("<a class=\"bodytextboldwhiteun\" style='cursor:pointer' ");
/* 1962 */             toreturn.append("onClick=\"javascript:customLinks('" + actionId + "','" + resourceId + "')\">" + FormatUtil.getString(actionName));
/* 1963 */             toreturn.append("</a></td>");
/*      */           }
/* 1965 */           addtoreturn.append("<input type='hidden' id='" + tableName + "_" + actionId + "_isJSP' value='" + isJSP + "'/>");
/* 1966 */           addtoreturn.append("<input type='hidden' id='" + tableName + "_" + actionId + "_confirmBox' value='" + confirmBox + "'/>");
/* 1967 */           addtoreturn.append("<input type='hidden' id='" + tableName + "_" + actionId + "_confirmmsg' value='" + FormatUtil.getString(confirmmsg) + "'/>");
/* 1968 */           addtoreturn.append("<input type='hidden' id='" + tableName + "_" + actionId + "_link' value='" + link + "'/>");
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1974 */     return toreturn.toString() + addtoreturn.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public void printMGTree(DefaultMutableTreeNode rootNode, StringBuilder builder)
/*      */   {
/* 1980 */     for (Enumeration<DefaultMutableTreeNode> enu = rootNode.children(); enu.hasMoreElements();)
/*      */     {
/* 1982 */       DefaultMutableTreeNode node = (DefaultMutableTreeNode)enu.nextElement();
/* 1983 */       Properties prop = (Properties)node.getUserObject();
/* 1984 */       String mgID = prop.getProperty("label");
/* 1985 */       String mgName = prop.getProperty("value");
/* 1986 */       String isParent = prop.getProperty("isParent");
/* 1987 */       int mgIDint = Integer.parseInt(mgID);
/* 1988 */       if ((EnterpriseUtil.isAdminServer()) && (mgIDint > EnterpriseUtil.RANGE))
/*      */       {
/* 1990 */         mgName = mgName + "(" + CommDBUtil.getManagedServerNameWithPort(mgID) + ")";
/*      */       }
/* 1992 */       builder.append("<LI id='" + prop.getProperty("label") + "_list' ><A ");
/* 1993 */       if (node.getChildCount() > 0)
/*      */       {
/* 1995 */         if ((prop.getProperty("isParent") != null) && (prop.getProperty("isParent").equals("true")))
/*      */         {
/* 1997 */           builder.append("style='background-color:#f9f9f9;border-bottom: 1px solid #ECECEC;border-top:none; border-right:none; border-left:none;'");
/*      */         }
/* 1999 */         else if ((prop.getProperty("isParent") != null) && (prop.getProperty("isParent").equals("false")))
/*      */         {
/* 2001 */           builder.append(" style='padding-left:").append(node.getLevel() * 15 + "px;'");
/*      */         }
/*      */         else
/*      */         {
/* 2005 */           builder.append(" style='padding-left:").append(node.getLevel() * 15 + "px;'");
/*      */         }
/*      */         
/*      */ 
/*      */       }
/* 2010 */       else if ((prop.getProperty("isParent") != null) && (prop.getProperty("isParent").equals("true")))
/*      */       {
/* 2012 */         builder.append("style='background-color:#f9f9f9;border-bottom: 1px solid #ECECEC;border-top:none; border-right:none; border-left:none;'");
/*      */       }
/* 2014 */       else if ((prop.getProperty("isParent") != null) && (prop.getProperty("isParent").equals("false")))
/*      */       {
/* 2016 */         builder.append(" style='padding-left:").append(node.getLevel() * 15 + "px;'");
/*      */       }
/*      */       else
/*      */       {
/* 2020 */         builder.append(" style='padding-left:").append(node.getLevel() * 15 + "px;'");
/*      */       }
/*      */       
/* 2023 */       builder.append(" onmouseout=\"changeStyle(this);\" onmouseover=\"SetSelected(this)\" onclick=\"SelectMonitorGroup('service_list_left1','" + prop.getProperty("value") + "','" + prop.getProperty("label") + "','leftimage1')\"> ");
/* 2024 */       if ((prop.getProperty("isParent") != null) && (prop.getProperty("isParent").equals("true")))
/*      */       {
/* 2026 */         builder.append("<img src='images/icon_monitors_mg.png' alt='' style='position:relative; top:5px;'/><b>" + prop.getProperty("value") + "</b></a></li>");
/*      */       }
/*      */       else
/*      */       {
/* 2030 */         builder.append(prop.getProperty("value") + "</a></li>");
/*      */       }
/* 2032 */       if (node.getChildCount() > 0)
/*      */       {
/* 2034 */         builder.append("<UL>");
/* 2035 */         printMGTree(node, builder);
/* 2036 */         builder.append("</UL>");
/*      */       }
/*      */     }
/*      */   }
/*      */   
/* 2041 */   public String getColumnGraph(LinkedHashMap graphData, HashMap attidMap) { Iterator it = graphData.keySet().iterator();
/* 2042 */     StringBuffer toReturn = new StringBuffer();
/* 2043 */     String table = "-";
/*      */     try {
/* 2045 */       DecimalFormat twoDecPer = new DecimalFormat("###,###.##");
/* 2046 */       LinkedHashMap attVsWidthProps = new LinkedHashMap();
/* 2047 */       float total = 0.0F;
/* 2048 */       while (it.hasNext()) {
/* 2049 */         String attName = (String)it.next();
/* 2050 */         String data = (String)attidMap.get(attName.toUpperCase());
/* 2051 */         boolean roundOffData = false;
/* 2052 */         if ((data != null) && (!data.equals(""))) {
/* 2053 */           if (data.indexOf(",") != -1) {
/* 2054 */             data = data.replaceAll(",", "");
/*      */           }
/*      */           try {
/* 2057 */             float value = Float.parseFloat(data);
/* 2058 */             if (value == 0.0F) {
/*      */               continue;
/*      */             }
/* 2061 */             total += value;
/* 2062 */             attVsWidthProps.put(attName, value + "");
/*      */           }
/*      */           catch (Exception e) {
/* 2065 */             e.printStackTrace();
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 2070 */       Iterator attVsWidthList = attVsWidthProps.keySet().iterator();
/* 2071 */       while (attVsWidthList.hasNext()) {
/* 2072 */         String attName = (String)attVsWidthList.next();
/* 2073 */         String data = (String)attVsWidthProps.get(attName);
/* 2074 */         HashMap graphDetails = (HashMap)graphData.get(attName);
/* 2075 */         String unit = graphDetails.get("Unit") != null ? "(" + FormatUtil.getString((String)graphDetails.get("Unit")) + ")" : "";
/* 2076 */         String toolTip = graphDetails.get("ToolTip") != null ? "title=\"" + FormatUtil.getString((String)graphDetails.get("ToolTip")) + " - " + data + unit + "\"" : "";
/* 2077 */         String className = (String)graphDetails.get("ClassName");
/* 2078 */         float percentage = Float.parseFloat(data) * 100.0F / total;
/* 2079 */         if (percentage < 1.0F)
/*      */         {
/* 2081 */           data = percentage + "";
/*      */         }
/* 2083 */         toReturn.append("<td class=\"" + className + "\" width=\"" + twoDecPer.format(percentage) + "%\"" + toolTip + "><img src=\"/images/spacer.gif\"  height=\"10\" width=\"90%\"></td>");
/*      */       }
/* 2085 */       if (toReturn.length() > 0) {
/* 2086 */         table = "<table align=\"center\" width =\"90%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"graphborder\"><tr>" + toReturn.toString() + "</tr></table>";
/*      */       }
/*      */     }
/*      */     catch (Exception e) {
/* 2090 */       e.printStackTrace();
/*      */     }
/* 2092 */     return table;
/*      */   }
/*      */   
/*      */ 
/*      */   public String[] splitMultiConditionThreshold(String criticalcondition, String criticalThValue)
/*      */   {
/* 2098 */     String[] splitvalues = { criticalcondition, criticalThValue };
/* 2099 */     List<String> criticalThresholdValues = com.adventnet.appmanager.util.AMRegexUtil.getThresholdGroups(criticalcondition, true);
/* 2100 */     System.out.println("CRITICALTHGROPS " + criticalThresholdValues);
/* 2101 */     if ((criticalThresholdValues != null) && (criticalThresholdValues.size() > 5)) {
/* 2102 */       String condition1 = (String)criticalThresholdValues.get(0);
/* 2103 */       String thvalue1 = (String)criticalThresholdValues.get(1);
/* 2104 */       String conditionjoiner = (String)criticalThresholdValues.get(4);
/* 2105 */       String condition2 = (String)criticalThresholdValues.get(5);
/* 2106 */       String thvalue2 = (String)criticalThresholdValues.get(6);
/*      */       
/*      */ 
/* 2109 */       StringBuilder multiplecondition = new StringBuilder(condition1);
/* 2110 */       multiplecondition.append(" ").append(thvalue1).append(" ").append(conditionjoiner).append(" ").append(condition2).append(" ").append(thvalue2);
/* 2111 */       splitvalues[0] = multiplecondition.toString();
/* 2112 */       splitvalues[1] = "";
/*      */     }
/*      */     
/* 2115 */     return splitvalues;
/*      */   }
/*      */   
/*      */   public Map<String, String[]> setSelectedCondition(String condition, int thresholdType)
/*      */   {
/* 2120 */     LinkedHashMap<String, String[]> conditionsMap = new LinkedHashMap();
/* 2121 */     if (thresholdType != 3) {
/* 2122 */       conditionsMap.put("LT", new String[] { "", "<" });
/* 2123 */       conditionsMap.put("GT", new String[] { "", ">" });
/* 2124 */       conditionsMap.put("EQ", new String[] { "", "=" });
/* 2125 */       conditionsMap.put("LE", new String[] { "", "<=" });
/* 2126 */       conditionsMap.put("GE", new String[] { "", ">=" });
/* 2127 */       conditionsMap.put("NE", new String[] { "", "!=" });
/*      */     } else {
/* 2129 */       conditionsMap.put("CT", new String[] { "", "am.fault.conditions.string.contains" });
/* 2130 */       conditionsMap.put("DC", new String[] { "", "am.fault.conditions.string.doesnotcontain" });
/* 2131 */       conditionsMap.put("QL", new String[] { "", "am.fault.conditions.string.equalto" });
/* 2132 */       conditionsMap.put("NQ", new String[] { "", "am.fault.conditions.string.notequalto" });
/* 2133 */       conditionsMap.put("SW", new String[] { "", "am.fault.conditions.string.startswith" });
/* 2134 */       conditionsMap.put("EW", new String[] { "", "am.fault.conditions.string.endswith" });
/*      */     }
/* 2136 */     String[] updateSelected = (String[])conditionsMap.get(condition);
/* 2137 */     if (updateSelected != null) {
/* 2138 */       updateSelected[0] = "selected";
/*      */     }
/* 2140 */     return conditionsMap;
/*      */   }
/*      */   
/*      */   public String getCustomMessage(String monitorType, String commaSeparatedMsgId, String uiElement, ArrayList<String> listOfIdsToRemove) {
/*      */     try {
/* 2145 */       StringBuffer toreturn = new StringBuffer("");
/* 2146 */       if (commaSeparatedMsgId != null) {
/* 2147 */         StringTokenizer msgids = new StringTokenizer(commaSeparatedMsgId, ",");
/* 2148 */         int count = 0;
/* 2149 */         while (msgids.hasMoreTokens()) {
/* 2150 */           String id = msgids.nextToken();
/* 2151 */           String message = ConfMonitorConfiguration.getInstance().getMessageTextForId(monitorType, id);
/* 2152 */           String image = ConfMonitorConfiguration.getInstance().getMessageImageForId(monitorType, id);
/* 2153 */           count++;
/* 2154 */           if (!listOfIdsToRemove.contains("MESSAGE_" + id)) {
/* 2155 */             if (toreturn.length() == 0) {
/* 2156 */               toreturn.append("<table width=\"100%\">");
/*      */             }
/* 2158 */             toreturn.append("<tr><td width=\"100%\" class=\"msg-table-width\"><table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\"><tbody><tr>");
/* 2159 */             if (!image.trim().equals("")) {
/* 2160 */               toreturn.append("<td class=\"msg-table-width-bg\"><img width=\"18\" height=\"18\" alt=\"Icon\" src=\"" + image + "\">&nbsp;</td>");
/*      */             }
/* 2162 */             toreturn.append("<td class=\"msg-table-width\"><div id=\"htmlMessage\">" + message + "</div></td>");
/* 2163 */             toreturn.append("</tr></tbody></table></td></tr>");
/*      */           }
/*      */         }
/* 2166 */         if (toreturn.length() > 0) {
/* 2167 */           toreturn.append("TABLE".equals(uiElement) ? "<tr><td><img src=\"../images/spacer.gif\" width=\"10\"></td></tr></table>" : "</table>");
/*      */         }
/*      */       }
/*      */       
/* 2171 */       return toreturn.toString();
/*      */     }
/*      */     catch (Exception e) {
/* 2174 */       e.printStackTrace(); }
/* 2175 */     return "";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/* 2181 */   private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2187 */   private static Map<String, Long> _jspx_dependants = new HashMap(2);
/* 2188 */   static { _jspx_dependants.put("/jsp/util.jspf", Long.valueOf(1473429417000L));
/* 2189 */     _jspx_dependants.put("/jsp/includes/dashBoardActions.jspf", Long.valueOf(1473429417000L));
/*      */   }
/*      */   
/*      */ 
/*      */   private TagHandlerPool _005fjspx_005ftagPool_005flogic_005fpresent_0026_005frole;
/*      */   private TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;
/*      */   private TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
/*      */   private javax.el.ExpressionFactory _el_expressionfactory;
/*      */   private org.apache.tomcat.InstanceManager _jsp_instancemanager;
/*      */   public Map<String, Long> getDependants()
/*      */   {
/* 2200 */     return _jspx_dependants;
/*      */   }
/*      */   
/*      */   public void _jspInit() {
/* 2204 */     this._005fjspx_005ftagPool_005flogic_005fpresent_0026_005frole = TagHandlerPool.getTagHandlerPool(getServletConfig());
/* 2205 */     this._005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = TagHandlerPool.getTagHandlerPool(getServletConfig());
/* 2206 */     this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest = TagHandlerPool.getTagHandlerPool(getServletConfig());
/* 2207 */     this._el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
/* 2208 */     this._jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
/*      */   }
/*      */   
/*      */   public void _jspDestroy() {
/* 2212 */     this._005fjspx_005ftagPool_005flogic_005fpresent_0026_005frole.release();
/* 2213 */     this._005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
/* 2214 */     this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
/*      */   }
/*      */   
/*      */ 
/*      */   public void _jspService(HttpServletRequest request, HttpServletResponse response)
/*      */     throws IOException, javax.servlet.ServletException
/*      */   {
/* 2221 */     HttpSession session = null;
/*      */     
/*      */ 
/* 2224 */     JspWriter out = null;
/* 2225 */     Object page = this;
/* 2226 */     JspWriter _jspx_out = null;
/* 2227 */     PageContext _jspx_page_context = null;
/*      */     
/*      */     try
/*      */     {
/* 2231 */       response.setContentType("text/html;charset=UTF-8");
/* 2232 */       PageContext pageContext = _jspxFactory.getPageContext(this, request, response, "/jsp/ErrorPage.jsp", true, 8192, true);
/*      */       
/* 2234 */       _jspx_page_context = pageContext;
/* 2235 */       javax.servlet.ServletContext application = pageContext.getServletContext();
/* 2236 */       ServletConfig config = pageContext.getServletConfig();
/* 2237 */       session = pageContext.getSession();
/* 2238 */       out = pageContext.getOut();
/* 2239 */       _jspx_out = out;
/*      */       
/* 2241 */       out.write("<!-- $Id$-->\n");
/* 2242 */       out.write(10);
/* 2243 */       out.write(10);
/* 2244 */       out.write(10);
/* 2245 */       out.write(10);
/* 2246 */       out.write("\n\n\n\n");
/* 2247 */       out.write(10);
/* 2248 */       out.write(10);
/* 2249 */       out.write(10);
/* 2250 */       out.write("<!--$Id$ -->\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n<bean:define id=\"available\" name=\"colors\" property=\"AVAILABLE\" type=\"java.lang.String\"/>\n<bean:define id=\"unavailable\" name=\"colors\" property=\"UNAVAILABLE\" type=\"java.lang.String\"/>\n<bean:define id=\"unmanaged\" name=\"colors\" property=\"UNMANAGED\" type=\"java.lang.String\"/>\n<bean:define id=\"scheduled\" name=\"colors\" property=\"SCHEDULED\" type=\"java.lang.String\"/>\n<bean:define id=\"critical\" name=\"colors\" property=\"CRITICAL\" type=\"java.lang.String\"/>\n<bean:define id=\"clear\" name=\"colors\" property=\"CLEAR\" type=\"java.lang.String\"/>\n<bean:define id=\"warning\" name=\"colors\" property=\"WARNING\" type=\"java.lang.String\"/>\n\n");
/*      */       
/* 2252 */       String isTabletStr = (String)request.getSession().getAttribute("isTablet");
/* 2253 */       boolean isTablet = (isTabletStr != null) && (isTabletStr.trim().equals("true"));
/*      */       
/* 2255 */       out.write(10);
/* 2256 */       out.write(10);
/* 2257 */       out.write(10);
/* 2258 */       out.write(10);
/*      */       
/* 2260 */       String siteDashId = null;
/* 2261 */       if (EnterpriseUtil.isIt360MSPEdition)
/*      */       {
/*      */ 
/* 2264 */         siteDashId = DashboardUtil.getDashboardId(FormatUtil.getString("it360.dashboard.site.text"));
/* 2265 */         CustomerManagementAPI.getInstance();Properties siteProp = CustomerManagementAPI.getSiteProp(request);
/* 2266 */         if ((siteProp == null) || (siteProp.isEmpty()))
/*      */         {
/* 2268 */           siteDashId = "-1";
/*      */         }
/*      */       }
/*      */       try
/*      */       {
/* 2273 */         out.write("\n<script>\nfunction getpage(pageid,tab,forpage)\n{\ndocument.location.href=\"/MyPage.do?method=viewDashBoard&forpage=\"+forpage+\"&selectedpageid=\"+pageid+\"&selectedTab=\"+tab;\n}\n\nfunction getHomePage(pageid,tab,forpage)\n{\n\tvar siteDashId = \"");
/* 2274 */         out.print(siteDashId);
/* 2275 */         out.write("\";\n\tif(siteDashId != null && siteDashId != \"null\" && siteDashId != -1)\n\t{\n\t\tdocument.location.href=\"/MyPage.do?method=viewDashBoard&forpage=\"+forpage+\"&selectedpageid=\"+siteDashId+\"&selectedTab=\"+tab;\n\t}\n\telse\n\t{\n\tdocument.location.href=\"/MyPage.do?method=viewDashBoard&forpage=\"+forpage;\n}\n}\n\nfunction customizeTabs(forpage)\n{\n\t");
/* 2276 */         if (request.isUserInRole("DEMO"))
/*      */         {
/*      */ 
/* 2279 */           out.write("\n\t\talert(\"");
/* 2280 */           out.print(FormatUtil.getString("am.webclient.manager.settingsab.jsalertfordemo.text"));
/* 2281 */           out.write("\");\n\t");
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*      */ 
/* 2287 */           out.write("\n\tfnOpenNewWindowWithHeightWidthPlacement('/MyPage.do?method=editTabs&forpage='+forpage,'900','500','15','15'); //No I18N\n\t");
/*      */         }
/*      */         
/*      */ 
/* 2291 */         out.write("\n}\n\nfunction getMorePages(id)\n{\n//showMenuInDialog1('dashboardlocation','dashboardsdiv');\nshowMenuInDialog2(id,'dashboardsdiv');\n}\nvar http2 ;\nfunction showMenuInDialog2(holder,source)\n{\n \tif(document.getElementById(\"dashboardsdiv\").style.display==\"none\"){\n\n    http2=getHTTPObject();\n    var holder1=holder;\n    http2.onreadystatechange=new Function('AjaxCallForDashboard2(\\''+holder+'\\')');\n    URL=\"/MyPage.do?method=listDashBoards\";\n    http2.open(\"GET\",URL,true);\n    http2.send(null);\n  }\n  else{\n  //closeMonitorPop();\n  }\n}\n</script>\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n  <tbody>\n    <tr class=\"tabBtmLine\">\n      <td nowrap=\"nowrap\">\n        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" id=\"InnerTab\">\n          <tbody>\n            <tr>\n              <td width=\"17\"/>&nbsp;&nbsp;&nbsp;&nbsp;\n");
/*      */         
/* 2293 */         int nooftabs = 0;
/* 2294 */         String resourceid = request.getParameter("resourceid");
/* 2295 */         String resourcename = request.getParameter("resourcename");
/* 2296 */         String titles = request.getParameter("titles");
/* 2297 */         String tooltips = request.getParameter("tooltip");
/* 2298 */         String functions = request.getParameter("functions");
/* 2299 */         String tabs = request.getParameter("tabs");
/* 2300 */         String selectedtab = request.getParameter("selected");
/* 2301 */         String errorcode = request.getParameter("errorcode");
/* 2302 */         String pageids = request.getParameter("pageids");
/* 2303 */         String moretabid = "20";
/*      */         
/* 2305 */         StringTokenizer tok = new StringTokenizer(titles, ",");
/* 2306 */         StringTokenizer tok1 = new StringTokenizer(functions, ",");
/* 2307 */         StringTokenizer tok2 = new StringTokenizer(tooltips, ",");
/* 2308 */         StringTokenizer tok3 = new StringTokenizer(pageids, ",");
/* 2309 */         StringTokenizer tok4 = new StringTokenizer(tabs, ",");
/*      */         
/* 2311 */         while (tok.hasMoreTokens())
/*      */         {
/* 2313 */           nooftabs++;
/* 2314 */           String title = tok.nextToken();
/* 2315 */           String functionName = tok1.nextToken();
/* 2316 */           String tooltip = tok2.nextToken();
/* 2317 */           String pageid = tok3.nextToken();
/* 2318 */           String tab = tok4.nextToken();
/* 2319 */           if ((!request.isUserInRole("OPERATOR")) || (!"Business View".equals(title)))
/*      */           {
/*      */ 
/*      */ 
/* 2323 */             out.write("\n              <td><table title=\"");
/* 2324 */             out.print(FormatUtil.getString(tooltip));
/* 2325 */             out.write("\" id=\"");
/* 2326 */             out.print(tab);
/* 2327 */             out.write("Tab\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"cursor: pointer;\" >\n                  <tbody>\n                    <tr>\n                      <td ");
/* 2328 */             if (!selectedtab.equals(tab)) {
/* 2329 */               out.write("class=\"tbUnselected_Left\"");
/*      */             }
/* 2331 */             if (selectedtab.equals(tab)) {
/* 2332 */               out.write("class=\"tbSelected_Left\"");
/*      */             }
/* 2334 */             out.write(" ><img width=\"1\" height=\"1\" alt=\"spacer\" src=\"/images/spacer.gif\"/></td>\n                      <td ");
/* 2335 */             if (!selectedtab.equals(tab)) {
/* 2336 */               out.write("class=\"tbUnselected_Middle\"");
/*      */             }
/* 2338 */             out.write(32);
/* 2339 */             if (selectedtab.equals(tab)) {
/* 2340 */               out.write("class=\"tbSelected_Middle\"");
/*      */             }
/* 2342 */             out.write(" onClick=\"SetTabStyle('");
/* 2343 */             out.print(tab);
/* 2344 */             out.write("','InnerTab');");
/* 2345 */             out.print(functionName);
/* 2346 */             out.write(40);
/* 2347 */             out.write(39);
/* 2348 */             out.print(pageid);
/* 2349 */             out.write(39);
/* 2350 */             out.write(44);
/* 2351 */             out.print(tab);
/* 2352 */             out.write(44);
/* 2353 */             out.print(MyPageAction.forpage);
/* 2354 */             out.write(",'A_");
/* 2355 */             out.print(tab);
/* 2356 */             out.write("Tab');\" style=\"padding-left:5px;padding-right:5px\">\n                      <span ");
/* 2357 */             if (!selectedtab.equals(tab)) {
/* 2358 */               out.write(" class=\"tabLink\"");
/*      */             }
/* 2360 */             out.write(32);
/* 2361 */             if (selectedtab.equals(tab)) {
/* 2362 */               out.write("class=\"tabLinkActive\"");
/*      */             }
/* 2364 */             out.write(" title=\"");
/* 2365 */             out.print(title);
/* 2366 */             out.write("\"  id=\"A_");
/* 2367 */             out.print(tab);
/* 2368 */             out.write("Tab\">");
/* 2369 */             out.print(getTrimmedText(title, 21));
/* 2370 */             out.write("</span>\n                      </td>\n                      <td ");
/* 2371 */             if (!selectedtab.equals(tab)) {
/* 2372 */               out.write("class=\"tbUnselected_Right\"");
/*      */             }
/* 2374 */             out.write(32);
/* 2375 */             if (selectedtab.equals(tab)) {
/* 2376 */               out.write("class=\"tbSelected_Right\"");
/*      */             }
/* 2378 */             out.write("><img width=\"1\" height=\"1\" alt=\"spacer\" src=\"/images/spacer.gif\"/></td>\n                    </tr>\n                  </tbody>\n                </table>\n              </td>\n");
/*      */           } }
/* 2380 */         if (!MyPageAction.forpage.equals("3"))
/*      */         {
/* 2382 */           out.write("\n    <td><table title=\"");
/* 2383 */           out.print(FormatUtil.getString("am.mypage.more.dashboards.title.text"));
/* 2384 */           out.write("\" id=\"");
/* 2385 */           out.print(moretabid);
/* 2386 */           out.write("Tab\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"cursor: pointer;\" >\n                  <tbody>\n                    <tr>\n                      <td class=\"tbUnselected_Left\" ><img width=\"1\" height=\"1\" alt=\"spacer\" src=\"/images/spacer.gif\"/></td>\n                      <td class=\"tbUnselected_Middle\" onClick=\"persistPrevTabSelected();SetTabStyle('");
/* 2387 */           out.print(moretabid);
/* 2388 */           out.write("','InnerTab');getMorePages('A_");
/* 2389 */           out.print(moretabid);
/* 2390 */           out.write("Tab');\" style=\"padding-left:5px;padding-right:5px\">\n\t\t\t      <span class=\"tabLink\" id=\"A_");
/* 2391 */           out.print(moretabid);
/* 2392 */           out.write("Tab\" title=\"");
/* 2393 */           out.print(FormatUtil.getString("am.mypage.more.dashboards.text"));
/* 2394 */           out.write(34);
/* 2395 */           out.write(62);
/* 2396 */           out.print(FormatUtil.getString("am.mypage.more.dashboards.text"));
/* 2397 */           out.write("&nbsp;<img  width=\"7\" vspace=\"2\" height=\"4\" border=\"0\" valign=\"top\" src=\"/images/icon_black_arrow.gif\"/></span>\n                      </td>\n                      <td class=\"tbUnselected_Right\"><img width=\"1\" height=\"1\" alt=\"spacer\" src=\"/images/spacer.gif\"/></td>\n                    </tr>\n                  </tbody>\n                </table>\n              </td>\n            <td >\n           <a class=\"dash-edit-tab\" id=\"settingshook\" href=\"javascript:void(0);\" onclick=\"customizeTabs(");
/* 2398 */           out.print(MyPageAction.forpage);
/* 2399 */           out.write(");\" title=\"");
/* 2400 */           out.print(FormatUtil.getString("am.mypage.tabedit.tooltip.text"));
/* 2401 */           out.write("\"></a>\n           </td>\n            ");
/*      */         }
/*      */         
/*      */ 
/* 2405 */         out.write("\n            <td>\n            </td>\n            <td>\n\t    <a class=\"dash-popout\" id=\"settingshook\" href=\"javascript:void(0);\" onclick=\"javascript:popOut();\" title=\"");
/* 2406 */         out.print(FormatUtil.getString("am.webclient.mypage.popout.text"));
/* 2407 */         out.write("\"></a>\n            </td>\n            </tr>\n          </tbody>\n        </table>\n      </td>\n      <td align=\"right\">\n      ");
/* 2408 */         if (!com.adventnet.appmanager.util.Constants.isIt360)
/*      */         {
/* 2410 */           out.write("\n      <div id=\"loadingg\" style=\"display:none;\">\n\t      \t&nbsp;&nbsp;<img alt=\"Loading...\" src=\"/images/icon_cogwheel.gif\" border=\"10\"/>\n      </div>\n\t  ");
/*      */         }
/* 2412 */         out.write("\n      </td>\n      <td align=\"right\" class=\"cust-padd-rt\">\n      <a  href=\"javascript:generateReportForWidget()\" name=\"pdfReport\"><img  align=\"center\"  src=\"../images/icon_pdf.gif\" border=\"0\" alt=\"Export as PDF\" title=\"");
/* 2413 */         out.print(FormatUtil.getString("am.reporttab.pdftitle.text"));
/* 2414 */         out.write("\"></a> \n      </td>\n      <td align=\"right\" width=\"100\">\n      ");
/*      */         
/* 2416 */         PresentTag _jspx_th_logic_005fpresent_005f0 = (PresentTag)this._005fjspx_005ftagPool_005flogic_005fpresent_0026_005frole.get(PresentTag.class);
/* 2417 */         _jspx_th_logic_005fpresent_005f0.setPageContext(_jspx_page_context);
/* 2418 */         _jspx_th_logic_005fpresent_005f0.setParent(null);
/*      */         
/* 2420 */         _jspx_th_logic_005fpresent_005f0.setRole("ADMIN,ENTERPRISEADMIN,DEMO");
/* 2421 */         int _jspx_eval_logic_005fpresent_005f0 = _jspx_th_logic_005fpresent_005f0.doStartTag();
/* 2422 */         if (_jspx_eval_logic_005fpresent_005f0 != 0) {
/*      */           for (;;) {
/* 2424 */             out.write("\n\t\t\t<table width=\"100%\" id=\"actionListTable\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"position:relative; bottom:3px;\" onclick=\"showActions('actionListTable', 'actionListDiv')\">\n        <tr>\n                <td class=\"btnon\" onmouseup=\"className='btnover'\"  onmousedown=\"className='btnclick'\"  onmouseover=\"className='btnover';\" onmouseout=\"className='btnout';\"  class=\"button-mid-tile\" align=\"center\" ><b>");
/* 2425 */             out.print(FormatUtil.getString("am.mypage.actions.button.text"));
/* 2426 */             out.write(" </b><img vspace=\"2\" width=\"7\" border=\"0\" height=\"4\" alt=\"spacer\" src=\"/images/red-down-arrow.gif\"/></td>\n              </tr>\n            </table>\n            ");
/* 2427 */             out.write("\n\n\n<div style=\"display:none;\" id=\"actionListDiv\">\n\t<table id=\"dropMenuMgActions\" cellpadding=\"0\" cellspacing=\"0\"  border=0 align=\"right\" class=\"action-but-padding\">\n\t\t<TR>\n\t\t\t<td>\n\t\t\t\t<table  cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"action-but-border\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t\t\t\t\t\t<tr><td height=\"6\"></td></tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td >\n\t\t\t\t\t\t\t\t\t<span class=\"bodytext\"><b  style=\"text-decoration:none; cursor:text;\">&nbsp; ");
/* 2428 */             out.print(FormatUtil.getString("am.mypage.dashbobard.actions.text"));
/* 2429 */             out.write("</b></span>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr><td height=\"6\"></td></tr>\n\t\t\t\t\t\t\t\t");
/* 2430 */             if (!DashboardUtil.isReadOnlyVewForUser(request.getRemoteUser(), (String)request.getAttribute("pageid"))) {
/* 2431 */               out.write("\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td >\n\t\t\t\t\t\t\t\t\t<a href= \"javascript:void(0)\" onclick=\"addWidgets()\" style=\"text-decoration:none;\"><span class=\"bodytext\"><img src=\"/images/add-selectedMonitors.gif\" border=\"0\"/> ");
/* 2432 */               out.print(FormatUtil.getString("am.mypage.add.widgets.text"));
/* 2433 */               out.write("</span></a>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t<a href=\"/MyPage.do?method=editMyPage&pageid=");
/* 2434 */               if (_jspx_meth_c_005fout_005f0(_jspx_th_logic_005fpresent_005f0, _jspx_page_context))
/*      */                 return;
/* 2436 */               out.write("&selectedTab=");
/* 2437 */               out.print(selectedtab);
/* 2438 */               out.write("&forpage=");
/* 2439 */               out.print(MyPageAction.forpage);
/* 2440 */               out.write("\"><span class=\"bodytext\"><img src=\"/images/icon_edit.gif\" border=\"0\"/> ");
/* 2441 */               out.print(FormatUtil.getString("am.mypage.edit.dashboard.text"));
/* 2442 */               out.write("</span></a>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t");
/* 2443 */               if ((com.adventnet.appmanager.util.Constants.defaultDashboardIds != null) && (!com.adventnet.appmanager.util.Constants.defaultDashboardIds.contains(Integer.valueOf(Integer.parseInt((String)request.getAttribute("pageid")))))) {
/* 2444 */                 out.write("\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td >\n\t\t\t\t\t\t\t\t\t<a href=\"javascript:deleteDashboard();\" ><span class=\"bodytext\"><img src=\"/images/cam_report_disabled.gif\" border=\"0\"/> ");
/* 2445 */                 out.print(FormatUtil.getString("am.mypage.delete.dashboard.text"));
/* 2446 */                 out.write("</span></a>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t");
/*      */               }
/*      */             }
/* 2449 */             if (MyPageAction.forpage.equals("1")) {
/* 2450 */               out.write("\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td >\n\t\t\t\t\t\t\t\t\t<a href= \"/MyPage.do?method=newMyPage&forpage=");
/* 2451 */               out.print(MyPageAction.forpage);
/* 2452 */               out.write("\" ><span class=\"bodytext\"><img src=\"/images/icon_new_dashboard.png\" border=\"0\"/> ");
/* 2453 */               out.print(FormatUtil.getString("am.mypage.new.dashboard.text"));
/* 2454 */               out.write("</span></a>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t");
/* 2455 */               if (!com.adventnet.appmanager.util.Constants.sqlManager) {
/* 2456 */                 out.write("\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td align=\"right\"  class=\"bodytext\" nowrap=\"true\"><a style=\"text-decoration: none;\" href=\"/MyPage.do?method=newMyPage&pagetype=businesspage\"><img src=\"/images/icon_new_dashboard.png\" border=\"0\"/>  ");
/* 2457 */                 out.print(FormatUtil.getString("am.webclient.mypage.businessdashboard.new"));
/* 2458 */                 out.write("</a>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t");
/*      */               } }
/* 2460 */             out.write("\n\t\t\t\t\t\t\t\t");
/* 2461 */             out.write("\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td align=\"right\"  class=\"bodytext\" nowrap=\"true\"><a style=\"text-decoration: none;\" href=\"javascript:generateReportForWidget();\"><img src=\"../images/icon_pdf.gif\" border=\"0\"/>  ");
/* 2462 */             out.print(FormatUtil.getString("am.mypage.generate.dashboard.report"));
/* 2463 */             out.write("</a>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr><td height=\"6\"></td></tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td valign=\"top\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t\t\t\t\t\t<tr><td height=\"6\"></td></tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t<span class=\"bodytext\"><b  style=\"text-decoration:none; cursor:text;\">&nbsp; ");
/* 2464 */             out.print(FormatUtil.getString("Views"));
/* 2465 */             out.write("</b></span>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr><td height=\"6\"></td></tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0);\" id=\"publishMghook\" onclick=\"showURLInDialog('/MyPage.do?method=getPublishedKey&pageid=");
/* 2466 */             if (_jspx_meth_c_005fout_005f1(_jspx_th_logic_005fpresent_005f0, _jspx_page_context))
/*      */               return;
/* 2468 */             out.write("','position=relative,srcElement=settingshook,left=50,top=-10,title=");
/* 2469 */             out.print(FormatUtil.getString("am.mypage.dashboard.public.dashboard.text"));
/* 2470 */             out.write("');\" ><span class=\"bodytext\"><img src=\"/images/icon_publish_dsboard.gif\" border=\"0\"/> ");
/* 2471 */             out.print(FormatUtil.getString("am.mypage.dashboard.public.dashboard.text"));
/* 2472 */             out.write("</span></a>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td >\n\t\t\t\t\t\t\t\t\t<a href= \"javascript:void(0);\" onclick=\"javascript:popOut();\" ><span class=\"bodytext\"><img src=\"/images/popup.gif\" border=\"0\"/> ");
/* 2473 */             out.print(FormatUtil.getString("am.webclient.mypage.popout.text"));
/* 2474 */             out.write("</span></a>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t");
/*      */             
/* 2476 */             IfTag _jspx_th_c_005fif_005f0 = (IfTag)this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(IfTag.class);
/* 2477 */             _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
/* 2478 */             _jspx_th_c_005fif_005f0.setParent(_jspx_th_logic_005fpresent_005f0);
/*      */             
/* 2480 */             _jspx_th_c_005fif_005f0.setTest("${hideSetDefault == null}");
/* 2481 */             int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
/* 2482 */             if (_jspx_eval_c_005fif_005f0 != 0) {
/*      */               for (;;) {
/* 2484 */                 out.write("\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t<a href=\"/MyPage.do?method=setAsDefault&dashboardtype=1&forpage=");
/* 2485 */                 out.print(MyPageAction.forpage);
/* 2486 */                 out.write("&pageid=");
/* 2487 */                 if (_jspx_meth_c_005fout_005f2(_jspx_th_c_005fif_005f0, _jspx_page_context))
/*      */                   return;
/* 2489 */                 out.write("\"><span class=\"bodytext\"><img src=\"/images/icon_set_default.gif\" border=\"0\"/> ");
/* 2490 */                 out.print(FormatUtil.getString("am.mypage.setasdefault.text"));
/* 2491 */                 out.write("</span></a>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr><td height=\"6\"></td></tr>\n\t\t\t\t\t\t\t\t");
/* 2492 */                 int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
/* 2493 */                 if (evalDoAfterBody != 2)
/*      */                   break;
/*      */               }
/*      */             }
/* 2497 */             if (_jspx_th_c_005fif_005f0.doEndTag() == 5) {
/* 2498 */               this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0); return;
/*      */             }
/*      */             
/* 2501 */             this._005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
/* 2502 */             out.write("\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</TR>\n\t</table>\n</div>\n\n");
/* 2503 */             out.write("\n      ");
/* 2504 */             int evalDoAfterBody = _jspx_th_logic_005fpresent_005f0.doAfterBody();
/* 2505 */             if (evalDoAfterBody != 2)
/*      */               break;
/*      */           }
/*      */         }
/* 2509 */         if (_jspx_th_logic_005fpresent_005f0.doEndTag() == 5) {
/* 2510 */           this._005fjspx_005ftagPool_005flogic_005fpresent_0026_005frole.reuse(_jspx_th_logic_005fpresent_005f0);
/*      */         }
/*      */         else {
/* 2513 */           this._005fjspx_005ftagPool_005flogic_005fpresent_0026_005frole.reuse(_jspx_th_logic_005fpresent_005f0);
/* 2514 */           out.write("\n      </td>\n    </tr>\n  </tbody>\n</table>\n<script language=\"JavaScript\" type=\"text/javascript\" src=\"../apminsight/js/jquery.htmlClean.min.js\"></script>\n<script>\n\nfunction AjaxCallForDashboard2(holder)\n{\n  if(http2.readyState==4)\n  {\n    document.getElementById(\"dashboardsdiv\").innerHTML=http2.responseText;\n    var holderObj = document.getElementById(holder);\n    var posX = findPosX(holderObj)-");
/* 2515 */           out.print(nooftabs * 100);
/* 2516 */           out.write(";\n    var posY = findPosY(holderObj)+2;\n    var finalY = posY + holderObj.offsetHeight - document.body.scrollTop;\n    showDialog(document.getElementById('dashboardsdiv').innerHTML, 'position=absolute,closeButton=no,closeOnBodyClick=yes,left=' + posX + ',top=' + finalY);\n\n                //document.getElementById(\"dashboardsdiv\").style.display=\"block\";\n                document.getElementById(\"loadingg\").style.display = \"none\"\n  }\n}\n\n//Method used to the persist the previously viewed dashboard title, required for not loosing the selected dashabord title if  we select the More button..\nfunction persistPrevTabSelected()\n{\n\t  var prevTabSelected=$('span.tabLinkActive').attr('title');//No I18N\n\t  var moreTabEle = document.getElementById(\"A_");
/* 2517 */           out.print(moretabid);
/* 2518 */           out.write("Tab\");\n\t  moreTabEle.title = prevTabSelected;\n}\n\nfunction generateReportForWidget()\n{\n\t$(\"#containerDiv\").append(\"<div id=\\\"widgetsdata\\\" style=\\\"display:none\\\"></div>\");//No I18N\n\t \n\t$(\"div#widgetsdata\").html('');//clear div before appending\n\t$(\"div#widgetsdata\").append($(\"div#containerDiv\").clone());//No I18N\n\n\t$(\"div#widgetsdata\").find('.widget-links,a').each(function(){//No I18N\n\t\t  if($(this).attr('onmouseout') || $(this).attr('onmouseover') || $(this).attr('onclick')){//No I18N\n\t\t  \t$(this).removeAttr('onmouseout').removeAttr('onmouseover').removeAttr('onclick');//No I18N\n\t\t  }\n\t});\n\n\t//performance metric widget graph resizing inorder to fit in the PDF page\n\t$(\"div#widgetsdata\").find('#graphArea img').each(function(){//No I18N\n\t\tif($(this).height() > 800)\n\t\t{\n\t\t\t$(this).height(800);\n\t\t}\n\t\tif($(this).width() > 650)\n\t\t{\n\t\t\t$(this).width(650);\n\t\t}\n\t});\n\n\n      //removing script and meta tags goes here\n\t  $(\"div#widgetsdata\").find('script,map').remove();//No I18N\n\t  $(\"div#widgetsdata\").find('div meta').remove();\n");
/* 2519 */           out.write("\t  \n\n\t  var col2wid = $(\"div#widgetsdata\").find(\"td#col2\").remove();//No I18N\n\t  var col3wid = $(\"div#widgetsdata\").find(\"td#col3\").remove();//No I18N\n\t  var col4wid = $(\"div#widgetsdata\").find(\"td#col4\").remove();//No I18N\n\t  var contentHeight = $(\"div#monitorView\").prop(\"scrollHeight\");//No I18N\n\t  \n\t  $(\"div#widgetsdata\").find(\"td#col1\").append($(col2wid).html()).append($(col3wid).html()).append($(col4wid).html());//No I18N\n\t  $(\"div#widgetsdata\").find(\"div.pos_relative,td.tableHeader1\").width(\"100%\");//No I18N\n\t  $(\"div#widgetsdata\").find(\"div.pos_relative\").find(\"div#monitorView\").height(contentHeight+20);\n\t  $(\"div#widgetsdata\").find(\"div.pos_relative\").css(\"display\",'inline');//No I18N\n\t  $(\"div#widgetsdata\").find(\"td.widgetHeader\").find(\"img\").remove();//No I18N\n\t  $(\"div#widgetsdata\").find(\"td.widgetHeader\").remove();//No I18N\n\t  \n\n\t  //to disable timepriod in Last 24 hours/30days Availability/health history widget\n\t  $(\"div#widgetsdata\").find(\"select#historyperiod,select#healthperiod\").css(\"display\",'none');//No I18N\n");
/* 2520 */           out.write("\t  \n\t  //to remove paddingleft causing PDF width cut off\n\t  $(\"div#widgetsdata\").find(\".columnheading,.whitegrayrightalign\").css(\"cssText\", \"padding: 0px !important;\");//No I18N\n\t  \n\t  //helpcard widget removal if any in the dashboard\n\t  var helpcardwidgetIds = \"");
/* 2521 */           out.print(DashboardUtil.getWidgetIds(300));
/* 2522 */           out.write("\";\n\t  if(helpcardwidgetIds != \"\")\n\t  {\t\t  \n\t\t  $(\"div#widgetsdata\").find(helpcardwidgetIds).remove();//No I18N\n\t  }\t  \n\t \n\t  //removing <bean:define> tags goes here\n\t  $(\"div#widgetsdata\").find('bean\\\\:define').each(function(){//No I18N\n\t\t$(this).unwrap();\n\t  }); \n\t  \n\t  var doubleQuote_regex = /[\"]/gm;//No I18N\n\n\n\t  var contentDiv = $(\"div#widgetsdata\").find(\"td#col1\").html();//No I18N\t  \n\t  var contentDivData = $.htmlClean(contentDiv,{allowedAttributes:[[\"style\"],[\"height\"],[\"width\"],[\"border\"],[\"align\"],[\"valign\"],[\"cellpadding\"],[\"cellspacing\"],[\"background-image\"],[\"id\"],[\"style\"],[\"title\"]], removeAttrs:[\"alt\",\"href\",\"onmouseover\",\"onmouseout\",\"onclick\",[\"style\", [\"float\"]]], removeTags:[\"iframe\"] , format:true}).replace(doubleQuote_regex,'&quot;');//No I18N\t  \n\t  var opfileName=$('span.tabLinkActive').attr('title');//No I18N\n\n\t  $(\"#containerDiv\").find(\"#widgetsdata\").remove();//removing the cloned container div after pdf processing over\n\n\t  var url = '/MyPage.do?method=generatePdfForWidget'; //No I18N\n");
/* 2523 */           out.write("\t   var inputs = '';\n\t   inputs+='<input type=\"hidden\" name=\"divToConvert\" value=\"'+contentDivData+'\"/>'; //No I18N\n\t   inputs+='<input type=\"hidden\" name=\"opfile\" value=\"'+opfileName+'\"/>'; //No I18N\n\t   jQuery('<form action=\"'+url+'\" method=\"post\">'+inputs+'</form>')//No I18N\n\t   .appendTo('body').submit().remove(); //No I18N\n}\n\n\n\n</script>\n");
/*      */         }
/*      */       }
/*      */       catch (Exception ex) {
/* 2527 */         ex.printStackTrace();
/*      */       }
/*      */     } catch (Throwable t) {
/* 2530 */       if (!(t instanceof javax.servlet.jsp.SkipPageException)) {
/* 2531 */         out = _jspx_out;
/* 2532 */         if ((out != null) && (out.getBufferSize() != 0))
/* 2533 */           try { out.clearBuffer(); } catch (IOException e) {}
/* 2534 */         if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
/*      */       }
/*      */     } finally {
/* 2537 */       _jspxFactory.releasePageContext(_jspx_page_context);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean _jspx_meth_c_005fout_005f0(JspTag _jspx_th_logic_005fpresent_005f0, PageContext _jspx_page_context) throws Throwable
/*      */   {
/* 2543 */     PageContext pageContext = _jspx_page_context;
/* 2544 */     JspWriter out = _jspx_page_context.getOut();
/*      */     
/* 2546 */     OutTag _jspx_th_c_005fout_005f0 = (OutTag)this._005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(OutTag.class);
/* 2547 */     _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
/* 2548 */     _jspx_th_c_005fout_005f0.setParent((Tag)_jspx_th_logic_005fpresent_005f0);
/*      */     
/* 2550 */     _jspx_th_c_005fout_005f0.setValue("${pageid}");
/* 2551 */     int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
/* 2552 */     if (_jspx_th_c_005fout_005f0.doEndTag() == 5) {
/* 2553 */       this._005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
/* 2554 */       return true;
/*      */     }
/* 2556 */     this._005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
/* 2557 */     return false;
/*      */   }
/*      */   
/*      */   private boolean _jspx_meth_c_005fout_005f1(JspTag _jspx_th_logic_005fpresent_005f0, PageContext _jspx_page_context) throws Throwable
/*      */   {
/* 2562 */     PageContext pageContext = _jspx_page_context;
/* 2563 */     JspWriter out = _jspx_page_context.getOut();
/*      */     
/* 2565 */     OutTag _jspx_th_c_005fout_005f1 = (OutTag)this._005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(OutTag.class);
/* 2566 */     _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
/* 2567 */     _jspx_th_c_005fout_005f1.setParent((Tag)_jspx_th_logic_005fpresent_005f0);
/*      */     
/* 2569 */     _jspx_th_c_005fout_005f1.setValue("${pageid}");
/* 2570 */     int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
/* 2571 */     if (_jspx_th_c_005fout_005f1.doEndTag() == 5) {
/* 2572 */       this._005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
/* 2573 */       return true;
/*      */     }
/* 2575 */     this._005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
/* 2576 */     return false;
/*      */   }
/*      */   
/*      */   private boolean _jspx_meth_c_005fout_005f2(JspTag _jspx_th_c_005fif_005f0, PageContext _jspx_page_context) throws Throwable
/*      */   {
/* 2581 */     PageContext pageContext = _jspx_page_context;
/* 2582 */     JspWriter out = _jspx_page_context.getOut();
/*      */     
/* 2584 */     OutTag _jspx_th_c_005fout_005f2 = (OutTag)this._005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(OutTag.class);
/* 2585 */     _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
/* 2586 */     _jspx_th_c_005fout_005f2.setParent((Tag)_jspx_th_c_005fif_005f0);
/*      */     
/* 2588 */     _jspx_th_c_005fout_005f2.setValue("${pageid}");
/* 2589 */     int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
/* 2590 */     if (_jspx_th_c_005fout_005f2.doEndTag() == 5) {
/* 2591 */       this._005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
/* 2592 */       return true;
/*      */     }
/* 2594 */     this._005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
/* 2595 */     return false;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\ManageEngine\AppManager12\working\WEB-INF\lib\AdventNetAppManagerWebClient.jar!\org\apache\jsp\jsp\MyPage_005fTabs_jsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */