package io.mystore.order.action;

import akka.stream.javadsl.Source;
import com.akkaserverless.javasdk.testkit.ActionResult;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import io.mystore.order.action.OrderToOrderedItemsAction;
import io.mystore.order.action.OrderToOrderedItemsActionTestKit;
import io.mystore.order.entity.OrderEntity;
import org.junit.Test;
import static org.junit.Assert.*;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class OrderToOrderedItemsActionTest {

  @Test
  public void exampleTest() {
    OrderToOrderedItemsActionTestKit testKit = OrderToOrderedItemsActionTestKit.of(OrderToOrderedItemsAction::new);
    // use the testkit to execute a command
    // ActionResult<SomeResponse> result = testKit.someOperation(SomeRequest);
    // verify the response
    // SomeResponse actualResponse = result.getReply();
    // assertEquals(expectedResponse, actualResponse);
  }

  @Test
  public void onOrderCreatedTest() {
    OrderToOrderedItemsActionTestKit testKit = OrderToOrderedItemsActionTestKit.of(OrderToOrderedItemsAction::new);
    // ActionResult<Empty> result = testKit.onOrderCreated(OrderEntity.OrderCreated.newBuilder()...build());
  }

  @Test
  public void ignoreOtherEventsTest() {
    OrderToOrderedItemsActionTestKit testKit = OrderToOrderedItemsActionTestKit.of(OrderToOrderedItemsAction::new);
    // ActionResult<Empty> result = testKit.ignoreOtherEvents(Any.newBuilder()...build());
  }

}
