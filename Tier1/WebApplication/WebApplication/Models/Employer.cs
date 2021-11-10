using System.ComponentModel.DataAnnotations;

namespace WebApplication.Models
{
    public class Employer : User
    {
        [Required] public string CompanyName { get; set; }
        [Required] public string Address { get; set; }

        public Employer()
        {
            Role = "Employer";
        }
    }
}