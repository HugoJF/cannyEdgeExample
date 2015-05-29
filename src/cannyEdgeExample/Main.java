package cannyEdgeExample;

import java.awt.image.BufferedImage;
import java.util.List;

import boofcv.alg.feature.detect.edge.CannyEdge;
import boofcv.alg.feature.detect.edge.EdgeContour;
import boofcv.alg.filter.binary.BinaryImageOps;
import boofcv.alg.filter.binary.Contour;
import boofcv.core.image.ConvertBufferedImage;
import boofcv.factory.feature.detect.edge.FactoryEdgeDetectors;
import boofcv.gui.binary.VisualizeBinaryData;
import boofcv.gui.image.ShowImages;
import boofcv.io.image.UtilImageIO;
import boofcv.struct.ConnectRule;
import boofcv.struct.image.ImageSInt16;
import boofcv.struct.image.ImageUInt8;

public class Main {

	public static void main(String args[]) {
		BufferedImage image = UtilImageIO.loadImage("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");

		ImageUInt8 gray = ConvertBufferedImage.convertFrom(image, (ImageUInt8) null);
		ImageUInt8 edgeImage = new ImageUInt8(gray.width, gray.height);

		// Create a canny edge detector which will dynamically compute the
		// threshold based on maximum edge intensity
		// It has also been configured to save the trace as a graph. This is the
		// graph created while performing
		// hysteresis thresholding.
		CannyEdge<ImageUInt8, ImageSInt16> canny = FactoryEdgeDetectors.canny(2, true, true, ImageUInt8.class, ImageSInt16.class);

		// The edge image is actually an optional parameter. If you don't need
		// it just pass in null
		canny.process(gray, 0.4f, 0.5f, edgeImage);

		// First get the contour created by canny
		List<EdgeContour> edgeContours = canny.getContours();
		// The 'edgeContours' is a tree graph that can be difficult to process.
		// An alternative is to extract
		// the contours from the binary image, which will produce a single loop
		// for each connected cluster of pixels.
		// Note that you are only interested in external contours.
		List<Contour> contours = BinaryImageOps.contour(edgeImage, ConnectRule.EIGHT, null);

		// display the results
		BufferedImage visualBinary = VisualizeBinaryData.renderBinary(edgeImage, null);
		BufferedImage visualCannyContour = VisualizeBinaryData.renderContours(edgeContours, null, gray.width, gray.height, null);
		BufferedImage visualEdgeContour = VisualizeBinaryData.renderExternal(contours, null, gray.width, gray.height, null);

		ShowImages.showWindow(visualBinary, "Binary Edges from Canny");
		ShowImages.showWindow(visualCannyContour, "Canny Trace Graph");
		ShowImages.showWindow(visualEdgeContour, "Contour from Canny Binary");
	}
}