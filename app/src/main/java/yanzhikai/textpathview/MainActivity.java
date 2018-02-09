package yanzhikai.textpathview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import yanzhikai.textpath.ArrowPainter;
import yanzhikai.textpath.TextPathView1;
import yanzhikai.textpath.TextPathView2;

public class MainActivity extends AppCompatActivity {
    private SeekBar sb_progress;
    private TextPathView2 tvp2;
    private TextPathView1 tpv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb_progress = findViewById(R.id.sb_progress);
        tvp2 = findViewById(R.id.tpv2);
        tpv = findViewById(R.id.tpv);
        tpv.setListener(new ArrowPainter());
        sb_progress.setMax(1000);
        sb_progress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvp2.drawPath(progress / 1000f);
                tpv.drawPath(progress / 1000f);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                tpv.setText("sad");
                Log.d("TestView", "onStopTrackingTouch: ");
            }
        });
    }
}
