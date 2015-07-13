package com.kanmani.prokarma.samplecontentprovider;

import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Kanmani on 5/14/2015.
 */
public class ImageFragment extends Fragment {

    private static final String TAG = ImageFragment.class.getSimpleName();

    private ListView mImageList;
    private ContentResolver resolver;
    private ArrayList imageList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.image_list, container, false);
        mImageList = (ListView) view.findViewById(R.id.Image_holder);
        getImagesfromGallery();
        return view;
    }

    private void getImagesfromGallery() {
        resolver = getActivity().getApplicationContext().getContentResolver();
        Uri imageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Images.Media.DATA,MediaStore.Images.Media._ID};
        loadImages(imageUri, projection);

    }

    private void loadImages(Uri imageUri, String[] projection) {
        Cursor photoCursor = resolver.query(imageUri, projection, null, null, null);
        SimpleCursorAdapter1 cursorAdapter = new SimpleCursorAdapter1(getActivity(), photoCursor, 0);
        mImageList.setAdapter(cursorAdapter);
        // ImageAdaptor imageAdaptor = new ImageAdaptor(getActivity().getApplicationContext(), imageList);
        //return BitmapFactory.decodeFile(photopath, null);
    }

    class SimpleCursorAdapter1 extends CursorAdapter {
        private Context context;
        private ImageView mImage;
        private Cursor cursor;
        private LayoutInflater inflater;

        public SimpleCursorAdapter1(Context context, Cursor c, int flags) {
            super(context, c, flags);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
           View  convertView = LayoutInflater.from(context).inflate(R.layout.image_list_item,parent,false);
//            mImage = (ImageView)convertView.findViewById(R.id.GImage);
//            try {
//                if (cursor != null) {
//
//                    if (cursor.moveToFirst()) {
//                        do {
//                            photopath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
//                            imageList.add(BitmapFactory.decodeFile(photopath));
//                        }
//                        while (cursor.moveToNext());
//                    }
//                }
//
//                Log.v(TAG, "ListSize : " + imageList.size());
//
//                mImage.setImageResource(cursor);
//            } finally {
//                if (cursor != null) {
//                    cursor.close();
//                }
//            }
             return convertView;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            String photoPath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            ImageView galleryImage = (ImageView)view.findViewById(R.id.GImage);
            File photoFile = new File(photoPath);
            Log.i(TAG, "photo path :: " + photoPath);
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap bitmap = BitmapFactory.decodeFile(photoPath,bmOptions);
            galleryImage.setImageBitmap(bitmap);
        }
    }
}
