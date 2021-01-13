package core.order;

/**
 * @author wonseok.song
 * @since 2021-01-13
 */
public interface OrderService {
  Order createOrder(Long memberId, String itemName, int itemPrice);
}
