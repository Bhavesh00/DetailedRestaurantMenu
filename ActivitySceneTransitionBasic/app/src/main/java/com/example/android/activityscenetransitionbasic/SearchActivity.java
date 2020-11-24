package com.example.android.activityscenetransitionbasic;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private LinearLayout llContainer;
    private EditText etSearch;
    private ListView lvProducts;
    private ArrayList<Item> mProductArrayList = new ArrayList<Item>();
    private MyAdapter adapter1;
    public static String initialQuery;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        mProductArrayList.add(new Item(R.string.starters, R.string.guacamole,R.drawable.guacamole, R.string.guacamole_desc,R.string.sixteen_dollar, new int[] {R.drawable.vegan, R.drawable.gluten_free}));
        mProductArrayList.add(new Item(R.string.starters, R.string.queso_fundido, R.drawable.queso_fundido, R.string.queso_fundido_desc, R.string.nine_dollar));
        mProductArrayList.add(new Item(R.string.starters,R.string.nachos, R.drawable.nachos, R.string.nachos_desc, R.string.eleven_dollar));
        mProductArrayList.add(new Item(R.string.entrees, R.string.carne_asada,R.drawable.carne_asada, R.string.carne_asada_desc,R.string.sixteen_dollar,  new int[] {R.drawable.dairy_free}));
        mProductArrayList.add(new Item(R.string.entrees, R.string.tampiquena, R.drawable.tampiquena, R.string.tampiquena_desc, R.string.sixteen_dollar));
        mProductArrayList.add(new Item(R.string.entrees, R.string.mega_desc, R.drawable.mega_tiacoyo, R.string.mega_desc, R.string.fiften_dollar));
        mProductArrayList.add(new Item(R.string.entrees, R.string.fajitas,R.drawable.fajitas_de_pollo_o_res, R.string.fajitas_desc, R.string.fiften_dollar));
        mProductArrayList.add(new Item(R.string.entrees, R.string.milanesa, R.drawable.milanesas, R.string.milanesa_desc, R.string.fiften_dollar, new int[] {R.drawable.dairy_free}));
        mProductArrayList.add(new Item(R.string.entrees, R.string.pechuga_en_salsa, R.drawable.pechugas_en_salsa_chipotle, R.string.pechuaga_en_salsa_desc, R.string.fiften_dollar));
        mProductArrayList.add(new Item(R.string.entrees, R.string.pechuga_plancha,R.drawable.pechuga_a_la_plancha, R.string.pechuga_plancha_desc, R.string.fourteen_dollar, new int[] {R.drawable.dairy_free}));
        mProductArrayList.add(new Item(R.string.entrees, R.string.enchiladas, R.drawable.enchiladas_en_salsa_verde, R.string.enchiladas_desc, R.string.twelve_dollar));
        mProductArrayList.add(new Item(R.string.entrees, R.string.flautas, R.drawable.flautas, R.string.flautas_desc, R.string.eleven_dollar));
        mProductArrayList.add(new Item(R.string.tacos, R.string.taco_americano,R.drawable.taco_americano, R.string.taco_americano_desc, R.string.two_nintey_nine_dollar));
        mProductArrayList.add(new Item(R.string.tacos, R.string.taco_mexica, R.drawable.taco_mexica, R.string.taco_mexica_desc, R.string.three_twenty_five_dollar));
        mProductArrayList.add(new Item(R.string.tacos, R.string.taco_de_lomo, R.drawable.taco_de_lomo, R.string.taco_de_lomo_desc, R.string.three_forty_five_dollar, new int[] {R.drawable.dairy_free}));
        mProductArrayList.add(new Item(R.string.tacos, R.string.taco_de_pescado,R.drawable.taco_de_pescado, R.string.taco_de_pescado_desc, R.string.three_twenty_five_dollar, new int[] {R.drawable.dairy_free}));
        mProductArrayList.add(new Item(R.string.tacos, R.string.taco_campesino, R.drawable.taco_campesino, R.string.taco_campesino_desc, R.string.five_twenty_five_dollar, new int[] {R.drawable.dairy_free}));
        mProductArrayList.add(new Item(R.string.tacos, R.string.taco_veggie, R.drawable.taco_veggie, R.string.taco_veggie_desc, R.string.two_fifty_dollar, new int[] {R.drawable.vegan, R.drawable.gluten_free}));
        mProductArrayList.add(new Item(R.string.cocktails, R.string.fresh_lime_margarita, R.drawable.fresh_lime_margarita, R.string.fresh_lime_margarita_desc, R.string.six_fifty_dollar, new int[] {R.drawable.dairy_free}));
        mProductArrayList.add(new Item(R.string.cocktails, R.string.paloma, R.drawable.paloma, R.string.paloma_desc, R.string.six_fifty_dollar, new int[] {R.drawable.dairy_free}));
        mProductArrayList.add(new Item(R.string.cocktails, R.string.russo_mexicano, R.drawable.russo_mexicano, R.string.russo_mexicano_desc, R.string.seven_dollar));
        mProductArrayList.add(new Item(R.string.cocktails, R.string.seasonal_margarita_avacado, R.drawable.seasonal_margarita___avacado, R.string.seasonal_margarita_avacado_desc, R.string.eleven_dollar, new int[] {R.drawable.dairy_free, R.drawable.vegan}));
        mProductArrayList.add(new Item(R.string.cocktails, R.string.seasonal_margarita_blackberry_mint, R.drawable.seasonal_margarita___blackberry_mint, R.string.seasonal_margarita_blackberry_mint_desc, R.string.eight_fifty_dollar, new int[] {R.drawable.dairy_free, R.drawable.vegan}));
        mProductArrayList.add(new Item(R.string.cocktails, R.string.mango_habanero, R.drawable.mango_habanero, R.string.mango_habanero_desc, R.string.seven_fifty_dollar, new int[] {R.drawable.dairy_free, R.drawable.vegan}));
        mProductArrayList.add(new Item(R.string.cocktails, R.string.seasonal_margarita_watermelon, R.drawable.watermelon_margarita, R.string.seasonal_margarita_watermelon_desc, R.string.six_fifty_dollar, new int[] {R.drawable.dairy_free, R.drawable.vegan}));
        mProductArrayList.add(new Item(R.string.desserts, R.string.flan, R.drawable.flan, R.string.flan_desc, R.string.five_dollar));
        mProductArrayList.add(new Item(R.string.desserts, R.string.paletas, R.drawable.paletas, R.string.paletas_desc, R.string.three_dollar, new int[] {R.drawable.dairy_free, R.drawable.vegan}));

        initialize();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Log.i("Testing Query", "Success");
                callSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //              if (searchView.isExpanded() && TextUtils.isEmpty(newText)) {
                adapter1.getFilter().filter(newText);
                //callSearch(newText);
                //
                return true;
            }

            public void callSearch(String query) {
                //Do searching
                //Log.i("Testing Query", query);
                adapter1.getFilter().filter(query);

                //Intent intent = new Intent(SearchActivity.this, SearchActivity.class);
                //startActivity(intent);

            }

        });

        return true;
    }

    public static void setQuery(String text) {
        initialQuery = text;
    }

    private void initialize() {
        lvProducts = (ListView)findViewById(R.id.lvProducts);
    }


    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        adapter1 = new MyAdapter(SearchActivity.this, mProductArrayList);
        lvProducts.setAdapter(adapter1);
        adapter1.getFilter().filter(initialQuery);
    }

    // Adapter Class
    public class MyAdapter extends BaseAdapter implements Filterable {

        private ArrayList<Item> mOriginalValues; // Original Values
        private ArrayList<Item> mDisplayedValues;    // Values to be displayed
        LayoutInflater inflater;

        public MyAdapter(Context context, ArrayList<Item> mProductArrayList) {
            this.mOriginalValues = mProductArrayList;
            this.mDisplayedValues = mProductArrayList;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            if (mDisplayedValues != null) {
                return mDisplayedValues.size();
            }

            return 0;

        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        private class ViewHolder {
            LinearLayout ll_container, label_container;
            SquareFrameLayout square;
            ImageView food_image, food_label_1, food_label_2;
            TextView food_name, price;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;

            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.grid_item, null);
                holder.ll_container = (LinearLayout) convertView.findViewById(R.id.ll_container);
                holder.square = (SquareFrameLayout) convertView.findViewById(R.id.square);
                holder.food_image = (ImageView) convertView.findViewById(R.id.food_image);
                holder.food_name = (TextView) convertView.findViewById(R.id.food_name);
                holder.label_container = (LinearLayout) convertView.findViewById(R.id.label_container);
                holder.food_label_1 = (ImageView) convertView.findViewById(R.id.food_label_1);
                holder.food_label_2 = (ImageView) convertView.findViewById(R.id.food_label_2);
                holder.price = (TextView) convertView.findViewById(R.id.price);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.food_name.setText(getResources().getString(mDisplayedValues.get(position).getName()));
            holder.price.setText(getResources().getString(mDisplayedValues.get(position).getPrice()));
            holder.food_image.setImageResource(mDisplayedValues.get(position).getThumbnail());


            if (mDisplayedValues.get(position).getFoodLabels() != null && mDisplayedValues.get(position).getFoodLabelCount() == 2) {
                holder.food_label_1.setImageResource(mDisplayedValues.get(position).getFoodLabels()[0]);
                holder.food_label_2.setImageResource(mDisplayedValues.get(position).getFoodLabels()[1]);

            } else if (mDisplayedValues.get(position).getFoodLabels() != null && mDisplayedValues.get(position).getFoodLabelCount() == 1) {
                holder.food_label_1.setImageResource(mDisplayedValues.get(position).getFoodLabels()[0]);

            }




            // getResources().getDrawable(R.drawable.myimage, getApplicationContext().getTheme())



            holder.ll_container.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    Intent intent = new Intent(SearchActivity.this, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_PARAM_ID, mDisplayedValues.get(position).getId());

                    // BEGIN_INCLUDE(start_activity)
                    /*
                     * Now create an {@link android.app.ActivityOptions} instance using the
                     * {@link ActivityOptionsCompat#makeSceneTransitionAnimation(Activity, Pair[])} factory
                     * method.
                     */
                    @SuppressWarnings("unchecked")
                    ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            SearchActivity.this,

                            // Now we provide a list of Pair items which contain the view we can transitioning
                            // from, and the name of the view it is transitioning to, in the launched activity
                            new Pair<>(v.findViewById(R.id.food_image),
                                    DetailActivity.VIEW_NAME_HEADER_IMAGE),
                            new Pair<>(v.findViewById(R.id.food_name),
                                    DetailActivity.VIEW_NAME_HEADER_TITLE));

                    // Now we can start the Activity, providing the activity options as a bundle
                    ActivityCompat.startActivity(SearchActivity.this, intent, activityOptions.toBundle());

                }
            });



            return convertView;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {

                @SuppressWarnings("unchecked")
                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {

                    mDisplayedValues = (ArrayList<Item>) results.values; // has the filtered values
                    notifyDataSetChanged();  // notifies the data with new filtered values
                }

                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                    ArrayList<Item> FilteredArrList = new ArrayList<Item>();

                    if (mOriginalValues == null) {
                        mOriginalValues = new ArrayList<Item>(mDisplayedValues); // saves the original data in mOriginalValues
                    }

                    /********
                     *
                     *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                     *  else does the Filtering and returns FilteredArrList(Filtered)
                     *
                     ********/
                    if (constraint == null || constraint.length() == 0) {

                        // set the Original result to return
                        results.count = mOriginalValues.size();
                        results.values = mOriginalValues;

                    } else {
                        constraint = constraint.toString().toLowerCase();
                        for (int i = 0; i < mOriginalValues.size(); i++) {
                            String data = getResources().getString(mOriginalValues.get(i).getName()); // This gets the string from the R.string.*

                            if (data.toLowerCase().contains(constraint.toString())) {
                                FilteredArrList.add(new Item(Item.getItem(mOriginalValues.get(i).getId())));
                            }
                        }
                        // set the Filtered result to return
                        results.count = FilteredArrList.size();
                        //Log.i("Check Results Size: ", String.valueOf(results.count));
                        results.values = FilteredArrList;
                    }
                    return results;
                }
            };
            return filter;
        }
    }

}


