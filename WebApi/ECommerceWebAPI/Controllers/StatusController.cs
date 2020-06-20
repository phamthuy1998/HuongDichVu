using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ECommerceWebAPI_DataAccess;

namespace ECommerceWebAPI.Controllers
{
    public class StatusController : ApiController
    {
        E_COMMERCE_WEB_Entities entities = new E_COMMERCE_WEB_Entities();

        [Route("api/allOrderStatus")]
        [HttpGet]
        public IHttpActionResult getAllOrderStatus()
        {
            var status = entities.GetAllOrderStatus().ToList();
            if (status == null)
            {
                return NotFound();
            }
            return Ok(status);
        }
    }
}
