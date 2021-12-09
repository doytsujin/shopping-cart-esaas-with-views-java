package io.shopping.cart;

import com.akkaserverless.javasdk.AkkaServerless;
import io.shopping.cart.action.CartToPurchasedProductAction;
import io.shopping.cart.entity.PurchasedProduct;
import io.shopping.cart.entity.ShoppingCart;
import io.shopping.cart.view.CustomerCartViewByDateImpl;
import io.shopping.cart.view.CustomerCartViewImpl;
import io.shopping.cart.view.ProductsViewImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public final class Main {

  private static final Logger LOG = LoggerFactory.getLogger(Main.class);

  public static AkkaServerless createAkkaServerless() {
    // The AkkaServerlessFactory automatically registers any generated Actions, Views or Entities,
    // and is kept up-to-date with any changes in your protobuf definitions.
    // If you prefer, you may remove this and manually register these components in a
    // `new AkkaServerless()` instance.
    return AkkaServerlessFactory.withComponents(
      PurchasedProduct::new,
      ShoppingCart::new,
      CartToPurchasedProductAction::new,
      CustomerCartViewImpl::new,
      CustomerCartViewByDateImpl::new,
      ProductsViewImpl::new);
  }

  public static void main(String[] args) throws Exception {
    LOG.info("starting the Akka Serverless service");
    createAkkaServerless().start();
  }
}
