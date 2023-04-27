cordova.define('cordova/plugin_list', function(require, exports, module) {
  module.exports = [
    {
      "id": "info.sabpaisa.plugin.custom.SabpaisaCordovaPlugin",
      "file": "plugins/info.sabpaisa.plugin.custom/www/SabpaisaCordovaPlugin.js",
      "pluginId": "info.sabpaisa.plugin.custom",
      "clobbers": [
        "cordova.plugins.SabpaisaCordovaPlugin"
      ]
    }
  ];
  module.exports.metadata = {
    "info.sabpaisa.plugin.custom": "1.0.0"
  };
});