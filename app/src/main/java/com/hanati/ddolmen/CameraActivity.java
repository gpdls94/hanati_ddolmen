package com.hanati.ddolmen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class CameraActivity extends AppCompatActivity {

    ImageView imageView;
    ImageButton btn_send;
    LinearLayout loading;
    ImageView loading_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        initView();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loading.setVisibility(View.VISIBLE);

                GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(loading_icon);
                Glide.with(CameraActivity.this).load(R.drawable.load2).into(imageViewTarget);

                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        Intent it = new Intent(getApplicationContext(), ResultActivity.class);
                        startActivity(it);

                        loading.setVisibility(View.GONE);
                    }
                };
                handler.postDelayed(runnable, 1800);
            }
        });
    }

    void initView(){
        imageView = (ImageView)findViewById(R.id.img_selected);
        btn_send = (ImageButton)findViewById(R.id.btn_send);
        loading = (LinearLayout)findViewById(R.id.loading);
        loading_icon = (ImageView)findViewById(R.id.icon);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Log.e("aaaaaa", data.getDataString());
        imageView.setImageURI(data.getData());
    }
}
