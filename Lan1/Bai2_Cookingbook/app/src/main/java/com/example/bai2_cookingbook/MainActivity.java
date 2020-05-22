package com.example.bai2_cookingbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Adapter_recipe adapter_recipe;
    List<recipe> recipeList;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.mListView);

        //
        recipeList = new ArrayList<>();
        recipeList.add(new recipe(R.drawable.mango,
                "Pineapple, Mango and Cucumber Salad with Peanut Sauce ",
                "https://www.cookingchanneltv.com/recipes/pineapple-mango-and-cucumber-salad-with-peanut-sauce-rojak-2827025"));
        recipeList.add(new recipe(R.drawable.pork,
                "Slow Cooker Shredded Pork",
                "https://www.cookingchanneltv.com/recipes/kelsey-nixon/slow-cooker-shredded-pork-1961553"));

        recipeList.add(new recipe(R.drawable.chocolate,
                "Chocolate Fondue",
                "https://www.cookingchanneltv.com/recipes/rev-run/chocolate-fondue-2795116"));
        recipeList.add(new recipe(R.drawable.honey,
                "Pecorino and Honey Dip",
                "https://www.cookingchanneltv.com/recipes/debi-mazar-and-gabriele-corcos/pecorino-and-honey-dip-1960990"));
        recipeList.add(new recipe(R.drawable.sandies,
                "Pecan Sandies",
                "https://www.cookingchanneltv.com/recipes/pecan-sandies-1947188"));
        recipeList.add(new recipe(R.drawable.tower,
                "Choux Pastry Eiffel Tower",
                "https://www.cookingchanneltv.com/recipes/choux-pastry-eiffel-tower-3443535"));
        recipeList.add(new recipe(R.drawable.egg,
                "Scotch Eggs",
                "https://www.cookingchanneltv.com/recipes/scotch-eggs-2108654"));
        recipeList.add(new recipe(R.drawable.soda,
                "Apricot Spritzer",
                "https://www.cookingchanneltv.com/recipes/bobby-flay/apricot-spritzer-2403219"));
        recipeList.add(new recipe(R.drawable.cocktail,
                "Beefsteak Collins Cocktail",
                "https://www.cookingchanneltv.com/recipes/beefsteak-collins-cocktail-2109045"));

        //
        adapter_recipe = new Adapter_recipe(this, R.layout.item, recipeList);
        mListView.setAdapter(adapter_recipe);


    }

    public void a() {

        // final WebView webView = findViewById(R.id.mWebview);
        // WebSettings webSettings = webView.getSettings();
        // webSettings.setJavaScriptEnabled(true);

        // webView.loadUrl("https://www.cookingchanneltv.com/recipes/pineapple-mango-and-cucumber-salad-with-peanut-sauce-rojak-2827025");

        // final ImageView imageView = (ImageView) findViewById(R.id.mImageview);

        //  imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isImageFitToScreen) {
//                    isImageFitToScreen = false;
//                    imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//                    imageView.setAdjustViewBounds(true);
//                } else {
//                    isImageFitToScreen = true;
//                    imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//                }
//            }
//        });
    }

}
