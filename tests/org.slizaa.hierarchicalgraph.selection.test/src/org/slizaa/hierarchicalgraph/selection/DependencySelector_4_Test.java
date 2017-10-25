package org.slizaa.hierarchicalgraph.selection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.slizaa.hierarchicalgraph.selection.fwk.DependencySelectorProbeRule;
import org.slizaa.testfwk.TestGraph;
import org.slizaa.testfwk.TestGraphProviderRule;

public class DependencySelector_4_Test  {

  public static TestGraphProviderRule       _graphProvider = new TestGraphProviderRule(TestGraph.MAP_STRUCT);

  public static DependencySelectorProbeRule _probe         = new DependencySelectorProbeRule(_graphProvider);

  @ClassRule
  public static RuleChain                   _chain         = RuleChain.outerRule(_graphProvider).around(_probe);
  
  @Test
  public void testWithTargetSelection() {

    //
    assertThat(_probe.dependencySelector().getUnfilteredCoreDependencies()).hasSize(50);
    assertThat(_probe.dependencySelector().getUnfilteredSourceNodes()).hasSize(22);
    assertThat(_probe.dependencySelector().getUnfilteredTargetNodes()).hasSize(6);
    
    //
    _probe.dependencySelector().setSelectedTargetNodes(_graphProvider.node(1383));

    //
    assertThat(_probe.dependencySelector().getFilteredCoreDependencies()).hasSize(7);
    assertThat(_probe.dependencySelector().getFilteredSourceNodes()).hasSize(7);
    assertThat(_probe.dependencySelector().getFilteredTargetNodes()).hasSize(6);
    
    //
    _probe.dependencySelector().unselectNodes();
    
    //
    assertThat(_probe.dependencySelector().getUnfilteredCoreDependencies()).hasSize(50);
    assertThat(_probe.dependencySelector().getUnfilteredSourceNodes()).hasSize(22);
    assertThat(_probe.dependencySelector().getUnfilteredTargetNodes()).hasSize(6);
  }
}
