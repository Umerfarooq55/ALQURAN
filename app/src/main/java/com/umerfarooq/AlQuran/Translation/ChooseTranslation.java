package com.umerfarooq.AlQuran.Translation;

        import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import info.androidhive.introslider.R;

public class ChooseTranslation extends AppCompatActivity implements View.OnClickListener{
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
    String tr1="https://allianceintltd.com/QuranTranslations/Json_files/translations/English.pdf";
    String tr2="https://allianceintltd.com/QuranTranslations/Json_files/translations/Urdu.pdf";
    String tr3="https://allianceintltd.com/QuranTranslations/Json_files/translations/German.pdf";
   // String tr4="https://allianceintltd.com/QuranTranslations/Json_files/translations/german.pdf";
    String tr5="";
    String tr6="";
    String tr7="";
    String tr8="";
    String tr9="";
    String tr10="";
    String tr11="";
    String tr12="";
    String tr13="";
    String tr14="";
    String tr15="";
    String tr16="";
    String tr17="";
    String tr18="";
    String tr19="";
    String tr20="";

    DownloadManager downloadManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_translation);

        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(this);

        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3=(Button)findViewById(R.id.b33);
        b3.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        //Before starting any download check internet connection availability
        switch (view.getId()) {
            case R.id.b1:

                long downloadReference;
                Uri music_uri1 = Uri.parse
                        (tr1);

                downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(music_uri1);
                request.setTitle("Translation Downloading");
                request.setDescription("Downloading Please Wait...");
                request.setDestinationInExternalPublicDir("/QuranFolder", "English.Json");
               downloadReference = downloadManager.enqueue(request);


        break;
            case R.id.b2:
                long downloadReference1;
                Uri music_uri2 = Uri.parse
                        (tr2);

                downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request1 = new DownloadManager.Request(music_uri2);
                request1.setTitle("Translation Downloading");
                request1.setDescription("Downloading Please Wait...");
                request1.setDestinationInExternalPublicDir("/QuranFolder", "Urdu.Json");
                downloadReference1 = downloadManager.enqueue(request1);
                       break;

            case R.id.b33:
              //  Toast.makeText(ChooseTranslation.this, "b3", Toast.LENGTH_SHORT).show();
                long downloadReference3;
                Uri music_uri3 = Uri.parse
                        (tr3);

                downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request2 = new DownloadManager.Request(music_uri3);
                request2.setTitle("Translation Downloading");
                request2.setDescription("Downloading Please Wait...");
                request2.setDestinationInExternalPublicDir("/QuranFolder", "German.Json");
                downloadReference = downloadManager.enqueue(request2);
                    break;
//            case R.id.b4:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b5:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b6:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b7:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b8:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b9:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b10:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b11:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b12:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b13:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b14:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b15:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b16:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b17:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b18:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.b19:
//                Toast.makeText(ChooseTranslation.this, "THIS TRANSLATION IS NOT AVAIBLE RIGHT NOW", Toast.LENGTH_SHORT).show();
//                break;



//            case R.id.openDownloadedFolder:
//                openDownloadedFolder();
//                break;

        }

    }

    private void Check_Image_Status(long Image_DownloadId) {

        DownloadManager.Query ImageDownloadQuery = new DownloadManager.Query();
        //set the query filter to our previously Enqueued download
        ImageDownloadQuery.setFilterById(Image_DownloadId);

        //Query the download manager about downloads that have been requested.
        Cursor cursor = downloadManager.query(ImageDownloadQuery);
        if(cursor.moveToFirst()){
            DownloadStatus(cursor, Image_DownloadId);
        }
    }

    private void DownloadStatus(Cursor cursor, long DownloadId){

        //column for download  status
        int columnIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
        int status = cursor.getInt(columnIndex);
        //column for reason code if the download failed or paused
        int columnReason = cursor.getColumnIndex(DownloadManager.COLUMN_REASON);
        int reason = cursor.getInt(columnReason);
        //get the download filename
        int filenameIndex = cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME);
        String filename = cursor.getString(filenameIndex);

        String statusText = "";
        String reasonText = "";

        switch(status){
            case DownloadManager.STATUS_FAILED:
                statusText = "STATUS_FAILED";
                switch(reason){
                    case DownloadManager.ERROR_CANNOT_RESUME:
                        reasonText = "ERROR_CANNOT_RESUME";
                        break;
                    case DownloadManager.ERROR_DEVICE_NOT_FOUND:
                        reasonText = "ERROR_DEVICE_NOT_FOUND";
                        break;
                    case DownloadManager.ERROR_FILE_ALREADY_EXISTS:
                        reasonText = "ERROR_FILE_ALREADY_EXISTS";
                        break;
                    case DownloadManager.ERROR_FILE_ERROR:
                        reasonText = "ERROR_FILE_ERROR";
                        break;
                    case DownloadManager.ERROR_HTTP_DATA_ERROR:
                        reasonText = "ERROR_HTTP_DATA_ERROR";
                        break;
                    case DownloadManager.ERROR_INSUFFICIENT_SPACE:
                        reasonText = "ERROR_INSUFFICIENT_SPACE";
                        break;
                    case DownloadManager.ERROR_TOO_MANY_REDIRECTS:
                        reasonText = "ERROR_TOO_MANY_REDIRECTS";
                        break;
                    case DownloadManager.ERROR_UNHANDLED_HTTP_CODE:
                        reasonText = "ERROR_UNHANDLED_HTTP_CODE";
                        break;
                    case DownloadManager.ERROR_UNKNOWN:
                        reasonText = "ERROR_UNKNOWN";
                        break;
                }
                break;
            case DownloadManager.STATUS_PAUSED:
                statusText = "STATUS_PAUSED";
                switch(reason){
                    case DownloadManager.PAUSED_QUEUED_FOR_WIFI:
                        reasonText = "PAUSED_QUEUED_FOR_WIFI";
                        break;
                    case DownloadManager.PAUSED_UNKNOWN:
                        reasonText = "PAUSED_UNKNOWN";
                        break;
                    case DownloadManager.PAUSED_WAITING_FOR_NETWORK:
                        reasonText = "PAUSED_WAITING_FOR_NETWORK";
                        break;
                    case DownloadManager.PAUSED_WAITING_TO_RETRY:
                        reasonText = "PAUSED_WAITING_TO_RETRY";
                        break;
                }
                break;
            case DownloadManager.STATUS_PENDING:
                statusText = "STATUS_PENDING";
                break;
            case DownloadManager.STATUS_RUNNING:
                statusText = "STATUS_RUNNING";
                break;
            case DownloadManager.STATUS_SUCCESSFUL:
                statusText = "STATUS_SUCCESSFUL";
                reasonText = "Filename:\n" + filename;
                break;
        }



            Toast toast = Toast.makeText(ChooseTranslation.this,
                    "Image Download Status:"+ "\n" + statusText + "\n" +
                            reasonText,
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 25, 400);
            toast.show();

            // Make a delay of 3 seconds so that next toast (Music Status) will not merge with this one.
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                }
            }, 3000);

    }
    public   boolean isConnectingToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager
                .getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
}
