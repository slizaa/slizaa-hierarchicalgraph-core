package org.slizaa.testfwk.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.slizaa.testfwk.ui.rules.ImageRegistryRule;
import org.slizaa.testfwk.ui.rules.SlizaaTreeViewerFactoryRule;
import org.slizaa.testfwk.ui.rules.SlizaaWorkbenchModelRule;
import org.slizaa.testfwk.ui.rules.SwtBotRule;
import org.slizaa.ui.shared.AbstractSlizaaWorkbenchModelComponent;
import org.slizaa.workbench.model.SlizaaWorkbenchModel;

@RunWith(SWTBotJunit4ClassRunner.class)
public class AbstractSlizaaUiTest {

  /** - */
  @ClassRule
  public static SwtBotRule                  swtBotRule            = new SwtBotRule();

  @ClassRule
  public static ImageRegistryRule           imageRegistryRule     = new ImageRegistryRule(() -> swtBotRule.display());

  @ClassRule
  public static SlizaaTreeViewerFactoryRule treeViewerFactoryRule = new SlizaaTreeViewerFactoryRule();

  @ClassRule
  public static SlizaaWorkbenchModelRule    workbenchModelRule    = new SlizaaWorkbenchModelRule();

  @Rule
  public MockitoRule                        rule                  = MockitoJUnit.rule();

  /**
   * <p>
   * </p>
   */
  public static <T extends AbstractSlizaaWorkbenchModelComponent> T openShell(T component) {

    //
    checkNotNull(component).initializeAbstractSlizaaPart(workbenchModelRule.getWorkbenchModel());
    component.createComposite(shell());
    swtBotRule.openShell();
    return component;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public final SWTBot swtbot() {
    return swtBotRule.swtbot();
  }

  /**
   * <p>
   * </p>
   *
   */
  public final void displaySleep() {
    swtBotRule.displaySleep();
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public static Shell shell() {
    return swtBotRule.shell();
  }

  public Display display() {
    return swtBotRule.display();
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public SlizaaWorkbenchModel workbenchModel() {
    return workbenchModelRule.getWorkbenchModel();
  }
}
