package io.mystore.shipping.action;

import com.akkaserverless.javasdk.action.ActionCreationContext;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;

import io.mystore.shipping.api.StockItemApi;
import io.mystore.shipping.entity.ShipSkuItemEntity;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class ShipSkuItemToStockItemAction extends AbstractShipSkuItemToStockItemAction {

  public ShipSkuItemToStockItemAction(ActionCreationContext creationContext) {
  }

  @Override
  public Effect<Empty> onShipOrderItemAdded(ShipSkuItemEntity.ShipOrderItemAdded shipOrderItemAdded) {
    return effects().forward(components().stockItem().ship(toStockItem(shipOrderItemAdded)));
  }

  @Override
  public Effect<Empty> onReleasedSkuItemFromOrder(ShipSkuItemEntity.ReleasedSkuItemFromOrder releasedSkuItemFromOrder) {
    return effects().forward(components().stockItem().release(toStockItem(releasedSkuItemFromOrder)));
  }

  @Override
  public Effect<Empty> ignoreOtherEvents(Any any) {
    return effects().reply(Empty.getDefaultInstance());
  }

  private StockItemApi.ShipStockItem toStockItem(ShipSkuItemEntity.ShipOrderItemAdded shipOrderItemAdded) {
    return StockItemApi.ShipStockItem
        .newBuilder()
        .setSkuItemId(shipOrderItemAdded.getSkuItemId())
        .build();
  }

  private StockItemApi.ReleaseStockItem toStockItem(ShipSkuItemEntity.ReleasedSkuItemFromOrder releasedSkuItemFromOrder) {
    return StockItemApi.ReleaseStockItem
        .newBuilder()
        .setSkuItemId(releasedSkuItemFromOrder.getSkuItemId())
        .build();
  }
}
