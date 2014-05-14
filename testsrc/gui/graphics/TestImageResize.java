package gui.graphics;

import static org.junit.Assert.*;
import gui.graphics.ImageResize;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.junit.Before;
import org.junit.Test;

public class TestImageResize {
	private BufferedImage testImage;
	private Dimension dimensionToTest;
	private ImageResize ir = new ImageResize();
	
	@Before
	public void setUp() throws Exception {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("gui/graphics/svart.jpg");
			testImage = ImageIO.read(input);
		} catch (IOException e) {
			
		}
	}

	@Test
	public void HorisontalTest() {
//		dimensionToTest = mock(Dimension.class);
//		when(dimensionToTest.height).thenReturn(40);
//		when(dimensionToTest.width).thenReturn(20);
		dimensionToTest = new Dimension(20, 40);
		testImage = ir.resizeImage(testImage, dimensionToTest);
		assertEquals(20, testImage.getWidth());
	}
	
	@Test
	public void VerticalTest() {
		dimensionToTest = new Dimension(40, 20);
		testImage = ir.resizeImage(testImage, dimensionToTest);
		assertEquals(20, testImage.getHeight());
	}
}
