/* Generated By:JJTree: Do not edit this line. OWhereClause.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.orient.core.command.OCommandContext;
import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.metadata.schema.OClass;

import java.util.Map;

public class OWhereClause extends SimpleNode {
  OBooleanExpression baseExpression;

  public OWhereClause(int id) {
    super(id);
  }

  public OWhereClause(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  public boolean matchesFilters(OIdentifiable currentRecord, OCommandContext ctx) {
    if (baseExpression == null) {
      return true;
    }
    return baseExpression.evaluate(currentRecord, ctx);
  }

  public void toString(Map<Object, Object> params, StringBuilder builder) {
    if (baseExpression == null) {
      return ;
    }
    baseExpression.toString(params, builder);
  }


  /**
   * estimates how many items of this class will be returned applying this filter
   * 
   * @param oClass
   * @return an estimation of the number of records of this class returned applying this filter, 0 if and only if sure that no
   *         records are returned
   */
  public long estimate(OClass oClass) {
    long count = oClass.count();
    if (count > 1) {
      return count / 2;
    }
    return count;
  }
}
/* JavaCC - OriginalChecksum=e8015d01ce1ab2bc337062e9e3f2603e (do not edit this line) */
