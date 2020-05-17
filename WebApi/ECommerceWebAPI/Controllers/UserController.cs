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
                var user = entities.Login(userName, password);
                return Ok(user);
        }

        [Route("api/userInfoById")]
        [AcceptVerbs("GET", "POST")]
        [HttpGet]
        public IHttpActionResult getUserInfoById(int userId)
        {
            var user = entities.GetUserInfoById(userId).ToList();
            if (user == null)
            {
                return NotFound();
            }
            return Ok(user);
        }

        [Route("api/signUp")]
        [AcceptVerbs("GET", "POST")]
        [HttpPost]
        public IHttpActionResult signUp(string userName, string password, string name, string email, string phone, string address)
        {
                var result = entities.SignUp(userName, password, name, email, phone, address);
                return Ok(result);
        }

        [Route("api/updateUser")]
        [AcceptVerbs("GET", "POST")]
        [HttpPut]
        public IHttpActionResult updateUser(int userId, string name, string email, string phone, string address, string avatar)
        {
            var result = entities.UpdateUserInfo(userId, name, email, phone, address, avatar);
            return Ok(result);
        }

        [Route("api/changePassword")]
        [AcceptVerbs("GET", "POST")]
        [HttpPost]
        public IHttpActionResult changePass(int userId, string oldPass, string newPass)
        {
            var result = entities.ChangePassword(userId, oldPass, newPass);
            return Ok(result);
        }
    }
}
