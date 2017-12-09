package org.slizaa.hierarchicalgraph.core.testfwk.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import org.junit.ClassRule;
import org.slizaa.hierarchicalgraph.HGNode;
import org.slizaa.hierarchicalgraph.HGRootNode;
import org.slizaa.hierarchicalgraph.core.testfwk.XmiBasedGraph;
import org.slizaa.hierarchicalgraph.core.testfwk.XmiBasedTestGraphProviderRule;
import org.slizaa.hierarchicalgraph.spi.INodeLabelProvider;

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

  /**
   * <p>
   * </p>
   *
   * @param hgNode
   * @return
   */
  public String getLabel(HGNode hgNode) {

    //
    HGRootNode rootNode = checkNotNull(hgNode).getRootNode();

    if (rootNode.hasExtension(INodeLabelProvider.class)) {
      INodeLabelProvider labelProvider = rootNode.getExtension(INodeLabelProvider.class);
      return labelProvider.getText(hgNode);
    } else {
      throw new AssertionError("Root node has no extension of type 'INodeLabelProvider'.");
    }
  }
}
