package org.slizaa.hierarchicalgraph.core.testfwk.ui.rules;

import java.util.function.Consumer;

import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.junit.rules.ExternalResource;
import org.slizaa.hierarchicalgraph.provider.HierarchicalgraphItemProviderAdapterFactory;
import org.slizaa.ui.tree.SlizaaTreeViewerFactory;

public class SlizaaTreeViewerFactoryRule extends ExternalResource {

  /** - */
  private IEclipseContext                   _eclipseContext;

  /** - */
  private DefaultActionContributionProvider _defaultActionContributionProvider;

  /** - */
  private Consumer<ComposedAdapterFactory>  _composedAdapterFactoryConfigurer;

  /**
   * <p>
   * Creates a new instance of type {@link SlizaaTreeViewerFactoryRule}.
   * </p>
   */
  public SlizaaTreeViewerFactoryRule() {
    super();
  }

  public SlizaaTreeViewerFactoryRule(Consumer<ComposedAdapterFactory> composedAdapterFactoryConfigurer) {
    super();
    _composedAdapterFactoryConfigurer = composedAdapterFactoryConfigurer;
  }

  @Override
  protected void before() throws Throwable {

    //
    _eclipseContext = EclipseContextFactory.create();
    _defaultActionContributionProvider = new DefaultActionContributionProvider();

    // manual add the adapter factory
    ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory();
    composedAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
    composedAdapterFactory.addAdapterFactory(new HierarchicalgraphItemProviderAdapterFactory());

    //
    if (_composedAdapterFactoryConfigurer != null) {
      _composedAdapterFactoryConfigurer.accept(composedAdapterFactory);
    }

    //
    SlizaaTreeViewerFactory.setSlizaaTreeViewerCreator(_defaultActionContributionProvider, composedAdapterFactory,
        () -> eclipseContext());
  }

  @Override
  protected void after() {
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public final IEclipseContext eclipseContext() {
    return _eclipseContext;
  }

  /**
   * <p>
   * </p>
   *
   * @return
   */
  public final DefaultActionContributionProvider defaultActionContributionProvider() {
    return _defaultActionContributionProvider;
  }
}
