using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ECommerceWebAPI_DataAccess;

namespace ECommerceWebAPI.Controllers
{
    public class CategoryController : ApiController
    {
        E_COMMERCE_WEB_Entities entities = new E_COMMERCE_WEB_Entities();

        [Route("api/allCates")]
        [HttpGet]
        public IHttpActionResult getAllCategories()
        {
            var category = entities.GetAllCategories().ToList();
            if (category == null)
            {
                return NotFound();
            }
            return Ok(category);
        }
    }
}
