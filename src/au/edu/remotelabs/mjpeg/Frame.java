/**
 * MJPEG streaming application.
 * 
 * @author Michael Diponio <michael.diponio@uts.edu.au>
 * @date 18th May 2016
 */

package au.edu.remotelabs.mjpeg;

import java.io.IOException;
import java.io.OutputStream;

/** 
 * A single frame from the source stream.
 */
public class Frame
{
    /** Image bytes. */
    private final byte image[];
    
    /** Timestamp of when the frame was read. */
    private final long timestamp;
    
    /** MIME type of image. */
    private final String mime;
    
    
    /**
     * Creates the frame with the specified content size.
     * 
     * @param mime image mime type
     * @param data image data bytes 
     */
    public Frame(String mime, byte data[])
    {
        this.mime = mime;
        this.image = data;
        this.timestamp = System.currentTimeMillis();
    }

    
    /**
     * Write the image bytes to the output stream. 
     * 
     * @param stream stream to write to
     * @throws IOException error in writing
     */
    public void writeTo(OutputStream stream) throws IOException
    {
        stream.write(this.image);
    }
    
    /**
     * Returns the length of the frame image in bytes.
     * 
     * @return image length in bytes
     */
    public int getContentLength()
    {
        return this.image.length;
    }
    
    /**
     * Returns the content type MIME of the frame. 
     * 
     * @return MIME type
     */
    public String getContentType()
    {
        return this.mime;
    }
    
    /**
     * Gets the time stamp of when this frame was read.
     * 
     * @return time stamp of read
     */
    public long getTimestamp()
    {
        return this.timestamp;
    }
}