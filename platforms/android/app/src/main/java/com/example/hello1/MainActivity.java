/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.example.hello1;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.sabpaisa.gateway.android.sdk.SabPaisaGateway;
import com.sabpaisa.gateway.android.sdk.interfaces.IPaymentSuccessCallBack;
import com.sabpaisa.gateway.android.sdk.models.TransactionResponsesModel;

import org.apache.cordova.*;

public class MainActivity extends CordovaActivity implements IPaymentSuccessCallBack<TransactionResponsesModel>
{
    public static MainActivity mainActivityReference;
    public static CallbackContext callbackContext;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mainActivityReference = this;
        // enable Cordova apps to be started in the background
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }

        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
    }

    public static void openSabpaisaSDK(String firstname,String lastname,String email,String mobileNumber,String amount,CallbackContext callbackContext){
        MainActivity.callbackContext=callbackContext;
        SabPaisaGateway sabPaisaGateway1 =
                SabPaisaGateway.Companion.builder()
                        .setAmount(Double.parseDouble(amount))   //Mandatory Parameter
                        .setFirstName(firstname) //Mandatory Parameter
                        .setLastName(lastname) //Mandatory Parameter
                        .setMobileNumber(mobileNumber) //Mandatory Parameter
                        .setEmailId(email)//Mandatory Parameter
                        .setClientCode("TM001")
                        .setAesApiIv("YN2v8qQcU3rGfA1y")
                        .setAesApiKey("kaY9AIhuJZNvKGp2")
                        .setTransUserName("rajiv.moti_336")
                        .setTransUserPassword("RIADA_SP336")
                        .build();
        SabPaisaGateway.Companion.setInitUrl("https://securepay.sabpaisa.in/SabPaisa/sabPaisaInit?v=1");
        SabPaisaGateway.Companion.setEndPointBaseUrl("https://securepay.sabpaisa.in");
        SabPaisaGateway.Companion.setTxnEnquiryEndpoint("https://txnenquiry.sabpaisa.in");

        sabPaisaGateway1.init(mainActivityReference,mainActivityReference);
    }

    @Override
    public void onPaymentFail(@Nullable TransactionResponsesModel transactionResponsesModel) {
        callbackContext.success(transactionResponsesModel.getStatus());
    }

    @Override
    public void onPaymentSuccess(@Nullable TransactionResponsesModel transactionResponsesModel) {
        callbackContext.success(transactionResponsesModel.getStatus());
    }

}


