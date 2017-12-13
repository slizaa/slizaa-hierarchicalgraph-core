package org.slizaa.hierarchicalgraph.core.ui.tree;

import org.junit.Test;
import org.slizaa.hierarchicalgraph.HGRootNode;
import org.slizaa.hierarchicalgraph.core.ui.tree.fwk.AbstractTreeViewerTest;
import org.slizaa.hierarchicalgraph.spi.INodeComparator;

/**
 * <p>
 * </p>
 */
public class TreeViewerTest extends AbstractTreeViewerTest {

  /**
   * <p>
   * </p>
   * 
   * @throws InterruptedException
   */
  @Test
  public void test() throws InterruptedException {

    // get the root nodes
    HGRootNode rootNode = testGraph().rootNode();

    // configure node comparator
    rootNode.registerExtension(INodeComparator.class, new DummyNodeComparator());

    // TODO!!
    
    // we have to set the node
    part().handleRootNodeChanged(null, testGraph().rootNode());

    //
    // displaySleep();

    // TODO: tests
  }
}