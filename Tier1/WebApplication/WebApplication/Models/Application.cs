﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebApplication.Models
{
    public class Application
    {
        public int JobId { get; set; }
        [Required]
        public string Details { get; set; }

    }
}
