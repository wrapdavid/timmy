/*    */ package com.sun.org.apache.xpath.internal.operations;
/*    */ 
/*    */ import com.sun.org.apache.xpath.internal.XPathContext;
/*    */ import com.sun.org.apache.xpath.internal.objects.XNumber;
/*    */ import com.sun.org.apache.xpath.internal.objects.XObject;
/*    */ import javax.xml.transform.TransformerException;
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
/*    */ public class Mult
/*    */   extends Operation
/*    */ {
/*    */   static final long serialVersionUID = -4956770147013414675L;
/*    */   
/*    */   public XObject operate(XObject left, XObject right) throws TransformerException {
/* 50 */     return new XNumber(left.num() * right.num());
/*    */   }
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
/*    */   public double num(XPathContext xctxt) throws TransformerException {
/* 65 */     return this.m_left.num(xctxt) * this.m_right.num(xctxt);
/*    */   }
/*    */ }


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/com/sun/org/apache/xpath/internal/operations/Mult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */