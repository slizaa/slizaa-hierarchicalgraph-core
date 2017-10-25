package org.slizaa.ui.dependencytable;

import static org.slizaa.hierarchicalgraph.selection.SelectionFactoryMethods.createDependencySelection;

import java.util.Collection;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.junit.Test;
import org.slizaa.hierarchicalgraph.HGCoreDependency;
import org.slizaa.testfwk.ui.AbstractSlizaaPartTest;
import org.slizaa.workbench.model.ModelFactory;
import org.slizaa.workbench.model.SlizaaWorkbenchModel;

public class DependencyTableTest extends AbstractSlizaaPartTest {

  /** - */
  private DependencyTablePart  _part;

  /** - */
  private SlizaaWorkbenchModel _workbenchModel;

  /**
   * {@inheritDoc}
   */
  @Override
  public void beforeShellOpens(Shell shell) {
    
    super.beforeShellOpens(shell);

    //
    _workbenchModel = ModelFactory.eINSTANCE.createSlizaaWorkbenchModel();

    // create the xref part
    _part = new DependencyTablePart();
    _part.initializeAbstractSlizaaPart(_workbenchModel);
    _part.createComposite(shell);
  }

  /**
   * <p>
   * </p>
   */
  @Test
  public void test() {

    //
    SWTBotTable tableBot = swtbot().table();

    //
    Collection<HGCoreDependency> dependencies = graphProvider().node(28232)
        .getOutgoingDependenciesTo(graphProvider().node(267432)).getCoreDependencies();

    //
    _part.handleDetailDependencySelectionChanged(null, createDependencySelection(dependencies));

    //
    swtbot().waitUntil(Conditions.tableHasRows(tableBot, dependencies.size()));

    // TODO: sort/filter/etc.
    // assert (tableBot.getTableItem(0).getText(0))
    // .equals("com.amazonaws.services.ec2.model.transform.DhcpConfigurationStaxUnmarshaller");

    // displaySleep();
  }
}