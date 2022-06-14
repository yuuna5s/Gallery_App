package com.example.selfie;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.util.ArrayList;

public class ImagesGallery {
    public static ArrayList<String> listofImage(Context context)
    {
        Uri uri;
        Cursor cursor;
        int column_index_data,column_index_folder_name;
        ArrayList<String> listofAllImages = new ArrayList<>();
        String absolutePathofImage;
        uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

        String orderBy = MediaStore.Video.Media.DATE_TAKEN;
        cursor = context.getContentResolver().query(uri, projection, null, null, orderBy+" DESC");

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);

        //get folder name
        //column_index_folder_name = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);

        while(cursor.moveToNext()){
            absolutePathofImage = cursor.getString(column_index_data);

            listofAllImages.add(absolutePathofImage);
        }

        return listofAllImages;
    }
}
