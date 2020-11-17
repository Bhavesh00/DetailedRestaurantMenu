package com.example.android.activityscenetransitionbasic;

/**
 * Represents an menu item in our application
 */
public class Item {

    public static Item[] ITEMS = new Item[] {
            new Item(R.string.guacamole,R.drawable.guacamole, R.string.guacamole_desc, new int[] {R.drawable.vegan, R.drawable.gluten_free}),
            new Item(R.string.queso_fundido, R.drawable.queso_fundido, R.string.queso_fundido_desc),
            new Item(R.string.nachos, R.drawable.nachos, R.string.nachos_desc),
            new Item(R.string.carne_asada,R.drawable.carne_asada, R.string.carne_asada_desc,  new int[] {R.drawable.dairy_free}),
            new Item(R.string.tampiquena, R.drawable.tampiquena, R.string.tampiquena_desc),
            new Item(R.string.mega_desc, R.drawable.mega_tiacoyo, R.string.mega_desc),
            new Item(R.string.fajitas,R.drawable.fajitas_de_pollo_o_res, R.string.fajitas_desc),
            new Item(R.string.milanesa, R.drawable.milanesas, R.string.milanesa_desc, new int[] {R.drawable.dairy_free}),
            new Item(R.string.pechuga_en_salsa, R.drawable.pechugas_en_salsa_chipotle, R.string.pechuaga_en_salsa_desc),
            new Item(R.string.pechuga_plancha,R.drawable.pechuga_a_la_plancha, R.string.pechuga_plancha_desc, new int[] {R.drawable.dairy_free}),
            new Item(R.string.enchiladas, R.drawable.enchiladas_en_salsa_verde, R.string.enchiladas_desc),
            new Item(R.string.flautas, R.drawable.flautas, R.string.flautas_desc),
            new Item(R.string.taco_americano,R.drawable.taco_americano, R.string.taco_americano_desc),
            new Item(R.string.taco_mexica, R.drawable.taco_mexica, R.string.taco_mexica_desc),
            new Item(R.string.taco_de_lomo, R.drawable.taco_de_lomo, R.string.taco_de_lomo_desc, new int[] {R.drawable.dairy_free}),
            new Item(R.string.taco_de_pescado,R.drawable.taco_de_pescado, R.string.taco_de_pescado_desc, new int[] {R.drawable.dairy_free}),
            new Item(R.string.taco_campesino, R.drawable.taco_campesino, R.string.taco_campesino_desc, new int[] {R.drawable.dairy_free}),
            new Item(R.string.taco_veggie, R.drawable.taco_veggie, R.string.taco_veggie_desc, new int[] {R.drawable.vegan, R.drawable.gluten_free}),
            new Item(R.string.fresh_lime_margarita, R.drawable.fresh_lime_margarita, R.string.fresh_lime_margarita_desc, new int[] {R.drawable.dairy_free}),
            new Item(R.string.paloma, R.drawable.paloma, R.string.paloma_desc, new int[] {R.drawable.dairy_free}),
            new Item(R.string.russo_mexicano, R.drawable.russo_mexicano, R.string.russo_mexicano_desc),
            new Item(R.string.seasonal_margarita_avacado, R.drawable.seasonal_margarita___avacado, R.string.seasonal_margarita_avacado_desc, new int[] {R.drawable.dairy_free, R.drawable.vegan}),
            new Item(R.string.seasonal_margarita_blackberry_mint, R.drawable.seasonal_margarita___blackberry_mint, R.string.seasonal_margarita_blackberry_mint_desc, new int[] {R.drawable.dairy_free, R.drawable.vegan}),
            new Item(R.string.mango_habanero, R.drawable.mango_habanero, R.string.mango_habanero_desc, new int[] {R.drawable.dairy_free, R.drawable.vegan}),
            new Item(R.string.seasonal_margarita_watermelon, R.drawable.watermelon_margarita, R.string.seasonal_margarita_watermelon_desc, new int[] {R.drawable.dairy_free, R.drawable.vegan}),
            new Item(R.string.flan, R.drawable.flan, R.string.flan_desc),
            new Item(R.string.paletas, R.drawable.paletas, R.string.paletas_desc, new int[] {R.drawable.dairy_free, R.drawable.vegan}),
    };


    public static Item getItem(int id) {
        for (Item item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private final int mName;
    private final int mFoodImage;
    private final String mPrice;
    private final int mDescription;
    private final String mNutrition;
    private final int[] mFoodLabels;

    Item (int name, int foodImage, int desc) {
        mName = name;
        mFoodImage = foodImage;
        mPrice = "$10.00";
        mDescription = desc;
        mNutrition = "Nutritional Info:";
        mFoodLabels = null;
    }

    Item (int name, int foodImage, int desc, int[] labels) {
        mName = name;
        mFoodImage = foodImage;
        mPrice = "$10.00";
        mDescription = desc;
        mNutrition = "Nutritional Info:";
        mFoodLabels = labels;
    }

    Item (int name, int foodImage, int desc, String price, String nutr, int[] labels) {
        mName = name;
        mFoodImage = foodImage;
        mPrice = price;
        mDescription = desc;
        mNutrition = nutr;
        mFoodLabels = labels;
    }

    public int getId() {
        return mName + mFoodImage;
    }

    public int getName() {
        return mName;
    }

    public int getPhoto() {
        return mFoodImage;
    }

    public int getThumbnail() {
        return mFoodImage;
    }

    public int getDescription() {
        return mDescription;
    }

    public String getPrice() {
        return mPrice;
    }

    public String getNutrition() {
        return mNutrition;
    }

    public int[] getFoodLabels() {
        return mFoodLabels;
    }

    public int getFoodLabelCount() {
        return mFoodLabels.length;
    }
}
