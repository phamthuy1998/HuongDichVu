using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ECommerceWebAPI_DataAccess;

namespace ECommerceWebAPI.Controllers
{
    public class OrderItemController : ApiController
    {
        E_COMMERCE_WEB_Entities entities = new E_COMMERCE_WEB_Entities();

        [Route("api/orderItemOfOrder")]
        [HttpGet]
        public IHttpActionResult getOrderItemOfOrder(int orderId)
        {
            var order = entities.GetOrderItemByOrder(orderId).ToList();
            if (order == null)
            {
                return NotFound();
            }
            return Ok(order);
        }
    }
}
