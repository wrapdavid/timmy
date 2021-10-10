/*    */ package javax.swing.plaf.nimbus;
/*    */ 
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JSplitPane;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class SplitPaneVerticalState
/*    */   extends State
/*    */ {
/*    */   SplitPaneVerticalState() {
/* 33 */     super("Vertical");
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isInState(JComponent paramJComponent) {
/* 38 */     return (paramJComponent instanceof JSplitPane && ((JSplitPane)paramJComponent).getOrientation() == 1);
/*    */   }
/*    */ }


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/javax/swing/plaf/nimbus/SplitPaneVerticalState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */