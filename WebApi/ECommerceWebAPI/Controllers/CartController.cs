using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ECommerceWebAPI_DataAccess;

namespace ECommerceWebAPI.Controllers
{
    public class CartController : ApiController
    {
        E_COMMERCE_WEB_Entities entities = new E_COMMERCE_WEB_Entities();

        [Route("api/checkOut")]
        [AcceptVerbs("GET", "POST")]
        [HttpPut]
        public IHttpActionResult checkOut(int userId, string name, string phone, string email, string address, string note)
        {
            var result = entities.CheckOut(userId, name, phone, email, address, note);
            return Ok(result);
        }

        [Route("api/cartCount")]
        [HttpGet]
        public IHttpActionResult getCartCount(int userId)
        {
            var count = entities.GetCartCount(userId).ToList();
            if (count == null)
            {
                return NotFound();
            }
            return Ok(count);
        }
    }
}
