using System.ComponentModel.DataAnnotations;

namespace WebApplication.Models
{
    public class User
    {
        [Required] [EmailAddress] public string Email { get; set; }
        public string Role { get; set; }
        [Required] public string Password { get; set; }
        [Required] [Phone] public string PhoneNumber { get; set; }
    }
}