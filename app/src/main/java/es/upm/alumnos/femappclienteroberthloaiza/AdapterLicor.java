package es.upm.alumnos.femappclienteroberthloaiza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import es.upm.alumnos.femappclienteroberthloaiza.model.Result;

/**
 * Created by Usuario on 29/10/2017.
 */

public class AdapterLicor extends ArrayAdapter {

    private Context APPContext;
    private int layoutID;
    private ArrayList<Result> result;

    public AdapterLicor(Context context, int layoutID, List<Result> result) {
        super(context, layoutID, result);
        this.setAPPContext(context);
        this.setLayoutID(layoutID);
        this.setResult((ArrayList<Result>) result);
    }

    public Context getAPPContext() {
        return APPContext;
    }

    private void setAPPContext(Context APPContext) {
        this.APPContext = APPContext;
    }

    public int getLayoutID() {
        return layoutID;
    }

    private void setLayoutID(int layoutID) {
        this.layoutID = layoutID;
    }

    public ArrayList<Result> getResult() {
        return result;
    }

    private void setResult(ArrayList<Result> result) {
        this.result = result;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout view;

        if (null != convertView)
            view = (LinearLayout) convertView;
        else {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = (LinearLayout) layoutInflater.inflate(this.getLayoutID(), parent, false);
        }

        ImageView imgLicor = (ImageView) view.findViewById(R.id.licorImg);
        imgLicor.setTag(this.getResult().get(position));
        Picasso.with(this.getContext())
                .load(this.getResult().get(position).getImage_thumb_url())
                .into(imgLicor);

        TextView ProducerName = (TextView) view.findViewById(R.id.Producer_name);
        ProducerName.setText("Company : "+this.getResult().get(position).getProducer_name());
        TextView Name = (TextView) view.findViewById(R.id.Name);
        Name.setText(this.getResult().get(position).getName());//Name product
        TextView Tag = (TextView) view.findViewById(R.id.Tag);
        Tag.setText("Description: "+this.getResult().get(position).getTags());
        TextView Origin = (TextView) view.findViewById(R.id.Origin);
        Origin.setText("Country: "+this.getResult().get(position).getOrigin());

        return view;
    }
}
