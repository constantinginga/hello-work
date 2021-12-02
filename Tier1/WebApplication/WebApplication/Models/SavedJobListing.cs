using System.ComponentModel.DataAnnotations;

namespace WebApplication.Models
{
    public class SavedJobListing
    {
        [Required] public string Email { get; set; }
        [Required] public int JobId { get; set; }
        [Required] public int Id { get; set; }
    }
}