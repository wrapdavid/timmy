package com.sun.org.apache.xpath.internal.compiler;

public class OpCodes {
  public static final int ENDOP = -1;
  
  public static final int EMPTY = -2;
  
  public static final int ELEMWILDCARD = -3;
  
  public static final int OP_XPATH = 1;
  
  public static final int OP_OR = 2;
  
  public static final int OP_AND = 3;
  
  public static final int OP_NOTEQUALS = 4;
  
  public static final int OP_EQUALS = 5;
  
  public static final int OP_LTE = 6;
  
  public static final int OP_LT = 7;
  
  public static final int OP_GTE = 8;
  
  public static final int OP_GT = 9;
  
  public static final int OP_PLUS = 10;
  
  public static final int OP_MINUS = 11;
  
  public static final int OP_MULT = 12;
  
  public static final int OP_DIV = 13;
  
  public static final int OP_MOD = 14;
  
  public static final int OP_QUO = 15;
  
  public static final int OP_NEG = 16;
  
  public static final int OP_STRING = 17;
  
  public static final int OP_BOOL = 18;
  
  public static final int OP_NUMBER = 19;
  
  public static final int OP_UNION = 20;
  
  public static final int OP_LITERAL = 21;
  
  static final int FIRST_NODESET_OP = 22;
  
  public static final int OP_VARIABLE = 22;
  
  public static final int OP_GROUP = 23;
  
  public static final int OP_EXTFUNCTION = 24;
  
  public static final int OP_FUNCTION = 25;
  
  static final int LAST_NODESET_OP = 25;
  
  public static final int OP_ARGUMENT = 26;
  
  public static final int OP_NUMBERLIT = 27;
  
  public static final int OP_LOCATIONPATH = 28;
  
  public static final int OP_PREDICATE = 29;
  
  public static final int OP_MATCHPATTERN = 30;
  
  public static final int OP_LOCATIONPATHPATTERN = 31;
  
  public static final int NODETYPE_COMMENT = 1030;
  
  public static final int NODETYPE_TEXT = 1031;
  
  public static final int NODETYPE_PI = 1032;
  
  public static final int NODETYPE_NODE = 1033;
  
  public static final int NODENAME = 34;
  
  public static final int NODETYPE_ROOT = 35;
  
  public static final int NODETYPE_ANYELEMENT = 36;
  
  public static final int NODETYPE_FUNCTEST = 1034;
  
  public static final int AXES_START_TYPES = 37;
  
  public static final int FROM_ANCESTORS = 37;
  
  public static final int FROM_ANCESTORS_OR_SELF = 38;
  
  public static final int FROM_ATTRIBUTES = 39;
  
  public static final int FROM_CHILDREN = 40;
  
  public static final int FROM_DESCENDANTS = 41;
  
  public static final int FROM_DESCENDANTS_OR_SELF = 42;
  
  public static final int FROM_FOLLOWING = 43;
  
  public static final int FROM_FOLLOWING_SIBLINGS = 44;
  
  public static final int FROM_PARENT = 45;
  
  public static final int FROM_PRECEDING = 46;
  
  public static final int FROM_PRECEDING_SIBLINGS = 47;
  
  public static final int FROM_SELF = 48;
  
  public static final int FROM_NAMESPACE = 49;
  
  public static final int FROM_ROOT = 50;
  
  public static final int MATCH_ATTRIBUTE = 51;
  
  public static final int MATCH_ANY_ANCESTOR = 52;
  
  public static final int MATCH_IMMEDIATE_ANCESTOR = 53;
  
  public static final int AXES_END_TYPES = 53;
  
  private static final int NEXT_FREE_ID = 99;
}


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/com/sun/org/apache/xpath/internal/compiler/OpCodes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */