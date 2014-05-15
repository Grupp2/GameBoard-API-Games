package othello.gui.graphics;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageResize {

	public BufferedImage resizeImage(BufferedImage image, Dimension dimension) {
		int type = 0;
		type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
		int sideSize = getSmallestSide(dimension);
		BufferedImage resizedImage = new BufferedImage(sideSize > 0 ? sideSize:1, sideSize > 0 ? sideSize:1, type);
		Graphics2D graph = resizedImage.createGraphics();
		graph.drawImage(image, 0, 0, sideSize, sideSize, null);
		graph.dispose();
		return resizedImage;
	}

	private int getSmallestSide(Dimension dimension) {
		int result = 0;
		result = dimension.height;
		if (dimension.width < result)
			result = dimension.width;
		return result;
	}
}