package mode;

import mode.store.ICommodity;
import mode.store.impl.CardCommodityService;
import mode.store.impl.CouponCommodityService;
import mode.store.impl.GoodsCommodityService;

/**
 * 商店工厂
 * @author yifeiwifelongshu
 */
public class StoreFactory {
    /**
     * 根据类型获取对应的商品服务
     * @param commodityType
     * @return
     */
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) {
            return null;
        }
        // 优惠券
        if (1 == commodityType) {
            return new CouponCommodityService();
        }
        // 实体货物
        if (2 == commodityType) {
            return new GoodsCommodityService();
        }
        // 兑换卡
        if (3 == commodityType) {
            return new CardCommodityService();
        }
        throw new RuntimeException("不存在的商品服务类型");
    }
}
