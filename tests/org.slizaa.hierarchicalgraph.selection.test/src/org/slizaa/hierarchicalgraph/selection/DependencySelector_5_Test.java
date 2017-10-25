package org.slizaa.hierarchicalgraph.selection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.slizaa.hierarchicalgraph.selection.fwk.DependencySelectorProbeRule;
import org.slizaa.hierarchicalgraph.selection.selector.IDependencySelectorListener;
import org.slizaa.hierarchicalgraph.selection.selector.SelectedNodesChangedEvent;
import org.slizaa.testfwk.TestGraph;
import org.slizaa.testfwk.TestGraphProviderRule;

public class DependencySelector_5_Test {

  public static TestGraphProviderRule       _graphProvider = new TestGraphProviderRule(TestGraph.MAP_STRUCT);

  public static DependencySelectorProbeRule _probe         = new DependencySelectorProbeRule(_graphProvider);

  @ClassRule
  public static RuleChain                   _chain         = RuleChain.outerRule(_graphProvider).around(_probe);

  @Rule
  public MockitoRule                        rule           = MockitoJUnit.rule();

  @Mock
  private IDependencySelectorListener       _listener;

  @Test
  public void testWithTargetSelection() {

    //
    _probe.dependencySelector().addDependencySelectorListener(_listener);

    //
    assertThat(_probe.dependencySelector().getUnfilteredCoreDependencies()).hasSize(50);
    assertThat(_probe.dependencySelector().getUnfilteredSourceNodes()).hasSize(22);
    assertThat(_probe.dependencySelector().getUnfilteredTargetNodes()).hasSize(6);

    //
    _probe.dependencySelector().setSelectedTargetNodes(_graphProvider.node(1383));

    //
    verify(_listener).selectedNodesChanged(any(SelectedNodesChangedEvent.class));

    //
    assertThat(_probe.dependencySelector().getFilteredCoreDependencies()).hasSize(7);
    assertThat(_probe.dependencySelector().getFilteredSourceNodes()).hasSize(7);
    assertThat(_probe.dependencySelector().getFilteredTargetNodes()).hasSize(6);

    //
    _probe.dependencySelector().unselectNodes();

    //
    verify(_listener, times(2)).selectedNodesChanged(any(SelectedNodesChangedEvent.class));

    //
    assertThat(_probe.dependencySelector().getUnfilteredCoreDependencies()).hasSize(50);
    assertThat(_probe.dependencySelector().getUnfilteredSourceNodes()).hasSize(22);
    assertThat(_probe.dependencySelector().getUnfilteredTargetNodes()).hasSize(6);
  }

}
