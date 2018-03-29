package in.smartparking.payment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SelectParkingTime extends AppCompatActivity {

    Spinner plan ;
    TextView summary;
    Button pay;
    int pos;

    String arr[] = {
            "Select Time Slot",
            "6:00 A.M to 8:00 A.M",
            "8:00 A.M to 10:00 A.M",
            "10:00 A.M to 12:00 P.M",
            "12:00 P.M to 2:00 P.M",
            "2:00 P.M to 4:00 P.M",
            "4:00 P.M to 6:00 P.M",
            "6:00 P.M to 8:00 P.M",
            "8:00 P.M to 10:00 P.M",
            "10:00 P.M to 12:00 P.M"
                    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_parking_time);

        plan = findViewById(R.id.plan);
        summary = findViewById(R.id.summary);
        pay = findViewById(R.id.pay);
        pay.setEnabled(false);
        ArrayAdapter aa =  new ArrayAdapter(this,android.R.layout.simple_spinner_item,arr);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        plan.setAdapter(aa);
        plan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    summary.setText("Please select your Timing First");
                }else{
                    summary.setText("You have to Pay Rs 20.");
                    pay.setEnabled(true);
                    pos=i;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pay(pos);
            }
        });

    }

    void pay(int pos){
        Intent intent= new Intent(this, QRCodeScreen.class);
        intent.putExtra("plan",pos);
        startActivity(intent);

    }

}
