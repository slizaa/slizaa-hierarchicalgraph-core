package org.slizaa.hierarchicalgraph.selection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.slizaa.hierarchicalgraph.selection.fwk.DependencySelectorProbeRule;
import org.slizaa.testfwk.TestGraph;
import org.slizaa.testfwk.TestGraphProviderRule;

public class DependencySelector_2_Test {

  public static TestGraphProviderRule       _graphProvider = new TestGraphProviderRule(TestGraph.MAP_STRUCT);

  public static DependencySelectorProbeRule _probe         = new DependencySelectorProbeRule(_graphProvider);

  @ClassRule
  public static RuleChain                   _chain         = RuleChain.outerRule(_graphProvider).around(_probe);

  @Test
  public void testWithSourceSelection() {

    //
    assertThat(_probe.dependencySelector().getUnfilteredCoreDependencies()).hasSize(50);
    assertThat(_probe.dependencySelector().getUnfilteredSourceNodes()).hasSize(22);
    assertThat(_probe.dependencySelector().getUnfilteredTargetNodes()).hasSize(6);

    //
    _probe.dependencySelector().setSelectedSourceNodes(_graphProvider.node(2280));

    //
    assertThat(_probe.dependencySelector().getFilteredCoreDependencies()).hasSize(4);
    assertThat(_probe.dependencySelector().getFilteredSourceNodes()).hasSize(22);
    assertThat(_probe.dependencySelector().getFilteredTargetNodes()).hasSize(4);
  }
}
