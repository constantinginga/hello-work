using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace WebApplication.Models
{
   
    
    public class Application
    {
        public Application()
        {
            Status = Status.Waiting;
        }       
        [Required]
        [JsonPropertyName("JobId")]

        public int JobId { get; set; }
        [JsonPropertyName("Details")]

        public string Details { get; set; }
        [JsonPropertyName("employeEmail")]

        public string employeEmail { get; set; }
        [JsonPropertyName("employerEmail")]

        public string employerEmail { get; set; }
        public Status Status { get; set; }
        [JsonPropertyName("Name")]
        public string Name { get; set; }

    }
}
