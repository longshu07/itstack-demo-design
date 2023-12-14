package bridging.pay.model.service;

/**
 * 支付操作类型接口
 * @author  longshu
 */
public interface IPayModel {
    /**
     * 安全校验
     * @param uId
     * @return
     */
    boolean security(String uId);
}
