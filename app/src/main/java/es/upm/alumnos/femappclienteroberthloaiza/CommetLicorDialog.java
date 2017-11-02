package es.upm.alumnos.femappclienteroberthloaiza;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import es.upm.alumnos.femappclienteroberthloaiza.activities.LicorsActivity;
import es.upm.alumnos.femappclienteroberthloaiza.activities.LicorsAsyncTask;
import es.upm.alumnos.femappclienteroberthloaiza.activities.MainActivity;
import es.upm.alumnos.femappclienteroberthloaiza.model.Result;

/**
 * Created by Usuario on 1/11/2017.
 */

public class CommetLicorDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final LicorsActivity main = (LicorsActivity) getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(View.inflate(main, R.layout.save_commet, null))
                .setTitle("Licors")
                .setPositiveButton(
                        R.string.save,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                String save = ((EditText) CommetLicorDialog.this.getDialog().findViewById(R.id.commet))
                                        .getText().toString();
                                comment(save);
                                Toast.makeText(getContext() , R.string.saveComment, Toast.LENGTH_LONG).show();
                            }
                        }
                )
                .setNegativeButton(
                        R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                CommetLicorDialog.this.getDialog().cancel();
                            }
                        }
                );

        return builder.create();
    }


    private void comment(String comment) {
        LicorsActivity licorsActivity = (LicorsActivity) getActivity();
        ImageView imgLicor = (ImageView) licorsActivity.findViewById(R.id.licorImg);

        Result result = (Result) imgLicor.getTag();
        ContentValues contentValues = new ContentValues();
        contentValues.put("comment", comment);
        licorsActivity.getApplicationContext();

        LicorsAsyncTask myTask = new LicorsAsyncTask(result.getId(), licorsActivity.getApplicationContext()) {
            @Override
            protected void onPreExecute() {
            }

            @Override
            protected Uri doInBackground(ContentValues... contentValues) {
                Uri uri = Uri.parse(MainActivity.CONTENT_URI + "/" + "comments" + "/" + this.getLicorId());
                ContentResolver contentResolver = this.getContext().getContentResolver();
                return contentResolver.insert(uri, contentValues[0]);
            }

            @Override
            protected void onPostExecute(Uri uri) {

            }
        };

        myTask.execute(contentValues);
    }
}

