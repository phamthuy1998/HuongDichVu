using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ECommerceWebAPI_DataAccess;

namespace ECommerceWebAPI.Controllers
{
    public class UserController : ApiController
    {
        E_COMMERCE_WEB_Entities entities = new E_COMMERCE_WEB_Entities();

        [Route("api/login")]
        [AcceptVerbs("GET", "POST")]
        [HttpGet]
        public IHttpActionResult login(string userName, string password )
        {          
                var result = entities.Login(userName, password);
                return Ok(result);          
        }

        [Route("api/signUp")]
        [AcceptVerbs("GET", "POST")]
        [HttpPost]
        public IHttpActionResult signUp(string userName, string password, string name, string email, string phone, string address)
        {
                var result = entities.SignUp(userName, password, name, email, phone, address);
                return Ok(result);
        }
    }
}
