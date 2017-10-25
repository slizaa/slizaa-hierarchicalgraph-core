package org.slizaa.hierarchicalgraph.mapstruct;

import static org.assertj.core.api.Assertions.assertThat;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.ClassRule;
import org.junit.Test;
import org.slizaa.hierarchicalgraph.HGNode;
import org.slizaa.hierarchicalgraph.HierarchicalgraphPackage;
import org.slizaa.testfwk.TestGraph;
import org.slizaa.testfwk.TestGraphProviderRule;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class LookupNodeTest {

  @ClassRule
  public static TestGraphProviderRule _graphProvider = new TestGraphProviderRule(TestGraph.MAP_STRUCT);

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
