/* Generated By:JJTree: Do not edit this line. OCreatePropertyAttributeStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import java.util.Map;

public class OCreatePropertyAttributeStatement extends SimpleNode {
  public OIdentifier settingName;
  public OExpression settingValue;

  public OCreatePropertyAttributeStatement(int id) {
    super(id);
  }

  public OCreatePropertyAttributeStatement(OrientSql p, int id) {
    super(p, id);
  }

  /**
   * Accept the visitor.
   **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  @Override public void toString(Map<Object, Object> params, StringBuilder builder) {
    settingName.toString(params, builder);
    if (settingValue != null) {
      builder.append(" ");
      settingValue.toString(params, builder);
    }
  }

  public OCreatePropertyAttributeStatement copy() {
    OCreatePropertyAttributeStatement result = new OCreatePropertyAttributeStatement(-1);
    result.settingName = settingName == null ? null : settingName.copy();
    result.settingValue = settingValue == null ? null : settingValue.copy();
    return result;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    OCreatePropertyAttributeStatement that = (OCreatePropertyAttributeStatement) o;

    if (settingName != null ? !settingName.equals(that.settingName) : that.settingName != null)
      return false;
    if (settingValue != null ? !settingValue.equals(that.settingValue) : that.settingValue != null)
      return false;

    return true;
  }

  @Override public int hashCode() {
    int result = settingName != null ? settingName.hashCode() : 0;
    result = 31 * result + (settingValue != null ? settingValue.hashCode() : 0);
    return result;
  }
}
/* JavaCC - OriginalChecksum=6a7964c2b9dad541ca962eecea00651b (do not edit this line) */