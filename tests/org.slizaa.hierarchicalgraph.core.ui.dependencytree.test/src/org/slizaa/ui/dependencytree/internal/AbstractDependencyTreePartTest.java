package org.slizaa.ui.dependencytree.internal;

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
public abstract class AbstractDependencyTreePartTest extends AbstractXmiBasedTestGraphUiTest {

  /** - */
  private static DependencyTreePart _part;

  /** - */
  private SWTBotTree                _fromTree;

  /** - */
  private SWTBotTree                _toTree;

  /**
   * <p>
   * </p>
   */
  @BeforeClass
  public static void createPart() {
    _part = openShell(new DependencyTreePart());
  }

  /**
   * <p>
   * </p>
   *
   */
  @Before
  public void setup() {

    // create the SWTBotTrees
    _fromTree = swtbot().treeWithId("slizaa-id", DependencyTreeComposite.SLIZAA_ID_DEPENDENCY_TREE_FROM_TREE);
    _toTree = swtbot().treeWithId("slizaa-id", DependencyTreeComposite.SLIZAA_ID_DEPENDENCY_TREE_TO_TREE);
  }

  /**
   * <p>
   * </p>
   */
  public SWTBotTree fromTree() {
    return _fromTree;
  }

  /**
   * <p>
   * </p>
   */
  public SWTBotTree toTree() {
    return _toTree;
  }

  /**
   * <p>
   * </p>
   */
  public DependencyTreePart part() {
    return _part;
  }
}