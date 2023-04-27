package info.sabpaisa.plugin.custom;

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
            String arg1 = args.getString(0);
            String arg2 = args.getString(0);
            this.coolMethod(arg1,arg2, callbackContext);
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
