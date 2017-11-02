package es.upm.alumnos.femappclienteroberthloaiza.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import es.upm.alumnos.femappclienteroberthloaiza.CommetLicorDialog;
import es.upm.alumnos.femappclienteroberthloaiza.R;
import es.upm.alumnos.femappclienteroberthloaiza.model.Result;


/**
 * Created by Usuario on 29/10/2017.
 */

public class LicorsActivity extends AppCompatActivity {

    protected static final String LICOR_STATE = "licorState";

    private TextView descrip1, descrip2, descrip3;
    private Button comentar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.initView((Result) getIntent().getSerializableExtra(MainActivity.LICORS));
    }

    private void initView(Result result) {
        getSupportActionBar().setTitle(result.getName());
        ImageView imageView = (ImageView) findViewById(R.id.licorImg);
        imageView.setTag(result);
        Picasso.with(getApplicationContext())
                .load(result.getImage_thumb_url())
                .into(imageView);

        descrip2 = (TextView) findViewById(R.id.descrip2);
        descrip2.setMovementMethod(new ScrollingMovementMethod());
        descrip2.setText("Company : " + result.getProducer_name() + "\n\n" +
                "Description : " + result.getTags() + "\n\n" +
                "Country: " + result.getOrigin());

        descrip1 = (TextView) findViewById(R.id.descrip1);
        descrip1.setMovementMethod(new ScrollingMovementMethod());
        descrip1.setText("Price (cents): " + result.getPrice_in_cents() + "\n\n" +
                "Category : " + result.getPrimary_category() + "\n\n" +
                "Package Vol: " + result.getPackage_unit_volume_in_milliliters() + "\n\n");

        descrip3 = (TextView) findViewById(R.id.descrip3);
        descrip3.setMovementMethod(new ScrollingMovementMethod());
        descrip3.setText("Alcohol cont: " + result.getAlcohol_content() + "\n\n" +
                "Varietal: " + result.getVarietal() + "\n\n" +
                "Style: " + result.getStyle() + "\n\n");

        comentar = (Button) findViewById(R.id.Comment);
        comentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CommetLicorDialog().show(getFragmentManager(), "COMMET DIALOG");
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ImageView imgLicor = (ImageView) findViewById(R.id.licorImg);
        outState.putSerializable(LICOR_STATE, (Result) imgLicor.getTag());

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Result result = (Result) savedInstanceState.getSerializable(LICOR_STATE);
        this.initView(result);
    }

}
