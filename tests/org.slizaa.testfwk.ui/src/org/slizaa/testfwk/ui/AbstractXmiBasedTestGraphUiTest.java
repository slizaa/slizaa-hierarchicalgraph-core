package org.slizaa.testfwk.ui;

import org.junit.ClassRule;
import org.slizaa.testfwk.XmiBasedGraph;
import org.slizaa.testfwk.XmiBasedTestGraphProviderRule;

public class AbstractXmiBasedTestGraphUiTest extends AbstractSlizaaUiTest {

  @ClassRule
  public static XmiBasedTestGraphProviderRule testGraphProviderRule = new XmiBasedTestGraphProviderRule(
      XmiBasedGraph.EUREKA,
      rootNode -> TestGraphConfigurer.registerNodeLabelProvider(rootNode, path -> imageRegistryRule.getImage(path)));

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public static XmiBasedTestGraphProviderRule testGraph() {
    return testGraphProviderRule;
  }
}
