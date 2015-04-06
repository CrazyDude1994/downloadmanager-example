package com.crazydude.downloadmanagerexample;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class DownloadFileReceiver extends BroadcastReceiver {
    public DownloadFileReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent install = new Intent(Intent.ACTION_VIEW);
        DownloadManager downloadManager = (DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
        install.setDataAndType(downloadManager.getUriForDownloadedFile(intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0)),
                "application/vnd.android.package-archive");
        install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(install);
    }
}
