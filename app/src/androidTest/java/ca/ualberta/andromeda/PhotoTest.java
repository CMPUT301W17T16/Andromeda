package ca.ualberta.andromeda;
import android.graphics.Bitmap;

import junit.framework.TestCase;

import org.junit.Test;
/**
 * Created by livialee on 2017-03-31.
 */

public class PhotoTest extends TestCase {

    @Test
    public void testAddPhoto() {
        Bitmap bitmap = Bitmap.createBitmap(1000, 2000, Bitmap.Config.ARGB_8888);
        Photo photo = new Photo(bitmap);

        // The photo is compressed; not the same as input it's too big
        assertNotSame(bitmap, photo.getBitmap());
        assertNotSame(photo.getBitmap().getByteCount(), bitmap.getByteCount());

    }

    @Test
    public void testSmallPhoto() {
        Bitmap bitmap = Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
        Photo photo = new Photo(bitmap);

        // The photo is not compressed; the same as input
        assertSame(bitmap, photo.getBitmap());
    }
    @Test
    public void testLimitPhoto() {
        Bitmap bitmap = Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888);
        Photo photo = new Photo(bitmap);

        // The photo is not compressed; the same as input
        assertSame(bitmap, photo.getBitmap());
        int one = photo.getBitmap().getByteCount();
        int two = bitmap.getByteCount();
        assertEquals(one, two);
    }
    @Test
    public void testLimitPhotoTooBig() {
        Bitmap bitmap = Bitmap.createBitmap(128, 129, Bitmap.Config.ARGB_8888);
        Photo photo = new Photo(bitmap);

        // The photo is compressed; different from input
        assertNotSame(bitmap, photo.getBitmap());
        int one = photo.getBitmap().getByteCount();
        int two = bitmap.getByteCount();
        assertNotSame(one, two);
    }

}
