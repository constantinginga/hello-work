using System;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Data.Authentication
{
    public class UserService : IUserService
    {
        private string _urlUser;
        private WebApiUtil _client;
        private string _loginArgs;
        private string _urlJobSeeker;
        private string _urlEmployer;
        private string _getUserArgs;

        public UserService()
        {
            _urlUser = "http://localhost:8082/user";
            _urlEmployer = "http://localhost:8082/employer";
            _urlJobSeeker = "http://localhost:8082/jobSeeker";

            _client = new WebApiUtil(_urlUser);
            _loginArgs = "?email=%email%&password=%password%";
            _getUserArgs = "?email=%email%";
        }

        public async Task<User> ValidateUser(string email, string password)
        {
            try
            {
                string response =
                    await _client.Get(_loginArgs.Replace("%email%", email).Replace("%password%", password));
                return JsonSerializer.Deserialize<User>(response, new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                throw;
            }
        }

        public async Task<Employer> CreateEmployer(Employer employer)
        {
            try
            {
                string employerJson = JsonSerializer.Serialize(employer, new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
                string response =
                    await _client.Post(_urlEmployer, "", employerJson);
                if (response.Equals("Email already in use") || response.Equals("Not Valid Email"))
                {
                    throw new Exception(response);
                }

                return JsonSerializer.Deserialize<Employer>(response, new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                throw;
            }
        }

        public async Task<JobSeeker> CreateJobSeeker(JobSeeker jobSeeker)
        {
            try
            {
                string seekerJson = JsonSerializer.Serialize(jobSeeker, new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
                string response =
                    await _client.Post(_urlJobSeeker, "", seekerJson);
                if (response.Equals("Email already in use") || response.Equals("Not Valid Email"))
                {
                    throw new Exception(response);
                }

                return JsonSerializer.Deserialize<JobSeeker>(response, new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                throw;
            }
        }

        public async void UpdateJobSeeker(JobSeeker seeker)
        {
            try
            {
                string seekerJson = JsonSerializer.Serialize(seeker, new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
                string response =
                    await _client.Patch(_urlJobSeeker, "", seekerJson);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                throw;
            }
        }

        public async Task<Employer> GetEmployer(string cachedUserEmail)
        {
            try
            {
                string response =
                    await _client.Get(_urlEmployer, _getUserArgs.Replace("%email%", cachedUserEmail));
                return JsonSerializer.Deserialize<Employer>(response, new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                throw;
            }
        }

        public async Task<JobSeeker> GetJobSeeker(string cachedUserEmail)
        {
            try
            {
                string response =
                    await _client.Get(_urlJobSeeker, _getUserArgs.Replace("%email%", cachedUserEmail));
                return JsonSerializer.Deserialize<JobSeeker>(response, new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                });
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                throw;
            }
        }
    }
}