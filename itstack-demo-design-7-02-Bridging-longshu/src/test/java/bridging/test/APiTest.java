package bridging.test;

import bridging.pay.channel.service.Pay;
import bridging.pay.channel.service.impl.AliPay;
import bridging.pay.channel.service.impl.WxPay;
import bridging.pay.model.service.impl.FacePayModel;
import bridging.pay.model.service.impl.FingerprintPayModel;
import org.junit.Test;

import java.math.BigDecimal;

public class APiTest {
    @Test
    public void payTest(){
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        Pay wxPay = new WxPay(new FacePayModel());
        wxPay.bridgingTransfer("uid-weixi-face", "uid-weixi-face", new BigDecimal("100"));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay aliPay = new AliPay(new FingerprintPayModel());
        aliPay.bridgingTransfer("uid-ali-fingerprint","uid-ali-fingerprint",new BigDecimal("500"));
    }
}
