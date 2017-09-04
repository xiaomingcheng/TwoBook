package commerce.photoview;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_dianWo;
    private Dialog photoDialog;
    private ImageView iv_dialog_photo;
    private PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        bt_dianWo = (Button) findViewById(R.id.bt_dianWo);

        bt_dianWo.setOnClickListener(this);

        initPhotoDialog();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_dianWo:

                Glide.with(this).load("http://imgsrc.baidu.com/imgad/pic/item/267f9e2f07082838b5168c32b299a9014c08f1f9.jpg").into(iv_dialog_photo);
                mAttacher = new PhotoViewAttacher(iv_dialog_photo);
                mAttacher.update();
                photoDialog.show();
                break;
        }
    }

    //初始化照片选择器Dialog
    private void initPhotoDialog() {

        photoDialog = new Dialog(this, R.style.DialogTheme);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_photo, null);
        photoDialog.setContentView(dialogView);

        Window dialogWindow = photoDialog.getWindow();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (dm.widthPixels * 0.9);
        dialogWindow.setGravity(Gravity.CENTER);

        iv_dialog_photo = (ImageView) dialogView.findViewById(R.id.iv_dialog_photo);
    }

}
