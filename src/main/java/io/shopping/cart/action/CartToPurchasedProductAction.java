package io.shopping.cart.action;

import com.akkaserverless.javasdk.action.ActionCreationContext;
import com.akkaserverless.javasdk.action.Action.Effect;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;

import io.shopping.cart.api.PurchasedProductApi;
import io.shopping.cart.entity.CartEntity;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class CartToPurchasedProductAction extends AbstractCartToPurchasedProductAction {

  public CartToPurchasedProductAction(ActionCreationContext creationContext) {
  }

  @Override
  public Effect<Empty> onCartCheckedOut(CartEntity.CartCheckedOut cartCheckedOut) {
    cartCheckedOut.getCartState().getLineItemsList().stream()
        .map(lineItem -> PurchasedProductApi.PurchasedProduct.newBuilder()
            .setCustomerId(cartCheckedOut.getCartState().getCustomerId())
            .setCartId(cartCheckedOut.getCartState().getCartId())
            .setProductId(lineItem.getProductId())
            .setProductName(lineItem.getProductName())
            .setQuantity(lineItem.getQuantity())
            .setPurchasedUtc(cartCheckedOut.getCartState().getCheckedOutUtc())
            .build())
        .forEach(purchasedProduct -> effects().forward(components().purchasedProduct().addPurchasedProduct(purchasedProduct)));

    return effects().reply(Empty.getDefaultInstance());
  }

  @Override
  public Effect<Empty> ignoreOtherEvents(Any any) {
    return effects().reply(Empty.getDefaultInstance());
  }
}
