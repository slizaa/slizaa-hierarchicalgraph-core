package org.slizaa.ui.tree;

import org.eclipse.jface.viewers.TreeViewer;
import org.slizaa.ui.tree.interceptors.ISlizaaTreeEventInterceptor;

public interface ISlizaaTreeViewerBuilder {

  ISlizaaTreeViewerBuilder withTreeEventInterceptor(ISlizaaTreeEventInterceptor treeEventInterceptor);

  ISlizaaTreeViewerBuilder withStyle(int style);

  ISlizaaTreeViewerBuilder withAutoExpandLevel(int autoExpandLevel);
  
  TreeViewer create();
}
