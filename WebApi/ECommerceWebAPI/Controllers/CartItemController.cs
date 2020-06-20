using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ECommerceWebAPI_DataAccess;

namespace ECommerceWebAPI.Controllers
{
    public class CartItemController : ApiController
    {
        E_COMMERCE_WEB_Entities entities = new E_COMMERCE_WEB_Entities();

        [Route("api/minusCartItem")]
        [AcceptVerbs("GET", "POST")]
        [HttpPut]
        public IHttpActionResult minusCartItem(int userId, int productId)
        {
            var result = entities.MinusCartItem(userId, productId);
            return Ok(result);
        }

        [Route("api/plusCartItem")]
        [AcceptVerbs("GET", "POST")]
        [HttpPut]
        public IHttpActionResult plusCartItem(int userId, int productId, int quantity)
        {
            var result = entities.PlusCartItem(userId, productId, quantity);
            return Ok(result);
        }

        [Route("api/deleteCartItem")]
        [AcceptVerbs("GET", "POST")]
        [HttpDelete]
        public IHttpActionResult deleteCartItem(int userId, int productId)
        {
            var result = entities.DeleteCartItem(userId, productId);
            return Ok(result);
        }
    }
}
