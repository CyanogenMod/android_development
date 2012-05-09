/*
 * Copyright (C) 2008 The Android Open Source Project
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

package com.example.android.simplejni_aprof;
import android.util.Log;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SimpleJNI extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        int sum = Native.add(10, 15);
        tv.setText("fib(10 + 15) = " + Integer.toString(sum));
        setContentView(tv);
        Log.d("aprof","onCreate");
    }
    public void onDestroy() {
        super.onDestroy();
        Log.d("aprof","onDestory");
    }

     public void onRestart(){super.onRestart();Log.d("aprof","onRestart");}

     public void onResume(){super.onResume();Log.d("aprof","onResume");}

     public void onPause(){super.onPause();Log.d("aprof","onPause");}

     public void onStop(){super.onStop();Log.d("aprof","onStop");}

}

class Native {
    static {
        // The runtime will add "lib" on the front and ".o" on the end of
        // the name supplied to loadLibrary.
        System.loadLibrary("simplejni-aprof");
    }

    static native int add(int a, int b);
}
