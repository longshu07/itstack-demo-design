package bridging.pay.channel.service.impl;

import bridging.pay.channel.service.Pay;
import bridging.pay.model.service.IPayModel;

import java.math.BigDecimal;

/**
 * 阿里支付宝支付渠道
 * @author  longshu
 */
public class AliPay extends Pay {
    /**
     * 通过构造参数，传递对应的支付操作类型，来实现支付渠道 + 支付类型 组合
     *
     * @param iPayModel
     */
    public AliPay(IPayModel iPayModel) {
        super(iPayModel);
    }

    /**
     * 划账接⼝
     *
     * @param uId
     * @param tradeId
     * @param amount
     * @return
     */
    @Override
    public String bridgingTransfer(String uId, String tradeId, BigDecimal amount) {
        logger.info("模拟支付宝渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        boolean security = iPayModel.security(uId);
        logger.info("模拟支付宝渠道支付风控校验。uId：{} tradeId：{} security：{}", uId, tradeId, security);
        if (!security) {
            logger.info("模拟支付宝渠道支付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        logger.info("模拟支付宝渠道支付划账成功。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        return "0000";
    }
}
