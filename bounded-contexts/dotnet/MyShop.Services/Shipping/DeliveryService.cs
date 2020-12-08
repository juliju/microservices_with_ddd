using MyShop.Services.ShoppingCart;
using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;

namespace MyShop.Services.Shipping
{
    public class DeliveryService
    {
        public DeliveryService(ICatalogService catalogService)
        {
            CatalogService = catalogService;
        }

        public ICatalogService CatalogService { get; }

        public double CalculateOrderWeight(Cart cart)
        {
            return cart.GetItems()
                .Sum(item => item.Quantity * CatalogService.LoadItem(item.ItemId).Weight);
        }
    }
}
