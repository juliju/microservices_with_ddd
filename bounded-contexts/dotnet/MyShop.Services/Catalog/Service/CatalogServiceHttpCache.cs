﻿using MyShop.Entities;
using System;

namespace MyShop.Services
{
    public class CatalogServiceHttpCache : ICatalogService
    {
        public IItem LoadItem(ItemId itemId)
        {
            return default(IItem);
        }
    }
}
