using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ECommerceWebAPI_DataAccess;

namespace ECommerceWebAPI.Controllers
{
    public class CardController : ApiController
    {
        E_COMMERCE_WEB_Entities entities = new E_COMMERCE_WEB_Entities();

        [Route("api/allCards")]
        [HttpGet]
        public IHttpActionResult getAllCards()
        {
            var card = entities.GetAllCards().ToList();
            if (card == null)
            {
                return NotFound();
            }
            return Ok(card);
        }
    }
}
