package org.slizaa.testfwk.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import org.junit.ClassRule;
import org.slizaa.hierarchicalgraph.HGNode;
import org.slizaa.hierarchicalgraph.HGRootNode;
import org.slizaa.hierarchicalgraph.spi.INodeLabelProvider;
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
