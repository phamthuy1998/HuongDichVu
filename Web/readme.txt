

------------ ALL API NOT DONE ------------
Card:
Lấy tất cả banner quảng cáo():GET 
http://ecommerceweb2020.azurewebsites.net/api/allCards
List<Card>allCards

Product:
Lấy tất cả sản phẩm trong giỏ hàng của user(int userId): GET http://ecommerceweb2020.azurewebsites.net/api/allProsOfCart?userId={userId}
List<Product>allProsOfCart
Lấy chi tiết sản phẩm theo Id(int proId): GET http://ecommerceweb2020.azurewebsites.net/api/proDetail?proId={proId}
Product(Id, Name, Stock, Price,...)

User:
Đăng ký(string userName, string password, string name, string email, string phone, string address): POST http://ecommerceweb2020.azurewebsites.net/api/signUp?userName={userName}&password={password}&name={name}&email={email}&phone={phone}&address={address}
-1: trùng userName
-2: trùng email
-3: trùng phone
1: đăng ký thành công
Đổi mật khẩu(int userId, string oldPass, string newPass): GET http://ecommerceweb2020.azurewebsites.net/api/changePassword?userId={userId}&oldPass={oldPass}&newPass={newPass}
0: thất bại
1: thành công
Cập nhật thông tin user(int userId, string name, string email, string phone, string address, string avatar): PUT http://ecommerceweb2020.azurewebsites.net/api/updateUser?userId={userId}&name={name}&email={email}&phone={phone}&address={address}&avatar={avatar}
0: thất bại
1: thành công

Cart:
Thanh toán giỏ hàng(int userId, string name, string phone, string email, string address, string note): PUT http://ecommerceweb2020.azurewebsites.net/api/checkOut?userId={userId}&name={name}&phone={phone}&email={email}&address={address}&note={note}
0: thất bại
1: thành công
Lấy số lượng sản phẩm trong giỏ hàng(int userId): GET http://ecommerceweb2020.azurewebsites.net/api/cartCount?userId={userId}
Int count

CartItem:
Giảm số lượng sản phẩm trong giỏ hàng(int userId, int productId): PUT http://ecommerceweb2020.azurewebsites.net/api/minusCartItem?userId={userId}&productId={productId}
0: thất bại
1: thành công
Tăng số lượng sản phẩm trong giỏ hàng(int userId, int productId, int quantity): PUT http://ecommerceweb2020.azurewebsites.net/api/plusCartItem?userId={userId}&productId={productId}&quantity={quantity}
0: thất bại
1: thành công
Xoá sản phẩm trong giỏ hàng(int userId, int productId): DELTE http://ecommerceweb2020.azurewebsites.net/api/deleteCartItem?userId={userId}&productId={productId}
0: thất bại
1: thành công

Order:
Lấy tất cả đơn đặt hàng của user(int userId): GET http://ecommerceweb2020.azurewebsites.net/api/allOrdersOfUser?userId={userId}
List<Order>allOrdersOfUser
Lấy tất cả đơn đặt hàng của user theo trạng thái(int userId, int statusId) GET http://ecommerceweb2020.azurewebsites.net/api/orderByStatus?userId={userId}&statusId={statusId}
List<Order>orderByStatus
Huỷ đơn đặt hàng(int orderId) PUT: http://ecommerceweb2020.azurewebsites.net/api/cancelOrder?orderId={orderId}
0: thất bại
1: thành công

OrderItem
Lấy tất cả sản phẩm của đơn đặt hàng(int orderId): GET
http://ecommerceweb2020.azurewebsites.net/api/orderItemOfOrder?orderId={orderId}
List<OrderItem>orderItemOfOrder

Status
Lấy tất cả trạng thái đơn đặt hàng: GET http://ecommerceweb2020.azurewebsites.net/api/allOrderStatus
List<Status>allOrderStatus


------------ DONE --------------------
-- http://localhost:52551/api/allPros
-- http://localhost:52551/api/allProsOfCate?cateId={cateId}
-- http://localhost:52551/api/allSalePros
-- http://localhost:52551/api/allCates
-- http://ecommerceweb2020.azurewebsites.net/api/proDetail?proId={proId}
-- http://ecommerceweb2020.azurewebsites.net/api/login?userName={userName}&password={password}
-- http://ecommerceweb2020.azurewebsites.net/api/userInfoById?userId={userId}
-- http://ecommerceweb2020.azurewebsites.net/api/signUp?userName={userName}&password={password}&name={name}&email={email}&phone={phone}&address={address}
-- http://ecommerceweb2020.azurewebsites.net/api/plusCartItem?userId={userId}&productId={productId}&quantity={quantity}
-- http://ecommerceweb2020.azurewebsites.net/api/allProsOfCart?userId={userId}
-- http://ecommerceweb2020.azurewebsites.net/api/minusCartItem?userId={userId}&productId={productId}
-- http://ecommerceweb2020.azurewebsites.net/api/checkOut?userId={userId}&name={name}&phone={phone}&email={email}&address={address}&note={note}
-- http://ecommerceweb2020.azurewebsites.net/api/updateUser?userId={userId}&name={name}&email={email}&phone={phone}&address={address}&avatar={avatar}
-- http://ecommerceweb2020.azurewebsites.net/api/changePassword?userId={userId}&oldPass={oldPass}&newPass={newPass}



------------ TODO ------------------------


-- add nav link to header -> set active menu // chuwa dc
-- load slider
https://salitha94.blogspot.com/2019/02/implement-sweet-alerts-with-react-js.html





