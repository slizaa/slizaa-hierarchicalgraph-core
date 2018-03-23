package org.slizaa.hierarchicalgraph.spi;

import org.slizaa.hierarchicalgraph.HGProxyDependency;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public interface IProxyDependencyResolver {

  /**
   * <p>
   * </p>
   *
   * @param dependencyToResolve
   */
  IProxyDependencyResolverResult resolveProxyDependency(HGProxyDependency dependencyToResolve);

  /**
   * <p>
   * </p>
   *
   * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
   *
   */
  public static interface IProxyDependencyResolverResult {

    /**
     * <p>
     * </p>
     *
     */
    void waitForCompletion();
  }
}
