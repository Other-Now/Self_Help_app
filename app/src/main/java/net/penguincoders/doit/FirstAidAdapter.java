package net.penguincoders.doit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FirstAidAdapter extends RecyclerView.Adapter<FirstAidAdapter.ViewHolder> {

    private static final String TAG1 = "FirstAidAdapter";
    private ArrayList<RecItem> recItem1 = new ArrayList<>();
    private Context mContext1;
    private String parentActivity1;

    public FirstAidAdapter(Context mContext1, String parentActivity1) {
        this.mContext1 = mContext1;
        this.parentActivity1 = parentActivity1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_aid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG1, "onBindViewHolder: Called");
        holder.txtFirstAid.setText(recItem1.get(position).getName());

        /*holder.taskCardViewo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (recItem1.get(position).getId()) {
                    case 1:
                        Toast toast =
                        break;
                    case 2:
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext1,R.style.MyDialogTheme);  //Here builder would be of anderoidx.appcombat type
                        builder.setTitle(R.string.know_your_med);
                        builder.setMessage("Do you wish to know about your med?\n" +
                                "then, click on the YES button");
                        builder.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //TODO: Show the Website
                                Intent intent2 = new Intent(mContext1, KnowYourMedActivity.class);
                                intent2.putExtra("url","https://www.drugs.com/drug_information.html");  //it will pass the web address to be opened in webactivity.
                                mContext1.startActivity(intent2);
                            }
                        });
                        builder.create().show();
                        break;
                    case 3:
                        Intent intent3 = new Intent(mContext1, FirstAidTipsActivity.class);
                        mContext1.startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(mContext1, HealthTipsActivity.class);
                        mContext1.startActivity(intent4);
                        break;
                    default:
                        break;
                }
                *//*Intent intent = new Intent(mContext, BookActivity.class);
                intent.putExtra(BOOK_ID_KEY, books.get(position).getId());
                mContext.startActivity(intent);*//*
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return recItem1.size();
    }
    public void setRecItem1(ArrayList<RecItem> recItem) {
        this.recItem1 = recItem;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView taskCardViewo;
        private TextView txtFirstAid;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            taskCardViewo=itemView.findViewById(R.id.taskCardViewo);
            txtFirstAid=itemView.findViewById(R.id.txtFirstAid);
        }
    }
}
