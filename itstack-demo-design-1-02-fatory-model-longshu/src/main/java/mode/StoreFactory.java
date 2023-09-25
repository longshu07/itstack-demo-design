package mode;

import mode.store.ICommodity;
import mode.store.impl.CardCommodityService;
import mode.store.impl.CouponCommodityService;
import mode.store.impl.GoodsCommodityService;

/**
 * 商店工厂
 * 避免了创建者与具体产品逻辑耦合。
 * 满足单一原则，每一个业务逻辑都在自己的类中实现。
 * 满足开闭原则，无需更改调用方，就可以在程序中引入新的产品类型。
 * 但这样也会带来⼀些问题，⽐如有⾮常多的奖品类型，那么实现的⼦类会极速扩张。因此也需要使⽤其他的模式进⾏优化，这些在后续的设计模式中会逐步涉及到
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
