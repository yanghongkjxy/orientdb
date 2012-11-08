/*
 * Copyright 2010-2012 Luca Garulli (l.garulli--at--orientechnologies.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.orientechnologies.orient.core.processor.block;

import com.orientechnologies.common.parser.OSystemVariableResolver;
import com.orientechnologies.common.parser.OVariableParser;
import com.orientechnologies.common.parser.OVariableParserListener;
import com.orientechnologies.orient.core.processor.OConfigurableProcessor;
import com.orientechnologies.orient.core.processor.OProcessException;
import com.orientechnologies.orient.core.record.impl.ODocument;

public abstract class OAbstractBlock implements OProcessorBlock {

  protected Object delegate(final String iElementName, final OConfigurableProcessor iManager, final Object iContent,
      final ODocument iContext, final boolean iReadOnly) {
    try {
      return iManager.process(iContent, iContext, iReadOnly);
    } catch (Exception e) {
      throw new OProcessException("Error on processing '" + iElementName + "' field of '" + getName() + "' block", e);
    }
  }

  public void checkForBlock(final Object iValue) {
    if (!isBlock(iValue))
      throw new OProcessException("Block '" + getName() + "' was expecting a block but found object of type " + iValue.getClass());
  }

  public static boolean isBlock(final Object iValue) {
    return iValue instanceof ODocument && ((ODocument) iValue).containsField(("type"));
  }

  public static Object resolveInContext(final Object iContent, final ODocument iContext) {
    if (iContent instanceof String)
      return OVariableParser.resolveVariables((String) iContent, OSystemVariableResolver.VAR_BEGIN,
          OSystemVariableResolver.VAR_END, new OVariableParserListener() {

            @Override
            public String resolve(final String iVariable) {
              final Object val = iContext.field(iVariable);
              if (val != null)
                return val.toString();
              return null;
            }

          });
    return iContent;
  }
}