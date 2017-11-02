package es.upm.alumnos.femappclienteroberthloaiza.activities;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

/**
 * Created by Usuario on 29/10/2017.
 */

public abstract class LicorsAsyncTask extends AsyncTask<ContentValues, Void, Uri> {
    private Context context;
    private int licorId;

    public LicorsAsyncTask(int licorId, Context context) {
        this.licorId = licorId;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public int getLicorId() {
        return licorId;
    }

    protected abstract void onPreExecute();

    protected abstract Uri doInBackground(ContentValues... contentValues);

    protected abstract void onPostExecute(Uri uri);
}

