package com.dhh.knowledge.jni;

/**
 * Created by DHH on 2018/3/19.
 * 页面：
 */

public class JNI {
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary ( "native-lib" );
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
