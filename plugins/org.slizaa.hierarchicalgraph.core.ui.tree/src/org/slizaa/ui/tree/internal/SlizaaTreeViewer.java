package org.slizaa.ui.tree.internal;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.widgets.Composite;
import org.slizaa.hierarchicalgraph.HGRootNode;
import org.slizaa.hierarchicalgraph.impl.ExtendedHGNodeImpl;
import org.slizaa.hierarchicalgraph.spi.INodeComparator;
import org.slizaa.ui.shared.NodeComparator2ViewerComparatorAdapter;
import org.slizaa.ui.shared.context.BusyCursor;
import org.slizaa.ui.tree.interceptors.ISlizaaTreeEventInterceptor;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaTreeViewer extends TreeViewer {

  /** - */
  private ISlizaaTreeEventInterceptor _eventInterceptor;

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaTreeViewer}.
   * </p>
   *
   * @param parent
   * @param style
   * @param eventInterceptor
   */
  public SlizaaTreeViewer(Composite parent, int style, ISlizaaTreeEventInterceptor eventInterceptor,
      int autoExpandLevel) {
    super(parent, style);

    //
    this._eventInterceptor = eventInterceptor;

    //
    setAutoExpandLevel(autoExpandLevel);
    setUseHashlookup(true);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void handleSelect(SelectionEvent event) {

    //
    if (event.item.getData() instanceof ExtendedHGNodeImpl) {

      BusyCursor.execute(getTree().getParent(), () -> {

        //
        if (this._eventInterceptor != null) {
          this._eventInterceptor.handleSelect((ExtendedHGNodeImpl) event.item.getData());
        }

        ExtendedHGNodeImpl hgNode = (ExtendedHGNodeImpl) event.item.getData();
        hgNode.onSelect();
      });
    }
    super.handleSelect(event);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void handleTreeExpand(TreeEvent event) {

    //
    if (event.item.getData() instanceof ExtendedHGNodeImpl) {

      BusyCursor.execute(getTree().getParent(), () -> {

        //
        if (this._eventInterceptor != null) {
          this._eventInterceptor.handleTreeExpand((ExtendedHGNodeImpl) event.item.getData());
        }

        ExtendedHGNodeImpl hgNode = (ExtendedHGNodeImpl) event.item.getData();
        hgNode.onExpand();
      });
    }
    super.handleTreeExpand(event);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void handleTreeCollapse(TreeEvent event) {

    //
    if (event.item.getData() instanceof ExtendedHGNodeImpl) {

      BusyCursor.execute(getTree().getParent(), () -> {

        //
        if (this._eventInterceptor != null) {
          this._eventInterceptor.handleTreeCollapse((ExtendedHGNodeImpl) event.item.getData());
        }

        //
        ExtendedHGNodeImpl hgNode = (ExtendedHGNodeImpl) event.item.getData();
        hgNode.onCollapse();
      });
    }
    super.handleTreeCollapse(event);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void inputChanged(Object input, Object oldInput) {

    System.out.println("inputChanged: " + input);

    //
    if (input instanceof HGRootNode) {

      HGRootNode newRootNode = (HGRootNode) input;

      if (newRootNode.hasExtension(INodeComparator.class)) {

        INodeComparator nodeComparator = newRootNode.getExtension(INodeComparator.class);

        this.setComparator(new NodeComparator2ViewerComparatorAdapter(nodeComparator));
      }
    }

    //
    super.inputChanged(input, oldInput);
  }
}
