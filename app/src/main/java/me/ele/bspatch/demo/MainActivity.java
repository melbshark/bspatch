package me.ele.bspatch.demo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import me.ele.bspatch.Patcher;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String oldApkPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/eleme_5.12.1.apk";
        final String newApkPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/eleme_5.12.2-patch.apk";
        final String patch = Environment.getExternalStorageDirectory().getAbsolutePath() + "/diff.apk";

        new Thread() {

            @Override
            public void run() {
                super.run();
                Log.e(TAG, "start patch");
                final int result = Patcher.patch(oldApkPath, newApkPath, patch);
                Log.e(TAG, "end patch-->" + result);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result == 0) {
                            Toast.makeText(MainActivity.this, "patch success-->" + newApkPath, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "sadly, patch fails", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }.start();
    }
}
