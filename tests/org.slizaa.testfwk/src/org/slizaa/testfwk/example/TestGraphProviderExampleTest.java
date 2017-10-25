package org.slizaa.testfwk.example;

import org.junit.ClassRule;
import org.junit.Test;
import org.slizaa.testfwk.HGNodeUtils;
import org.slizaa.testfwk.TestGraph;
import org.slizaa.testfwk.TestGraphProviderRule;

public class TestGraphProviderExampleTest {

  @ClassRule
  public static TestGraphProviderRule gp = new TestGraphProviderRule(TestGraph.MAP_STRUCT);

  @Test
  public void testOutgoingCoreDependencies() {

    HGNodeUtils.dumpChildren(gp.rootNode());
  }
}
