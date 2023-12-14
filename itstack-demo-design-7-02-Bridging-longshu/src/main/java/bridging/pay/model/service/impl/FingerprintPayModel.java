package bridging.pay.model.service.impl;

import bridging.pay.model.service.IPayModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 指纹支付
 * @author  longshu
 */
public class FingerprintPayModel implements IPayModel {
    protected Logger logger = LoggerFactory.getLogger(FingerprintPayModel.class);

    @Override
    public boolean security(String uId) {
        logger.info("指纹支付，风控校验指纹信息");
        return true;
    }
}
