/*    */ package com.sun.xml.internal.bind.v2.runtime.reflect.opt;
/*    */ 
/*    */ import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MethodAccessor_Short
/*    */   extends Accessor
/*    */ {
/*    */   public MethodAccessor_Short() {
/* 42 */     super(Short.class);
/*    */   }
/*    */   
/*    */   public Object get(Object bean) {
/* 46 */     return Short.valueOf(((Bean)bean).get_short());
/*    */   }
/*    */   
/*    */   public void set(Object bean, Object value) {
/* 50 */     ((Bean)bean).set_short((value == null) ? Const.default_value_short : ((Short)value).shortValue());
/*    */   }
/*    */ }


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/com/sun/xml/internal/bind/v2/runtime/reflect/opt/MethodAccessor_Short.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */