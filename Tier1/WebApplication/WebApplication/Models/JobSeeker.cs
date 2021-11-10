namespace WebApplication.Models
{
    public class JobSeeker : User
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }

        public JobSeeker()
        {
            Role = "JobSeeker";
        }
    }
}