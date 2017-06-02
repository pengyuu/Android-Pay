package io.github.mayubao.android_pay;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import io.github.mayubao.pay_library.PayAPI;
import io.github.mayubao.pay_library.WechatPayReq;

public class PayWechatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_wechat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testWechatPay();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * 微信支付Test
     */
    public void testWechatPay() {
        String appid = "";
        String partnerid = "";
        String prepayid = "";
        String noncestr = "";
        String timestamp = "";
        String sign = "";
        WechatPayReq wechatPayReq = new WechatPayReq.Builder()
                .with(this) //activity实例
                .setAppId(appid) //微信支付AppID
                .setPartnerId(partnerid)//微信支付商户号
                .setPrepayId(prepayid)//预支付码
//								.setPackageValue(wechatPayReq.get)//"Sign=WXPay"
                .setNonceStr(noncestr)
                .setTimeStamp(timestamp)//时间戳
                .setSign(sign)//签名
                .create();

        PayAPI.getInstance().sendPayRequest(wechatPayReq);
//								.setOnWechatPayListener(new OnWechatPayListener() {
//
//									@Override
//									public void onPaySuccess(int errorCode) {
//										ToastUtil.show(mContext, "支付成功" + errorCode);
//
//									}
//
//									@Override
//									public void onPayFailure(int errorCode) {
//										ToastUtil.show(mContext, "支付失败" + errorCode);
//
//									}
//								});
//        WechatPayAPI.getInstance().sendPayReq(wechatPayReq);

        PayAPI.getInstance().sendPayRequest(wechatPayReq);

    }

}
