/* PixImage.java */

/**
 *  The PixImage class represents an image, which is a rectangular grid of
 *  color pixels.  Each pixel has red, green, and blue intensities in the range
 *  0...255.  Descriptions of the methods you must implement appear below.
 *  They include a constructor of the form
 *
 *      public PixImage(int width, int height);
 *
 *  that creates a black (zero intensity) image of the specified width and
 *  height.  Pixels are numbered in the range (0...width - 1, 0...height - 1).
 *
 *  All methods in this class must be implemented to complete Part I.
 *  See the README file accompanying this project for additional details.
 */

public class PixImage {

  /**
   *  Define any variables associated with a PixImage object here.  These
   *  variables MUST be private.
   */

    private class Pixel
    {
        private Pixel(short red, short green, short blue)
        {
            m_red = red;
            m_green = green;
            m_blue = blue;
        }

        private Pixel()
        {
            m_red = 0;
            m_green = 0;
            m_blue = 0;
        }
        private short getRed()
        {
            return m_red;
        }

        private void setRed(short red)
        {
            m_red = red;
        }

        private short getGreen()
        {
            return m_green;
        }

        private void setGreen(short green)
        {
            m_green = green;
        }

        private short getBlue()
        {
            return m_blue;
        }

        private void setBlue(short blue)
        {
            m_blue = blue;
        }

        private short m_red, m_green, m_blue;
    }

    private int m_imagewidth, m_imageheight;
    //private short m_red, m_green, m_blue;
    private Pixel[][] m_pixelset;
    private final static short[][] s_gxMatrix = {{1, 0, -1},
                                                 {2, 0, -2},
                                                 {1, 0, -1}};

    private final static short[][] s_gyMatrix = {{1,  2,  1},
                                                 {0,  0,  0},
                                                 {-1, -2, -1}};

  /**
   * PixImage() constructs an empty PixImage with a specified width and height.
   * Every pixel has red, green, and blue intensities of zero (solid black).
   *
   * @param width the width of the image.
   * @param height the height of the image.
   */
  public PixImage(int width, int height) {
    // Your solution here.
      m_imagewidth = width;
      m_imageheight = height;
      m_pixelset = new Pixel[height][width];
      int i, j;
      for(i = 0; i < height; i++)
      {
          for(j = 0; j < width; j++)
          {
              m_pixelset[i][j] = new Pixel();
          }
      }
 //     m_red = m_green = m_blue = 0;
  }

  /**
   * getWidth() returns the width of the image.
   *
   * @return the width of the image.
   */
  public int getWidth() {
    // Replace the following line with your solution.
    return m_imagewidth;
  }

  /**
   * getHeight() returns the height of the image.
   *
   * @return the height of the image.
   */
  public int getHeight() {
    // Replace the following line with your solution.
    return m_imageheight;
  }

  /**
   * getRed() returns the red intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the red intensity of the pixel at coordinate (x, y).
   */
  public short getRed(int x, int y) {
    // Replace the following line with your solution.
    if(pixelPositionCheck(x, y))
        return  m_pixelset[y][x].getRed();
    return -1;
  }

  /**
   * getGreen() returns the green intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the green intensity of the pixel at coordinate (x, y).
   */
  public short getGreen(int x, int y) {
    // Replace the following line with your solution.
      if(pixelPositionCheck(x, y))
        return m_pixelset[y][x].getGreen();
      return -1;
  }

  /**
   * getBlue() returns the blue intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the blue intensity of the pixel at coordinate (x, y).
   */
  public short getBlue(int x, int y) {
    // Replace the following line with your solution.
      if(pixelPositionCheck(x, y))
        return m_pixelset[y][x].getBlue();
      return -1;
  }

  /**
   * setPixel() sets the pixel at coordinate (x, y) to specified red, green,
   * and blue intensities.
   *
   * If any of the three color intensities is NOT in the range 0...255, then
   * this method does NOT change any of the pixel intensities.
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @param red the new red intensity for the pixel at coordinate (x, y).
   * @param green the new green intensity for the pixel at coordinate (x, y).
   * @param blue the new blue intensity for the pixel at coordinate (x, y).
   */
  public void setPixel(int x, int y, short red, short green, short blue) {
    // Your solution here.
      if(pixelPositionCheck(x, y)) {
          m_pixelset[y][x].setRed(red);
          m_pixelset[y][x].setGreen(green);
          m_pixelset[y][x].setBlue(blue);
      }
  }

  /**
   * toString() returns a String representation of this PixImage.
   *
   * This method isn't required, but it should be very useful to you when
   * you're debugging your code.  It's up to you how you represent a PixImage
   * as a String.
   *
   * @return a String representation of this PixImage.
   */
  public String toString() {
    // Replace the following line with your solution.
    String imageStr = new String();

    int i, j;
    for(j = 0; j < m_imageheight; j++)
    {
        for(i = 0; i < m_imagewidth; i++)
        {
            if(i == m_imagewidth - 1)
            {
                imageStr += String.format(" {%4d,%4d,%4d}",
                        m_pixelset[j][i].m_red,
                        m_pixelset[j][i].m_green,
                        m_pixelset[j][i].m_blue);
            }
            else
            {
                imageStr += String.format(" {%4d,%4d,%4d} |",
                        m_pixelset[j][i].m_red,
                        m_pixelset[j][i].m_green,
                        m_pixelset[j][i].m_blue);
            }

        }

        imageStr += "\r\n";
    }

    return imageStr;
  }

  /**
   * boxBlur() returns a blurred version of "this" PixImage.
   *
   * If numIterations == 1, each pixel in the output PixImage is assigned
   * a value equal to the average of its neighboring pixels in "this" PixImage,
   * INCLUDING the pixel itself.
   *
   * A pixel not on the image boundary has nine neighbors--the pixel itself and
   * the eight pixels surrounding it.  A pixel on the boundary has six
   * neighbors if it is not a corner pixel; only four neighbors if it is
   * a corner pixel.  The average of the neighbors is the sum of all the
   * neighbor pixel values (including the pixel itself) divided by the number
   * of neighbors, with non-integer quotients rounded toward zero (as Java does
   * naturally when you divide two integers).
   *
   * Each color (red, green, blue) is blurred separately.  The red input should
   * have NO effect on the green or blue outputs, etc.
   *
   * The parameter numIterations specifies a number of repeated iterations of
   * box blurring to perform.  If numIterations is zero or negative, "this"
   * PixImage is returned (not a copy).  If numIterations is positive, the
   * return value is a newly constructed PixImage.
   *
   * IMPORTANT:  DO NOT CHANGE "this" PixImage!!!  All blurring/changes should
   * appear in the new, output PixImage only.
   *
   * @param numIterations the number of iterations of box blurring.
   * @return a blurred version of "this" PixImage.
   */
  public PixImage boxBlur(int numIterations) {
    // Replace the following line with your solution.
    if(numIterations <= 0)
    {
        return this;
    }

    PixImage newImage = null;
    PixImage baseImage = this;
    int i, j, m, n;

    short red = 0, green = 0, blue = 0;
      //middle pixel para calculation
    short divider;
    while(numIterations > 0)
    {
        newImage = new PixImage(m_imagewidth, m_imageheight);
        for(i = 0; i < m_imagewidth; i++)
        {
            for(j = 0; j < m_imageheight; j++)
            {
                divider = red = green = blue = 0;
                for(m = i-1; m <= i+1; m++)
                {
                    if((m < 0) || (m > m_imagewidth - 1))
                         continue;
                    for(n = j-1; n <= j+1; n++)
                    {
                        if((n < 0) || (n > m_imageheight - 1))
                            continue;
                        if(-1 != baseImage.getRed(m, n))
                        {
                            red += baseImage.getRed(m, n);
                            green += baseImage.getGreen(m, n);
                            blue += baseImage.getBlue(m, n);
                            divider++;
                        }
                    }
                }
                red = (short)(red/divider);
                green = (short)(green/divider);
                blue = (short)(blue/divider);
                newImage.setPixel(i, j, red, green, blue);

            }
        }
        baseImage = newImage;
        numIterations--;
    }
    return newImage;
  }

  /**
   * mag2gray() maps an energy (squared vector magnitude) in the range
   * 0...24,969,600 to a grayscale intensity in the range 0...255.  The map
   * is logarithmic, but shifted so that values of 5,080 and below map to zero.
   *
   * DO NOT CHANGE THIS METHOD.  If you do, you will not be able to get the
   * correct images and pass the autograder.
   *
   * @param mag the energy (squared vector magnitude) of the pixel whose
   * intensity we want to compute.
   * @return the intensity of the output pixel.
   */
  private static short mag2gray(long mag) {
    short intensity = (short) (30.0 * Math.log(1.0 + (double) mag) - 256.0);

    // Make sure the returned intensity is in the range 0...255, regardless of
    // the input value.
    if (intensity < 0) {
      intensity = 0;
    } else if (intensity > 255) {
      intensity = 255;
    }
    return intensity;
  }

  /**
   * sobelEdges() applies the Sobel operator, identifying edges in "this"
   * image.  The Sobel operator computes a magnitude that represents how
   * strong the edge is.  We compute separate gradients for the red, blue, and
   * green components at each pixel, then sum the squares of the three
   * gradients at each pixel.  We convert the squared magnitude at each pixel
   * into a grayscale pixel intensity in the range 0...255 with the logarithmic
   * mapping encoded in mag2gray().  The output is a grayscale PixImage whose
   * pixel intensities reflect the strength of the edges.
   *
   * See http://en.wikipedia.org/wiki/Sobel_operator#Formulation for details.
   *
   * @return a grayscale PixImage representing the edges of the input image.
   * Whiter pixels represent stronger edges.
   */
  public PixImage sobelEdges() {
    // Replace the following line with your solution.
    int[][] energyMatrix = new int[m_imageheight][m_imagewidth];
    int i, j;

    for(i = 0; i < m_imagewidth; i++)
    {
        for(j = 0; j < m_imageheight; j++)
        {
            energyMatrix[j][i] = CalEnergy(i, j);
        }
    }
    short grayval;
    PixImage grayscaleimage = new PixImage(m_imagewidth, m_imageheight);
    for(i = 0; i < m_imagewidth; i++)
    {
        for(j = 0; j < m_imageheight; j++)
        {
            grayval = mag2gray(energyMatrix[j][i]);
            grayscaleimage.setPixel(i, j, grayval, grayval, grayval);
        }
    }
    return grayscaleimage;
    // Don't forget to use the method mag2gray() above to convert energies to
    // pixel intensities.
  }

  private int CalEnergy(int x, int y)
  {
      int i, j, m = 0, n = 0;
      int energy = 0;
      short[][] tmpredarray = new short[3][3];
      short[][] tmpgreenarray = new short[3][3];
      short[][] tmpbluearray = new short[3][3];
      for(i = x - 1; i <= x + 1; i++)
      {
          for(j = y - 1; j <= y + 1; j++)
          {
              if(-1 != getRed(i ,j))
              {
                  tmpredarray[n][m] = getRed(i, j);
                  tmpgreenarray[n][m]= getGreen(i, j);
                  tmpbluearray[n][m] = getBlue(i, j);
              }
              else
              {
                  Pixel refelctingpixel = GetReflectingPixel(i ,j);
                  tmpredarray[n][m] = refelctingpixel.getRed();
                  tmpgreenarray[n][m] = refelctingpixel.getGreen();
                  tmpbluearray[n][m] = refelctingpixel.getBlue();
              }
              n++;
          }
          n = 0;
          m++;
      }

     int redgradientx = 0, greengradientx = 0, bluegradientx = 0, redgradienty = 0, greengradienty = 0, bluegradienty = 0;

     for(i = 0; i < 3; i++)
     {
         for(j = 0; j < 3; j++)
         {
             redgradientx += s_gxMatrix[i][j] * tmpredarray[j][i];
             redgradienty += s_gyMatrix[i][j] * tmpredarray[j][i];
             greengradientx += s_gxMatrix[i][j] * tmpgreenarray[j][i];
             greengradienty += s_gyMatrix[i][j] * tmpgreenarray[j][i];
             bluegradientx += s_gxMatrix[i][j] * tmpbluearray[j][i];
             bluegradienty += s_gyMatrix[i][j] * tmpbluearray[j][i];
         }

     }
      energy = (int)(redgradientx * redgradientx + redgradienty * redgradienty +
               greengradientx * greengradientx + greengradienty * greengradienty +
               bluegradientx * bluegradientx + bluegradienty * bluegradienty);

      return energy;
  }

  private Pixel GetReflectingPixel(int x, int y)
  {
      if(x < 0)
      {
          x = 0;
      }
      if(x > m_imagewidth - 1)
      {
          x = m_imagewidth - 1;
      }
      if(y < 0)
      {
          y = 0;
      }
      if(y > m_imageheight - 1)
      {
          y = m_imageheight - 1;
      }

      return m_pixelset[y][x];


  }
  private boolean pixelPositionCheck(int x, int y)
  {
      if((x < 0)||(x > m_imagewidth - 1)||(y < 0)||(y > m_imageheight - 1))
      {
          return false;
      }
      else
      {
          return true;
      }
  }


  /**
   * TEST CODE:  YOU DO NOT NEED TO FILL IN ANY METHODS BELOW THIS POINT.
   * You are welcome to add tests, though.  Methods below this point will not
   * be tested.  This is not the autograder, which will be provided separately.
   */


  /**
   * doTest() checks whether the condition is true and prints the given error
   * message if it is not.
   *
   * @param b the condition to check.
   * @param msg the error message to print if the condition is false.
   */
  private static void doTest(boolean b, String msg) {
    if (b) {
      System.out.println("Good.");
    } else {
      System.err.println(msg);
    }
  }

  /**
   * array2PixImage() converts a 2D array of grayscale intensities to
   * a grayscale PixImage.
   *
   * @param pixels a 2D array of grayscale intensities in the range 0...255.
   * @return a new PixImage whose red, green, and blue values are equal to
   * the input grayscale intensities.
   */
  private static PixImage array2PixImage(int[][] pixels) {
    int width = pixels.length;
    int height = pixels[0].length;
    PixImage image = new PixImage(width, height);
    int x, y;
    for (x = 0; x < width; x++) {
      for (y = 0; y < height; y++) {
        image.setPixel(x, y, (short) pixels[x][y], (short) pixels[x][y],
                       (short) pixels[x][y]);
      }
    }

    return image;
  }

  /**
   * equals() checks whether two images are the same, i.e. have the same
   * dimensions and pixels.
   *
   * @param image a PixImage to compare with "this" PixImage.
   * @return true if the specified PixImage is identical to "this" PixImage.
   */
  public boolean equals(PixImage image) {
    int width = getWidth();
    int height = getHeight();

    if (image == null ||
        width != image.getWidth() || height != image.getHeight()) {
      return false;
    }

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        if (! (getRed(x, y) == image.getRed(x, y) &&
               getGreen(x, y) == image.getGreen(x, y) &&
               getBlue(x, y) == image.getBlue(x, y))) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * main() runs a series of tests to ensure that the convolutions (box blur
   * and Sobel) are correct.
   */
  public static void main(String[] args) {
    // Be forwarned that when you write arrays directly in Java as below,
    // each "row" of text is a column of your image--the numbers get
    // transposed.
    short val = mag2gray(163200);
    PixImage image1 = array2PixImage(new int[][] { { 0, 10, 240 },
                                                   { 30, 120, 250 },
                                                   { 80, 250, 255 } });
    System.out.println("Testing getWidth/getHeight on a 3x3 image.  " +
                       "Input image:");
    System.out.print(image1);
    doTest(image1.getWidth() == 3 && image1.getHeight() == 3,
           "Incorrect image width and height.");

    System.out.println("Testing blurring on a 3x3 image.");
    doTest(image1.boxBlur(1).equals(
           array2PixImage(new int[][] { { 40, 108, 155 },
                                        { 81, 137, 187 },
                                        { 120, 164, 218 } })),
           "Incorrect box blur (1 rep):\n" + image1.boxBlur(1));
    doTest(image1.boxBlur(2).equals(
           array2PixImage(new int[][] { { 91, 118, 146 },
                                        { 108, 134, 161 },
                                        { 125, 151, 176 } })),
           "Incorrect box blur (2 rep):\n" + image1.boxBlur(2));
    doTest(image1.boxBlur(2).equals(image1.boxBlur(1).boxBlur(1)),
           "Incorrect box blur (1 rep + 1 rep):\n" +
           image1.boxBlur(2) + image1.boxBlur(1).boxBlur(1));

    System.out.println("Testing edge detection on a 3x3 image.");
    doTest(image1.sobelEdges().equals(
           array2PixImage(new int[][] { { 104, 189, 180 },
                                        { 160, 193, 157 },
                                        { 166, 178, 96 } })),
           "Incorrect Sobel:\n" + image1.sobelEdges());


    PixImage image2 = array2PixImage(new int[][] { { 0, 100, 100 },
                                                   { 0, 0, 100 } });
    System.out.println("Testing getWidth/getHeight on a 2x3 image.  " +
                       "Input image:");
    System.out.print(image2);
    doTest(image2.getWidth() == 2 && image2.getHeight() == 3,
           "Incorrect image width and height.");

    System.out.println("Testing blurring on a 2x3 image.");
    doTest(image2.boxBlur(1).equals(
           array2PixImage(new int[][] { { 25, 50, 75 },
                                        { 25, 50, 75 } })),
           "Incorrect box blur (1 rep):\n" + image2.boxBlur(1));

    System.out.println("Testing edge detection on a 2x3 image.");
    doTest(image2.sobelEdges().equals(
           array2PixImage(new int[][] { { 122, 143, 74 },
                                        { 74, 143, 122 } })),
           "Incorrect Sobel:\n" + image2.sobelEdges());
  }
}
