package mar.sirenko.customer_order_manager.exception;

public abstract sealed class AlreadyExistsException extends RuntimeException
        permits AlreadyExistsException.Coupon {

    protected AlreadyExistsException(String message) {
        super(message);
    }

    public static final class Coupon extends AlreadyExistsException {

        public Coupon() {
            super("Купон уже существует");
        }
    }
}
