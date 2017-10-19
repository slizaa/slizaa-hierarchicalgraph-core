package org.slizaa.hierarchicalgraph.selection.xmi;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;

import org.junit.Test;

public class XRefStack_CropSelection_Test extends AbstractXRefStack_Test {

  @Test
  public void test() {

    //
    xRefStack().pruneDependenciesForUncroppedCenterNodes(Collections.singletonList(rootNode()), rootNode().getAccumulatedIncomingCoreDependencies(), rootNode().getAccumulatedOutgoingCoreDependencies());
    
    // select "/WEB-INF/lib/archaius-core-0.7.3.jar (54411)"
    xRefStack().setSelectedCenterNodes(node(54411));
    xRefStack().cropSelection();
    
    //
    assertThat(xRefStack().getCenterNodes()).hasSize(100);
    assertThat(xRefStack().getBackreferencedCenterNodes()).hasSize(0);
    assertThat(xRefStack().getLeftsidedNodes()).hasSize(100);
    assertThat(xRefStack().getRightsidedNodes()).hasSize(119);
    
    //
    dumpNodes(xRefStack().getCenterNodes());
  }
}
