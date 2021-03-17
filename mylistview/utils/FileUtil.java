package utils;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * Created by risha on 29-Dec-17.
 */
//save file utilities
public class FileUtil {
    public static Uri getOutputMediaFileUri(Context context,String folderPath, String fileName) {
        return Uri.fromFile(getOutputMediaFile(context,folderPath,fileName));
    }

    public static File getOutputMediaFile(Context context, String folderPath, String fileName) {

        File storageDir=new File(folderPath);
        String filePath="";
        //Create the storage directory if it does not exist
        if (!storageDir.exists()){
            if(!storageDir.mkdirs()) {
                return null;
            }
        }
        if(fileName!=null) {
            fileName=storageDir.getPath() + File.separator + fileName;
        }

        return new File(filePath);
    }

}
