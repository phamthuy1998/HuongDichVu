using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ECommerceWebAPI_DataAccess;

namespace ECommerceWebAPI.Controllers
{
    public class ProductController : ApiController
    {
        E_COMMERCE_WEB_Entities entities = new E_COMMERCE_WEB_Entities();

        [Route("api/allPros")]
        [HttpGet]
        public IHttpActionResult getAllProducts()
        {
            var product = entities.GetAllProducts().ToList();
            if (product == null)
            {
                return NotFound();
            }
            return Ok(product);            
        }

        [Route("api/allProsOfCart")]
        [HttpGet]
        public IHttpActionResult getAllProductsOfCart(int userId)
        {
            var product = entities.GetAllProductsOfCart(userId).ToList();
            if (product == null)
            {
                return NotFound();
            }
            return Ok(product);
        }

        [Route("api/allProsOfCate")]
        [HttpGet]
        public IHttpActionResult getAllProductsOfCategory(int cateId)
        {
            var product = entities.GetAllProductsOfCategory(cateId).ToList();
            if (product == null)
            {
                return NotFound();
            }
            return Ok(product);
        }

        [Route("api/allSalePros")]
        [HttpGet]
        public IHttpActionResult getAllSaleProducts()
        {
            var product = entities.GetAllSaleProducts().ToList();
            if (product == null)
            {
                return NotFound();
            }
            return Ok(product);
        }

        [Route("api/proDetail")]
        [HttpGet]
        public IHttpActionResult getProductDetailById(int proId)
        {
            var product = entities.GetProductDetailById(proId).ToList();
            if (product == null)
            {
                return NotFound();
            }
            return Ok(product);
        }

    }
}
