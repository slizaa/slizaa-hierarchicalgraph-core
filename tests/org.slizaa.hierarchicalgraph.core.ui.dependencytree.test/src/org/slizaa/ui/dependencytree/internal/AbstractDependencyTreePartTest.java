package org.slizaa.ui.dependencytree.internal;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.slizaa.hierarchicalgraph.core.testfwk.ui.AbstractXmiBasedTestGraphUiTest;
import org.slizaa.hierarchicalgraph.core.ui.dependencytree.internal.DependencyTreeComposite;
import org.slizaa.hierarchicalgraph.core.ui.dependencytree.internal.DependencyTreePart;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
@Ignore
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
    _part = new DependencyTreePart();
    // TODO
    // _part.createComposite(shell(), injector);
  }

  /**
   * <p>
   * </p>
   *
   */
  @Before
  public void setup() {

    // create the SWTBotTrees
    this._fromTree = swtbot().treeWithId("slizaa-id", DependencyTreeComposite.SLIZAA_ID_DEPENDENCY_TREE_FROM_TREE);
    this._toTree = swtbot().treeWithId("slizaa-id", DependencyTreeComposite.SLIZAA_ID_DEPENDENCY_TREE_TO_TREE);
  }

  /**
   * <p>
   * </p>
   */
  public SWTBotTree fromTree() {
    return this._fromTree;
  }

  /**
   * <p>
   * </p>
   */
  public SWTBotTree toTree() {
    return this._toTree;
  }

  /**
   * <p>
   * </p>
   */
  public DependencyTreePart part() {
    return _part;
  }
}