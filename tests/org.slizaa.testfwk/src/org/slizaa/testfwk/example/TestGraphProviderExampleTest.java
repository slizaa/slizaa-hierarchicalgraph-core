package org.slizaa.testfwk.example;

import org.junit.ClassRule;
import org.junit.Test;
import org.slizaa.testfwk.HGNodeUtils;
import org.slizaa.testfwk.XmiBasedGraph;
import org.slizaa.testfwk.XmiBasedTestGraphProviderRule;

public class TestGraphProviderExampleTest {

  @ClassRule
  public static XmiBasedTestGraphProviderRule gp = new XmiBasedTestGraphProviderRule(XmiBasedGraph.MAP_STRUCT);

  @Test
  public void testOutgoingCoreDependencies() {

    HGNodeUtils.dumpChildren(gp.rootNode());
  }
}
