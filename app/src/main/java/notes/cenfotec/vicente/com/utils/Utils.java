package notes.cenfotec.vicente.com.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by vicente on 01/03/15.
 */
public class Utils {

    public static void displayMessage(Context context,String message){
        if(context==null){
            throw new IllegalArgumentException("context required");
        }else if(message.isEmpty()){
            throw new IllegalArgumentException("message required");
        }else{
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, message, duration);
            toast.show();
        }

    }
}
