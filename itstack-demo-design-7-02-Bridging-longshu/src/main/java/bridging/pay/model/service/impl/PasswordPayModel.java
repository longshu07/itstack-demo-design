package bridging.pay.model.service.impl;

import bridging.pay.model.service.IPayModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 密码支付
 * @author  longshu
 */
public class PasswordPayModel implements IPayModel {
    protected Logger logger = LoggerFactory.getLogger(PasswordPayModel.class);

    /**
     * 安全校验
     *
     * @param uId
     * @return
     */
    @Override
    public boolean security(String uId) {
        logger.info("密码支付，风控校验脸部识别");
        return true;
    }
}
