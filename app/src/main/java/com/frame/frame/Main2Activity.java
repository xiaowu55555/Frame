package com.frame.frame;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.frame.library.base.WebViewActivity;

import java.net.URL;

public class Main2Activity extends WebViewActivity {

    public static void start(Context context, String url) {
        Intent starter = new Intent(context, Main2Activity.class);
        starter.putExtra(Intent.EXTRA_ORIGINATING_URI, url);
        context.startActivity(starter);
    }

    @Override
    protected ViewGroup getWebContentView() {
        FrameLayout frameLayout = findViewById(R.id.fl_content);
        return frameLayout;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main2;
    }
}
