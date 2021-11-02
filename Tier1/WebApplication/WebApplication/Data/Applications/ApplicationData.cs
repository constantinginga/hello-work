using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Data.Applications
{
    public class ApplicationData : IApplicationData
    {
        private HttpClient _client;
        private const string _url = "http://localhost:8082/applications";

        public IList<Application> Applications { get; private set; }

        public ApplicationData()
        {
            _client = new();
            Applications = new List<Application>();
        }

        public async Task<Application> AddApplication(Application application)
        {
            // store locally
            Applications.Add(application);

            // store in web api
            string applicationJson = JsonSerializer.Serialize(application);
            string response = await Post("", applicationJson);
            Application applicationResponse = JsonSerializer.Deserialize<Application>(response,
                new JsonSerializerOptions()
                {
                });
            return applicationResponse;
        }

        public async Task<IList<Application>> GetApplications()
        {
            // if (!Applications.Any())
            // {
            //     string responese = await Get("");
            //     Applications = JsonSerializer.Deserialize<List<Application>>(responese, new JsonSerializerOptions()
            //     {
            //     });
            //
            //     // have to do this because of the inheritance
            //     //     JsonSerializerSettings settings = new() {TypeNameHandling = TypeNameHandling.All};
            //     //     JobListings = JsonConvert.DeserializeObject<List<JobListing>>(responseBody, settings);
            // }

            return Applications;
        }

        private async Task<string> Get(string args)
        {
            HttpResponseMessage responseMessage = await _client.GetAsync(_url + args);
            if (!responseMessage.IsSuccessStatusCode)
            {
                throw new Exception($@"Error:{responseMessage.StatusCode}, {responseMessage.ReasonPhrase}");
            }

            return await responseMessage.Content.ReadAsStringAsync();
        }

        private async Task<string> Post(string args, string body)
        {
            StringContent content = new StringContent(body, Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await _client.PostAsync(_url + args, content);
            if (!responseMessage.IsSuccessStatusCode)
            {
                throw new Exception($@"Error:{responseMessage.StatusCode}, {responseMessage.ReasonPhrase}");
            }

            return await responseMessage.Content.ReadAsStringAsync();
        }

        private async Task Delete(string args)
        {
            Console.WriteLine(_url + args);
            HttpResponseMessage responseMessage = await _client.DeleteAsync(_url + args);
            if (!responseMessage.IsSuccessStatusCode)
            {
                throw new Exception($@"Error:{responseMessage.StatusCode}, {responseMessage.ReasonPhrase}");
            }
        }
    }
}