package org.slizaa.hierarchicalgraph.core.testfwk.ui.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.swt.graphics.Image;
import org.slizaa.hierarchicalgraph.HGNode;
import org.slizaa.hierarchicalgraph.core.testfwk.HGNodeUtils;
import org.slizaa.hierarchicalgraph.spi.INodeLabelProvider;

/**
 * <p>
 * </p>
 *
 * @author Gerd W&uuml;therich (gerd@gerd-wuetherich.de)
 */
public class DefaultNodeLabelProvider implements INodeLabelProvider {

  private final Function<String, Image> _imageProvider;

  /**
   * <p>
   * Creates a new instance of type {@link DefaultNodeLabelProvider}.
   * </p>
   *
   * @param imageProvider
   */
  public DefaultNodeLabelProvider(Function<String, Image> imageProvider) {
    _imageProvider = checkNotNull(imageProvider);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getText(Object object) {
    return ((StyledString) getStyledText(object)).getString();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object getImage(Object object) {
    HGNode hgNode = (HGNode) object;

    //
    List<String> labels = HGNodeUtils.getLabels(hgNode);

    //
    String[][] mappings = { { "Artifact", "org/slizaa/testfwk/ui/internal/icons/jar_obj.png" },
        { "Package", "org/slizaa/testfwk/ui/internal//icons/package_obj.png" },
        { "Method", "org/slizaa/testfwk/ui/internal//icons/methdef_obj.png" },
        { "Field", "org/slizaa/testfwk/ui/internal//icons/field_default_obj.png" },
        { "Class", "org/slizaa/testfwk/ui/internal//icons/class_obj.png" },
        { "Annotation", "org/slizaa/testfwk/ui/internal//icons/annotation_obj.png" },
        { "Enum", "org/slizaa/testfwk/ui/internal//icons/enum_obj.png" },
        { "Interface", "org/slizaa/testfwk/ui/internal//icons/int_obj.png" },
        { "Directory", "org/slizaa/testfwk/ui/internal//icons/fldr_obj.png" },
        { "File", "org/slizaa/testfwk/ui/internal//icons/file_obj.png" } };

    //
    for (String[] mapping : mappings) {
      if (labels.contains(mapping[0])) {
        return _imageProvider.apply(mapping[1]);
      }
    }

    //
    return null;

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object getStyledText(Object object) {

    HGNode hgNode = (HGNode) object;

    //
    List<String> labels = HGNodeUtils.getLabels(hgNode);

    //
    String[][] mappings = { { "Artifact", "fileName" }, { "Package", "fqn" }, { "Method", "signature" },
        { "Field", "name" }, { "Class", "name" }, { "Annotation", "name" }, { "Enum", "name" }, { "Interface", "name" },
        { "Directory", "fileName" }, { "File", "fileName" } };

    //
    for (String[] mapping : mappings) {
      if (labels.contains(mapping[0])) {
        return new StyledString(
            HGNodeUtils.getProperties(hgNode).get((mapping[1])) + " (" + hgNode.getIdentifier() + ")");
      }
    }

    //
    return new StyledString(HGNodeUtils.getLabels((HGNode) object).toString());
  }

}
