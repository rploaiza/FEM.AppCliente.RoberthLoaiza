package es.upm.alumnos.femappclienteroberthloaiza.activities;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import es.upm.alumnos.femappclienteroberthloaiza.AdapterLicor;
import es.upm.alumnos.femappclienteroberthloaiza.R;
import es.upm.alumnos.femappclienteroberthloaiza.model.Result;
import es.upm.alumnos.femappclienteroberthloaiza.model.ResultContract;

public class MainActivity extends Activity {

    public static final String CONTENT_URI = "content://es.upm.alumnos.femapprestroberthloaiza.provider";

    protected static final String LICORS_ENTITY = "licors";
    protected static final String LICORS = "licor";

    private EditText nombreLicor;
    private Button buttonSearch;
    private ListView licorsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreLicor = (EditText) findViewById(R.id.nombreLicor);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        licorsList = (ListView) findViewById((R.id.licorsList));

        getLicors();

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLicors();
            }
        });

        licorsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Result result = (Result) view.findViewById(R.id.licorImg).getTag();
                Intent intent = new Intent(getApplicationContext(), LicorsActivity.class);
                intent.putExtra(LICORS, result);
                startActivity(intent);
            }
        });
    }

    private void getLicors() {
        MainAsyncTask myTask = new MainAsyncTask() {
            @Override
            protected void onPreExecute() {
                this.setNameProduct(String.valueOf(nombreLicor.getText()));
            }

            @Override
            protected Cursor doInBackground(ListView... ListViews) {
                Uri uri = Uri.parse(CONTENT_URI + "/" + LICORS_ENTITY + "/" + this.getNameProduct());
                ContentResolver contentResolver = getContentResolver();
                this.setListView(ListViews[0]);
                return contentResolver.query(uri, null, null, null, null);
            }

            @Override
            protected void onPostExecute(Cursor cursor) {
                if (cursor != null) {
                    ArrayList<Result> results = new ArrayList<>();
                    if (cursor.moveToFirst()) {
                        while (!cursor.isAfterLast()) {
                            int ID = cursor.getInt(cursor.getColumnIndex(ResultContract.licorsTable.COLUMN_NAME_LICORS_ID));
                            String name = cursor.getString(cursor.getColumnIndex(ResultContract.licorsTable.COLUMN_NAME_LICORS_NAME));
                            String tags = cursor.getString(cursor.getColumnIndex(ResultContract.licorsTable.COLUMN_NAME_LICORS_TAGS));
                            int price = cursor.getInt(cursor.getColumnIndex(ResultContract.licorsTable.COLUMN_NAME_LICORS_PRICE_IN_CENTS));
                            String category = cursor.getString(cursor.getColumnIndex(ResultContract.licorsTable.COLUMN_NAME_LICORS_PRIMARY_CATEGORY));
                            String origin = cursor.getString(cursor.getColumnIndex(ResultContract.licorsTable.COLUMN_NAME_LICORS_ORIGIN));
                            int package_vol = cursor.getInt(cursor.getColumnIndex(ResultContract.licorsTable.COLUMN_NAME_LICORS_PACKAGE_VOL_MIL));
                            int alcohol = cursor.getInt(cursor.getColumnIndex(ResultContract.licorsTable.COLUMN_NAME_LICORS_ALCOHOL_CONT));
                            String producer = cursor.getString(cursor.getColumnIndex(ResultContract.licorsTable.COLUMN_NAME_LICORS_PRODUCER_NAME));
                            String imagen = cursor.getString(cursor.getColumnIndex(ResultContract.licorsTable.COLUMN_NAME_LICORS_IMAGE_THUMB_URL));
                            String varital = cursor.getString(cursor.getColumnIndex(ResultContract.licorsTable.COLUMN_NAME_LICORS_VARIETAL));
                            String style = cursor.getString(cursor.getColumnIndex(ResultContract.licorsTable.COLUMN_NAME_LICORS_STYLE));

                            Result result = new Result(ID, name, tags, price, category, origin, package_vol, alcohol,
                                    producer, imagen, varital, style);

                            results.add(result);
                            cursor.moveToNext();
                        }
                        cursor.close();
                    }
                    AdapterLicor adapterLicor = new AdapterLicor(getApplicationContext(), R.layout.activity_listview, results);
                    this.getListView().setAdapter(adapterLicor);
                }else
                    Toast.makeText(getBaseContext() , R.string.strError, Toast.LENGTH_LONG).show();
            }
        };

        myTask.execute((ListView) findViewById(R.id.licorsList));
    }
}
