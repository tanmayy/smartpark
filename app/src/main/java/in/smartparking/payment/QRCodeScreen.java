package in.smartparking.payment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class QRCodeScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_screen);

        Intent intent = getIntent();
        int plan = intent.getIntExtra("plan",0);
        ImageView qr = findViewById(R.id.qr);

        String link = "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data={\"plan\":"+plan+",\"paid\":true}";

        Picasso.get().load(link).into(qr);
    }
}
