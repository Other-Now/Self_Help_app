package net.penguincoders.doit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecMainAdapter extends RecyclerView.Adapter<RecMainAdapter.ViewHolder>{

    private static final String TAG = "RecMainAdapter";
    private ArrayList<RecItem> recItem = new ArrayList<>();
    private Context mContext;
    private String parentActivity;

    public RecMainAdapter(Context mContext, String parentActivity) {
        this.mContext = mContext;
        this.parentActivity = parentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rec_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.txtRec.setText(recItem.get(position).getName());
        holder.imgRec.setImageResource(recItem.get(position).getImg());

        holder.parentRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (recItem.get(position).getId()) {
                    case 1:
                        Intent intent1 = new Intent(mContext, MainActivity.class);
                        mContext.startActivity(intent1);
                        break;
                    case 2:
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext,R.style.AlertDialogTheme);  //Here builder would be of anderoidx.appcombat type
                        builder.setTitle(R.string.know_your_med);
                        builder.setMessage("Do you wish to know about your med?");
                        builder.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //TODO: Show the Website
                                Intent intent2 = new Intent(mContext, KnowYourMedActivity.class);
                                intent2.putExtra("url","https://www.drugs.com/drug_information.html");  //it will pass the web address to be opened in webactivity.
                                mContext.startActivity(intent2);
                            }
                        });
                        builder.create().show();
                        break;
                    case 3:
                        Intent intent3 = new Intent(mContext, FirstAidTipsActivity.class);
                        mContext.startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(mContext, HealthTipsActivity.class);
                        mContext.startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(mContext, CoronaTipsActivity.class);
                        mContext.startActivity(intent5);
                        break;
                    case 6:
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(mContext,R.style.AlertDialogTheme);  //Here builder would be of anderoidx.appcombat type
                        builder2.setTitle(R.string.nearby_hospitals);
                        builder2.setMessage("If you wish to search for hospitals in google map\n" +
                                "Click on the VISIT button");
                        builder2.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder2.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //TODO: Show the Website
                                Intent intent6 = new Intent(mContext, NearbyHospitalsActivity.class);
                                intent6.putExtra("url","https://www.google.com/search?q=hospital+near+me&oq=hospital&aqs=chrome.1.69i57j0l3j69i65.3448j0j7&client=ms-android-oppo&sourceid=chrome-mobile&ie=UTF-8#istate=lrl:mlt&rltbs=lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!1m4!1u16!2m2!16m1!1e1!1m4!1u16!2m2!16m1!1e2!2m1!1e2!2m1!1e3!2m7!1e16!4m2!16m1!1e1!4m2!16m1!1e2,lf:1,lf_ui:2&rlvp=oll:0,0;ospn:0.0060816999999993016,0.012623000000004936;oz:0;sll:25.423948565217657,86.1398827372612;sspn:0.023333066877288644,0.01544952392578125;fll:25.423948565217657,86.1398827372612;fspn:0.023333066877288644,0.01544952392578125;fz:15&trex=m_r:1,m_t:gwp,rc_q:hospital%2520near%2520me,rc_ui:2,ru_gwp:0%252C6,ru_q:hospital%2520near%2520me,trex_id:H2VV0e");  //it will pass the web address to be opened in webactivity.
                                mContext.startActivity(intent6);
                            }
                        });
                        builder2.create().show();
                        break;
                    case 7:
                        Intent intent7 = new Intent(mContext, NearbyHospitalsActivity.class);
                        intent7.putExtra("url","https://www.stylecraze.com/articles/seasonal-diseases-and-precautions/");  //it will pass the web address to be opened in webactivity.
                        mContext.startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(mContext, NearbyHospitalsActivity.class);
                        intent8.putExtra("url","https://www.vedyou.com/blog/easy-yoga-asanas-for-mental-health/");  //it will pass the web address to be opened in webactivity.
                        mContext.startActivity(intent8);
                        break;
                    case 9:
                        Intent intent9 = new Intent(mContext, NearbyHospitalsActivity.class);
                        intent9.putExtra("url","https://www.healthline.com/nutrition/27-health-and-nutrition-tips");  //it will pass the web address to be opened in webactivity.
                        mContext.startActivity(intent9);
                        break;
                    case 10:
                        Intent intent10 = new Intent(mContext, NearbyHospitalsActivity.class);
                        intent10.putExtra("url","https://www.healthline.com/health/fitness-exercise/10-best-exercises-everyday");  //it will pass the web address to be opened in webactivity.
                        mContext.startActivity(intent10);
                        break;
                    default:
                        break;
                }
                /*Intent intent = new Intent(mContext, BookActivity.class);
                intent.putExtra(BOOK_ID_KEY, books.get(position).getId());
                mContext.startActivity(intent);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return recItem.size();
    }

    public void setRecItem(ArrayList<RecItem> recItem) {
        this.recItem = recItem;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView parentRec;
        private ImageView imgRec;
        private TextView txtRec;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentRec=itemView.findViewById(R.id.parentRec);
            imgRec=itemView.findViewById(R.id.imgRec);
            txtRec=itemView.findViewById(R.id.txtRec);
        }
    }
}
