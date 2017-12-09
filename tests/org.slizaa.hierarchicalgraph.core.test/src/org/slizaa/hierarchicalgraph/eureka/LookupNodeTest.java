package org.slizaa.hierarchicalgraph.eureka;

import static org.assertj.core.api.Assertions.assertThat;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.ClassRule;
import org.junit.Test;
import org.slizaa.hierarchicalgraph.HGNode;
import org.slizaa.hierarchicalgraph.HierarchicalgraphPackage;
import org.slizaa.testfwk.XmiBasedGraph;
import org.slizaa.testfwk.XmiBasedTestGraphProviderRule;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class LookupNodeTest {

  @ClassRule
  public static XmiBasedTestGraphProviderRule _graphProvider = new XmiBasedTestGraphProviderRule(XmiBasedGraph.EUREKA_AGGREGATED);

  /**
   * <p>
   * </p>
   */
  @Test
  public void testLookup() {
    EcoreUtil.getAllContents(_graphProvider.rootNode(), false).forEachRemaining((c) -> {
      if (HierarchicalgraphPackage.eINSTANCE.getHGNode().isInstance(c)) {
        HGNode node = (HGNode) c;
        assertThat(node.getIdentifier()).isNotNull();
        assertThat(_graphProvider.rootNode().lookupNode(node.getIdentifier())).isEqualTo(node);
      }
    });
  }
}
