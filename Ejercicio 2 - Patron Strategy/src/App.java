import unam.model.ExpressShipping;
import unam.model.InternationalShipping;
import unam.model.RegularShipping;
import unam.model.ShippingDistance;

public class App {
    public static void main(String[] args) throws Exception {
        RegularShipping S1 = new RegularShipping();

        ExpressShipping S2 = new ExpressShipping();

        InternationalShipping S3 = new InternationalShipping();

        double costo = S1.calcShippingCost(ShippingDistance.REGIONAL, 25);
        System.out.println("Total Shipping #1 Cost: $" + costo);

        costo = S2.calcShippingCost(ShippingDistance.REGIONAL, 25);
        System.out.println("Total Shipping #2 Cost: $" + costo);

        costo = S3.calcShippingCost(ShippingDistance.BORDER_COUNTRY, 20);
        System.out.println("Total Shipping #3 Cost: $" + costo);
    }
}
