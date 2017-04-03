/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by livialee on 2017-02-27.
 */
public class Photo {
    private int intHeight;
    private int intWidth;
    private Bitmap image;

    public Photo(Bitmap Image) {
        this.image = Image;
        this.compressToSize();
    }

    public Bitmap getBitmap() {
        return this.image;
    }

    private void compressToSize() {

        if (this.image.getByteCount() > 655356){
            // TODO Compress the image until it is less than 655356
            double originalHeight = this.image.getHeight();
            double originalWidth = this.image.getWidth();
            // If the height is large than the width
            if (originalHeight > originalWidth) {
                double newHeight = 128;
                double ratio = originalWidth / originalHeight;
                double newWidth = ratio * newHeight;
                intHeight = (int) newHeight;
                intWidth = (int) newWidth;

                // TODO BOTH CONDITIONS REACH BELOW
                // If the width is large than the height
            } else if (originalHeight < originalWidth) {
                double newWidth = 128;
                double ratio = originalHeight / originalWidth;
                double newHeight = ratio * newWidth;
                intHeight = (int) newHeight;
                intWidth = (int) newWidth;
            }
            this.image = Bitmap.createScaledBitmap(this.image, intWidth, intHeight, false);
        }
    }
}
