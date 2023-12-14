package bridging.pay.channel.service;

import bridging.pay.model.service.IPayModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 支付渠道抽象类
 * 过构造参数，传递对应的支付操作类型，来实现支付渠道 + 支付类型 组合
 * @author  longshu
 */
public abstract class Pay {
    protected Logger logger = LoggerFactory.getLogger(Pay.class);
    /**
     * 支付操作类型
     * 例如：指纹支付、刷脸支付、密码支付
     */
    protected IPayModel iPayModel;

    /**
     * 通过构造参数，传递对应的支付操作类型，来实现支付渠道 + 支付类型 组合
     * @param iPayModel
     */
    public Pay(IPayModel iPayModel) {
        this.iPayModel = iPayModel;
    }

    /**
     * 划账接⼝
     * @param uId
     * @param tradeId
     * @param amount
     * @return
     */
    public abstract String bridgingTransfer(String uId, String tradeId, BigDecimal amount);
}
