/*    */ package com.sun.org.apache.bcel.internal.generic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IFLT
/*    */   extends IfInstruction
/*    */ {
/*    */   IFLT() {}
/*    */   
/*    */   public IFLT(InstructionHandle target) {
/* 76 */     super((short)155, target);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IfInstruction negate() {
/* 83 */     return new IFGE(this.target);
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
/*    */   public void accept(Visitor v) {
/* 96 */     v.visitStackConsumer(this);
/* 97 */     v.visitBranchInstruction(this);
/* 98 */     v.visitIfInstruction(this);
/* 99 */     v.visitIFLT(this);
/*    */   }
/*    */ }


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/com/sun/org/apache/bcel/internal/generic/IFLT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */