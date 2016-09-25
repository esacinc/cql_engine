package org.opencds.cqf.cql.execution;

import org.testng.annotations.Test;
import javax.xml.bind.JAXBException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class CqlConditionalOperatorsTest extends CqlExecutionTestBase {

  @Test
  public void testIfThenElse() throws JAXBException {
    Context context = new Context(library);
    Object result = context.resolveExpressionRef("IfTrue1").getExpression().evaluate(context);
    assertThat(result, is(5));

    result = context.resolveExpressionRef("IfFalse1").getExpression().evaluate(context);
    assertThat(result, is(5));

    result = context.resolveExpressionRef("IfNull1").getExpression().evaluate(context);
    assertThat(result, is(10));
  }

  @Test
  public void testStandardCase() throws JAXBException {
    Context context = new Context(library);
    Object result = context.resolveExpressionRef("StandardCase1").getExpression().evaluate(context);
    assertThat(result, is(5));

    result = context.resolveExpressionRef("StandardCase2").getExpression().evaluate(context);
    assertThat(result, is(5));

    result = context.resolveExpressionRef("StandardCase3").getExpression().evaluate(context);
    assertThat(result, is(15));
  }

  @Test
  public void testSelectedCase() throws JAXBException {
    Context context = new Context(library);
    Object result = context.resolveExpressionRef("SelectedCase1").getExpression().evaluate(context);
    assertThat(result, is(12));

    result = context.resolveExpressionRef("SelectedCase2").getExpression().evaluate(context);
    assertThat(result, is(15));

    result = context.resolveExpressionRef("SelectedCase3").getExpression().evaluate(context);
    assertThat(result, is(5));
  }

}
