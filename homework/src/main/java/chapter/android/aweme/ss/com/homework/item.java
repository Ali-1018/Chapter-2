package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;

public class item extends AppCompatActivity {

    private static List<Message> dataset;
    public static Message mMessage;
    public static int position;
    public static Toast mToast;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.im_list_item);
        try {
            getDataset();
        } catch (Exception e) {
            e.printStackTrace();
        }

        position = Integer.parseInt(getIntent().getStringExtra("position"));
        System.out.println("position: " + position);
        mMessage = dataset.get(position);

        TextView mTitleView = findViewById(R.id.tv_title);
        TextView mContentView = findViewById(R.id.tv_description);
        TextView mTimeView = findViewById(R.id.tv_time);
        ImageView mImageView = findViewById(R.id.robot_notice);

        mTitleView.setText(mMessage.getTitle());
        mContentView.setText(mMessage.getDescription());
        mTimeView.setText(mMessage.getTime());

        mToast = Toast.makeText(item.this, "click " + position, Toast.LENGTH_SHORT);
        mToast.show();
    }

    private void getDataset() throws Exception {
        InputStream assetInput = getAssets().open("data.xml");
        dataset = PullParser.pull2xml(assetInput);
    }

}
