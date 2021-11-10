using System;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Data.Authentication
{
    public class UserService : IUserService
    {
        private string _url;

        public UserService()
        {
            _url = "https://localhost:8082/Login?username=%username%&password=%password%";
        }

        public async Task<User> ValidateUser(string email, string password)
        {
            try
            {
                string response = await Get(_url.Replace("%email%", email).Replace("%password%", password));

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

        private async Task<string> Get(string args)
        {
            using HttpClient client = new HttpClient();
            HttpResponseMessage responseMessage = await client.GetAsync( args);
            if (!responseMessage.IsSuccessStatusCode)
            {
                throw new Exception($@"Error: {responseMessage.StatusCode}");
            }

            return await responseMessage.Content.ReadAsStringAsync();
        }
    }
}