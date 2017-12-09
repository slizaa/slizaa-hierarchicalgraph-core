package org.slizaa.testfwk.ui.example;

import java.io.Serializable;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.slizaa.testfwk.XmiBasedGraph;
import org.slizaa.testfwk.XmiBasedTestGraphProviderRule;
import org.slizaa.testfwk.ui.TestGraphConfigurer;
import org.slizaa.testfwk.ui.rules.ImageRegistryRule;
import org.slizaa.testfwk.ui.rules.SlizaaTreeViewerFactoryRule;
import org.slizaa.testfwk.ui.rules.SwtBotRule;

@RunWith(SWTBotJunit4ClassRunner.class)
public class ExampleTest {

  /** - */
  @ClassRule
  public static SwtBotRule                    swtBotRule            = new SwtBotRule();

  @ClassRule
  public static ImageRegistryRule             imageRegistryRule     = new ImageRegistryRule(() -> swtBotRule.display());

  @ClassRule
  public static SlizaaTreeViewerFactoryRule   treeViewerFactoryRule = new SlizaaTreeViewerFactoryRule();

  @Rule
  public MockitoRule                          rule                  = MockitoJUnit.rule();

  @ClassRule
  public static XmiBasedTestGraphProviderRule testGraphProviderRule = new XmiBasedTestGraphProviderRule(
      XmiBasedGraph.EUREKA,
      rootNode -> TestGraphConfigurer.registerNodeLabelProvider(rootNode, path -> imageRegistryRule.getImage(path)));

  @Mock
  private Serializable                        testMock;

  @Test
  public void test() {

    //
    System.out.println(swtBotRule.swtbot());

    //
    Image image = imageRegistryRule.getImage("org/slizaa/testfwk/ui/internal/icons/enum_obj.png");
    System.out.println(image);

    //
    System.out.println(testMock);
  }
}
