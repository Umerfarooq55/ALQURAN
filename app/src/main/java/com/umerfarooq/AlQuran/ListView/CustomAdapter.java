package com.umerfarooq.AlQuran.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.arcmenu.lib.RayMenu;

import java.util.ArrayList;

import info.androidhive.introslider.R;




/**
 * Created by anupamchugh on 09/02/16.
 */
public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener,View.OnTouchListener{

    private ArrayList<DataModel> dataSet;
    Context mContext;
    final static float STEP = 200;
    TextView mytv;
    float mRatio = 1.0f;
    int mBaseDist;
    float mBaseRatio;
    float fontsize = 13;
    Spinner mSpinner;
    // View lookup cache
    TextView t;

    static final int[] ITEM_DRAWABLES = { R.drawable.facebook,
            R.drawable.facebook, R.drawable.facebook, R.drawable.facebook,
            R.drawable.facebook };



    private static class ViewHolder {
        RayMenu rayMenu;
        TextView txtName;
        TextView txtType;
        TextView txtVersion;
        ImageView info;
        RelativeLayout rl;
        Spinner mSpinner;

        protected Dataholder data;
    }



    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;

    }


    @Override
    public void onClick(View v) {


        int position=(Integer) v.getTag();
        Object object= getItem(position);
        DataModel dataModel=(DataModel)object;




        switch (v.getId())
        {

           // case R.id.item_info:
//
               // Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                      //  .setAction("No action", null).show();

              //  break;


        }


    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {


            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
           // viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.version_number);
          //  viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);
            viewHolder.rayMenu = (RayMenu)convertView. findViewById(R.id.ray_menu);
            viewHolder.rl=(RelativeLayout)convertView.findViewById(R.id.relative);
            viewHolder.mSpinner=(Spinner) convertView.findViewById(R.id.healthy_spinner);

            final int itemCount = ITEM_DRAWABLES.length;

            for (int ib = 0; ib < itemCount; ib++) {
                ImageView item = new ImageView(mContext);
                item.setImageResource(ITEM_DRAWABLES[ib]);

                final int positionr = ib;
                viewHolder. rayMenu.addItem(item, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (positionr == 0) {

                        } else if (positionr == 1) {

                        } else if (positionr == 2) {

                        } else if (positionr == 3) {

                        } else {

                        }
                    }
                });

            }
viewHolder.rl.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       viewHolder.rayMenu.setRotation(0);
viewHolder.rayMenu.set();
    }
});
            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;
        viewHolder.data = new Dataholder(mContext);
        viewHolder.mSpinner = (Spinner) convertView.findViewById(R.id.healthy_spinner);
      viewHolder.mSpinner.setAdapter(viewHolder.data.getAdapter());
///
t=viewHolder.txtName;
        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtType.setText(dataModel.getType());
       // viewHolder.txtVersion.setText(dataModel.getVersion_number());
     //   viewHolder.info.setOnClickListener(this);
    //    viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }


    public boolean onTouchEvent(MotionEvent event) {
        if (event.getPointerCount() == 2) {
            int action = event.getAction();
            int pureaction = action & MotionEvent.ACTION_MASK;
            if (pureaction == MotionEvent.ACTION_POINTER_DOWN) {
                mBaseDist = getDistance(event);
                mBaseRatio = mRatio;
            } else {
                float delta = (getDistance(event) - mBaseDist) / STEP;
                float multi = (float) Math.pow(2, delta);
                mRatio = Math.min(1024.0f, Math.max(0.1f, mBaseRatio * multi));
                mytv.setTextSize(mRatio + 13);
            }
        }
        return true;
    }

    int getDistance(MotionEvent event) {
        int dx = (int) (event.getX(0) - event.getX(1));
        int dy = (int) (event.getY(0) - event.getY(1));
        return (int) (Math.sqrt(dx * dx + dy * dy));
    }

    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

}
