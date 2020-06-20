using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ECommerceWebAPI_DataAccess;

namespace ECommerceWebAPI.Controllers
{
    public class OrderController : ApiController
    {
        E_COMMERCE_WEB_Entities entities = new E_COMMERCE_WEB_Entities();

        [Route("api/allOrdersOfUser")]
        [HttpGet]
        public IHttpActionResult getAllOrdersOfUser(int userId)
        {
            var order = entities.GetAllOrdersOfUser(userId).ToList();
            if (order == null)
            {
                return NotFound();
            }
            return Ok(order);
        }

        [Route("api/orderByStatus")]
        [HttpGet]
        public IHttpActionResult getOrderByStatus(int userId, int statusId)
        {
            var order = entities.GetOrderByStatus(userId, statusId).ToList();
            if (order == null)
            {
                return NotFound();
            }
            return Ok(order);
        }

        [Route("api/cancelOrder")]
        [AcceptVerbs("GET", "POST")]
        [HttpPut]
        public IHttpActionResult cancelOrder(int orderId)
        {
            var result = entities.CancelOrder(orderId);
            return Ok(result);
        }
    }
}
