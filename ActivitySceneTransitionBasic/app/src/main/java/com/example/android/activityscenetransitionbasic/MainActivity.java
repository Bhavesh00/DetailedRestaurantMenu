/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.activityscenetransitionbasic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.squareup.picasso.Picasso;

/**
 * Our main Activity in this sample. Displays a grid of items which an image and title. When the
 * user clicks on an item, {@link DetailActivity} is launched, using the Activity Scene Transitions
 * framework to animatedly do so.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        // Setup the GridView and set the adapter
        GridView grid = findViewById(R.id.grid_starter);
        GridView grid2 = findViewById(R.id.grid_entree);
        GridView grid3 = findViewById(R.id.grid_taco);
        GridView grid4 = findViewById(R.id.grid_cocktail);
        GridView grid5 = findViewById(R.id.grid_dessert);
        grid.setOnItemClickListener(mOnItemClickListener);
        grid2.setOnItemClickListener(mOnItemClickListener);
        grid3.setOnItemClickListener(mOnItemClickListener);
        grid4.setOnItemClickListener(mOnItemClickListener);
        grid5.setOnItemClickListener(mOnItemClickListener);
        GridAdapter adapter = new GridAdapter(R.string.starters);
        GridAdapter adapter2 = new GridAdapter(R.string.entrees);
        GridAdapter adapter3 = new GridAdapter(R.string.tacos);
        GridAdapter adapter4 = new GridAdapter(R.string.cocktails);
        GridAdapter adapter5 = new GridAdapter(R.string.desserts);
        grid.setAdapter(adapter);
        grid2.setAdapter(adapter2);
        grid3.setAdapter(adapter3);
        grid4.setAdapter(adapter4);
        grid5.setAdapter(adapter5);

        // Menu Nav Bar
        ScrollView scroll_view = findViewById(R.id.scroll_view);
        @SuppressLint("WrongViewCast") final Button starters_button = findViewById(R.id.starters_button);
        starters_button.setOnClickListener(v -> {
            scroll_view.smoothScrollTo(0, ((findViewById(R.id.starter_head)).getTop()));
        });
        @SuppressLint("WrongViewCast") final Button entrees_button = findViewById(R.id.entrees_button);
        entrees_button.setOnClickListener(v -> {
            scroll_view.smoothScrollTo(0, ((findViewById(R.id.entree_head)).getTop()));
        });
        @SuppressLint("WrongViewCast") final Button tacos_button = findViewById(R.id.tacos_button);
        tacos_button.setOnClickListener(v -> {
            scroll_view.smoothScrollTo(0, ((findViewById(R.id.taco_head)).getTop()));
        });
        @SuppressLint("WrongViewCast") final Button cocktails_button = findViewById(R.id.cocktails_button);
        cocktails_button.setOnClickListener(v -> {
            scroll_view.smoothScrollTo(0, ((findViewById(R.id.cocktail_head)).getTop()));
        });
        @SuppressLint("WrongViewCast") final Button desserts_button = findViewById(R.id.desserts_button);
        desserts_button.setOnClickListener(v -> {
            scroll_view.smoothScrollTo(0, ((findViewById(R.id.dessert_head)).getTop()));
        });
    }

    private final AdapterView.OnItemClickListener mOnItemClickListener
            = new AdapterView.OnItemClickListener() {

        /**
         * Called when an item in the {@link android.widget.GridView} is clicked. Here will launch
         * the {@link DetailActivity}, using the Scene Transition animation functionality.
         */
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Item item = (Item) adapterView.getItemAtPosition(position);

            // Construct an Intent as normal
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_PARAM_ID, item.getId());

            // BEGIN_INCLUDE(start_activity)
            /*
             * Now create an {@link android.app.ActivityOptions} instance using the
             * {@link ActivityOptionsCompat#makeSceneTransitionAnimation(Activity, Pair[])} factory
             * method.
             */
            @SuppressWarnings("unchecked")
            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    MainActivity.this,

                    // Now we provide a list of Pair items which contain the view we can transitioning
                    // from, and the name of the view it is transitioning to, in the launched activity
                    new Pair<>(view.findViewById(R.id.food_image),
                            DetailActivity.VIEW_NAME_HEADER_IMAGE),
                    new Pair<>(view.findViewById(R.id.food_name),
                            DetailActivity.VIEW_NAME_HEADER_TITLE));

            // Now we can start the Activity, providing the activity options as a bundle
            ActivityCompat.startActivity(MainActivity.this, intent, activityOptions.toBundle());
            // END_INCLUDE(start_activity)
        }
    };

    /**
     * {@link android.widget.BaseAdapter} which displays items.
     */
    private class GridAdapter extends BaseAdapter {

        int type;
        public GridAdapter(int foodtype) {
            type = foodtype;
        }

        @Override
        public int getCount() {
            int total_type = 0;
            for (int i = 0; i < Item.ITEMS.length; i++) {
                if (type == Item.ITEMS[i].getMtype()) {
                    total_type++;
                }
            }
            return total_type;
        }

        @Override
        public Item getItem(int position) {
            int i = 0;
            while (type != Item.ITEMS[i].getMtype()) {
                i++;;
            }
            return Item.ITEMS[position+i];
        }

        @Override
        public long getItemId(int position) {
            return getItem(position).getId();
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.grid_item, viewGroup, false);
            }

            final Item item = getItem(position);
            if (item.getMtype() == type) {
                // Load the thumbnail image
                ImageView image = view.findViewById(R.id.food_image);
                Picasso.with(image.getContext()).load(item.getThumbnail()).into(image);

                if (item.getFoodLabels() != null) {
                    ImageView[] labels = new ImageView[item.getFoodLabelCount()];
                    for (int i = 0; i < item.getFoodLabelCount(); i++) {
                        if (i == 0) {
                            labels[i] = view.findViewById(R.id.food_label_1);
                        } else {
                            labels[i] = view.findViewById(R.id.food_label_2);

                        }
                        Picasso.with(labels[i].getContext()).load(item.getFoodLabels()[i]).into(labels[i]);
                    }
                }

                // Set the TextView's contents
                TextView name = view.findViewById(R.id.food_name);
                name.setText(item.getName());

                TextView price = view.findViewById(R.id.price);
                price.setText(item.getPrice());


            }
            return view;

        }
    }
}
