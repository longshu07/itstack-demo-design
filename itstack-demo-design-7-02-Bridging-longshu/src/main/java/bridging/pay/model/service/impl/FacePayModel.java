package bridging.pay.model.service.impl;

import bridging.pay.model.service.IPayModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 脸部支付
 * @author  longshu
 */
public class FacePayModel implements IPayModel {
    protected Logger logger = LoggerFactory.getLogger(FacePayModel.class);

    /**
     * 安全校验
     *
     * @param uId
     * @return
     */
    @Override
    public boolean security(String uId) {
        logger.info("人脸支付，风控校验脸部识别");
        return true;
    }
}
