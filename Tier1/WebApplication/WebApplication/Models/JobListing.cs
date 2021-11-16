using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace WebApplication.Models
{
    public class JobListing
    { 
        [Required]
        public int JobId { get; set; }
        [Required]
        public string JobTitle { get; set; }
        
        [Required]
        public string JobType { get; set; }

        [Required]
        public string Location { get; set; }

        [Required, Range(0, int.MaxValue, ErrorMessage = "Invalid job experience")]
        public float ExperienceLevel { get; set; }

        
        public List<string> JobRequirments { get; set; }
        
       
        public List<string> JobPrivilleges { get; set; }
        
        [RegularExpression(@"(\+?[0-9]{2})\s*[0-9]{2}\s*[0-9]{2}\s*[0-9]{2}\s*[0-9]{2}", ErrorMessage = "Invalid phone number or character!")]
        public string PhoneNumber { get; set; }
        
        [RegularExpression(@"^([\w\.\-]+)@([\w\-]+)((\.(\w){2,3})+)$", ErrorMessage = "Invalid character!")]
        public string Email { get; set; }
        
        
        public string ApplicationDeadline { get; set; }

    }
}
