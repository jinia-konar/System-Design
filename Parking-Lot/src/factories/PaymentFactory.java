package factories;

import enums.PaymentType;
import service.PaymentMethod;

public class PaymentFactory {
    public PaymentMethod getPaymentMethod(PaymentType paymentType) {
        if (paymentType == null) {
            throw new IllegalArgumentException("No Valid Payment type found");
        }
        return paymentType.getPaymentMethod();
    }
}
