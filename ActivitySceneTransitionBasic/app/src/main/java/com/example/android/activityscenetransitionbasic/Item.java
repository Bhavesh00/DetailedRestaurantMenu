package com.example.android.activityscenetransitionbasic;

/**
 * Represents an menu item in our application
 */
public class Item {

    public static Item[] ITEMS = new Item[] {
            new Item(R.string.starters, R.string.guacamole,R.drawable.guacamole, R.string.guacamole_desc,R.string.sixteen_dollar, new int[] {R.drawable.vegan, R.drawable.gluten_free}),
            new Item(R.string.starters, R.string.queso_fundido, R.drawable.queso_fundido, R.string.queso_fundido_desc, R.string.nine_dollar),
            new Item(R.string.starters,R.string.nachos, R.drawable.nachos, R.string.nachos_desc, R.string.eleven_dollar),
            new Item(R.string.entrees, R.string.carne_asada,R.drawable.carne_asada, R.string.carne_asada_desc,R.string.sixteen_dollar,  new int[] {R.drawable.dairy_free}),
            new Item(R.string.entrees, R.string.tampiquena, R.drawable.tampiquena, R.string.tampiquena_desc, R.string.sixteen_dollar),
            new Item(R.string.entrees, R.string.mega_desc, R.drawable.mega_tiacoyo, R.string.mega_desc, R.string.fiften_dollar),
            new Item(R.string.entrees, R.string.fajitas,R.drawable.fajitas_de_pollo_o_res, R.string.fajitas_desc, R.string.fiften_dollar),
            new Item(R.string.entrees, R.string.milanesa, R.drawable.milanesas, R.string.milanesa_desc, R.string.fiften_dollar, new int[] {R.drawable.dairy_free}),
            new Item(R.string.entrees, R.string.pechuga_en_salsa, R.drawable.pechugas_en_salsa_chipotle, R.string.pechuaga_en_salsa_desc, R.string.fiften_dollar),
            new Item(R.string.entrees, R.string.pechuga_plancha,R.drawable.pechuga_a_la_plancha, R.string.pechuga_plancha_desc, R.string.fourteen_dollar, new int[] {R.drawable.dairy_free}),
            new Item(R.string.entrees, R.string.enchiladas, R.drawable.enchiladas_en_salsa_verde, R.string.enchiladas_desc, R.string.twelve_dollar),
            new Item(R.string.entrees, R.string.flautas, R.drawable.flautas, R.string.flautas_desc, R.string.eleven_dollar),
            new Item(R.string.tacos, R.string.taco_americano,R.drawable.taco_americano, R.string.taco_americano_desc, R.string.two_nintey_nine_dollar),
            new Item(R.string.tacos, R.string.taco_mexica, R.drawable.taco_mexica, R.string.taco_mexica_desc, R.string.three_twenty_five_dollar),
            new Item(R.string.tacos, R.string.taco_de_lomo, R.drawable.taco_de_lomo, R.string.taco_de_lomo_desc, R.string.three_forty_five_dollar, new int[] {R.drawable.dairy_free}),
            new Item(R.string.tacos, R.string.taco_de_pescado,R.drawable.taco_de_pescado, R.string.taco_de_pescado_desc, R.string.three_twenty_five_dollar, new int[] {R.drawable.dairy_free}),
            new Item(R.string.tacos, R.string.taco_campesino, R.drawable.taco_campesino, R.string.taco_campesino_desc, R.string.five_twenty_five_dollar, new int[] {R.drawable.dairy_free}),
            new Item(R.string.tacos, R.string.taco_veggie, R.drawable.taco_veggie, R.string.taco_veggie_desc, R.string.two_fifty_dollar, new int[] {R.drawable.vegan, R.drawable.gluten_free}),
            new Item(R.string.cocktails, R.string.fresh_lime_margarita, R.drawable.fresh_lime_margarita, R.string.fresh_lime_margarita_desc, R.string.six_fifty_dollar, new int[] {R.drawable.dairy_free}),
            new Item(R.string.cocktails, R.string.paloma, R.drawable.paloma, R.string.paloma_desc, R.string.six_fifty_dollar, new int[] {R.drawable.dairy_free}),
            new Item(R.string.cocktails, R.string.russo_mexicano, R.drawable.russo_mexicano, R.string.russo_mexicano_desc, R.string.seven_dollar),
            new Item(R.string.cocktails, R.string.seasonal_margarita_avacado, R.drawable.seasonal_margarita___avacado, R.string.seasonal_margarita_avacado_desc, R.string.eleven_dollar, new int[] {R.drawable.dairy_free, R.drawable.vegan}),
            new Item(R.string.cocktails, R.string.seasonal_margarita_blackberry_mint, R.drawable.seasonal_margarita___blackberry_mint, R.string.seasonal_margarita_blackberry_mint_desc, R.string.eight_fifty_dollar, new int[] {R.drawable.dairy_free, R.drawable.vegan}),
            new Item(R.string.cocktails, R.string.mango_habanero, R.drawable.mango_habanero, R.string.mango_habanero_desc, R.string.seven_fifty_dollar, new int[] {R.drawable.dairy_free, R.drawable.vegan}),
            new Item(R.string.cocktails, R.string.seasonal_margarita_watermelon, R.drawable.watermelon_margarita, R.string.seasonal_margarita_watermelon_desc, R.string.six_fifty_dollar, new int[] {R.drawable.dairy_free, R.drawable.vegan}),
            new Item(R.string.desserts, R.string.flan, R.drawable.flan, R.string.flan_desc, R.string.five_dollar),
            new Item(R.string.desserts, R.string.paletas, R.drawable.paletas, R.string.paletas_desc, R.string.three_dollar, new int[] {R.drawable.dairy_free, R.drawable.vegan}),
    };


    public static Item getItem(int id) {
        for (Item item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private final int mtype;
    private final int mName;
    private final int mFoodImage;
    private final int mPrice;
    private final int mDescription;
    private final String mNutrition;
    private final int[] mFoodLabels;


    Item (int type, int name, int foodImage, int desc, int price) {
        mtype = type;
        mName = name;
        mFoodImage = foodImage;
        mPrice = price;
        mDescription = desc;
        mNutrition = "Nutritional Info:";
        mFoodLabels = null;
    }


    Item (int type, int name, int foodImage, int desc, int price, int[] labels) {
        mtype = type;
        mName = name;
        mFoodImage = foodImage;
        mPrice = price;
        mDescription = desc;
        mNutrition = "Nutritional Info:";
        mFoodLabels = labels;
    }

    Item (int type, int name, int foodImage, int desc, int price, String nutr, int[] labels) {
        mtype = type;
        mName = name;
        mFoodImage = foodImage;
        mPrice = price;
        mDescription = desc;
        mNutrition = nutr;
        mFoodLabels = labels;
    }

    public int getMtype() { return mtype; }

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

    public int getPrice() {
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
