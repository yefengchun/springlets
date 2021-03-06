/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.springlets.data.web.select2;

import org.springframework.data.domain.Page;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Response data for data requests performed by a select2 javascript component. 
 * This class will be converted to JSON, so the property names must follow the
 * name of the properties expected by select2.
 * 
 * This class uses an expression to convert the data to a String.
 * 
 * @author Cèsar Ordiñana at http://www.disid.com[DISID Corporation S.L.]
 * @see https://select2.github.io/examples.html#data-ajax
 *
 * @param <T> Response data type
 */
public class Select2Data<T> extends Select2DataSupport<T> {

  private final Expression parseIdExpression;
  private final Expression parseTextExpression;

  /**
   * Create a response for select2 with data obtained from a request.
   * Uses SpEL expression templates 
   * (http://docs.spring.io/spring/docs/current/spring-framework-reference/html/expressions.html#expressions-templating)
   * to create the select2 data properties
   * ('id' and 'text') from the attributes of the data bean to return  
   *
   * @param page the data to show
   * @param idExpression the SpEl expression for the id field
   * @param textExpression the SpEl expression for the text field
   */
  public Select2Data(Page<T> page, String idExpression, String textExpression) {
    super(page);

    TemplateParserContext templateParserContext = new TemplateParserContext();
    ExpressionParser parser = new SpelExpressionParser();
    parseIdExpression = parser.parseExpression(idExpression, templateParserContext);
    parseTextExpression = parser.parseExpression(textExpression, templateParserContext);
  }

  protected String getAsString(T element) {
    return parseTextExpression.getValue(element, String.class);
  }

  protected String getIdAsString(T element) {
    return parseIdExpression.getValue(element, String.class);
  }

}
