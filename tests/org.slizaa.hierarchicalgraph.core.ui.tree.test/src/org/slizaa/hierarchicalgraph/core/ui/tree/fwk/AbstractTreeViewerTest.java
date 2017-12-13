package org.slizaa.hierarchicalgraph.core.ui.tree.fwk;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slizaa.hierarchicalgraph.core.testfwk.ui.AbstractXmiBasedTestGraphUiTest;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public abstract class AbstractTreeViewerTest extends AbstractXmiBasedTestGraphUiTest {

  /** - */
  private static DummySlizaaTreeViewerPart _part;

  /** - */
  private SWTBotTree                           _tree;

  /**
   * <p>
   * </p>
   */
  @BeforeClass
  public static void createPart() {
    _part = openShell(new DummySlizaaTreeViewerPart());
  }

  /**
   * <p>
   * </p>
   *
   */
  @Before
  public void setup() {

    // create the SWTBotTrees
    _tree = swtbot().tree();
  }

  /**
   * <p>
   * </p>
   */
  public SWTBotTree tree() {
    return _tree;
  }

  /**
   * <p>
   * </p>
   */
  public DummySlizaaTreeViewerPart part() {
    return _part;
  }
}