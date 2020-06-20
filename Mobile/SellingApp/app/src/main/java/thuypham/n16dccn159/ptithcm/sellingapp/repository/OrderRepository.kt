package thuypham.n16dccn159.ptithcm.sellingapp.repository

import thuypham.n16dccn159.ptithcm.sellingapp.data.*

interface OrderRepository {
    fun order(userID: Int,
              name: String,
              phone: String,
              email: String,
              address: String,
              note: String): Result<ResultApi>
    fun getAllOrder(userID: Int, statusID: Int?=null): Result<ArrayList<Order>>
    fun getAllOrderItem(orderID: Int): Result<ArrayList<OrderItem>>
    fun getAllOrderStatus(): Result<ArrayList<OrderStatus>>
    fun cancelOrder(orderId:Int): Result<ResultApi>
}