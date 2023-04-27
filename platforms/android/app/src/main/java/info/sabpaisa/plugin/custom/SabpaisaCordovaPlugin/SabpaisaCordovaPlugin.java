package info.sabpaisa.plugin.custom;

import com.example.hello1.MainActivity;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class SabpaisaCordovaPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String firstname = args.getString(0);
            String lastname = args.getString(1);
            String email = args.getString(2);
            String mobileNumber = args.getString(3);
            String amount = args.getString(4);
            MainActivity.openSabpaisaSDK(firstname,lastname,email,mobileNumber,amount,callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String arg1,String arg2, CallbackContext callbackContext) {
        if (arg1 != null && arg1.length() > 0) {
            callbackContext.success(arg1);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}

