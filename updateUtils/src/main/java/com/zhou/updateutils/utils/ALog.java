package com.zhou.updateutils.utils;

import android.util.Log;

import com.zhou.updateutils.core.AllenChecker;


/**
 * Created by allenliu on 2017/8/16.
 */

public class ALog {
    public static void e(String msg) {
        if (AllenChecker.isDebug()) {
            if (msg != null && !msg.isEmpty())
                Log.e("Allen Checker", msg);
        }
    }
}
