package edu.orangecoastcollege.cs273.petprotector;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PetListActivity extends AppCompatActivity {
    private ImageView petImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        // Connect to view
        petImageView = (ImageView) findViewById(R.id.petImageView);
        // Set image from URI
        petImageView.setImageURI(getUriFromResource(this, R.drawable.none));
    }

    /**
     * Constructs the URI for a given asset
     * @param context
     * @param resId rId of the asset
     * @return Uri of the asset
     */
    public static Uri getUriFromResource(Context context, int resId) {
        Resources res = context.getResources();
        // Build a String in the URI form
        String uri = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + res.getResourcePackageName(resId) + "/"
                + res.getResourceTypeName(resId) + "/"
                + res.getResourceEntryName(resId);

        // Parse the String to construct URI
        return Uri.parse(uri);
    }
}
