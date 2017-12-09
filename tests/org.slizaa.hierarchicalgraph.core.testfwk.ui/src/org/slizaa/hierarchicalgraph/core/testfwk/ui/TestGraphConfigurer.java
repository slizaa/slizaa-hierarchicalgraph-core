package org.slizaa.hierarchicalgraph.core.testfwk.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.function.Function;

import org.eclipse.swt.graphics.Image;
import org.slizaa.hierarchicalgraph.HGRootNode;
import org.slizaa.hierarchicalgraph.core.testfwk.ui.internal.DefaultNodeLabelProvider;
import org.slizaa.hierarchicalgraph.spi.INodeLabelProvider;

public class TestGraphConfigurer {

  public static final void registerNodeLabelProvider(HGRootNode rootNode, Function<String, Image> imageProvider) {
    checkNotNull(rootNode).registerExtension(INodeLabelProvider.class,
        new DefaultNodeLabelProvider(checkNotNull(imageProvider)));

  }
}
