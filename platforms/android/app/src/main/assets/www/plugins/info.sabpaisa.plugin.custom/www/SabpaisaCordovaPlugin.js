cordova.define("info.sabpaisa.plugin.custom.SabpaisaCordovaPlugin", function(require, exports, module) {
var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'SabpaisaCordovaPlugin', 'coolMethod', [arg0]);
};

});
