using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Newtonsoft.Json;
using WebApplication.Models;
using JsonSerializer = System.Text.Json.JsonSerializer;

namespace WebApplication.Data.Applications
{
    public class ApplicationData : IApplicationData
    {
        private WebApiUtil _client;
        private const string _url = "http://localhost:8082/application";

        public IList<Application> Applications { get; private set; }

        public ApplicationData()
        {
            _client = new(_url);
            Applications = new List<Application>();
        }

        public async Task<Application> AddApplication(Application application)
        {
            // store locally
            Applications.Add(application);

            // store in web api
            string applicationJson = JsonSerializer.Serialize(application);
            string response = await _client.Post("", applicationJson);
            Application applicationResponse = JsonSerializer.Deserialize<Application>(response,
                new JsonSerializerOptions()
                {
                });
            return applicationResponse;
        }

        public async Task<IList<Application>> GetApplications()
        {
             if (!Applications.Any())
             {
                 string responese = await _client.Get("");

                 Applications = JsonSerializer.Deserialize<List<Application>>(responese, new JsonSerializerOptions()
                 {
                     PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                 });
                 
             }
             return Applications;
        }

    }
}