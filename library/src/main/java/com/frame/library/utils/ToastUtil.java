package com.frame.library.utils;

import android.app.Application;
import android.widget.Toast;

import com.frame.library.app.BaseApplication;

public class ToastUtil {

    private static Toast toast;

    public static void showToast(String message) {
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.getInstance().getApplicationContext(), message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();
    }
}
