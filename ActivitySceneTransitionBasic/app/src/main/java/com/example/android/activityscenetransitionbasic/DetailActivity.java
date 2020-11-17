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

import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import com.squareup.picasso.Picasso;

/**
 * Our secondary Activity which is launched from {@link MainActivity}. Has a simple detail UI
 * which has a large banner image, title and body text.
 */
public class DetailActivity extends AppCompatActivity {

    // Extra name for the ID parameter
    public static final String EXTRA_PARAM_ID = "detail:_id";

    // View name of the header image. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_IMAGE = "detail:header:image";

    // View name of the header title. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_TITLE = "detail:header:title";

    private ImageView mHeaderFoodImage;
    private ImageView mHeaderFoodLabelOne;
    private ImageView mHeaderFoodLabelTwo;
    private TextView mHeaderName;
    private TextView mHeaderDescription;
    private TextView mHeaderPrice;
    private TextView mHeaderNutrition;

    private Item mItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        // Retrieve the correct Item instance, using the ID provided in the Intent
        mItem = Item.getItem(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));

        mHeaderFoodImage = findViewById(R.id.food_image_zoom);
        mHeaderFoodLabelOne = findViewById(R.id.food_label_1_zoom);
        mHeaderFoodLabelTwo = findViewById(R.id.food_label_2_zoom);
        mHeaderName = findViewById(R.id.food_name_zoom);
        mHeaderDescription = findViewById(R.id.food_desc);
        mHeaderPrice = findViewById(R.id.price_zoom);
        mHeaderNutrition = findViewById(R.id.nutrition);

        // BEGIN_INCLUDE(detail_set_view_name)
        /*
         * Set the name of the view's which will be transition to, using the static values above.
         * This could be done in the layout XML, but exposing it via static variables allows easy
         * querying from other Activities
         */
        ViewCompat.setTransitionName(mHeaderFoodImage, VIEW_NAME_HEADER_IMAGE);
        ViewCompat.setTransitionName(mHeaderName, VIEW_NAME_HEADER_TITLE);
        // END_INCLUDE(detail_set_view_name)

        loadItem();
    }

    private void loadItem() {
        // Set the title TextView to the item's name
        mHeaderName.setText(mItem.getName());
        mHeaderDescription.setText(mItem.getDescription());
        mHeaderPrice.setText(mItem.getPrice());
        mHeaderNutrition.setText(mItem.getNutrition());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && addTransitionListener()) {
            // If we're running on Lollipop and we have added a listener to the shared element
            // transition, load the thumbnail. The listener will load the full-size image when
            // the transition is complete.
            loadThumbnail();
            loadImageOne();
            loadImageTwo();
        } else {
            // If all other cases we should just load the full-size image now
            loadFullSizeImage();
            loadImageOne();
            loadImageTwo();
        }
    }

    /**
     * Load the item's thumbnail image into our {@link ImageView}.
     */
    private void loadThumbnail() {
        Picasso.with(mHeaderFoodImage.getContext())
                .load(mItem.getThumbnail())
                .noFade()
                .into(mHeaderFoodImage);
    }

    /**
     * Load the item's full-size image into our {@link ImageView}.
     */
    private void loadFullSizeImage() {
        Picasso.with(mHeaderFoodImage.getContext())
                .load(mItem.getPhoto())
                .noFade()
                .noPlaceholder()
                .into(mHeaderFoodImage);
    }

    /**
     * Load the item's full-size image into our {@link ImageView}.
     */
    private void loadImageOne() {
        if (mItem.getFoodLabels() != null) {
            Picasso.with(mHeaderFoodLabelOne.getContext())
                    .load(mItem.getFoodLabels()[0])
                    .noFade()
                    .noPlaceholder()
                    .into(mHeaderFoodLabelOne);
        }
    }

    /**
     * Load the item's full-size image into our {@link ImageView}.
     */
    private void loadImageTwo() {
        if (mItem.getFoodLabels() != null && mItem.getFoodLabelCount() > 1) {
            Picasso.with(mHeaderFoodLabelTwo.getContext())
                    .load(mItem.getFoodLabels()[1])
                    .noFade()
                    .noPlaceholder()
                    .into(mHeaderFoodLabelTwo);
        }
    }

    /**
     * Try and add a {@link Transition.TransitionListener} to the entering shared element
     * {@link Transition}. We do this so that we can load the full-size image after the transition
     * has completed.
     *
     * @return true if we were successful in adding a listener to the enter transition
     */
    @RequiresApi(21)
    private boolean addTransitionListener() {
        final Transition transition = getWindow().getSharedElementEnterTransition();

        if (transition != null) {
            // There is an entering shared element transition so add a listener to it
            transition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionEnd(Transition transition) {
                    // As the transition has ended, we can now load the full-size image
                    loadFullSizeImage();

                    // Make sure we remove ourselves as a listener
                    transition.removeListener(this);
                }

                @Override
                public void onTransitionStart(Transition transition) {
                    // No-op
                }

                @Override
                public void onTransitionCancel(Transition transition) {
                    // Make sure we remove ourselves as a listener
                    transition.removeListener(this);
                }

                @Override
                public void onTransitionPause(Transition transition) {
                    // No-op
                }

                @Override
                public void onTransitionResume(Transition transition) {
                    // No-op
                }
            });
            return true;
        }

        // If we reach here then we have not added a listener
        return false;
    }

}
