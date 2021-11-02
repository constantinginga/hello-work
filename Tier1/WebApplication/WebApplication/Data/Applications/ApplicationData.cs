using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Data.Applications
{
    public class ApplicationData : IApplicationData
    {
        private HttpClient client;
        private const string _url = "http://localhost:8082/applications";

        public IList<Application> Applications { get; private set; }

        public ApplicationData()
        {
            client = new();
            Applications = new List<Application>();
        }

        public async Task Create(Application application)
        {
            // store locally
            Applications.Add(application);

            // store in web api
            StringContent queryString = new(JsonConvert.SerializeObject(application), Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.PostAsync(_url, queryString);
            response.EnsureSuccessStatusCode();
        }

        public async Task<IList<Application>> GetApplications()
        {
            return Applications;
        }
    }
}
