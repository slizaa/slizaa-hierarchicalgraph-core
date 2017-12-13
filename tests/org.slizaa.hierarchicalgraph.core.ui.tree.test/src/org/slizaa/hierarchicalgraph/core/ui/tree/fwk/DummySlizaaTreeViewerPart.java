package org.slizaa.hierarchicalgraph.core.ui.tree.fwk;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.slizaa.hierarchicalgraph.HGRootNode;
import org.slizaa.ui.shared.AbstractSlizaaWorkbenchModelComponent;
import org.slizaa.ui.tree.SlizaaTreeViewerFactory;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DummySlizaaTreeViewerPart extends AbstractSlizaaWorkbenchModelComponent {

  /** - */
  private TreeViewer _slizaaTreeViewer;
  
  /**
   * <p>
   * </p>
   *
   * @return
   */
  public TreeViewer getTreeViewer() {
    return _slizaaTreeViewer;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void createComposite(Composite parent) {

    //
    GridLayoutFactory.fillDefaults().applyTo(parent);

    _slizaaTreeViewer = SlizaaTreeViewerFactory.createTreeViewer(parent, SWT.NONE, 1, null);

    //
    GridDataFactory.fillDefaults().grab(true, true).applyTo(_slizaaTreeViewer.getControl());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void handleRootNodeChanged(HGRootNode oldValue, HGRootNode newValue) {
    _slizaaTreeViewer.setInput(newValue);
  }
}
