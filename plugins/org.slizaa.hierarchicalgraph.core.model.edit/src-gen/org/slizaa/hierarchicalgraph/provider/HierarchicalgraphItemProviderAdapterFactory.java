/**
 */
package org.slizaa.hierarchicalgraph.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IItemStyledLabelProvider;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.slizaa.hierarchicalgraph.core.model.util.HierarchicalgraphAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class HierarchicalgraphItemProviderAdapterFactory extends HierarchicalgraphAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
  /**
   * This keeps track of the root adapter factory that delegates to this adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComposedAdapterFactory parentAdapterFactory;

  /**
   * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IChangeNotifier changeNotifier = new ChangeNotifier();

  /**
   * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Collection<Object> supportedTypes = new ArrayList<Object>();

  /**
   * This constructs an instance.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HierarchicalgraphItemProviderAdapterFactory() {
    supportedTypes.add(IEditingDomainItemProvider.class);
    supportedTypes.add(IStructuredItemContentProvider.class);
    supportedTypes.add(ITreeItemContentProvider.class);
    supportedTypes.add(IItemLabelProvider.class);
    supportedTypes.add(IItemPropertySource.class);
    supportedTypes.add(IItemStyledLabelProvider.class);
  }

  /**
   * This keeps track of the one adapter used for all {@link org.slizaa.hierarchicalgraph.HGNode} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HGNodeItemProvider hgNodeItemProvider;

  /**
   * This creates an adapter for a {@link org.slizaa.hierarchicalgraph.HGNode}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public Adapter createHGNodeAdapter() {
    if (hgNodeItemProvider == null) {
      hgNodeItemProvider = new ExtendedHGNodeItemProvider(this);
    }

    return hgNodeItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.slizaa.hierarchicalgraph.HGRootNode} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HGRootNodeItemProvider hgRootNodeItemProvider;

  /**
   * This creates an adapter for a {@link org.slizaa.hierarchicalgraph.HGRootNode}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createHGRootNodeAdapter() {
    if (hgRootNodeItemProvider == null) {
      hgRootNodeItemProvider = new HGRootNodeItemProvider(this);
    }

    return hgRootNodeItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.slizaa.hierarchicalgraph.DefaultNodeSource} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DefaultNodeSourceItemProvider defaultNodeSourceItemProvider;

  /**
   * This creates an adapter for a {@link org.slizaa.hierarchicalgraph.DefaultNodeSource}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createDefaultNodeSourceAdapter() {
    if (defaultNodeSourceItemProvider == null) {
      defaultNodeSourceItemProvider = new DefaultNodeSourceItemProvider(this);
    }

    return defaultNodeSourceItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.slizaa.hierarchicalgraph.DefaultDependencySource} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DefaultDependencySourceItemProvider defaultDependencySourceItemProvider;

  /**
   * This creates an adapter for a {@link org.slizaa.hierarchicalgraph.DefaultDependencySource}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createDefaultDependencySourceAdapter() {
    if (defaultDependencySourceItemProvider == null) {
      defaultDependencySourceItemProvider = new DefaultDependencySourceItemProvider(this);
    }

    return defaultDependencySourceItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.slizaa.hierarchicalgraph.HGAggregatedDependency} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HGAggregatedDependencyItemProvider hgAggregatedDependencyItemProvider;

  /**
   * This creates an adapter for a {@link org.slizaa.hierarchicalgraph.HGAggregatedDependency}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createHGAggregatedDependencyAdapter() {
    if (hgAggregatedDependencyItemProvider == null) {
      hgAggregatedDependencyItemProvider = new HGAggregatedDependencyItemProvider(this);
    }

    return hgAggregatedDependencyItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.slizaa.hierarchicalgraph.HGCoreDependency} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HGCoreDependencyItemProvider hgCoreDependencyItemProvider;

  /**
   * This creates an adapter for a {@link org.slizaa.hierarchicalgraph.HGCoreDependency}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createHGCoreDependencyAdapter() {
    if (hgCoreDependencyItemProvider == null) {
      hgCoreDependencyItemProvider = new HGCoreDependencyItemProvider(this);
    }

    return hgCoreDependencyItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.slizaa.hierarchicalgraph.HGProxyDependency} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HGProxyDependencyItemProvider hgProxyDependencyItemProvider;

  /**
   * This creates an adapter for a {@link org.slizaa.hierarchicalgraph.HGProxyDependency}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createHGProxyDependencyAdapter() {
    if (hgProxyDependencyItemProvider == null) {
      hgProxyDependencyItemProvider = new HGProxyDependencyItemProvider(this);
    }

    return hgProxyDependencyItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NodeToCoreDependencyMapItemProvider nodeToCoreDependencyMapItemProvider;

  /**
   * This creates an adapter for a {@link java.util.Map.Entry}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createNodeToCoreDependencyMapAdapter() {
    if (nodeToCoreDependencyMapItemProvider == null) {
      nodeToCoreDependencyMapItemProvider = new NodeToCoreDependencyMapItemProvider(this);
    }

    return nodeToCoreDependencyMapItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NodeToCoreDependenciesMapItemProvider nodeToCoreDependenciesMapItemProvider;

  /**
   * This creates an adapter for a {@link java.util.Map.Entry}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createNodeToCoreDependenciesMapAdapter() {
    if (nodeToCoreDependenciesMapItemProvider == null) {
      nodeToCoreDependenciesMapItemProvider = new NodeToCoreDependenciesMapItemProvider(this);
    }

    return nodeToCoreDependenciesMapItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StringToObjectMapItemProvider stringToObjectMapItemProvider;

  /**
   * This creates an adapter for a {@link java.util.Map.Entry}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createStringToObjectMapAdapter() {
    if (stringToObjectMapItemProvider == null) {
      stringToObjectMapItemProvider = new StringToObjectMapItemProvider(this);
    }

    return stringToObjectMapItemProvider;
  }

  /**
   * This returns the root adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComposeableAdapterFactory getRootAdapterFactory() {
    return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
  }

  /**
   * This sets the composed adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
    this.parentAdapterFactory = parentAdapterFactory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object type) {
    return supportedTypes.contains(type) || super.isFactoryForType(type);
  }

  /**
   * This implementation substitutes the factory itself as the key for the adapter.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter adapt(Notifier notifier, Object type) {
    return super.adapt(notifier, this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object adapt(Object object, Object type) {
    if (isFactoryForType(type)) {
      Object adapter = super.adapt(object, type);
      if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
        return adapter;
      }
    }

    return null;
  }

  /**
   * This adds a listener.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void addListener(INotifyChangedListener notifyChangedListener) {
    changeNotifier.addListener(notifyChangedListener);
  }

  /**
   * This removes a listener.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void removeListener(INotifyChangedListener notifyChangedListener) {
    changeNotifier.removeListener(notifyChangedListener);
  }

  /**
   * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void fireNotifyChanged(Notification notification) {
    changeNotifier.fireNotifyChanged(notification);

    if (parentAdapterFactory != null) {
      parentAdapterFactory.fireNotifyChanged(notification);
    }
  }

  /**
   * This disposes all of the item providers created by this factory. 
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void dispose() {
    if (hgNodeItemProvider != null) hgNodeItemProvider.dispose();
    if (hgRootNodeItemProvider != null) hgRootNodeItemProvider.dispose();
    if (defaultNodeSourceItemProvider != null) defaultNodeSourceItemProvider.dispose();
    if (defaultDependencySourceItemProvider != null) defaultDependencySourceItemProvider.dispose();
    if (hgAggregatedDependencyItemProvider != null) hgAggregatedDependencyItemProvider.dispose();
    if (hgCoreDependencyItemProvider != null) hgCoreDependencyItemProvider.dispose();
    if (hgProxyDependencyItemProvider != null) hgProxyDependencyItemProvider.dispose();
    if (nodeToCoreDependencyMapItemProvider != null) nodeToCoreDependencyMapItemProvider.dispose();
    if (nodeToCoreDependenciesMapItemProvider != null) nodeToCoreDependenciesMapItemProvider.dispose();
    if (stringToObjectMapItemProvider != null) stringToObjectMapItemProvider.dispose();
  }

}
