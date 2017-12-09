package org.slizaa.ui.xref.internal;

import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Test;
import org.slizaa.hierarchicalgraph.HGAggregatedDependency;
import org.slizaa.hierarchicalgraph.HGNode;

/**
 * <p>
 * </p>
 */
public class XRefPart_SingleCenterSelect_Test extends AbstractXRefPartTest {

  /**
   * <p>
   * </p>
   * 
   * @throws InterruptedException
   */
  @Test
  public void test() throws InterruptedException {

    //
    for (int i = 0; i < modules().size(); i++) {

      //
      HGNode centerModule = (HGNode) modules().get(i);

      //
      System.out.println("Before select centered node...");
      
      //
      centerTree().select(centerRootItem().getNode(getLabel(centerModule)));
      
      //
      System.out.println("Center node selected.");

      //
      for (HGAggregatedDependency dependency : centerModule.getIncomingDependenciesFrom(modules())) {
        
        
        
        
        String fromLabel = getLabel(dependency.getFrom());
        
        System.out.printf("Try to find 'from' node '%s.'\n", fromLabel);
        
        for (SWTBotTreeItem item : fromRootItem().getItems()) {
          System.out.println("ITEM: '" + item.getText() + "'.");
        }
        
        swtbot().waitUntil(Conditions.treeItemHasNode(fromRootItem(), getLabel(dependency.getFrom())));
        System.out.printf("Found 'from' node '%s.'\n", fromLabel);
      }

      //
      for (HGAggregatedDependency dependency : centerModule.getOutgoingDependenciesTo(modules())) {
        
        String toLabel = getLabel(dependency.getFrom());
        
        System.out.printf("Try to find 'to' node '%s.' \n", toLabel);
        swtbot().waitUntil(Conditions.treeItemHasNode(toRootItem(), getLabel(dependency.getTo())));
        System.out.printf("Found 'to' node '%s.'\n", toLabel);
      }
    }
  }
}