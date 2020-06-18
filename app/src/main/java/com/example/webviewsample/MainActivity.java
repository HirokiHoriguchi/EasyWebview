package com.example.webviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;

import static com.example.webviewsample.Data.load_URL;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private WebView webView;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialaizing();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN
                && keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                finish();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private void initialaizing() {
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:
                setContentView(R.layout.web);

                webView = findViewById(R.id.web_view);

                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setDomStorageEnabled(true);

                getWindow().setFlags(
                        WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                        WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);

                webView.loadUrl(load_URL);

                break;

            case R.id.button_2:
                Uri uri = Uri.parse(load_URL);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                break;
            default:
                break;
        }
    }
}
