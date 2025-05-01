package enums;

import service.PaymentMethod;
import service.impl.CardPaymentMethod;
import service.impl.UPIPaymentMethod;

import java.util.function.Supplier;

public enum PaymentType {
    Card(CardPaymentMethod::new),
    UPI(UPIPaymentMethod::new);

    private final Supplier<PaymentMethod> paymentMethodSupplier;

    PaymentType(Supplier<PaymentMethod> paymentMethodSupplier) {
        this.paymentMethodSupplier = paymentMethodSupplier;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethodSupplier.get();
    }
}
