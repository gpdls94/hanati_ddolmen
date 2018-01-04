package com.hanati.ddolmen;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {

    private static final int MY_PERMISSION_CAMERA = 1111;

    ImageView imageView;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        initView();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA);

                if(permissionCheck == PackageManager.PERMISSION_DENIED) {

                } else {
                    ActivityCompat.requestPermissions(getParent(), new String[] {Manifest.permission.CAMERA}, 1);
                }*/
                Intent it = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivityForResult(it, 0);

            }
        });
    }

    void initView(){
        imageView = (ImageView)findViewById(R.id.img_selected);
        btn_send = (Button)findViewById(R.id.btn_send);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("aaaaaa", "requestCode : " + String.valueOf(requestCode));
        Log.e("aaaaaa", "resultCode : " + String.valueOf(resultCode));
        Log.e("aaaaaa", "data : " + data.getData());
        //imageView.setImageURI(data.getData());




    }


}
