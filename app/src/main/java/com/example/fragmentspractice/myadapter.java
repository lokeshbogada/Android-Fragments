package com.example.fragmentspractice;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>  implements AdapterView.OnItemClickListener{

    ArrayList<dataModel> dataHolder;

    public myadapter(ArrayList<dataModel> dataHolder) {
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.img.setImageResource(dataHolder.get(position).getImage());
        holder.header.setText(dataHolder.get(position).getHeader());
        holder.desc.setText(dataHolder.get(position).getDesc());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Item clicked: " + position, Toast.LENGTH_SHORT).show();
                showNotification(v,dataHolder.get(position).getImage(),dataHolder.get(position).getHeader(),dataHolder.get(position).getDesc());
                /*final String CHANNEL_ID ="channel1";
                Bitmap largeIcon = BitmapFactory.decodeResource(v.getResources(),R.drawable.angular);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(v.getContext(),CHANNEL_ID)
                        .setSmallIcon(R.drawable.angular)
                        .setContentText("angular")
                        .setContentText("Basic angular Text")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .setBigContentTitle("Hello Fragment Example")
                                .bigText("qwerty asda djf jud fsdfdnjc sf xncsjndf dm c dmlka ckdmvsdwi399 "))
                        .setLargeIcon(largeIcon);

                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                    NotificationChannel notificationChannel = new NotificationChannel("1","notification", NotificationManager.IMPORTANCE_HIGH);
                    NotificationManager notificationManager = v.getContext().getSystemService(NotificationManager.class);
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(Color.RED);
                    notificationChannel.enableVibration(true);

                    notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                    notificationManager.createNotificationChannel(notificationChannel);

                }
                NotificationManager notificationManager = v.getContext().getSystemService(NotificationManager.class);
                notificationManager.notify(1,builder.build());
*/
                Intent intent = new Intent(v.getContext(),ResultActivity.class);
                intent.putExtra("img",dataHolder.get(position).getImage());
                intent.putExtra("header",dataHolder.get(position).getHeader());
                intent.putExtra("desc",dataHolder.get(position).getDesc());
                v.getContext().startActivity(intent);
                //startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(view.getContext(), "Item clicked: " + i, Toast.LENGTH_SHORT).show();


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void showNotification(View view, int image, String header, String desc) {
        Bitmap largeIcon = BitmapFactory.decodeResource(view.getResources(),image);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(view.getContext(), "default_notification_channel_id" )
                .setSmallIcon(image)
                .setContentTitle( header)
                .setContentText( desc)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .setBigContentTitle(header)
                        .bigText("qwerty asda djf jud fsdfdnjc sf xncsjndf dm c dmlka ckdmvsdwi399 "))
                .setLargeIcon(largeIcon);



        NotificationManager notificationManager =(NotificationManager) view.getContext().getSystemService(Context.NOTIFICATION_SERVICE);


        NotificationChannel notificationChannel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes. CONTENT_TYPE_SONIFICATION )
                    .setUsage(AudioAttributes. USAGE_ALARM )
                    .build() ;
            notificationChannel = new NotificationChannel("NOTIFICATION_CHANNEL_ID", "NOTIFICATION_CHANNEL_NAME", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mBuilder.setChannelId("NOTIFICATION_CHANNEL_ID");
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel) ;
        }
        assert notificationManager != null;
        notificationManager.notify(( int ) System. currentTimeMillis () ,mBuilder.build()) ;
    }
    class myviewholder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView header,desc;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img1);
            header = itemView.findViewById(R.id.t1);
            desc = itemView.findViewById(R.id.t2);

        }
    }

}
