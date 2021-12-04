using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace WebApplication.Models
{
    public class User
    {
        [Required] [EmailAddress] public string Email { get; set; }
        public string Role { get; set; }

        [Required] [PasswordPropertyText][MinLength(6)] public string Password { get; set; }
        [Required] [Phone] public string PhoneNumber { get; set; }
    }
}