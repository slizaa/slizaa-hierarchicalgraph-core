package org.slizaa.hierarchicalgraph.core.testfwk.example;

import org.junit.ClassRule;
import org.junit.Test;
import org.slizaa.hierarchicalgraph.core.testfwk.HGNodeUtils;
import org.slizaa.hierarchicalgraph.core.testfwk.XmiBasedGraph;
import org.slizaa.hierarchicalgraph.core.testfwk.XmiBasedTestGraphProviderRule;

public class TestGraphProviderExampleTest {

  @ClassRule
  public static XmiBasedTestGraphProviderRule gp = new XmiBasedTestGraphProviderRule(XmiBasedGraph.MAP_STRUCT);

  @Test
  public void testOutgoingCoreDependencies() {

    HGNodeUtils.dumpChildren(gp.rootNode());
  }
}
