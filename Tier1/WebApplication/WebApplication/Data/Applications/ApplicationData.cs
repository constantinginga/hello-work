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
        private WebApiUtil _client;
        private const string _url = "http://localhost:8082/applications";

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

    }
}