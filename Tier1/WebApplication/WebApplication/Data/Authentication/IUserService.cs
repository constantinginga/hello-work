using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Data.Authentication
{
    public interface IUserService
    {
        Task<User> ValidateUser(string email, string password);
        Task<Employer> CreateEmployer(Employer employer);
        Task<JobSeeker> CreateJobSeeker(JobSeeker jobSeeker);
        void UpdateJobSeeker(JobSeeker seeker);
        Task<Employer> GetEmployer(string cachedUserEmail);
        Task<JobSeeker> GetJobSeeker(string cachedUserEmail);
    }
}