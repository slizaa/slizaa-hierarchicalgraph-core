package org.slizaa.ui.tree;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.slizaa.ui.tree.interceptors.ISlizaaLabelProviderInterceptor;
import org.slizaa.ui.tree.interceptors.ISlizaaTreeEventInterceptor;
import org.slizaa.ui.tree.internal.IInterceptableLabelProvider;
import org.slizaa.ui.tree.internal.SlizaaTreeViewer;
import org.slizaa.ui.tree.internal.SlizaaTreeViewerCreator;
import org.slizaa.ui.tree.internal.osgi.Activator;

import com.google.common.base.Supplier;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class SlizaaTreeViewerFactory {

  /** - */
  private static SlizaaTreeViewerCreator _creator;

  /**
   * <p>
   * </p>
   *
   * @param parent
   * @return
   */
  public static ISlizaaTreeViewerBuilder newSlizaaTreeViewer(Composite parent) {
    return new DefaultSlizaaTreeViewerBuilder(checkNotNull(parent));
  }

  /**
   * <p>
   * </p>
   *
   * @param composedAdapterFactory
   */
  public static void setSlizaaTreeViewerCreator(ISlizaaActionContributionProvider slizaaActionContributionProvider,
      ComposedAdapterFactory adapterFactory, Supplier<IEclipseContext> contextSupplier) {

    // checkState(_creator == null);

    //
    _creator = new SlizaaTreeViewerCreator(checkNotNull(slizaaActionContributionProvider), checkNotNull(adapterFactory),
        checkNotNull(contextSupplier));
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  private static SlizaaTreeViewerCreator slizaaTreeViewerCreator() {

    //
    if (_creator == null) {

      // create the default OSGi based creator
      _creator = new SlizaaTreeViewerCreator(Activator.getDefault().getSlizaaActionContributionProvider(),
          Activator.getDefault().getComposedAdapterFactory(), () -> Activator.getDefault().getEclipseContext());
    }

    //
    return _creator;
  }

  /**
   * <p>
   * </p>
   *
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   */
  private static class DefaultSlizaaTreeViewerBuilder implements ISlizaaTreeViewerBuilder {

    /** - */
    private Composite                       _parent;

    /** - */
    private int                             _style;

    /** - */
    private int                             _autoExpandLevel;

    /** - */
    private ISlizaaTreeEventInterceptor     _treeEventInterceptor;

    /** - */
    private ISlizaaLabelProviderInterceptor _labelProviderInterceptor;

    /**
     * <p>
     * Creates a new instance of type {@link DefaultSlizaaTreeViewerBuilder}.
     * </p>
     *
     * @param parent
     */
    public DefaultSlizaaTreeViewerBuilder(Composite parent) {
      _parent = checkNotNull(parent);
      _style = SWT.NO_BACKGROUND | SWT.NONE | SWT.MULTI;
      _autoExpandLevel = 3;
    }

    /**
     * <p>
     * </p>
     *
     * @param style
     * @return
     */
    @Override
    public ISlizaaTreeViewerBuilder withStyle(int style) {
      _style = style;
      return this;
    }

    @Override
    public ISlizaaTreeViewerBuilder withAutoExpandLevel(int autoExpandLevel) {
      _autoExpandLevel = autoExpandLevel;
      return this;
    }

    @Override
    public ISlizaaTreeViewerBuilder withTreeEventInterceptor(ISlizaaTreeEventInterceptor treeEventInterceptor) {
      _treeEventInterceptor = treeEventInterceptor;
      return this;
    }

    @Override
    public ISlizaaTreeViewerBuilder withLabelProviderInterceptor(
        ISlizaaLabelProviderInterceptor labelProviderInterceptor) {
      _labelProviderInterceptor = labelProviderInterceptor;
      return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TreeViewer create() {

      //
      SlizaaTreeViewer result = slizaaTreeViewerCreator().createTreeViewer(_parent, _style, _autoExpandLevel,
          _treeEventInterceptor);

      //
      if (_labelProviderInterceptor != null) {
        ((IInterceptableLabelProvider) result.getLabelProvider())
            .setLabelProviderInterceptor(_labelProviderInterceptor);
      }

      //
      return result;
    }
  }

}
