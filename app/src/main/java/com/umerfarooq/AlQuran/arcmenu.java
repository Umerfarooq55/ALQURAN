package com.umerfarooq.AlQuran;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.arcmenu.lib.ArcMenu;
import com.example.arcmenu.lib.RayMenu;

import info.androidhive.introslider.R;

public class arcmenu extends Activity {
    private static final int[] ITEM_DRAWABLES = { R.drawable.blogger,
            R.drawable.facebook, R.drawable.google, R.drawable.twitter,
            R.drawable.linkedin };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ArcMenu arcMenu = (ArcMenu) findViewById(R.id.arc_menu);

        initArcMenu(arcMenu, ITEM_DRAWABLES);

        RayMenu rayMenu = (RayMenu) findViewById(R.id.ray_menu);
        final int itemCount = ITEM_DRAWABLES.length;
        for (int i = 0; i < itemCount; i++) {
            ImageView item = new ImageView(this);
            item.setImageResource(ITEM_DRAWABLES[i]);

            final int position = i;
            rayMenu.addItem(item, new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (position == 0) {
                        Toast.makeText(arcmenu.this, "Blogger",
                                Toast.LENGTH_SHORT).show();
                    } else if (position == 1) {
                        Toast.makeText(arcmenu.this, "Facebook",
                                Toast.LENGTH_SHORT).show();
                    } else if (position == 2) {
                        Toast.makeText(arcmenu.this, "Google",
                                Toast.LENGTH_SHORT).show();
                    } else if (position == 3) {
                        Toast.makeText(arcmenu.this, "Twitter",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(arcmenu.this, "Linkedin",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

       private void initArcMenu(ArcMenu menu, int[] itemDrawables) {
        final int itemCount = itemDrawables.length;
        for (int i = 0; i < itemCount; i++) {
            ImageView item = new ImageView(this);
            item.setImageResource(itemDrawables[i]);

            final int position = i;
            menu.addItem(item, new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (position == 0) {
                        Toast.makeText(arcmenu.this, "Blogger",
                                Toast.LENGTH_SHORT).show();
                    } else if (position == 1) {
                        Toast.makeText(arcmenu.this, "Facebook",
                                Toast.LENGTH_SHORT).show();
                    } else if (position == 2) {
                        Toast.makeText(arcmenu.this, "Google",
                                Toast.LENGTH_SHORT).show();
                    } else if (position == 3) {
                        Toast.makeText(arcmenu.this, "Twitter",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(arcmenu.this, "Linkedin",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
