package update.hc.com.updateonlion;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import update.hc.com.updateonlion.manager.AppDownloadManager;
import update.hc.com.updateonlion.manager.UpdateManager;

public class MainActivity extends AppCompatActivity {
    UpdateManager updateManager = new UpdateManager(this);
    String[] permision = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    public static AppDownloadManager.AndroidOInstallPermissionListener sListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reQuestPermiss();

        findViewById(R.id.button_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateManager.checkUpdateInfo();
            }
        });


    }

    private void reQuestPermiss() {
        int a = ActivityCompat.checkSelfPermission(this,
                permision[0]);
        int b = ActivityCompat.checkSelfPermission(this,
                permision[1]);
        if (Build.VERSION.SDK_INT > 23 && a != PackageManager.PERMISSION_GRANTED && b != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, permision, 1);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
