package org.slizaa.ui.xref.internal;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.slizaa.hierarchicalgraph.HGAggregatedDependency;
import org.slizaa.hierarchicalgraph.HGNode;

/**
 * <p>
 * </p>
 */
public class XRefPart_SingleCrop_Test extends AbstractXRefPartTest {

  /**
   * <p>
   * </p>
   * 
   * @throws InterruptedException
   */
  @Test
  @Ignore
  public void test() throws InterruptedException {

    //
    for (int i = 0; i < modules().size(); i++) {

      //
      HGNode centerModule = (HGNode) modules().get(i);
      
      //
      centerTree().select(centerRootItem().getNode(getLabel(centerModule)));
      cropSelectionButton().click();
      
      assertThat(centerRootItem().getItems()).hasSize(1);
      
      //
      for (HGAggregatedDependency dependency : centerModule.getIncomingDependenciesFrom(modules())) {
        fromRootItem().getNode(getLabel(dependency.getFrom()));
      }

      //
      for (HGAggregatedDependency dependency : centerModule.getOutgoingDependenciesTo(modules())) {
        toRootItem().getNode(getLabel(dependency.getTo()));
      }
      
      uncropButton().click();
      assertThat(centerRootItem().getItems()).hasSameSizeAs(modules());
    }
  }
}