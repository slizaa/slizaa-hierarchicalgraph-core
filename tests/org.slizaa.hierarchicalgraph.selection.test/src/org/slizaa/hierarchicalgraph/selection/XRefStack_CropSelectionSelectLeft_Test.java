package org.slizaa.hierarchicalgraph.selection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;

import org.junit.ClassRule;
import org.junit.Test;
import org.slizaa.hierarchicalgraph.selection.fwk.XRefStackProbeRule;
import org.slizaa.testfwk.XmiBasedGraph;
import org.slizaa.testfwk.XmiBasedTestGraphProviderRule;

public class XRefStack_CropSelectionSelectLeft_Test {

  @ClassRule
  public static XmiBasedTestGraphProviderRule _graphProvider = new XmiBasedTestGraphProviderRule(XmiBasedGraph.EUREKA_AGGREGATED);

  @ClassRule
  public static XRefStackProbeRule    _probe         = new XRefStackProbeRule();

  @Test
  public void test() {

    //
    _probe.xRefStack().pruneDependenciesForUncroppedCenterNodes(Collections.singletonList(_graphProvider.rootNode()),
        _graphProvider.rootNode().getAccumulatedIncomingCoreDependencies(), _graphProvider.rootNode().getAccumulatedOutgoingCoreDependencies());
    
    // select "/WEB-INF/lib/archaius-core-0.7.3.jar (54411)"
    _probe.xRefStack().setSelectedCenterNodes(_graphProvider.node(54411));
    _probe.xRefStack().cropSelection();

    _probe.xRefStack().setSelectedLeftsidedNodes(_graphProvider.node(54411));

    //
    assertThat(_probe.xRefStack().getCenterNodes()).hasSize(100);
    assertThat(_probe.xRefStack().getBackreferencedCenterNodes()).hasSize(89);
    assertThat(_probe.xRefStack().getLeftsidedNodes()).hasSize(100);
    assertThat(_probe.xRefStack().getRightsidedNodes()).hasSize(119);
  }
}
